package com.example.coffee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.core.splashscreen.SplashScreen;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Android 12+ sistem splash (ikon/arka plan)
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);

        // "☕ Selam Barista!" metnini gösteren layout
        setContentView(R.layout.activity_splash);

        // Kısa bekleme sonrası ana ekrana geç
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 1500);
    }
}