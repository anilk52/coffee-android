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
import com.example.coffee.ai.MiloConversationState;
import com.example.coffee.ai.MiloReply;

/**
 * MİLO – Sohbet eden AI Barista ekranı.
 *
 * Not:
 *  - Alt kısımda soru yazdığın alan (edtQuestion)
 *  - Gönder butonu (btnSend)
 *  - Ortadaki büyük metin alanı sohbeti gösteriyor (txtAnswerBody)
 *  - txtAnswerTitle sadece başlık gibi kullanılıyor
 *
 * Şimdilik RecyclerView yerine tek bir TextView içinde "Sen:" / "MİLO:" satırlarıyla
 * sohbeti gösteriyoruz. İleride istersek baloncuklu chat'e çevirebiliriz.
 */
public class AiBaristaActivity extends AppCompatActivity {

    private ImageView imgHero;
    private TextView txtCoffeeName;
    private EditText edtQuestion;
    private Button btnSend;
    private TextView txtAnswerTitle;
    private TextView txtAnswerBody;

    private String coffeeName = "";
    private String coffeeDescription = "";
    private String coffeeMeasure = "";
    private String coffeeSize = "";
    private String coffeeTip = "";
    private String coffeeNote = "";

    // MİLO sohbet durumu
    private MiloConversationState conversationState;

    // MİLO beyni
    private BdinoAiEngine ai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_barista);

        // View binding
        imgHero        = findViewById(R.id.imgHero);
        txtCoffeeName  = findViewById(R.id.txtCoffeeName);
        edtQuestion    = findViewById(R.id.edtQuestion);
        btnSend        = findViewById(R.id.btnSend);
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

        // Başlık / label
        txtAnswerTitle.setText("MİLO – BDINO AI Barista");
        txtAnswerTitle.setVisibility(TextView.VISIBLE);

        // Sohbet alanını temizle & hoş geldin mesajı
        txtAnswerBody.setText("");
        appendSystemMessage("MİLO hazır. Ona örneğin şöyle yazabilirsin:\n" +
                "• \"Bugün ne içsem?\"\n" +
                "• \"Latte çok hafif oluyor, ne yapmalıyım?\"\n" +
                "• \"Filtre kahvem hep acı çıkıyor\"");

        // MİLO beyni
        ai = BdinoAiEngine.getInstance(getApplicationContext());
        ai.initOfflineModelIfNeeded();

        // Başlangıçta state yok
        conversationState = null;

        // Gönder butonu → sohbet turu
        btnSend.setOnClickListener(v -> {
            String userMessage = edtQuestion.getText().toString().trim();
            if (userMessage.isEmpty()) {
                edtQuestion.setError("Önce MİLO'ya bir şey yaz 😊");
                return;
            }

            // Kullanıcı mesajını sohbet ekranına ekle
            appendUserMessage(userMessage);
            edtQuestion.setText("");

            // MİLO'dan cevap al
            MiloReply reply = ai.generateTurn(
                    userMessage,
                    conversationState,
                    coffeeName,
                    coffeeDescription,
                    coffeeMeasure,
                    coffeeSize,
                    coffeeTip,
                    coffeeNote
            );

            // State'i güncelle
            conversationState = reply.getState();

            // MİLO'nun cevabını ekle
            String miloText = reply.getAnswer();
            if (!TextUtils.isEmpty(miloText)) {
                appendMiloMessage(miloText);
            } else {
                appendMiloMessage("Şu an söyleyecek pek bir şey bulamadım, istersen farklı bir şekilde sorabilirsin. ☕");
            }

            // Eğer MİLO artık cevap beklemiyorsa (sohbet turu bitti), state'i resetleyebiliriz
            if (!reply.isExpectsReply()) {
                // İstersen burada tamamen sıfırlarsın, ben hafif bir uyarı mesajı da gösteriyorum
                appendSystemMessage("MİLO bu turu tamamladı. Yeni bir öneri veya soru için tekrar yazabilirsin.");
                // conversationState = null; // tamamen sıfırlamak istersen yorum satırını aç
            }
        });
    }

    private String safeGetString(Intent intent, String key) {
        String s = intent.getStringExtra(key);
        return s != null ? s : "";
    }

    /* -------------------- Sohbet Metodu Yardımcıları -------------------- */

    private void appendUserMessage(String text) {
        String current = txtAnswerBody.getText().toString();
        StringBuilder sb = new StringBuilder();
        if (!current.isEmpty()) {
            sb.append(current).append("\n\n");
        }
        sb.append("Sen: ").append(text);
        txtAnswerBody.setText(sb.toString());
        scrollToBottom();
    }

    private void appendMiloMessage(String text) {
        String current = txtAnswerBody.getText().toString();
        StringBuilder sb = new StringBuilder();
        if (!current.isEmpty()) {
            sb.append(current).append("\n\n");
        }
        sb.append("MİLO: ").append(text);
        txtAnswerBody.setText(sb.toString());
        scrollToBottom();
    }

    private void appendSystemMessage(String text) {
        String current = txtAnswerBody.getText().toString();
        StringBuilder sb = new StringBuilder();
        if (!current.isEmpty()) {
            sb.append(current).append("\n\n");
        }
        sb.append("• ").append(text);
        txtAnswerBody.setText(sb.toString());
        scrollToBottom();
    }

    private void scrollToBottom() {
        // TextView içinde basit bir aşağı kaydırma
        txtAnswerBody.post(() -> {
            int scrollAmount = txtAnswerBody.getLayout() != null
                    ? txtAnswerBody.getLayout().getLineTop(txtAnswerBody.getLineCount()) - txtAnswerBody.getHeight()
                    : 0;
            if (scrollAmount > 0) {
                txtAnswerBody.scrollTo(0, scrollAmount);
            } else {
                txtAnswerBody.scrollTo(0, 0);
            }
        });
    }
}