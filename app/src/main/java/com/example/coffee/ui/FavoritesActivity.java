package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Favori kahveleri listeleyen ekran (şimdilik sade versiyon).
 * Eğer başka bir ekrandan "favorites" listesi gönderilirse onu gösterir,
 * yoksa boş bir liste görünür (ileride boş mesaj ekleyebiliriz).
 */
public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView recyclerFavorites;
    private RecipeAdapter adapter;
    private final List<Recipe> favoriteList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        recyclerFavorites = findViewById(R.id.recyclerFavorites);
        recyclerFavorites.setLayoutManager(new LinearLayoutManager(this));

        // Eğer başka bir ekrandan "favorites" listesi geldiyse al
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("favorites")) {
            try {
                ArrayList<Recipe> passed =
                        (ArrayList<Recipe>) intent.getSerializableExtra("favorites");
                if (passed != null) {
                    favoriteList.clear();
                    favoriteList.addAll(passed);
                }
            } catch (Exception ignored) {
                // Hata olursa liste boş kalır
            }
        }

        adapter = new RecipeAdapter(this, favoriteList);
        recyclerFavorites.setAdapter(adapter);
    }
}