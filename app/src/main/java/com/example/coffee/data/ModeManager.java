package com.example.coffee.data;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

public final class ModeManager {

    private static final String PREFS_NAME = "bdino_prefs";
    private static final String KEY_HOME_MODE = "home_mode";
    private static final String KEY_THEME_MODE = "theme_mode";

    public static final String THEME_SYSTEM = "system";
    public static final String THEME_LIGHT = "light";
    public static final String THEME_DARK = "dark";

    private ModeManager() {
        // no instance
    }

    private static SharedPreferences prefs(@NonNull Context context) {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    // --------- EV / KAFE MODU ---------

    public static boolean isHomeMode(@NonNull Context context) {
        // Varsayılan: EV modu açık
        return prefs(context).getBoolean(KEY_HOME_MODE, true);
    }

    public static void setHomeMode(@NonNull Context context, boolean homeMode) {
        prefs(context)
                .edit()
                .putBoolean(KEY_HOME_MODE, homeMode)
                .apply();
    }

    // --------- TEMA MODU ---------

    @NonNull
    public static String getThemeMode(@NonNull Context context) {
        String value = prefs(context).getString(KEY_THEME_MODE, THEME_LIGHT);
        if (value == null) return THEME_LIGHT;
        switch (value) {
            case THEME_SYSTEM:
            case THEME_DARK:
            case THEME_LIGHT:
                return value;
            default:
                return THEME_LIGHT;
        }
    }

    public static void setThemeMode(@NonNull Context context, @NonNull String mode) {
        String normalized;
        switch (mode) {
            case THEME_SYSTEM:
                normalized = THEME_SYSTEM;
                break;
            case THEME_DARK:
                normalized = THEME_DARK;
                break;
            case THEME_LIGHT:
            default:
                normalized = THEME_LIGHT;
                break;
        }

        prefs(context)
                .edit()
                .putString(KEY_THEME_MODE, normalized)
                .apply();
    }
}