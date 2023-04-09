package com.cookandroid.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//홈 카테고리 도서/문구 액티비티
public class BookActivity extends AppCompatActivity {

    GridView gridView11;

    //배열 변수를 만들어 도서/문구 이름과 이미지 담음
    String[] bookWord = {"도서/문구1", "도서/문구2", "도서/문구3", "도서/문구4", "도서/문구5",
            "도서/문구6", "도서/문구7", "도서/문구8", "도서/문구9", "도서/문구10",
            "도서/문구11", "도서/문구12","도서/문구13", "도서/문구14", "도서/문구15",
            "도서/문구16", "도서/문구17", "도서/문구18", "도서/문구19", "도서/문구20"};

    int[] bookImage = {R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content,
            R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content, R.drawable.ic_content};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cg_book);

        gridView11 = findViewById(R.id.gridView11);

        //배열을 도서/문구 어댑터에 넘겨줌
        BookAdapter bookAdapter = new BookAdapter(BookActivity.this, bookWord, bookImage);
        //데이터를 받은 도서/문구 어댑터가 화면을 그림
        gridView11.setAdapter(bookAdapter);

        //그리드뷰 클릭되었을 때 토스트 메시지 출력 이벤트(ex.도서/문구1을 클릭했습니다.)
        gridView11.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(getApplicationContext(), bookWord[position]+ "을 클릭했습니다."
                        , Toast.LENGTH_SHORT).show();
            }
        });

        //액션바 제목 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("도서/문구");
        //뒤로가기 버튼 생성
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}

