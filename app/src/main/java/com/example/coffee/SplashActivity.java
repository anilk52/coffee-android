package com.example.coffee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity {

    private static final long SPLASH_DURATION_MS = 2500L;

    private static final String[] GREETINGS = new String[]{
            "Selam Barista!",
            "Bugün hangi demleme? ☕",
            "Çekirdeği taze tut 🌱",
            "Oranlar hazır mı? 1:2!",
            "Basınç iyi, akış güzel!",
            "Krema harika görünüyor!",
            "Kokuyu aldın mı? 😌",
            "Isı sabit, tat kusursuz.",
            "Hadi kahve zamanı!",
            "bdinoᴼ Coffee ile daha lezzetli!"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Splash temasını Manifest’te verdik; şimdi layout’u basıyoruz
        setContentView(R.layout.activity_splash);

        ImageView imgLogo = findViewById(R.id.imgLogo);
        TextView txtGreeting = findViewById(R.id.txtGreeting);

        // Rastgele selamlama
        int idx = (int) (Math.random() * GREETINGS.length);
        txtGreeting.setText(GREETINGS[idx]);

        // Animasyonlar (res/anim içindeki fade_in ve slide_up)
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);

        imgLogo.startAnimation(fadeIn);
        txtGreeting.startAnimation(slideUp);

        // Zamanlayıp ana menüye geç
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, SPLASH_DURATION_MS);
    }
}