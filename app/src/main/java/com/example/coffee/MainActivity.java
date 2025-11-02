package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.coffee.ui.FavoritesActivity;
import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.cardEspresso).setOnClickListener(this);
        findViewById(R.id.cardFilter).setOnClickListener(this);
        findViewById(R.id.cardSpecial).setOnClickListener(this);
        findViewById(R.id.cardAlcoholic).setOnClickListener(this);
        findViewById(R.id.cardIced).setOnClickListener(this);
        findViewById(R.id.cardTurkish).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_favorites) {
            startActivity(new Intent(this, FavoritesActivity.class));
            return true;
        } else if (id == R.id.action_settings) {
            // SettingsActivity sonra
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, RecipeActivity.class);

        // NOT: AGP 8+ 'da R.id non-final → switch yerine if/else kullan
        int vid = v.getId();
        if (vid == R.id.cardEspresso) {
            i.putExtra("category", "Espresso");
        } else if (vid == R.id.cardFilter) {
            i.putExtra("category", "Filter");
        } else if (vid == R.id.cardSpecial) {
            i.putExtra("category", "Special");
        } else if (vid == R.id.cardAlcoholic) {
            i.putExtra("category", "Alcoholic");
        } else if (vid == R.id.cardIced) {
            i.putExtra("category", "Iced");
        } else if (vid == R.id.cardTurkish) {
            i.putExtra("category", "Turkish");
        } else {
            i.putExtra("category", "All");
        }

        startActivity(i);
    }

    @Override
    public void onBackPressed() { moveTaskToBack(true); }
}