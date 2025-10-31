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

    public static final String EXTRA_CATEGORY = "category"; // Örn: "Espresso"

    private RecipeAdapter adapter;
    private final List<Recipe> allRecipes = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe); // ✅ tekil dosya ismi

        RecyclerView recyclerView = findViewById(R.id.recyclerRecipes);
        EditText searchBox = findViewById(R.id.edtSearch);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tüm tarifleri yükle
        allRecipes.clear();
        allRecipes.addAll(RecipesData.getAll());

        // Gelen kategori
        String category = getIntent().getStringExtra(EXTRA_CATEGORY);

        // Başlangıç filtreli liste
        List<Recipe> filtered = filterByCategory(allRecipes, category);

        adapter = new RecipeAdapter(this, filtered);
        recyclerView.setAdapter(adapter);

        // 🔍 Arama kutusu filtreleme
        searchBox.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s == null ? "" : s.toString();
                List<Recipe> baseList = filterByCategory(allRecipes, category);
                adapter.submit(baseList);   // kategoriye göre yeniden yükle
                adapter.filter(query);      // aramayı uygula
            }
            @Override public void afterTextChanged(Editable s) {}
        });
    }

    private List<Recipe> filterByCategory(List<Recipe> source, @Nullable String category) {
        if (category == null || category.trim().isEmpty() || category.equalsIgnoreCase("Tüm Tarifler")) {
            return new ArrayList<>(source);
        }
        List<Recipe> out = new ArrayList<>();
        for (Recipe r : source) {
            if (category.equalsIgnoreCase(r.getCategory())) {
                out.add(r);
            }
        }
        return out;
    }
}