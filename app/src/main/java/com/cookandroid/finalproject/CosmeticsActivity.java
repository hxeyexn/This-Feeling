package com.cookandroid.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//홈 카테고리 화장품 액티비티
public class CosmeticsActivity extends AppCompatActivity {

    GridView gridView4;

    //배열 변수를 만들어 화장품 이름과 이미지 담음
    String[] cosmeticsWord = {"화장품1", "화장품2", "화장품3", "화장품4", "화장품5", "화장품6", "화장품7", "화장품8", "화장품9", "화장품10",
            "화장품11", "화장품12","화장품13", "화장품14", "화장품15", "화장품16", "화장품17", "화장품18", "화장품19", "화장품20"};

    int[] cosmeticsImage = {R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cg_cosmetics);

        gridView4 = findViewById(R.id.gridView4);

        //배열을 화장품 어댑터에 넘겨줌
        CosmeticsAdapter cosmeticsAdapter = new CosmeticsAdapter(CosmeticsActivity.this, cosmeticsWord, cosmeticsImage);
        //데이터를 받은 화장품 어댑터가 화면을 그림
        gridView4.setAdapter(cosmeticsAdapter);

        //그리드뷰 클릭되었을 때 토스트 메시지 출력 이벤트(ex.의류/신발1을 클릭했습니다.)
        gridView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(getApplicationContext(), cosmeticsWord[position]+ "을 클릭했습니다."
                        , Toast.LENGTH_SHORT).show();
            }
        });

        //액션바 제목 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("화장품");
        //뒤로가기 버튼 생성
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
