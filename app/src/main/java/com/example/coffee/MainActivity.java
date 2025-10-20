package com.example.coffee;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       
        setContentView(R.layout.activity_main);

        
        Toast.makeText(this, "MainActivity started", Toast.LENGTH_SHORT).show();

       
        TextView tv = findViewById(R.id.helloText);
        if (tv != null) {
            tv.setText("Merhaba! UI yüklendi");
            tv.setTextColor(Color.BLACK);
            tv.setTextSize(24);
        } else {
            TextView fallback = new TextView(this);
            fallback.setText("Fallback: activity_main.xml bulunamadı!");
            fallback.setTextColor(Color.RED);
            fallback.setTextSize(22);
            setContentView(fallback);
        }

       
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
    }
}