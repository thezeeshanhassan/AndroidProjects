package com.example.sqlitespinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button button;
    Spinner spinner;
    EditText name, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);

        DatabaseHandler obj = new DatabaseHandler(this);

        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) MainActivity.this);
        loadSpinnerData();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val1 = name.getText().toString();
                String val2 = email.getText().toString();


                if(val1.equals("") || val2.equals("")) {
                    Toast.makeText(MainActivity.this, "Enter Valid Inputs",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                db.insertUser(val1,val2);

                name.setText("");
                email.setText("");

                loadSpinnerData();

            }
        });
    }

    private void loadSpinnerData() {
        DatabaseHandler dbHandler = new DatabaseHandler(this);
        List<String> data = new ArrayList<>();

        try {
            ResultSet result = dbHandler.getAllUsers();
            while(result.next()) {

            }
        } catch (SQLException e) {
            Toast.makeText(this, "Error loading data", Toast.LENGTH_SHORT).show();
        }

    }
}