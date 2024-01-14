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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private List<Note> list = new ArrayList<>();

    public NoteAdapter(Context context){
        this.inflater = LayoutInflater.from(context);
    }

    public void chagenNote(Note note , int position){
        list.set(position,note);
        notifyItemChanged(position);
    }
    public List <Note> getList(){return  list;}
    public void  sortNotes(int position){
        Collections.sort(list, new Comparator<Note>() {
            @Override
            public int compare(Note o1, Note o2) {
                return o1.getTitle().compareToIgnoreCase(o2.getTitle());
            }
        });
        notifyDataSetChanged(position);
    }

    private void notifyDataSetChanged(int position) {
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
            holder.notify();
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
