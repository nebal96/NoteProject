package com.example.noteproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class notebooks extends AppCompatActivity {
//    RecyclerView notebooks_rv;
//    NotebookAdapter notebookAdapter;
//
//    List<NoteBook> notebookList = new ArrayList<>();
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebooks);}

//
//        initData();
//
//
//        notebooks_rv = findViewById(R.id.notebooks_rv);
//        notebooks_rv.setLayoutManager(new LinearLayoutManager(this));
//        notebookAdapter = new NotebookAdapter(this ,notebookList);
//        notebooks_rv.setAdapter(notebookAdapter);

    //}

    private void initData() {
//        FirebaseDatabase.getInstance().getReference().child("Note")
//                .addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                        notebookList.clear();
//                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//
//                            NoteBook notebook = snapshot.getValue(NoteBook.class);
//                            notebookList.add(notebook);
//
//                        }
//                        notebookAdapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
    }}
