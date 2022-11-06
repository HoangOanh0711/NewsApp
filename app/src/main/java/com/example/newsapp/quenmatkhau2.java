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
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsapp.TrangChu.ShowNotification;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.core.utilities.Pair;

import java.util.concurrent.TimeUnit;

public class quenmatkhau2 extends AppCompatActivity {

    Button btn_xacnhan;
    TextView btn_guilai, txt_sdt;
    EditText ed_otp1, ed_otp2, ed_otp3, ed_otp4, ed_otp5, ed_otp6, btn_taiday_quenmk, sdt;

    private static final String TAG = "PhoneAuthActivity";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private PhoneAuthProvider.ForceResendingToken forceResendingToken;

    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    //private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quenmatkhau2);
        mAuth = FirebaseAuth.getInstance();

        khaibao();
        setupOTPInput();

        txt_sdt.setText("Hãy điền OTP gồm 6 số vừa được gửi đến số điện thoại "+getIntent().getStringExtra("sdt"));
        mVerificationId = getIntent().getStringExtra("otp");

        /*btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                Log.d(TAG, "onCodeSent:" + verificationId);

                mVerificationId = verificationId;
                mResendToken = token;
            }

            @Override
            public void onClick(View view) {

                String otp = ed_otp1.getText().toString() +
                        ed_otp2.getText().toString() +
                        ed_otp3.getText().toString() +
                        ed_otp4.getText().toString() +
                        ed_otp5.getText().toString() +
                        ed_otp6.getText().toString();
                verifyCode(otp);
                //st_sdt = sdt.getText().toString().trim();
                *//*private void resendVerificationCode(String st_sdt,
                        PhoneAuthProvider.ForceResendingToken token) {
                    PhoneAuthOptions options =
                            PhoneAuthOptions.newBuilder(mAuth)
                                    .setPhoneNumber(st_sdt)
                                    .setTimeout(60L, TimeUnit.SECONDS)
                                    .setActivity(this)
                                    .setCallbacks(mCallbacks)
                                    .build();
                    PhoneAuthProvider.verifyPhoneNumber(options);
                }*//*
                Intent intent = new Intent(quenmatkhau2.this, quenmatkhau3.class);
                startActivity(intent);
                finish();
            }
        });*/

        btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed_otp1.getText().toString().isEmpty() ||
                        ed_otp2.getText().toString().isEmpty() ||
                        ed_otp3.getText().toString().isEmpty() ||
                        ed_otp4.getText().toString().isEmpty() ||
                        ed_otp5.getText().toString().isEmpty() ||
                        ed_otp6.getText().toString().isEmpty()) {
                    Toast.makeText(quenmatkhau2.this,"Nhập OTP đã được gửi qua số điện thoại",Toast.LENGTH_SHORT).show();
                    return;
                }
                String otp = ed_otp1.getText().toString() +
                        ed_otp2.getText().toString() +
                        ed_otp3.getText().toString() +
                        ed_otp4.getText().toString() +
                        ed_otp5.getText().toString() +
                        ed_otp6.getText().toString();
                if (mVerificationId!=null) {
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(mVerificationId, otp);
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(getApplicationContext(), quenmatkhau3.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            } else {
                                Toast.makeText(quenmatkhau2.this,"OTP sai, vui lòng nhập lại",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    });
                }
            }
        });


    }

    /*private void verifyCode(String code) {
        ShowNotification.showProgressDialog(quenmatkhau2.this, "Đang xác thực");
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
        signInWithPhoneAuthCredential(credential);
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        ShowNotification.dismissProgressDialog();
                        if (task.isSuccessful()) {
                            Log.d(TAG, "success");
                            FirebaseUser user = task.getResult().getUser();
                            ShowNotification.showAlertDialog(quenmatkhau2.this, "Thành công");
                        } else {
                            Log.w(TAG, "failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                ShowNotification.showAlertDialog(quenmatkhau2.this, "Lỗi");
                            }
                        }
                    }
                });
    }*/
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void setupOTPInput() {
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

    /*private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(PhoneAuthCredential credential) {
            Log.d(TAG, "onVerificationCompleted:" + credential);

            //tự động điền mã OTP
            ed_otp1.setText(credential.getSmsCode().substring(0,1));
            ed_otp2.setText(credential.getSmsCode().substring(1,2));
            ed_otp3.setText(credential.getSmsCode().substring(2,3));
            ed_otp4.setText(credential.getSmsCode().substring(3,4));
            ed_otp5.setText(credential.getSmsCode().substring(4,5));
            ed_otp6.setText(credential.getSmsCode().substring(5,6));

            verifyCode(credential.getSmsCode());
        }

        //fail
        @Override
        public void onVerificationFailed(FirebaseException e) {
            Log.w(TAG, "onVerificationFailed", e);
            ShowNotification.dismissProgressDialog();

            if (e instanceof FirebaseAuthInvalidCredentialsException) {
                ShowNotification.showAlertDialog(quenmatkhau2.this, "Request fail");
            } else if (e instanceof FirebaseTooManyRequestsException) {
                ShowNotification.showAlertDialog(quenmatkhau2.this, "Quota không đủ");
            }
        }

        *//*@Override
        public void onCodeSent(@NonNull String verificationId,
                               @NonNull PhoneAuthProvider.ForceResendingToken token) {
            Log.d(TAG, "onCodeSent:" + verificationId);
            ShowNotification.dismissProgressDialog();
            Toast.makeText(getApplicationContext(), "Đã gửi OTP", Toast.LENGTH_SHORT).show();
            mVerificationId = verificationId;
            mResendToken = token;
        }*//*
    };*/

    private void khaibao() {
        btn_xacnhan = findViewById(R.id.btn_xacnhan);
        btn_guilai = findViewById(R.id.btn_guilai_quenmk);
        ed_otp1 = findViewById(R.id.ed_otp1);
        ed_otp2 = findViewById(R.id.ed_otp2);
        ed_otp3 = findViewById(R.id.ed_otp3);
        ed_otp4 = findViewById(R.id.ed_otp4);
        ed_otp5 = findViewById(R.id.ed_otp5);
        ed_otp6 = findViewById(R.id.ed_otp6);
        txt_sdt = findViewById(R.id.txt_sdt_quenmk2);
    }
}