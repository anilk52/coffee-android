// app/src/main/java/com/example/coffee/ui/RecipeDetailActivity.java
package com.example.coffee.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends Activity {

    private View ingredientsGroup, stepsGroup, tipsGroup;
    private TextView ingredientsView, stepsView, tipsView, titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        titleView = findViewById(R.id.titleView);

        ingredientsGroup = findViewById(R.id.ingredientsGroup);
        stepsGroup = findViewById(R.id.stepsGroup);
        tipsGroup = findViewById(R.id.tipsGroup);

        ingredientsView = findViewById(R.id.ingredientsView);
        stepsView = findViewById(R.id.stepsView);
        tipsView = findViewById(R.id.tipsView);

        String title = getIntent().getStringExtra("title");
        Recipe recipe = RecipesData.findByTitle(title);

        if (recipe == null) {
            titleView.setText(getString(R.string.not_found));
            ingredientsGroup.setVisibility(View.GONE);
            stepsGroup.setVisibility(View.GONE);
            tipsGroup.setVisibility(View.GONE);
            return;
        }

        titleView.setText(recipe.getTitle());

        if (recipe.hasIngredients()) {
            ingredientsView.setText(recipe.getIngredients());
            ingredientsGroup.setVisibility(View.VISIBLE);
        } else {
            ingredientsGroup.setVisibility(View.GONE);
        }

        if (recipe.hasSteps()) {
            stepsView.setText(recipe.getSteps());
            stepsGroup.setVisibility(View.VISIBLE);
        } else {
            stepsGroup.setVisibility(View.GONE);
        }

        if (recipe.hasTips()) {
            tipsView.setText(recipe.getTips());
            tipsGroup.setVisibility(View.VISIBLE);
        } else {
            tipsGroup.setVisibility(View.GONE);
        }
    }
}
