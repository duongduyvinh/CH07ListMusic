package model;

import java.io.Serializable;

public class Song implements Serializable {
    private String title;
    private String file;

    public Song() {}

    public Song(String title, String file) {
        this.title = title;
        this.file = file;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getFile() { return file; }
    public void setFile(String file) { this.file = file; }
}
