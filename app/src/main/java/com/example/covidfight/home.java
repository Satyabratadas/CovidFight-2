package com.example.covidfight;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
public class home extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.extbutton).setOnClickListener(this);
    }
    private void socialdistance(){
        Intent social = new Intent(this, social_distance.class);
        startActivity(social);
    }
    private void awarness(){
        Intent awar = new Intent(this, awarness.class);
        startActivity(awar);
    }
    private void prediction(){
        Intent pre = new Intent(this, prediction.class);
        startActivity(pre);
    }
    private void darkside(){
        Intent dark = new Intent(this, darkside.class);
        startActivity(dark);
    }
    private void reminder(){
        Intent rem = new Intent(this, reminder.class);
        startActivity(rem);
    }
    private void logout(){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button5:
                socialdistance();
                break;
            case R.id.button6:
                awarness();
                break;
            case R.id.button7:
                prediction();
                break;
            case R.id.button8:
                darkside();
                break;
            case R.id.button9:
                reminder();
                break;
            case R.id.extbutton:
                logout();
                break;
        }
    }
}
