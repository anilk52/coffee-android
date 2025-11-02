package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.data.CoffeeFacts;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecipeDetailActivity extends AppCompatActivity {

    public static final String K_IMAGE   = "image";
    public static final String K_NAME    = "name";
    public static final String K_DESC    = "desc";
    public static final String K_MEASURE = "measure";
    public static final String K_METHOD  = "method";
    public static final String K_TIP     = "tip";
    public static final String K_NOTE    = "note";

    private ImageView imgHero;
    private TextView txtTitle, txtDesc, txtMeasure, txtMethod, txtTip, txtNote;
    private TextView chipTime, chipDifficulty, chipTaste, chipGear;

    private View timerBox;
    private TextView txtTimer, txtStepsHeader, txtStepsList;
    private Button btnStartPause, btnReset;

    // TTS
    private Button btnTtsStart, btnTtsStop;
    private TextToSpeech tts;

    private CountDownTimer cdt;
    private long totalMillis = 0L;
    private boolean running = false;

    // BDINO Sözlüğü
    private TextView txtFactTitle, txtFactBody;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // Views
        imgHero     = findViewById(R.id.imgHero);
        txtTitle    = findViewById(R.id.txtTitle);
        chipTime    = findViewById(R.id.chipTime);
        chipDifficulty = findViewById(R.id.chipDifficulty);
        chipTaste   = findViewById(R.id.chipTaste);
        chipGear    = findViewById(R.id.chipGear);

        txtDesc     = findViewById(R.id.txtDesc);
        txtMeasure  = findViewById(R.id.txtMeasure);
        txtMethod   = findViewById(R.id.txtMethod);
        txtTip      = findViewById(R.id.txtTip);
        txtNote     = findViewById(R.id.txtNote);

        timerBox    = findViewById(R.id.timerBox);
        txtTimer    = findViewById(R.id.txtTimer);
        btnStartPause = findViewById(R.id.btnStartPause);
        btnReset    = findViewById(R.id.btnReset);
        txtStepsHeader = findViewById(R.id.txtStepsHeader);
        txtStepsList   = findViewById(R.id.txtStepsList);

        btnTtsStart = findViewById(R.id.btnTtsStart);
        btnTtsStop  = findViewById(R.id.btnTtsStop);

        txtFactTitle = findViewById(R.id.txtFactTitle);
        txtFactBody  = findViewById(R.id.txtFactBody);

        // Intent
        Intent it = getIntent();
        int image     = it.getIntExtra(K_IMAGE, 0);
        String name   = it.getStringExtra(K_NAME);
        String desc   = it.getStringExtra(K_DESC);
        String measure= it.getStringExtra(K_MEASURE);
        String method = it.getStringExtra(K_METHOD);
        String tip    = it.getStringExtra(K_TIP);
        String note   = it.getStringExtra(K_NOTE);

        String extraTime  = it.getStringExtra("total_time");
        String extraDiff  = it.getStringExtra("difficulty");
        String taste      = it.getStringExtra("taste_profile");
        String gear       = it.getStringExtra("equipment");

        // Fill
        if (image != 0) imgHero.setImageResource(image);
        txtTitle.setText(nz(name));
        txtDesc.setText(nz(desc));
        setOrHide(txtMeasure, measure);
        setOrHide(txtMethod, method);
        setOrHide(txtTip, tip);
        setOrHide(txtNote, note);

        setChip(chipTime,     !TextUtils.isEmpty(extraTime) ? "⏱ " + extraTime : null);
        setChip(chipDifficulty,!TextUtils.isEmpty(extraDiff) ? "🎯 " + extraDiff : null);
        setChip(chipTaste,    !TextUtils.isEmpty(taste)     ? "🌿 " + taste : null);
        setChip(chipGear,     !TextUtils.isEmpty(gear)      ? "🧰 " + gear : null);

        // Steps
        String stepsList = buildStepsList(method);
        if (!TextUtils.isEmpty(stepsList)) {
            txtStepsHeader.setVisibility(View.VISIBLE);
            txtStepsList.setVisibility(View.VISIBLE);
            txtStepsList.setText(stepsList);
        } else {
            txtStepsHeader.setVisibility(View.GONE);
            txtStepsList.setVisibility(View.GONE);
        }

        // Timer
        totalMillis = parseTotalMillis(method);
        if (totalMillis > 0) {
            timerBox.setVisibility(View.VISIBLE);
            txtTimer.setText(formatMillis(totalMillis));
            setupTimer();
        } else {
            timerBox.setVisibility(View.GONE);
        }

        // ——— TTS ———
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int res = tts.setLanguage(new Locale("tr", "TR"));
                if (res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED) {
                    tts.setLanguage(Locale.getDefault());
                }
                tts.setSpeechRate(0.95f);
                tts.setPitch(1.0f);
            }
        });
        btnTtsStart.setOnClickListener(v -> speakStepsOrMethod());
        btnTtsStop.setOnClickListener(v -> stopSpeak());

        // ——— BDINO Sözlüğü ———
        txtFactTitle.setText("BDINO Sözlüğü");
        txtFactBody.setText(CoffeeFacts.random());
    }

    private void speakStepsOrMethod() {
        String text = !TextUtils.isEmpty(txtStepsList.getText())
                ? txtStepsList.getText().toString()
                : txtMethod.getText().toString();
        if (TextUtils.isEmpty(text) || tts == null) return;

        String[] chunks = text.split("\\n");
        stopSpeak();
        for (int i = 0; i < chunks.length; i++) {
            String line = chunks[i].trim();
            if (line.isEmpty()) continue;
            int queueMode = (i == 0) ? TextToSpeech.QUEUE_FLUSH : TextToSpeech.QUEUE_ADD;
            tts.speak(line, queueMode, null, "bdino_step_" + i);
        }
    }

    private void stopSpeak() { if (tts != null) tts.stop(); }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pauseTimer();
        if (tts != null) { tts.stop(); tts.shutdown(); tts = null; }
    }

    // —— UI helpers ——
    private void setChip(TextView chip, String value) {
        if (chip == null) return;
        if (TextUtils.isEmpty(value)) chip.setVisibility(View.GONE);
        else { chip.setText(value); chip.setVisibility(View.VISIBLE); }
    }
    private void setOrHide(TextView tv, String s) {
        if (TextUtils.isEmpty(s)) tv.setVisibility(View.GONE);
        else { tv.setText(s); tv.setVisibility(View.VISIBLE); }
    }
    private static String nz(String s){ return s==null?"":s; }

    // —— Parsing ——
    private long parseTotalMillis(String methodText) {
        if (TextUtils.isEmpty(methodText)) return 0L;
        Pattern p = Pattern.compile("(\\d+)\\s*(s|sn|sec|second|seconds|m|min|minute|minutes)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(methodText);
        long total = 0L;
        while (m.find()) {
            int val = safeInt(m.group(1));
            String unit = m.group(2).toLowerCase();
            total += unit.startsWith("m") ? val * 60_000L : val * 1_000L;
        }
        return total;
    }
    private String buildStepsList(String methodText) {
        if (TextUtils.isEmpty(methodText)) return "";
        String[] lines = methodText.split("\\r?\\n");
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("(.*?)(\\d+\\s*(s|sn|sec|second|seconds|m|min|minute|minutes))", Pattern.CASE_INSENSITIVE);
        int index = 1;
        for (String line : lines) {
            String t = line.trim();
            if (t.isEmpty()) continue;
            Matcher m = p.matcher(t);
            if (m.find()) {
                String title = m.group(1).trim();
                long ms = parseTotalMillis(m.group(2));
                if (TextUtils.isEmpty(title)) title = "Adım";
                sb.append(index++).append(". ").append(title).append(" — ").append(formatMillis(ms)).append("\n");
            } else {
                sb.append(index++).append(". ").append(t).append("\n");
            }
        }
        return sb.toString().trim();
    }
    private String formatMillis(long ms) {
        long s = ms / 1000;
        long m = s / 60;
        long rem = s % 60;
        if (m > 0) return String.format(Locale.getDefault(), "%d:%02d", m, rem);
        return String.format(Locale.getDefault(), "0:%02d", rem);
    }

    // —— Timer ——
    private void setupTimer() {
        btnStartPause.setOnClickListener(v -> {
            if (!running) { startTimer(); btnStartPause.setText("Duraklat"); }
            else { pauseTimer(); btnStartPause.setText("Devam"); }
            running = !running;
        });
        btnReset.setOnClickListener(v -> {
            pauseTimer();
            txtTimer.setText(formatMillis(totalMillis));
            btnStartPause.setText("Başlat");
            running = false;
        });
    }
    private void startTimer() {
        pauseTimer();
        long seconds = parseCurrentSeconds(txtTimer.getText().toString());
        cdt = new CountDownTimer(seconds * 1000L, 1000) {
            @Override public void onTick(long millisUntilFinished) { txtTimer.setText(formatMillis(millisUntilFinished)); }
            @Override public void onFinish() { txtTimer.setText("0:00"); btnStartPause.setText("Başlat"); running = false; }
        }.start();
    }
    private void pauseTimer() { if (cdt != null) { cdt.cancel(); cdt = null; } }
    private long parseCurrentSeconds(String mmss) {
        try {
            String[] p = mmss.split(":");
            if (p.length == 2) return Long.parseLong(p[0].trim())*60 + Long.parseLong(p[1].trim());
        } catch (Exception ignored) {}
        return 0;
    }
    private int safeInt(String s) { try { return Integer.parseInt(s.trim()); } catch (Exception e) { return 0; } }
}