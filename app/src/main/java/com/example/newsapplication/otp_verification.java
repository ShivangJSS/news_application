package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.PhoneAuthCredential;

public class otp_verification extends AppCompatActivity {

EditText input1,input2,input3,input4,input5,input6;
String getotpback;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
Button verifyButtonClick=findViewById(R.id.btn2);
input1=findViewById(R.id.input1);
        input2=findViewById(R.id.input2);
        input3=findViewById(R.id.input3);
        input4=findViewById(R.id.input4);
        input5=findViewById(R.id.input5);
        input6=findViewById(R.id.input6);
        TextView textView=findViewById(R.id.txt);
        textView.setText(String.format(
                "+91", getIntent().getStringExtra("num")
        ));
        getotpback=getIntent().getStringExtra("backendotp");
        ProgressBar progressBar=findViewById(R.id.progress);
        verifyButtonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String enterCodeotp=input1.getText().toString()+input2.getText().toString()+input3.getText().toString()+input4.getText().toString()+input5.getText().toString()+input6.getText().toString();

           if(enterCodeotp!=null)
           {
             progressBar.setVisibility(View.VISIBLE);
             verifyButtonClick.setVisibility(View.INVISIBLE);
           }
               else {
               Toast.makeText(otp_verification.this, "check internet connection", Toast.LENGTH_SHORT).show();
           }
                if(input1.toString()=="")
                {
                    Toast.makeText(otp_verification.this, "please all numbers", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(otp_verification.this, "otp verify", Toast.LENGTH_SHORT).show();
                }
            }
        });
numberotpmove();
      

    }

    private void numberotpmove() {
        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
if (!s.toString().trim().isEmpty())
{

    input1.requestFocus();
}
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty())
                {

                    input2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty())
                {

                    input3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty())
                {

                    input4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty())
                {

                    input5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty())
                {

                    input6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}