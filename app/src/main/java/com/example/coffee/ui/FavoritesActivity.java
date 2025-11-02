package com.example.coffee.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.utils.Prefs;
import com.example.coffee.utils.RecipeIds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityrecipe); // mevcut liste layout’unu yeniden kullan
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle(getString(R.string.favorites));
        }

        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));

        // Veri kaynağı (hibrit)
        List<?> all = RecipesData.getAllFromJson(this);
        if (all == null || all.isEmpty()) all = RecipesData.getAll();

        Set<String> favs = new HashSet<>(Prefs.getFavs(this));
        List<Object> onlyFavs = new ArrayList<>();
        for (Object r : all) {
            if (favs.contains(RecipeIds.idOf(r))) onlyFavs.add(r);
        }

        rv.setAdapter(new RecipeAdapter(this, onlyFavs));
    }

    @Override
    public boolean onSupportNavigateUp() { onBackPressed(); return true; }
}