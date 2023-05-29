package com.example.um;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {
    TextView storyContent;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        storyContent = findViewById(R.id.contentOfStory);
        toolbar = findViewById(R.id.titles);
        Intent i = getIntent();
        String title = i.getStringExtra("titleOfStory");
        String content = i.getStringExtra("contentOfStory");
        toolbar.setTitle(title);
        storyContent.setText(content);
        storyContent.setMovementMethod(new ScrollingMovementMethod());


    }
}