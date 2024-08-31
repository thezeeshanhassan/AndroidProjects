package com.example.sharedprefslogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {
    Button login, showInformation;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        showInformation = findViewById(R.id.showInformation);
        textView = findViewById(R.id.textView);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PrefrencesActivity.class);
                startActivity(intent);
            }
        });

        showInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaySharedPrefrences();
            }
        });
    }

    private void displaySharedPrefrences() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = pref.getString("username", "Null Username");
        String passw = pref.getString("password", "Null Password");
        boolean checkBox = pref.getBoolean("checkbox", false);
        String facedata = pref.getString("facedata", "ahfhsdjjdj");

        StringBuilder builder = new StringBuilder();
        builder.append("Username  " + username + "\n");
        builder.append("Password  " + passw + "\n");
        builder.append("Checkbox  " + checkBox + "\n");
        builder.append("FaceData  " + facedata + "\n");
        textView.setVisibility(View.VISIBLE);
        textView.setText(builder);
    }
}