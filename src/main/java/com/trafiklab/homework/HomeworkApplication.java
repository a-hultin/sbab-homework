package com.trafiklab.homework;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.trafiklab.homework.client.TrafikLabClient;
import com.trafiklab.homework.model.JourneyPatternPointOnLine;
import com.trafiklab.homework.model.LineDirection;
import com.trafiklab.homework.model.StopPoint;

@SpringBootApplication
public class HomeworkApplication {

	private static final Logger log = LoggerFactory.getLogger(HomeworkApplication.class);

	@Autowired
	private TrafikLabClient trafikLabClient;

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}


	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {
			try{

				List<JourneyPatternPointOnLine> journeyPatternPointOnLineList = trafikLabClient.getJourneyPatternPointOnLineList();

				// remove entries with existFromDate in the future
				Iterator<JourneyPatternPointOnLine> dateIterator = journeyPatternPointOnLineList.iterator();
				while (dateIterator.hasNext()) {
					JourneyPatternPointOnLine journeyPatternPointOnLine = dateIterator.next();
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(journeyPatternPointOnLine.getExistsFromDate());
					if(date.after(java.util.Calendar.getInstance().getTime())){
						dateIterator.remove();
					}
				}
				
				// group by LineDirection(lineNumber and directionCode) and make set of journeyPatternPointNumber
				Map<LineDirection, Set<JourneyPatternPointOnLine>> lineResultMap = journeyPatternPointOnLineList.stream().collect(
					java.util.stream.Collectors.groupingBy(
						JourneyPatternPointOnLine::getLineDirection, 
						java.util.stream.Collectors.toSet()));

				// set numStops for each LineDirection
				for(Map.Entry<LineDirection, Set<JourneyPatternPointOnLine>> entry : lineResultMap.entrySet()){
					entry.getKey().setNumStops(entry.getValue().size());
				}

				// sort by numStops
				List<LineDirection> sortedList = lineResultMap.entrySet().stream()
					.sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size())
					.filter(e -> e.getValue().size() > 0)
					.map(e -> e.getKey())
					.collect(java.util.stream.Collectors.toList());


				Set<String> printedLines = new HashSet<String>();
				int numprinted = 0;

				Iterator<LineDirection> iterator = sortedList.iterator();

				// print in clear text (not log.info)
				log.info(">>> 10 lines with most stops <<<");
				// print 10 lines with most stops
				while (numprinted < 10 && iterator.hasNext()) {
					LineDirection lineDirection = iterator.next();
					if(!printedLines.contains(lineDirection.getLineNumber())){
						log.info("lineNumber: " + lineDirection.getLineNumber() + " numStops: " + lineDirection.getNumStops());
						printedLines.add(lineDirection.getLineNumber());
						numprinted++;
					}
				}
				
				List<StopPoint> stopPointList = trafikLabClient.getStopPointList();

				// make map<stopPointNumber, stopPointname> from stopPointList
				Map<String, String> stopPointMap = stopPointList.stream().collect(
					java.util.stream.Collectors.toMap(
						StopPoint::getStopPointNumber, 
						StopPoint::getStopPointName));

				// get set of JourneyPatternPointOnLine for line number with most stops
				Set<JourneyPatternPointOnLine> journeyPatternPointOnLineSet = lineResultMap.get(sortedList.get(0));

				log.info(">>> All stops for line " + sortedList.get(0).getLineNumber() + " <<<");
				for(JourneyPatternPointOnLine journeyPatternPointOnLine : journeyPatternPointOnLineSet){
					log.info("stopPointName: " + stopPointMap.get(journeyPatternPointOnLine.getJourneyPatternPointNumber()));
				}
			}
			catch(Exception e){
				log.info("Error: " + e.getMessage());
				e.printStackTrace();
			}
		};
	}
}