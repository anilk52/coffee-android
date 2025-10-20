package com.example.coffee;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.ui.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Başlık metni
        TextView tv = findViewById(R.id.helloText);
        if (tv != null) {
            tv.setText("Merhaba! UI yüklendi");
            tv.setTextColor(Color.BLACK);
            tv.setTextSize(24);
        }

        // Mevcut layouttaki buton ID'leri (değiştirmeden kullanalım)
        Button btnEspresso   = findViewById(R.id.btn_espresso);
        Button btnLatte      = findViewById(R.id.btn_latte);
        Button btnCappuccino = findViewById(R.id.btn_cappuccino);

        if (btnEspresso != null) {
            btnEspresso.setOnClickListener(v -> {
                Toast.makeText(this, "Espresso bazlılar", Toast.LENGTH_SHORT).show();
                RecipeActivity.start(this, "ESPRESSO");
            });
        }
        if (btnLatte != null) {
            btnLatte.setOnClickListener(v -> {
                Toast.makeText(this, "Filtre kahveler", Toast.LENGTH_SHORT).show();
                RecipeActivity.start(this, "FILTER");
            });
        }
        if (btnCappuccino != null) {
            btnCappuccino.setOnClickListener(v -> {
                Toast.makeText(this, "Alkollü kahveler", Toast.LENGTH_SHORT).show();
                RecipeActivity.start(this, "ALCOHOL");
            });
        }
    }
}