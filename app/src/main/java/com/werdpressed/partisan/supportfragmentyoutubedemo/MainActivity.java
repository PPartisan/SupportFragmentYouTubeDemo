package com.werdpressed.partisan.supportfragmentyoutubedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class MainActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        YouTubePlayerSupportFragment frag = (YouTubePlayerSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.youtube_fragment);

        if (frag == null) {
            frag = YouTubePlayerSupportFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.youtube_fragment, frag).commit();
        }

        frag.initialize(DeveloperKey.KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {

        if (!wasRestored) {
            youTubePlayer.cueVideo("g1or7atdOrE");
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.e(MainActivity.class.getSimpleName(), "Ruh Roh!");
    }
    
}
