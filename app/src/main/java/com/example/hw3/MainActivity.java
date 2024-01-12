package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    private Button btn_add;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btn_listener();


    }
    private void initViews(){
        btn_add = findViewById(R.id.btn_add);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new NoteAdapter(this);
        recyclerView.setAdapter(adapter);
    }
    private void getNotes(){
        if (getIntent() !=  null) {

        }
        Note note = (Note ) getIntent().getSerializableExtra("note");
        adapter.addNote(note);

    }
    private void btn_listener(){
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });
        }


        }

