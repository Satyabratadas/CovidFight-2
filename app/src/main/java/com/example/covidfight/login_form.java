package com.example.covidfight;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
    private void userLogin(){

        String username = txt_username.getText().toString().trim();
        String password = txt_password.getText().toString().trim();
        if(TextUtils.isEmpty(username)){
            Toast.makeText(login_form.this,"Please Enter username",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(login_form.this,"Please Enter password",Toast.LENGTH_SHORT).show();

        }
        Call<User> call =RetrofitClient.getInstance().getApi().login(new LoginRequest(username,  password));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    Toast.makeText(login_form.this, response.body().getToken(), Toast.LENGTH_SHORT).show();
                    token = response.body().getToken();
                    Intent sign = new Intent(login_form.this, home.class);
                    startActivity(sign);
                }
                else{
                    Toast.makeText(login_form.this, "login not correct", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(login_form.this,"error",Toast.LENGTH_LONG).show();

            }
        });

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

