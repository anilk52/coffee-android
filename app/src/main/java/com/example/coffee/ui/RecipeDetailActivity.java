package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;

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
    private TextView chipTime, chipDifficulty;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        imgHero     = findViewById(R.id.imgHero);
        txtTitle    = findViewById(R.id.txtTitle);
        txtDesc     = findViewById(R.id.txtDesc);
        txtMeasure  = findViewById(R.id.txtMeasure);
        txtMethod   = findViewById(R.id.txtMethod);
        txtTip      = findViewById(R.id.txtTip);
        txtNote     = findViewById(R.id.txtNote);
        chipTime    = findViewById(R.id.chipTime);
        chipDifficulty = findViewById(R.id.chipDifficulty);

        Intent it = getIntent();
        int image     = it.getIntExtra(K_IMAGE, 0);
        String name   = it.getStringExtra(K_NAME);
        String desc   = it.getStringExtra(K_DESC);
        String measure= it.getStringExtra(K_MEASURE);
        String method = it.getStringExtra(K_METHOD);
        String tip    = it.getStringExtra(K_TIP);
        String note   = it.getStringExtra(K_NOTE);

        if (image != 0) imgHero.setImageResource(image);
        txtTitle.setText(nz(name));
        txtDesc.setText(nz(desc));
        setOrHide(txtMeasure, measure);
        setOrHide(txtMethod, method);
        setOrHide(txtTip, tip);
        setOrHide(txtNote, note);

        // Süre & Zorluk (tüm kategoriler)
        String extraTime = it.getStringExtra("total_time");
        String extraDiff = it.getStringExtra("difficulty");
        if (!TextUtils.isEmpty(extraTime)) {
            chipTime.setText("⏱ " + extraTime);
            chipTime.setVisibility(View.VISIBLE);
        } else chipTime.setVisibility(View.GONE);

        if (!TextUtils.isEmpty(extraDiff)) {
            chipDifficulty.setText("🎯 " + extraDiff);
            chipDifficulty.setVisibility(View.VISIBLE);
        } else chipDifficulty.setVisibility(View.GONE);
    }

    private void setOrHide(TextView tv, String s) {
        if (TextUtils.isEmpty(s)) { tv.setVisibility(View.GONE); }
        else { tv.setText(s); tv.setVisibility(View.VISIBLE); }
    }
    private static String nz(String s){ return s==null?"":s; }
}