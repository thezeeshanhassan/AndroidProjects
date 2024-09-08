//
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NewsFeed extends Fragment {

    private RecyclerView recyclerView;
    private TweetAdapter tweetAdapter;
    private List<Tweet> tweetList;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_feed, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tweetList = new ArrayList<>();
        tweetAdapter = new TweetAdapter(tweetList);
        recyclerView.setAdapter(tweetAdapter);

        // Initialize Firebase Database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Tweets");

        // Add tweets to Firebase
//        addTweetsToFirebase();

        fetchTweets();

        return view;
    }

    private void fetchTweets() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tweetList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Tweet tweet = snapshot.getValue(Tweet.class);
                    if (tweet != null) {
                        tweetList.add(tweet);
                    }
                }
                tweetAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle possible errors
            }
        });
    }

    private void addTweetsToFirebase() {
        List<Tweet> tweets = new ArrayList<>();
        tweets.add(new Tweet("Just launched a new feature in our Twitter clone project! 🚀 Check it out and let us know what you think. #AndroidDev #TechUpdate", "barshanhassan", "1h", 12, 150, 75));
        tweets.add(new Tweet("Working hard on improving the UI of our Twitter clone. Stay tuned for a smoother experience! 🎨 #AndroidDev #UIUX", "ahmadhassan", "2h", 20, 300, 120));
        tweets.add(new Tweet("Integrating real-time notifications in our Twitter clone. Can't wait for you all to try it out! 🔔 #AndroidDev #Firebase", "mehdihassan", "3h", 25, 400, 180));
        tweets.add(new Tweet("Adding new media support to our Twitter clone! 📸 Expect more engaging content. #AndroidDev #AppFeatures", "hamzamehmood", "4h", 15, 250, 100));
        tweets.add(new Tweet("Optimizing performance for our Twitter clone project. Expect faster load times and smoother scrolling! ⚡ #AndroidDev #Performance", "laibamehmood", "5h", 18, 200, 85));
        tweets.add(new Tweet("Excited to announce the new like and share features in our Twitter clone. Your feedback is welcome! 👍 #AndroidDev #AppUpdate", "arreebamehmood", "6h", 30, 500, 200));
        tweets.add(new Tweet("Just fixed a major bug in our Twitter clone. Thanks for your patience and continued support! 🛠️ #AndroidDev #BugFix", "khalidhussain", "7h", 10, 120, 55));
        tweets.add(new Tweet("We’re integrating advanced search features in our Twitter clone. Finding tweets will be easier than ever! 🔍 #AndroidDev #Search", "zeeshanhassan", "8h", 22, 350, 140));

        for (Tweet tweet : tweets) {
            myRef.push().setValue(tweet);
        }
    }
}

