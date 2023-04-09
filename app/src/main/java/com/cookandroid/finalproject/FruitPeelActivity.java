package com.cookandroid.finalproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//홈 카테고리 식품 중 과일껍질 액티비티
public class FruitPeelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f_fruit_peel);

        //액션바 제목 설정
        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("과일껍질");
        //뒤로가기 버튼 생성
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
}