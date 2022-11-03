package com.example.newsapp.TaiKhoan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.R;
import com.hbb20.CountryCodePicker;

public class quenmatkhau1 extends AppCompatActivity {

    TextView btn_taiday;
    Button btn_guiotp;

    EditText sdt;

    CountryCodePicker countryCodePicker;
    ImageView img_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quenmatkhau1);

        btn_taiday = findViewById(R.id.btn_taiday_quenmk);
        btn_guiotp = findViewById(R.id.btn_guiotp);
        sdt = findViewById(R.id.ed_sdt_quenmk);
        img_check = findViewById(R.id.img_check_quenmk);
        countryCodePicker = findViewById(R.id.ccp_quenmk);

        countryCodePicker.registerCarrierNumberEditText(sdt);
        countryCodePicker.setPhoneNumberValidityChangeListener(new CountryCodePicker.PhoneNumberValidityChangeListener() {
            @Override
            public void onValidityChanged(boolean isValidNumber) {
                if (isValidNumber) {
                    img_check.setImageResource(R.drawable.ic_checkok);
                } else {
                    img_check.setImageResource(R.drawable.ic_checkx);
                }
            }
        });
        sdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String input = editable.toString().trim();
                if (input.length() > 0) {
                    img_check.setVisibility(View.VISIBLE);
                } else {
                    img_check.setVisibility(View.GONE);
                }
            }
        });

        btn_taiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quenmatkhau1.this, dangnhap.class);
                startActivity(intent);
                finish();
            }
        });

        btn_guiotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quenmatkhau1.this, quenmatkhau2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}