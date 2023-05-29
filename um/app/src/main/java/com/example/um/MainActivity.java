package com.example.um;

import static com.example.um.NoiQuy.musicfail;
import static com.example.um.NoiQuy.musicsuccess;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.um.GiaiTri.GiaiTriMain;
import com.example.um.KienThuc.TaiLieu;

public class MainActivity extends AppCompatActivity {
    public static MediaPlayer music;
    LinearLayout kienthuc,tracnghiem,noiquy,choigame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        if(NoiQuy.musicEffectChecked)
        {
            musicsuccess = MediaPlayer.create(MainActivity.this,R.raw.music_success);
            musicfail  = MediaPlayer.create(MainActivity.this,R.raw.music_fail);
        }
        if(music == null)
        {
            music = MediaPlayer.create(MainActivity.this,R.raw.music_background);
            music.setLooping(true);
            music.start();
        }
        kienthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TaiLieu.class));

            }
        });
        tracnghiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TracNghiem.class));
            }
        });

        noiquy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NoiQuy.class));
            }
        });

        choigame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GiaiTriMain.class));
            }
        });
        Button btnAbout = (Button)findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);

                TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(20);
                tv.setBackgroundColor(Color.GREEN);

                Typeface t = Typeface.create("serif", Typeface.BOLD_ITALIC);
                tv.setTypeface(t);
                tv.setPadding(5,5,5,5);
                tv.setText("Thành viên nhóm:\n 12520084 - Trần Quang Trung");
                toast.setView(tv);
                toast.show();
            }
        });

    }
    private void AnhXa() {
        kienthuc = findViewById(R.id.kienthuc);
         tracnghiem = findViewById(R.id.tracnghiem);
        noiquy = findViewById(R.id.thele);
        choigame = findViewById(R.id.game);
    }
    
}