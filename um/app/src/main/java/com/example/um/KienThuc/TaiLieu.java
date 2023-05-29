package com.example.um.KienThuc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.um.MainActivity;
import com.example.um.R;

public class TaiLieu extends AppCompatActivity {
    ImageButton backk;
    LinearLayout daiso,hinhhoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_lieu);
        AnhXa();
        backk = findViewById(R.id.back);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TaiLieu.this, MainActivity.class));
            }
        });
        daiso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TaiLieu.this, DaiSo.class));

            }
        });

        hinhhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TaiLieu.this, Hinhhocc.class));
            }
        });
    }

    private void AnhXa() {
        daiso = findViewById(R.id.daiso);
        hinhhoc = findViewById(R.id.hinhhoc);
    }
}