package io.fluentcoding.smmdbapi.util;

import io.fluentcoding.smmdbapi.SMMDBApi;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requester {
    private final String REQUEST_URL;

    public Requester(String REQUEST_URL) {
        this.REQUEST_URL = REQUEST_URL;
    }

    public JSONObject requestJSONObject(String request, String apiKey, String[] queryParts) throws RequestException {
        return new JSONObject(request(request, apiKey, queryParts));
    }

    public JSONArray requestJSONArray(String request, String apiKey, String[] queryParts) throws RequestException {
        return new JSONArray(request(request, apiKey, queryParts));
    }

    public String request(String request, String apiKey, String[] queryParts) throws RequestException {
        String queryString;

        if (queryParts.length == 0) {
            queryString = "";
        } else {

            StringBuilder queryStringBuilder = new StringBuilder();

            for (String queryPart : queryParts) {
                queryStringBuilder.append(queryPart);
                queryStringBuilder.append("&");
            }

            if (queryStringBuilder.length() == 0)
                queryString = "";
            else
                queryString = queryStringBuilder.substring(0, queryStringBuilder.length() - 1);

            System.out.println(queryString);
        }

        try {
            URL url = new URL(REQUEST_URL + request + (queryString == null ? "" : "?" + queryString));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            if (apiKey != null)
                con.setRequestProperty("Authorization", "APIKEY " + apiKey);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            return response.toString();
        } catch (Exception e) {
            throw new RequestException(e.getMessage());
        }
    }
}