package com.cookandroid.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FragmentCommunity extends Fragment {
    ListView listView;
    Button saveBtn;
    EditText edittext1, edittext2;
    MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //프래그먼트 커뮤니티를 인플레이트해주고 컨테이너에 붙여달라는 뜻
        View view = inflater.inflate(R.layout.btm_community, container, false);
        activity = (MainActivity) getActivity();
        edittext1 = (EditText) view.findViewById(R.id.edittext1);
        edittext2 = (EditText) view.findViewById(R.id.edittext2);
        saveBtn = (Button) view.findViewById(R.id.saveBtn);
        ListView listview= (ListView)view.findViewById(R.id.listView1);

        //리스트뷰
        final ArrayAdapter<Object> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1);
        listview.setAdapter(adapter);

        //파이어베이스 사용
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();


        //글 저장 버튼 눌렀을 때
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference database = FirebaseDatabase.getInstance().getReference();
                Board board = new Board(edittext1.getText().toString(),edittext2.getText().toString());
                //(앱 안정성)제목 입력 값 없는 경우 제목 입력하라는 토스트 메시지 출력
                if(edittext1.getText().toString().replace(" ", "").equals("")){
                    Toast.makeText(getActivity(), "제목을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                //(앱 안정성)내용 입력 값 없는 경우 내용 입력하라는 토스트 메시지 출력
                else if(edittext2.getText().toString().replace(" ", "").equals("")){
                    Toast.makeText(getActivity(), "내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                //(앱안정성)제목, 내용 값 둘 다 있으면 파이어베이스(DB)에 데이터 저장
                else{
                    //파이어베이스(DB)에 데이터 저장
                    database.child("board").push().setValue(board);
                    //글 저장 되면 edittext 값 초기화
                    edittext1.setText(null);
                    edittext2.setText(null);
                    //글 저장되면 키보드 숨기기
                    InputMethodManager mInputMethodManager = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    mInputMethodManager.hideSoftInputFromWindow(edittext1.getWindowToken(), 0);
                    mInputMethodManager.hideSoftInputFromWindow(edittext2.getWindowToken(), 0);
                }
            }
        });


        database.child("board").addChildEventListener(new ChildEventListener() {

            //파이어베이스에서 데이터 추가 되었을 때 가져와서 리스트에 뿌리기
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                Board board = dataSnapshot.getValue(Board.class);
                adapter.add(board.gettitle());
            }

            //데이터가 변화되었을 때
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            //데이터가 제거되었을 때
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            //데이터가 파이어베이스 DB 리스트 위치 변경되었을 때
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            //DB 처리중 오류가 발생했을 때
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //액션바 제목 설정
        ActionBar actionBar =((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Community");
        actionBar.setDisplayHomeAsUpEnabled(false);
        return view;
    }


}

//게시판 클래스
class Board{
    String title;
    String content;

    Board(){}

    Board(String title, String content) {
        this.title=title;
        this.content=content;
    }

    public String gettitle() { return title; }
    public String getcontent() { return content; }
}

