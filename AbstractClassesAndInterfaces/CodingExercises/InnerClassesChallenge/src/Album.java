import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private final String name;
    private final String artist;
    private final SongList songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new SongList();
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

        if (!songList.add(title, duration))  {
            System.out.println("error: song already exists in the album");
            return false;
        }

        return true;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        Song song = songList.findSong(trackNumber - 1);
        if (song == null) {
            System.out.println("error: album does not have track " + trackNumber);
            return false;
        }

        playlist.add(song);
        return true;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
        Song song = songList.findSong(songTitle);
        if (song == null) {
            System.out.println("error: album does not have track \"" + songTitle + "\"");
            return false;
        }

        playlist.add(song);
        return true;
    }



    //---------------------------------------------------------
    // Inner Class (SongList) definition

    private static class SongList {
        private final ArrayList<Song> songs = new ArrayList<>();

        private boolean add(String title, double duration) {

            if (findSong(title) != null) {
                System.out.println("error: song already exists in the album");
                return false;
            }

            songs.add(new Song(title, duration));
            return true;
        }

        private Song findSong(String title) {
            for (Song song : this.songs) {
                if (song.getTitle().equals(title))
                    return song;
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if (index < 0 || index >= songs.size()) {
                return null;
            }
            return songs.get(index);
        }

    }
}

