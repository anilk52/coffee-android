package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CardView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.ui.AiBaristaActivity;
import com.example.coffee.ui.FavoritesActivity;
import com.example.coffee.ui.RecipeActivity;
import com.example.coffee.ui.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY = "category";

    private CardView cardEspresso;
    private CardView cardFilter;
    private CardView cardSpecial;
    private CardView cardAlcohol;
    private CardView cardIced;
    private CardView cardTurkish;

    private ImageButton btnFavorites;
    private ImageButton btnSettings;
    private ImageButton btnAI;   // Ana ekrandaki AI tuşu

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

        // Üst butonlar
        btnFavorites = findViewById(R.id.btnFavorites);
        btnSettings  = findViewById(R.id.btnSettings);
        btnAI        = findViewById(R.id.btnAI);   // XML’deki AI ikonun id'si

        // Kategori tıklamaları → RecipeActivity
        cardEspresso.setOnClickListener(v -> openRecipeActivity("espresso"));
        cardFilter.setOnClickListener(v -> openRecipeActivity("filter"));
        cardSpecial.setOnClickListener(v -> openRecipeActivity("special"));
        cardAlcohol.setOnClickListener(v -> openRecipeActivity("alcohol"));
        cardIced.setOnClickListener(v -> openRecipeActivity("iced"));
        cardTurkish.setOnClickListener(v -> openRecipeActivity("turkish"));

        // Favoriler
        btnFavorites.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
            startActivity(intent);
        });

        // Ayarlar
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        // 🔮 ANA EKRAN AI BUTONU → GENEL MİLO SOHBETİ
        btnAI.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AiBaristaActivity.class);
            // Burada tarif bilgisi göndermiyoruz → MİLO genel kahve modu
            startActivity(intent);
        });
    }

    private void openRecipeActivity(String category) {
        Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
        intent.putExtra(EXTRA_CATEGORY, category);
        startActivity(intent);
    }
}