// app/src/main/java/com/example/coffee/ui/RecipeActivity.java
package com.example.coffee.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private static final String EXTRA_CATEGORY = "category";

    public static void start(Context ctx, String category) {
        Intent i = new Intent(ctx, RecipeActivity.class);
        i.putExtra(EXTRA_CATEGORY, category);
        ctx.startActivity(i);
    }

    private ListView listView;
    private TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        listView = findViewById(R.id.recipesList);
        emptyView = findViewById(R.id.emptyView);

        String category = getIntent().getStringExtra(EXTRA_CATEGORY);
        List<String> titles = (category == null || category.isEmpty())
                ? RecipesData.allTitles()
                : RecipesData.titlesForCategory(category);

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
