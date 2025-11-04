package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY = "extra_category";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ÜST İKONLAR
        ImageView btnFavorites = findViewById(R.id.btnFavorites);
        ImageView btnAiBarista = findViewById(R.id.btnAiBarista);
        ImageView btnSettings  = findViewById(R.id.btnSettings);

        if (btnFavorites != null) {
            btnFavorites.setOnClickListener(v ->
                    Toast.makeText(this, "Favoriler yakında gelecek ✨", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnAiBarista != null) {
            btnAiBarista.setOnClickListener(v ->
                    Toast.makeText(this, "AI Barista modu yakında 💡", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnSettings != null) {
            btnSettings.setOnClickListener(v ->
                    Toast.makeText(this, "Ayarlar yakında ⚙️", Toast.LENGTH_SHORT).show()
            );
        }

        // KATEGORİ KARTLARI
        initCategoryClick(R.id.cardEspresso, "Espresso");
        initCategoryClick(R.id.cardFilter,   "Filter");
        initCategoryClick(R.id.cardSpecial,  "Special");
        initCategoryClick(R.id.cardAlcoholic,"Alcoholic");
        initCategoryClick(R.id.cardIced,     "Iced");
        initCategoryClick(R.id.cardTurkish,  "Turkish");
    }

    private void initCategoryClick(int viewId, final String category) {
        View card = findViewById(viewId);
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
                intent.putExtra(EXTRA_CATEGORY, category);
                startActivity(intent);
            });
        }
    }
}