package com.example.um.KienThuc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.um.R;
public class Hinhhocc extends AppCompatActivity {
    LinearLayout c1,c2;
    ImageButton backk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hinhhocc);
        AnhXa();
        backk = findViewById(R.id.back);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hinhhocc.this, TaiLieu.class));
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hinhhocc.this, C1Hinhhoc.class));

            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hinhhocc.this, C2Hinhhoc.class));

            }
        });
    }

    private void AnhXa() {
        c1 = findViewById(R.id.c11);
        c2= findViewById(R.id.c22);
    }
}