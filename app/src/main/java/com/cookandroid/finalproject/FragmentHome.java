package com.cookandroid.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class FragmentHome extends Fragment {
    ViewPager2 viewPager2;
    GridView gridView1;

    int[] images = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5};

    String[] categoryWord = {"식품", "용기", "화장품", "가전제품", "주방용품", "의류/신발", "생활용품", "가구", "욕실용품", "도서/문구", "기타"};
    int[] categoryImage = {R.drawable.ic_food, R.drawable.ic_container, R.drawable.ic_cosmetics,
            R.drawable.ic_appliances, R.drawable.ic_kitchen, R.drawable.ic_clothes, R.drawable.ic_daily,
            R.drawable.ic_furniture, R.drawable.ic_bath, R.drawable.ic_book, R.drawable.ic_etc};

    ItemAdapter itemAdapter;

    boolean orientationState = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //프래그먼트 홈을 인플레이트해주고 컨테이너에 붙여달라는 뜻
        View view = inflater.inflate(R.layout.btm_home, container, false);

        ViewPager2 viewPager2 = view.findViewById(R.id.viewPage2);
        itemAdapter = new ItemAdapter(images);
        viewPager2.setAdapter(itemAdapter);

        gridView1 = view.findViewById(R.id.gridView1);

        HomeCategoryAdapter homeCategoryAdapter = new HomeCategoryAdapter(getActivity(), categoryWord, categoryImage);
        gridView1.setAdapter(homeCategoryAdapter);

        ActionBar actionBar =((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Home");
        actionBar.setDisplayHomeAsUpEnabled(false);
        return view;
    }

}
