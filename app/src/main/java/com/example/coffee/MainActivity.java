package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.coffee.data.RecipesData;
import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupCard(R.id.cardEspresso, RecipesData.CAT_ESPRESSO);
        setupCard(R.id.cardFilter, RecipesData.CAT_FILTER);
        setupCard(R.id.cardSpecial, RecipesData.CAT_SPECIAL);
        setupCard(R.id.cardAlcoholic, RecipesData.CAT_ALCOHOLIC);
        setupCard(R.id.cardIced, RecipesData.CAT_ICED);
        setupCard(R.id.cardTurkish, RecipesData.CAT_TURKISH);
    }

    private void setupCard(int cardId, String category) {
        LinearLayout card = findViewById(cardId);
        card.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, RecipeActivity.class);
            i.putExtra("category", category);
            startActivity(i);
        });
    }
}