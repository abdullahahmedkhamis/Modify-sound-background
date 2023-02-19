package com.ndroid.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMusicActivity extends AppCompatActivity {

    private List<String> myMedia = new ArrayList<>();
    private List<String> myMediaPaths = new ArrayList<>();

    private MediaPlayer myPlayer;
    private int mplayer_status = -1;
    private int selected_media = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_music);

        Button playbutton_ref = findViewById(R.id.button_play);
        Button pausebutton_ref = findViewById(R.id.button_pause);
        Button stopbutton_ref = findViewById(R.id.button_stop);

        ListView mylistview_ref = findViewById(R.id.mylistview);

        ListAdapter myMediaAdapter = new ArrayAdapter<String>(this, R.layout.listview_item, myMedia);
        mylistview_ref.setAdapter(myMediaAdapter);

        String []files = {"sound1", "sound2", "sound3"};

        myMedia.addAll( Arrays.asList(files));

        mylistview_ref.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    if(selected_media != position) {
                        if(myPlayer != null) myPlayer.release();
                        myPlayer = new MediaPlayer();


                        mplayer_status = 1;
                        myPlayer.setDataSource(getApplicationContext(), Uri.parse("android.resource://" + getPackageName() + "/raw/" + myMedia.get(position)));
                        myPlayer.prepare();
                        myPlayer.start();
                    }

                    selected_media = position;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //Events
        playbutton_ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(mplayer_status == -1) myPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myPlayer.start();
                mplayer_status = 1;
            }
        });

        pausebutton_ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPlayer.pause();
                mplayer_status = 0;
            }
        });

        stopbutton_ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPlayer.stop();
                mplayer_status = -1;
            }
        });


    }
}