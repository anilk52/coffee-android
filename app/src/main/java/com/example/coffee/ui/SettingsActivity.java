package com.example.coffee.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import com.example.coffee.R;
import com.example.coffee.data.ModeManager;

public class SettingsActivity extends AppCompatActivity {

    private TextView txtThemeValue;
    private SwitchCompat switchHomeMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        applyCurrentTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setupToolbar();
        bindViews();
        bindThemeRow();
        bindHomeModeRow();
    }

    private void applyCurrentTheme() {
        String mode = ModeManager.getThemeMode(this);
        int nightMode;
        switch (mode) {
            case ModeManager.THEME_DARK:
                nightMode = AppCompatDelegate.MODE_NIGHT_YES;
                break;
            case ModeManager.THEME_SYSTEM:
                nightMode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
                break;
            case ModeManager.THEME_LIGHT:
            default:
                nightMode = AppCompatDelegate.MODE_NIGHT_NO;
                break;
        }
        AppCompatDelegate.setDefaultNightMode(nightMode);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbarSettings);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.settings_title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void bindViews() {
        txtThemeValue = findViewById(R.id.txtThemeValue);
        switchHomeMode = findViewById(R.id.switchHomeMode);

        String themeMode = ModeManager.getThemeMode(this);
        txtThemeValue.setText(getThemeLabel(themeMode));

        boolean isHome = ModeManager.isHomeMode(this);
        switchHomeMode.setChecked(isHome);
    }

    private void bindThemeRow() {
        LinearLayout rowTheme = findViewById(R.id.rowTheme);
        rowTheme.setOnClickListener(v -> showThemeDialog());
    }

    private void bindHomeModeRow() {
        LinearLayout rowHome = findViewById(R.id.rowHomeMode);
        rowHome.setOnClickListener(v -> {
            boolean newValue = !switchHomeMode.isChecked();
            switchHomeMode.setChecked(newValue);
        });

        switchHomeMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ModeManager.setHomeMode(SettingsActivity.this, isChecked);
            int msgRes = isChecked
                    ? R.string.settings_home_mode_on_toast
                    : R.string.settings_home_mode_off_toast;
            Toast.makeText(SettingsActivity.this, msgRes, Toast.LENGTH_SHORT).show();
        });
    }

    private void showThemeDialog() {
        final String[] modes = new String[]{
                ModeManager.THEME_SYSTEM,
                ModeManager.THEME_LIGHT,
                ModeManager.THEME_DARK
        };

        final String[] labels = new String[]{
            getString(R.string.settings_theme_system),
            getString(R.string.settings_theme_light),
            getString(R.string.settings_theme_dark)
        };

        String currentMode = ModeManager.getThemeMode(this);
        int checkedItem = 1; // varsayılan: LIGHT
        if (ModeManager.THEME_SYSTEM.equals(currentMode)) {
            checkedItem = 0;
        } else if (ModeManager.THEME_DARK.equals(currentMode)) {
            checkedItem = 2;
        }

        new AlertDialog.Builder(this)
                .setTitle(R.string.settings_theme_title)
                .setSingleChoiceItems(labels, checkedItem, null)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                    AlertDialog alertDialog = (AlertDialog) dialog;
                    int selectedPosition = alertDialog
                            .getListView()
                            .getCheckedItemPosition();

                    if (selectedPosition >= 0 && selectedPosition < modes.length) {
                        String selectedMode = modes[selectedPosition];
                        ModeManager.setThemeMode(SettingsActivity.this, selectedMode);
                        txtThemeValue.setText(getThemeLabel(selectedMode));
                        applyCurrentTheme();
                        recreate();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    private String getThemeLabel(String mode) {
        if (ModeManager.THEME_SYSTEM.equals(mode)) {
            return getString(R.string.settings_theme_system);
        } else if (ModeManager.THEME_DARK.equals(mode)) {
            return getString(R.string.settings_theme_dark);
        } else {
            return getString(R.string.settings_theme_light);
        }
    }
}