package com.example.um;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Truyennn extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyennn);
        //lấy danh sách các câu chuyện nhỏ và nội dung là mảng chuỗi
        String[] titles = getResources().getStringArray(R.array.Story_title);
        String[] contents = getResources().getStringArray(R.array.Story_content);
        // ánh xạ
        recyclerView = findViewById(R.id.storyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, titles, contents);
        recyclerView.setAdapter(adapter);
    }
}