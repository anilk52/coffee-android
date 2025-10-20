package com.example.coffee.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private static final String EXTRA_CATEGORY = "extra_category";

    public static void start(Context ctx, String category) {
        Intent i = new Intent(ctx, RecipeActivity.class);
        i.putExtra(EXTRA_CATEGORY, category);
        ctx.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        String category = getIntent().getStringExtra(EXTRA_CATEGORY);
        if (category == null) category = "ESPRESSO";

        // Basit demo veri (gerçek tarif veritabanı gelene kadar)
        List<String> items = new ArrayList<>();
        switch (category) {
            case "FILTER":
                items = Arrays.asList(
                        "V60",
                        "Chemex",
                        "French Press",
                        "Aeropress",
                        "Kalita Wave"
                );
                setTitle("Filtre Kahveler");
                break;
            case "ALCOHOL":
                items = Arrays.asList(
                        "Irish Coffee",
                        "Espresso Martini",
                        "Carajillo",
                        "Caffè Corretto",
                        "Kahlúa Latte"
                );
                setTitle("Alkollü Kahveler");
                break;
            case "ESPRESSO":
            default:
                items = Arrays.asList(
                        "Espresso",
                        "Americano",
                        "Cappuccino",
                        "Latte",
                        "Flat White"
                );
                setTitle("Espresso Bazlılar");
                break;
        }

        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
        lv.setOnItemClickListener((parent, view, position, id) -> {
            String name = items.get(position);
            Toast.makeText(this, "Seçildi: " + name, Toast.LENGTH_SHORT).show();
            // Sonraki aşama: RecipeDetailActivity.start(this, category, name);
        });
    }
}        lv.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, titles));

        lv.setOnItemClickListener((parent, view, position, id) ->
                RecipeDetailActivity.start(this, current.get(position)));
    }
}
