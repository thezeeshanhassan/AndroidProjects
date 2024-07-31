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

                Intent i = getIntent();
                email = i.getStringExtra("email");
                password = i.getStringExtra("password");


                lemail = emailInput.getText().toString();
                lpassword = passwordInput.getText().toString();

                if(email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LogInActivity.this,
                            "Please First Create Account",
                            Toast.LENGTH_SHORT).show();
                }
                else if (!email.equals(lemail) || !password.equals(lpassword)) {
                    Toast.makeText(LogInActivity.this,
                            "Email or Password is Incorrect",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LogInActivity.this,
                            "LogIn Successfully",
                            Toast.LENGTH_SHORT).show();
                    // Start the next activity
//                    Intent nextIntent = new Intent(LogInActivity.this,
//                    NextActivity.class);  // Replace NextActivity with your target activity
//                    startActivity(nextIntent);
                }
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}