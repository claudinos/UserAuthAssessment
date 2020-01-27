package com.example.userauthenticationassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG= RegisterUser.class.getSimpleName();
    @BindView(R.id.input_Fname)
    TextInputEditText Fname;
    @BindView(R.id.input_lname)TextInputEditText Lname;
    @BindView(R.id.email1)TextInputEditText Email1;
    @BindView(R.id.password1)TextInputEditText passw1;
    @BindView(R.id.password2)TextInputEditText passw2;
    @BindView(R.id.btn_signup)
    Button Signup;
    @BindView(R.id.link_login)
    TextView login;
    DBHelper helper= new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        ButterKnife.bind(this);
        login.setOnClickListener(this);
        Signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==login){
            Intent intent=new Intent(RegisterUser.this,LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (v==Signup){
            String fname=Fname.getText().toString();
            String lname=Lname.getText().toString();
            String email=Email1.getText().toString();
            String pass1=passw1.getText().toString();
            String pass2=passw2.getText().toString();
            if (!pass1.equals(pass2)){
                //toast
                Toast.makeText(RegisterUser.this,"Passwords don't match",Toast.LENGTH_LONG).show();
            }else {
                Intent intent=new Intent(RegisterUser.this,Credentials.class);
                startActivity(intent);
                //insert in database
                Information information=new Information();
                information.setFname(fname);
                information.setLname(lname);
                information.setEmail(email);
                information.setPass(pass1);
                helper.insertInfo(information);
            }
        }

    }
}
