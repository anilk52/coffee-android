// app/src/main/java/com/example/coffee/MainActivity.java
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
            tv.setText("Merhaba! Uygulendi");
            tv.setTextSize(24);
        }

        Button btnEspresso = findViewById(R.id.btnEspresso);
        Button btnFilter   = findViewById(R.id.btnFilter);
        Button btnAlcohol  = findViewById(R.id.btnAlcohol);

        if (btnEspresso != null) btnEspresso.setOnClickListener(v ->
                RecipeActivity.start(this, "Espresso")
        );
        if (btnFilter != null) btnFilter.setOnClickListener(v ->
                RecipeActivity.start(this, "Brew")     // "FILTER" yerine veri setindeki kategori
        );
        if (btnAlcohol != null) btnAlcohol.setOnClickListener(v ->
                RecipeActivity.start(this, "Milk")     // "ALCOHOL" yerine veri setindeki kategori
        );
    }
}
