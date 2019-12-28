package com.example.noteproject;

public class Note {

        String id ;
        String title ;
        String note;
    long lastUpdate;
    String notebookId;

    public Note(String id, String title, String note,long lastUpdate,String notebookId) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.lastUpdate = lastUpdate;
        this.notebookId = notebookId;
    }

    public Note() {

    }

    public String getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(String notebookId) {
        this.notebookId = notebookId;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
