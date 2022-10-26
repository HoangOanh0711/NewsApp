package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Thread td = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(splash.this,dangnhap.class);
                    startActivity(intent);
                }
            }
        };td.start();

    }
}