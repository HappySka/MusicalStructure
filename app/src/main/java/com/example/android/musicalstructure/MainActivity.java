package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        //"Load" activity_songs into app
        if (SongCollection.songList == null)
            SongCollection.songList = new ArrayList<>();

        SongCollection.songList.add(new Song("White America", "Eminem", "The Eminem Show"));
        SongCollection.songList.add(new Song("Without Me", "Eminem", "The Eminem Show"));
        SongCollection.songList.add(new Song("Hailie's Song", "Eminem", "The Eminem Show"));
        SongCollection.songList.add(new Song("Without Me", "Eminem", "The Eminem Show"));
        SongCollection.songList.add(new Song("Wolves", "Rise Against", "Wolves"));
        SongCollection.songList.add(new Song("House on Fire", "Rise Against", "Wolves"));
        SongCollection.songList.add(new Song("Alles Neu", "Peter Fox", "Stadtaffe"));
        SongCollection.songList.add(new Song("Schüttel deinen Speck", "Peter Fox", "Stadtaffe"));
        SongCollection.songList.add(new Song("Breaking the Habit", "Linkin Park", "Meteora"));
        SongCollection.songList.add(new Song("Numb", "Linkin Park", "Meteora"));

        //Start album activity as default activity
        // Create a new intent to open the {@link NumbersActivity}
        Intent albumIntent = new Intent(MainActivity.this, AlbumsActivity.class);
        // Start the new activity
        startActivity(albumIntent);

    }
}
