package io.fluentcoding.smmdbapi.util;

import io.fluentcoding.smmdbapi.param.*;

import java.util.*;

public class QueryGenerator {

    public static String[] generateQuery(Map<String, Object> objects) {
        List<String> parameters = new ArrayList<String>();

        for (Map.Entry<String, Object> entry : objects.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }

            String value;

            if (entry.getValue() instanceof AutoScroll) {
                value = String.valueOf(((AutoScroll) entry.getValue()).ordinal());
            } else if (entry.getValue() instanceof CourseTheme) {
                value = String.valueOf(((CourseTheme) entry.getValue()).ordinal());
            } else if (entry.getValue() instanceof Difficulty) {
                value = String.valueOf(((Difficulty) entry.getValue()).ordinal());
            } else if (entry.getValue() instanceof Direction) {
                value = ((Direction) entry.getValue()).getParamValue();
            } else if (entry.getValue() instanceof GameStyle) {
                value = String.valueOf(((GameStyle) entry.getValue()).ordinal());
            } else if (entry.getValue() instanceof Order) {
                value = ((Order) entry.getValue()).getParamValue();
            } else if (entry.getValue() instanceof Date) {
                value = String.valueOf(((Date) entry.getValue()).getTime());
            } else if (entry.getValue() instanceof Boolean) {
                value = ((Boolean) entry.getValue()) ? "1" : "0";
            } else if (entry.getValue() instanceof String[]) {
                value = StringUtil.concatenatedString(",", (String[]) entry.getValue());
            } else {
                value = entry.getValue().toString();
            }

            parameters.add(entry.getKey() + "=" + value);
        }

        return parameters.toArray(new String[0]);
    }
}