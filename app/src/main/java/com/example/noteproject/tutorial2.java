package com.example.noteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tutorial2 extends AppCompatActivity {
    TextView t2skip;
    Button t2next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial2);
        t2skip = findViewById(R.id.t2skip);
        t2next = findViewById(R.id.t2next);
        t2skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(tutorial2.this,splash.class);
                startActivity(intent);
            }
        });
        t2next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial2.this, splash.class);
                startActivity(intent);
            }
        });
    }
}
