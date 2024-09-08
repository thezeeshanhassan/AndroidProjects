package com.example.twitter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {
    Button signUp, logIn, forgotPassword;
    EditText emailInput, passwordInput;
    String email, password, lemail, lpassword;

    Boolean status;
    Button Login;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);

        signUp = findViewById(R.id.signUp);
        logIn = findViewById(R.id.logIn);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        forgotPassword = findViewById(R.id.forgotPassword);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailInput.getText().toString().trim();
                password = passwordInput.getText().toString().trim();
                if(password.isEmpty())
                {
                    passwordInput.setError("Enter Password");
                }
                fetchUserDetails(email);
            }
        });

//        forgotPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                handleForgotPassword();
//            }
//        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LogInActivity.this,
                        SignUpActivity.class);
                startActivity(i);
            }
        });

    }


//    private void handleForgotPassword() {
//        Intent i = new Intent(LogInActivity.this, ForgetpasswordActivity.class);
//        startActivity(i);
//
//    }
    private void fetchUserDetails(final String username) {
        // Query the database to get the user details for the given username
        myRef.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // User found
                    User user = dataSnapshot.getValue(User.class);
                    Log.d("TAG", "onDataChange: User Found");
                    Log.d("FireP", user.getPassword());
                    Log.d("P", password);

                    if (user != null) {
                        // Check if the entered password matches the stored password

                        if (user.getPassword().equals(password)) {
                            // Login success
                            Toast.makeText(LogInActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();

//                             Navigate to next activity (e.g., HomeActivity)
                            Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            // Incorrect password
                            Toast.makeText(LogInActivity.this, "Incorrect password!", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    // User not found
                    Toast.makeText(LogInActivity.this, "User not found!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
}