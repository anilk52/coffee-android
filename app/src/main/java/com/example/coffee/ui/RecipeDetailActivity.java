package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecipeDetailActivity extends AppCompatActivity {

    // Görseller / metinler
    private ImageView imgHero;
    private TextView txtTitle, txtDescription, txtMeasure, txtSize, txtTip, txtNote;

    // Ses + paylaş
    private Button btnSpeed;
    private ImageButton btnPlay, btnStop, btnShare;

    // Timer
    private TextView txtTimer;
    private CountDownTimer countDownTimer;
    private boolean isTimerRunning = false;
    private long timeLeftInMillis = 0L;
    private long initialTimeInMillis = 0L;

    // AI Barista butonu (detay ekranından açmak için)
    private Button btnAiBarista;

    // TTS
    private TextToSpeech tts;
    private String fullTextToRead = "";
    // 0 -> 1x, 1 -> 1.5x, 2 -> 2x
    private int speedState = 0;

    // Bu alanları AI Barista'ya intent ile göndereceğiz
    private int imageResId = 0;
    private String title;
    private String description;
    private String measure;
    private String size;
    private String tip;
    private String note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // View binding
        imgHero        = findViewById(R.id.imgHero);
        txtTitle       = findViewById(R.id.txtTitle);
        txtDescription = findViewById(R.id.txtDescription);
        txtMeasure     = findViewById(R.id.txtMeasure);
        txtSize        = findViewById(R.id.txtSize);
        txtTip         = findViewById(R.id.txtTip);
        txtNote        = findViewById(R.id.txtNote);

        btnSpeed = findViewById(R.id.btnSpeed);
        btnPlay  = findViewById(R.id.btnPlay);
        btnStop  = findViewById(R.id.btnStop);
        btnShare = findViewById(R.id.btnShare);

        txtTimer     = findViewById(R.id.txtTimer);
        btnAiBarista = findViewById(R.id.btnAiBarista);

        // Intent verileri
        Intent intent = getIntent();

        imageResId  = intent.getIntExtra("imageResId", 0);
        title       = intent.getStringExtra("title");
        description = intent.getStringExtra("description");
        measure     = intent.getStringExtra("measure");
        size        = intent.getStringExtra("size");
        tip         = intent.getStringExtra("tip");
        note        = intent.getStringExtra("note");

        if (imageResId != 0) {
            imgHero.setImageResource(imageResId);
        }

        if (title != null)       txtTitle.setText(title);
        if (description != null) txtDescription.setText(description);
        if (measure != null)     txtMeasure.setText(measure);
        if (size != null)        txtSize.setText(size);
        if (tip != null)         txtTip.setText(tip);
        if (note != null)        txtNote.setText(note);

        // 🔊 Sesli okunacak metni hazırla
        StringBuilder sb = new StringBuilder();
        if (title != null && !title.isEmpty())             sb.append(title).append(". ");
        if (description != null && !description.isEmpty()) sb.append(description).append(" ");
        if (measure != null && !measure.isEmpty())         sb.append("Ölçü: ").append(measure).append(". ");
        if (size != null && !size.isEmpty())               sb.append("Bardak boyutu: ").append(size).append(". ");
        if (tip != null && !tip.isEmpty())                 sb.append("Barista ipucu: ").append(tip).append(". ");
        if (note != null && !note.isEmpty())               sb.append("Not: ").append(note).append(". ");

        fullTextToRead = sb.toString();

        // 🔊 TTS başlat
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(new Locale("tr", "TR"));
                applySpeed();
            }
        });

        // 🔁 Hız butonu (1x -> 1.5x -> 2x -> 1x ...)
        btnSpeed.setOnClickListener(v -> {
            speedState = (speedState + 1) % 3;
            applySpeed();
        });

        // ▶ Oynat
        btnPlay.setOnClickListener(v -> speakRecipe());

        // ⏹ Durdur
        btnStop.setOnClickListener(v -> {
            if (tts != null) {
                tts.stop();
            }
        });

        // 📤 Paylaş
        btnShare.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, fullTextToRead);
            startActivity(Intent.createChooser(shareIntent, "Bdino Coffee tarifini paylaş"));
        });

        // ⏱ TIMER: ölçü bilgisinden yaklaşık süre çıkar
        initialTimeInMillis = estimateTimerFromMeasure(measure);
        if (initialTimeInMillis > 0) {
            timeLeftInMillis = initialTimeInMillis;
            txtTimer.setVisibility(View.VISIBLE);
            updateTimerUI();
        } else {
            txtTimer.setVisibility(View.GONE);
        }

        // Timer tıklama: başlat / durdur
        txtTimer.setOnClickListener(v -> {
            if (initialTimeInMillis == 0) return;
            if (isTimerRunning) {
                pauseTimer();
            } else {
                startTimer();
            }
        });

        // Uzun bas: sıfırla
        txtTimer.setOnLongClickListener(v -> {
            if (initialTimeInMillis == 0) return true;
            resetTimer();
            return true;
        });

        // 🤖 AI BARISTA EKRANINA GEÇİŞ
        if (btnAiBarista != null) {
            btnAiBarista.setOnClickListener(v -> {
                Intent aiIntent = new Intent(RecipeDetailActivity.this, AiBaristaActivity.class);
                aiIntent.putExtra("imageResId", imageResId);
                aiIntent.putExtra("title", title);
                aiIntent.putExtra("description", description);
                aiIntent.putExtra("measure", measure);
                aiIntent.putExtra("size", size);
                aiIntent.putExtra("tip", tip);
                aiIntent.putExtra("note", note);
                startActivity(aiIntent);
            });
        }
    }

    /* ======================  TTS HIZ  ====================== */

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
            case 0:
            default:
                rate = 1.0f;
                btnSpeed.setText("1x");
                break;
        }
        if (tts != null) {
            tts.setSpeechRate(rate);
        }
    }

    private void speakRecipe() {
        if (tts == null) return;
        if (fullTextToRead == null || fullTextToRead.trim().isEmpty()) return;

        tts.stop();
        tts.speak(fullTextToRead, TextToSpeech.QUEUE_FLUSH, null, "BDINO_TTS");
    }

    /* ======================  TIMER LOJİĞİ  ====================== */

    // Ölçü string’inden tahmini süre (sn/dk) çıkarır
    private long estimateTimerFromMeasure(String measure) {
        if (measure == null) return 0L;

        String lower = measure.toLowerCase(Locale.ROOT);
        Matcher m = Pattern.compile("(\\d+)").matcher(lower);
        int lastNumber = -1;
        while (m.find()) {
            try {
                lastNumber = Integer.parseInt(m.group(1));
            } catch (NumberFormatException ignored) {
            }
        }
        if (lastNumber <= 0) return 0L;

        long seconds;
        if (lower.contains("dk")) {
            seconds = lastNumber * 60L;
        } else {
            seconds = lastNumber;
        }
        return seconds * 1000L;
    }

    private void startTimer() {
        if (timeLeftInMillis <= 0) {
            timeLeftInMillis = initialTimeInMillis;
        }

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000L) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerUI();
            }

            @Override
            public void onFinish() {
                isTimerRunning = false;
                timeLeftInMillis = 0;
                updateTimerUI();
            }
        }.start();

        isTimerRunning = true;
        updateTimerUI();
    }

    private void pauseTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        isTimerRunning = false;
        updateTimerUI();
    }

    private void resetTimer() {
        pauseTimer();
        timeLeftInMillis = initialTimeInMillis;
        updateTimerUI();
    }

    private void updateTimerUI() {
        long totalSeconds = timeLeftInMillis / 1000L;
        long minutes = totalSeconds / 60L;
        long seconds = totalSeconds % 60L;

        String timeText = String.format(Locale.getDefault(), "⏱ %02d:%02d", minutes, seconds);
        txtTimer.setText(timeText);
    }

    /* ======================  LIFECYCLE  ====================== */

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
    }
}