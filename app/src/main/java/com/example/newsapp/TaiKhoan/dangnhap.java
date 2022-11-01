package com.example.newsapp.TaiKhoan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsapp.R;
import com.example.newsapp.TrangChu.trangchu;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

public class dangnhap extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance()
            .getReferenceFromUrl("https://newsapp-a5dc3-default-rtdb.firebaseio.com/");

    TextView btn_quenmk,btn_taiday;
    Button btn_dangnhap;
    EditText sdt,matkhau;
    String st_sdt, st_matkhau;
    CountryCodePicker countryCodePicker;
    ImageView img_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        khaibao();

        //kiểm tra định dạng số điện thoại ở từng quốc gia
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
                gangiatri();
                databaseReference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChild(st_sdt)) {
                            final String getMatkhau = snapshot.child(st_sdt).child("Mật khẩu").getValue(String.class);
                            Log.e("hi",getMatkhau);
                            if (getMatkhau.equals(st_matkhau)) {
                                Intent intent = new Intent(dangnhap.this, trangchu.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(dangnhap.this, "Sai mật khẩu", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(dangnhap.this, "Số điện thoại không tồn tại", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(dangnhap.this, "Lỗi", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void khaibao(){
        btn_quenmk = findViewById(R.id.btn_quenmatkhau);
        btn_taiday = findViewById(R.id.btn_taiday_dnhap);
        btn_dangnhap = findViewById(R.id.btn_dangnhap_dnhap);

        sdt = findViewById(R.id.ed_sdt_dnhap);
        matkhau = findViewById(R.id.ed_matkhau_dnhap);

        img_check = findViewById(R.id.img_check_dnhap);
        countryCodePicker = findViewById(R.id.ccp_dnhap);
    }

    private void gangiatri() {
        st_sdt = sdt.getText().toString().trim();
        st_matkhau = matkhau.getText().toString().trim();
    }
}