package com.example.noteproject;

import androidx.annotation.NonNull;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class noteView extends AppCompatActivity {

    EditText note , noteTitle;
    TextView lastUpdate,saveBtn;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_view);
        String noteId = getIntent().getStringExtra("id");
        String NotebookId = getIntent().getStringExtra("NotebookId");
        String desc = getIntent().getStringExtra("note");
        String title = getIntent().getStringExtra("title");
        String lastupdate = getIntent().getStringExtra("lastUpdate");
        note = findViewById(R.id.note1);
        noteTitle = findViewById(R.id.noteTitle1);
        saveBtn = findViewById(R.id.saveBtn1);
        lastUpdate = findViewById(R.id.lastUpdate1);

        note.setText(desc);
        noteTitle.setText(title);
        lastUpdate.setText(lastupdate);


        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
        String uid = user.getUid();




        findViewById(R.id.backarrownote1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Note newNote= new Note();
                newNote.setTitle(noteTitle.getText().toString());
                newNote.setNote(note.getText().toString());
                newNote.setLastUpdate(new Date().getTime());
                newNote.setId(noteId);
                newNote.setNotebookId(NotebookId);
                FirebaseDatabase.getInstance().getReference().child("User").child(uid).child("notes").child(noteId).setValue(newNote);
                FirebaseDatabase.getInstance().getReference().child("User").child(uid).child("Notebooks").child(NotebookId).child("notes").child(noteId).setValue(newNote);
                Toast.makeText(noteView.this,"note has been added successfully", Toast.LENGTH_SHORT).show();
                Intent  intent = new Intent(noteView.this ,MainActivity.class);
                startActivity(intent);


            }
        });
    }
}
