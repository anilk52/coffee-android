package com.example.coffee.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.coffee.R;

public class SettingsActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "bdino_prefs";
    private static final String KEY_HOME_MODE = "home_mode";      // true = Ev Modu, false = Kafe Modu
    private static final String KEY_DARK_MODE = "dark_mode";      // tema ayarı
    private static final String KEY_VOICE_GUIDE = "voice_guide";  // sesli rehber

    private Switch switchHomeMode;
    private Switch switchDarkMode;
    private Switch switchVoiceGuide;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        switchHomeMode   = findViewById(R.id.switchHomeMode);
        switchDarkMode   = findViewById(R.id.switchDarkMode);
        switchVoiceGuide = findViewById(R.id.switchVoiceGuide);

        if (switchHomeMode == null || switchDarkMode == null || switchVoiceGuide == null) {
            Toast.makeText(this, "Bazı ayar bileşenleri yüklenemedi.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kaydedilmiş değerleri yükle
        boolean isHomeMode   = prefs.getBoolean(KEY_HOME_MODE, true);
        boolean isDarkMode   = prefs.getBoolean(KEY_DARK_MODE, false);
        boolean isVoiceGuide = prefs.getBoolean(KEY_VOICE_GUIDE, false);

        switchHomeMode.setChecked(isHomeMode);
        switchDarkMode.setChecked(isDarkMode);
        switchVoiceGuide.setChecked(isVoiceGuide);

        // Ev / Kafe modu
        switchHomeMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean(KEY_HOME_MODE, isChecked).commit();
            String msg = isChecked ? "Ev modu aktif 🏠" : "Kafe modu aktif ☕";
            Toast.makeText(SettingsActivity.this, msg, Toast.LENGTH_SHORT).show();
        });

        // Koyu / Açık tema (anında uygular)
        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean(KEY_DARK_MODE, isChecked).commit();
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                Toast.makeText(this, "Koyu tema etkinleştirildi 🌙", Toast.LENGTH_SHORT).show();
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                Toast.makeText(this, "Açık tema etkinleştirildi ☀️", Toast.LENGTH_SHORT).show();
            }
        });

        // Sesli rehber (yakında)
        switchVoiceGuide.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean(KEY_VOICE_GUIDE, isChecked).commit();
            String msg = isChecked
                    ? "Sesli barista rehberi aktif (yakında)."
                    : "Sesli barista rehberi kapatıldı.";
            Toast.makeText(SettingsActivity.this, msg, Toast.LENGTH_SHORT).show();
        });
    }
}