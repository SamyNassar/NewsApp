package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private NewsAdapter adapter;
    private ArrayList<News> newsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        getSupportLoaderManager().initLoader(0, null, this);


        RecyclerView rvNews = findViewById(R.id.rvNews);
        // Initialize News List.
        newsArrayList = new ArrayList<>();
        // Create the adapter.
        adapter = new NewsAdapter(newsArrayList);
        // Attach the adapter to the recyclerView to populate items
        rvNews.setAdapter(adapter);
        // Set layout manager to position the items
        rvNews.setLayoutManager(new LinearLayoutManager(this));


    }

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int id, @Nullable Bundle args) {
        return new NewsLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<News>> loader, List<News> data) {

        if (!newsArrayList.isEmpty()) {
            newsArrayList.clear();
        }
        newsArrayList.addAll(data);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<News>> loader) {
    }
}
