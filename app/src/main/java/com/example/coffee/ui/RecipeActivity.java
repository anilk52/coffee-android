package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.adapter.RecipeAdapter;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView txtCategory;
    private RecipeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        // View refs
        recyclerView = findViewById(R.id.recyclerView);
        txtCategory  = findViewById(R.id.txtCategory);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Intent’ten kategori al
        Intent i = getIntent();
        String category = (i != null) ? i.getStringExtra("category") : null;

        // Başlık
        txtCategory.setText(categoryLabel(category));

        // Veri
        List<Recipe> recipes = RecipesData.forCategory(category);

        // Adapter
        adapter = new RecipeAdapter(
                this,
                recipes,
                recipe -> {
                    Intent d = new Intent(RecipeActivity.this, RecipeDetailActivity.class);
                    d.putExtra("name", recipe.getName()); // modelde getTitle() ise buna göre değiştir
                    startActivity(d);
                }
        );
        recyclerView.setAdapter(adapter);
    }

    private String categoryLabel(String cat) {
        if (cat == null) return "TÜM TARİFLER";
        switch (cat) {
            case RecipesData.CAT_ESPRESSO: return "ESPRESSO";
            case RecipesData.CAT_FILTRE:   return "FİLTRE";
            case RecipesData.CAT_SPECIAL:  return "SPECIAL";
            case RecipesData.CAT_ALKOLLU:  return "ALKOLLÜ";
            case RecipesData.CAT_ICE:      return "ICE";
            case RecipesData.CAT_TURK:     return "TÜRK KAHVESİ";
            default: return "TARİFLER";
        }
    }
}