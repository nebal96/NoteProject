package com.example.noteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class splash extends AppCompatActivity {
    Button splashlogin;
    TextView splashsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        if (isFirstRun) {
            startActivity(new Intent(splash.this, tutorial1.class));
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();
        splashlogin = findViewById(R.id.splashlogin);
        splashsignup= findViewById(R.id.splashsignup);
        splashlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splash.this,login.class);
                startActivity(intent);
            }
        });
        splashsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(splash.this,signup.class);
                startActivity(intent);
            }
        });

    }
}
