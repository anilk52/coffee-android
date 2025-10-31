package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout cardEspresso, cardFilter, cardSpecial, cardAlcoholic, cardIced, cardTurkish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardEspresso  = findViewById(R.id.cardEspresso);
        cardFilter    = findViewById(R.id.cardFilter);
        cardSpecial   = findViewById(R.id.cardSpecial);
        cardAlcoholic = findViewById(R.id.cardAlcoholic);
        cardIced      = findViewById(R.id.cardIced);
        cardTurkish   = findViewById(R.id.cardTurkish);

        cardEspresso.setOnClickListener(v -> openCategory("Espresso"));
        cardFilter.setOnClickListener(v -> openCategory("Filter"));
        cardSpecial.setOnClickListener(v -> openCategory("Special"));
        cardAlcoholic.setOnClickListener(v -> openCategory("Alcoholic"));
        cardIced.setOnClickListener(v -> openCategory("Iced"));
        cardTurkish.setOnClickListener(v -> openCategory("Turkish"));
    }

    private void openCategory(String category) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("category", category);
        startActivity(i);
    }
}