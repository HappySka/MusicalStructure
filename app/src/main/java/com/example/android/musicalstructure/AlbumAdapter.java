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

public class AlbumAdapter extends ArrayAdapter<String> {


    public AlbumAdapter(Activity context, ArrayList<String> albumList) {
        super(context, 0, albumList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_grid_item, parent, false);
        }

        String currentAlbum = getItem(position);

        TextView albumName = listItemView.findViewById(R.id.album_name);
        albumName.setText(currentAlbum);

        //additionally one could import the album art for each album and set the ImageView in album_grid_item.xml with that drawable

        return listItemView;
    }
}
