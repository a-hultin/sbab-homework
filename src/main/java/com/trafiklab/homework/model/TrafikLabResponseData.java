package com.trafiklab.homework.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrafikLabResponseData {

    // add version, type, result
    // result is list of JourneyPatternPointOnLine
    // add getters and setters

    @JsonProperty("Version")
    private String version;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Result")
    List<JourneyPatternPointOnLine> result;
    //private JourneyPatternPointOnLine[] result;

    public TrafikLabResponseData(){
    }

    public TrafikLabResponseData(String version, String type, List<JourneyPatternPointOnLine> result) {
        this.version = version;
        this.type = type;
        this.result = result;
    }

    public String getVersion() {
        return version;
    }

    public String getType() {
        return type;
    }

    public List<JourneyPatternPointOnLine> getResult() {
        return result;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setResult(List<JourneyPatternPointOnLine> result) {
        this.result = result;
    }

}
