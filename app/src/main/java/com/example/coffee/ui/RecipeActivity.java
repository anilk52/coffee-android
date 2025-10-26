package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        ListView listView = findViewById(R.id.recipesList);
        TextView empty = findViewById(R.id.emptyView);

        String category = getIntent() != null ? getIntent().getStringExtra("category") : null;
        List<String> titles = (category == null)
                ? RecipesData.allTitles()
                : RecipesData.titlesForCategory(category);

        if (titles == null || titles.isEmpty()) {
            if (empty != null) empty.setVisibility(View.VISIBLE);
            if (listView != null) listView.setVisibility(View.GONE);
            return;
        }

        if (empty != null) empty.setVisibility(View.GONE);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.item_simple_row, titles
        );
        listView.setAdapter(adapter);

        // ✅ Detay ekranına doğru anahtarlarla veri gönder
        listView.setOnItemClickListener((p, v, pos, id) -> {
            String title = adapter.getItem(pos);
            Recipe r = RecipesData.findByName(title);

            Intent i = new Intent(this, RecipeDetailActivity.class);
            i.putExtra("recipe_name", title); // Detay bu anahtarı bekliyor
            if (r != null && r.getDescription() != null && !r.getDescription().trim().isEmpty()) {
                i.putExtra("recipe_desc", r.getDescription());
            }
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
    }
}