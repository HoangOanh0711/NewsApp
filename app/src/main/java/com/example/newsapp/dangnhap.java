package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dangnhap extends AppCompatActivity {

    TextView btn_quenmk,btn_taiday;
    Button btn_dangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        khaibao();

        btn_quenmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap.this, quenmatkhau1.class);
                startActivity(intent);
                finish();
            }
        });

        btn_taiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap.this, dangky.class);
                startActivity(intent);
                finish();
            }
        });

        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap.this, trangchu.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void khaibao(){
        btn_quenmk = findViewById(R.id.btn_quenmatkhau);
        btn_taiday = findViewById(R.id.btn_taiday_dnhap);
        btn_dangnhap = findViewById(R.id.btn_dangnhap_dnhap);
    }
}