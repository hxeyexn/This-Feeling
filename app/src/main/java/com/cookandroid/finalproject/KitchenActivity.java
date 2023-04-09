package com.cookandroid.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//홈 카테고리 주방용품 액티비티
public class KitchenActivity extends AppCompatActivity {

    GridView gridView6;

    //배열 변수를 만들어 주방용품 이름과 이미지 담음
    String[] kitchenWord = {"주방용품1", "주방용품2", "주방용품3", "주방용품4", "주방용품5",
            "주방용품6", "주방용품7", "주방용품8", "주방용품9", "주방용품10",
            "주방용품11", "주방용품12","주방용품13", "주방용품14", "주방용품15",
            "주방용품16", "주방용품17", "주방용품18", "주방용품19", "주방용품20"};

    int[] kitchenImage = {R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cg_kitchen);

        gridView6 = findViewById(R.id.gridView6);

        //배열을 주방용품 어댑터에 넘겨줌
        KitchenAdapter kitchenAdapter = new KitchenAdapter(KitchenActivity.this, kitchenWord, kitchenImage);
        //데이터를 받은 주방용품 어댑터가 화면을 그림
        gridView6.setAdapter(kitchenAdapter);

        //그리드뷰 클릭되었을 때 토스트 메시지 출력 이벤트(ex.주방욤품1을 클릭했습니다.)
        gridView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(getApplicationContext(), kitchenWord[position]+ "을 클릭했습니다."
                        , Toast.LENGTH_SHORT).show();
            }
        });

        //액션바 제목 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("주방용품");
        //뒤로가기 버튼 생성
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
