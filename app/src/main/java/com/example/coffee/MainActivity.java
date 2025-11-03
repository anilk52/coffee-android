package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.example.coffee.ui.FavoritesActivity;
import com.example.coffee.ui.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);

        ImageButton btnFavorites = findViewById(R.id.btnFavorites);
        ImageButton btnSettings = findViewById(R.id.btnSettings);
        ImageButton btnAiBarista = findViewById(R.id.btnAiBarista);

        btnFavorites.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, FavoritesActivity.class);
            startActivity(i);
        });

        btnSettings.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        });

        btnAiBarista.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "AI Barista yakında burada ☕", Toast.LENGTH_SHORT).show()
        );
    }
}