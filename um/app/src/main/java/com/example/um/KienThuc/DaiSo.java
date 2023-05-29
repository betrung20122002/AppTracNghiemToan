package com.example.um.KienThuc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.um.R;

public class DaiSo extends AppCompatActivity {
    LinearLayout c1, c2,c3,c4;
    ImageButton backk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dai_so);
        AnhXa();
        backk = findViewById(R.id.back);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaiSo.this, TaiLieu.class));
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DaiSo.this, C1DaiSo.class));

            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DaiSo.this, C2DaiSo.class));

            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DaiSo.this, C4DaiSo.class));

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DaiSo.this, C3DaiSo.class));

            }
        });
    }

    private void AnhXa() {
        c1 = findViewById(R.id.c111);
        c2 = findViewById(R.id.c222);
        c3 = findViewById(R.id.c333);
        c4 = findViewById(R.id.c444);
    }

}