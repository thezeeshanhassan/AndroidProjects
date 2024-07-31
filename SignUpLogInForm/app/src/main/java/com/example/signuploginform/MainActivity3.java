package com.example.signuploginform;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    EditText email, password, confirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        email = findViewById(R.id.email);
        password= findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmPassword);

        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("val1");


        if(!value1.equals( email.getText().toString())) {
            Toast.makeText(MainActivity3.this,
                    "Enter Valid Email", Toast.LENGTH_SHORT).show();
        }
        if(!password.getText().toString().equals(confirmpassword.getText().toString())) {
            Toast.makeText(MainActivity3.this,
                    "Password Not Matching", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(MainActivity3.this, MainActivity2.class);
            i.putExtra("val1",password.getText().toString());
            Toast.makeText(this, "Password Successfully Changed", Toast.LENGTH_SHORT).show();
            startActivity(i);
        }
    }
}