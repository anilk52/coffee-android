package com.example.coffee.ui;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private final List<Recipe> allRecipes = new ArrayList<>();
    private final List<Recipe> shown = new ArrayList<>();
    private RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activityrecipe);

        RecyclerView rv = findViewById(R.id.recyclerRecipes);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecipeAdapter(shown);
        rv.setAdapter(adapter);

        // Tüm tarifleri al
        allRecipes.clear();
        allRecipes.addAll(RecipesData.getAll());

        // Kategori filtresi
        String category = getIntent().getStringExtra("category");
        shown.clear();

        if (TextUtils.isEmpty(category)) {
            shown.addAll(allRecipes);
            setTitle(R.string.app_name);
        } else {
            for (Recipe r : allRecipes) {
                if (category.equalsIgnoreCase(r.getCategory())) {
                    shown.add(r);
                }
            }
            setTitle(category);
        }

        adapter.notifyDataSetChanged();
    }
}