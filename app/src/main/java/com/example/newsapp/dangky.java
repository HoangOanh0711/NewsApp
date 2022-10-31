package com.example.newsapp;

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

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

import java.util.Arrays;

public class dangky extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance()
            .getReferenceFromUrl("https://newsapp-a5dc3-default-rtdb.firebaseio.com/");

    TextView btn_taiday;
    Button btn_dangky;
    EditText sdt,ten,matkhau,nhaplaimk;
    String st_sdt, st_ten, st_matkhau, st_nhaplaimk;

    CountryCodePicker countryCodePicker;
    ImageView img_check;
    ImageView imageView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        FacebookSdk.sdkInitialize(getApplicationContext());

        khaibao();
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
                /*Intent intent = new Intent(dangky.this, dangnhap.class);
                startActivity(intent);
                finish();*/
            }
        });

        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gangiatri();
                if (ktra()) {
                    databaseReference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(st_sdt)) {
                                Toast.makeText(dangky.this, "Số điện thoại đã được đăng ký", Toast.LENGTH_SHORT).show();
                            } else {
                                databaseReference.child("Users").child(st_sdt).child("Tên người dùng").setValue(st_ten);
                                databaseReference.child("Users").child(st_sdt).child("Mật khẩu").setValue(st_matkhau);
                                databaseReference.child("Users").child(st_sdt).child("Số điện thoại").setValue(st_sdt);

                                Intent intent = new Intent(dangky.this, dangnhap.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(dangky.this, "Lỗi", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

        imageView5 = findViewById(R.id.imageView5);


        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(dangky.this, Arrays.asList("public_profile"));
                Intent intent = new Intent(dangky.this, Facebook.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }
        });
    }



    private void gangiatri() {
        st_sdt = "+" + countryCodePicker.getFullNumber();
        st_ten = ten.getText().toString().trim();
        st_matkhau = matkhau.getText().toString().trim();
        st_nhaplaimk = nhaplaimk.getText().toString().trim();
    }

    private void khaibao(){
        btn_taiday = findViewById(R.id.btn_taiday_dky);
        btn_dangky = findViewById(R.id.btn_dangky_dky);

        sdt = findViewById(R.id.ed_sdt_dky);
        ten = findViewById(R.id.ed_ten_dky);
        matkhau = findViewById(R.id.ed_matkhau_dky);
        nhaplaimk = findViewById(R.id.ed_nhaplaimatkhau_dky);

        img_check = findViewById(R.id.img_check_dky);
        countryCodePicker = findViewById(R.id.ccp_dky);
    }

    private boolean ktra() {
        if (st_matkhau.isEmpty()) {
            Toast.makeText(this, "Mật khẩu đang để trống", Toast.LENGTH_SHORT).show();
            return false;
        } if (st_matkhau.length()<5) {
            Toast.makeText(this, "Mật khẩu quá ngắn", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!st_matkhau.equals(st_nhaplaimk)) {
            Toast.makeText(this, "Mật khẩu khác nhau", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
}