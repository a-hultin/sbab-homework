package com.trafiklab.homework.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class JourneyPatternPointOnLine {
    // add lineNumber, directionCode, journeyPatternPointNumber, lastModifiedUtcDateTime
    // add getters and setters

    @JsonProperty("LineNumber")
    private String lineNumber;
    @JsonProperty("DirectionCode")
    private String directionCode;
    @JsonProperty("JourneyPatternPointNumber")
    private String journeyPatternPointNumber;
    @JsonProperty("LastModifiedUtcDateTime")
    private String lastModifiedUtcDateTime;
    @JsonProperty("ExistsFromDate")
    private String existsFromDate;

    public JourneyPatternPointOnLine(){
    }

    public JourneyPatternPointOnLine(String lineNumber, String directionCode, String journeyPatternPointNumber, String lastModifiedUtcDateTime, String existsFromDate) {
        this.lineNumber = lineNumber;
        this.directionCode = directionCode;
        this.journeyPatternPointNumber = journeyPatternPointNumber;
        this.lastModifiedUtcDateTime = lastModifiedUtcDateTime;
        this.existsFromDate = existsFromDate;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public String getDirectionCode() {
        return directionCode;
    }

    public String getJourneyPatternPointNumber() {
        return journeyPatternPointNumber;
    }

    public String getLastModifiedUtcDateTime() {
        return lastModifiedUtcDateTime;
    }

    public String getExistsFromDate() {
        return existsFromDate;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setDirectionCode(String directionCode) {
        this.directionCode = directionCode;
    }

    public void setJourneyPatternPointNumber(String journeyPatternPointNumber) {
        this.journeyPatternPointNumber = journeyPatternPointNumber;
    }

    public void setLastModifiedUtcDateTime(String lastModifiedUtcDateTime) {
        this.lastModifiedUtcDateTime = lastModifiedUtcDateTime;
    }

    public void setExistsFromDate(String existsFromDate) {
        this.existsFromDate = existsFromDate;
    }

    public LineDirection getLineDirection(){
        return new LineDirection(lineNumber, directionCode);
    }

    @Override
    public String toString() {
        return "JourneyPatternPointOnLine{" +
                "lineNumber='" + lineNumber + '\'' +
                ", directionCode='" + directionCode + '\'' +
                ", journeyPatternPointNumber='" + journeyPatternPointNumber + '\'' +
                ", lastModifiedUtcDateTime='" + lastModifiedUtcDateTime + '\'' +
                ", existsFromDate='" + existsFromDate + '\'' +
                '}';
    }    
}
