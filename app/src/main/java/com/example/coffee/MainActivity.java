package com.example.coffee;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.helloText);
        if (tv != null) {
            tv.setText("Merhaba! UI yüklendi");
            tv.setTextSize(24);
        }

        Button btnEspresso = findViewById(R.id.btnEspresso);
        Button btnFilter   = findViewById(R.id.btnFilter);
        Button btnAlcohol  = findViewById(R.id.btnAlcohol);

        if (btnEspresso != null) btnEspresso.setOnClickListener(v ->
                RecipeActivity.start(this, "ESPRESSO"));

        if (btnFilter != null) btnFilter.setOnClickListener(v ->
                RecipeActivity.start(this, "FILTER"));

        if (btnAlcohol != null) btnAlcohol.setOnClickListener(v ->
                RecipeActivity.start(this, "ALCOHOL"));
    }
}