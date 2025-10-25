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

public class RecipeDetailActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private CollapsingToolbarLayout collapsing;
    private ImageView imgHeader;

    // İçerik metni (zaten vardı)
    private TextView txtContent;

    // 4. adımda layout'a eklenecek; şimdilik opsiyonel
    private TextView txtCupSize;
    private TextView txtTips;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // View bind
        toolbar = findViewById(R.id.toolbar);
        collapsing = findViewById(R.id.collapsing);
        imgHeader = findViewById(R.id.imgHeader);
        txtContent = findViewById(R.id.txtContent);

        // 4. adımda layout'a eklenecek alanlar; null olabilir
        txtCupSize = findViewById(R.id.txtCupSize);
        txtTips = findViewById(R.id.txtTips);

        // Toolbar geri okunu ayarla
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Intent verileri
        String nameFromList = getIntent().getStringExtra("title");        // RecipeActivity'den geliyor
        String nameExtra     = getIntent().getStringExtra("recipe_name");  // alternatif
        String descExtra     = getIntent().getStringExtra("recipe_desc");

        String nameKey = !TextUtils.isEmpty(nameFromList) ? nameFromList : nameExtra;

        // Veriyi bul
        Recipe recipe = !TextUtils.isEmpty(nameKey) ? RecipesData.findByName(nameKey) : null;

        // Başlık
        String title = (recipe != null && !TextUtils.isEmpty(recipe.getName()))
                ? recipe.getName()
                : (!TextUtils.isEmpty(nameKey) ? nameKey : getString(R.string.app_name));
        collapsing.setTitle(title);

        // Açıklama (fallback sırası: extra -> recipe.description -> app_name)
        String content =
                !TextUtils.isEmpty(descExtra) ? descExtra :
                (recipe != null && !TextUtils.isEmpty(recipe.getDescription()))
                        ? recipe.getDescription()
                        : getString(R.string.app_name);

        // Cup size & tips (varsa)
        String cup = (recipe != null && !TextUtils.isEmpty(recipe.getCupSize()))
                ? recipe.getCupSize() : null;
        String tips = (recipe != null && !TextUtils.isEmpty(recipe.getTips()))
                ? recipe.getTips() : null;

        // Görsel
        if (recipe != null && recipe.getImageResId() != 0) {
            imgHeader.setImageResource(recipe.getImageResId());
        } else {
            imgHeader.setImageResource(R.drawable.ic_launcher_foreground);
        }

        // İçerikleri ekrana bas
        txtContent.setText(content);

        // Eğer 4. adım yapılmış ve bu TextView'lar layout'ta varsa doğrudan yaz
        if (txtCupSize != null) {
            txtCupSize.setText(!TextUtils.isEmpty(cup) ? cup : "—");
        }
        if (txtTips != null) {
            txtTips.setText(!TextUtils.isEmpty(tips) ? tips : "—");
        }

        // Layout'ta özel alanlar henüz yoksa, içerik metnine ekle (geçici-fallback)
        if (txtCupSize == null || txtTips == null) {
            StringBuilder sb = new StringBuilder(content);
            if (!TextUtils.isEmpty(cup)) {
                sb.append("\n\n").append("Bardak Boyutu: ").append(cup);
            }
            if (!TextUtils.isEmpty(tips)) {
                sb.append("\n").append("Barista İpucu: ").append(tips);
            }
            txtContent.setText(sb.toString());
        }
    }
}