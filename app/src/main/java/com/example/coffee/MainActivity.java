package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.data.RecipesData;
import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        // HATAYI KESMEK İÇİN: activity_main kullanıyoruz
        setContentView(R.layout.activity_main);

        bind(R.id.cardEspresso,  RecipesData.CAT_ESPRESSO);
        bind(R.id.cardFilter,    RecipesData.CAT_FILTER);
        bind(R.id.cardSpecial,   RecipesData.CAT_SPECIAL);
        bind(R.id.cardAlcoholic, RecipesData.CAT_ALCOHOLIC);
        bind(R.id.cardIced,      RecipesData.CAT_ICED);
        bind(R.id.cardTurkish,   RecipesData.CAT_TURKISH);
    }

    private void bind(int viewId, String category) {
        View v = findViewById(viewId);
        if (v != null) {
            v.setOnClickListener(x -> {
                Intent i = new Intent(this, RecipeActivity.class);
                i.putExtra("category", category);
                startActivity(i);
            });
        }
    }
}