package io.fluentcoding.smmdbapi;

import io.fluentcoding.smmdbapi.in.CourseRequestParams;
import io.fluentcoding.smmdbapi.out.Course;
import io.fluentcoding.smmdbapi.out.Course64;
import io.fluentcoding.smmdbapi.out.Stats;
import io.fluentcoding.smmdbapi.param.CourseFileType;
import io.fluentcoding.smmdbapi.util.ElementParser;
import io.fluentcoding.smmdbapi.util.RequestException;
import io.fluentcoding.smmdbapi.util.Requester;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

public enum SMMDBApi {
    INSTANCE;

    private final String REQUEST_URL = "https://smmdb.ddns.net/api/";
    private Requester requester = new Requester(REQUEST_URL);
    private ElementParser parser = new ElementParser();

    public Stats getStats() throws RequestException {
        JSONObject result = requester.requestJSONObject("getstats", null, new String[0]);

        return new Stats(result.getInt("courses"), result.getInt("courses64"), result.getInt("accounts"));
    }

    public List<Course> getCourses() throws RequestException {
        return getCourses(null, null);
    }

    public List<Course> getCourses(CourseRequestParams params) throws RequestException {
        return getCourses(params, null);
    }

    public List<Course> getCourses(String apiKey) throws RequestException {
        return getCourses(null, apiKey);
    }

    public List<Course> getCourses(CourseRequestParams params, String apiKey) throws RequestException {
        JSONArray result = getCoursesJSON(params, apiKey, false);

        return parser.parseCourses(result);
    }

    public List<Course64> getCourses64() throws RequestException {
        return getCourses64(null, null);
    }

    public List<Course64> getCourses64(CourseRequestParams params) throws RequestException {
        return getCourses64(params, null);
    }

    public List<Course64> getCourses64(String apiKey) throws RequestException {
        return getCourses64(null, apiKey);
    }

    public List<Course64> getCourses64(CourseRequestParams params, String apiKey) throws RequestException {
        JSONArray result = getCoursesJSON(params, apiKey, true);

        return parser.parseCourses64(result);
    }

    public ReadableByteChannel getReadChannelOfDownloadCourse(String id, CourseFileType fileType) throws IOException {
        return Channels.newChannel(new URL(REQUEST_URL + "downloadcourse?id=" + id + "&type=" + fileType.getParamValue()).openStream());
    }

    public void downloadCourse(String id, CourseFileType fileType, String destinationPath) throws IOException {
        ReadableByteChannel readChannel = getReadChannelOfDownloadCourse(id, fileType);

        FileOutputStream fileOS = new FileOutputStream(destinationPath);
        FileChannel writeChannel = fileOS.getChannel();

        writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);
    }

    private JSONArray getCoursesJSON(CourseRequestParams params, String apiKey, boolean courses64) throws RequestException {
        if (params == null) {
            return requester.requestJSONArray("getcourses" + (courses64 ? "64" : ""), apiKey, new String[0]);
        } else {
            try {
                return requester.requestJSONArray("getcourses" + (courses64 ? "64" : ""), apiKey, params.generateQuery());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
