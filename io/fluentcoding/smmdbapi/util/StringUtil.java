package io.fluentcoding.smmdbapi.util;

public class StringUtil {

    public static String concatenatedString(CharSequence delimiter, CharSequence... inputs) {
        StringBuilder temp = new StringBuilder();

        for (CharSequence input : inputs) {
            temp.append(input);
            temp.append(delimiter);
        }

        return temp.substring(0, -2);
    }
}
