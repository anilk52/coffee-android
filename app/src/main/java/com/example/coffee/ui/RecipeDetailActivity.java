package com.example.coffee.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        LinearLayout ingGroup = findViewById(R.id.ingredientsGroup);
        LinearLayout stepsGroup = findViewById(R.id.stepsGroup);
        LinearLayout tipsGroup = findViewById(R.id.tipsGroup);

        TextView title = findViewById(R.id.titleView);
        TextView ing = findViewById(R.id.ingredientsView);
        TextView steps = findViewById(R.id.stepsView);
        TextView tips = findViewById(R.id.tipsView);

        String t = getIntent() != null ? getIntent().getStringExtra("title") : null;
        Recipe r = (t == null) ? null : RecipesData.findByTitle(t);

        if (r == null) {
            if (title != null) title.setText(getString(R.string.not_found));
            if (ingGroup != null) ingGroup.setVisibility(View.GONE);
            if (stepsGroup != null) stepsGroup.setVisibility(View.GONE);
            if (tipsGroup != null) tipsGroup.setVisibility(View.GONE);
            return;
        }

        if (title != null) title.setText(r.getTitle());

        if (r.hasIngredients()) {
            if (ing != null) ing.setText(r.getIngredients());
            if (ingGroup != null) ingGroup.setVisibility(View.VISIBLE);
        } else if (ingGroup != null) ingGroup.setVisibility(View.GONE);

        if (r.hasSteps()) {
            if (steps != null) steps.setText(r.getSteps());
            if (stepsGroup != null) stepsGroup.setVisibility(View.VISIBLE);
        } else if (stepsGroup != null) stepsGroup.setVisibility(View.GONE);

        if (r.hasTips()) {
            if (tips != null) tips.setText(r.getTips());
            if (tipsGroup != null) tipsGroup.setVisibility(View.VISIBLE);
        } else if (tipsGroup != null) tipsGroup.setVisibility(View.GONE);
    }
}
