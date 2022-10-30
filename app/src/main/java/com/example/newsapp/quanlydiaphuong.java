package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newsapp.Thoitiet.thoitiet;

public class quanlydiaphuong extends AppCompatActivity {
    LinearLayout btn_themdiaphuong;
    ImageView btn_quaylai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlydiaphuong);

        khaibao();

        btn_themdiaphuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quanlydiaphuong.this,chonthanhpho.class);
                startActivity(intent);
            }
        });

        btn_quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quanlydiaphuong.this, thoitiet.class);
                startActivity(intent);
            }
        });
    }

    private void khaibao() {
        btn_themdiaphuong = findViewById(R.id.btn_themdiaphuong);
        btn_quaylai = findViewById(R.id.img_quaylai_quanlydiaphuong);
    }
}