package com.example.um.GiaiTri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.um.MainActivity;
import com.example.um.R;
import com.example.um.Truyennn;

public class GiaiTriMain extends AppCompatActivity {

    LinearLayout game, doctruyen;
    ImageButton backk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_tri_main);
        AnhXa();
        backk = findViewById(R.id.back);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GiaiTriMain.this, MainActivity.class));
            }
        });
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GiaiTriMain.this, Game.class));

            }
        });
        doctruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GiaiTriMain.this, Truyennn.class));

            }
        });


    }

    private void AnhXa() {
        game = findViewById(R.id.gameee);
        doctruyen = findViewById(R.id.truyennnn);
    }
}