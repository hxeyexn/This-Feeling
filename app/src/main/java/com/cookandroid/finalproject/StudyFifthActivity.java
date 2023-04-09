package com.cookandroid.finalproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//StudyFifth 액티비티
public class StudyFifthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_fifth);

        //액션바 제목 설정
        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("환경의 모습");
        actionBar.setDisplayHomeAsUpEnabled(false);
    }
}
