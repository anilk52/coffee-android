package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.List;

public class RecipeActivity extends AppCompatActivity implements RecipeAdapter.OnRecipeClick {

    private RecipeAdapter adapter;

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_recipe);

        String category = getIntent().getStringExtra("category");
        TextView txtCategory = findViewById(R.id.txtCategory);
        txtCategory.setText(category);

        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));

        List<Recipe> data = RecipesData.forCategory(category);
        adapter = new RecipeAdapter(data, this);
        rv.setAdapter(adapter);
    }

    @Override public void onRecipeClick(Recipe recipe) {
        Intent i = new Intent(this, RecipeDetailActivity.class);
        i.putExtra("name", recipe.getName());
        startActivity(i);
    }
}