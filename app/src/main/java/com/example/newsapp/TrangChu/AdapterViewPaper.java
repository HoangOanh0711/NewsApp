package com.example.newsapp.TrangChu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class AdapterViewPaper extends FragmentStateAdapter {
    ArrayList<Fragment> arr;
    public AdapterViewPaper(@NonNull FragmentActivity fragmentActivity, ArrayList<Fragment> arr) {
        super(fragmentActivity);
        this.arr=arr;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return arr.get(position);
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }
}
