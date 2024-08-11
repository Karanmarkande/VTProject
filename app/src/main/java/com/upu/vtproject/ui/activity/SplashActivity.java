package com.upu.vtproject.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.upu.vtproject.R;
import com.upu.vtproject.utils.PreferenceUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Handler obj = new Handler();
        // obj.postDelayed();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (PreferenceUtils.getString("is_loged_in", SplashActivity.this).equals("LogedIn")) {

                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 5000);
    }
}