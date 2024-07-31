package com.example.assignment02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    Button backToHome, showSelected;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        backToHome = findViewById(R.id.backToHome);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        textView = findViewById(R.id.textView);
        showSelected = findViewById(R.id.showSelected);

        showSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder result = new StringBuilder();
                if(radioButton1.isChecked()) {
                    result.append("From Single Radio Button \n" + "Male ");
                }
                if(radioButton2.isChecked()) {
                    if(!radioButton1.isChecked()) {
                        result.append("From Single Radio Button \n");
                    }
                    result.append("Female \n");
                }
                if(radioButton3.isChecked()) {
                    result.append("From Group Radio Button \n" + "Male ");
                }
                if(radioButton4.isChecked()) {
                    if(!radioButton3.isChecked()) {
                        result.append("From Group Radio Button \n");
                    }
                    result.append("Female \n");
                }

                textView.setText(result);
                textView.setVisibility(View.VISIBLE);
            }
        });

        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicitIntent = new Intent(MainActivity4.this,
                        MainActivity.class);
                startActivity(explicitIntent);
            }
        });

    }
}