package com.example.covidfight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int SPLASH_TIME_OUT = 4000;
        new Handler().postDelayed(() -> {
            Intent homeintent = new Intent(MainActivity.this,login_form.class);
            startActivity(homeintent);
            finish();
        }, SPLASH_TIME_OUT);
    }
}
