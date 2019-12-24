package com.example.noteproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteVh> {


    Context context ;
    List<Note> notes ;

    public NotesAdapter(Context context  , List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_note_row ,parent , false );
        return new NoteVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteVh holder, int position) {
        holder.setData(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }




    class NoteVh extends RecyclerView.ViewHolder{

        TextView note_title , note_desc  , note_date;
        public NoteVh(@NonNull View itemView) {
            super(itemView);
            note_title = itemView.findViewById(R.id.note_title);
            note_desc = itemView.findViewById(R.id.note_desc);
            note_date = itemView.findViewById(R.id.note_date);

        }

        public void setData(final Note note) {
            note_title.setText(note.getTitle());
            note_desc.setText(note.getNote());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, note.getTitle(), Toast.LENGTH_SHORT).show();
//                    Intent  intent = new Intent(itemView.getContext() ,NoteActivity.class);
//                    intent.putExtra("id",note.getId());
//                    intent.putExtra("title",note.getTitle());
//                    intent.putExtra("note",note.getNote());
//                    intent.putExtra("date",note.getDate());
//                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
