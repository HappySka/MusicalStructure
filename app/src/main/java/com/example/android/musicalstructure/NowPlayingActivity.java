package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);


        //Set song name, artist and album name based on current song
        TextView songName = findViewById(R.id.playing_song_name);
        songName.setText(SongCollection.nowPlaying.getSongName());

        TextView songArtist = findViewById(R.id.playing_artist);
        songArtist.setText(SongCollection.nowPlaying.getArtistAndAlbum());


        //Set onClickListener for menu bar items
        TextView songs = findViewById(R.id.menu_song_list);
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(NowPlayingActivity.this, SongsActivity.class);
                startActivity(songsIntent);
            }
        });

        TextView albums = findViewById(R.id.menu_album);
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the activity_songs category is clicked on.
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(NowPlayingActivity.this, AlbumsActivity.class);
                startActivity(albumsIntent);
            }
        });

    }
}
