package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;

import java.util.Locale;

public class RecipeDetailActivity extends AppCompatActivity {

    private ImageView imgHero;
    private TextView txtTitle;
    private TextView txtDescription;
    private TextView txtMeasure;
    private TextView txtSize;
    private TextView txtTip;
    private TextView txtNote;
    private Button btnShare;
    private Button btnSpeak;
    private Button btnSlow;
    private Button btnNormal;
    private Button btnFast;
    private Button btnStop;

    // TTS
    private TextToSpeech tts;
    private String fullTextToRead = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // View bağlama
        imgHero        = findViewById(R.id.imgHero);
        txtTitle       = findViewById(R.id.txtTitle);
        txtDescription = findViewById(R.id.txtDescription);
        txtMeasure     = findViewById(R.id.txtMeasure);
        txtSize        = findViewById(R.id.txtSize);
        txtTip         = findViewById(R.id.txtTip);
        txtNote        = findViewById(R.id.txtNote);
        btnShare       = findViewById(R.id.btnShare);
        btnSpeak       = findViewById(R.id.btnSpeak);
        btnSlow        = findViewById(R.id.btnSlow);
        btnNormal      = findViewById(R.id.btnNormal);
        btnFast        = findViewById(R.id.btnFast);
        btnStop        = findViewById(R.id.btnStop);

        // Intent’ten verileri al
        Intent intent = getIntent();

        int imageResId = intent.getIntExtra("imageResId", 0);
        if (imageResId != 0) {
            imgHero.setImageResource(imageResId);
        }

        String title       = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String measure     = intent.getStringExtra("measure");
        String size        = intent.getStringExtra("size");
        String tip         = intent.getStringExtra("tip");
        String note        = intent.getStringExtra("note");

        if (title != null)       txtTitle.setText(title);
        if (description != null) txtDescription.setText(description);
        if (measure != null)     txtMeasure.setText(measure);
        if (size != null)        txtSize.setText(size);
        if (tip != null)         txtTip.setText(tip);
        if (note != null)        txtNote.setText(note);

        // 🔊 Okunacak metni derle
        StringBuilder sb = new StringBuilder();
        if (title != null && !title.isEmpty()) {
            sb.append(title).append(". ");
        }
        if (description != null && !description.isEmpty()) {
            sb.append(description).append(" ");
        }
        if (measure != null && !measure.isEmpty()) {
            sb.append("Ölçü: ").append(measure).append(". ");
        }
        if (size != null && !size.isEmpty()) {
            sb.append("Bardak boyutu: ").append(size).append(". ");
        }
        if (tip != null && !tip.isEmpty()) {
            sb.append("Barista ipucu: ").append(tip).append(". ");
        }
        if (note != null && !note.isEmpty()) {
            sb.append("Not: ").append(note).append(". ");
        }
        fullTextToRead = sb.toString();

        // 🔊 OFFLINE TTS başlatma
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                // Cihazda Türkçe ses paketi varsa offline çalışır
                int result = tts.setLanguage(new Locale("tr", "TR"));
                tts.setPitch(1.0f);       // Ses tonu (1.0 = normal)
                tts.setSpeechRate(0.95f); // Konuşma hızı (hafif yavaş)
            }
        });

        // Paylaş butonu
        btnShare.setOnClickListener(v ->
                shareRecipe(title, description, measure, size, tip, note)
        );

        // 🔊 Standart "Oku" butonu (mevcut hızla)
        btnSpeak.setOnClickListener(v -> speakRecipe());

        // 🐌 Yavaş okuma
        btnSlow.setOnClickListener(v -> {
            if (tts != null) {
                tts.setSpeechRate(0.8f);
                speakRecipe();
            }
        });

        // ▶ Normal hız
        btnNormal.setOnClickListener(v -> {
            if (tts != null) {
                tts.setSpeechRate(1.0f);
                speakRecipe();
            }
        });

        // ⚡ Hızlı okuma
        btnFast.setOnClickListener(v -> {
            if (tts != null) {
                tts.setSpeechRate(1.2f);
                speakRecipe();
            }
        });

        // ⏹ Durdur
        btnStop.setOnClickListener(v -> {
            if (tts != null) {
                tts.stop();
            }
        });
    }

    private void speakRecipe() {
        if (tts == null) return;
        if (fullTextToRead == null || fullTextToRead.trim().isEmpty()) return;

        tts.stop(); // önce varsa eskiyi kes
        tts.speak(fullTextToRead, TextToSpeech.QUEUE_FLUSH, null, "BDINO_TTS");
    }

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

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}