package com.example.noteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splash extends AppCompatActivity {
    Button splashlogin;
    TextView splashsignup;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /// code for check if it is the first install
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        if (isFirstRun) {
            startActivity(new Intent(splash.this, tutorial1.class));
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();
////////////////////////////////////////////////////////////////////////////////////////////////////////////

        mAuth= FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if ( user !=null)
        {
            Intent intent = new Intent(splash.this , MainActivity.class);
            startActivity(intent);
        }

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
