package com.cookandroid.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//홈 카테고리 가전제품 액티비티
public class AppliancesActivity extends AppCompatActivity {

    GridView gridView5;

    //배열 변수를 만들어 가전제품 이름과 이미지 담음
    String[] appliancesWord = {"가전제품1", "가전제품2", "가전제품3", "가전제품4", "가전제품5",
            "가전제품6", "가전제품7", "가전제품8", "가전제품9", "가전제품10",
            "가전제품11", "가전제품12","가전제품13", "가전제품14", "가전제품15",
            "가전제품16", "가전제품17", "가전제품18", "가전제품19", "가전제품20"};

    int[] appliancesImage = {R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cg_appliances);

        gridView5 = findViewById(R.id.gridView5);

        //배열을 가전제품 어댑터에 넘겨줌
        AppliancesAdapter appliancesAdapter = new AppliancesAdapter(AppliancesActivity.this, appliancesWord, appliancesImage);
        //데이터를 받은 가전제품 어댑터가 화면을 그림
        gridView5.setAdapter(appliancesAdapter);

        //그리드뷰 클릭되었을 때 토스트 메시지 출력 이벤트(ex.가전제품1을 클릭했습니다.)
        gridView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(getApplicationContext(), appliancesWord[position]+ "을 클릭했습니다."
                        , Toast.LENGTH_SHORT).show();
            }
        });

        //액션바 제목 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("가전제품");
        //뒤로가기 버튼 생성
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}

