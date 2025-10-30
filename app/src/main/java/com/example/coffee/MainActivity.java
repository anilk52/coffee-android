package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.data.RecipesData;
import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnEspresso).setOnClickListener(v -> openCategory(RecipesData.CAT_ESPRESSO));
        findViewById(R.id.btnFilter).setOnClickListener(v -> openCategory(RecipesData.CAT_FILTER));
        findViewById(R.id.btnSpecial).setOnClickListener(v -> openCategory(RecipesData.CAT_SPECIAL));
        findViewById(R.id.btnAlcohol).setOnClickListener(v -> openCategory(RecipesData.CAT_ALCOHOLIC));
        findViewById(R.id.btnIced).setOnClickListener(v -> openCategory(RecipesData.CAT_ICED));
        findViewById(R.id.btnTurkish).setOnClickListener(v -> openCategory(RecipesData.CAT_TURKISH));
    }

    private void openCategory(String cat) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra(RecipeActivity.EXTRA_CATEGORY, cat);
        startActivity(i);
    }
}