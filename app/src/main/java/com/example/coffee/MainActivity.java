// app/src/main/java/com/example/coffee/MainActivity.java
package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);

        TextView hello = findViewById(R.id.helloText);

        Button btnEspresso = findViewById(R.id.btnEspresso);
        Button btnFilter   = findViewById(R.id.btnFilter);
        Button btnAlcohol  = findViewById(R.id.btnAlcohol);

        View.OnClickListener openList = v -> {
            String category = "ESPRESSO";
            int id = v.getId();
            if (id == R.id.btnFilter) {
                category = "FILTER";
            } else if (id == R.id.btnAlcohol) {
                category = "ALCOHOL";
            }

            Intent i = new Intent(
                    MainActivity.this,
                    com.example.coffee.ui.RecipeActivity.class // <— tam paket adı
            );
            i.putExtra("category", category);
            startActivity(i);
        };

        btnEspresso.setOnClickListener(openList);
        btnFilter.setOnClickListener(openList);
        btnAlcohol.setOnClickListener(openList);
    }
}
