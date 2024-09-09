package com.example.twitter;

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

public class sendMessage extends AppCompatActivity {
    Button btn;
    EditText emailInput,passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_send_message);

        btn = findViewById(R.id.sentMessage);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailInput = findViewById(R.id.emailInput);
                if(emailInput.equals("thezeeshan")) {
                    emailInput.setError("Username Not Found");
                }
                else {
                    Toast.makeText(sendMessage.this, "Message Sent Successfully",
                            Toast.LENGTH_SHORT).show();
                    emailInput.setText("");
                    passwordInput.setText("");
                }
            }
        });

    }
}