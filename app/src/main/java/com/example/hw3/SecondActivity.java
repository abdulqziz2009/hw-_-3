package com.example.hw3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private ImageView image_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        image_add = findViewById(R.id.img_add);







        image_add.setOnClickListener(v -> {


            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            final int SELECT_PHOTO = 1234;
            startActivityForResult(photoPickerIntent, SELECT_PHOTO);


    });
        };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 1234:
                if(resultCode == RESULT_OK){

                    Uri selectedImage = imageReturnedIntent.getData();
                    ImageView photoRegistration = (ImageView) findViewById(R.id.img_add);
                    photoRegistration.setImageURI(selectedImage);

                }
        }
    }
}
