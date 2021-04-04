package com.example.pettypaw_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewCalendar extends AppCompatActivity {

    GridView monthView;
    TextView monthText;
    MonthAdapter adt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_calendar);

        monthView = findViewById(R.id.monthView); //그리드뷰 객체 참조
        adt = new MonthAdapter(this); //어댑터 객체 생성
        monthView.setAdapter(adt); //그리드뷰에 어댑터 설정

        monthText = findViewById(R.id.monthText);
        setMonthText();

        Button monthPrevious = findViewById(R.id.monthPrevious);
        Button monthNext = findViewById(R.id.monthNext);

        //할일 listview로 설정한다.
        ListView todo_list = (ListView) findViewById(R.id.todo_list);

        // 뒤로가기 버튼 이벤트 리스너 설정
        monthPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adt.setPreviousMonth();
                adt.notifyDataSetChanged(); //어댑터 데이터 갱신하고 뷰 다시 뿌리기
                setMonthText();
            }
        });

        // 앞으로 가기 버튼에 이벤트 리스너 설정
        monthNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adt.setNextMonth();
                adt.notifyDataSetChanged(); //어댑터 데이터 갱신하고 뷰 다시 뿌리기
                setMonthText();
            }
        });
    }

    public void setMonthText(){
        int curYear = adt.getCurYear();
        int curMonth = adt.getCurMonth();
        monthText.setText(curYear+"년 "+(curMonth+1)+"월");
    }

    //액션버튼 메뉴 액션바에 집어넣기
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //액션버튼 클릭했을 때 동작
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //설정 아이콘
        if (id == R.id.setting_icon) {
            Intent intent = new Intent(this, LeaderSetting.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}