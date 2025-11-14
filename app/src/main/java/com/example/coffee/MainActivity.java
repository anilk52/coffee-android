package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.ui.AiBaristaActivity;
import com.example.coffee.ui.FavoritesActivity;
import com.example.coffee.ui.RecipeActivity;
import com.example.coffee.ui.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    // Kategori kartları (CardView / LinearLayout vs olabilir, o yüzden View tuttuk)
    private View cardEspresso;
    private View cardFilter;
    private View cardSpecial;
    private View cardAlcohol;
    private View cardIced;
    private View cardTurkish;

    // Üst ikonlar
    private ImageView btnFavorites;
    private ImageView btnAiBarista;
    private ImageView btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kategori kartları
        cardEspresso = findViewById(R.id.cardEspresso);
        cardFilter   = findViewById(R.id.cardFilter);
        cardSpecial  = findViewById(R.id.cardSpecial);
        cardAlcohol  = findViewById(R.id.cardAlcohol);
        cardIced     = findViewById(R.id.cardIced);
        cardTurkish  = findViewById(R.id.cardTurkish);

        // Üst ikonlar
        btnFavorites = findViewById(R.id.btnFavorites);
        btnAiBarista = findViewById(R.id.btnAiBarista);
        btnSettings  = findViewById(R.id.btnSettings);

        // Kategori tıklamaları
        if (cardEspresso != null) {
            cardEspresso.setOnClickListener(v -> openCategory("espresso"));
        }
        if (cardFilter != null) {
            cardFilter.setOnClickListener(v -> openCategory("filter"));
        }
        if (cardSpecial != null) {
            cardSpecial.setOnClickListener(v -> openCategory("special"));
        }
        if (cardAlcohol != null) {
            cardAlcohol.setOnClickListener(v -> openCategory("alcohol"));
        }
        if (cardIced != null) {
            cardIced.setOnClickListener(v -> openCategory("iced"));
        }
        if (cardTurkish != null) {
            cardTurkish.setOnClickListener(v -> openCategory("turkish"));
        }

        // Favoriler
        if (btnFavorites != null) {
            btnFavorites.setOnClickListener(v -> {
                Intent favIntent = new Intent(MainActivity.this, FavoritesActivity.class);
                startActivity(favIntent);
            });
        }

        // AI Barista (genel, tarif seçmeden)
        if (btnAiBarista != null) {
            btnAiBarista.setOnClickListener(v -> {
                Intent aiIntent = new Intent(MainActivity.this, AiBaristaActivity.class);
                startActivity(aiIntent);
            });
        }

        // Ayarlar
        if (btnSettings != null) {
            btnSettings.setOnClickListener(v -> {
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
            });
        }
    }

    private void openCategory(String categoryKey) {
        Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
        intent.putExtra("category", categoryKey);
        startActivity(intent);
    }
}