package com.example.newsapp.LichVanNien;

import static java.time.format.DateTimeFormatter.ofPattern;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String d=i2+"/"+(i1+1);
                event(d);
            }
        });
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

    private void event(String date) {
        switch (date) {
            case "1/1":
                Log.e("event","Tết Dương Lịch");
                break;
            case "14/2":
                Log.e("event","Lễ tình nhân (Valentine)");
                break;
            case "3/2":
                Log.e("event","Ngày thành lập Đảng Cộng sản Việt Nam");
                break;
            case "27/2":
                Log.e("event","Ngày Thầy thuốc Việt Nam");
                break;
            case "8/3":
                Log.e("event","Ngày Quốc tế Phụ nữ");
                break;
            case "20/3":
                Log.e("event","Ngày Quốc tế Hạnh phúc");
                break;
            case "26/3":
                Log.e("event","Ngày thành lập Đoàn Thanh niên Cộng sản Hồ Chí Minh");
                break;
            case "22/4":
                Log.e("event","Ngày Trái đất");
                break;
            case "1/5":
                Log.e("event","Quốc tế lao động");
                break;
            case "19/5":
                Log.e("event","Ngày sinh của Chủ tịch Hồ Chí Minh");
                break;
            case "1/6":
                Log.e("event","Ngày Quốc tế Thiếu nhi");
                break;
            case "28/6":
                Log.e("event","Ngày Gia đình Việt Nam");
                break;
            case "27/7":
                Log.e("event","Ngày Thương binh Liệt sĩ");
                break;
            case "19/8":
                Log.e("event","Ngày Cách mạng tháng Tám thành công");
                break;
            case "2/9":
                Log.e("event","Ngày Quốc khánh nước Cộng hoà Xã hội Chủ nghĩa Việt Nam");
                break;
            case "7/9":
                Log.e("event","Ngày thành lập Đài Truyền hình Việt Nam");
                break;
            case "13/10":
                Log.e("event","Ngày Doanh nhân Việt Nam");
                break;
            case "14/10":
                Log.e("event","Ngày thành lập Hội Nông dân Việt Nam");
                break;
            case "20/10":
                Log.e("event","Ngày thành lập Hội Phụ nữ Việt Nam");
                break;
            case "20/11":
                Log.e("event","Ngày Nhà giáo Việt Nam");
                break;
            case "22/12":
                Log.e("event","Ngày thành lập Quân đội Nhân dân Việt Nam");
                break;
            case "25/12":
                Log.e("event","Lễ Giáng Sinh");
                break;

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