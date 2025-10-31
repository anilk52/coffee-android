package com.example.coffee.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    private static final String EXTRA_RECIPE = "extra_recipe";

    public static void start(Context context, Recipe recipe) {
        Intent intent = new Intent(context, RecipeDetailActivity.class);
        intent.putExtra(EXTRA_RECIPE, recipe);
        context.startActivity(intent);
    }

    private ImageView imgRecipe;
    private TextView txtTitle, txtDesc, txtSteps, txtCup, txtCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        imgRecipe = findViewById(R.id.imgRecipe);
        txtTitle = findViewById(R.id.txtTitle);
        txtDesc = findViewById(R.id.txtDesc);
        txtSteps = findViewById(R.id.txtSteps);
        txtCup = findViewById(R.id.txtCup);
        txtCategory = findViewById(R.id.txtCategory);

        Recipe recipe = (Recipe) getIntent().getSerializableExtra(EXTRA_RECIPE);
        if (recipe == null) return;

        txtTitle.setText(recipe.getName());
        txtDesc.setText(recipe.getDescription());
        txtSteps.setText(recipe.getSteps());
        txtCup.setText(recipe.getCupSize());
        txtCategory.setText(RecipesData.categoryLabel(recipe.getCategory()));

        if (recipe.getImageResId() != 0) {
            imgRecipe.setImageResource(recipe.getImageResId());
        }
    }
}