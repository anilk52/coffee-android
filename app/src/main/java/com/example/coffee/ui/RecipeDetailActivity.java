package com.example.coffee.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.adapter.RecipeAdapter;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    private ImageView imgHero;
    private TextView txtTitle;
    private TextView txtDescription;
    private TextView txtMeasure;
    private TextView txtTip;
    private TextView txtNote;
    private TextView txtSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        imgHero      = findViewById(R.id.imgHero);
        txtTitle     = findViewById(R.id.txtTitle);
        txtDescription = findViewById(R.id.txtDescription);
        txtMeasure   = findViewById(R.id.txtMeasure);
        txtTip       = findViewById(R.id.txtTip);
        txtNote      = findViewById(R.id.txtNote);
        txtSize      = findViewById(R.id.txtSize);

        Recipe recipe = (Recipe) getIntent()
                .getSerializableExtra(RecipeAdapter.EXTRA_RECIPE);

        if (recipe == null) {
            finish();
            return;
        }

        if (recipe.getImageResId() != 0) {
            imgHero.setImageResource(recipe.getImageResId());
        }

        txtTitle.setText(recipe.getName());
        txtDescription.setText(emptySafe(recipe.getDescription()));
        txtMeasure.setText(emptySafe(recipe.getMeasure()));
        txtTip.setText(emptySafe(recipe.getTip()));
        txtNote.setText(emptySafe(recipe.getNote()));
        txtSize.setText(emptySafe(recipe.getSize()));
    }

    private String emptySafe(String s) {
        return TextUtils.isEmpty(s) ? "-" : s;
    }
}