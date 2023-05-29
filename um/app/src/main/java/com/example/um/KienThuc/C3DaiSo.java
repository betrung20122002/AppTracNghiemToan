package com.example.um.KienThuc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
public class C3DaiSo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.um.R.layout.activity_c3_dai_so);
    }

    public void dahieu(View view) {
        Intent i = new Intent(this,DaiSo.class);
        startActivity(i);
    }
}