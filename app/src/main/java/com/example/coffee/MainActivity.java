package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.ui.FavoritesActivity;
import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY = "category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // KART TIKLAMALARI
        setupCard(R.id.cardEspresso, "Espresso");
        setupCard(R.id.cardFilter,   "Filtre");
        setupCard(R.id.cardSpecial,  "Special");
        setupCard(R.id.cardAlcoholic,"Alkollü");
        setupCard(R.id.cardIced,     "Iced");
        setupCard(R.id.cardTurkish,  "Türk");
    }

    private void setupCard(int viewId, String category){
        View v = findViewById(viewId);
        if (v != null) {
            v.setOnClickListener(l -> {
                Intent i = new Intent(this, RecipeActivity.class);
                i.putExtra(EXTRA_CATEGORY, category);
                startActivity(i);
            });
        }
    }

    // (Favoriler/Ayarlar menüsü sende varsa kalsın)
    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_favorites) {
            startActivity(new Intent(this, FavoritesActivity.class));
            return true;
        }
        // ayarlar vs...
        return super.onOptionsItemSelected(item);
    }
}