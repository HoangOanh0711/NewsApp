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
import android.widget.LinearLayout;
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

    ImageView IMG_lichvannien_back, img_sukien;
    CalendarView calendarView;
    TextView txt_ngay,txt_tensukien;
    LinearLayout layout_event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichvannien);
//        initWidgets();

        khaibao();

        selectedDate = LocalDate.now();
//        setMonthView();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String d="Ngày "+i2+" tháng "+(i1+1);
                event(d);
            }
        });
    }

    private void khaibao() {
        calendarView = findViewById(R.id.cld_lichvannien_lich);
        IMG_lichvannien_back = findViewById(R.id.img_lvn_back);
        img_sukien = findViewById(R.id.img_sukien_lichvannien);
        txt_ngay = findViewById(R.id.txt_ngaysukien_lichvannien);
        txt_tensukien = findViewById(R.id.txt_tensukien_lichvannien);
        layout_event = findViewById(R.id.linear_event);
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
            case "Ngày 1 tháng 1":
                txt_ngay.setText(date);
                txt_tensukien.setText("Tết Dương Lịch");
                layout_event.setVisibility(View.VISIBLE);
                img_sukien.setImageResource(R.drawable.calendar1);
                break;
            case "Ngày 14 tháng 2":
                txt_ngay.setText(date);
                txt_tensukien.setText("Lễ tình nhân (Valentine)");
                layout_event.setVisibility(View.VISIBLE);
                img_sukien.setImageResource(R.drawable.valentines_day);
                break;
            case "Ngày 3 tháng 2":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày thành lập Đảng Cộng sản Việt Nam");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 27 tháng 2":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày Thầy thuốc Việt Nam");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 8 tháng 3":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày Quốc tế Phụ nữ");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 20 tháng 3":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày Quốc tế Hạnh phúc");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 26 tháng 3":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày thành lập Đoàn Thanh niên Cộng sản Hồ Chí Minh");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 22 tháng 4":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày Trái đất");
                layout_event.setVisibility(View.VISIBLE);
                img_sukien.setImageResource(R.drawable.earth_day);
                break;
            case "Ngày 1 tháng 5":
                txt_ngay.setText(date);
                txt_tensukien.setText("Quốc tế lao động");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 19 tháng 5":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày sinh của Chủ tịch Hồ Chí Minh");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 1 tháng 6":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày Quốc tế Thiếu nhi");
                layout_event.setVisibility(View.VISIBLE);
                img_sukien.setImageResource(R.drawable.international_childrens_day);
                break;
            case "Ngày 28 tháng 6":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày Gia đình Việt Nam");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 27 tháng 7":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày Thương binh Liệt sĩ");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 19 tháng 8":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày Cách mạng tháng Tám thành công");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 2 tháng 9":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày Quốc khánh nước Cộng hoà Xã hội Chủ nghĩa Việt Nam\"");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 7 tháng 9":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày thành lập Đài Truyền hình Việt Nam");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 13 tháng 10":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày Doanh nhân Việt Nam");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 14 tháng 10":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày thành lập Hội Nông dân Việt Nam");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 20 tháng 10":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày thành lập Hội Phụ nữ Việt Nam");
                layout_event.setVisibility(View.VISIBLE);
                img_sukien.setImageResource(R.drawable.womens_day);
                break;
            case "Ngày 20 tháng 11":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày Nhà giáo Việt Nam");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 22 tháng 12":
                txt_ngay.setText(date);
                txt_tensukien.setText("Ngày thành lập Quân đội Nhân dân Việt Nam");
                layout_event.setVisibility(View.VISIBLE);
                break;
            case "Ngày 25 tháng 12":
                txt_ngay.setText(date);
                txt_tensukien.setText("Lễ Giáng Sinh");
                img_sukien.setImageResource(R.drawable.calendar);
                layout_event.setVisibility(View.VISIBLE);
                img_sukien.setImageResource(R.drawable.calendar);
                break;
            default:
                layout_event.setVisibility(View.GONE);
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