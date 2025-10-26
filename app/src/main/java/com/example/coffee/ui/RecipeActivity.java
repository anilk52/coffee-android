package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private RecipeAdapter adapter;
    private TextView emptyView;
    private TextView txtCategory;
    private SearchView searchView;

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

        LinearLayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, lm.getOrientation()));

        adapter = new RecipeAdapter(recipe -> {
            Intent i = new Intent(this, RecipeDetailActivity.class);
            i.putExtra("recipe_name", recipe.getName());
            i.putExtra("recipe_desc", recipe.getDescription());
            startActivity(i);
        });
        recyclerView.setAdapter(adapter);
        adapter.submit(recipes);
        toggleEmpty(adapter.getItemCount() == 0);

        // Arama
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String q) {
                adapter.filter(q);
                toggleEmpty(adapter.getItemCount() == 0);
                return true;
            }
            @Override public boolean onQueryTextChange(String q) {
                adapter.filter(q);
                toggleEmpty(adapter.getItemCount() == 0);
                return true;
            }
        });

        // Hızlı boyut filtreleri (S / M / L anahtarına göre açıklamada arar)
        btnAll.setOnClickListener(v -> {
            searchView.setQuery("", false);
            adapter.filter(null);
            toggleEmpty(adapter.getItemCount() == 0);
        });
        btnS.setOnClickListener(v -> {
            searchView.setQuery("S —", false);
            adapter.filter("S —");
            toggleEmpty(adapter.getItemCount() == 0);
        });
        btnM.setOnClickListener(v -> {
            searchView.setQuery("M —", false);
            adapter.filter("M —");
            toggleEmpty(adapter.getItemCount() == 0);
        });
        btnL.setOnClickListener(v -> {
            searchView.setQuery("L —", false);
            adapter.filter("L —");
            toggleEmpty(adapter.getItemCount() == 0);
        });
    }

    private void toggleEmpty(boolean show) {
        if (emptyView != null) emptyView.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}