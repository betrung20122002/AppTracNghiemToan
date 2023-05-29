package com.example.um.KienThuc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.um.R;

public class C2Hinhhoc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_hinhhoc);
    }

    public void dahieuu(View view) {
        Intent i = new Intent(this,Hinhhocc.class);
        startActivity(i);
    }
}