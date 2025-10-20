package com.example.coffee;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RecipesActivity extends AppCompatActivity {
    private static final String EXTRA_CATEGORY = "CATEGORY";

    public static void start(Context ctx, String category) {
        Intent i = new Intent(ctx, RecipesActivity.class);
        i.putExtra(EXTRA_CATEGORY, category);
        ctx.startActivity(i);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String category = getIntent().getStringExtra(EXTRA_CATEGORY);
        TextView tv = new TextView(this);
        tv.setText("Kategori: " + category + "\n(Burada liste gelecek)");
        tv.setTextSize(20);
        setContentView(tv);
    }
}
