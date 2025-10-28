package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        setSupportActionBar(findViewById(R.id.topAppBar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.topAppBar).setOnClickListener(v -> onBackPressed());

        TextView txtCat = findViewById(R.id.txtCategory);
        EditText edtSearch = findViewById(R.id.edtSearch);
        RecyclerView rv = findViewById(R.id.rvList);

        String category = getIntent() != null ? getIntent().getStringExtra("category") : null;
        if (category == null) category = "Tüm Tarifler";
        txtCat.setText(category);

        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecipeAdapter(recipe -> {
            Intent i = new Intent(this, RecipeDetailActivity.class);
            i.putExtra("recipe_name", recipe.getName());
            i.putExtra("recipe_desc", recipe.getDescription());
            startActivity(i);
        });
        rv.setAdapter(adapter);

        // veri
        List<Recipe> all = RecipesData.getAll();
        List<Recipe> filtered = new ArrayList<>();
        if (all != null) {
            for (Recipe r : all) {
                if (category.equals("Tüm Tarifler") || category.equalsIgnoreCase(r.getCategory())) {
                    filtered.add(r);
                }
            }
        }
        adapter.submit(filtered);

        // arama
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int st, int c, int a) {}
            @Override public void onTextChanged(CharSequence s, int st, int b, int c) {}
            @Override public void afterTextChanged(Editable s) { adapter.filter(s == null ? null : s.toString()); }
        });
    }
}