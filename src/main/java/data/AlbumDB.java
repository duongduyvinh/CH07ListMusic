package data;

import model.Album;
import model.Song;

import java.util.ArrayList;
import java.util.List;

public class AlbumDB {

    // Trả về toàn bộ danh sách Album
    public static List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        
        List<Song> cine01Songs = new ArrayList<>();
        cine01Songs.add(new Song("The Final Battle", "final_battle.mp3"));
        cine01Songs.add(new Song("A Hero's Journey", "heros_journey.mp3"));
        albums.add(new Album("cine01", "Epic Soundscapes - Cinematic Scores", cine01Songs));

        List<Song> cine02Songs = new ArrayList<>();
        cine02Songs.add(new Song("Rise of the King", "rise_king.mp3"));
        cine02Songs.add(new Song("Dragon's Lair", "dragons_lair.mp3"));
        albums.add(new Album("cine02", "Orchestral Legends - Volume 2", cine02Songs));

        List<Song> lf01Songs = new ArrayList<>();
        lf01Songs.add(new Song("Late Night Syntax", "late_night_syntax.mp3"));
        lf01Songs.add(new Song("Coffee & Compilers", "coffee_compilers.mp3"));
        albums.add(new Album("lf01", "Midnight Coder - Lo-Fi Beats", lf01Songs));

        List<Song> edm01Songs = new ArrayList<>();
        edm01Songs.add(new Song("Electric Sunrise", "electric_sunrise.mp3"));
        edm01Songs.add(new Song("Jump The Beat", "jump_the_beat.mp3"));
        albums.add(new Album("edm01", "Neon Lights - The Festival Collection", edm01Songs));

        return albums;
    }

    // Tìm kiếm một Album cụ thể theo mã productCode
    public static Album getAlbum(String productCode) {
        List<Album> allAlbums = getAllAlbums();
        for (Album album : allAlbums) {
            if (album.getProductCode().equals(productCode)) {
                return album;
            }
        }
        return null;
    }
}
