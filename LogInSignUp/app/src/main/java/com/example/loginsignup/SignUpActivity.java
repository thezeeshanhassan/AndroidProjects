package com.example.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {
    Button signUp, logIn;
    String email, username, password, cpassword;
    EditText emailInput, usernameInput, passwordInput, cpasswordInput;
    CheckBox checkboxTerms;

    DatabaseHandler db = new DatabaseHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        signUp = findViewById(R.id.signUp);
        logIn = findViewById(R.id.logIn);
        emailInput = findViewById(R.id.emailInput);
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        cpasswordInput = findViewById(R.id.cpasswordInput);
        checkboxTerms = findViewById(R.id.checkboxTerms);



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = emailInput.getText().toString();
                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();
                cpassword = cpasswordInput.getText().toString();

                validateInputs();

                User user = new User(username, email, password);
                try {
                    db.insertUser(user);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent i = new Intent(SignUpActivity.this,
                            LogInActivity.class);
                    startActivity(i);
            }
        });
    }

    private void validateInputs() {
        String email = emailInput.getText().toString().trim();
        String username = usernameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();
        String cpassword = cpasswordInput.getText().toString().trim();

        boolean isValid = true;

        if (email.isEmpty()) {
            emailInput.setError("Email is required");
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError("Please enter a valid email");
            isValid = false;
        }

        if (username.isEmpty()) {
            usernameInput.setError("Username is required");
            isValid = false;
        }

        if (password.isEmpty()) {
            passwordInput.setError("Password is required");
            isValid = false;
        } else if (!password.matches(".*[A-Z].*")) {
            passwordInput.setError("Password must contain at least one capital letter");
            isValid = false;
        } else if (password.length() < 8) {
            passwordInput.setError("Password must have at least 8 characters");
            isValid = false;
        }

        if (cpassword.isEmpty()) {
            cpasswordInput.setError("Confirm Password is required");
            isValid = false;
        } else if (!password.equals(cpassword)) {
            cpasswordInput.setError("Passwords do not match");
            isValid = false;
        }

        if (!checkboxTerms.isChecked()) {
            checkboxTerms.setError("Please accept the terms and conditions");
            isValid = false;
        } else {
            checkboxTerms.setError(null); // Clear the error
        }

        if (isValid) {
            Toast.makeText(SignUpActivity.this, "Successfully Signed Up.\nPlease go to the Login Page to log in", Toast.LENGTH_SHORT).show();
            // Proceed with the sign-up process
        }
    }
}