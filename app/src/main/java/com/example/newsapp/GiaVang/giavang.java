package com.example.newsapp.GiaVang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.R;
import com.example.newsapp.Thoitiet.Thoitiet1;
import com.example.newsapp.Thoitiet.Thoitiet1_Adapter;
import com.example.newsapp.TrangChu.taikhoan;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class giavang extends AppCompatActivity {
//    TextView TXT_giavang_tieude, TXT_giavang_ngay;
//    private ViewgiavangAdapter mAdapter;
//    private ViewPager2 viewPaperGiaVang;
//    private TabLayout mTabLayout;
//    private int[] mTabTitles = new int[]{R.string.loai, R.string.mua, R.string.ban}
    ImageView IMG_giavang_back;
    RecyclerView rcvGiavang;
    GiaVang_Adapter giaVang_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giavang);
        //
//        TXT_giavang_tieude = findViewById(R.id.txt_giavang_tieude);
//        TXT_giavang_ngay = findViewById(R.id.txt_giavang_ngay);
//        //
//        mAdapter = new ViewgiavangAdapter(this);
//        viewPaperGiaVang = findViewById(R.id.viewPaperGiaVang);
//        mTabLayout = findViewById(R.id.tablayout);
//        viewPaperGiaVang.setAdapter(mAdapter);
        //
        IMG_giavang_back = findViewById(R.id.img_giavang_back);

        rcvGiavang = findViewById(R.id.rcv_giavang);
        giaVang_adapter = new GiaVang_Adapter(this);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcvGiavang.setLayoutManager(linearLayoutManager1);

        giaVang_adapter.setMgiavang(getList_giavang());
        rcvGiavang.setAdapter(giaVang_adapter);
    }

    private List<GiaVangModel> getList_giavang() {
        List<GiaVangModel> list = new ArrayList<>();
        list.add(new GiaVangModel("65.800.000","+ 50.000","+ 0,08%","66.600.000","+ 50.000","+ 0,08%"));
        list.add(new GiaVangModel("75.800.000","+ 50.000","+ 0,08%","66.200.000","+ 50.000","+ 0,08%"));
        list.add(new GiaVangModel("65.072.000","+ 50.000","+ 0,08%","66.400.000","+ 50.000","+ 0,08%"));
        list.add(new GiaVangModel("65.900.000","+ 50.000","+ 0,08%","66.600.000","+ 50.000","+ 0,08%"));
        list.add(new GiaVangModel("65.860.000","+ 50.000","+ 0,08%","50.600.000","+ 50.000","+ 0,08%"));
        list.add(new GiaVangModel("65.803.000","+ 50.000","+ 0,08%","58.600.000","+ 50.000","+ 0,08%"));

        return list;
    }
    //Hàm quay về màn hình trước
    public void backFromGiaVang(View view){
        Intent intent = new Intent(getApplicationContext(), taikhoan.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.layoutgiavang),"transition_taikhoan");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(giavang.this,pairs);
            startActivity(intent,options.toBundle());
        }else {
            startActivity(intent);
        }
    }
}