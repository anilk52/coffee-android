package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private boolean jumped = false; // çift geçişi önlemek için

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 5 sn sonra menüye geç
        new Handler(Looper.getMainLooper()).postDelayed(this::goNext, 5000);

        // Dokununca hemen geç
        findViewById(R.id.splash_root).setOnClickListener(v -> goNext());
    }

    private void goNext() {
        if (jumped || isFinishing()) return;
        jumped = true;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
