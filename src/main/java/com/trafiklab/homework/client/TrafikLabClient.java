package com.trafiklab.homework.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import com.trafiklab.homework.model.JourneyPatternPointOnLine;
import com.trafiklab.homework.model.StopPoint;
import com.trafiklab.homework.model.TrafikLabResponse;
import com.trafiklab.homework.model.TrafikLabResponseStop;



@Component
public class TrafikLabClient {

    @Value("${TRAFIKLAB_APIKEY}")
    private String apiKey;

    @Value("${TRAFIKLAB_BASEURL}")
    private String baseUrl;

    // get logger
    private static final Logger log = LoggerFactory.getLogger(TrafikLabClient.class);


    public TrafikLabClient() {
    }

    public List<JourneyPatternPointOnLine> getJourneyPatternPointOnLineList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "?key=" + apiKey + "&model=jour&DefaultTransportModeCode=BUS";
        TrafikLabResponse response = restTemplate.getForObject(url, TrafikLabResponse.class);
        // if response statuscode != 0 then exit
        if (response.getStatusCode() != 0) {
            log.error("Error: " + response.getMessage());
            log.error("Exiting...");
            System.exit(1);
        }
        return response.getResponseData().getResult();
    }

    public List<StopPoint> getStopPointList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "?key=" + apiKey + "&model=stop&DefaultTransportModeCode=BUS";
        TrafikLabResponseStop response = restTemplate.getForObject(url, TrafikLabResponseStop.class);
        // if response statuscode != 0 then exit
        if (response.getStatusCode() != 0) {
            log.error("Error: " + response.getMessage());
            log.error("Exiting...");
            System.exit(1);
        }
        return response.getResponseData().getResult();
    }
    
}
