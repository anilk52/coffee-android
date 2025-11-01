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

public class RecipeDetailActivity extends AppCompatActivity {

    private ImageView imgHero;
    private TextView txtTitle, txtDesc, txtMeasure, txtMethod, txtTip, txtNote;

    // Intent extras key'leri (Adapter aynılarını set etmeli)
    public static final String K_IMAGE   = "imageRes";
    public static final String K_NAME    = "name";
    public static final String K_DESC    = "description";
    public static final String K_MEASURE = "measure";
    public static final String K_METHOD  = "method";
    public static final String K_TIP     = "tip";
    public static final String K_NOTE    = "note";

    private String name, desc, measure, method, tip, note;
    private int imageRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }

        imgHero   = findViewById(R.id.imgHero);
        txtTitle  = findViewById(R.id.txtTitle);
        txtDesc   = findViewById(R.id.txtDesc);
        txtMeasure= findViewById(R.id.txtMeasure);
        txtMethod = findViewById(R.id.txtMethod);
        txtTip    = findViewById(R.id.txtTip);
        txtNote   = findViewById(R.id.txtNote);

        Intent i = getIntent();
        imageRes = i.getIntExtra(K_IMAGE, 0);
        name     = nz(i.getStringExtra(K_NAME));
        desc     = nz(i.getStringExtra(K_DESC));
        measure  = nz(i.getStringExtra(K_MEASURE));
        method   = nz(i.getStringExtra(K_METHOD));
        tip      = nz(i.getStringExtra(K_TIP));
        note     = nz(i.getStringExtra(K_NOTE));

        // UI doldur
        if (imageRes != 0) imgHero.setImageResource(imageRes);
        txtTitle.setText(name);
        txtDesc.setText(desc);
        txtMeasure.setText(measure);
        txtMethod.setText(method);
        txtTip.setText(tip);
        txtNote.setText(note);
    }

    private String nz(String s) { return s == null ? "" : s; }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recipe_detail, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) { onBackPressed(); return true; }
        if (id == R.id.action_share) { shareRecipe(); return true; }
        return super.onOptionsItemSelected(item);
    }

    private void shareRecipe() {
        String body = (name + "\n" + desc + "\n" + measure + "\n" + method).trim();
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_SUBJECT, name);
        share.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(Intent.createChooser(share, getString(R.string.share_recipe)));
    }
}