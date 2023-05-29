package com.example.um.KienThuc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.um.R;

public class C1Hinhhoc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1_hinhhoc);
    }

    public void dahieu(View view) {
        Intent i = new Intent(this,Hinhhocc.class);
        startActivity(i);
    }
}