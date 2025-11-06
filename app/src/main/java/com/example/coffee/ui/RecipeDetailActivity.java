package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;

public class RecipeDetailActivity extends AppCompatActivity {

    private ImageView imgHero;
    private TextView txtTitle;
    private TextView txtDescription;
    private TextView txtMeasure;
    private TextView txtSize;
    private TextView txtTip;
    private TextView txtNote;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // View bağlama
        imgHero       = findViewById(R.id.imgHero);
        txtTitle      = findViewById(R.id.txtTitle);
        txtDescription= findViewById(R.id.txtDescription);
        txtMeasure    = findViewById(R.id.txtMeasure);
        txtSize       = findViewById(R.id.txtSize);
        txtTip        = findViewById(R.id.txtTip);
        txtNote       = findViewById(R.id.txtNote);
        btnShare      = findViewById(R.id.btnShare);

        // Intent’ten verileri al
        Intent intent = getIntent();

        // Bunların key'leri RecipeActivity'de ne kullanıyorsan onunla aynı olmalı
        int imageResId    = intent.getIntExtra("imageResId", 0);
        String title      = intent.getStringExtra("title");
        String description= intent.getStringExtra("description");
        String measure    = intent.getStringExtra("measure");
        String size       = intent.getStringExtra("size");   // Örn: "M – 150 ml"
        String tip        = intent.getStringExtra("tip");
        String note       = intent.getStringExtra("note");

        // Görsel
        if (imageResId != 0) {
            imgHero.setImageResource(imageResId);
        }

        // Metinleri doldur
        if (title != null)       txtTitle.setText(title);
        if (description != null) txtDescription.setText(description);
        if (measure != null)     txtMeasure.setText(measure);
        if (size != null)        txtSize.setText(size);      // HAZIR METİNİ direkt yazıyoruz
        if (tip != null)         txtTip.setText(tip);
        if (note != null)        txtNote.setText(note);

        // Paylaş butonu
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareRecipe(title, description, measure, size, tip, note);
            }
        });
    }

    /**
     * Tarifi metin olarak paylaş
     */
    private void shareRecipe(String title,
                             String description,
                             String measure,
                             String size,
                             String tip,
                             String note) {

        StringBuilder builder = new StringBuilder();

        if (title != null) {
            builder.append(title).append("\n\n");
        }
        if (description != null) {
            builder.append(description).append("\n\n");
        }
        if (measure != null) {
            builder.append("Ölçü: ").append(measure).append("\n");
        }
        if (size != null) {
            builder.append("Bardak boyutu: ").append(size).append("\n");
        }
        if (tip != null) {
            builder.append("\nBarista ipucu: ").append(tip);
        }
        if (note != null) {
            builder.append("\n\nNot: ").append(note);
        }

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, builder.toString());

        startActivity(Intent.createChooser(shareIntent, "Bdino Coffee tarifini paylaş"));
    }
}