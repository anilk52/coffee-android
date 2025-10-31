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

    private final List<Recipe> all = new ArrayList<>();
    private final List<Recipe> shown = new ArrayList<>();
    private RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        // HATAYI KESMEK İÇİN: activity_recipe kullanıyoruz
        setContentView(R.layout.activity_recipe);

        RecyclerView rv = findViewById(R.id.recyclerRecipes);
        if (rv != null) {
            rv.setLayoutManager(new LinearLayoutManager(this));
            adapter = new RecipeAdapter(shown);
            rv.setAdapter(adapter);
        } else {
            // Recycler yoksa bile crash olmasın
            adapter = new RecipeAdapter(shown);
        }

        all.clear();
        all.addAll(RecipesData.getAll());

        String category = getIntent().getStringExtra("category");
        shown.clear();

        if (TextUtils.isEmpty(category)) {
            shown.addAll(all);
            setTitle(R.string.app_name);
        } else {
            for (Recipe r : all) {
                if (category.equalsIgnoreCase(r.getCategory())) {
                    shown.add(r);
                }
            }
            setTitle(category);
        }

        adapter.notifyDataSetChanged();
    }
}