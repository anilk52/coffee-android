package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.coffee.ui.RecipeActivity;
import com.example.coffee.ui.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        if (getSupportActionBar() != null) getSupportActionBar().setTitle("BDINO Coffee");

        setupCard(findViewById(R.id.cardEspresso));
        setupCard(findViewById(R.id.cardFilter));
        setupCard(findViewById(R.id.cardSpecial));
        setupCard(findViewById(R.id.cardAlcoholic));
        setupCard(findViewById(R.id.cardIced));
        setupCard(findViewById(R.id.cardTurkish));
    }

    private void setupCard(FrameLayout card) {
        if (card == null) return;
        card.setOnClickListener(v -> startActivity(new Intent(this, RecipeActivity.class)));
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}