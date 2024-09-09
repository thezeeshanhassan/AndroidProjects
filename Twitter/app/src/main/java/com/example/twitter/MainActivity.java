package com.example.twitter;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    Fragment fragment = null;
    FrameLayout frameLayout;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button createTweet;

    FirebaseDatabase database;
    DatabaseReference tweetsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayout);
        tabs = findViewById(R.id.tabLayout);
        createTweet = findViewById(R.id.createTweet); // Your button for creating a tweet

        // Initialize Firebase reference
        database = FirebaseDatabase.getInstance();
        tweetsRef = database.getReference("Tweets");

        // Initialize and add the NewsFeed fragment
        NewsFeed newsFeedFragment = new NewsFeed();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, newsFeedFragment);
        transaction.commit();

        // Add functionality for tabs
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new NewsFeed();
                        break;
                    case 1:
                        fragment = new Notification();
                        break;
                    case 2:
                        fragment = new Messages();
                        break;
                    case 3:
                        fragment = new Profile();
                        break;
                }

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        // Set OnClickListener to show dialog when createTweet button is clicked
        createTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreateTweetDialog();
            }
        });
    }

    // Function to show the dialog and create a new tweet
    private void showCreateTweetDialog() {
        // Create a dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.newtweet, null);
        builder.setView(dialogView);

        // Find views in the dialog
        EditText tweetMessageInput = dialogView.findViewById(R.id.content);
        Button submitTweetButton = dialogView.findViewById(R.id.submit_tweet);

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();

        // Handle tweet submission
        submitTweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tweetMessage = tweetMessageInput.getText().toString().trim();

                if (!tweetMessage.isEmpty()) {
                    // Create a new Tweet object and push to Firebase
                    Tweet newTweet = new Tweet(tweetMessage, "user", "just now", 0, 0, 0); // Adjust accordingly
                    tweetsRef.push().setValue(newTweet);

                    Toast.makeText(MainActivity.this, "Tweet added!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a tweet message.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
