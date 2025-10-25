package com.example.coffee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.core.splashscreen.SplashScreen;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Android 12+ native splash
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Sadece "☕ Selam Barista!" yazısını fade-in yap
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        TextView txtHello = findViewById(R.id.txtHello);
        if (txtHello != null) txtHello.startAnimation(fadeIn);

        // 1.5 sn sonra ana ekrana geç
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 1500);
    }
}