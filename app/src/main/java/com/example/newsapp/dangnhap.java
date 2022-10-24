package com.example.newsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class dangnhap extends AppCompatActivity {

    TextView btn_quenmk,btn_taiday;
    Button btn_dangnhap;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView btn_signin_gg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        khaibao();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);



        if (account != null)
        {
            Log.e("Account", account.getEmail());
            navigateNext();
        }

        btn_signin_gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
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
                Intent intent = new Intent(dangnhap.this, trangchu.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void signIn ()
    {
        Intent signIntent = gsc.getSignInIntent();
        startActivityForResult(signIntent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000)
        {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateNext();
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
    }

    private void navigateNext()
    {
        finish();
        Intent intentNext = new Intent(dangnhap.this, trangchu.class);
        startActivity(intentNext);
    }

    private void khaibao(){
        btn_signin_gg = findViewById(R.id.imageView4);
        btn_quenmk = findViewById(R.id.btn_quenmatkhau);
        btn_taiday = findViewById(R.id.btn_taiday_dnhap);
        btn_dangnhap = findViewById(R.id.btn_dangnhap_dnhap);
    }
}