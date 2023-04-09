package com.cookandroid.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//홈 카테고리 생활용품 액티비티
public class DailyActivity extends AppCompatActivity {

    GridView gridView8;

    //배열 변수를 만들어 생활용품 이름과 이미지 담음
    String[] dailyWord = {"생활용품1", "생활용품2", "생활용품3", "생활용품4", "생활용품5",
            "생활용품6", "생활용품7", "생활용품8", "생활용품9", "생활용품10",
            "생활용품11", "생활용품12","생활용품13", "생활용품14", "생활용품15",
            "생활용품16", "생활용품17", "생활용품18", "생활용품19", "생활용품20"};

    int[] dailyImage = {R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cg_daily);

        gridView8 = findViewById(R.id.gridView8);

        //배열을 생활용품 어댑터에 넘겨줌
        DailyAdapter dailyAdapter = new DailyAdapter(DailyActivity.this, dailyWord, dailyImage);
        //데이터를 받은 생활용품 어댑터가 화면을 그림
        gridView8.setAdapter(dailyAdapter);

        //그리드뷰 클릭되었을 때 토스트 메시지 출력 이벤트(ex.생활용품1을 클릭했습니다.)
        gridView8.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(getApplicationContext(), dailyWord[position]+ "을 클릭했습니다."
                        , Toast.LENGTH_SHORT).show();
            }
        });

        //액션바 제목 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("생활용품");
        //뒤로가기 버튼 생성
        actionBar.setDisplayHomeAsUpEnabled(true); //뒤로가기 버튼 생성
    }
}