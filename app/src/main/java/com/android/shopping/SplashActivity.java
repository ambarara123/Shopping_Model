package com.android.shopping;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        preferences = getSharedPreferences("save", MODE_PRIVATE);

        boolean check = preferences.getBoolean("data", false);

        if (check) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        } else {


            //handler for delaying in splash
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this,
                            LoginActivity.class));
                    finish();
                }
            }, 2000);
        }
    }
}
