package io.fluentcoding.smmdbapi.param;

public enum Direction {
    ASCENDING("asc"),
    DESCENDING("desc");

    private String paramValue;

    Direction(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamValue() {
        return paramValue;
    }
}
