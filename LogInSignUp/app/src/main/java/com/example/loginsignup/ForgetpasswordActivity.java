package com.example.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForgetpasswordActivity extends AppCompatActivity {
    Button changePassword, logIn;
    EditText emailInput, passwordInput, cPasswordInput;
    String email, fPassword, fcPassword, femail;
    boolean isValid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgetpassword);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        cPasswordInput = findViewById(R.id.cpasswordInput);
        changePassword = findViewById(R.id.changePassword);
        logIn = findViewById(R.id.logIn);

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                email = i.getStringExtra("email");

                fPassword = passwordInput.getText().toString();
                fcPassword = cPasswordInput.getText().toString();
                femail = emailInput.getText().toString();

                if (validateInputs()) {
                    if (email == null || email.isEmpty()) {
                        Toast.makeText(ForgetpasswordActivity.this,
                                "You Don't have Account \n" +
                                        "Please Create Account First",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if(email.equals(femail)) {
                        Toast.makeText(ForgetpasswordActivity.this,
                                "Successfully Changed Password.\n" +
                                        "Please go to the Login Page to log in",
                                Toast.LENGTH_SHORT).show();
                        }
                } else if(!email.equals(femail)){
                    emailInput.setError("Email is Entered Wrond");
                }

            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                femail = emailInput.getText().toString();
                fPassword = passwordInput.getText().toString();
                Intent i = new Intent(ForgetpasswordActivity.this,
                        LogInActivity.class);
                i.putExtra("email",femail);
                i.putExtra("password", fPassword);
                Toast.makeText(ForgetpasswordActivity.this, fPassword,
                        Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });


    }
    boolean validateInputs() {

        isValid = true;

        fPassword = passwordInput.getText().toString();
        fcPassword = cPasswordInput.getText().toString();
        femail = emailInput.getText().toString();

        if (femail.isEmpty()) {
            emailInput.setError("Email is Required");
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(femail).matches()) {
            emailInput.setError("Enter a valid email");
            isValid = false;
        }

        // Password validation
        if (fPassword.isEmpty()) {
            passwordInput.setError("Password is required");
            isValid = false;
        } else if (!fPassword.matches(".*[A-Z].*")) {
            passwordInput.setError("Password must contain at least one capital letter");
            isValid = false;
        } else if (fPassword.length() < 8) {
            passwordInput.setError("Password must have at least 8 characters");
            isValid = false;
        }

        // Confirm Password validation
        if (fcPassword.isEmpty()) {
            cPasswordInput.setError("Confirm Password is required");
            isValid = false;
        } else if (!fPassword.equals(fcPassword)) {
            cPasswordInput.setError("Passwords do not match");
            isValid = false;
        }

        return isValid;
    }
}