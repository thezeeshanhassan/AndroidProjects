package com.example.twitter;

import com.google.firebase.database.DatabaseReference;

import java.util.UUID;

public class Tweet {
    private String uuid;
    private String content;
    private String username;
    private String postTime;
    private int commentCount;
    private int retweetCount;
    private int likeCount;
    DatabaseReference myRef = null;

    // Empty constructor for Firestore
    public Tweet() {
    }

    // Constructor with parameters
    public Tweet(String content, String username, String postTime, int commentCount, int retweetCount, int likeCount) {
        this.uuid = UUID.randomUUID().toString();
        this.content = content;
        this.username = username;
        this.postTime = postTime;
        this.commentCount = commentCount;
        this.retweetCount = retweetCount;
        this.likeCount = likeCount;
    }

    // Getters and Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


}

