package io.fluentcoding.smmdbapi.util;

import java.util.Date;

public class DateUtil {

    public static Date getDateFromUnix(long time) {
        return new Date(time * 1000);
    }
}