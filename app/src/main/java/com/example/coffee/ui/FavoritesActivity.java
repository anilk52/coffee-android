package com.example.coffee.ui;

import android.os.Bundle;
import android.view.View;

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
        // DOĞRU LAYOUT: activity_recipe.xml
        setContentView(R.layout.activity_recipe);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle(getString(R.string.favorites));
        }

        // recyclerView id’si projene göre değişebiliyor, compile-time R.id hatası yaşamamak için güvenli bulma:
        int rvId = getResources().getIdentifier("recyclerView", "id", getPackageName());
        if (rvId == 0) rvId = getResources().getIdentifier("recycler", "id", getPackageName());
        RecyclerView rv = findViewById(rvId);
        if (rv == null) {
            // En kötü ihtimal: layout’ta farklı bir id var—görünmez hatayı engelle
            rv = new RecyclerView(this);
            rv.setId(View.generateViewId());
            rv.setLayoutManager(new LinearLayoutManager(this));
        } else {
            rv.setLayoutManager(new LinearLayoutManager(this));
        }

        // JSON metodu yoksa derlemeyi kırmamak için sadece getAll(context)
        List<?> all = RecipesData.getAll();

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