package com.example.um;

import static com.example.um.MainActivity.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
public class NoiQuy extends AppCompatActivity {

    CheckBox CBmusic;
    CheckBox CBeffect;
    public static MediaPlayer musicfail;
    public static MediaPlayer musicsuccess;
    public static boolean musicEffectChecked = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noi_quy);
        CBmusic=(CheckBox)findViewById(R.id.CBMusic);
        CBeffect=(CheckBox)findViewById(R.id.CBEffect);
        CBmusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    music = MediaPlayer.create(NoiQuy.this, R.raw.music_background);
                    music.setLooping(true);
                    music.start();
                }
                else music.stop();
            }
        });
        CBeffect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    musicEffectChecked=true;
                    musicsuccess = MediaPlayer.create(NoiQuy.this, R.raw.music_success);
                    musicfail = MediaPlayer.create(NoiQuy.this, R.raw.music_fail);
                }
                else
                {
                    musicEffectChecked=false;
                    musicsuccess = null;
                    musicfail=null;
                }
            }
        });
    }
}