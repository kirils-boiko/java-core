package com.example.mypackage;

import com.example.mypackage.model.*;
import jdk.swing.interop.SwingInterOpUtils;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open dataSource");
            return;
        }

        System.out.println("---------------------------------------------------");
        List<Artist> artists = dataSource.queryArtists(DataSource.ORDER.BY_DESC);
        if (artists.isEmpty()) {
            System.out.println("No artists!");
            return;
        }
        System.out.println("ID  |Name");
        System.out.println("---------");
        for (Artist artist : artists) {
            System.out.printf("%-4d|%-30s\n", artist.getId(), artist.getName());
        }

        System.out.println("---------------------------------------------------");
        List<Album> albumsByArtist = dataSource.queryAlbumsByArtist("Pink Floyd", DataSource.ORDER.BY_ASC);
        if (albumsByArtist.isEmpty()) {
            System.out.println("No albums");
            return;
        }

        System.out.println("ID|Album Name");
        System.out.println("-------------");
        for (Album album : albumsByArtist) {
            System.out.printf("%-4d|%-30s\n", album.getId(), album.getName());
        }

        System.out.println("---------------------------------------------------");
        List<SongInfo> songInfos = dataSource.queryInfoBySong("Go Your Own Way");

        if (songInfos.isEmpty()) {
            System.out.println("No songs by that title");
            return;
        }
        for(SongInfo songInfo : songInfos) {
            songInfo.toPrint();
        }

        System.out.println("---------------------------------------------------");
        dataSource.querySongsMetaData();

        System.out.println("---------------------------------------------------");
        System.out.println("songs count: " +
                dataSource.getCount(DataSource.TABLE.SONGS));
        System.out.println("albums count: " +
                dataSource.getCount(DataSource.TABLE.ALBUMS));
        System.out.println("artists count: " +
                dataSource.getCount(DataSource.TABLE.ARTISTS));

        System.out.println(DataSource.TABLE_FULL_LIST);
        System.out.println(DataSource.CREATE_FULL_LIST_VIEW);



        //---------------------------------------------
        // Querying the full_list VIEW
        List<SongInfo> fullList= dataSource.queryFullList();

        System.out.println("---------------------------------------------------");
        if (fullList.isEmpty()) {
            System.out.println("No records in full list");
            return;
        }
        System.out.println();
        for(SongInfo songInfo : fullList) {
            songInfo.toPrint();
        }


        System.out.println("---------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title:");
        String title = scanner.nextLine();
        List<SongInfo> songsInfo = dataSource.queryInfoBySong(title);

        if (songsInfo.isEmpty()) {
            System.out.println("No songs with that title");
            return;
        }
        System.out.println("ID|Album Name");
        System.out.println("-------------");
        for (SongInfo songInfo : songsInfo) {
            songInfo.toPrint();
        }

        System.out.println("---------------------------------------------------");
        System.out.println(dataSource.insertSong("Nirvana", "Nevermind", 8,
                "Drain You"));
        System.out.println(dataSource.insertSong("Nirvana", "Nevermind", 9,
                "Lounge Act"));
        System.out.println(dataSource.insertSong("Nirvana", "In Utero", 4,
                "Rape Me"));
        System.out.println(dataSource.insertSong("Nirvana", "In Utero", 4,
                "Rape Me"));
        System.out.println(dataSource.insertSong("Alice In Chains", "Dirt", 13,
                "Would?"));



        dataSource.close();
    }

}
