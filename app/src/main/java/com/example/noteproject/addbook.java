package com.example.noteproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class addbook extends AppCompatActivity {
    Button addNotebookBtn;
    EditText addNotebookEt;
    TextView cancelAddNotebook;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);

        addNotebookEt = findViewById(R.id.addNotebookEt);
        findViewById(R.id.cancelAddNotebook).setOnClickListener(v -> {
            Intent intent = new Intent(addbook.this, MainActivity.class);
            startActivity(intent);
        });


        findViewById(R.id.addNotebookBtn).setOnClickListener(v -> {
            mAuth = FirebaseAuth.getInstance();
            FirebaseUser user = mAuth.getCurrentUser();
            String uid = user.getUid();
            NoteBook notebook = new NoteBook();
            notebook.setTitle(addNotebookEt.getText().toString());
            notebook.setImage("kkkk");
            String id = FirebaseDatabase.getInstance().getReference().child("User").child(uid).child("NoteBook").push().getKey();
            notebook.setId(id);
            FirebaseDatabase.getInstance().getReference().child("User").child(uid).child("Notebooks").child(id).setValue(notebook);

            Intent intent = new Intent(addbook.this, notebooks.class);
            startActivity(intent);
        });



    }
}

