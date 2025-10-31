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

    public static final String EXTRA_CATEGORY = "category"; // String (örn: "Espresso")

    private RecipeAdapter adapter;
    private final List<Recipe> all = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        // View’lar
        RecyclerView recycler = findViewById(R.id.recyclerRecipes);
        EditText edtSearch = findViewById(R.id.edtSearch);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        // Veri
        String category = getIntent().getStringExtra(EXTRA_CATEGORY); // null olabilir
        all.clear();
        all.addAll(RecipesData.getAll());   // tüm tarifler

        List<Recipe> initial = filterByCategory(all, category);
        adapter = new RecipeAdapter(this, initial);
        recycler.setAdapter(adapter);

        // Arama
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Kategori filtresi + arama birlikte çalışsın:
                List<Recipe> base = filterByCategory(all, category);
                adapter.submit(base);
                adapter.filter(s == null ? "" : s.toString());
            }
            @Override public void afterTextChanged(Editable s) {}
        });
    }

    private List<Recipe> filterByCategory(List<Recipe> source, @Nullable String category) {
        if (category == null || category.trim().isEmpty() || "Tüm Tarifler".equalsIgnoreCase(category)) {
            return new ArrayList<>(source);
        }
        List<Recipe> out = new ArrayList<>();
        for (Recipe r : source) {
            if (category.equalsIgnoreCase(r.getCategory())) out.add(r);
        }
        return out;
    }
}