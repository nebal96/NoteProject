package com.example.noteproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotebookAdapter extends RecyclerView.Adapter<NotebookAdapter.NotebookVh> {


    Context context ;
    List<NoteBook> noteBooks ;

    public NotebookAdapter(Context context  , List<NoteBook> notes) {
        this.context = context;
        this.noteBooks = notes;
    }

    @NonNull
    @Override
    public NotebookVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_notebook_row ,parent , false );
        return new NotebookVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotebookVh holder, int position) {
        holder.setData(noteBooks.get(position));
    }

    @Override
    public int getItemCount() {
        return noteBooks.size();
    }




    class NotebookVh extends RecyclerView.ViewHolder{

        TextView notebook_title;
        ImageView notebook_img;
        public NotebookVh(@NonNull View itemView) {
            super(itemView);
            notebook_title = itemView.findViewById(R.id.notebook_title);
            notebook_img = itemView.findViewById(R.id.book);

        }

        public void setData(final NoteBook notebook) {
            notebook_title.setText(notebook.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext() ,notebooksContent.class);
                    intent.putExtra("id",notebook.getId());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
