// NewsFeed.java
package com.example.twitter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class NewsFeed extends Fragment {

    private RecyclerView recyclerView;
    private TweetAdapter tweetAdapter;
    private List<String> tweetList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_feed, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tweetList = new ArrayList<>();
        // Add some sample tweets
        for (int i = 0; i < 20; i++) {
            tweetList.add("Just finished developing my Twitter clone " +
                    "app in Android Studio! \uD83C\uDF89\uD83D\uDCF1 It features NewsFeed, Notifications, Messages, and Profile tabs, all static for now. " +
                    "Excited to share more soon! #AndroidDevelopment #AppDevelopment " +
                    "#TwitterClone" + i);
        }

        tweetAdapter = new TweetAdapter(tweetList);
        recyclerView.setAdapter(tweetAdapter);

        return view;
    }
}
