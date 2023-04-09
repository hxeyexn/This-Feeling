package com.cookandroid.finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//홈 화면 밀어서 화면 변경 데이터 연결 어댑터
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    int[] images;

    public ItemAdapter(int[] images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //뷰홀더를 생성시점에 자동호출 메소드
        //각각의 아이템을 위한 레이아웃을 인플레이션 후 뷰홀더에 넣어서 뷰홀더를 리턴하면 하나의 아이템을 위한 뷰홀더가 만들어져서 리턴됨
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    //뷰홀더 재사용위한 메소드
    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {

        holder.imageView.setImageResource(images[position]);
    }

    //자식 뷰(어댑터 뷰의 자식 뷰)들의 개수를 리턴하는 메소드
    @Override
    public int getItemCount() {
        return images.length;
    }

    // 뷰홀더 클래스
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

