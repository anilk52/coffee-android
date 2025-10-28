package com.example.coffee.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
    private TextView txtContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        toolbar = findViewById(R.id.toolbar);
        collapsing = findViewById(R.id.collapsing);
        imgHeader = findViewById(R.id.imgHeader);
        txtContent = findViewById(R.id.txtContent);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Intent extras
        String nameExtra = getIntent().getStringExtra("recipe_name");
        String descExtra = getIntent().getStringExtra("recipe_desc");

        Recipe recipe = findRecipeByName(nameExtra);

        // Başlık
        String title = (recipe != null && !TextUtils.isEmpty(recipe.getName()))
                ? recipe.getName()
                : (TextUtils.isEmpty(nameExtra) ? getString(R.string.app_name) : nameExtra);
        collapsing.setTitle(title);

        // İçerik metni (sadece mevcut model alanlarını kullanıyoruz)
        String description = (descExtra != null && !descExtra.trim().isEmpty())
                ? descExtra
                : (recipe != null && !TextUtils.isEmpty(recipe.getDescription()))
                    ? recipe.getDescription()
                    : getString(R.string.not_found);

        // İstersen kategori bilgisini de tek metne ekleyelim
        String category = (recipe != null && !TextUtils.isEmpty(recipe.getCategory()))
                ? recipe.getCategory()
                : "";

        StringBuilder content = new StringBuilder();
        if (!TextUtils.isEmpty(description)) content.append(description);
        if (!TextUtils.isEmpty(category)) {
            if (content.length() > 0) content.append("\n\n");
            content.append("Kategori: ").append(category);
        }
        txtContent.setText(content.toString());

        // Görsel
        if (recipe != null && recipe.getImageResId() != 0) {
            imgHeader.setImageResource(recipe.getImageResId());
        } else {
            imgHeader.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    @Nullable
    private Recipe findRecipeByName(@Nullable String name) {
        if (TextUtils.isEmpty(name)) return null;
        try {
            List<Recipe> all = RecipesData.getAll();
            for (Recipe r : all) {
                if (r != null && name.equalsIgnoreCase(r.getName())) {
                    return r;
                }
            }
        } catch (Throwable ignored) {}
        return null;
    }
}