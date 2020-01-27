package com.example.userauthenticationassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Credentials extends AppCompatActivity {
    @BindView(R.id.EmailView)
    TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credentials);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String Email=intent.getStringExtra("name");
        email.setText("Your Email is "+ Email);
    }
}
