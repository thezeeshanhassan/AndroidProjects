package com.example.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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


                if (email.isEmpty() || username.isEmpty() || password.isEmpty() ||
                        cpassword.isEmpty()) {
                    Toast.makeText(SignUpActivity.this,
                            "All fields are mandatory",
                            Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).
                        matches()) {
                    Toast.makeText(SignUpActivity.this,
                            "Please enter a valid email address",
                            Toast.LENGTH_SHORT).show();
                } else if (!password.matches(".*[A-Z]") ) {
                    Toast.makeText(SignUpActivity.this,
                            "Password must contain at least one capital letter" ,
                            Toast.LENGTH_SHORT).show();
                } else if(password.length() < 8) {
                    Toast.makeText(SignUpActivity.this,
                            "Password must have 8 Characters" ,
                            Toast.LENGTH_SHORT).show();
                } else if (!(password.equals(cpassword))) {
                    Toast.makeText(SignUpActivity.this,
                            "Passwords do not match",
                            Toast.LENGTH_SHORT).show();
                } else if(!checkboxTerms.isChecked()) {
                    Toast.makeText(SignUpActivity.this,
                            "Please Check the Check Box to Continue",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this,
                            "Successfully Sign Up. \n" +
                                    "Plese Go to the Login Page to LogIn",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        Toast.makeText(this, email + username
                + password + cpassword, Toast.LENGTH_SHORT).show();

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this,
                        LogInActivity.class);
                i.putExtra("val1", email);
                i.putExtra("val2", password);
                startActivity(i);

            }
        });
    }
}