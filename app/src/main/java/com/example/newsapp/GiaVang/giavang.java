package com.example.newsapp.GiaVang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.R;
import com.example.newsapp.TrangChu.taikhoan;
import com.google.android.material.tabs.TabLayout;

public class giavang extends AppCompatActivity {
//    TextView TXT_giavang_tieude, TXT_giavang_ngay;
//    private ViewgiavangAdapter mAdapter;
//    private ViewPager2 viewPaperGiaVang;
//    private TabLayout mTabLayout;
//    private int[] mTabTitles = new int[]{R.string.loai, R.string.mua, R.string.ban}
    ImageView IMG_giavang_back;
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
    }
    //Hàm quay về màn hình trước
    public void backFromGiaVang(View view){

        Intent intent = new Intent(getApplicationContext(), taikhoan.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.layoutgiavang),"transition_taikhoan");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(giavang.this,pairs);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            startActivity(intent,options.toBundle());
        }else {
            startActivity(intent);
        }
    }
}