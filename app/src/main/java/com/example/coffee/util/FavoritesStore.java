package com.example.coffee.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class FavoritesStore {
    private static final String PREF = "bdino_prefs";
    private static final String KEY = "fav_names";

    private FavoritesStore(){}

    public static Set<String> get(Context c){
        SharedPreferences sp = c.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        Set<String> def = new HashSet<>();
        return new HashSet<>(sp.getStringSet(KEY, def));
    }

    public static boolean isFav(Context c, String name){
        if (name == null) return false;
        return get(c).contains(name);
    }

    public static void toggle(Context c, String name){
        if (name == null) return;
        SharedPreferences sp = c.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        Set<String> cur = new HashSet<>(get(c));
        if (cur.contains(name)) cur.remove(name); else cur.add(name);
        sp.edit().putStringSet(KEY, cur).apply();
    }
}