package com.example.coffee.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;
import com.example.coffee.util.FavoritesStore;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_favorites);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Favoriler");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView rv = findViewById(R.id.recyclerFavorites);
        rv.setLayoutManager(new LinearLayoutManager(this));

        List<Recipe> favs = new ArrayList<>();
        for (Recipe r : RecipesData.getAll()) {
            if (FavoritesStore.isFav(this, r.getName())) {
                favs.add(r);
            }
        }
        rv.setAdapter(new RecipeAdapter(this, favs));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) { onBackPressed(); return true; }
        return super.onOptionsItemSelected(item);
    }
}