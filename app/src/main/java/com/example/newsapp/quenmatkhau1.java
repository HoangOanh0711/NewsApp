package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
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

import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.utilities.Pair;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class quenmatkhau1 extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance()
            .getReferenceFromUrl("https://newsapp-a5dc3-default-rtdb.firebaseio.com/");
    FirebaseAuth auth = FirebaseAuth.getInstance();
    TextView btn_taiday;
    private Button btn_guiotp;

    private EditText sdt;
    private String st_sdt;


    CountryCodePicker countryCodePicker;
    ImageView img_check;

    private static final String TAG = "PhoneAuthActivity";

    private FirebaseAuth mAuth;

    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;



    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

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

        mAuth = FirebaseAuth.getInstance();
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                Log.d(TAG, "onVerificationCompleted:" + credential);

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Log.w(TAG, "onVerificationFailed", e);

                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                } else if (e instanceof FirebaseTooManyRequestsException) {
                }

            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                Log.d(TAG, "onCodeSent:" + verificationId);

                mVerificationId = verificationId;
                mResendToken = token;
            }
        };


        btn_guiotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st_sdt = sdt.getText().toString().trim();
                    PhoneAuthOptions options =
                            PhoneAuthOptions.newBuilder(mAuth)
                                    .setPhoneNumber(st_sdt)
                                    .setTimeout(60L, TimeUnit.SECONDS)
                                    //.setActivity(this)
                                    //.setCallbacks(mCallbacks)
                                    .build();
                    PhoneAuthProvider.verifyPhoneNumber(options);
                
                Intent intent = new Intent(quenmatkhau1.this, quenmatkhau2.class);
                startActivity(intent);
                finish();
            }
        });


    }
}