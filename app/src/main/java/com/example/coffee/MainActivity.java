package com.example.coffee;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.coffee.R; // 🔥 Bunu ekle

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 📄 XML bağlandı
        // ☕ XML layout'u bağladık
    }
}