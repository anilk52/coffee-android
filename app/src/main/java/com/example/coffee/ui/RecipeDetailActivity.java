package com.example.coffee.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.coffee.R;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_SUBTITLE = "subtitle";
    public static final String EXTRA_IMAGE = "image";
    public static final String EXTRA_SIZE = "size";
    public static final String EXTRA_TIP = "tip";
    public static final String EXTRA_INSTRUCTIONS = "instructions";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        ImageView img = findViewById(R.id.imgPhoto);
        TextView tTitle = findViewById(R.id.txtTitle);
        TextView tSub = findViewById(R.id.txtSubtitle);
        TextView tSize = findViewById(R.id.txtSize);
        TextView tTip  = findViewById(R.id.txtTip);
        TextView tIns  = findViewById(R.id.txtInstructions);

        tTitle.setText(getIntent().getStringExtra(EXTRA_TITLE));
        tSub.setText(getIntent().getStringExtra(EXTRA_SUBTITLE));
        tSize.setText(getIntent().getStringExtra(EXTRA_SIZE));
        tTip.setText(getIntent().getStringExtra(EXTRA_TIP));
        tIns.setText(getIntent().getStringExtra(EXTRA_INSTRUCTIONS));

        int imgRes = getIntent().getIntExtra(EXTRA_IMAGE, R.drawable.logo_bdino);
        img.setImageResource(imgRes);
    }
}