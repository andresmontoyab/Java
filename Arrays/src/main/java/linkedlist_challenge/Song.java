package linkedlist_challenge;

public class Song {

    private String title;
    private String Duration;

    private Song(String title, String duration) {
        this.title = title;
        Duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    @Override
    public String toString() {
        return this.getTitle() + "and the duration is " + this.getDuration();
    }

    public void addSongToAlbum(Song song, Album album) {
        album.addSong(song);
    }

    public static Song createSong(String name, String duration) {
        return new Song(name, duration);
    }
}
