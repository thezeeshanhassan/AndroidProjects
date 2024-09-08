package com.example.loginsignup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class FirebaseHandler {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    database = FirebaseDatabase.getInstance();
    myRef = database.getReference("User");


}
