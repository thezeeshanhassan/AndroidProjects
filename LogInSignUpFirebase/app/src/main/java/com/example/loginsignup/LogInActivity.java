package com.example.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogInActivity extends AppCompatActivity {
    Button signUp, logIn, forgotPassword;
    EditText emailInput, passwordInput;
    String email, password, lemail, lpassword;


    DatabaseHandler db = new DatabaseHandler(this);



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

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateInputs();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleForgotPassword();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LogInActivity.this,
                        SignUpActivity.class);
                startActivity(i);
            }
        });

    }

    private void validateInputs() {
        // Get the entered email and password from the input fields
        lemail = emailInput.getText().toString().trim();
        lpassword = passwordInput.getText().toString().trim();

        // Check if the input fields are empty
        if (lemail.isEmpty()) {
            emailInput.setError("Email is Required");
            return;
        }
        if (lpassword.isEmpty()) {
            passwordInput.setError("Password is Required");
            return;
        }

        // Get the user details from the database based on the entered email
        User user = db.getUserDetails(lemail);

        // Check if the email exists in the database
        if (user == null) {
            emailInput.setError("No account found with this email");
            Toast.makeText(LogInActivity.this,
                    "Please Create an Account", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if the password matches the one in the database
        if (!user.getPassword().equals(lpassword)) {
            passwordInput.setError("Entered Password is Wrong");
        } else {
            Toast.makeText(LogInActivity.this,
                    "LogIn Successfully", Toast.LENGTH_SHORT).show();
            // Proceed with the login process, such as navigating to the next activity
        }
    }


    private void handleForgotPassword() {
        Intent i = new Intent(LogInActivity.this, ForgetpasswordActivity.class);
        startActivity(i);

    }
}