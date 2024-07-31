package com.example.signuploginform;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button signup, login;
    EditText name, idNum, email, dateofbirth, password;
    TextView textView;

    int id;
    String nam, gmail, dob, pswd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        idNum = findViewById(R.id.idNum);
        email = findViewById(R.id.email);
        dateofbirth = findViewById(R.id.dateofbirth);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.getText().toString().equals("")) {
                    nam = name.getText().toString();
                }
                else if(name.getText().toString().equals("")) {

                    Toast.makeText(MainActivity.this,
                            "Enter Name", Toast.LENGTH_SHORT).show();
                }

                try {
                    id = Integer.parseInt(idNum.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,
                            "Id is Not a Number", Toast.LENGTH_SHORT).show();
                }

                if(email.getText().toString().equals("") ||
                        (!email.getText().toString().contains("@gmail.com"))) {
                    Toast.makeText(MainActivity.this,
                            "Enter Valid Email", Toast.LENGTH_SHORT).show();
                }
                else if(!email.getText().toString().equals("") &&
                        (email.getText().toString().contains("@gmail.com"))) {
                    gmail = email.getText().toString();
                }

                dob = dateofbirth.getText().toString();
                if(!isValidDate(dob)) {
                    Toast.makeText(MainActivity.this,
                            "Pleae Enter Valid Date", Toast.LENGTH_SHORT).show();
                }


                if(password.getText().toString().length() < 8) {
                    Toast.makeText(MainActivity.this,
                            "Pleae Enter 8 Digit Password",
                            Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().length() > 8) {
                    pswd = password.getText().toString();

                }

            }




            private boolean isValidDate(String date) {
                if (TextUtils.isEmpty(date)) {
                    return false;
                }

                SimpleDateFormat sdf = new SimpleDateFormat(
                        "dd/MM/yyyy", Locale.getDefault());
                sdf.setLenient(false);

                try {
                    Date parsedDate = sdf.parse(date);
                    if (parsedDate != null) {
                        // Additional check to ensure the date is not in the future
                        return !parsedDate.after(new Date());
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return false;
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(!name.getText().toString().equals("") &&
                            (!idNum.getText().toString().equals("")) &&
                            (!email.getText().toString().equals("")) &&
                            (!dateofbirth.getText().toString().equals("")) &&
                            (!password.getText().toString().equals(""))) {
                        Intent explicitIntent = new Intent(MainActivity.this,
                                MainActivity2.class);
                        explicitIntent.putExtra("mail", email.getText().toString());
                        explicitIntent.putExtra("pass", password.getText().toString());
                        Toast.makeText(MainActivity.this,
                                "Successfully Sign Up", Toast.LENGTH_SHORT).show();
                        startActivity(explicitIntent);
                    }
                    else {
                        Toast.makeText(MainActivity.this,
                                "No Field Empty",
                                Toast.LENGTH_SHORT).show();
                    }
            }
        });

    }


}