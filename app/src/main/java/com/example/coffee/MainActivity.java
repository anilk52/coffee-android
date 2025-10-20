package com.example.coffee;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClassic = findViewById(R.id.btnClassic);
        Button btnIced    = findViewById(R.id.btnIced);
        Button btnSpecial = findViewById(R.id.btnSpecial);

        btnClassic.setOnClickListener(v ->
                Toast.makeText(this, "Klasik kahveler açılacak", Toast.LENGTH_SHORT).show());

        btnIced.setOnClickListener(v ->
                Toast.makeText(this, "Soğuk kahveler açılacak", Toast.LENGTH_SHORT).show());

        btnSpecial.setOnClickListener(v ->
                Toast.makeText(this, "Özel tarifler açılacak", Toast.LENGTH_SHORT).show());
    }
}       
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
    }
}
