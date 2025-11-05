package com.example.coffee.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class FavoriteStore {

    private static final String PREFS_NAME = "bdino_prefs";
    private static final String KEY_FAVORITES = "favorite_recipes";

    private static SharedPreferences prefs(Context ctx) {
        return ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static Set<String> getFavorites(Context ctx) {
        SharedPreferences sp = prefs(ctx);
        Set<String> stored = sp.getStringSet(KEY_FAVORITES, null);
        if (stored == null) return new HashSet<>();
        return new HashSet<>(stored); // kopya
    }

    public static boolean isFavorite(Context ctx, String recipeName) {
        if (recipeName == null) return false;
        return getFavorites(ctx).contains(recipeName);
    }

    public static void toggleFavorite(Context ctx, String recipeName) {
        if (recipeName == null) return;
        SharedPreferences sp = prefs(ctx);
        Set<String> set = getFavorites(ctx);
        if (set.contains(recipeName)) {
            set.remove(recipeName);
        } else {
            set.add(recipeName);
        }
        sp.edit().putStringSet(KEY_FAVORITES, set).apply();
    }
}