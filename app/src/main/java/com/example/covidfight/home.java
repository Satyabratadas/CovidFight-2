package com.example.covidfight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensocial_distance();
            }
        });
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openawarness();
            }
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openprediction();
            }
        });
        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendarkside();
            }
        });
        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennotification();
            }
        });
        Button extbutton = findViewById(R.id.extbutton);
        extbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
    public void opensocial_distance() {
        Intent social = new Intent(this, social_distance.class);
        startActivity(social);
    }
    public void openawarness() {
        Intent awar = new Intent(this, awarness.class);
        startActivity(awar);
    }

    public void openprediction() {
        Intent pre = new Intent(this, prediction.class);
        startActivity(pre);
    }
    public void opendarkside() {
        Intent dark = new Intent(this, darkside.class);
        startActivity(dark);
    }
    public void opennotification() {
        Intent notify = new Intent(this, reminder.class);
        startActivity(notify);
    }


}
