package com.example.coffee.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY = "extra_category"; // String

    private RecipeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        RecyclerView recycler = findViewById(R.id.recyclerRecipes);
        EditText search = findViewById(R.id.edtSearch);

        String category = getIntent().getStringExtra(EXTRA_CATEGORY);
        List<Recipe> data = category == null ? RecipesData.getAll() : RecipesData.forCategory(category);

        adapter = new RecipeAdapter(this, data);
        adapter.setOnItemClick(item ->
                RecipeDetailActivity.start(this, item.getName())
        );

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        if (search != null) {
            search.addTextChangedListener(new TextWatcher() {
                @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
                @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
                @Override public void afterTextChanged(Editable s) {
                    adapter.getFilter().filter(s == null ? "" : s.toString());
                }
            });
        }
    }
}