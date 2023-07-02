package com.trafiklab.homework.model;


import com.fasterxml.jackson.annotation.JsonProperty;

// to be deserialized from JSON

public class TrafikLabResponse {

    // add statusCode, message, executionTime, responseData
    // add getters and setters

    @JsonProperty("StatusCode")
    private int statusCode;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("ExecutionTime")
    private int executionTime;
    @JsonProperty("ResponseData")
    private TrafikLabResponseData responseData;

    public TrafikLabResponse(){
    }
    
    public TrafikLabResponse(int statusCode, String message, int executionTime, TrafikLabResponseData responseData) {
        this.statusCode = statusCode;
        this.message = message;
        this.executionTime = executionTime;
        this.responseData = responseData;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public TrafikLabResponseData getResponseData() {
        return responseData;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public void setResponseData(TrafikLabResponseData responseData) {
        this.responseData = responseData;
    }

}
