package com.example.noteproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class noteDetails extends AppCompatActivity {

    EditText note , noteTitle;
    TextView lastUpdate,saveBtn;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);
        String notebookId = getIntent().getStringExtra("id");

        note = findViewById(R.id.note);
        noteTitle = findViewById(R.id.noteTitle);
        saveBtn = findViewById(R.id.saveBtn);
        lastUpdate = findViewById(R.id.lastUpdate);

        findViewById(R.id.backarrownote).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser user = mAuth.getCurrentUser();
                String uid = user.getUid();
                Note newNote= new Note();
                newNote.setTitle(noteTitle.getText().toString());
                newNote.setNotebookId(notebookId);
                newNote.setNote(note.getText().toString());
                newNote.setLastUpdate(new Date().getTime());
                String noteId=FirebaseDatabase.getInstance().getReference().child("User").child(uid).child("NoteBooks").child(notebookId).child("notes").push().getKey();
                newNote.setId(noteId);
                FirebaseDatabase.getInstance().getReference().child("User").child(uid).child("notes").child(noteId).setValue(newNote);

                FirebaseDatabase.getInstance().getReference().child("User").child(uid).child("Notebooks").child(notebookId).child("notes").child(noteId).setValue(newNote);
                Toast.makeText(noteDetails.this,"note has been added successfully", Toast.LENGTH_SHORT).show();
                Intent  intent = new Intent(noteDetails.this ,MainActivity.class);
                startActivity(intent);


            }
        });
    }
}
