package com.example.android.musicalstructure;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {


    public SongAdapter(Activity context, ArrayList<Song> songList) {
        super(context, 0, songList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item, parent, false);
        }

        Song currentSong = getItem(position);

        TextView songName = listItemView.findViewById(R.id.song_list_titel);
        songName.setText(currentSong.getSongName());

        TextView artistAndAlbum = listItemView.findViewById(R.id.song_list_artist_album);
        artistAndAlbum.setText(currentSong.getArtistAndAlbum());

        return listItemView;
    }
}
