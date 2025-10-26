package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private RecipeAdapter adapter;
    private SearchView searchView;
    private TextView emptyView;
    private TextView txtCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        emptyView   = findViewById(R.id.emptyView);
        txtCategory = findViewById(R.id.txtCategory);
        searchView  = findViewById(R.id.searchView);
        Button btnAll = findViewById(R.id.btnAll);
        Button btnS   = findViewById(R.id.btnS);
        Button btnM   = findViewById(R.id.btnM);
        Button btnL   = findViewById(R.id.btnL);

        String category = getIntent() != null ? getIntent().getStringExtra("category") : "Tarifler";
        txtCategory.setText(category);

        List<Recipe> recipes = RecipesData.forCategory(category);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecipeAdapter(recipe -> {
            Intent i = new Intent(this, RecipeDetailActivity.class);
            i.putExtra("recipe_name", recipe.getName());
            i.putExtra("recipe_desc", recipe.getDescription());
            startActivity(i);
        });
        recyclerView.setAdapter(adapter);
        adapter.submit(recipes);

        toggleEmpty(recipes == null || recipes.isEmpty());

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String q) { adapter.filter(q); return true; }
            @Override public boolean onQueryTextChange(String q) { adapter.filter(q); return true; }
        });

        btnAll.setOnClickListener(v -> adapter.filter(null));
        btnS.setOnClickListener(v -> adapter.filter("S —"));
        btnM.setOnClickListener(v -> adapter.filter("M —"));
        btnL.setOnClickListener(v -> adapter.filter("L —"));
    }

    private void toggleEmpty(boolean show) {
        if (emptyView != null) emptyView.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}