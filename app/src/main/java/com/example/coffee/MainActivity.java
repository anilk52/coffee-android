package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.data.RecipesData;
import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEspresso = findViewById(R.id.btnEspresso);
        Button btnFilter = findViewById(R.id.btnFilter);
        Button btnSpecial = findViewById(R.id.btnSpecial);
        Button btnAlcohol = findViewById(R.id.btnAlcohol);
        Button btnIced = findViewById(R.id.btnIced);
        Button btnTurkish = findViewById(R.id.btnTurkish);

        btnEspresso.setOnClickListener(v -> openCategory(RecipesData.CAT_ESPRESSO));
        btnFilter.setOnClickListener(v -> openCategory(RecipesData.CAT_FILTER));
        btnSpecial.setOnClickListener(v -> openCategory(RecipesData.CAT_SPECIAL));
        btnAlcohol.setOnClickListener(v -> openCategory(RecipesData.CAT_ALCOHOLIC));
        btnIced.setOnClickListener(v -> openCategory(RecipesData.CAT_ICED));
        btnTurkish.setOnClickListener(v -> openCategory(RecipesData.CAT_TURKISH));
    }

    private void openCategory(String category) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("category", category);
        startActivity(i);
    }
}