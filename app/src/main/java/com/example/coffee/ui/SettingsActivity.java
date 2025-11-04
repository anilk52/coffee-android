package com.example.coffee.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;

public class SettingsActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "bdino_prefs";
    private static final String KEY_HOME_MODE = "home_mode";      // true = Ev Modu, false = Kafe Modu
    private static final String KEY_DARK_MODE = "dark_mode";      // ileride tema için
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

        // Kaydedilmiş değerleri yükle
        boolean isHomeMode   = prefs.getBoolean(KEY_HOME_MODE, true);
        boolean isDarkMode   = prefs.getBoolean(KEY_DARK_MODE, false);
        boolean isVoiceGuide = prefs.getBoolean(KEY_VOICE_GUIDE, false);

        switchHomeMode.setChecked(isHomeMode);
        switchDarkMode.setChecked(isDarkMode);
        switchVoiceGuide.setChecked(isVoiceGuide);

        // Ev / Kafe modu
        switchHomeMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean(KEY_HOME_MODE, isChecked).apply();
            String msg = isChecked ? "Ev modu aktif 🏠" : "Kafe modu aktif ☕";
            Toast.makeText(SettingsActivity.this, msg, Toast.LENGTH_SHORT).show();
        });

        // Koyu / Açık tema (şimdilik sadece kayıt + uyarı)
        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean(KEY_DARK_MODE, isChecked).apply();
            String msg = isChecked
                    ? "Koyu tema ayarı kaydedildi. Tema ileride buradan yönetilecek."
                    : "Açık tema ayarı kaydedildi.";
            Toast.makeText(SettingsActivity.this, msg, Toast.LENGTH_SHORT).show();
        });

        // Sesli rehber
        switchVoiceGuide.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean(KEY_VOICE_GUIDE, isChecked).apply();
            String msg = isChecked
                    ? "Sesli barista rehberi açıldı (yakında)."
                    : "Sesli barista rehberi kapatıldı.";
            Toast.makeText(SettingsActivity.this, msg, Toast.LENGTH_SHORT).show();
        });
    }
}