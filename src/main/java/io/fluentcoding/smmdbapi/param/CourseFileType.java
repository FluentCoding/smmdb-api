package io.fluentcoding.smmdbapi.param;

public enum CourseFileType {
    ZIP("zip"),
    /* 3DS */ THREEDS("3ds"),
    JSON("json"),
    PROTOBUF("protobuf");

    private String paramValue;

    CourseFileType(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamValue() {
        return paramValue;
    }
}
