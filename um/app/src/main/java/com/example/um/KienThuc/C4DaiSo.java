package com.example.um.KienThuc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.um.R;

public class C4DaiSo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c4_dai_so);
    }

    public void dahieu(View view) {
        Intent i = new Intent(this,DaiSo.class);
        startActivity(i);
    }
}