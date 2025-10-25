package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;
import com.example.coffee.ui.RecipeAdapter;
import com.example.coffee.ui.RecipeDetailActivity;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rv = findViewById(R.id.rvRecipes);
        adapter = new RecipeAdapter(recipe -> {
            Intent i = new Intent(this, RecipeDetailActivity.class);
            // id / name vs. ne taşıyorsan:
            i.putExtra("recipe_name", recipe.getName());
            startActivity(i);
        });
        rv.setAdapter(adapter);

        // DEMO veri bağla (RecipesData içindeki uygun metodu kullan)
        List<Recipe> list = RecipesData.getAll(); // <-- eğer metot adı farklıysa (örn. getRecipes()) olarak değiştir
        adapter.submit(list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView sv = (SearchView) item.getActionView();
        sv.setQueryHint(getString(R.string.search));
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String q) {
                adapter.filter(q);
                return true;
            }
            @Override public boolean onQueryTextChange(String q) {
                adapter.filter(q);
                return true;
            }
        });
        return true;
    }
}
