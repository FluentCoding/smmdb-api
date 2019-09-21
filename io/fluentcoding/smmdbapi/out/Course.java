package io.fluentcoding.smmdbapi.out;

import io.fluentcoding.smmdbapi.param.AutoScroll;
import io.fluentcoding.smmdbapi.param.CourseTheme;
import io.fluentcoding.smmdbapi.param.Difficulty;
import io.fluentcoding.smmdbapi.param.GameStyle;
import io.fluentcoding.smmdbapi.util.DateUtil;
import io.fluentcoding.smmdbapi.util.ToStringBuilder;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.Date;

@Getter
public class Course {
    private String id, owner, title, maker, nintendoid, videoid;
    private AutoScroll autoScroll, autoScrollSub;
    private GameStyle gameStyle;
    private CourseTheme courseTheme, courseThemeSub;
    private Difficulty difficulty;
    private Date lastModified, uploaded;
    private int stars, time, width, widthSub;
    private Integer vPrev, vFull;
    @Getter(AccessLevel.NONE)
    private Boolean starred;

    public Course(String id, String owner, String title, String maker, int gameStyle, int courseTheme, int courseThemeSub, int time, int autoScroll, int autoScrollSub, int width, int widthSub, String nintendoid, String videoid, int difficulty, long lastModified, long uploaded, int stars, Boolean starred, Integer vPrev, Integer vFull) {
        this.id = id;
        this.owner = owner;
        this.title = title;
        this.maker = maker;
        this.gameStyle = GameStyle.values()[gameStyle];
        this.courseTheme = CourseTheme.values()[courseTheme];
        this.courseThemeSub = CourseTheme.values()[courseThemeSub];
        this.time = time;
        this.autoScroll = AutoScroll.values()[autoScroll];
        this.autoScrollSub = AutoScroll.values()[autoScrollSub];
        this.width = width;
        this.widthSub = widthSub;
        this.nintendoid = nintendoid;
        this.videoid = videoid;
        this.difficulty = Difficulty.values()[difficulty];
        this.lastModified = DateUtil.getDateFromUnix(lastModified);
        this.uploaded = DateUtil.getDateFromUnix(uploaded);
        this.stars = stars;
        this.starred = starred;
        this.vPrev = vPrev;
        this.vFull = vFull;
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