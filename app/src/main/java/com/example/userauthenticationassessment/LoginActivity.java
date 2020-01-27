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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.email2)
    TextInputEditText email2;
    @BindView(R.id.password2)TextInputEditText pass2;
    @BindView(R.id.btn_login)
    Button Login;
    @BindView(R.id.signup)
    TextView signup;
    DBHelper helper=new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        signup.setOnClickListener(this);
        Login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==signup){
            Intent intent=new Intent(LoginActivity.this,RegisterUser.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (v==Login){
            String email=email2.getText().toString();
            String pass=pass2.getText().toString();

            String Password=helper.searchPass(email);
            if (pass.equals(Password)){
                Intent intent=new Intent(LoginActivity.this,Credentials.class);
                intent.putExtra("name",email);
                Toast.makeText(LoginActivity.this,email,Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
            else {
                Toast.makeText(LoginActivity.this,"Username and Pasword Don't match",Toast.LENGTH_LONG).show();
            }
        }
    }
}
