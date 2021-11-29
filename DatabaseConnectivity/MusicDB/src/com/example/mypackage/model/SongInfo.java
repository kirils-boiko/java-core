package com.example.mypackage.model;

public class SongInfo {

    private String artistName;
    private String albumName;
    private int track;
    private String songName;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void toPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("Artist: " + artistName + "\n");
        sb.append("Album: " + albumName + "\n");
        sb.append("Track: " + track + "\n");
        sb.append("Song: " + songName + "\n");
        System.out.println(sb.toString());
    }
}
