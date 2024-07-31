package com.example.assignment02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    CheckBox pizza, burger, coffee;
    Button button, backToHome;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        pizza = findViewById(R.id.pizza);
        coffee = findViewById(R.id.coffee);
        burger = findViewById(R.id.burger);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        backToHome = findViewById(R.id.backToHome);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalAmount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items:\n");

                if (pizza.isChecked()) {
                    result.append("Pizza 100 Rs\n");
                    totalAmount += 100;
                }
                if (coffee.isChecked()) {
                    result.append("Coffee 50 Rs\n");
                    totalAmount += 50;
                }
                if (burger.isChecked()) {
                    result.append("Burger 120 Rs\n");
                    totalAmount += 120;
                }

                result.append("Total: ").append(totalAmount).append(" Rs");

                if(totalAmount > 0) {
                    textView.setText(result.toString());
                    textView.setVisibility(View.VISIBLE);
                }
                else {
                    textView.setText("No Item Selected");
                    textView.setVisibility(View.VISIBLE);
                }
            }
        });

        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicitIntent = new Intent(MainActivity3.this,
                        MainActivity.class);
                startActivity(explicitIntent);
            }
        });


    }
}