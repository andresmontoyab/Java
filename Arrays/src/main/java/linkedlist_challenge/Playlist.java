package linkedlist_challenge;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {

    private final Logger logger = Logger.getLogger(Playlist.class);

    private String name;
    private LinkedList<Song> songs;
    private boolean forward;

    public Playlist(String name, LinkedList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public boolean addSongToPlayList(String songName, String albumName) {
        Song song = Album.searchAlbumAndSong(songName, albumName);
        if (song != null) {
            songs.add(song);
            return true;
        }
        return false;
    }

    public void showPlayList() {
        Iterator<Song> i = songs.iterator();
        Song song;
        while (i.hasNext()) {
            song = i.next();
            logger.info(song.getTitle()+ " and " + song.getDuration());
        }
    }

    public ListIterator<Song> getInitialIterator() {
        return this.songs.listIterator();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }

    public void setSongs(LinkedList<Song> songs) {
        this.songs = songs;
    }
}
