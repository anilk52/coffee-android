package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        ListView listView = findViewById(R.id.recipesList);
        TextView emptyView = findViewById(R.id.emptyView);

        // MainActivity’den gelen kategori (Espresso / Filtre / Special / Alkollü / Ice)
        String category = getIntent() != null ? getIntent().getStringExtra("category") : null;

        // Kategoriye göre başlıkları al
        List<String> titles = (category == null || category.trim().isEmpty())
                ? RecipesData.allTitles()
                : RecipesData.titlesForCategory(category);

        // Boş durum kontrolü
        if (titles == null || titles.isEmpty()) {
            if (emptyView != null) {
                emptyView.setText(R.string.no_recipes);
                emptyView.setVisibility(View.VISIBLE);
            }
            if (listView != null) listView.setVisibility(View.GONE);
            return;
        }

        if (emptyView != null) emptyView.setVisibility(View.GONE);
        if (listView != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_list_item_1, titles);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener((parent, view, position, id) -> {
                String title = adapter.getItem(position);
                Intent i = new Intent(this, RecipeDetailActivity.class);
                i.putExtra("title", title);
                startActivity(i);
            });
        }
    }
}