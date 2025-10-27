package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.data.RecipesData;
import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnEspresso).setOnClickListener(this);
        findViewById(R.id.btnFiltre).setOnClickListener(this);
        findViewById(R.id.btnSpecial).setOnClickListener(this);
        findViewById(R.id.btnAlkollu).setOnClickListener(this);
        findViewById(R.id.btnIce).setOnClickListener(this);
        findViewById(R.id.btnTurk).setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        int id = v.getId();
        String cat = null;
        if (id == R.id.btnEspresso)      cat = RecipesData.CAT_ESPRESSO;
        else if (id == R.id.btnFiltre)   cat = RecipesData.CAT_FILTRE;
        else if (id == R.id.btnSpecial)  cat = RecipesData.CAT_SPECIAL;
        else if (id == R.id.btnAlkollu)  cat = RecipesData.CAT_ALKOLLU;
        else if (id == R.id.btnIce)      cat = RecipesData.CAT_ICE;
        else if (id == R.id.btnTurk)     cat = RecipesData.CAT_TURK;

        if (cat != null) {
            Intent i = new Intent(this, RecipeActivity.class);
            i.putExtra("category", cat);
            startActivity(i);
        }
    }
}