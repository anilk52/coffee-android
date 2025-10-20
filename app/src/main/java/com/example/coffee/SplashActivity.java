package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY_MS = 5000L; // 5 sn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 5 sn sonra ana ekrana geç
        new Handler(Looper.getMainLooper()).postDelayed(this::goNext, SPLASH_DELAY_MS);

        // Ekrana dokununca hemen geç
        LinearLayout root = findViewById(R.id.splashRoot);
        if (root != null) root.setOnClickListener(v -> goNext());
    }

    private void goNext() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}