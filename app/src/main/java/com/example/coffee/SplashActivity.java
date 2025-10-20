package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 5 sn sonra veya dokununca Main'e geç
        findViewById(R.id.splash_root).setOnClickListener(v -> goNext());
        new Handler().postDelayed(this::goNext, 5000);
    }

    private void goNext() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}