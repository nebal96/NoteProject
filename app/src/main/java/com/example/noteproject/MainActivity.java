package com.example.noteproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView notes_rv;
    RecyclerView notebooks_rv;
    NotesAdapter notesAdapter ;
    NotebookAdapter notebookAdapter ;
    FirebaseAuth mAuth;
    List<Note> noteList = new ArrayList<>();
    List<NoteBook> notebookList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.signout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this ,splash.class);
                finishAffinity();
                startActivity(intent);
            }
        });
        findViewById(R.id.createNotebook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , addbook.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.showNotebooks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , notebooks.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.showNotes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , notes.class);
                startActivity(intent);
            }
        });
        mAuth= FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String uid = user.getUid();
        FirebaseDatabase.getInstance().getReference().child("User").child(uid).child("Notebooks")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        notebookList.clear();
                        for(DataSnapshot snapshot: dataSnapshot.getChildren() ){
                            NoteBook notebook = snapshot.getValue(NoteBook.class);
                            notebookList.add(notebook);
                        }
                        notebookAdapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

        notebooks_rv = findViewById(R.id.notebooks_rv);
        notebooks_rv.setLayoutManager(new LinearLayoutManager(this));
        notebookAdapter = new NotebookAdapter(this ,notebookList );
        notebooks_rv.setAdapter(notebookAdapter);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.notebooks_rv);
        recyclerView.setLayoutManager(linearLayoutManager);


        FirebaseDatabase.getInstance().getReference().child("User").child(uid).child("notes")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        noteList.clear();
                        for(DataSnapshot snapshot: dataSnapshot.getChildren() ){
                            Note note = snapshot.getValue(Note.class);
                            noteList.add(note);
                        }
                        notesAdapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

        notes_rv = findViewById(R.id.notes_rv);
        notes_rv.setLayoutManager(new LinearLayoutManager(this));
        notesAdapter = new NotesAdapter(this ,noteList );
        notes_rv.setAdapter(notesAdapter);





    }


}
