package com.example.um;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.um.KienThuc.TaiLieu;
import com.example.um.model.Category;

import java.util.List;

public class TracNghiem extends AppCompatActivity {
    private TextView textViewHighScore;
    private Spinner spinnerCategory;
    private Button buttonStartQuestion;
    ImageButton backk;
    private int highscore;
    private static final int REQUEST_CODE_QUESTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trac_nghiem);

        AnhXa();

        //load chu de
        loadCategories();
        //loa diem
        loadHighScore();
        //cliick bat dau
        buttonStartQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuestion();
            }
        });
        backk = findViewById(R.id.back);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TracNghiem.this, MainActivity.class));
            }
        });
    }
    //load điểm hiển thị
    private void loadHighScore() {

        SharedPreferences preferences = getSharedPreferences("share",MODE_PRIVATE);
        highscore = preferences.getInt("highscore",0);
        textViewHighScore.setText("Điểm cao : "+highscore);
    }

    //ham bat dau cau hoi qua activity question
    private void startQuestion() {
        //lay id,name chu de da chon
        Category category = (Category) spinnerCategory.getSelectedItem();
        int categoryID = category.getId();
        String categoryName = category.getName();

        //chuyen qua activity question
        Intent intent = new Intent(TracNghiem.this, QuestionActivity.class);
        //gui du lieu name, id
        intent.putExtra("idcategories",categoryID);
        intent.putExtra("categoriesname",categoryName);

        startActivityForResult(intent,REQUEST_CODE_QUESTION);
    }

    //phuong thuc anh xa id
    private void AnhXa(){
        textViewHighScore = findViewById(R.id.textview_high_score);
        buttonStartQuestion = findViewById(R.id.button_start_question);
        spinnerCategory = findViewById(R.id.spinner_category);
    }
    //load du lieu
    private void loadCategories(){
        Database database = new Database(this);
        //lay du lieu danh sach chu de
        List<Category> categories = database.getDataCategories();

        //tao adapter
        ArrayAdapter<Category> categoryArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,categories);

        //bo cuc hien thi chu de
        categoryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //gan chu de len spinner hien thi
        spinnerCategory.setAdapter(categoryArrayAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_QUESTION){
            //         if(requestCode == RESULT_OK){
            int score = data.getIntExtra("score",0);

            if(score > highscore){
                updateHighScore(score);
            }
            //        }
        }
    }

    //cap nhat diem cao
    private void updateHighScore(int score) {
        //gan diem cao moi
        highscore = score;
        //hien thi
        textViewHighScore.setText("Điểm cao :"+highscore);

        //lu tru diem
        SharedPreferences preferences = getSharedPreferences("share",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        //gan gia tri cho diem cao moi vao khoa
        editor.putInt("highscore",highscore);
        //hoan tat
        editor.apply();


    }
}
