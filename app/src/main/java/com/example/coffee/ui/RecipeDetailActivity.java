package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;

import java.util.Locale;

public class RecipeDetailActivity extends AppCompatActivity {

    private ImageView imgHero;
    private TextView txtTitle, txtDescription, txtMeasure, txtSize, txtTip, txtNote;

    private Button btnSpeed;
    private ImageButton btnPlay, btnStop, btnShare;

    private TextToSpeech tts;
    private String fullTextToRead = "";

    // Hız döngüsü: 0 → 1x, 1 → 1.5x, 2 → 2x
    private int speedState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // View bağlama
        imgHero = findViewById(R.id.imgHero);
        txtTitle = findViewById(R.id.txtTitle);
        txtDescription = findViewById(R.id.txtDescription);
        txtMeasure = findViewById(R.id.txtMeasure);
        txtSize = findViewById(R.id.txtSize);
        txtTip = findViewById(R.id.txtTip);
        txtNote = findViewById(R.id.txtNote);

        btnSpeed = findViewById(R.id.btnSpeed);
        btnPlay  = findViewById(R.id.btnPlay);
        btnStop  = findViewById(R.id.btnStop);
        btnShare = findViewById(R.id.btnShare);

        // Intent verilerini al
        Intent intent = getIntent();

        int imageResId = intent.getIntExtra("imageResId", 0);
        if (imageResId != 0) imgHero.setImageResource(imageResId);

        String title       = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String measure     = intent.getStringExtra("measure");
        String size        = intent.getStringExtra("size");
        String tip         = intent.getStringExtra("tip");
        String note        = intent.getStringExtra("note");

        if (title != null) txtTitle.setText(title);
        if (description != null) txtDescription.setText(description);
        if (measure != null) txtMeasure.setText(measure);
        if (size != null) txtSize.setText(size);
        if (tip != null) txtTip.setText(tip);
        if (note != null) txtNote.setText(note);

        // Okunacak metni oluştur
        fullTextToRead =
                (title != null ? title + ". " : "") +
                (description != null ? description + " " : "") +
                (measure != null ? "Ölçü: " + measure + ". " : "") +
                (size != null ? "Bardak boyutu: " + size + ". " : "") +
                (tip != null ? "Barista ipucu: " + tip + ". " : "") +
                (note != null ? "Not: " + note + ". " : "");

        // TTS hazırlığı
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(new Locale("tr", "TR"));
                applySpeed();
            }
        });

        // Hız butonu
        btnSpeed.setOnClickListener(v -> {
            speedState = (speedState + 1) % 3;
            applySpeed();
        });

        // ▶ Oynat
        btnPlay.setOnClickListener(v -> speakRecipe());

        // ⏹ Durdur
        btnStop.setOnClickListener(v -> {
            if (tts != null) tts.stop();
        });

        // 📤 Paylaş
        btnShare.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");

            shareIntent.putExtra(Intent.EXTRA_TEXT, fullTextToRead);
            startActivity(Intent.createChooser(shareIntent, "Bdino Coffee tarifini paylaş"));
        });
    }

    private void applySpeed() {
        float rate;

        switch (speedState) {
            case 1:
                rate = 1.5f;
                btnSpeed.setText("1.5x");
                break;
            case 2:
                rate = 2.0f;
                btnSpeed.setText("2x");
                break;
            default:
                rate = 1.0f;
                btnSpeed.setText("1x");
                break;
        }

        if (tts != null) tts.setSpeechRate(rate);
    }

    private void speakRecipe() {
        if (tts != null && fullTextToRead.trim().length() > 0) {
            tts.stop();
            tts.speak(fullTextToRead, TextToSpeech.QUEUE_FLUSH, null, "BDINO_TTS");
        }
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