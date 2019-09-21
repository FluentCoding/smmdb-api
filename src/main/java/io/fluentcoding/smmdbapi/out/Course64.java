package io.fluentcoding.smmdbapi.out;

import io.fluentcoding.smmdbapi.param.CourseTheme64;
import io.fluentcoding.smmdbapi.param.Difficulty;
import io.fluentcoding.smmdbapi.util.DateUtil;
import io.fluentcoding.smmdbapi.util.ToStringBuilder;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.Date;

@Getter
public class Course64 {
    private String id, owner, title, uploader, videoid;
    private CourseTheme64 courseTheme;
    private Integer courseStars, vImg;
    private int stars;
    private Difficulty difficulty;
    private Date lastModified, uploaded;
    @Getter(AccessLevel.NONE)
    private Boolean starred;

    public Course64(String id, String owner, String title, String uploader, String videoid, int courseTheme, Integer courseStars, int stars, Integer vImg, int difficulty, long lastModified, long uploaded, Boolean starred) {
        this.id = id;
        this.owner = owner;
        this.title = title;
        this.uploader = uploader;
        this.videoid = videoid;
        this.courseTheme = CourseTheme64.values()[courseTheme];
        this.courseStars = courseStars;
        this.stars = stars;
        this.vImg = vImg;
        this.difficulty = Difficulty.values()[difficulty];
        this.lastModified = DateUtil.getDateFromUnix(lastModified);
        this.uploaded = DateUtil.getDateFromUnix(uploaded);
        this.starred = starred;
    }

    @Override
    public String toString() {
        return ToStringBuilder.getToStringMethod(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Course)) return false;
        if (obj == this) return true;

        return id.equals(((Course) obj).getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public boolean isStarred() {
        return starred;
    }
}