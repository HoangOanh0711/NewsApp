package com.example.newsapp.TaiKhoan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.newsapp.R;

public class quenmatkhau2 extends AppCompatActivity {

    Button btn_xacnhan;
    EditText ed_otp1, ed_otp2, ed_otp3, ed_otp4, ed_otp5, ed_otp6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quenmatkhau2);

        khaibao();

        btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quenmatkhau2.this, quenmatkhau3.class);
                startActivity(intent);
                finish();
            }
        });

        ed_otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed_otp1.getText().toString().length()==1) {
                    ed_otp2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ed_otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed_otp2.getText().toString().length()==1) {
                    ed_otp3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ed_otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed_otp3.getText().toString().length()==1) {
                    ed_otp4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ed_otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed_otp4.getText().toString().length()==1) {
                    ed_otp5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ed_otp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed_otp5.getText().toString().length()==1) {
                    ed_otp6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void khaibao() {

        btn_xacnhan = findViewById(R.id.btn_xacnhan);
        ed_otp1 = findViewById(R.id.ed_otp1);
        ed_otp2 = findViewById(R.id.ed_otp2);
        ed_otp3 = findViewById(R.id.ed_otp3);
        ed_otp4 = findViewById(R.id.ed_otp4);
        ed_otp5 = findViewById(R.id.ed_otp5);
        ed_otp6 = findViewById(R.id.ed_otp6);
    }
}