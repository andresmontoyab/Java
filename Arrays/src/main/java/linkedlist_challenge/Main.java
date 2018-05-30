package linkedlist_challenge;

import org.apache.log4j.Logger;


import java.util.*;

public class Main {


    private static final  Logger logger = Logger.getLogger(Main.class);
    private final static Scanner scanner = new Scanner(System.in);
    private static Playlist newPlayList;

    public static void main(String[] args) {

        LinkedList<Integer> intergers = new LinkedList<Integer>();

        intergers.add(8);
        intergers.add(6);
        intergers.add(80);
        intergers.add(85);

        ListIterator<Integer> listIterator = intergers.listIterator();
        listIterator.hasNext();
        listIterator.hasPrevious();
        listIterator.next();
        listIterator.previous();



        Album rockAlbum = new Album("Rock", new ArrayList<Song>());
        Song wishYou = Song.createSong("Wish You Were Here", "5:00");
        Song anotherBrick = Song.createSong("Another Brick In the Wall", "5:00");
        Song welcomeHome = Song.createSong("Welcome Home", "4:00");
        Song edgeToWorld = Song.createSong("Edge To The World", "4:00");
        Song wakeMeUp = Song.createSong("Wake me when september ends", "4:00");
        Song saintComming = Song.createSong("The Saint are Comming", "4:00");
        rockAlbum.addSong(wishYou);
        rockAlbum.addSong(welcomeHome);
        rockAlbum.addSong(anotherBrick);
        rockAlbum.addSong(edgeToWorld);
        rockAlbum.addSong(wakeMeUp);
        rockAlbum.addSong(saintComming);

        Album indieAlbum = new Album("Indie", new ArrayList<Song>());
        Song quietLittle = Song.createSong("Quiet Little Voices ", "5:00");
        Song conductor =  Song.createSong("Conductor", "5:00");
        Song thisMyHouse = Song.createSong("This is my house", "4:00");
        Song kids = Song.createSong("Kids", "4:00");
        Song youth = Song.createSong("Youth", "4:00");
        Song littleTalks = Song.createSong("Little Talks", "4:00");
        indieAlbum.addSong(quietLittle);
        indieAlbum.addSong(conductor);
        indieAlbum.addSong(thisMyHouse);
        indieAlbum.addSong(kids);
        indieAlbum.addSong(youth);
        indieAlbum.addSong(littleTalks);

        ArrayList<Album> listAlbum = new ArrayList<Album>();
        listAlbum.add(indieAlbum);
        listAlbum.add(rockAlbum);

        Album.setAlbums(listAlbum);

        newPlayList = new Playlist("Playlist", new LinkedList<Song>());
        newPlayList.addSongToPlayList("Wish You Were Here", "Rock");
        newPlayList.addSongToPlayList("This is my house", "Indie");
        newPlayList.addSongToPlayList("Wake me when september ends", "Rock");
        newPlayList.addSongToPlayList("Welcome Home", "Rock");
        newPlayList.addSongToPlayList("Youth", "Indie");


        boolean exit = false;
        boolean forward = true;
        showMenu();
        ListIterator<Song> iterator = newPlayList.getInitialIterator(); // por lo general el iterador siempre se encuentr entre dos nodos.
        while (!exit) {
            logger.info("Please enter a option");
            int choose = scanner.nextInt();
            switch (choose) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    showMenu();
                    break;
                case 2:
                    showPlayList();
                    break;
                case 3:
                    if(!forward) {
                        if(iterator.hasNext()) {
                            iterator.next();
                        }
                        forward = true;
                    }
                    if (iterator.hasNext()) {
                        logger.info(iterator.next().toString());
                    } else {
                        logger.info("You're in the final of the list");
                        forward = false;
                    }
                    break;
                case 4:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        forward = false;
                    }
                    if (iterator.hasPrevious()) {
                        logger.info(iterator.previous().toString());
                    } else {
                        logger.info("You're in the beggining of the list");
                        forward = true;
                    }
                    break;
                case 5:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            logger.info(iterator.previous().toString());
                        } else {
                            logger.info("You're in the beginning of the list");
                        }
                        forward= false;
                    } else if (!forward) {
                        if (iterator.hasNext()) {
                            logger.info(iterator.next().toString());
                        } else {
                            logger.info("You're in the final of the list.");
                        }
                        forward= true;
                    }
                    break;
            }
        }

    }


    public static void showMenu() {
        logger.info("\nWelcome to the Media Player");
        logger.info("\nPres");
        logger.info("\t  0 - Exit");
        logger.info("\t  1 - Show Menu Again");
        logger.info("\t  2 - Show Play List");
        logger.info("\t  3 - Move to the next Song");
        logger.info("\t  4 - Move to the previous Song");
        logger.info("\t  5 - Repeat Song");
    }

    public static void showPlayList() {
        newPlayList.showPlayList();
    }

}
