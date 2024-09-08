package com.example.firebasepractice;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText editTextUserId, editTextName, editTextEmail;
    private Button buttonAddUser, buttonUpdateUser, buttonDeleteUser;
    private ListView listViewUsers;

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private List<String> usersList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");

        // Initialize UI elements
        editTextUserId = findViewById(R.id.editTextUserId);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonAddUser = findViewById(R.id.buttonAddUser);
        buttonUpdateUser = findViewById(R.id.buttonUpdateUser);
        buttonDeleteUser = findViewById(R.id.buttonDeleteUser);
        listViewUsers = findViewById(R.id.listViewUsers);

        // Initialize the list and adapter
        usersList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usersList);
        listViewUsers.setAdapter(adapter);

        // Add User
        buttonAddUser.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String userId = editTextUserId.getText().toString();
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();

                addUser(userId, name, email);
            }
        });

        // Update User
        buttonUpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = editTextUserId.getText().toString();
                String name = editTextName.getText().toString();

                updateUser(userId, name);
            }
        });

        // Delete User
        buttonDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = editTextUserId.getText().toString();

                deleteUser(userId);
            }
        });

        // Get all users and display them in the ListView
        getAllUsers();
    }

    // CRUD Operations

    private void addUser(String userId, String name, String email) {
        User user = new User(userId, name, email);
        myRef.child(userId).setValue(user);
        Log.d("TAG", "User added");
    }

    private void updateUser(String userId, String newName) {
        myRef.child(userId).child("name").setValue(newName);
        Log.d("TAG", "User updated");
    }

    private void deleteUser(String userId) {
        myRef.child(userId).removeValue();
        Log.d("TAG", "User deleted");
    }

    // Function to get all users and display them in the ListView
    private void getAllUsers() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usersList.clear(); // Clear the list to avoid duplicates
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    User user = userSnapshot.getValue(User.class);
                    if (user != null) {
                        String userInfo = "ID: " + user.userId + "\nName: " + user.name + "\nEmail: " + user.email;
                        usersList.add(userInfo);
                    }
                }
                adapter.notifyDataSetChanged(); // Update the ListView
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
}