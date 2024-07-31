package com.example.assignment02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {

    ToggleButton toggleButton;
    TextView textView1,textView2;
    Switch switchButton;
    Button backToHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        toggleButton = findViewById(R.id.toggleButton);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        switchButton = findViewById(R.id.switchButton);
        backToHome = findViewById(R.id.backToHome);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked()) {
                    textView1.setText("Toggle is ON");
                    textView1.setVisibility(View.VISIBLE);
                } else {
                    textView1.setText("Toggle is OFF");
                    textView1.setVisibility(View.VISIBLE);
                }
            }
        });

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switchButton.isChecked()) {
                    textView2.setText("Switch is ON");
                    textView2.setVisibility(View.VISIBLE);
                } else {
                    textView2.setText("Switch is OFF");
                    textView2.setVisibility(View.VISIBLE);
                }
            }
        });

        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicitIntent = new Intent(MainActivity5.this,
                        MainActivity.class);
                startActivity(explicitIntent);
            }
        });


    }
}