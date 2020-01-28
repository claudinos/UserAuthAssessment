package com.example.userauthenticationassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Credentials extends AppCompatActivity {
    @BindView(R.id.EmailView)
    TextView email;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credentials);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String Email=intent.getStringExtra("name");
        email.setText("Your Email is "+ Email);
        helper=new DBHelper(this);
        Cursor cursor=helper.alldata();
        if (cursor.getCount()==0){
            Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                Toast.makeText(getApplicationContext(), "id "+cursor.getString(0), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "First Name "+cursor.getString(1), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Last name "+cursor.getString(2), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Email "+cursor.getString(3), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Password "+cursor.getString(4), Toast.LENGTH_SHORT).show();
            }
        }

    }
}
