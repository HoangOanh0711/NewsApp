package com.example.newsapp.TinTuc;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.newsapp.R;
import com.example.newsapp.TrangChu.tintuc;

import java.util.ArrayList;

public class tintuc_AdapterViewPaper extends FragmentStateAdapter {

    public tintuc_AdapterViewPaper(@NonNull tintuc fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new fg_moi();
            case 1:
                return new fg_thoisu();
            case 2:
                return new fg_thegioi();
            case 3:
                return new fg_phapluat();
            case 4:
                return new fg_bongda();
            case 5:
                return new fg_nhipsong();
            default:
                return new fg_moi();
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

}
