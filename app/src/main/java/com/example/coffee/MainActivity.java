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

        // Toolbar ayarı
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // --- Kategori kartlarını dinle ---
        findViewById(R.id.cardEspresso).setOnClickListener(this);
        findViewById(R.id.cardFilter).setOnClickListener(this);
        findViewById(R.id.cardSpecial).setOnClickListener(this);
        findViewById(R.id.cardAlcoholic).setOnClickListener(this);
        findViewById(R.id.cardIced).setOnClickListener(this);
        findViewById(R.id.cardTurkish).setOnClickListener(this);
    }

    // --- Menü oluşturma ---
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // --- Menü tıklamaları ---
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_favorites) {
            startActivity(new Intent(this, FavoritesActivity.class));
            return true;
        } else if (id == R.id.action_settings) {
            // SettingsActivity daha sonra eklenecek
            // startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // --- Kart tıklamaları ---
    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, RecipeActivity.class);
        switch (v.getId()) {
            case R.id.cardEspresso:
                i.putExtra("category", "Espresso");
                break;
            case R.id.cardFilter:
                i.putExtra("category", "Filter");
                break;
            case R.id.cardSpecial:
                i.putExtra("category", "Special");
                break;
            case R.id.cardAlcoholic:
                i.putExtra("category", "Alcoholic");
                break;
            case R.id.cardIced:
                i.putExtra("category", "Iced");
                break;
            case R.id.cardTurkish:
                i.putExtra("category", "Turkish");
                break;
            default:
                i.putExtra("category", "All");
        }
        startActivity(i);
    }

    // --- Geri tuşu ile çıkış onayı ---
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}