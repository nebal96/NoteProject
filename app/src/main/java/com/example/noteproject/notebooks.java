package com.example.noteproject;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class notebooks extends AppCompatActivity {
    RecyclerView notebook_rv;
    NotebookAdapter notebookAdapter;
    static List<NoteBook> notebookList = new ArrayList<>();

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebooks);

        findViewById(R.id.backarrownotebook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notebooks.this , MainActivity.class);
                startActivity(intent);
            }
        });

        notebook_rv = findViewById(R.id.notebook_rv);
        FlexboxLayoutManager layoutManager;
        layoutManager = new FlexboxLayoutManager(notebooks.this);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setAlignItems(AlignItems.BASELINE);
        layoutManager.setJustifyContent(JustifyContent.CENTER);
        notebook_rv.setLayoutManager(layoutManager);
        notebookAdapter = new NotebookAdapter(this ,notebookList );
        notebook_rv.setAdapter(notebookAdapter);



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


    }


}
