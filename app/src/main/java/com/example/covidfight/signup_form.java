package com.example.covidfight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signup_form extends AppCompatActivity implements View.OnClickListener {
    EditText txt_username,txt_email,txt_passward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        txt_username = findViewById(R.id.txt_username);
        txt_passward = findViewById(R.id.txt_passward);
        txt_email = findViewById(R.id.txt_email);
        findViewById(R.id.button3).setOnClickListener(this);

    }
    private void userSignup(){
        String username = txt_username.getText().toString().trim();
        String email = txt_email.getText().toString().trim();
        String passward = txt_passward.getText().toString().trim();
        if(TextUtils.isEmpty(username)){
            Toast.makeText(signup_form.this,"Please Enter Username",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(signup_form.this,"Please Enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passward)){
            Toast.makeText(signup_form.this,"Please Enter passward",Toast.LENGTH_SHORT).show();
        }
        Call<ResponseBody> call =RetrofitClient.getInstance().getApi().register(new RegisterRequest(username, email, passward));
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Log.d("signup_form","Response successful");
                Log.d("MainActivity", String.valueOf(response.code()));

            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
               // Toast.makeText(signup_form.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button3) {
            userSignup();
        }

    }
}
