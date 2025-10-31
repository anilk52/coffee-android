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
        // Senin dosya adın: res/layout/activitymain.xml
        setContentView(R.layout.activitymain);

        bindCard(R.id.cardEspresso,  RecipesData.CAT_ESPRESSO);
        bindCard(R.id.cardFilter,    RecipesData.CAT_FILTER);
        bindCard(R.id.cardSpecial,   RecipesData.CAT_SPECIAL);
        bindCard(R.id.cardAlcoholic, RecipesData.CAT_ALCOHOLIC);
        bindCard(R.id.cardIced,      RecipesData.CAT_ICED);
        bindCard(R.id.cardTurkish,   RecipesData.CAT_TURKISH);
    }

    private void bindCard(int viewId, String category) {
        View v = findViewById(viewId);
        if (v != null) {
            v.setOnClickListener(x -> {
                Intent i = new Intent(MainActivity.this, RecipeActivity.class);
                i.putExtra("category", category);
                startActivity(i);
            });
        }
    }
}