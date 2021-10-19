package kiro.javaCore;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album DI01 = new Album("Disco Inferno 01", "I Hate Models");
        DI01.addSong("Two Steps from Heaven", 567);
        DI01.addSong("Sad Groove", 496);
        DI01.addSong("Lazy in Hell", 468);
        albums.add(DI01);

        Album WM = new Album("Warehouse Memories", "I Hate Models");
        WM.addSong("Warehouse Memories", 446);
        WM.addSong("Daydream", 463);
        WM.addSong("Shades of Night", 374);
        albums.add(WM);

        LinkedList<Song> playlist = new LinkedList<Song>();
        DI01.addToPlaylist(2, playlist);
        DI01.addToPlaylist("Lazy in Hell", playlist);
        DI01.addToPlaylist("Two Sits from Heaven", playlist);
        WM.addToPlaylist("Warehouse Memories", playlist);
        WM.addToPlaylist(2, playlist);

        play(playlist);


    }

    private static void play(LinkedList<Song> playlist) {
        ListIterator<Song> listIterator = playlist.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        if (playlist.isEmpty()) {
            System.out.println("No songs in playlist");
            scanner.close();
            return;
        }
        printOptions();

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    printOptions();
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext())
                            listIterator.next();
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().getTitle());
                    } else {
                        System.out.println("End of playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious())
                            listIterator.previous();
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("Beginning of playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Replaying " + listIterator.previous().getTitle());
                            goingForward = false;
                        } else {
                            System.out.println("No song's playing");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Replaying " + listIterator.next().getTitle());
                            goingForward = true;
                        } else {
                            System.out.println("No song's playing");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Playlist:");
                    for (int i = 0; i < playlist.size(); i++) {
                        System.out.println(String.format("%d. %s",
                                (i+1), playlist.get(i).toString()));
                    }
                    break;
                case 5:
                    System.out.println("Removing the current song from playlist...");
                    listIterator.remove();
                    break;
                case 6:
                    System.out.println("Quitting the music player...");
                    quit = true;
                    break;
                default:
                    System.out.println("error: options 0-6 are available");
                    break;

            }
        }





        scanner.close();
    }

    private static void printOptions() {
        System.out.println("Press:");
        System.out.println("\t0 - to print options.");
        System.out.println("\t1 - to skip forward.");
        System.out.println("\t2 - to skip backwards.");
        System.out.println("\t3 - to replay the current song.");
        System.out.println("\t4 - to list the songs in the playlist.");
        System.out.println("\t5 - to remove the current song from playlist.");
        System.out.println("\t6 - to quit the music player.");
    }

}
