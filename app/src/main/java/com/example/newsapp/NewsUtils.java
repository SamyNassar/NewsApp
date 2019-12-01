package com.example.newsapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewsUtils {

    private static final String TAG = "NewsUtils";
    public static final String STRING_NEWS_URL = "https://content.guardianapis.com/search?api-key=79d4f4e8-15bf-43c3-8527-6a23c204fca0";

    private OkHttpClient client = new OkHttpClient();

    private String response;


    // Get response from HTTPS Url.
    public String getResponse(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    // Get the News from parsing JSON.
    public ArrayList<News> extractNews(String res)  {

        ArrayList<News> newsList = new ArrayList<>();

        JSONObject root;
        if (res != null){
            try {
                root = new JSONObject(res);
                JSONObject response = root.getJSONObject("response");
                JSONArray results = response.getJSONArray("results");

                for (int i = 0, j = response.length(); i < j; i++) {

                    JSONObject currentNews = results.getJSONObject(i);

                    newsList.add(new News(
                            currentNews.getString("webTitle"),
                            currentNews.getString("type"),
                            currentNews.getString("pillarName"),
                            currentNews.getString("webUrl")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        return newsList;
    }


}
