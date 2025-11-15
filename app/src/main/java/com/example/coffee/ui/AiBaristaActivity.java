package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.ai.BdinoAiEngine;

/**
 * BDINO AI Barista – MiLO ile sohbet ekranı (offline)
 */
public class AiBaristaActivity extends AppCompatActivity {

    private TextView txtHeader;
    private TextView txtConversation;
    private EditText edtMessage;
    private Button btnSend;

    // Tariften gelen bağlam (isteğe bağlı)
    private String coffeeName;
    private String description;
    private String measure;
    private String size;
    private String tip;
    private String note;

    private BdinoAiEngine ai;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_barista);

        txtHeader      = findViewById(R.id.txtAiHeader);
        txtConversation = findViewById(R.id.txtAiConversation);
        edtMessage     = findViewById(R.id.edtAiMessage);
        btnSend        = findViewById(R.id.btnAiSend);

        // AI motoru
        ai = BdinoAiEngine.getInstance(getApplicationContext());
        if (ai != null) {
            ai.initOfflineModelIfNeeded();
        }

        // Intent ile tariften gelen bilgiler
        Intent intent = getIntent();
        if (intent != null) {
            coffeeName  = intent.getStringExtra("title");
            description = intent.getStringExtra("description");
            measure     = intent.getStringExtra("measure");
            size        = intent.getStringExtra("size");
            tip         = intent.getStringExtra("tip");
            note        = intent.getStringExtra("note");
        }

        // Başlık
        if (!TextUtils.isEmpty(coffeeName)) {
            txtHeader.setText("MiLO – " + coffeeName + " hakkında konuşuyor");
        } else {
            txtHeader.setText("MiLO – BDINO AI Barista");
        }

        // İlk karşılama mesajı
        appendBot("Merhaba, ben MiLO. Kahve hakkında aklına ne geliyorsa sorabilirsin ☕");

        btnSend.setOnClickListener(v -> onSendClicked());
    }

    private void onSendClicked() {
        String userText = edtMessage.getText().toString().trim();
        if (userText.isEmpty()) return;

        appendUser(userText);

        if (ai != null) {
            String reply = ai.generateReply(
                    userText,
                    coffeeName,
                    description,
                    measure,
                    size,
                    tip,
                    note
            );
            appendBot(reply);
        } else {
            appendBot("Şu anda AI motoruna ulaşamıyorum, ama bu ekran offline çalışmalıydı. Lütfen daha sonra tekrar dene.");
        }

        edtMessage.setText("");
    }

    private void appendUser(String text) {
        String current = txtConversation.getText().toString();
        String appended = current + "\n\nSen: " + text;
        txtConversation.setText(appended);
        scrollToBottom();
    }

    private void appendBot(String text) {
        String current = txtConversation.getText().toString();
        String appended = current + "\n\nMiLO: " + text;
        txtConversation.setText(appended);
        scrollToBottom();
    }

    private void scrollToBottom() {
        View parent = (View) txtConversation.getParent();
        if (parent instanceof ScrollView) {
            ((ScrollView) parent).post(() ->
                    ((ScrollView) parent).fullScroll(View.FOCUS_DOWN)
            );
        }
    }
}