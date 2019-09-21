package io.fluentcoding.smmdbapi.util;

import io.fluentcoding.smmdbapi.out.Course;
import io.fluentcoding.smmdbapi.out.Course64;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ElementParser {

    public List<Course> parseCourses(JSONArray array) {
        final List<Course> courses = new ArrayList<Course>();

        iterate(array, new Consumer<JSONObject>() {

            public void apply(JSONObject t) {
                courses.add(new Course(
                        t.getString("id"),
                        t.getString("owner"),
                        t.getString("title"),
                        t.getString("maker"),
                        t.getInt("gameStyle"),
                        t.getInt("courseTheme"),
                        t.getInt("courseThemeSub"),
                        t.getInt("time"),
                        t.getInt("autoScroll"),
                        t.getInt("autoScrollSub"),
                        t.getInt("width"),
                        t.getInt("widthSub"),
                        t.isNull("nintendoid") ? null : t.getString("nintendoid"),
                        t.isNull("videoid") ? null : t.getString("videoid"),
                        t.getInt("difficulty"),
                        t.getLong("lastmodified"),
                        t.getLong("uploaded"),
                        t.getInt("stars"),
                        t.has("starred") ? t.getBoolean("starred") : null,
                        t.has("vPrev") ? t.getInt("vPrev") : null,
                        t.has("vFull") ? t.getInt("vFull") : null
                ));
            }
        });

        return courses;
    }

    public List<Course64> parseCourses64(JSONArray array) {
        final List<Course64> courses = new ArrayList<Course64>();

        iterate(array, new Consumer<JSONObject>() {

            public void apply(JSONObject t) {
                courses.add(new Course64(
                        t.getString("id"),
                        t.getString("owner"),
                        t.getString("title"),
                        t.getString("uploader"),
                        t.isNull("videoid") ? null : t.getString("videoid"),
                        t.getInt("courseTheme"),
                        t.has("courseStars") ? t.getInt("courseStars") : null,
                        t.getInt("stars"),
                        t.has("vImg") ? t.getInt("vImg") : null,
                        t.getInt("difficulty"),
                        t.getLong("lastmodified"),
                        t.getLong("uploaded"),
                        t.has("starred") ? t.getBoolean("starred") : null
                ));
            }
        });

        return courses;
    }

    private static void iterate(JSONArray array, Consumer<JSONObject> consumer) {
        for (int i = 0; i < array.length(); i++)
            consumer.apply(array.getJSONObject(i));
    }
}
