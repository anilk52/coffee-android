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

    // 9 kategori kartı
    private CardView cardEspresso;
    private CardView cardFilter;
    private CardView cardLatteLab;
    private CardView cardIced;
    private CardView cardTurkish;
    private CardView cardAlcoholic;
    private CardView cardFrappe;
    private CardView cardSignature;
    private CardView cardBrewGuide;

    // Üst ikonlar
    private ImageButton btnFavorites;
    private ImageButton btnAI;
    private ImageButton btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kartları bağla
        cardEspresso   = findViewById(R.id.cardEspresso);
        cardFilter     = findViewById(R.id.cardFilter);
        cardLatteLab   = findViewById(R.id.cardLatteLab);
        cardIced       = findViewById(R.id.cardIced);
        cardTurkish    = findViewById(R.id.cardTurkish);
        cardAlcoholic  = findViewById(R.id.cardAlcoholic);
        cardFrappe     = findViewById(R.id.cardFrappe);
        cardSignature  = findViewById(R.id.cardSignature);
        cardBrewGuide  = findViewById(R.id.cardBrewGuide);

        // Üst ikonlar
        btnFavorites = findViewById(R.id.btnFavorites);
        btnAI        = findViewById(R.id.btnAI);
        btnSettings  = findViewById(R.id.btnSettings);

        // Kategori tıklama listener'ı
        View.OnClickListener categoryClickListener = v -> {
            String category;

            int id = v.getId();
            if (id == R.id.cardEspresso) {
                category = "espresso";
            } else if (id == R.id.cardFilter) {
                category = "filter";
            } else if (id == R.id.cardLatteLab) {
                // Şimdilik eski "special" datasını kullanıyoruz,
                // sonra Latte Lab içeriğini ayıracağız.
                category = "special";
            } else if (id == R.id.cardIced) {
                category = "iced";
            } else if (id == R.id.cardTurkish) {
                category = "turkish";
            } else if (id == R.id.cardAlcoholic) {
                category = "alcoholic";
            } else if (id == R.id.cardFrappe) {
                category = "frappe";
            } else if (id == R.id.cardSignature) {
                category = "signature";
            } else {
                category = "brew_guide";
            }

            Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
            intent.putExtra(EXTRA_CATEGORY, category);
            startActivity(intent);
        };

        // Listener'ları bağla
        cardEspresso.setOnClickListener(categoryClickListener);
        cardFilter.setOnClickListener(categoryClickListener);
        cardLatteLab.setOnClickListener(categoryClickListener);
        cardIced.setOnClickListener(categoryClickListener);
        cardTurkish.setOnClickListener(categoryClickListener);
        cardAlcoholic.setOnClickListener(categoryClickListener);
        cardFrappe.setOnClickListener(categoryClickListener);
        cardSignature.setOnClickListener(categoryClickListener);
        cardBrewGuide.setOnClickListener(categoryClickListener);

        // Favoriler butonu
        btnFavorites.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
            startActivity(intent);
        });

        // AI Barista (MiLO)
        btnAI.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AiBaristaActivity.class);
            startActivity(intent);
        });

        // Ayarlar (şimdilik placeholder)
        btnSettings.setOnClickListener(v ->
                Toast.makeText(
                        MainActivity.this,
                        "Ayarlar yakında eklenecek.",
                        Toast.LENGTH_SHORT
                ).show()
        );
    }
}