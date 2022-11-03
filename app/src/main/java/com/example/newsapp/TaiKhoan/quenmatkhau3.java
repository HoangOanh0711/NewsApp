package com.example.newsapp.TaiKhoan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.newsapp.R;

public class quenmatkhau3 extends AppCompatActivity {

    EditText ed_matkhau,ed_nhaplaimk;
    Button btn_capnhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quenmatkhau3);

        khaibao();

        btn_capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quenmatkhau3.this, quenmatkhau4.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void khaibao() {
        ed_matkhau = findViewById(R.id.ed_matkhau_quenmk);
        ed_nhaplaimk = findViewById(R.id.ed_nhaplaimatkhau_quenmk);

        btn_capnhat = findViewById(R.id.btn_capnhat);
    }
}