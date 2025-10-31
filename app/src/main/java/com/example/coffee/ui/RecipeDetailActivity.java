package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        // ELİNDEKİ XML: activity_recipe_detail
        setContentView(R.layout.activity_recipe_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

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

        // BURADA HİÇBİR VIEW ID’YE DOKUNMUYORUZ (ID bulunamadı hatalarını kesmek için)
        // Sadece başlığı ayarlıyoruz.
        setTitle(recipe.getName() != null ? recipe.getName() : getString(R.string.app_name));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}