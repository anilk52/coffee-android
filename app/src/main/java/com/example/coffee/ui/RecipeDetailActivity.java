package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    private ImageView imgHero;
    private TextView txtTitle, txtDesc, txtMeasure, txtMethod, txtTip, txtNote;

    private Recipe recipe; // paylaşımda da kullanacağız

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // Toolbar geri oku (tema ActionBar kullanıyorsa görünür)
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }

        // --- Yeni ID’lerle view bağlama (XML ile uyumlu) ---
        imgHero   = findViewById(R.id.imgHero);
        txtTitle  = findViewById(R.id.txtTitle);
        txtDesc   = findViewById(R.id.txtDesc);
        txtMeasure= findViewById(R.id.txtMeasure);
        txtMethod = findViewById(R.id.txtMethod);
        txtTip    = findViewById(R.id.txtTip);
        txtNote   = findViewById(R.id.txtNote);

        // --- Veriyi al ---
        // Model Serializable/Parcelable olabilir; ikisini de dene
        Object obj = getIntent().getSerializableExtra("recipe");
        if (obj instanceof Recipe) {
            recipe = (Recipe) obj;
        } else {
            try {
                recipe = getIntent().getParcelableExtra("recipe");
            } catch (Throwable ignored) {}
        }

        // Alternatif: tek tek extra geldi ise
        if (recipe == null) {
            String name = getIntent().getStringExtra("name");
            int imageRes = getIntent().getIntExtra("imageRes", 0);
            String desc = getIntent().getStringExtra("desc");
            String measure = getIntent().getStringExtra("measure");
            String method = getIntent().getStringExtra("method");
            String tip = getIntent().getStringExtra("tip");
            String note = getIntent().getStringExtra("note");
            if (!TextUtils.isEmpty(name)) {
                recipe = new Recipe(imageRes, name, desc, method, measure, tip, note, "", "");
            }
        }

        // --- UI doldur ---
        if (recipe != null) {
            if (imageSafe(recipe.getImageRes())) imgHero.setImageResource(recipe.getImageRes());
            txtTitle.setText(nz(recipe.getName()));
            txtDesc.setText(nz(recipe.getDescription()));
            txtMeasure.setText(nz(recipe.getMeasure()));
            // bazı modellerde "steps" alan adı olabilir → ikisini de dene
            String methodText = !TextUtils.isEmpty(recipe.getSteps())
                    ? recipe.getSteps() : recipe.getMethod();
            txtMethod.setText(nz(methodText));
            txtTip.setText(nz(recipe.getTip()));
            txtNote.setText(nz(recipe.getNote()));
        }
    }

    private boolean imageSafe(int resId) { return resId != 0; }
    private String nz(String s) { return s == null ? "" : s; }

    // Paylaş menüsü
    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recipe_detail, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) { onBackPressed(); return true; }
        if (id == R.id.action_share) {
            shareRecipe();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareRecipe() {
        String title = recipe != null ? recipe.getName() : getString(R.string.app_name);
        String body  = recipe != null
                ? (recipe.getName() + "\n" +
                   nz(recipe.getDescription()) + "\n" +
                   nz(recipe.getMeasure()) + "\n" +
                   nz(recipe.getSteps().isEmpty() ? recipe.getMethod() : recipe.getSteps()))
                : getString(R.string.app_name);

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_SUBJECT, title);
        share.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(Intent.createChooser(share, getString(R.string.share_recipe)));
    }
}