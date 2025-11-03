package com.example.coffee;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    // RecipeActivity içinde kullanılan sabit (dokunmuyoruz)
    public static final String EXTRA_CATEGORY = "com.example.coffee.CATEGORY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Uygulama varsayılan olarak aydınlık temada çalışsın
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_main);

        ImageButton btnFavorites = findViewById(R.id.btnFavorites);
        ImageButton btnAiBarista = findViewById(R.id.btnAiBarista);
        ImageButton btnSettings  = findViewById(R.id.btnSettings);

        if (btnFavorites != null) {
            btnFavorites.setOnClickListener(v ->
                    Toast.makeText(
                            MainActivity.this,
                            "Favoriler yakında burada ⭐",
                            Toast.LENGTH_SHORT
                    ).show()
            );
        }

        if (btnAiBarista != null) {
            btnAiBarista.setOnClickListener(v ->
                    Toast.makeText(
                            MainActivity.this,
                            "AI Barista yakında burada ☕",
                            Toast.LENGTH_SHORT
                    ).show()
            );
        }

        if (btnSettings != null) {
            btnSettings.setOnClickListener(v ->
                    Toast.makeText(
                            MainActivity.this,
                            "Ayarlar yakında burada ⚙️",
                            Toast.LENGTH_SHORT
                    ).show()
            );
        }
    }
}