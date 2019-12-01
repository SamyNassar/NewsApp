package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> newsList;
    private Context mContext;


    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView title, type, pillarName;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_textView);
            type = itemView.findViewById(R.id.type_textView);
            pillarName = itemView.findViewById(R.id.pillarName_textView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mContext = parent.getContext();

        // Inflate the custom layout
        View newsView = LayoutInflater.from(mContext).inflate(
                R.layout.news_card_item, parent, false);

        // Return a new holder instance
        return new ViewHolder(newsView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final News currentNews = newsList.get(position);



        TextView title = holder.title;
        TextView type = holder.type;
        TextView pillarName = holder.pillarName;
        LinearLayout linearLayout = holder.linearLayout;


        title.setText(currentNews.getTitle());
        type.setText(currentNews.getType());
        pillarName.setText(currentNews.getPillarName());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage;
                if (currentNews != null) {
                    webpage = Uri.parse(currentNews.getURL());
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                        mContext.startActivity(intent);
                    }
                }
            }
        });




    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


}
