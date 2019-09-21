package io.fluentcoding.smmdbapi.in;

import io.fluentcoding.smmdbapi.param.*;
import io.fluentcoding.smmdbapi.util.QueryGenerator;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.*;

@Setter
public class CourseRequestParams {
    private Order order;
    private Direction dir;
    private Integer limit, start, timeFrom, timeTo, widthFrom, widthTo, widthSubFrom, widthSubTo;
    private Boolean random;
    private String[] ids;
    private Date lastModifiedFrom, lastModifiedTo, uploadedFrom, uploadedTo;
    private Difficulty difficultyFrom, difficultyTo;
    private String title, maker, uploader;
    private GameStyle gameStyle;
    private CourseTheme courseTheme, courseThemeSub;
    private AutoScroll autoScroll, autoScrollSub;

    public static CourseRequestParams createCourseRequestParams() {
        return new CourseRequestParams();
    }

    private CourseRequestParams() {}

    public String[] generateQuery() throws IllegalAccessException {
        Map<String, Object> objects = new HashMap<String, Object>();

        for (Field field : getClass().getDeclaredFields())
            objects.put(field.getName().toLowerCase(), field.get(this));

        return QueryGenerator.generateQuery(objects);
    }

    public void setTimeRange(int from, int to) {
        setTimeFrom(from);
        setTimeTo(to);
    }

    public void setWidthRange(int from, int to) {
        setWidthFrom(from);
        setWidthTo(to);
    }

    public void setLastModifiedRange(Date from, Date to) {
        setLastModifiedFrom(from);
        setLastModifiedTo(to);
    }

    public void setUploadedRange(Date from, Date to) {
        setUploadedFrom(from);
        setUploadedTo(to);
    }

    public void setDifficultyRange(Difficulty from, Difficulty to) {
        setDifficultyFrom(from);
        setDifficultyTo(to);
    }
}
