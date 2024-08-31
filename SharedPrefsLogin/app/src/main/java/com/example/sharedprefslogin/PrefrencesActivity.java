package com.example.sharedprefslogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class PrefrencesActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private CheckBox saveCredentialsCheckBox;
    private Button logInButton;
    private Button captureButton,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefrences);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        saveCredentialsCheckBox = findViewById(R.id.saveCredentialsCheckBox);
        logInButton = findViewById(R.id.logIn);
        captureButton = findViewById(R.id.captureButton);


        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (saveCredentialsCheckBox.isChecked()) {
                    saveLoginDetails();
                }
                // Proceed with login (Add your login logic here)
                Toast.makeText(PrefrencesActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            }
        });

        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });


    }

    private void saveLoginDetails() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("username", username);
        editor.putString("password", password);
        editor.putBoolean("checkbox", saveCredentialsCheckBox.isChecked());

        editor.apply();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            if (imageBitmap != null) {
                storeFaceData(imageBitmap);
            }
        }
    }

    private void storeFaceData(Bitmap imageBitmap) {
        // Convert bitmap to base64 string
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        String encodedImage = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);

        // Store the image in SharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("FaceAuthPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("faceData", encodedImage);
        editor.apply();

        Toast.makeText(this, "Face data stored successfully", Toast.LENGTH_SHORT).show();
    }
}
