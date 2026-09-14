package model;

import java.io.Serializable;
import java.util.List;

public class Album implements Serializable {
    private String productCode;
    private String description;
    private List<Song> songs;

    public Album() {}

    public Album(String productCode, String description, List<Song> songs) {
        this.productCode = productCode;
        this.description = description;
        this.songs = songs;
    }

    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Song> getSongs() { return songs; }
    public void setSongs(List<Song> songs) { this.songs = songs; }
}
