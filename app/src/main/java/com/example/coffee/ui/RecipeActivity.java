package com.example.coffee.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.TextView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView txtCategory;
    private RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // DOĞRU LAYOUT ADI:
        setContentView(R.layout.activity_recipe);

        recyclerView = findViewById(R.id.recyclerView);
        txtCategory  = findViewById(R.id.txtCategory);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecipeAdapter(recipe -> {
            // tıklama: ileride detay sayfasına gidersin
            // startActivity(new Intent(this, RecipeDetailActivity.class).putExtra("recipe_name", recipe.getName()));
        });
        recyclerView.setAdapter(adapter);

        String category = getIntent() != null ? getIntent().getStringExtra("category") : null;
        if (!TextUtils.isEmpty(category)) {
            txtCategory.setText(category);
            txtCategory.setVisibility(TextView.VISIBLE);
        } else {
            txtCategory.setVisibility(TextView.GONE);
        }

        // Veri yükle (forCategory yoksa getAll'a düşer)
        List<Recipe> data = new ArrayList<>();
        try {
            if (!TextUtils.isEmpty(category)) {
                data = RecipesData.forCategory(category);
            } else {
                data = RecipesData.getAll();
            }
        } catch (Throwable ignore) {
            data = RecipesData.getAll();
        }
        adapter.submit(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView sv = (SearchView) item.getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String q) { adapter.filter(q); return true; }
            @Override public boolean onQueryTextChange(String q) { adapter.filter(q); return true; }
        });
        return true;
    }
}