package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        //fill the ListView with all songs
        SongAdapter itemsAdapter = new SongAdapter(this, SongCollection.songList);
        final ListView listView = findViewById(R.id.song_list);
        listView.setAdapter(itemsAdapter);

        //Set onClickListener for the ListView
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song item = (Song) listView.getItemAtPosition(position);
                SongCollection.nowPlaying = item;
                Intent playingIntent = new Intent(SongsActivity.this, NowPlayingActivity.class);
                startActivity(playingIntent);
            }
        });


        //Set onClickListener for menu bar items

        // Find the View that shows the albums
        TextView albums = findViewById(R.id.menu_album);
        // Set a click listener on that View
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the activity_songs category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SongsActivity}
                Intent albumsIntent = new Intent(SongsActivity.this, AlbumsActivity.class);
                // Start the new activity
                startActivity(albumsIntent);
            }
        });

        //If a song was already selected, also allow to switch to the Now Playing activity
        if (SongCollection.nowPlaying != null) {
            TextView nowPlaying = findViewById(R.id.menu_playing);
            nowPlaying.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent playingIntent = new Intent(SongsActivity.this, NowPlayingActivity.class);
                    startActivity(playingIntent);
                }
            });
        }


    }
}
