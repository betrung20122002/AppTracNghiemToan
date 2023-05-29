package com.example.um;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashCreen extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    private ImageView logo;
    private static int splashTimeOut=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_creen);

        Media();
        logo = findViewById(R.id.logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashCreen.this, Login.class);
                startActivity(i);
                mediaPlayer.stop();
                finish();
            }
        }, splashTimeOut);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mysplashanimation);
        logo.startAnimation(myanim);
    }
    private void Media() {
        mediaPlayer = MediaPlayer.create(this, R.raw.cat_sound);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
}