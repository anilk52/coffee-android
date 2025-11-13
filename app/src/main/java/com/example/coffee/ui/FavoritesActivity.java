package com.example.coffee.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.ui.RecipeAdapter;
import com.example.coffee.util.FavoriteStore;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView recyclerFavorites;
    private RecipeAdapter adapter;
    private final List<Recipe> favoriteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe); // Aynı layout

        recyclerFavorites = findViewById(R.id.recyclerRecipes);
        SearchView searchView = findViewById(R.id.searchView);

        // Favoriler ekranında aramayı şimdilik gizleyebiliriz
        if (searchView != null) {
            searchView.setVisibility(View.GONE);
        }

        loadFavorites();

        adapter = new RecipeAdapter(this, favoriteList);
        recyclerFavorites.setLayoutManager(new LinearLayoutManager(this));
        recyclerFavorites.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Ekrana geri dönüldüğünde, favoriler değişmiş olabilir
        loadFavorites();
        if (adapter != null) {
            adapter.updateList(new ArrayList<>(favoriteList));
        }
    }

    private void loadFavorites() {
        favoriteList.clear();
        Set<String> favNames = FavoriteStore.getFavorites(this);
        if (favNames.isEmpty()) return;

        for (Recipe r : RecipesData.getAll()) {
            if (favNames.contains(r.getName())) {
                favoriteList.add(r);
            }
        }
    }
}