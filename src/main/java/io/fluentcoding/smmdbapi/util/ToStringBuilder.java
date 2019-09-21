package io.fluentcoding.smmdbapi.util;

import java.lang.reflect.Field;

public class ToStringBuilder {

    public static String getToStringMethod(Object object) {
        Class<?> objectClass = object.getClass();

        StringBuilder builder = new StringBuilder(objectClass.getSimpleName());

        builder.append(" {");

        for (Field f : objectClass.getDeclaredFields()) {
            f.setAccessible(true);

            builder.append("\n\t");
            builder.append(f.getName());
            builder.append(" = ");
            try {
                builder.append(f.get(object));
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        builder.append("\n}");

        return builder.toString();
    }
}
