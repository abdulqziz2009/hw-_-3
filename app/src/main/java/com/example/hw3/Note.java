package com.example.hw3;

import android.widget.ImageView;

public class Note {
    private String title;
    private String description;
    private String date;
    private int image;

    public Note(){

    }

    public Note(String title, String description, String date, int image) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public int getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", image=" + image +
                '}';
    }
}
