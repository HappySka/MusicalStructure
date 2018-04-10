package com.example.android.musicalstructure;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {

    public static final Parcelable.Creator<Song> CREATOR
            = new Parcelable.Creator<Song>() {
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
    private final String artistAlbumSeperator = " - ";
    private String artist;
    private String album;
    private String songName;

    public Song(String songName, String artist, String album) {
        this.songName = songName;
        this.artist = artist;
        this.album = album;
    }

    public Song() {
        this.songName = "";
        this.artist = "";
        this.album = "";
    }

    private Song(Parcel in) {
        String[] songInfo = in.createStringArray();
        this.songName = songInfo[0];
        this.artist = songInfo[1];
        this.album = songInfo[2];
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    // Getter methods
    //
    public String getSongName() {
        return songName;
    }

    //Parcelable implementation to allow to hand over a song to the "Now Playing" activity
    //replaced by usage of Singleton SongCollection

    public String getArtistAndAlbum() {
        return (artist + artistAlbumSeperator + album);
    }

    public void writeToParcel(Parcel out, int flags) {
        String[] songInfo = new String[3];
        songInfo[0] = this.songName;
        songInfo[1] = this.artist;
        songInfo[2] = this.album;

        out.writeStringArray(songInfo);
    }

    public int describeContents() {
        return 0;
    }

}
