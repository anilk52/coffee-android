package com.example.coffee.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.animation.AnimationUtils;
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
    private final List<Recipe> filtered = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_recipe);

        recyclerRecipes = findViewById(R.id.recyclerRecipes);
        searchInput = findViewById(R.id.searchInput);

        recyclerRecipes.setLayoutManager(new LinearLayoutManager(this));
        allRecipes.addAll(RecipesData.getAll());
        filtered.addAll(allRecipes);

        adapter = new RecipeAdapter(this, filtered);
        recyclerRecipes.setAdapter(adapter);

        // İlk açılış animasyonu
        recyclerRecipes.setLayoutAnimation(
                AnimationUtils.loadLayoutAnimation(this, R.anim.layout_fall_down));
        recyclerRecipes.scheduleLayoutAnimation();

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String q = s.toString().toLowerCase();
                filtered.clear();
                for (Recipe r : allRecipes) {
                    if (r.getName().toLowerCase().contains(q) ||
                        r.getDescription().toLowerCase().contains(q)) {
                        filtered.add(r);
                    }
                }
                adapter.notifyDataSetChanged();
                recyclerRecipes.scheduleLayoutAnimation();
            }
        });
    }
}