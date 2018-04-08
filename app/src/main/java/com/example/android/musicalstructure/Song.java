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
    private String song_name;
    private String artist;
    private String album;

    public Song(String song_name, String artist, String album) {
        this.song_name = song_name;
        this.artist = artist;
        this.album = album;
    }

    public Song() {
        this.song_name = "";
        this.artist = "";
        this.album = "";
    }

    private Song(Parcel in) {
        String[] songInfo = in.createStringArray();
        this.song_name = songInfo[0];
        this.artist = songInfo[1];
        this.album = songInfo[2];
    }

    //Standard Getter methods
    //
    public String getSongName() {
        return song_name;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    //Parcelable implementation to allow to hand over a song to the "Now Playing" activity
    //
    public void writeToParcel(Parcel out, int flags) {
        String[] songInfo = new String[3];
        songInfo[0] = this.song_name;
        songInfo[1] = this.artist;
        songInfo[2] = this.album;

        out.writeStringArray(songInfo);
    }

    public int describeContents() {
        return 0;
    }

}
