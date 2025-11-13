package com.example.coffee.ui;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.MainActivity;
import com.example.coffee.R;
import com.example.coffee.ui.RecipeAdapter;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private RecyclerView recyclerRecipes;
    private SearchView searchView;
    private RecipeAdapter adapter;

    private List<Recipe> allRecipes = new ArrayList<>();
    private List<Recipe> shownRecipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recyclerRecipes = findViewById(R.id.recyclerRecipes);
        searchView      = findViewById(R.id.searchView);

        // Ana menüden gelen kategori
        String category = getIntent().getStringExtra(MainActivity.EXTRA_CATEGORY);

        // Tüm tarifleri al
        List<Recipe> fromData = RecipesData.getAll();
        allRecipes.clear();
        shownRecipes.clear();

        if (category != null && !category.trim().isEmpty()) {
            String key = category.trim().toLowerCase();
            for (Recipe r : fromData) {
                String cat = r.getCategory() != null ? r.getCategory().toLowerCase() : "";
                if (cat.equals(key)) {
                    allRecipes.add(r);
                }
            }
        } else {
            allRecipes.addAll(fromData);
        }

        shownRecipes.addAll(allRecipes);

        adapter = new RecipeAdapter(this, shownRecipes);
        recyclerRecipes.setLayoutManager(new LinearLayoutManager(this));
        recyclerRecipes.setAdapter(adapter);

        // Arama
        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filterList(newText);
                    return true;
                }
            });
        }
    }

    private void filterList(String text) {
        if (text == null) text = "";
        String q = text.toLowerCase().trim();

        if (q.isEmpty()) {
            adapter.updateList(new ArrayList<>(allRecipes));
            return;
        }

        List<Recipe> filtered = new ArrayList<>();
        for (Recipe r : allRecipes) {
            String name = r.getName() != null ? r.getName().toLowerCase() : "";
            String desc = r.getShortDesc() != null ? r.getShortDesc().toLowerCase() : "";
            if (name.contains(q) || desc.contains(q)) {
                filtered.add(r);
            }
        }
        adapter.updateList(filtered);
    }
}