package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        RecyclerView recycler = findViewById(R.id.recipesList);

        String category = getIntent() != null ? getIntent().getStringExtra("category") : null;

        // Başlık
        String title = (category == null) ? "Tüm Tarifler ☕" : (category + " ☕");
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Veri
        List<Recipe> data = (category == null)
                ? RecipesData.getAll()
                : RecipesData.getByCategory(category);

        // Adapter (mevcut RecipeAdapter’ını kullanıyoruz)
        RecipeAdapter adapter = new RecipeAdapter(r -> {
            Intent i = new Intent(this, RecipeDetailActivity.class);
            i.putExtra("recipe_name", r.getName());
            i.putExtra("recipe_desc", r.getDescription());
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
        adapter.submit(data);
    }
}