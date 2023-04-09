package com.cookandroid.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//홈 카테고리 가구 액티비티
public class FurnitureActivity extends AppCompatActivity {

    GridView gridView9;

    //배열 변수를 만들어 가구 이름과 이미지 담음
    String[] furnitureWord = {"가구1", "가구2", "가구3", "가구4", "가구5",
            "가구6", "가구7", "가구8", "가구9", "가구10",
            "가구11", "가구12","가구13", "가구14", "가구15",
            "가구16", "가구17", "가구18", "가구19", "가구20"};

    int[] furnitureImage = {R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cg_furniture);

        gridView9 = findViewById(R.id.gridView9);

        //배열을 가구 어댑터에 넘겨줌
        FurnitureAdapter furnitureAdapter = new FurnitureAdapter(FurnitureActivity.this, furnitureWord, furnitureImage);
        //데이터를 받은 가구 어댑터가 화면을 그림
        gridView9.setAdapter(furnitureAdapter);

        //그리드뷰 클릭되었을 때 토스트 메시지 출력 이벤트(ex.가구1을 클릭했습니다.)
        gridView9.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(getApplicationContext(), furnitureWord[position] + "을 클릭했습니다."
                        , Toast.LENGTH_SHORT).show();
            }
        });

        //액션바 제목 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("가구");
        //뒤로가기 버튼 생성
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}

