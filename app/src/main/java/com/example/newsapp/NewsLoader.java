package com.example.newsapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.net.URL;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String stringUrl = NewsUtils.STRING_NEWS_URL;

    public NewsLoader(@NonNull Context context) {
        super(context);

    }

    @Override
    protected void onStartLoading() {
//        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public List<News> loadInBackground() {

        NewsUtils newsUtils = new NewsUtils();
        return newsUtils.extractNews(newsUtils.getResponse(stringUrl));

    }
}
