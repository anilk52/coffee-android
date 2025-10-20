// app/src/main/java/com/example/coffee/ui/RecipeDetailActivity.java
package com.example.coffee.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.coffee.R;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {
    private static final String EXTRA_RECIPE = "extra_recipe";

    public static void start(Context ctx, Recipe recipe) {
        Intent i = new Intent(ctx, RecipeDetailActivity.class);
        i.putExtra(EXTRA_RECIPE, recipe);
        ctx.startActivity(i);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        Recipe r = (Recipe) getIntent().getSerializableExtra(EXTRA_RECIPE);

        ((TextView) findViewById(R.id.title)).setText(r.title);
        ((TextView) findViewById(R.id.ing)).setText(r.ingredients);
        ((TextView) findViewById(R.id.steps)).setText(r.steps);
        ((TextView) findViewById(R.id.tip)).setText(r.tip == null ? "" : "İpucu: " + r.tip);
    }
}
