package com.ndroid.musicplayerapp.sounds;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ndroid.musicplayerapp.R;

public class MainActivity1 extends AppCompatActivity implements View.OnClickListener {

    // views declartion
    TextView tvTime1, tvDuration1;
    SeekBar seekBarTime1, seekBarVolume1;
    Button btnPlay1;

    MediaPlayer musicPlayer1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main1);

        // hide the actionbar
        getSupportActionBar().hide();

        tvTime1 = findViewById(R.id.tvTime1);
        tvDuration1 = findViewById(R.id.tvDuration1);
        seekBarTime1 = findViewById(R.id.seekBarTime1);
        seekBarVolume1 = findViewById(R.id.seekBarVolume1);
        btnPlay1 = findViewById(R.id.btnPlay1);

        musicPlayer1 = MediaPlayer.create(this, R.raw.sura_elbaqra);
        musicPlayer1.setLooping(true);
        musicPlayer1.seekTo(0);
        musicPlayer1.setVolume(0.5f, 0.5f);

        String duration = millisecondsToString(musicPlayer1.getDuration());
        tvDuration1.setText(duration);

        btnPlay1.setOnClickListener(this);

        seekBarVolume1.setProgress(50);
        seekBarVolume1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean isFromUser) {
                float volume = progress / 100f;
                musicPlayer1.setVolume(volume,volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarTime1.setMax(musicPlayer1.getDuration());
        seekBarTime1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean isFromUser) {
                if(isFromUser) {
                    musicPlayer1.seekTo(progress);
                    seekBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (musicPlayer1 != null) {
                    if(musicPlayer1.isPlaying()) {
                        try {
                            final double current = musicPlayer1.getCurrentPosition();
                            final String elapsedTime = millisecondsToString((int) current);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvTime1.setText(elapsedTime);
                                    seekBarTime1.setProgress((int) current);
                                }
                            });

                            Thread.sleep(1000);
                        }catch (InterruptedException e) {}
                    }
                }
            }
        }).start();

    } // end main


    public String millisecondsToString(int time) {
        String elapsedTime = "";
        int minutes = time / 1000 / 60;
        int seconds = time / 1000 % 60;
        elapsedTime = minutes+":";
        if(seconds < 10) {
            elapsedTime += "0";
        }
        elapsedTime += seconds;

        return  elapsedTime;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnPlay) {
            if(musicPlayer1.isPlaying()) {
                // is playing
                musicPlayer1.pause();
                btnPlay1.setBackgroundResource(R.drawable.ic_play);
            } else {
                // on pause
                musicPlayer1.start();
                btnPlay1.setBackgroundResource(R.drawable.ic_pause);
            }
        }
    }
}
