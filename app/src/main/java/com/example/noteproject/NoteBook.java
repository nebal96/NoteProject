package com.example.noteproject;

public class NoteBook {
    String title;
    String image;
    String id;
    public NoteBook(){

    }
    public NoteBook(String id, String title, String image) {

        this.title = title;
        this.image = image;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
