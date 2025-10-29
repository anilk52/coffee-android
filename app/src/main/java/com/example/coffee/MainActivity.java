package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.data.RecipesData;
import com.example.coffee.ui.RecipeActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    private void openCategory(String catKey) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("category", catKey);
        startActivity(i);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((MaterialCardView) findViewById(R.id.cardEspresso))
                .setOnClickListener(v -> openCategory(RecipesData.CAT_ESPRESSO));

        ((MaterialCardView) findViewById(R.id.cardFiltre))
                .setOnClickListener(v -> openCategory(RecipesData.CAT_FILTRE));

        ((MaterialCardView) findViewById(R.id.cardSpecial))
                .setOnClickListener(v -> openCategory(RecipesData.CAT_SPECIAL));

        ((MaterialCardView) findViewById(R.id.cardAlkollu))
                .setOnClickListener(v -> openCategory(RecipesData.CAT_ALKOLLU));

        ((MaterialCardView) findViewById(R.id.cardIce))
                .setOnClickListener(v -> openCategory(RecipesData.CAT_ICE));

        ((MaterialCardView) findViewById(R.id.cardTurk))
                .setOnClickListener(v -> openCategory(RecipesData.CAT_TURK));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            Toast.makeText(this, "Arama yakında ✨", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_favorites) {
            Toast.makeText(this, "Favoriler yakında ⭐", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_settings) {
            Toast.makeText(this, "Ayarlar yakında ⚙️", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}