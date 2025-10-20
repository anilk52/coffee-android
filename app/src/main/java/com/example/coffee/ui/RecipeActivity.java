package com.example.coffee.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private static final String EXTRA_CATEGORY = "extra_category";
    private final List<Recipe> current = new ArrayList<>();

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

        // 5 gerçekçi örnek (kısa açıklama)
        List<String> names;
        switch (category) {
            case "FILTER":
                setTitle("Filtre Kahveler");
                names = Arrays.asList("V60", "Chemex", "French Press", "Aeropress", "Kalita Wave");
                break;
            case "ALCOHOL":
                setTitle("Alkollü Kahveler");
                names = Arrays.asList("Irish Coffee", "Espresso Martini", "Carajillo",
                        "Caffè Corretto", "Kahlua Latte");
                break;
            case "ESPRESSO":
            default:
                setTitle("Espresso Bazlılar");
                names = Arrays.asList("Espresso", "Americano", "Cappuccino", "Latte", "Flat White");
                break;
        }

        // Basit açıklamalar
        current.clear();
        for (String n : names) {
            String d = "Hazırlanışı: kaliteli kahve, doğru öğütüm ve uygun oranlarla " +
                    "demlenir. (" + n + ")";
            current.add(new Recipe(n, d));
        }

        ListView lv = findViewById(R.id.listView);
        ArrayAdapter<String> ad = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, names);
        lv.setAdapter(ad);

        lv.setOnItemClickListener((parent, view, position, id) ->
                RecipeDetailActivity.start(this, current.get(position)));
    }
}