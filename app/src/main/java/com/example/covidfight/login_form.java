package com.example.covidfight;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_form extends AppCompatActivity {
    EditText txt_username,txt_passward;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        txt_username = findViewById(R.id.txt_username);
        txt_passward = findViewById(R.id.txt_passward);


        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = txt_username.getText().toString().trim();
                String passward = txt_passward.getText().toString().trim();

                if(TextUtils.isEmpty(username)){
                    Toast.makeText(login_form.this,"Please Enter username",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(passward)){
                    Toast.makeText(login_form.this,"Please Enter passward",Toast.LENGTH_SHORT).show();
                    return;
                }

                openhome();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup_form();
            }
        });
    }

    public void openhome() {
        Intent home = new Intent(this, home.class);
        startActivity(home);
    }
    public void opensignup_form() {
        Intent sign = new Intent(this, signup_form.class);
        startActivity(sign);
    }
}

