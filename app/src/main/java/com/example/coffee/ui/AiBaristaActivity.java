package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.ai.BdinoAiEngine;

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

        // Gönder butonu → AI katmanını çağırır
        btnSend.setOnClickListener(v -> {
            String question = edtQuestion.getText().toString().trim();
            if (question.isEmpty()) {
                edtQuestion.setError("Önce AI Barista'ya bir şey sor 😊");
                return;
            }

            BdinoAiEngine ai = BdinoAiEngine.getInstance();

            // 1) LLM için prompt'u oluştur
            String promptForModel = ai.buildPromptForModel(
                    question,
                    coffeeName,
                    coffeeDescription,
                    coffeeMeasure,
                    coffeeSize,
                    coffeeTip,
                    coffeeNote
            );

            // 2) Şimdilik kural tabanlı cevabı al
            String answer = ai.generateAdvice(
                    question,
                    promptForModel,
                    coffeeName,
                    coffeeMeasure,
                    coffeeSize,
                    coffeeTip
            );

            txtAnswerTitle.setVisibility(TextView.VISIBLE);
            txtAnswerBody.setVisibility(TextView.VISIBLE);
            txtAnswerBody.setText(answer);
        });

        // Sesle sor (şimdilik placeholder)
        btnVoice.setOnClickListener(v ->
                Toast.makeText(
                        AiBaristaActivity.this,
                        "Sesle soru özelliği yakında 😊",
                        Toast.LENGTH_SHORT
                ).show()
        );
    }

    private String safeGetString(Intent intent, String key) {
        String s = intent.getStringExtra(key);
        return s != null ? s : "";
    }
}