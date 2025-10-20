package com.example.coffee;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Başlık metni
        TextView title = findViewById(R.id.helloText);
        if (title != null) {
            title.setText("Merhaba! UI yüklendi");
            title.setTextColor(Color.BLACK);
            title.setTextSize(24f);
        }

        // Butonlar (XML'deki id'lerle birebir)
        Button btnEspresso   = findViewById(R.id.btn_espresso);
        Button btnLatte      = findViewById(R.id.btn_latte);
        Button btnCappuccino = findViewById(R.id.btn_cappuccino);

        if (btnEspresso != null) {
            btnEspresso.setOnClickListener(v ->
                RecipesActivity.start(this, "ESPRESSO")
            );
        }

        if (btnLatte != null) {
            btnLatte.setOnClickListener(v ->
                RecipesActivity.start(this, "LATTE")
            );
        }

        if (btnCappuccino != null) {
            btnCappuccino.setOnClickListener(v ->
                RecipesActivity.start(this, "CAPPUCCINO")
            );
        }

        // Arka plan beyaz
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
    }
}