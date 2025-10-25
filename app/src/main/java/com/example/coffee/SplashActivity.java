package com.example.coffee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Android 12+ SplashScreen API
import androidx.core.splashscreen.SplashScreen;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Android 12+ için SplashScreen'i uygula (temayla eşleşir)
        SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);

        // Herhangi bir iş/animasyon beklemiyorsak direkt Main'e geç
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
