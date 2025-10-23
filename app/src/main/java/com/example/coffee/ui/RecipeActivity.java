// app/src/main/java/com/example/coffee/ui/RecipeActivity.java
package com.example.coffee.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;

import java.util.List;

public class RecipeActivity extends Activity {

    private ListView listView;
    private TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        listView = findViewById(R.id.recipesList);
        emptyView = findViewById(R.id.emptyView);

        // Basit: tüm başlıkları tek listede gösteriyoruz
        List<String> titles = RecipesData.allTitles();

        if (titles.isEmpty()) {
            emptyView.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            return;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, titles
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onItemClick);
    }

    private final AdapterView.OnItemClickListener onItemClick =
            (parent, view, position, id) -> {
                String title = (String) parent.getItemAtPosition(position);
                Intent i = new Intent(RecipeActivity.this, RecipeDetailActivity.class);
                i.putExtra("title", title);
                startActivity(i);
            };
}
