package com.trafiklab.homework.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrafikLabResponseDataStop {

    // add version, type, result
    // result is list of JourneyPatternPointOnLine
    // add getters and setters

    @JsonProperty("Version")
    private String version;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Result")
    List<StopPoint> result;
    //private JourneyPatternPointOnLine[] result;

    public TrafikLabResponseDataStop(){
    }

    public TrafikLabResponseDataStop(String version, String type, List<StopPoint> result) {
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

    public List<StopPoint> getResult() {
        return result;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setResult(List<StopPoint> result) {
        this.result = result;
    }

}
