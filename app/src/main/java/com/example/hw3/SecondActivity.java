package com.example.hw3;

import static com.example.hw3.R.layout.activity_main2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
    private Button btnsave;
    private EditText title, desc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

    }
    private void initView(){
        btnsave = findViewById(R.id.btn_add_seacon);
        title = findViewById(R.id.title_et);
        desc = findViewById(R.id.description_et);
    }
    private void initListener(){
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteTitle = title.getText().toString();
                String noteDesc = desc.getText().toString();
                Date d = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                String noteDate = df + "/" + d;
                Note note = new Note(noteTitle,noteDate,noteDesc,0);
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                i.putExtra("note", (Serializable) note);
                startActivity(i);
            }
        });
    }

}
