package com.example.coffee.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    private static final String K_NAME  = "name";
    private static final String K_DESC  = "desc";
    private static final String K_CUP   = "cup";
    private static final String K_TIP   = "tip";
    private static final String K_IMAGE = "image";

    private ImageView imgRecipe;
    private TextView txtTitle, txtDesc, txtCup, txtTip;

    /** Liste ekranından çağır: Recipe nesnesini alan güvenli başlatıcı */
    public static void start(Context ctx, Recipe r) {
        Intent i = new Intent(ctx, RecipeDetailActivity.class);
        i.putExtra(K_NAME,  safe(r.getName()));
        i.putExtra(K_DESC,  safe(r.getDescription()));
        i.putExtra(K_CUP,   safe(r.getCupSize()));
        i.putExtra(K_TIP,   safe(r.getTip()));
        i.putExtra(K_IMAGE, r.getImageResId());
        ctx.startActivity(i);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        imgRecipe = findViewById(R.id.imgRecipe);
        txtTitle  = findViewById(R.id.txtTitle);
        txtDesc   = findViewById(R.id.txtDesc);
        txtCup    = findViewById(R.id.txtCup);
        txtTip    = findViewById(R.id.txtTip);

        // intent verilerini çek
        String name = getIntent().getStringExtra(K_NAME);
        String desc = getIntent().getStringExtra(K_DESC);
        String cup  = getIntent().getStringExtra(K_CUP);
        String tip  = getIntent().getStringExtra(K_TIP);
        int image   = getIntent().getIntExtra(K_IMAGE, 0);

        // görseller ve metinler
        txtTitle.setText(safe(name));
        txtDesc.setText(safe(desc));
        txtCup.setText(safe(cup));
        txtTip.setText(safe(tip));

        if (image != 0) {
            imgRecipe.setImageResource(image);
        } else {
            imgRecipe.setImageResource(R.drawable.logo_bdino); // fallback
        }
    }

    private static String safe(String s) {
        return TextUtils.isEmpty(s) ? "" : s;
    }
}