package com.example.coffee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Görsel/tema üzerinden splash gösteriyoruz; layout gerekmiyor
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
