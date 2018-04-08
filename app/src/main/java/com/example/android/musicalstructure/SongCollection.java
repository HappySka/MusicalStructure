package com.example.android.musicalstructure;

import java.util.ArrayList;
import java.util.HashSet;

public class SongCollection {

    public static Song nowPlaying;
    public static ArrayList<Song> songList;
    public static HashSet<String> albumList;

    private SongCollection() {
    }

    // Find unique album names in all songs via HashSet
    public static void createAlbumList() {
        if (songList != null) {
            albumList = new HashSet<>();
            for (Song song : songList) {
                albumList.add(song.getAlbum());
            }
        }
    }
}
