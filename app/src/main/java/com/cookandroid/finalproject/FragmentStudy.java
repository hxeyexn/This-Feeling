package com.cookandroid.finalproject;

import static com.cookandroid.finalproject.R.layout.btm_study;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentStudy extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //액션바 제목 설정
        ActionBar actionBar =((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Study");
        actionBar.setDisplayHomeAsUpEnabled(false);

        //프래그먼트 스터디를 인플레이트해주고 컨테이너에 붙여달라는 뜻
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(btm_study, container, false);

        RecyclerView recyclerView=(RecyclerView)viewGroup.findViewById(R.id.recyclerview);
        //리스트뷰와 달리 LayoutManager 사용
        //LayoutManager를 현재 액티비티의 context 받아서 사용
        //그러나 지금은 액티비티가 아닌 프래그먼트에서 사용하므로
        //getApplicationContext()가 아닌 getActivity() 사용
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        //RecyclerView에 layoutmanager를 연결
        recyclerView.setLayoutManager(layoutManager);

        //studyitem 리스트
        List<StudyItem> items=new ArrayList<>();
        StudyItem[] item=new StudyItem[5];
        item[0]=new StudyItem(R.drawable.sf1,"#일상 속 친환경  - 분리수거? 분리배출?");
        item[1]=new StudyItem(R.drawable.ss1,"#탄소중립으로 GO!  - 레독스 흐름전지");
        item[2]=new StudyItem(R.drawable.st1,"#환경지식사전  - 프리사이클링");
        item[3]=new StudyItem(R.drawable.sfo1,"#꿀팁으로 친환경 실천  - 공유냉장고");
        item[4]=new StudyItem(R.drawable.sfi1,"#환경의 모습  - 흰수마자");
        for(int i=0;i<5;i++) items.add(item[i]);

        //데이터를 받은 스터디 어댑터가 화면을 그림
        recyclerView.setAdapter(new StudyAdapter(getActivity(), items, R.layout.btm_study));
        return viewGroup;
    }
}

//문자열과 이미지가 아이템에 들어감
class StudyItem {
    int image;
    String title;

    int getImage() {
        return this.image;
    }

    String getTitle() {
        return this.title;
    }

    StudyItem(int image, String title) {
        this.image = image;
        this.title = title;
    }
}

