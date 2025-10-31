package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    private ImageView coffeeImage, shareButton;
    private TextView coffeeName, coffeeDescription, coffeeMeasure, coffeeTip, coffeeNote;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        coffeeImage       = findViewById(R.id.coffeeImage);
        shareButton       = findViewById(R.id.shareButton);
        coffeeName        = findViewById(R.id.coffeeName);
        coffeeDescription = findViewById(R.id.coffeeDescription);
        coffeeMeasure     = findViewById(R.id.coffeeMeasure);
        coffeeTip         = findViewById(R.id.coffeeTip);
        coffeeNote        = findViewById(R.id.coffeeNote);

        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("recipe")) {
            Toast.makeText(this, "Tarif bulunamadı.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        Recipe recipe = (Recipe) intent.getSerializableExtra("recipe");
        if (recipe == null) {
            Toast.makeText(this, "Tarif yüklenemedi.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        if (recipe.getImageResId() != 0) {
            coffeeImage.setImageResource(recipe.getImageResId());
        } else {
            coffeeImage.setImageResource(R.drawable.ic_placeholder_logo);
        }

        coffeeName.setText(safe(recipe.getName()));
        coffeeDescription.setText(safe(recipe.getDescription()));
        coffeeMeasure.setText(safe(recipe.getMeasure()));
        coffeeTip.setText(safe(recipe.getTip()));
        coffeeNote.setText(safe(recipe.getNote()));

        setTitle(recipe.getName());

        shareButton.setOnClickListener(v -> {
            String shareText = coffeeName.getText() + "\n\n" + coffeeDescription.getText();
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_SUBJECT, coffeeName.getText().toString());
            share.putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(Intent.createChooser(share, getString(R.string.share_recipe)));
        });
    }

    private String safe(@Nullable String s) {
        return s == null ? "" : s;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}