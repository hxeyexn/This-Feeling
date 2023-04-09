package com.cookandroid.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//홈 카테고리 용기 액티비티
public class ContainerActivity extends AppCompatActivity {

    GridView gridView3;

    //배열 변수를 만들어 용기 이름과 이미지 담음
    String[] containerWord = {"용기1", "용기2", "용기3", "용기4", "용기5", "용기6", "용기7", "용기8", "용기9", "용기10",
            "용기11", "용기12","용기13", "용기14", "용기15", "용기16", "용기17", "용기18", "용기19", "용기20"};

    int[] containerImage = {R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cg_container);

        gridView3 = findViewById(R.id.gridView3);

        //배열을 용기 어댑터에 넘겨줌
        ContainerAdapter containerAdapter = new ContainerAdapter(ContainerActivity.this, containerWord, containerImage);
        //데이터를 받은 용기 어댑터가 화면을 그림
        gridView3.setAdapter(containerAdapter);

        //그리드뷰 클릭되었을 때 토스트 메시지 출력 이벤트(ex.용기1을 클릭했습니다.)
        gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(getApplicationContext(), containerWord[position]+ "을 클릭했습니다."
                        , Toast.LENGTH_SHORT).show();
            }
        });

        //액션바 제목 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("용기");
        //뒤로가기 버튼 생성
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}

