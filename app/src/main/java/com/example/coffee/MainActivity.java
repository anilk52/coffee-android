package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.coffee.ui.AiBaristaActivity;
import com.example.coffee.ui.FavoritesActivity;
import com.example.coffee.ui.RecipeActivity;
import com.example.coffee.ui.SettingsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_CATEGORY = "extra_category";

    private CardView cardEspresso;
    private CardView cardFilter;
    private CardView cardLatteLab;
    private CardView cardIced;
    private CardView cardTurkish;
    private CardView cardAlcohol;
    private CardView cardFrappe;
    private CardView cardSignature;
    private CardView cardBrewGuide;

    private ImageButton btnFavorites;
    private ImageButton btnAI;
    private ImageButton btnSettings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Tema satırını kaldırdık; uygulama manifestteki varsayılan temayı kullanacak.
        setContentView(R.layout.activity_main);

        // Kartlar
        cardEspresso  = findViewById(R.id.cardEspresso);
        cardFilter    = findViewById(R.id.cardFilter);
        cardLatteLab  = findViewById(R.id.cardLatteLab);
        cardIced      = findViewById(R.id.cardIced);
        cardTurkish   = findViewById(R.id.cardTurkish);
        cardAlcohol   = findViewById(R.id.cardAlcohol);
        cardFrappe    = findViewById(R.id.cardFrappe);
        cardSignature = findViewById(R.id.cardSignature);
        cardBrewGuide = findViewById(R.id.cardBrewGuide);

        // Üst ikonlar
        btnFavorites = findViewById(R.id.btnFavorites);
        btnAI        = findViewById(R.id.btnAI);
        btnSettings  = findViewById(R.id.btnSettings);

        // Click listener bağla
        cardEspresso.setOnClickListener(this);
        cardFilter.setOnClickListener(this);
        cardLatteLab.setOnClickListener(this);
        cardIced.setOnClickListener(this);
        cardTurkish.setOnClickListener(this);
        cardAlcohol.setOnClickListener(this);
        cardFrappe.setOnClickListener(this);
        cardSignature.setOnClickListener(this);
        cardBrewGuide.setOnClickListener(this);

        btnFavorites.setOnClickListener(this);
        btnAI.setOnClickListener(this);
        btnSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.cardEspresso) {
            openCategory("ESPRESSO");
        } else if (id == R.id.cardFilter) {
            openCategory("FILTER");
        } else if (id == R.id.cardLatteLab) {
            openCategory("LATTE_LAB");
        } else if (id == R.id.cardIced) {
            openCategory("ICED");
        } else if (id == R.id.cardTurkish) {
            openCategory("TURKISH");
        } else if (id == R.id.cardAlcohol) {
            openCategory("ALCOHOLIC");
        } else if (id == R.id.cardFrappe) {
            openCategory("FRAPPE");
        } else if (id == R.id.cardSignature) {
            openCategory("SIGNATURE");
        } else if (id == R.id.cardBrewGuide) {
            openCategory("BREW_GUIDE");
        } else if (id == R.id.btnFavorites) {
            startActivity(new Intent(this, FavoritesActivity.class));
        } else if (id == R.id.btnAI) {
            startActivity(new Intent(this, AiBaristaActivity.class));
        } else if (id == R.id.btnSettings) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
    }

    private void openCategory(String categoryKey) {
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra(EXTRA_CATEGORY, categoryKey);
        startActivity(intent);
    }
}