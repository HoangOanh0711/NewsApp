package com.example.newsapp.TrangChu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.newsapp.R;
import com.example.newsapp.TrangChu.AdapterViewPaper;
import com.example.newsapp.TrangChu.taikhoan;
import com.example.newsapp.TrangChu.tintuc;
import com.example.newsapp.TrangChu.xuhuong;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class trangchu extends AppCompatActivity {

    ViewPager2 viewPager;
    BottomNavigationView bottomNavigationView;

    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);

        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navi);

        fragmentArrayList.add(new tintuc());
        fragmentArrayList.add(new xuhuong());
        fragmentArrayList.add(new taikhoan());

        AdapterViewPaper viewPaperAdapter = new AdapterViewPaper(this, fragmentArrayList);
        viewPager.setAdapter(viewPaperAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.nav_tintuc);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.nav_xuhuong);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.nav_taikhoan);
                        break;
                }
                super.onPageSelected(position);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_tintuc:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.nav_xuhuong:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.nav_taikhoan:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }
}