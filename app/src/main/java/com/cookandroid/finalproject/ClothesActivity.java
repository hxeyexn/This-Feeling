package com.cookandroid.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//홈 카테고리 의류/신발 액티비티
public class ClothesActivity extends AppCompatActivity {

    GridView gridView7;

    //배열 변수를 만들어 의류/신발 이름과 이미지 담음
    String[] clothesWord = {"의류/신발1", "의류/신발2", "의류/신발3", "의류/신발4", "의류/신발5",
            "의류/신발6", "의류/신발7", "의류/신발8", "의류/신발9", "의류/신발10",
            "의류/신발11", "의류/신발12","의류/신발13", "의류/신발14", "의류/신발15",
            "의류/신발16", "의류/신발17", "의류/신발18", "의류/신발19", "의류/신발20"};

    int[] clothesImage = {R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content,
            R.drawable.ic_content,R.drawable.ic_content, R.drawable.ic_content,R.drawable.ic_content};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cg_clothes);

        gridView7 = findViewById(R.id.gridView7);

        //배열을 의류/신발 어댑터에 넘겨줌
        ClothesAdapter clothesAdapter = new ClothesAdapter(ClothesActivity.this, clothesWord, clothesImage);
        //데이터를 받은 의류/신발 어댑터가 화면을 그림
        gridView7.setAdapter(clothesAdapter);

        //그리드뷰 클릭되었을 때 토스트 메시지 출력 이벤트(ex.의류/신발1을 클릭했습니다.)
        gridView7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(getApplicationContext(), clothesWord[position]+ "을 클릭했습니다."
                        , Toast.LENGTH_SHORT).show();
            }
        });

        //액션바 제목 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("의류/신발");
        //뒤로가기 버튼 생성
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}