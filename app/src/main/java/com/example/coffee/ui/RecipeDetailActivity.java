package com.example.coffee.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_recipe_detail);

        String name = getIntent().getStringExtra("name");
        Recipe r = RecipesData.findByName(name);

        ImageView img = findViewById(R.id.imgHeader);
        TextView t1 = findViewById(R.id.txtTitle);
        TextView t2 = findViewById(R.id.txtDesc);
        TextView t3 = findViewById(R.id.txtSize);
        TextView t4 = findViewById(R.id.txtTips);

        if (r != null) {
            img.setImageResource(r.getImageResId());
            t1.setText(r.getName());
            t2.setText(r.getDesc());
            t3.setText("Bardak Boyutu: " + r.getSize());
            t4.setText("Barista İpucu: " + r.getTips());
        }
    }
}