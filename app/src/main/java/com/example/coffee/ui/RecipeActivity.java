package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Kategoriye göre tarif listesini gösterir.
 * Intent extra: "category" (null ise tüm tarifler)
 */
public class RecipeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    private TextView txtCategory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recyclerView = findViewById(R.id.recyclerView);
        txtCategory  = findViewById(R.id.txtCategory);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tıklamada detay sayfasını aç
        adapter = new RecipeAdapter(recipe -> {
            Intent i = new Intent(this, RecipeDetailActivity.class);
            i.putExtra("recipe_name", recipe.getName());
            i.putExtra("recipe_desc", recipe.getDescription());
            startActivity(i);
        });
        recyclerView.setAdapter(adapter);

        // Kategori oku
        String category = getIntent() != null ? getIntent().getStringExtra("category") : null;

        // Başlık
        txtCategory.setText(getTitleFor(category));

        // Veri
        List<Recipe> all = RecipesData.getAll();
        List<Recipe> shown = filterByCategory(all, category);
        adapter.submit(shown);
    }

    private static String getTitleFor(@Nullable String cat) {
        if (TextUtils.isEmpty(cat)) return "Tüm Tarifler";
        return cat;
    }

    private static List<Recipe> filterByCategory(List<Recipe> list, @Nullable String cat) {
        if (list == null) return new ArrayList<>();
        if (TextUtils.isEmpty(cat)) return new ArrayList<>(list);
        List<Recipe> out = new ArrayList<>();
        for (Recipe r : list) {
            if (r != null && cat.equalsIgnoreCase(r.getCategory())) {
                out.add(r);
            }
        }
        return out;
    }
}