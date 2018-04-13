package com.example.android.musicalstructure;

import java.util.ArrayList;
import java.util.HashSet;

public class SongCollection {

    //Singleton to keep song list and album list for all activities

    public static Song nowPlaying;
    public static ArrayList<Song> songList;
    public static ArrayList<String> albumList;
    public static String selectedAlbum;

    private SongCollection() {
    }

    /**
     * creates album list based on song list
     */
    public static void createAlbumList() {
        if (songList != null) {
            HashSet<String> albums = new HashSet<>();
            // Find unique album names in all activity_songs via HashSet
            for (Song song : songList) {
                albums.add(song.getAlbum());
            }
            // Put album names in ArrayList for clear album order
            albumList = new ArrayList<>();
            albumList.addAll(albums);
        }
    }
}
