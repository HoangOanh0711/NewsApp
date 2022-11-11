package com.example.newsapp.LichVanNien;

import static java.time.format.DateTimeFormatter.ofPattern;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsapp.GiaVang.giavang;
import com.example.newsapp.R;
import com.example.newsapp.TrangChu.taikhoan;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class lichvannien extends AppCompatActivity {

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectedDate;
    ImageView IMG_lichvannien_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichvannien);
//        initWidgets();
        selectedDate = LocalDate.now();
        CalendarView calendarView = findViewById(R.id.cld_lichvannien_lich);
        IMG_lichvannien_back = findViewById(R.id.img_lvn_back);
//        setMonthView();
    }
    //Hàm quay về màn hình trước
    public void backFromLichVanNien(View view){

        Intent intent = new Intent(getApplicationContext(), taikhoan.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.LayoutLichVanNien),"transition_taikhoan");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(lichvannien.this,pairs);
            startActivity(intent,options.toBundle());
        }else {
            startActivity(intent);
        }
    }
//    private void initWidgets()
//    {
//        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
//        monthYearText = findViewById(R.id.monthYearTV);
//    }
//
//    private void setMonthView()
//    {
//        monthYearText.setText(monthYearFromDate(selectedDate));
//        ArrayList<String> daysInMonth = daysInMonthArray(selectedDate);
//
//        lichvannienAdapter calendarAdapter = new lichvannienAdapter(daysInMonth, this);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
//        calendarRecyclerView.setLayoutManager(layoutManager);
//        calendarRecyclerView.setAdapter(calendarAdapter);
//    }
//
//    private ArrayList<String> daysInMonthArray(LocalDate date)
//    {
//        ArrayList<String> daysInMonthArray = new ArrayList<>();
//        YearMonth yearMonth = YearMonth.from(date);
//
//        int daysInMonth = yearMonth.lengthOfMonth();
//
//        LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
//        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();
//
//        for(int i = 1; i <= 42; i++)
//        {
//            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek)
//            {
//                daysInMonthArray.add("");
//            }
//            else
//            {
//                daysInMonthArray.add(String.valueOf(i - dayOfWeek));
//            }
//        }
//        return  daysInMonthArray;
//    }
//
//    private String monthYearFromDate(LocalDate date)
//    {
//        DateTimeFormatter formatter = ofPattern("MMMM yyyy");
//        return date.format(formatter);
//    }
//
//    public void previousMonthAction(View view)
//    {
//        selectedDate = selectedDate.minusMonths(1);
//        setMonthView();
//    }
//
//    public void nextMonthAction(View view)
//    {
//        selectedDate = selectedDate.plusMonths(1);
//        setMonthView();
//    }
//
//    @Override
//    public void onItemClick(int position, String dayText)
//    {
//        if(!dayText.equals(""))
//        {
//            String message = "Selected Date " + dayText + " " + monthYearFromDate(selectedDate);
//            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
//        }
//    }
}