package com.example.newsapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class login_page extends AppCompatActivity {
EditText num;
EditText name;
Button btn1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        num=findViewById(R.id.mno);
        btn1=findViewById(R.id.btn1);
        name=findViewById(R.id.name);
        ProgressBar progress=findViewById(R.id.progress);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String p1 = name.getText().toString();
                if (p1.isEmpty() ){
                    Toast.makeText(login_page.this, "enter your name", Toast.LENGTH_SHORT).show();
                }
                String p2=num.getText().toString();
                if(p2.length()!=10)

                {
                    Toast.makeText(login_page.this, "enter the valid phone number", Toast.LENGTH_SHORT).show();
                }
                if(p2.length()==10)
                {
                    progress.setVisibility(View.VISIBLE);
                    btn1.setVisibility(View.INVISIBLE);
PhoneAuthProvider.getInstance().verifyPhoneNumber(
        "+91"+p2,
        60,
        TimeUnit.SECONDS,
        login_page.this,
        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                progress.setVisibility(View.VISIBLE);
                btn1.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                progress.setVisibility(View.VISIBLE);
                btn1.setVisibility(View.INVISIBLE);
                Toast.makeText(login_page.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                progress.setVisibility(View.VISIBLE);
                btn1.setVisibility(View.INVISIBLE);
                Intent intent=new Intent(login_page.this, otp_verification.class);
                intent.putExtra(String.valueOf(num),p2);
                intent.putExtra("backendotp",backendotp);
                startActivity(intent);

            }
        }

);



                }

            }
        });

    }
}