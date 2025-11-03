package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    // Kategoriyi diğer activity'ye taşımak için sabit tanım
    public static final String EXTRA_CATEGORY = "com.example.coffee.CATEGORY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Üst menü ikonları
        ImageButton btnFavorites = findViewById(R.id.btnFavorites);
        ImageButton btnSettings = findViewById(R.id.btnSettings);
        ImageButton btnAiBarista = findViewById(R.id.btnAiBarista);

        // AI Barista tıklama
        btnAiBarista.setOnClickListener(v -> {
            Intent aiIntent = new Intent(MainActivity.this, AiBaristaActivity.class);
            startActivity(aiIntent);
        });

        // Ayarlar tıklama
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        // Favoriler tıklama
        btnFavorites.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
            startActivity(intent);
        });

        // Kategori kartlarını başlat
        initCategoryClick(R.id.cardEspresso, "Espresso");
        initCategoryClick(R.id.cardFilter, "Filter");
        initCategoryClick(R.id.cardSpecial, "Special");
        initCategoryClick(R.id.cardAlcoholic, "Alcoholic");
        initCategoryClick(R.id.cardIced, "Iced");
        initCategoryClick(R.id.cardTurkish, "Turkish");
    }

    // Tekrarlayan tıklama işlemleri için yardımcı metot
    private void initCategoryClick(int viewId, String categoryName) {
        View card = findViewById(viewId);
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
                intent.putExtra(EXTRA_CATEGORY, categoryName);
                startActivity(intent);
            });
        }
    }
}