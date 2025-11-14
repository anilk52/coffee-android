package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.ui.AiBaristaActivity;
import com.example.coffee.ui.RecipeActivity;
import com.example.coffee.ui.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    // RecipeActivity için kategori anahtarı
    public static final String EXTRA_CATEGORY = "extra_category";

    // Kategori kartları
    private View cardEspresso;
    private View cardFilter;
    private View cardSpecial;
    private View cardIced;
    private View cardTurkish;
    // Alkollü kartı için ID'yi bilmediğimiz için şimdilik çıkardım (cardAlcohol vs.)

    // Üst ikonlar
    // Favoriler ID'si de net olmadığı için şimdilik yok
    private ImageView btnAiBarista;
    private ImageView btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kategori kartlarını bağla
        cardEspresso = findViewById(R.id.cardEspresso);
        cardFilter   = findViewById(R.id.cardFilter);
        cardSpecial  = findViewById(R.id.cardSpecial);
        cardIced     = findViewById(R.id.cardIced);
        cardTurkish  = findViewById(R.id.cardTurkish);
        // cardAlcohol / cardAlcoholic gibi bir ID varsa, layout'u görünce ekleriz

        // Üst ikonlar
        btnAiBarista = findViewById(R.id.btnAiBarista);
        btnSettings  = findViewById(R.id.btnSettings);
        // btnFavorites = findViewById(R.id.btnFavorites); // ID hatalı olduğu için şimdilik kullanmıyoruz

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
        if (cardIced != null) {
            cardIced.setOnClickListener(v -> openCategory("iced"));
        }
        if (cardTurkish != null) {
            cardTurkish.setOnClickListener(v -> openCategory("turkish"));
        }
        // Alkollü kategori: ID'yi bildiğimizde buraya ekleriz

        // AI Barista (genel ekran)
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
        intent.putExtra(EXTRA_CATEGORY, categoryKey);
        startActivity(intent);
    }
}