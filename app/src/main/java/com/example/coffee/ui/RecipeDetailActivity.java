package com.example.coffee.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    private ImageView imgRecipe;
    private TextView txtName, txtDesc, txtCup, txtTip;

    // 🔹 Kolay başlatma metodu
    public static void start(Context ctx, String recipeName) {
        Intent i = new Intent(ctx, RecipeDetailActivity.class);
        i.putExtra("recipe_name", recipeName);
        ctx.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        imgRecipe = findViewById(R.id.imgRecipe);
        txtName = findViewById(R.id.txtName);
        txtDesc = findViewById(R.id.txtDesc);
        txtCup = findViewById(R.id.txtCup);
        txtTip = findViewById(R.id.txtTip);

        // Gelen tarif ismini al
        String name = getIntent().getStringExtra("recipe_name");
        if (name == null) {
            finish();
            return;
        }

        // Tarifleri bul ve eşleşeni göster
        Recipe target = null;
        for (Recipe r : RecipesData.getAll()) {
            if (r.getName().equalsIgnoreCase(name)) {
                target = r;
                break;
            }
        }

        if (target == null) {
            txtName.setText("Tarif bulunamadı");
            return;
        }

        // Görseller ve bilgiler
        txtName.setText(target.getName());
        txtDesc.setText(target.getDescription());
        txtCup.setText(target.getCupSize());
        txtTip.setText(getTipFor(target.getName()));

        if (target.getImageRes() != 0) {
            imgRecipe.setImageResource(target.getImageRes());
        } else {
            imgRecipe.setImageResource(R.drawable.ic_placeholder_logo);
        }
    }

    // 🔹 Küçük barista ipuçları
    private String getTipFor(String name) {
        switch (name.toLowerCase()) {
            case "espresso": return "Shot 25 sn civarı akmalı.";
            case "doppio": return "İki shot; öğütüm biraz daha kalın.";
            case "latte": return "Süt 60°C, köpüğü kadifemsi olsun.";
            case "cappuccino": return "Köpük kubbe gibi kabarsın.";
            case "affogato": return "Espressoyu dondurmanın üstüne hemen dök.";
            case "turk kahvesi": return "Köpüğü taşmadan alın; yavaş ateşte pişirin.";
            default: return "Barista ipucu: Demleme süresini not al, kıvamını yakala!";
        }
    }
}