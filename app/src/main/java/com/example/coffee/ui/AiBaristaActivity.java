package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.ai.BdinoAiEngine;

import java.util.Locale;

public class AiBaristaActivity extends AppCompatActivity {

    private ImageView imgHero;
    private TextView txtCoffeeName;
    private EditText edtQuestion;
    private Button btnSend;
    private Button btnVoice;
    private TextView txtAnswerTitle;
    private TextView txtAnswerBody;

    private String coffeeName = "";
    private String coffeeDescription = "";
    private String coffeeMeasure = "";
    private String coffeeSize = "";
    private String coffeeTip = "";
    private String coffeeNote = "";

    // MİLO ses için
    private TextToSpeech tts;
    private boolean isTtsReady = false;
    private boolean isSpeaking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_barista);

        // View binding
        imgHero        = findViewById(R.id.imgHero);
        txtCoffeeName  = findViewById(R.id.txtCoffeeName);
        edtQuestion    = findViewById(R.id.edtQuestion);
        btnSend        = findViewById(R.id.btnSend);
        btnVoice       = findViewById(R.id.btnVoice);
        txtAnswerTitle = findViewById(R.id.txtAnswerTitle);
        txtAnswerBody  = findViewById(R.id.txtAnswerBody);

        // Intent ile gelen tarif bilgileri
        Intent intent = getIntent();
        int imageResId = intent.getIntExtra("imageResId", 0);
        if (imageResId != 0) {
            imgHero.setImageResource(imageResId);
        }

        coffeeName        = safeGetString(intent, "title");
        coffeeDescription = safeGetString(intent, "description");
        coffeeMeasure     = safeGetString(intent, "measure");
        coffeeSize        = safeGetString(intent, "size");
        coffeeTip         = safeGetString(intent, "tip");
        coffeeNote        = safeGetString(intent, "note");

        if (!TextUtils.isEmpty(coffeeName)) {
            txtCoffeeName.setText(coffeeName);
        } else {
            txtCoffeeName.setText("BDINO Coffee");
        }

        // MİLO beyni
        BdinoAiEngine ai = BdinoAiEngine.getInstance(getApplicationContext());
        ai.initOfflineModelIfNeeded(); // Şimdilik no-op

        // MİLO sesi (TextToSpeech) başlat
        initTextToSpeech();

        // Gönder butonu → MİLO cevabı üret + istersek otomatik konuştur
        btnSend.setOnClickListener(v -> {
            String question = edtQuestion.getText().toString().trim();
            if (question.isEmpty()) {
                edtQuestion.setError("Önce MİLO'ya bir şey sor 😊");
                return;
            }

            String answer = ai.generateAdvice(
                    question,
                    coffeeName,
                    coffeeDescription,
                    coffeeMeasure,
                    coffeeSize,
                    coffeeTip,
                    coffeeNote
            );

            txtAnswerTitle.setVisibility(TextView.VISIBLE);
            txtAnswerBody.setVisibility(TextView.VISIBLE);
            txtAnswerBody.setText(answer);

            // İstersen otomatik konuşturmak için aşağıyı açık bırak
            speakAnswer(false);
        });

        // 🔊 MİLO konuş / durdur butonu
        btnVoice.setOnClickListener(v -> {
            if (!isTtsReady) {
                Toast.makeText(
                        AiBaristaActivity.this,
                        "Ses motoru hazır değil. Telefonun metin okuma dilini (Türkçe) kontrol et.",
                        Toast.LENGTH_LONG
                ).show();
                return;
            }

            if (isSpeaking) {
                stopSpeaking();
            } else {
                speakAnswer(true);
            }
        });
    }

    private String safeGetString(Intent intent, String key) {
        String s = intent.getStringExtra(key);
        return s != null ? s : "";
    }

    /* ------------------- MİLO Ses (TextToSpeech) ------------------- */

    private void initTextToSpeech() {
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int res = tts.setLanguage(new Locale("tr", "TR"));
                if (res == TextToSpeech.LANG_MISSING_DATA ||
                        res == TextToSpeech.LANG_NOT_SUPPORTED) {
                    // Türkçe yoksa yine de en azından varsayılan dili denesin
                    tts.setLanguage(Locale.getDefault());
                    isTtsReady = false;
                    Toast.makeText(
                            AiBaristaActivity.this,
                            "Türkçe ses paketi eksik olabilir. Telefonun dil ayarlarından yükleyebilirsin.",
                            Toast.LENGTH_LONG
                    ).show();
                } else {
                    isTtsReady = true;
                }
            } else {
                isTtsReady = false;
                Toast.makeText(
                        AiBaristaActivity.this,
                        "Ses motoru başlatılamadı.",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    /**
     * Mevcut cevabı MİLO sesiyle okur.
     * fromButton = true ise buton ikonunu da günceller.
     */
    private void speakAnswer(boolean fromButton) {
        if (!isTtsReady || tts == null) return;

        String text = txtAnswerBody.getText().toString().trim();
        if (text.isEmpty()) {
            Toast.makeText(this, "Önce MİLO'dan bir cevap alalım ☕", Toast.LENGTH_SHORT).show();
            return;
        }

        // Daha doğal hız
        tts.stop();
        tts.setSpeechRate(1.0f);   // İleride x1 / x1.5 / x2 yapabiliriz
        tts.setPitch(1.0f);

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "MILO_ANSWER");
        isSpeaking = true;
        if (fromButton) {
            btnVoice.setText("⏹"); // durdur simgesi gibi
        }
    }

    private void stopSpeaking() {
        if (tts != null) {
            tts.stop();
        }
        isSpeaking = false;
        btnVoice.setText("🔊"); // tekrar konuş simgesi
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tts != null) {
            tts.stop();
            tts.shutdown();
            tts = null;
        }
    }
}