package com.example.signuploginform;

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

public class MainActivity2 extends AppCompatActivity {
    EditText email, password;
    Button signup, login, forgot;
    String gmail, paswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);
        forgot = findViewById(R.id.forgot);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicitIntetn = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(explicitIntetn);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("") || (!email.getText().toString().contains("@gmail.com"))) {
                    Toast.makeText(MainActivity2.this,
                            "Enter Valid Email", Toast.LENGTH_SHORT).show();
                }
                else if(!email.getText().toString().equals("")) {
                    gmail = email.getText().toString();
                }
                if(password.getText().toString().length() < 8) {
                    Toast.makeText(MainActivity2.this,
                            "Pleae Enter 8 Digit Password", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().length() > 8) {
                    paswd = password.getText().toString();

                }

                Bundle extras = getIntent().getExtras();
                String value1 = extras.getString("mail");
                String value2 = extras.getString("pass");

                if(value1.equals( email.getText().toString()) &&
                        value2.equals(password.getText().toString())) {
                    Toast.makeText(MainActivity2.this,
                            "Loged In Successfully", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(MainActivity2.this,
                            "Pleae Correct Password or Email", Toast.LENGTH_SHORT).show();
                }

            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                i.putExtra("email",email.getText().toString());
                startActivity(i);
            }
        });

    }
}