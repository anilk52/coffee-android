package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.ui.RecipeActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private void openCategory(String category) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("category", category);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton btnEspresso = findViewById(R.id.btnEspresso);
        MaterialButton btnFilter   = findViewById(R.id.btnFilter);
        MaterialButton btnSpecial  = findViewById(R.id.btnSpecial);
        MaterialButton btnAlcohol  = findViewById(R.id.btnAlcohol);
        MaterialButton btnIce      = findViewById(R.id.btnIce);

        // DİKKAT: Bu stringler RecipesData’daki kategori adlarıyla birebir aynı olmalı.
        btnEspresso.setOnClickListener(v -> openCategory("Espresso"));
        btnFilter.setOnClickListener(v -> openCategory("Filtre"));
        btnSpecial.setOnClickListener(v -> openCategory("Special"));
        btnAlcohol.setOnClickListener(v -> openCategory("Alkollü"));
        btnIce.setOnClickListener(v -> openCategory("Ice"));
    }
}