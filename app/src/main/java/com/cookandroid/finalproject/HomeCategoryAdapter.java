package com.cookandroid.finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeCategoryAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    String[] arrCategoryWord;
    int[] arrCategoryImage;

    public HomeCategoryAdapter(Context context, String[] arrCategoryWord, int[] arrCategoryImage) {

        this.context = context;
        this.arrCategoryWord = arrCategoryWord;
        this.arrCategoryImage = arrCategoryImage;
    }

    //자식 뷰(어댑터 뷰의 자식 뷰)들의 개수를 리턴하는 메소드
    @Override
    public int getCount() {
        return arrCategoryWord.length;
    }

    //항목(자식 뷰의 내용을 갖는 객체) 중 하나를 리턴
    //int position은 리턴할 항목의 위치를 의미
    @Override
    public Object getItem(int position) {
        return arrCategoryWord[position];
    }

    //어댑터가 갖는 항목의 ID를 리턴
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //각 그리드 칸마다 이미지뷰, 텍스트뷰 생성해서 보여줌
    //자식 뷰들 중 하나를 리턴하는 메소드, 값이 null이면, 자식 뷰를 생성
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (inflater == null) {
            //LayoutInflater(xml 리소스를 전개하여 뷰 객체를 만듬) 객체 사용할 준비
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        if (view == null) {
            //사전에 미리 선언해뒀던 레이아웃에 작성했던 xml의 메모리 객체가 삽입
            //인수 root는 생성된 뷰의 루트로 사용할 뷰, 리소스 내에 루트가 따로 있어 null 사용
            view = inflater.inflate(R.layout.home_category, null);
        }

        ImageView categoryImage = view.findViewById(R.id.categoryImage);
        TextView categoryWord = view.findViewById(R.id.categoryText);

        categoryImage.setImageResource(arrCategoryImage[position]);
        categoryWord.setText(arrCategoryWord[position]);

        //카테고리 클릭하면 해당 액티비티 띄우기
        categoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //식품 카테고리 클릭 시
                if(position == 0) {
                    Intent intent = new Intent(context, FoodActivity.class);
                    context.startActivity(intent);
                }
                //용기 카테고리 클릭 시
                else if(position == 1) {
                    Intent intent = new Intent(context, ContainerActivity.class);
                    context.startActivity(intent);
                }
                //화장품 카테고리 클릭 시
                else if(position == 2) {
                    Intent intent = new Intent(context, CosmeticsActivity.class);
                    context.startActivity(intent);
                }
                //가전제품 카테고리 클릭 시
                else if(position == 3) {
                    Intent intent = new Intent(context, AppliancesActivity.class);
                    context.startActivity(intent);
                }
                //주방용품 카테고리 클릭 시
                else if(position == 4) {
                    Intent intent = new Intent(context, KitchenActivity.class);
                    context.startActivity(intent);
                }
                //의류/신발 카테고리 클릭 시
                else if(position == 5) {
                    Intent intent = new Intent(context, ClothesActivity.class);
                    context.startActivity(intent);
                }
                //생활용품 카테고리 클릭 시
                else if(position == 6) {
                    Intent intent = new Intent(context, DailyActivity.class);
                    context.startActivity(intent);
                }
                //가구 카테고리 클릭 시
                else if(position == 7) {
                    Intent intent = new Intent(context, FurnitureActivity.class);
                    context.startActivity(intent);
                }
                //욕실용품 카테고리 클릭 시
                else if(position == 8) {
                    Intent intent = new Intent(context, BathActivity.class);
                    context.startActivity(intent);
                }
                //도서/문구 카테고리 클릭 시
                else if(position == 9) {
                    Intent intent = new Intent(context, BookActivity.class);
                    context.startActivity(intent);
                }
                //기타 카테고리 클릭 시
                else if(position == 10) {
                    Intent intent = new Intent(context, EtcActivity.class);
                    context.startActivity(intent);
                }
            }
        });
        return view;
    }
}
