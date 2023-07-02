package com.trafiklab.homework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPoint {
    
    @JsonProperty("StopPointNumber")
    private String stopPointNumber;
    @JsonProperty("StopPointName")
    private String stopPointName;
    @JsonProperty("StopAreaNumber")
    private String stopAreaNumber;

    public StopPoint(){
    }

    public StopPoint(String stopPointNumber, String stopPointName, String stopAreaNumber) {
        this.stopPointNumber = stopPointNumber;
        this.stopPointName = stopPointName;
        this.stopAreaNumber = stopAreaNumber;
    }

    public String getStopPointNumber() {
        return stopPointNumber;
    }

    public String getStopPointName() {
        return stopPointName;
    }

    public String getStopAreaNumber() {
        return stopAreaNumber;
    }

    public void setStopPointNumber(String stopPointNumber) {
        this.stopPointNumber = stopPointNumber;
    }

    public void setStopPointName(String stopPointName) {
        this.stopPointName = stopPointName;
    }

    public void setStopAreaNumber(String stopAreaNumber) {
        this.stopAreaNumber = stopAreaNumber;
    }

    // add equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StopPoint)) return false;

        StopPoint that = (StopPoint) o;

        if (getStopPointNumber() != null ? !getStopPointNumber().equals(that.getStopPointNumber()) : that.getStopPointNumber() != null)
            return false;
        if (getStopPointName() != null ? !getStopPointName().equals(that.getStopPointName()) : that.getStopPointName() != null)
            return false;
        return getStopAreaNumber() != null ? getStopAreaNumber().equals(that.getStopAreaNumber()) : that.getStopAreaNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getStopPointNumber() != null ? getStopPointNumber().hashCode() : 0;
        result = 31 * result + (getStopPointName() != null ? getStopPointName().hashCode() : 0);
        result = 31 * result + (getStopAreaNumber() != null ? getStopAreaNumber().hashCode() : 0);
        return result;
    }


}
