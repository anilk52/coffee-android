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

    private CardView cardEspresso;
    private CardView cardFilter;
    private CardView cardSpecial;
    private CardView cardAlcohol;
    private CardView cardIced;
    private CardView cardTurkish;

    private ImageButton btnFavorites;
    private ImageButton btnAI;
    private ImageButton btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kartlar
        cardEspresso = findViewById(R.id.cardEspresso);
        cardFilter   = findViewById(R.id.cardFilter);
        cardSpecial  = findViewById(R.id.cardSpecial);
        cardAlcohol  = findViewById(R.id.cardAlcohol);
        cardIced     = findViewById(R.id.cardIced);
        cardTurkish  = findViewById(R.id.cardTurkish);

        // Üst ikonlar
        btnFavorites = findViewById(R.id.btnFavorites);
        btnAI        = findViewById(R.id.btnAI);
        btnSettings  = findViewById(R.id.btnSettings);

        // Kategori tıklamaları
        View.OnClickListener categoryClickListener = v -> {
            String category;

            int id = v.getId();
            if (id == R.id.cardEspresso) {
                category = "espresso";
            } else if (id == R.id.cardFilter) {
                category = "filter";
            } else if (id == R.id.cardSpecial) {
                category = "special";
            } else if (id == R.id.cardAlcohol) {
                category = "alcoholic";
            } else if (id == R.id.cardIced) {
                category = "iced";
            } else {
                category = "turkish";
            }

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

        // Favoriler
        btnFavorites.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
            startActivity(intent);
        });

        // AI Barista
        btnAI.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AiBaristaActivity.class);
            startActivity(intent);
        });

        // Ayarlar (şimdilik placeholder)
        btnSettings.setOnClickListener(v ->
                Toast.makeText(MainActivity.this,
                        "Ayarlar yakında eklenecek.",
                        Toast.LENGTH_SHORT
                ).show()
        );
    }
}