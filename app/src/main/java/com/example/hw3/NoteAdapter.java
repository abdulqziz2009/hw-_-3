package com.example.hw3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private List<Note> list = new ArrayList<>();

    public NoteAdapter(Context context){
        this.inflater = LayoutInflater.from(context);
    }

    public void addNote(Note note){
        list.add(note);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item,parent,false);
        return new NoteviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (list.get(position) != null) {
            holder.onBind(list.get(position));
        }


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoteviewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title,desc,date;

        public NoteviewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_add);
            title = itemView.findViewById(R.id.title_et);
            desc = itemView.findViewById(R.id.description_et);
            date = itemView.findViewById(R.id.date_date);

        }

        public void onBind(Note note){

            title.setText(note.getTitle());
            desc.setText(note.getDescription());
            date.setText(note.getDate());

        }

    }
}
