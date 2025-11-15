package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
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
    private CardView cardFrappe; // yeni kategori kartı

    private View btnFavorites;
    private View btnAI;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kategori kartları
        cardEspresso = findViewSafe(R.id.cardEspresso);
        cardFilter   = findViewSafe(R.id.cardFilter);
        cardSpecial  = findViewSafe(R.id.cardSpecial);
        cardAlcohol  = findViewSafe(R.id.cardAlcohol);
        cardIced     = findViewSafe(R.id.cardIced);
        cardTurkish  = findViewSafe(R.id.cardTurkish);
        cardFrappe   = findViewSafe(R.id.cardFrappe); // Frappé / Blended

        // Üst ikonlar / butonlar
        btnFavorites = findViewSafe(R.id.btnFavorites);
        btnAI        = findViewSafe(R.id.btnAI);

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
        if (cardFrappe != null) {
            // Yeni kategori: Frappé / Blended
            cardFrappe.setOnClickListener(v -> openCategory("frappe"));
        }

        // Favoriler
        if (btnFavorites != null) {
            btnFavorites.setOnClickListener(v -> openFavorites());
        }

        // Ana ekrandan genel AI Barista
        if (btnAI != null) {
            btnAI.setOnClickListener(v -> openAiBaristaGeneral());
        }
    }

    private void openCategory(String categoryKey) {
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra(EXTRA_CATEGORY, categoryKey);
        startActivity(intent);
    }

    private void openFavorites() {
        Intent intent = new Intent(this, FavoritesActivity.class);
        startActivity(intent);
    }

    private void openAiBaristaGeneral() {
        // Genel sohbet için tarif bilgisi göndermiyoruz; AiBaristaActivity
        // Intent extras boş gelirse “BDINO Coffee” genel modunda açılacak.
        Intent intent = new Intent(this, AiBaristaActivity.class);
        startActivity(intent);
    }

    @SuppressWarnings("unchecked")
    private <T extends View> T findViewSafe(int id) {
        try {
            return (T) findViewById(id);
        } catch (Exception e) {
            return null;
        }
    }
}