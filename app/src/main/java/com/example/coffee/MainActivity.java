package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.coffee.ui.AiBaristaActivity;
import com.example.coffee.ui.FavoritesActivity;
import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY = "category";

    private CardView cardEspresso, cardFilter, cardSpecial, cardAlcohol, cardIced, cardTurkish;
    private CardView cardFrappe, cardSmoothie; // ➕ YENİ KARTLAR

    private ImageButton btnFavorites, btnAI, btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kart bağlantıları
        cardEspresso = findViewById(R.id.cardEspresso);
        cardFilter   = findViewById(R.id.cardFilter);
        cardSpecial  = findViewById(R.id.cardSpecial);
        cardAlcohol  = findViewById(R.id.cardAlcohol);
        cardIced     = findViewById(R.id.cardIced);
        cardTurkish  = findViewById(R.id.cardTurkish);

        cardFrappe   = findViewById(R.id.cardFrappe);     // ➕
        cardSmoothie = findViewById(R.id.cardSmoothie);   // ➕


        btnFavorites = findViewById(R.id.btnFavorites);
        btnAI        = findViewById(R.id.btnAI);
        btnSettings  = findViewById(R.id.btnSettings);

        // Kategori tıklamaları
        View.OnClickListener categoryClickListener = v -> {
            String category;

            int id = v.getId();
            if (id == R.id.cardEspresso)       category = "espresso";
            else if (id == R.id.cardFilter)    category = "filter";
            else if (id == R.id.cardSpecial)   category = "special";
            else if (id == R.id.cardAlcohol)   category = "alcoholic";
            else if (id == R.id.cardIced)      category = "iced";
            else if (id == R.id.cardTurkish)   category = "turkish";
            else if (id == R.id.cardFrappe)    category = "frappe";     // ➕
            else                                category = "smoothie";   // ➕

            Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
            intent.putExtra(EXTRA_CATEGORY, category);
            startActivity(intent);
        };

        cardEspresso.setOnClickListener(categoryClickListener);
        cardFilter.setOnClickListener(categoryClickListener);
        cardSpecial.setOnClickListener(categoryClickListener);
        cardAlcohol.setOnClickListener(categoryClickListener);
        cardIced.setOnClickListener(categoryClickListener);
        cardTurkish.setOnClickListener(categoryClickListener);
        cardFrappe.setOnClickListener(categoryClickListener);     // ➕
        cardSmoothie.setOnClickListener(categoryClickListener);   // ➕

        // Üst ikonlar
        btnFavorites.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, FavoritesActivity.class)));

        btnAI.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, AiBaristaActivity.class)));

        btnSettings.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Ayarlar yakında eklenecek.", Toast.LENGTH_SHORT).show());
    }
}