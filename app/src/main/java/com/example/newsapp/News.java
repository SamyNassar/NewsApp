package com.example.newsapp;

public class News {

    private String title, type, pillarName, URL;

    public News(String title, String type, String pillarName, String URL) {
        this.title = title;
        this.type = type;
        this.pillarName = pillarName;
        this.URL = URL;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getPillarName() {
        return pillarName;
    }

    public String getURL() {
        return URL;
    }
}
