package com.example.covidfight;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login_form extends AppCompatActivity implements View.OnClickListener{
    EditText txt_username,txt_password;
    SessionManager session;

    String token;

    @SuppressLint("CutpasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        txt_username = findViewById(R.id.txt_username);
        txt_password = findViewById(R.id.txt_passward);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        session = new SessionManager(getApplicationContext());
    }
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
        Call<ResponseBody> call =RetrofitClient.getInstance().getApi().login(new LoginRequest(username, password));
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try {
                        assert response.body() != null;
                        token=response.body().string();
                        session.createLoginSession(token);
                        Intent i = new Intent(getApplicationContext(),home.class);
                        startActivity(i);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(login_form.this,"failed",Toast.LENGTH_LONG).show();
                }
                // Log.d("signup_form","Response successful");
                // Log.d("MainActivity", String.valueOf(response.code()));
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
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

