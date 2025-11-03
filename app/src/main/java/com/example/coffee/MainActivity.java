package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.data.RecipesData;
import com.example.coffee.ui.FavoritesActivity;
import com.example.coffee.ui.RecipeActivity;
import com.example.coffee.ui.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupTopActions();
        setupCategoryCards();
    }

    private void setupTopActions() {
        ImageButton btnFavorites = findViewById(R.id.btnFavorites);
        ImageButton btnAiBarista = findViewById(R.id.btnAiBarista);
        ImageButton btnSettings = findViewById(R.id.btnSettings);

        if (btnFavorites != null) {
            btnFavorites.setOnClickListener(v -> {
                Intent i = new Intent(MainActivity.this, FavoritesActivity.class);
                startActivity(i);
            });
        }

        if (btnSettings != null) {
            btnSettings.setOnClickListener(v -> {
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);
            });
        }

        if (btnAiBarista != null) {
            // Şimdilik sadece bilgi amaçlı; AI mantığını sonra ekleyeceğiz
            btnAiBarista.setOnClickListener(v ->
                    Toast.makeText(MainActivity.this,
                            "AI Barista yakında burada ☕",
                            Toast.LENGTH_SHORT).show());
        }
    }

    private void setupCategoryCards() {
        setupCard(R.id.cardEspresso, RecipesData.CAT_ESPRESSO);
        setupCard(R.id.cardFilter,   RecipesData.CAT_FILTER);
        setupCard(R.id.cardSpecial,  RecipesData.CAT_SPECIAL);
        setupCard(R.id.cardAlcoholic,RecipesData.CAT_ALCOHOLIC);
        setupCard(R.id.cardIced,     RecipesData.CAT_ICED);
        setupCard(R.id.cardTurkish,  RecipesData.CAT_TURKISH);
    }

    private void setupCard(int cardId, String category) {
        View card = findViewById(cardId);
        if (card == null) return;

        card.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
            // RecipeActivity içinde hangi key kullanılıyorsa orada karşılanacak;
            // genelde "category" veya benzeri bir EXTRA kullanılıyor.
            intent.putExtra("category", category);
            startActivity(intent);
        });
    }
}