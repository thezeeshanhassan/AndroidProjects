package com.example.twitter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.TweetViewHolder> {

    private List<Tweet> tweets;

    public TweetAdapter(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    @NonNull
    @Override
    public TweetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet_item, parent, false);
        return new TweetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TweetViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);
        holder.tweetText.setText(tweet.getContent());
        holder.username.setText(tweet.getUsername());
        holder.postTime.setText(tweet.getPostTime());
        holder.comment_count.setText(String.valueOf(tweet.getCommentCount()));
        holder.retweet_count.setText(String.valueOf(tweet.getRetweetCount()));
        holder.like_count.setText(String.valueOf(tweet.getLikeCount()));
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public static class TweetViewHolder extends RecyclerView.ViewHolder {
        TextView tweetText, username, postTime, comment_count, retweet_count, like_count;
        ImageView profileImage, tweetMedia, commentIcon, retweet_icon, like_icon, share_icon;

        public TweetViewHolder(@NonNull View itemView) {
            super(itemView);
            tweetText = itemView.findViewById(R.id.tweetContent);
            username = itemView.findViewById(R.id.username);
            postTime = itemView.findViewById(R.id.postTime);
            comment_count = itemView.findViewById(R.id.comment_count);
            retweet_count = itemView.findViewById(R.id.retweet_count);
            like_count = itemView.findViewById(R.id.like_count);
            like_icon = itemView.findViewById(R.id.like_icon);
            profileImage = itemView.findViewById(R.id.profileImage);
            tweetMedia = itemView.findViewById(R.id.tweetMedia);
            commentIcon = itemView.findViewById(R.id.commentIcon);
            share_icon = itemView.findViewById(R.id.share_icon);
        }
    }
}
