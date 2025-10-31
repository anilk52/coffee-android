package com.example.coffee.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private RecyclerView recyclerRecipes;
    private RecipeAdapter adapter;
    private EditText searchInput;
    private List<Recipe> allRecipes = new ArrayList<>();
    private List<Recipe> filtered = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_recipe);

        recyclerRecipes = findViewById(R.id.recyclerRecipes);
        searchInput = findViewById(R.id.searchInput);

        recyclerRecipes.setLayoutManager(new LinearLayoutManager(this));
        allRecipes = RecipesData.getAll();
        filtered.addAll(allRecipes);

        adapter = new RecipeAdapter(this, filtered);
        recyclerRecipes.setAdapter(adapter);

        // Dinamik filtreleme
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String q = s.toString().toLowerCase();
                filtered.clear();
                for (Recipe r : allRecipes) {
                    if (r.getName().toLowerCase().contains(q) ||
                        r.getDescription().toLowerCase().contains(q)) {
                        filtered.add(r);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}