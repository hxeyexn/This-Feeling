package com.cookandroid.finalproject;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//어댑터는 RecyclerView.Adapter<StudyAdapter.ViewHolder>를 상속받음
public class StudyAdapter extends RecyclerView.Adapter<StudyAdapter.ViewHolder> {
    Context context;
    List<StudyItem> items;
    int item_layout;
    public StudyAdapter(Context context, List<StudyItem> items, int item_layout) {
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    //ViewHolder 불러줌
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //뷰홀더를 생성시점에 자동호출 메소드
        //각각의 아이템을 위한 레이아웃을 인플레이션 후 뷰홀더에 넣어서 뷰홀더를 리턴하면 하나의 아이템을 위한 뷰홀더가 만들어져서 리턴됨
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_study_cardview,null);
        return new ViewHolder(v);
    }

    //불러온 데이터를 아이템에 넣어줌
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final StudyItem item=items.get(position);
        Drawable drawable=context.getResources().getDrawable(item.getImage());
        holder.image.setBackground(drawable);
        holder.title.setText(item.getTitle());
        holder.cardview.setOnClickListener(new View.OnClickListener() {

            //카드뷰 클릭했을 때 해당 액티비티 띄움
            @Override
            public void onClick(View v) {
                //0번 클릭되었을 때
                if(position == 0) {
                    Intent intent = new Intent(context, StudyFirstActivity.class);
                    //StudyFirst 액티비티 호출
                    context.startActivity(intent);
                }
                //1번 클릭되었을 때
                else if(position == 1) {
                    Intent intent = new Intent(context, StudySecondActivity.class);
                    //StudySecond 액티비티 호출
                    context.startActivity(intent);
                }
                //2번 클릭되었을 때
                else if(position == 2) {
                    Intent intent = new Intent(context, StudyThirdActivity.class);
                    //StudyThird 액티비티 호출
                    context.startActivity(intent);
                }
                //3번 클릭되었을 때
                else if(position == 3) {
                    Intent intent = new Intent(context, StudyFourthActivity.class);
                    //StudyFourth 액티비티 호출
                    context.startActivity(intent);
                }
                //4번 클릭되었을 때
                else if(position == 4) {
                    Intent intent = new Intent(context, StudyFifthActivity.class);
                    //StudyFifth 액티비티 호출
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        CardView cardview;

        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.imageView1);
            title=(TextView)itemView.findViewById(R.id.textView1);
            cardview=(CardView)itemView.findViewById(R.id.cardview);
        }
    }
}


