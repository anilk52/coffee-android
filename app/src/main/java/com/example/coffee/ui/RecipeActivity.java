// app/src/main/java/com/example/coffee/ui/RecipesActivity.java
package com.example.coffee.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;
import java.util.ArrayList;
import java.util.List;

public class RecipesActivity extends AppCompatActivity {
    private static final String EXTRA_CATEGORY = "extra_category";
    private List<Recipe> current = new ArrayList<>();

    public static void start(Context ctx, String category) {
        Intent i = new Intent(ctx, RecipesActivity.class);
        i.putExtra(EXTRA_CATEGORY, category);
        ctx.startActivity(i);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        String category = getIntent().getStringExtra(EXTRA_CATEGORY);
        current = RecipesData.getRecipes(category);

        List<String> titles = new ArrayList<>();
        for (Recipe r : current) titles.add(r.title);

        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, titles));

        lv.setOnItemClickListener((parent, view, position, id) ->
                RecipeDetailActivity.start(this, current.get(position)));
    }
}
