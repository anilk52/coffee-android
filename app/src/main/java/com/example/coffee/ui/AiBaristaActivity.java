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

    private MiloConversationState conversationState;
    private BdinoAiEngine ai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_barista);

        imgHero        = findViewSafe(R.id.imgHero);
        txtCoffeeName  = findViewSafe(R.id.txtCoffeeName);
        edtQuestion    = findViewSafe(R.id.edtQuestion);
        btnSend        = findViewSafe(R.id.btnSend);
        txtAnswerTitle = findViewSafe(R.id.txtAnswerTitle);
        txtAnswerBody  = findViewSafe(R.id.txtAnswerBody);

        // Intent ile gelen tarif bilgileri
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

        if (!TextUtils.isEmpty(coffeeName)) {
            txtCoffeeName.setText(coffeeName);
        } else {
            txtCoffeeName.setText("BDINO Coffee");
        }

        txtAnswerTitle.setText("MİLO – BDINO AI Barista");
        txtAnswerBody.setText("");

        appendSystemMessage(
                "MİLO hazır. Sorular sorabilirsin:\n" +
                "• \"Bugün ne içsem?\"\n" +
                "• \"Latte çok hafif oldu, nasıl daha yoğun yaparım?\"\n" +
                "• \"Filtre kahvem neden acı?\""
        );

        // AI Motoru
        ai = BdinoAiEngine.getInstance(getApplicationContext());
        if (ai != null) ai.initOfflineModelIfNeeded();
        conversationState = null;

        // Gönder butonu
        btnSend.setOnClickListener(v -> {
            String userMessage = edtQuestion.getText().toString().trim();
            if (userMessage.isEmpty()) {
                edtQuestion.setError("MİLO'ya bir şey yaz 😊");
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
                e.printStackTrace();
            }

            if (reply != null) {
                conversationState = reply.getState();
                miloText = reply.getAnswer();
            }

            if (TextUtils.isEmpty(miloText)) {
                miloText = "Mesajını aldım: \"" + userMessage +
                        "\"\nŞu an deneme modundayım ama kahveyle ilgili yardımcı olmaya hazırım. ☕";
            }

            appendMiloMessage(miloText);

            if (reply != null && !reply.isExpectsReply()) {
                appendSystemMessage("Yeni soru sorabilirsin.");
            }
        });
    }

    private <T> T findViewSafe(int id) {
        try {
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
        String current = txtAnswerBody.getText().toString();
        txtAnswerBody.setText(
                (current.isEmpty() ? "" : current + "\n\n") +
                "Sen: " + text
        );
        scrollToBottom();
    }

    private void appendMiloMessage(String text) {
        String current = txtAnswerBody.getText().toString();
        txtAnswerBody.setText(
                (current.isEmpty() ? "" : current + "\n\n") +
                "MİLO: " + text
        );
        scrollToBottom();
    }

    private void appendSystemMessage(String text) {
        String current = txtAnswerBody.getText().toString();
        txtAnswerBody.setText(
                (current.isEmpty() ? "" : current + "\n\n") +
                "• " + text
        );
        scrollToBottom();
    }

    private void scrollToBottom() {
        txtAnswerBody.post(() -> {
            if (txtAnswerBody.getLayout() == null) return;
            int scrollAmount = txtAnswerBody.getLayout()
                    .getLineTop(txtAnswerBody.getLineCount()) - txtAnswerBody.getHeight();
            txtAnswerBody.scrollTo(0, Math.max(scrollAmount, 0));
        });
    }
}