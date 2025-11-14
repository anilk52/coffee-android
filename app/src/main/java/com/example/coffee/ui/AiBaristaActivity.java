package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.ai.BdinoAiEngine;
import com.example.coffee.ai.MiloConversationState;
import com.example.coffee.ai.MiloReply;

public class AiBaristaActivity extends AppCompatActivity {

    private ImageView imgHero;
    private TextView txtCoffeeName;
    private EditText edtQuestion;
    private Button btnSend;
    private ImageButton btnMic;
    private TextView txtAnswerTitle;
    private TextView txtAnswerBody;

    private String coffeeName = "";
    private String coffeeDescription = "";
    private String coffeeMeasure = "";
    private String coffeeSize = "";
    private String coffeeTip = "";
    private String coffeeNote = "";

    private MiloConversationState conversationState;
    private BdinoAiEngine ai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_barista);

        // ---- View bağlama ----
        imgHero        = findViewSafe(R.id.imgHero);
        txtCoffeeName  = findViewSafe(R.id.txtCoffeeName);
        edtQuestion    = findViewSafe(R.id.edtQuestion);
        btnSend        = findViewSafe(R.id.btnSend);
        btnMic         = findViewSafe(R.id.btnMic);
        txtAnswerTitle = findViewSafe(R.id.txtAnswerTitle);
        txtAnswerBody  = findViewSafe(R.id.txtAnswerBody);

        // Intent ile tarif bilgisi geldiyse al
        Intent intent = getIntent();
        int imageResId = intent.getIntExtra("imageResId", 0);
        if (imageResId != 0 && imgHero != null) {
            imgHero.setImageResource(imageResId);
        }

        coffeeName        = safeGetString(intent, "title");
        coffeeDescription = safeGetString(intent, "description");
        coffeeMeasure     = safeGetString(intent, "measure");
        coffeeSize        = safeGetString(intent, "size");
        coffeeTip         = safeGetString(intent, "tip");
        coffeeNote        = safeGetString(intent, "note");

        if (txtCoffeeName != null) {
            if (!TextUtils.isEmpty(coffeeName)) {
                txtCoffeeName.setText(coffeeName);
            } else {
                txtCoffeeName.setText("BDINO Coffee");
            }
        }

        if (txtAnswerTitle != null) {
            txtAnswerTitle.setText("MİLO – BDINO AI Barista");
        }

        if (txtAnswerBody != null) {
            txtAnswerBody.setText("");
            appendSystemMessage(
                    "MİLO hazır. Ona şunları sorabilirsin:\n" +
                    "• \"Bugün ne içsem?\"\n" +
                    "• \"Latte çok hafif oldu, nasıl daha yoğun yaparım?\"\n" +
                    "• \"Filtre kahvem hep acı çıkıyor.\""
            );
        }

        // ---- AI motoru ----
        ai = BdinoAiEngine.getInstance(getApplicationContext());
        if (ai != null) {
            ai.initOfflineModelIfNeeded();
        } else {
            Toast.makeText(this, "AI motoru yüklenemedi (deneme modu).", Toast.LENGTH_SHORT).show();
        }
        conversationState = null;

        // ---- Gönder butonu ----
        if (btnSend != null && edtQuestion != null) {
            btnSend.setOnClickListener(v -> {
                String userMessage = edtQuestion.getText().toString().trim();
                if (userMessage.isEmpty()) {
                    edtQuestion.setError("Önce MİLO'ya bir şey yaz 😊");
                    return;
                }

                appendUserMessage(userMessage);
                edtQuestion.setText("");

                String miloText = null;
                MiloReply reply = null;

                try {
                    if (ai != null) {
                        reply = ai.generateTurn(
                                userMessage,
                                conversationState,
                                coffeeName,
                                coffeeDescription,
                                coffeeMeasure,
                                coffeeSize,
                                coffeeTip,
                                coffeeNote
                        );
                    }
                } catch (Exception e) {
                    // AI tarafında hata olursa uygulama çökmesin
                    e.printStackTrace();
                }

                if (reply != null) {
                    conversationState = reply.getState();
                    miloText = reply.getAnswer();
                }

                // Hiçbir şey gelmediyse fallback cevap
                if (TextUtils.isEmpty(miloText)) {
                    miloText = "Mesajını aldım: \"" + userMessage +
                            "\"\nŞu an deneme modundayım, ama kahveyle ilgili her sorunu bana yazabilirsin. ☕";
                }

                appendMiloMessage(miloText);

                // Tur bitti uyarısı
                if (reply != null && !reply.isExpectsReply()) {
                    appendSystemMessage("MİLO bu turu tamamladı. Yeni bir soru için tekrar yazabilirsin.");
                }
            });
        }
    }

    // ---------- Yardımcı fonksiyonlar ----------

    private <T> T findViewSafe(int id) {
        try {
            //noinspection unchecked
            return (T) findViewById(id);
        } catch (Exception e) {
            return null;
        }
    }

    private String safeGetString(Intent intent, String key) {
        if (intent == null) return "";
        String s = intent.getStringExtra(key);
        return s != null ? s : "";
    }

    private void appendUserMessage(String text) {
        if (txtAnswerBody == null) return;
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
        if (txtAnswerBody == null) return;
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
        if (txtAnswerBody == null) return;
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
        if (txtAnswerBody == null) return;
        txtAnswerBody.post(() -> {
            if (txtAnswerBody.getLayout() == null) return;
            int scrollAmount = txtAnswerBody.getLayout()
                    .getLineTop(txtAnswerBody.getLineCount()) - txtAnswerBody.getHeight();
            if (scrollAmount > 0) {
                txtAnswerBody.scrollTo(0, scrollAmount);
            } else {
                txtAnswerBody.scrollTo(0, 0);
            }
        });
    }
}