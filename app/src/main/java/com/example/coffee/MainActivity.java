package com.example.coffee;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // onCreate() sonunda veya uygun yerde:
findViewById(R.id.btnEspresso).setOnClickListener(v ->
        RecipesActivity.start(this, "ESPRESSO"));

findViewById(R.id.btnFilter).setOnClickListener(v ->
        RecipesActivity.start(this, "FILTER"));

findViewById(R.id.btnAlcohol).setOnClickListener(v ->
        RecipesActivity.start(this, "ALCOHOL"));

        // Başlık yazısı
        TextView tv = findViewById(R.id.helloText);
        if (tv != null) {
            tv.setText("Merhaba! UI yüklendi");
            tv.setTextColor(Color.BLACK);
            tv.setTextSize(24);
        }

        // Butonlar
        Button btnEspresso   = findViewById(R.id.btn_espresso);
        Button btnLatte      = findViewById(R.id.btn_latte);
        Button btnCappuccino = findViewById(R.id.btn_cappuccino);

        if (btnEspresso != null)
            btnEspresso.setOnClickListener(v ->
                Toast.makeText(this, "Espresso seçildi", Toast.LENGTH_SHORT).show());

        if (btnLatte != null)
            btnLatte.setOnClickListener(v ->
                Toast.makeText(this, "Latte seçildi", Toast.LENGTH_SHORT).show());

        if (btnCappuccino != null)
            btnCappuccino.setOnClickListener(v ->
                Toast.makeText(this, "Cappuccino seçildi", Toast.LENGTH_SHORT).show());

        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
    }
}