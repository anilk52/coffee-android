package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.coffee.ui.AiBaristaActivity;
import com.example.coffee.ui.FavoritesActivity;
import com.example.coffee.ui.RecipeActivity;
import com.example.coffee.ui.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY = "category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 🔸 KATEGORİ KARTLARI
        // Burada id'ler varsa tıklama verir, yoksa sessizce geçer.
        bindCategoryCard("cardEspresso", "espresso");
        bindCategoryCard("cardFilter",   "filter");
        bindCategoryCard("cardSpecial",  "special");
        bindCategoryCard("cardAlcohol",  "alcohol");  // layout'ta yoksa sorun olmaz
        bindCategoryCard("cardIced",     "iced");
        bindCategoryCard("cardTurkish",  "turkish");

        // 🔸 FAVORİLER TUŞU
        // Farklı isim ihtimaline karşı 2 deneme yapıyoruz (btnFavorites / btnFav)
        bindClickIfExists("btnFavorites", v -> {
            Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
            startActivity(intent);
        });
        bindClickIfExists("btnFav", v -> {
            Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
            startActivity(intent);
        });

        // 🔸 AYARLAR TUŞU
        bindClickIfExists("btnSettings", v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        // 🔸 ANA EKRAN AI TUŞU → GENEL MİLO SOHBETİ
        // Id farklı olabilir diye iki isim deniyorum: btnAI ve btnAi
        View.OnClickListener aiClick = v -> {
            Intent intent = new Intent(MainActivity.this, AiBaristaActivity.class);
            // Tarif göndermiyoruz → MİLO genel kahve modu
            startActivity(intent);
        };
        bindClickIfExists("btnAI", aiClick);
        bindClickIfExists("btnAi", aiClick);
    }

    // ----------------------------------------------------------
    // Yardımcı: Kategori kartını id adına göre bul & tıklamayı bağla
    // ----------------------------------------------------------
    private void bindCategoryCard(String idName, String category) {
        int resId = getResources().getIdentifier(idName, "id", getPackageName());
        if (resId != 0) {
            View v = findViewById(resId);
            if (v instanceof CardView) {
                v.setOnClickListener(view -> openRecipeActivity(category));
            } else if (v != null) {
                // CardView değilse bile tıklama ver
                v.setOnClickListener(view -> openRecipeActivity(category));
            }
        }
    }

    // ----------------------------------------------------------
    // Yardımcı: Varsa bu id'ye sahip view'e tıklama bağla
    // ----------------------------------------------------------
    private void bindClickIfExists(String idName, View.OnClickListener listener) {
        int resId = getResources().getIdentifier(idName, "id", getPackageName());
        if (resId != 0) {
            View v = findViewById(resId);
            if (v != null) {
                v.setOnClickListener(listener);
            }
        }
    }

    private void openRecipeActivity(String category) {
        Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
        intent.putExtra(EXTRA_CATEGORY, category);
        startActivity(intent);
    }
}