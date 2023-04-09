package com.cookandroid.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//홈 카테고리 욕실용품 액티비티
public class BathActivity extends AppCompatActivity {

    GridView gridView10;

    //배열 변수를 만들어 욕실용품 이름과 이미지 담음
    String[] bathWord = {"욕실용품1", "욕실용품2", "욕실용품3", "욕실용품4", "욕실용품5",
            "욕실용품6", "욕실용품7", "욕실용품8", "욕실용품9", "욕실용품10",
            "욕실용품11", "욕실용품12","욕실용품13", "욕실용품14", "욕실용품15",
            "욕실용품16", "욕실용품17", "욕실용품18", "욕실용품19", "욕실용품20"};

    int[] bathImage = {R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cg_bath);

        gridView10 = findViewById(R.id.gridView10);

        //배열을 욕실용품 어댑터에 넘겨줌
        BathAdapter bathAdapter = new BathAdapter(BathActivity.this, bathWord, bathImage);
        //데이터를 받은 욕실용품 어댑터가 화면을 그림
        gridView10.setAdapter(bathAdapter);

        //그리드뷰 클릭되었을 때 토스트 메시지 출력 이벤트(ex.욕실용품1을 클릭했습니다.)
        gridView10.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(getApplicationContext(), bathWord[position]+ "을 클릭했습니다."
                        , Toast.LENGTH_SHORT).show();
            }
        });

        //액션바 제목 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("욕실용품");
        //뒤로가기 버튼 생성
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
