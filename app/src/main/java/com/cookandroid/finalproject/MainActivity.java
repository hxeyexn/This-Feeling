package com.cookandroid.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //홈, 스터디, 커뮤니티 프래그먼트 생성
    //프래그먼트는 뷰와 다르게 context를 매개변수로 넣어줄 필요가 없음
    //FragmentManager는 transaction 객체를 가져올 수 있음
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final FragmentHome Fragmenthome = new FragmentHome();
    private final FragmentStudy Fragmentstudy = new FragmentStudy();
    private final FragmentCommunity Fragmentcommunity = new FragmentCommunity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FragmentManager 생성
        FragmentManager fragmentManager = getSupportFragmentManager();
        //프래그먼트 실행
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, Fragmenthome).commitAllowingStateLoss(); // 여러 개 쓰면 안됨

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnItemSelectedListener(new ItemSelectedListener());
    }

    //네비게이션 바 선택 했을 때 해당 프래그먼트 띄워주기
    class ItemSelectedListener implements BottomNavigationView.OnItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            //프래그먼트 실행
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.home:
                    //프래그먼트 실행, xml 파일에 만들어 둔 영역에 올림
                    transaction.replace(R.id.frameLayout, Fragmenthome).commitAllowingStateLoss();
                    break;

                case R.id.study:
                    //프래그먼트 실행, xml 파일에 만들어 둔 영역에 올림
                    transaction.replace(R.id.frameLayout, Fragmentstudy).commitAllowingStateLoss();
                    break;

                case R.id.community:
                    //프래그먼트 실행, xml 파일에 만들어 둔 영역에 올림
                    transaction.replace(R.id.frameLayout, Fragmentcommunity).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}