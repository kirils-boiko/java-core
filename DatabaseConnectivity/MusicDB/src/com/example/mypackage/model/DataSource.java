package com.example.mypackage.model;

import java.sql.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    //--------------------------------------------------------
    // SQL Constants

    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" +
            "/Users/Kirill/JavaCore/DatabaseConnectivity/MusicDB/" +
            DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUMS_ID = "_id";
    public static final String COLUMN_ALBUMS_NAME = "name";
    public static final String COLUMN_ALBUMS_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";
    public static final int INDEX_ARTISTS_ID = 1;
    public static final int INDEX_ARTISTS_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONGS_ID = "_id";
    public static final String COLUMN_SONGS_TRACK = "track";
    public static final String COLUMN_SONGS_TITLE = "title";
    public static final String COLUMN_SONGS_ALBUM = "album";
    public static final int INDEX_SONGS_ID = 1;
    public static final int INDEX_SONGS_TRACK = 2;
    public static final int INDEX_SONGS_TITLE = 3;
    public static final int INDEX_SONGS_ALBUM = 4;

    public enum ORDER {
        BY_NONE,
        BY_ASC,
        BY_DESC
    }

    public enum TABLE {
        ARTISTS {
            @Override
            public String toString() {
                return "artists";
            }
        },
        ALBUMS {
            @Override
            public String toString() {
                return "albums";
            }
        },
        SONGS {
            @Override
            public String toString() {
                return "songs";
            }
        }
    }

    public static final String QUERY_ARTISTS = "SELECT * FROM " + TABLE_ARTISTS;
    public static final String QUERY_ARTISTS_SORT =
            " ORDER BY " + COLUMN_ARTISTS_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ID + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + "," +
                    TABLE_ALBUMS + "." + COLUMN_ALBUMS_ARTIST +
                    " FROM " + TABLE_ARTISTS + " INNER JOIN " + TABLE_ALBUMS +
                    " ON " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID + " = " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUMS_ARTIST + " WHERE " +
                    TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + " = '";
    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + " COLLATE NOCASE ";

    public static final String TABLE_FULL_LIST = "full_list";
    public static final String CREATE_FULL_LIST_VIEW =
            "CREATE VIEW IF NOT EXISTS " + TABLE_FULL_LIST + " AS" + " SELECT " +
                    TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + ", " +
                    TABLE_SONGS + "." + COLUMN_SONGS_TRACK + ", " +
                    TABLE_SONGS + "." + COLUMN_SONGS_TITLE +
                    " FROM " + TABLE_ARTISTS +
                    " INNER JOIN " + TABLE_ALBUMS +
                    " ON " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID + " = " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUMS_ARTIST +
                    " INNER JOIN " + TABLE_SONGS +
                    " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ID + " = " +
                    TABLE_SONGS + "." + COLUMN_SONGS_ALBUM +
                    " ORDER BY " +
                    TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + ", " +
                    TABLE_SONGS + "." + COLUMN_SONGS_TRACK;
    public static final String QUERY_SONG_IN_VIEW_FULL_LIST =
            "SELECT * FROM " + TABLE_FULL_LIST + " WHERE " + COLUMN_SONGS_TITLE +
                    " = '";

    public static final String QUERY_SONG_IN_VIEW_FULL_LIST_PREP =
            "SELECT * FROM " + TABLE_FULL_LIST + " WHERE " + COLUMN_SONGS_TITLE +
                    " = ?";

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS +
            "(" + COLUMN_ARTISTS_NAME + ") VALUES(?)";
    public static final String INSERT_ALBUM = "INSERT INTO " + TABLE_ALBUMS +
            "(" + COLUMN_ALBUMS_NAME + "," + COLUMN_ALBUMS_ARTIST + ") VALUES (?,?)";
    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS +
            "(" + COLUMN_SONGS_TRACK + "," + COLUMN_SONGS_TITLE + "," + COLUMN_SONGS_ALBUM +
            ") VALUES(?,?,?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTISTS_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTISTS_NAME + " = ?";
    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUMS_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUMS_NAME + " = ?";
    public static final String QUERY_SONG = "SELECT " + COLUMN_SONGS_ID + " FROM " +
            TABLE_SONGS + " WHERE " + COLUMN_SONGS_TRACK + " = ? AND " + COLUMN_SONGS_TITLE +
            " = ? AND " + COLUMN_SONGS_ALBUM + " = ?";

    //---------------------------------------------------------
    // Data Source fields and methods

    private Connection connection;

    private PreparedStatement querySongInView;
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;
    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;
    private PreparedStatement querySong;

    public boolean open() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            querySongInView = connection.prepareStatement(QUERY_SONG_IN_VIEW_FULL_LIST_PREP);
            insertIntoArtists = connection.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = connection.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = connection.prepareStatement(INSERT_SONGS);
            queryArtist = connection.prepareStatement(QUERY_ARTIST);
            queryAlbum = connection.prepareStatement(QUERY_ALBUM);
            querySong = connection.prepareStatement(QUERY_SONG);
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean close() {
        try {

            if (querySongInView != null) {
                querySongInView.close();
            }
            if (insertIntoArtists != null) {
                insertIntoArtists.close();
            }
            if (insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }
            if (insertIntoSongs != null) {
                insertIntoSongs.close();
            }
            if (queryArtist != null) {
                queryArtist.close();
            }
            if (queryAlbum != null) {
                queryAlbum.close();
            }
            if (connection != null) {
                connection.close();
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    public List<Artist> queryArtists(ORDER sortOrder) {
        // get a list of artists
        StringBuilder sb = new StringBuilder(QUERY_ARTISTS);
        if (sortOrder != ORDER.BY_NONE) {
            sb.append(QUERY_ARTISTS_SORT);
            if (sortOrder == ORDER.BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        try (Statement statement = connection.createStatement();
            ResultSet results =
                    statement.executeQuery(sb.toString())) {

            List<Artist> artists = new ArrayList<>();
            while(results.next()) {
                Artist artist = new Artist();
                artist.setId(results.getInt(INDEX_ARTISTS_ID));
                artist.setName(results.getString(INDEX_ARTISTS_NAME));
                artists.add(artist);
            }
            return artists;

        } catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Album> queryAlbumsByArtist(String artist, ORDER sortOrder) {
        // get the list of albums by artists
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append(artist + "'");

        if (sortOrder != ORDER.BY_NONE) {
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
            if (sortOrder == ORDER.BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        try (Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sb.toString())) {

            List<Album> albums = new ArrayList<>();
            while (results.next()) {
                Album album = new Album();
                album.setId(results.getInt(1));
                album.setName(results.getString(2));
                album.setArtistId(results.getInt(3));
                albums.add(album);
            }

            return albums;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }



    public void querySongsMetaData() {
        String sql = "SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);) {

            ResultSetMetaData meta = results.getMetaData();
            int numColumns = meta.getColumnCount();
            for (int i = 1; i <= numColumns; i++) {
                System.out.format("Column %d in the songs table: %s\n",
                        i, meta.getColumnName(i));
            }
        } catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getCount(TABLE table) {
        String sql = "SELECT COUNT(*) AS count FROM " + table.toString();

        try (Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql)) {

            return results.getInt("count");
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public boolean createViewForFullList() {
        try (Statement statement = connection.createStatement()) {

            statement.execute(CREATE_FULL_LIST_VIEW);
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<SongInfo> queryFullList() {
        StringBuilder sb = new StringBuilder("SELECT * FROM " + TABLE_FULL_LIST);

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<SongInfo> songs = new ArrayList<>();
            while (results.next()) {
                SongInfo songInfo = new SongInfo();
                songInfo.setArtistName(results.getString(1));
                songInfo.setAlbumName(results.getString(2));
                songInfo.setTrack(results.getInt(3));
                songInfo.setSongName(results.getString(4));
                songs.add(songInfo);
            }

            return songs;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<SongInfo> queryInfoBySong(String title) {

        try {
            querySongInView.setString(1, title);
            ResultSet results = querySongInView.executeQuery();

            List<SongInfo> songs = new ArrayList<>();
            while (results.next()) {
                SongInfo songInfo = new SongInfo();
                songInfo.setArtistName(results.getString(1));
                songInfo.setAlbumName(results.getString(2));
                songInfo.setTrack(results.getInt(3));
                songInfo.setSongName(results.getString(4));
                songs.add(songInfo);
            }

            return songs;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private int insertArtist(String name) throws SQLException {

        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();
        if (results.next()) {
            return results.getInt(1);
        } else {
            // insert the artist
            insertIntoArtists.setString(1, name);
            int affectedRows = insertIntoArtists.executeUpdate();
            if (affectedRows != 1) {
                throw new SQLException("problem with artist insertion");
            }

            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("cannot get the generated key for artist");
            }
        }
    }

    private int insertAlbum(String albumName, int artistId) throws SQLException {
        queryAlbum.setString(1, albumName);
        ResultSet results = queryAlbum.executeQuery();
        if (results.next()) {
            return results.getInt(1);
        }

        insertIntoAlbums.setString(1, albumName);
        insertIntoAlbums.setInt(2, artistId);
        int affectedRows = insertIntoAlbums.executeUpdate();
        if (affectedRows != 1) {
            throw new SQLException("problem with album insertion");
        }

        ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        } else {
            throw new SQLException("cannot get the generated key for album");
        }
    }

    public boolean insertSong(String artistName, String albumName, int trackNumber, String title) {
        try {
            System.out.println("Turning off the auto commit behaviour");
            connection.setAutoCommit(false);

            int artistId = insertArtist(artistName);
            int albumId = insertAlbum(albumName, artistId);
            querySong.setInt(1, trackNumber);
            querySong.setString(2, title);
            querySong.setInt(3, albumId);
            ResultSet result = querySong.executeQuery();
            if (result.next()) {
              throw new SQLException("song's already in the list");
            }

            insertIntoSongs.setInt(1, trackNumber);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3,albumId);
            int affectedRows = insertIntoSongs.executeUpdate();
            if (affectedRows == 1) {
                connection.commit();
            } else {
                throw new SQLException("failure with song insertion");
            }

            return true;

        } catch (Exception e) {
            System.out.println("insertSong exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                connection.rollback();
                return false;
            } catch (SQLException er) {
                System.out.println("error rolling back: " + er.getMessage());
                return false;
            }
        } finally {
            try {
                System.out.println("Resetting default commit behaviour");
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("failure at resetting the auto-commit behaviour: " + e.getMessage());
            }
        }
    }

}


// -----------------------------------------------------
// Other versions of methods

//    public List<Artist> queryArtists() {
//        Statement statement = null;
//        ResultSet results = null;
//
//        try {
//            statement = connection.createStatement();
//            results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS);
//
//            List<Artist> artists = new ArrayList<>();
//            while(results.next()) {
//                Artist artist = new Artist();
//                artist.setId(results.getInt(COLUMN_ARTISTS_ID));
//                artist.setName(results.getString(COLUMN_ARTISTS_NAME));
//                artists.add(artist);
//            }
//            return artists;
//
//        } catch(SQLException e) {
//            System.out.println("ERROR: " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        } finally {
//            try {
//                if (results != null) {
//                    results.close();
//                }
//            } catch(SQLException e) {
//                System.out.println("ERROR ResultSet: " + e.getMessage());
//                e.printStackTrace();
//            }
//            try {
//                if (statement != null) {
//                    statement.close();
//                }
//            } catch(SQLException e) {
//                System.out.println("ERROR Statement: " + e.getMessage());
//                e.printStackTrace();
//            }
//        }
//    }
