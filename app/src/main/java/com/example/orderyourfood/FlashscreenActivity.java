package com.example.orderyourfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;



public class FlashscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView appname;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashscreen);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(FlashscreenActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);

        appname=findViewById(R.id.name);
        appname.animate().scaleYBy(0.8f).scaleXBy(0.8f).alpha(1).setDuration(1000);
    }
}