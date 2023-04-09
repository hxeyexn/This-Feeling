package com.cookandroid.finalproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//StudyFirst 액티비티
public class StudyFirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_first);

        //액션바 제목 설정
        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("일상 속 친환경");
        actionBar.setDisplayHomeAsUpEnabled(false);

    }
}