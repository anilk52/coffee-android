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
    private final List<Recipe> allRecipes = new ArrayList<>();
    private final List<Recipe> shown = new ArrayList<>();
    private String selectedCategory; // null ise hepsi

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_recipe);

        recyclerRecipes = findViewById(R.id.recyclerRecipes);
        searchInput = findViewById(R.id.searchInput);
        recyclerRecipes.setLayoutManager(new LinearLayoutManager(this));

        allRecipes.addAll(RecipesData.getAll());

        // Ana menüden gönderilen kategori
        selectedCategory = getIntent().getStringExtra("category");

        // Başlangıç listesi
        filterAndShow("");

        adapter = new RecipeAdapter(this, shown);
        recyclerRecipes.setAdapter(adapter);

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterAndShow(s.toString());
            }
        });

        // (Varsa) başlıkta kategori etiketini göster
        if (getSupportActionBar() != null) {
            String title = selectedCategory == null ? "Tüm Tarifler" : RecipesData.categoryLabel(selectedCategory);
            getSupportActionBar().setTitle(title);
        }
    }

    private void filterAndShow(String query) {
        String q = query == null ? "" : query.toLowerCase();
        shown.clear();
        for (Recipe r : allRecipes) {
            boolean catOk = (selectedCategory == null) || selectedCategory.equals(r.getCategory());
            boolean textOk = r.getName().toLowerCase().contains(q)
                          || r.getDescription().toLowerCase().contains(q);
            if (catOk && textOk) shown.add(r);
        }
        if (adapter != null) adapter.notifyDataSetChanged();
    }
}