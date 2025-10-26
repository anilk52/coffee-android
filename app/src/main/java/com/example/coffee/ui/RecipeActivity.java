package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.adapter.RecipeAdapter;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recyclerView = findViewById(R.id.recyclerView);
        TextView txtCategory = findViewById(R.id.txtCategory);

        category = getIntent().getStringExtra("category");
        txtCategory.setText(category != null ? category : "Kahveler");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Recipe> recipes = RecipesData.getByCategory(category);
        adapter = new RecipeAdapter(recipes, recipe -> {
            Intent intent = new Intent(RecipeActivity.this, RecipeDetailActivity.class);
            intent.putExtra("recipeName", recipe.getName());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
    }
}