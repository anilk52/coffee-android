package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.data.RecipesData;
import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    private void openCategory(String categoryKey) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("category", categoryKey);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEspresso = findViewById(R.id.btnEspresso);
        Button btnFiltre   = findViewById(R.id.btnFiltre);
        Button btnSpecial  = findViewById(R.id.btnSpecial);
        Button btnAlkollu  = findViewById(R.id.btnAlkollu);
        Button btnIce      = findViewById(R.id.btnIce);

        View.OnClickListener listener = v -> {
            int id = v.getId();
            if (id == R.id.btnEspresso) {
                openCategory(RecipesData.CAT_ESPRESSO);
            } else if (id == R.id.btnFiltre) {
                openCategory(RecipesData.CAT_FILTRE);
            } else if (id == R.id.btnSpecial) {
                openCategory(RecipesData.CAT_SPECIAL);
            } else if (id == R.id.btnAlkollu) {
                openCategory(RecipesData.CAT_ALKOLLU);
            } else if (id == R.id.btnIce) {
                openCategory(RecipesData.CAT_ICE);
            }
        };

        btnEspresso.setOnClickListener(listener);
        btnFiltre.setOnClickListener(listener);
        btnSpecial.setOnClickListener(listener);
        btnAlkollu.setOnClickListener(listener);
        btnIce.setOnClickListener(listener);
    }
}