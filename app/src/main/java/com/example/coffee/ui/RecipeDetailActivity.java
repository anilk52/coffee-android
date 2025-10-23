package com.example.coffee.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_DESCRIPTION = "extra_description";

    /** Başka ekranlardan rahat çağırmak için */
    public static void start(Context context, Recipe recipe) {
        Intent i = new Intent(context, RecipeDetailActivity.class);
        // Recipe null gelirse güvenli fallback kullanacağız
        if (recipe != null) {
            i.putExtra(EXTRA_TITLE, recipe.getTitle());
            i.putExtra(EXTRA_DESCRIPTION, recipe.getDescription());
        }
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        TextView titleView = findViewById(R.id.recipeTitle);
        TextView descView  = findViewById(R.id.recipeDescription);

        // Intent’ten verileri al
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        String desc  = getIntent().getStringExtra(EXTRA_DESCRIPTION);

        // Null ise strings.xml'deki not_found'u göster
        if (title == null || title.trim().isEmpty()) {
            title = getString(R.string.not_found);
        }
        if (desc == null || desc.trim().isEmpty()) {
            desc = getString(R.string.not_found);
        }

        titleView.setText(title);
        descView.setText(desc);
        setTitle(title);
    }
}