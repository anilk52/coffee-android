package com.example.coffee.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.ai.BdinoAiEngine;
import com.example.coffee.ai.BdinoAiEngine.BrewAiConversationState;
import com.example.coffee.ai.BdinoAiEngine.BrewAiReply;

public class AiBaristaActivity extends AppCompatActivity {

    private TextView txtHeader;
    private TextView txtConversation;
    private EditText edtMessage;
    private ImageButton btnSend;

    private BdinoAiEngine engine;
    private BrewAiConversationState state = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_barista);

        txtHeader       = findViewById(R.id.txtAiHeader);
        txtConversation = findViewById(R.id.txtAiConversation);
        edtMessage      = findViewById(R.id.edtAiMessage);
        btnSend         = findViewById(R.id.btnAiSend);

        // Başlık güvenceye alınsın
        txtHeader.setText("BrewAi by bdinoᴼ");

        engine = BdinoAiEngine.getInstance(getApplicationContext());

        btnSend.setOnClickListener(v -> {
            String msg = edtMessage.getText().toString();
            if (TextUtils.isEmpty(msg.trim())) {
                return;
            }

            BrewAiReply reply = engine.chatOnce(msg, state);
            state = reply.newState;

            // Konuşma geçmişini basitçe birleştirelim
            StringBuilder sb = new StringBuilder();
            if (state != null && state.getHistory() != null) {
                for (String line : state.getHistory()) {
                    sb.append(line).append("\n");
                }
            }

            txtConversation.setText(sb.toString().trim());
            edtMessage.setText("");
        });
    }
}