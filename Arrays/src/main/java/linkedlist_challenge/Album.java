package linkedlist_challenge;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Album {

    private static  ArrayList<Album> albums;
    private static final Logger logger = Logger.getLogger(Album.class);
    private String name;
    private ArrayList<Song> songs;

    public Album(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public static Song searchAlbumAndSong(String songName, String albumName) {

        Album album;
        Song song;
        for (int i = 0; i < albums.size(); i++) {
            album = albums.get(i);
            if (album.getName().equals(albumName)) {
                for (int j = 0; j < album.getSongs().size(); j++) {
                    song = album.getSongs().get(j);
                    if (song.getTitle().equals(songName)) {
                        logger.info("The Song was found");
                        return song;
                    }
                    else {
//                        logger.error("Song " + songName + " does not exists in the album " + album.getName()+ ".");
                    }
                }
            } else {
//                logger.error("Album " + albumName + " does not exists.");
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public boolean addSong(Song song) {
            songs.add(song);
            return true;

    }

    public static ArrayList<Album> getAlbums() {
        return albums;
    }

    public static void setAlbums(ArrayList<Album> albums) {
        Album.albums = albums;
    }
}
