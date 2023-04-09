package com.cookandroid.finalproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//StudyFourth 액티비티
public class StudyFourthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_fourth);

        //액션바 제목 설정
        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("꿀팁으로 친환경 실천");
        actionBar.setDisplayHomeAsUpEnabled(false);
    }
}
