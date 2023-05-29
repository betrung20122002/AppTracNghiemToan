package com.example.um.GiaiTri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.um.KienThuc.Hinhhocc;
import com.example.um.KienThuc.TaiLieu;
import com.example.um.MainActivity;
import com.example.um.R;

public class Game extends AppCompatActivity {
    private Button playgame, choitiep, vemenu;
    ImageButton backk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);
        anhxa();
        batxukienclick();
        backk = findViewById(R.id.back);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Game.this, MainActivity.class));
            }
        });
    }
    public void batxukienclick()
    {

        playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Game.this, ChoiGame.class);
                intent.putExtra("playgame", 1);
                startActivity(intent);
            }
        });
        choitiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Game.this, ChoiGame.class);
                intent.putExtra("playgame", 3);
                startActivity(intent);
            }
        });
        vemenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Game.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void anhxa()
    {
        playgame = (Button)findViewById(R.id.playgame2048);
        choitiep = (Button)findViewById(R.id.choitiep);
        vemenu = (Button)findViewById(R.id.vemenu);
    }
}