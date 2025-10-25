package com.example.coffee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.splashscreen.SplashScreen;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);

        try { Thread.sleep(1500); } catch (InterruptedException ignored) {}

        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}