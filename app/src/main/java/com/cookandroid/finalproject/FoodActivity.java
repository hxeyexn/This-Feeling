package com.cookandroid.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//홈 카테고리 식품 액티비티
public class FoodActivity extends AppCompatActivity {

    GridView gridView2;

    //배열 변수를 만들어 식품 이름과 이미지 담음
    String[] foodWord = {"과일껍질", "동물 뼈", "달걀껍질", "육류", "과일씨앗",
             "양파껍질", "기름", "장류", "커피찌꺼기", "약",
             "견과류껍질", "갑각류\n/어패류"};

    int[] foodImage = {R.drawable.ic_fruitpeel, R.drawable.ic_bone, R.drawable.ic_egg,
            R.drawable.ic_meat, R.drawable.ic_fruitseeds, R.drawable.ic_onionskin,
            R.drawable.ic_oil, R.drawable.ic_sauce, R.drawable.ic_coffeegrounds,
            R.drawable.ic_medicine, R.drawable.ic_nutshell, R.drawable.ic_crab};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cg_food);

        gridView2 = findViewById(R.id.gridView2);

        //배열을 식품 어댑터에 넘겨줌
        FoodAdapter foodAdapter = new FoodAdapter(FoodActivity.this, foodWord, foodImage);
        //데이터를 받은 식품 어댑터가 화면을 그림
        gridView2.setAdapter(foodAdapter);

        //액션바 제목 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("식품");
        //뒤로가기 버튼 생성
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}


