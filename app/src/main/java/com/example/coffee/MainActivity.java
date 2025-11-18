package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.coffee.ui.RecipeActivity;
import com.example.coffee.ui.AiBaristaActivity;
import com.example.coffee.ui.SettingsActivity;
import com.example.coffee.ui.FavoritesActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY = "extra_category";

    // Kategori anahtarları (RecipeRepository ile aynı olmalı)
    public static final String CAT_ESPRESSO   = "espresso";
    public static final String CAT_FILTER     = "filter";
    public static final String CAT_LATTE_LAB  = "latte_lab";
    public static final String CAT_ICED       = "iced";
    public static final String CAT_TURKISH    = "turkish";
    public static final String CAT_ALCOHOLIC  = "alcoholic";
    public static final String CAT_FRAPPE     = "frappe";
    public static final String CAT_SIGNATURE  = "signature";
    public static final String CAT_BREW_GUIDE = "brew_guide";

    private CardView cardEspresso;
    private CardView cardFilter;
    private CardView cardLatteLab;
    private CardView cardIced;
    private CardView cardTurkish;
    private CardView cardAlcoholic;
    private CardView cardFrappe;
    private CardView cardSignature;
    private CardView cardBrewGuide;

    private ImageButton btnFavorites;
    private ImageButton btnBrewAi;
    private ImageButton btnSettings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ÜST BAR BUTONLARI
        btnFavorites = findViewById(R.id.btnFavorites);
        btnBrewAi    = findViewById(R.id.btnBrewAi);
        btnSettings  = findViewById(R.id.btnSettings);

        btnFavorites.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, FavoritesActivity.class)));

        btnBrewAi.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, AiBaristaActivity.class)));

        btnSettings.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, SettingsActivity.class)));

        // KARTLAR
        cardEspresso   = findViewById(R.id.cardEspresso);
        cardFilter     = findViewById(R.id.cardFilter);
        cardLatteLab   = findViewById(R.id.cardLatteLab);
        cardIced       = findViewById(R.id.cardIced);
        cardTurkish    = findViewById(R.id.cardTurkish);
        cardAlcoholic  = findViewById(R.id.cardAlcoholic);
        cardFrappe     = findViewById(R.id.cardFrappe);
        cardSignature  = findViewById(R.id.cardSignature);
        cardBrewGuide  = findViewById(R.id.cardBrewGuide);

        View.OnClickListener cardClickListener = v -> {
            String catKey = null;
            int id = v.getId();

            if (id == R.id.cardEspresso) {
                catKey = CAT_ESPRESSO;
            } else if (id == R.id.cardFilter) {
                catKey = CAT_FILTER;
            } else if (id == R.id.cardLatteLab) {
                catKey = CAT_LATTE_LAB;
            } else if (id == R.id.cardIced) {
                catKey = CAT_ICED;
            } else if (id == R.id.cardTurkish) {
                catKey = CAT_TURKISH;
            } else if (id == R.id.cardAlcoholic) {
                catKey = CAT_ALCOHOLIC;
            } else if (id == R.id.cardFrappe) {
                catKey = CAT_FRAPPE;
            } else if (id == R.id.cardSignature) {
                catKey = CAT_SIGNATURE;
            } else if (id == R.id.cardBrewGuide) {
                catKey = CAT_BREW_GUIDE;
            }

            if (catKey != null) openCategory(catKey);
        };

        cardEspresso.setOnClickListener(cardClickListener);
        cardFilter.setOnClickListener(cardClickListener);
        cardLatteLab.setOnClickListener(cardClickListener);
        cardIced.setOnClickListener(cardClickListener);
        cardTurkish.setOnClickListener(cardClickListener);
        cardAlcoholic.setOnClickListener(cardClickListener);
        cardFrappe.setOnClickListener(cardClickListener);
        cardSignature.setOnClickListener(cardClickListener);
        cardBrewGuide.setOnClickListener(cardClickListener);
    }

    private void openCategory(String categoryKey) {
        Intent i = new Intent(MainActivity.this, RecipeActivity.class);
        i.putExtra(EXTRA_CATEGORY, categoryKey);
        startActivity(i);
    }
}