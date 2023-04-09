package com.cookandroid.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//홈 카테고리 기타 액티비티
public class EtcActivity extends AppCompatActivity {

    GridView gridView12;

    //배열 변수를 만들어 기타 이름과 이미지 담음
    String[] etcWord = {"기타1", "기타2", "기타3", "기타4", "기타5", "기타6", "기타7", "기타8", "기타9", "기타10",
            "기타11", "기타12","기타13", "기타14", "기타15", "기타16", "기타17", "기타18", "기타19", "기타20"};

    int[] etcImage = {R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cg_etc);

        gridView12 = findViewById(R.id.gridView12);

        //배열을 기타 어댑터에 넘겨줌
        EtcAdapter etcAdapter = new EtcAdapter(EtcActivity.this, etcWord, etcImage);
        //데이터를 받은 기타 어댑터가 화면을 그림
        gridView12.setAdapter(etcAdapter);

        //그리드뷰 클릭되었을 때 토스트 메시지 출력 이벤트(ex.기타1을 클릭했습니다.)
        gridView12.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(getApplicationContext(), etcWord[position]+ "을 클릭했습니다."
                        , Toast.LENGTH_SHORT).show();
            }
        });

        //액션바 제목 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("기타");
        //뒤로가기 버튼 생성
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
