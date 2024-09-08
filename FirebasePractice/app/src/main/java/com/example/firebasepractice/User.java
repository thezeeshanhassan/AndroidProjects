package com.example.firebasepractice;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.AbstractCollection;


public class User {
    public String userId;
    public String name;
    public String email;

    // Required default constructor for Firebase
    public User() {
    }

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    DatabaseReference myRef = null;
    public void addUser(String userId, String name, String email) {
        User user = new User(userId, name, email);
        myRef.child(userId).setValue(user);
    }
    public void updateUser(String userId, String newName) {
        myRef.child(userId).child("name").setValue(newName);
    }
    public void deleteUser(String userId) {
        myRef.child(userId).removeValue();
    }
    // Function to get all users and display them in the ListView



}

