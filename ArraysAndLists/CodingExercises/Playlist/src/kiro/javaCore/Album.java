package kiro.javaCore;


import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if (title.isEmpty()) {
            System.out.println("error: song's title empty");
            return false;
        }

        if (duration <= 0) {
            System.out.println("error: non-positive song duration");
            return false;
        }

        if (findSong(title) != null) {
            System.out.println("error: song already exists in the album");
            return false;
        }

        songs.add(new Song(title, duration));
        return true;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if (index < 0 || index >= songs.size()) {
            System.out.println("error: album does not have track " + trackNumber);
            return false;
        }

        playlist.add(this.songs.get(index));
        return true;
    }

    public boolean addToPlaylist(String songTitle, LinkedList<Song> playlist) {
        Song song = findSong(songTitle);
        if (song == null) {
            System.out.println("error: album does not have track \"" + songTitle + "\"");
            return false;
        }

        playlist.add(song);
        return true;
    }

    private Song findSong(String title) {
        for (Song song : this.songs) {
            if (song.getTitle().equals(title))
                return song;
        }
        return null;
    }


}
