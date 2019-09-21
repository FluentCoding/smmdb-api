package io.fluentcoding.smmdbapi.param;

public enum Order {
    LAST_MODIFIED("lastmodified"),
    UPLOADED("uploaded"),
    TITLE("title"),
    STARS("stars");

    private String paramValue;

    Order(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamValue() {
        return paramValue;
    }
}
