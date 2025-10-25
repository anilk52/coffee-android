package com.example.coffee.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.List;

/**
 * Tarif detay ekranı (CollapsingToolbar + görsel + içerik).
 * MainActivity -> Intent extra:
 *   "recipe_name" (String)  : Zorunlu değil ama önerilir.
 *   "recipe_desc" (String)  : Opsiyonel; yoksa RecipesData'dan bulunur.
 */
public class RecipeDetailActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private CollapsingToolbarLayout collapsing;
    private ImageView imgHeader;
    private TextView txtContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_recipe_detail);

        // View’ları bağla
        toolbar = findViewById(R.id.toolbar);
        collapsing = findViewById(R.id.collapsing);
        imgHeader = findViewById(R.id.imgHeader);
        txtContent = findViewById(R.id.txtContent);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Intent’ten gelenler
        String nameExtra = getIntent().getStringExtra("recipe_name");
        String descExtra = getIntent().getStringExtra("recipe_desc");

        Recipe recipe = null;

        // Eğer sadece isim geldiyse data kaynağından bulmaya çalış
        if (!TextUtils.isEmpty(nameExtra)) {
            recipe = findRecipeByName(nameExtra);
        }

        // Başlık
        String title = (recipe != null && !TextUtils.isEmpty(recipe.getName()))
                ? recipe.getName()
                : (TextUtils.isEmpty(nameExtra) ? getString(R.string.app_name) : nameExtra);
        collapsing.setTitle(title);

        // İçerik (açıklama)
        String content =
                (descExtra != null && !descExtra.trim().isEmpty()) ? descExtra :
                (recipe != null && recipe.getDescription() != null && !recipe.getDescription().trim().isEmpty())
                        ? recipe.getDescription()
                        : getString(R.string.app_name) + " — Afiyet olsun!";

        txtContent.setText(content);

        // Üst görsel (varsa); yoksa uygulama ikonu ile devam et
        if (recipe != null && recipe.getImageResId() != 0) {
            imgHeader.setImageResource(recipe.getImageResId());
        } else {
            // Projede hazır olan foreground’u kullanıyoruz; istersen başka bir drawable koy
            imgHeader.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    // Basit isimle arama — RecipesData.getAll() mevcut olmalı
    private @Nullable Recipe findRecipeByName(String name) {
        try {
            List<Recipe> all = RecipesData.getAll(); // Metod ismi farklıysa burada güncelle
            if (all != null) {
                for (Recipe r : all) {
                    if (r != null && r.getName() != null
                            && r.getName().equalsIgnoreCase(name)) {
                        return r;
                    }
                }
            }
        } catch (Throwable ignore) { /* veri kaynağı farklı olabilir, güvende kal */ }
        return null;
    }
}
