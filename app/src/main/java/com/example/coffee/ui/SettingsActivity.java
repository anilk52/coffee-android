package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.coffee.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_settings);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Switch switchTheme = findViewById(R.id.switchTheme);
        Button btnShareApp = findViewById(R.id.btnShareApp);

        switchTheme.setOnCheckedChangeListener((v, checked) -> {
            int mode = checked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO;
            AppCompatDelegate.setDefaultNightMode(mode);
        });

        btnShareApp.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
            i.putExtra(Intent.EXTRA_TEXT, "BDINO Coffee — favori kahve rehberim!");
            startActivity(Intent.createChooser(i, getString(R.string.share)));
        });
    }

    @Override
    public boolean onSupportNavigateUp() { onBackPressed(); return true; }
}