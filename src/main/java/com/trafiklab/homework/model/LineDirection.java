package com.trafiklab.homework.model;

public class LineDirection {

    private String lineNumber;
    private String directionCode;
    private int numStops;

    public LineDirection(){
    }

    public LineDirection(String lineNumber, String directionCode) {
        this.lineNumber = lineNumber;
        this.directionCode = directionCode;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public String getDirectionCode() {
        return directionCode;
    }

    public int getNumStops() {
        return numStops;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setDirectionCode(String directionCode) {
        this.directionCode = directionCode;
    }

    public void setNumStops(int numStops) {
        this.numStops = numStops;
    }

    // add equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineDirection)) return false;

        LineDirection that = (LineDirection) o;

        if (getLineNumber() != null ? !getLineNumber().equals(that.getLineNumber()) : that.getLineNumber() != null)
            return false;
        return getDirectionCode() != null ? getDirectionCode().equals(that.getDirectionCode()) : that.getDirectionCode() == null;
    }

    @Override
    public int hashCode() {
        int result = getLineNumber() != null ? getLineNumber().hashCode() : 0;
        result = 31 * result + (getDirectionCode() != null ? getDirectionCode().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LineDirection{" +
                "lineNumber='" + lineNumber + '\'' +
                ", directionCode='" + directionCode + '\'' +
                ", numStops=" + numStops +
                '}';
    }


}
