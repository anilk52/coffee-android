package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.data.RecipesData;
import com.example.coffee.ui.RecipeActivity;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    private void openCategory(String categoryKey) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("category", categoryKey);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCardView cardEspresso = findViewById(R.id.cardEspresso);
        MaterialCardView cardFiltre   = findViewById(R.id.cardFiltre);
        MaterialCardView cardSpecial  = findViewById(R.id.cardSpecial);
        MaterialCardView cardAlkollu  = findViewById(R.id.cardAlkollu);
        MaterialCardView cardIce      = findViewById(R.id.cardIce);

        View.OnClickListener l = v -> {
            int id = v.getId();
            if (id == R.id.cardEspresso) {
                openCategory(RecipesData.CAT_ESPRESSO);
            } else if (id == R.id.cardFiltre) {
                openCategory(RecipesData.CAT_FILTRE);
            } else if (id == R.id.cardSpecial) {
                openCategory(RecipesData.CAT_SPECIAL);
            } else if (id == R.id.cardAlkollu) {
                openCategory(RecipesData.CAT_ALKOLLU);
            } else if (id == R.id.cardIce) {
                openCategory(RecipesData.CAT_ICE);
            }
        };

        cardEspresso.setOnClickListener(l);
        cardFiltre.setOnClickListener(l);
        cardSpecial.setOnClickListener(l);
        cardAlkollu.setOnClickListener(l);
        cardIce.setOnClickListener(l);
    }
}
