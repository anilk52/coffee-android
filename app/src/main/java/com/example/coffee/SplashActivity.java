package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.imgLogo);
        TextView fallback = findViewById(R.id.txtFallback);

        // drawable/logo_bdino varsa kullan; yoksa metin kalsın
        int resId = getResources().getIdentifier("logo_bdino", "drawable", getPackageName());
        if (resId != 0) {
            logo.setImageResource(resId);
            fallback.setVisibility(View.GONE);
        } else {
            fallback.setVisibility(View.VISIBLE);
        }

        // 1.2 saniye sonra ana ekrana geç
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 1200);
    }
}