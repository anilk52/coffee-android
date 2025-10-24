package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView hello = findViewById(R.id.helloText);
        if (hello != null) hello.setText(getString(R.string.hello));

        Button b1 = findViewById(R.id.btnEspresso);
        Button b2 = findViewById(R.id.btnFilter);
        Button b3 = findViewById(R.id.btnAlcohol);

        if (b1 != null) b1.setOnClickListener(v -> openList("ESPRESSO"));
        if (b2 != null) b2.setOnClickListener(v -> openList("FILTER"));
        if (b3 != null) b3.setOnClickListener(v -> openList("ALCOHOL"));
    }

    private void openList(String category) {
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("category", category);
        startActivity(i);
    }
}
