package com.example.newsapp.TaiKhoan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.newsapp.R;
import com.example.newsapp.TrangChu.taikhoan;

public class doimatkhau extends AppCompatActivity {

    ImageButton IMG_dmk_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doimatkhau);
        IMG_dmk_back = findViewById(R.id.img_dmk_back);
        IMG_dmk_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDMK = new Intent(getApplicationContext(), taikhoan.class);
                startActivity(intentDMK);
            }
        });
    }
    //Hàm quay về màn hình trước
//    public void backFromDMK(View view){
//
//         Intent intent = new Intent(getApplicationContext(), taikhoan.class);
//        Pair[] pairs = new Pair[1];
//        pairs[0] = new Pair<View, String>(findViewById(R.id.LayoutDMK),"transition_taikhoan");
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(doimatkhau.this,pairs);
//            startActivity(intent,options.toBundle());
//        }else {
//            startActivity(intent);
//        }
//    }
}