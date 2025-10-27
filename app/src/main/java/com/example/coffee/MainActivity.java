package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.data.RecipesData;
import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Butonlar
        findViewById(R.id.btnEspresso).setOnClickListener(this);
        findViewById(R.id.btnFiltre).setOnClickListener(this);
        findViewById(R.id.btnSpecial).setOnClickListener(this);
        findViewById(R.id.btnAlkollu).setOnClickListener(this);
        findViewById(R.id.btnIce).setOnClickListener(this);
        findViewById(R.id.btnTurk).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String category = null;

        switch (v.getId()) {
            case R.id.btnEspresso:
                category = RecipesData.CAT_ESPRESSO;
                break;
            case R.id.btnFiltre:
                category = RecipesData.CAT_FILTRE;
                break;
            case R.id.btnSpecial:
                category = RecipesData.CAT_SPECIAL;
                break;
            case R.id.btnAlkollu:
                category = RecipesData.CAT_ALKOLLU;
                break;
            case R.id.btnIce:
                category = RecipesData.CAT_ICE;
                break;
            case R.id.btnTurk:
                category = RecipesData.CAT_TURK;
                break;
        }

        if (category != null) {
            Intent intent = new Intent(this, RecipeActivity.class);
            intent.putExtra("category", category);
            startActivity(intent);
        }
    }
}