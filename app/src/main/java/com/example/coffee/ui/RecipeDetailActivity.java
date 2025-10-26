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
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;

public class RecipeDetailActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private CollapsingToolbarLayout collapsing;
    private ImageView imgHeader;
    private TextView txtContent, txtCupSize, txtTips;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_recipe_detail);

        // View’lar
        toolbar = findViewById(R.id.toolbar);
        collapsing = findViewById(R.id.collapsing);
        imgHeader = findViewById(R.id.imgHeader);
        txtContent = findViewById(R.id.txtContent);
        txtCupSize = findViewById(R.id.txtCupSize);
        txtTips = findViewById(R.id.txtTips);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Intent verileri
        String nameExtra = getIntent().getStringExtra("recipe_name");
        String descExtra = getIntent().getStringExtra("recipe_desc");

        // Veri kaynağından bul
        Recipe recipe = null;
        if (!TextUtils.isEmpty(nameExtra)) {
            recipe = findRecipeByName(nameExtra);
        }

        // Başlık
        String title = (recipe != null && !TextUtils.isEmpty(recipe.getName()))
                ? recipe.getName()
                : (!TextUtils.isEmpty(nameExtra) ? nameExtra : getString(R.string.app_name));
        collapsing.setTitle(title);

        // İçerik (açıklama)
        String content =
                !TextUtils.isEmpty(descExtra) ? descExtra :
                (recipe != null && !TextUtils.isEmpty(recipe.getDescription()))
                        ? recipe.getDescription()
                        : getString(R.string.app_name) + " — Afiyet olsun!";
        txtContent.setText(content);

        // Bardak boyutu
        if (txtCupSize != null) {
            String cup = (recipe != null && !TextUtils.isEmpty(recipe.getCupSize()))
                    ? recipe.getCupSize()
                    : "—";
            txtCupSize.setText(cup);
        }

        // Barista ipucu  (DÜZELTİLDİ: getTips() yerine getTip())
        if (txtTips != null) {
            String tips = (recipe != null && !TextUtils.isEmpty(recipe.getTip()))
                    ? recipe.getTip()
                    : "Keyifli demlemeler!";
            txtTips.setText(tips);
        }

        // Üst görsel
        if (recipe != null && recipe.getImageResId() != 0) {
            imgHeader.setImageResource(recipe.getImageResId());
        } else {
            imgHeader.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    private @Nullable Recipe findRecipeByName(String name) {
        try {
            List<Recipe> all = RecipesData.getAll();
            if (all != null) {
                for (Recipe r : all) {
                    if (r != null && r.getName() != null
                            && r.getName().equalsIgnoreCase(name)) {
                        return r;
                    }
                }
            }
        } catch (Throwable ignore) { }
        return null;
    }
}
