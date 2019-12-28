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
import java.util.List;

public class notebooksContent extends AppCompatActivity {
     RecyclerView booknotes_rv;
    NotesAdapter notesAdapter ;
    FirebaseAuth mAuth;
    List<Note> noteList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebooks_content);
        String notebookId = getIntent().getStringExtra("id");
        findViewById(R.id.doneBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notebooksContent.this , notebooks.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.addnoteBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notebooksContent.this , noteDetails.class);

                intent.putExtra("id", notebookId);
                startActivity(intent);
            }
        });



        mAuth= FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String uid = user.getUid();
        FirebaseDatabase.getInstance().getReference().child("User").child(uid).child("Notebooks").child(notebookId).child("notes")
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

        booknotes_rv = findViewById(R.id.booknotes_rv);
        booknotes_rv.setLayoutManager(new LinearLayoutManager(this));
        notesAdapter = new NotesAdapter(this ,noteList );
        booknotes_rv.setAdapter(notesAdapter);




    }
}
