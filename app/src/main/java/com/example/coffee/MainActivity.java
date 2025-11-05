package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.ui.FavoritesActivity;
import com.example.coffee.ui.RecipeActivity;
import com.example.coffee.ui.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    // Tarif listesine kategori göndermek için key
    public static final String EXTRA_CATEGORY = "extra_category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Üst menü ikonları
        ImageView btnFavorite = findViewById(R.id.btnFavorite);
        ImageView btnAi       = findViewById(R.id.btnAi);
        ImageView btnSettings = findViewById(R.id.btnSettings);
        TextView  txtFooter   = findViewById(R.id.txtFooter);

        // Footer yazısı (varsa)
        if (txtFooter != null) {
            txtFooter.setText(R.string.main_footer);
        }

        // Favoriler
        if (btnFavorite != null) {
            btnFavorite.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
                startActivity(intent);
            });
        }

        // AI Barista (şimdilik sadece bilgi)
        if (btnAi != null) {
            btnAi.setOnClickListener(v ->
                    Toast.makeText(MainActivity.this,
                            R.string.ai_barista,
                            Toast.LENGTH_SHORT
                    ).show()
            );
        }

        // Ayarlar
        if (btnSettings != null) {
            btnSettings.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            });
        }

        // Ana kategori kartları
        initCategoryClick(R.id.cardEspresso, "espresso");
        initCategoryClick(R.id.cardFilter,   "filter");
        initCategoryClick(R.id.cardSpecial,  "special");
        initCategoryClick(R.id.cardAlcoholic,"alcoholic");
        initCategoryClick(R.id.cardIced,     "iced");
        initCategoryClick(R.id.cardTurkish,  "turkish");
    }

    /**
     * Belirli bir kart ID’sine tıklanınca ilgili kategoriyle RecipeActivity’yi açar.
     */
    private void initCategoryClick(int cardId, String categoryKey) {
        View card = findViewById(cardId);
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
                intent.putExtra(EXTRA_CATEGORY, categoryKey);
                startActivity(intent);
            });
        }
    }
}