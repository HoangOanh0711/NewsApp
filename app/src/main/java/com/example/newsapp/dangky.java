package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dangky extends AppCompatActivity {

    TextView btn_taiday;
    Button btn_dangky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        khaibao();

        btn_taiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangky.this, dangnhap.class);
                startActivity(intent);
                finish();
            }
        });

        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangky.this, trangchu.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void khaibao(){
        btn_taiday = findViewById(R.id.btn_taiday_dky);
        btn_dangky = findViewById(R.id.btn_dangky_dky);
    }
}