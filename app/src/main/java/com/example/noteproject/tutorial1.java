package com.example.noteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tutorial1 extends AppCompatActivity {
    TextView t1skip;
    Button t1next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial1);
        t1skip = findViewById(R.id.t1skip);
        t1next = findViewById(R.id.t1next);
        t1skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial1.this, splash.class);
                tutorial1.this.startActivity(intent);
            }
        });
        t1next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial1.this, tutorial2.class);
                tutorial1.this.startActivity(intent);
            }
        });
    }
}
