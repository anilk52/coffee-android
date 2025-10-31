package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    private ImageView coffeeImage, shareButton;
    private TextView coffeeName, coffeeDescription, coffeeMeasure, coffeeTip, coffeeNote;

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_recipe_detail);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        if (recipe.getImageResId() != 0) coffeeImage.setImageResource(recipe.getImageResId());
        else coffeeImage.setImageResource(R.drawable.ic_placeholder_logo);

        coffeeName.setText(recipe.getName());
        coffeeDescription.setText(recipe.getDescription());
        coffeeMeasure.setText(recipe.getMeasure());
        coffeeTip.setText(recipe.getTip());
        coffeeNote.setText(recipe.getNote());
        setTitle(recipe.getName());

        shareButton.setOnClickListener(v -> shareCurrent());
    }

    private void shareCurrent() {
        String title = coffeeName.getText().toString();
        String body  = coffeeDescription.getText().toString();
        String shareText = title + "\n\n" + body;

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_SUBJECT, title);
        share.putExtra(Intent.EXTRA_TEXT, shareText);
        startActivity(Intent.createChooser(share, getString(R.string.share)));
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recipe_detail, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) { onBackPressed(); return true; }
        if (item.getItemId() == R.id.action_share) { shareCurrent(); return true; }
        return super.onOptionsItemSelected(item);
    }
}