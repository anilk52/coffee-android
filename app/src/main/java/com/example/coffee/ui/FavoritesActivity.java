package com.example.coffee.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.adapter.RecipeAdapter;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView recyclerFavorites;
    private RecipeAdapter adapter;
    private List<Recipe> favoriteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Aynı liste ekranı layout’unu kullanıyoruz
        setContentView(R.layout.activity_recipe);

        recyclerFavorites = findViewById(R.id.recyclerRecipes);
        SearchView searchView = findViewById(R.id.searchView);

        // Favoriler ekranında aramayı şimdilik gizleyelim
        if (searchView != null) {
            searchView.setVisibility(View.GONE);
        }

        // Şimdilik: tüm tarifleri göster
        favoriteList.clear();
        favoriteList.addAll(RecipesData.getAll());

        adapter = new RecipeAdapter(this, favoriteList);
        recyclerFavorites.setLayoutManager(new LinearLayoutManager(this));
        recyclerFavorites.setAdapter(adapter);
    }
}