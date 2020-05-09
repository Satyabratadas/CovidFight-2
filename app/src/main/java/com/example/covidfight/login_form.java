package com.example.covidfight;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login_form extends AppCompatActivity implements View.OnClickListener{
    EditText txt_username,txt_password;

    @SuppressLint("CutpasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        txt_username = findViewById(R.id.txt_username);
        txt_password = findViewById(R.id.txt_passward);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);


    }
    private static String token;
    private void userLogin() {

        String username = txt_username.getText().toString().trim();
        String password = txt_password.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(login_form.this, "Please Enter username", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(login_form.this, "Please Enter password", Toast.LENGTH_SHORT).show();

        }

    }




    private void usersign(){
        Intent sign = new Intent(this, signup_form.class);
        startActivity(sign);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                userLogin();
                break;
            case R.id.button2:
                usersign();
                break;

        }


    }
}

