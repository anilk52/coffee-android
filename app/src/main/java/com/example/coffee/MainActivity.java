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

        findViewById(R.id.btnEspresso).setOnClickListener(this);
        findViewById(R.id.btnFiltre).setOnClickListener(this);
        findViewById(R.id.btnSpecial).setOnClickListener(this);
        findViewById(R.id.btnAlkollu).setOnClickListener(this);
        findViewById(R.id.btnIce).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String category;
        int id = v.getId();
        if (id == R.id.btnEspresso) {
            category = RecipesData.CAT_ESPRESSO;
        } else if (id == R.id.btnFiltre) {
            category = RecipesData.CAT_FILTRE;
        } else if (id == R.id.btnSpecial) {
            category = RecipesData.CAT_SPECIAL;
        } else if (id == R.id.btnAlkollu) {
            category = RecipesData.CAT_ALKOLLU;
        } else if (id == R.id.btnIce) {
            category = RecipesData.CAT_ICE;
        } else {
            category = null;
        }
        openCategory(category);
    }

    private void openCategory(String category) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("category", category);
        startActivity(i);
    }
}