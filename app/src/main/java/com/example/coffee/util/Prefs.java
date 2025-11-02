package com.example.coffee.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public final class Prefs {
    private static final String FILE = "bdino_prefs";
    private static final String KEY_FAVS = "favorites";

    private Prefs() {}

    private static SharedPreferences sp(Context c) {
        return c.getSharedPreferences(FILE, Context.MODE_PRIVATE);
    }

    public static Set<String> getFavs(Context c) {
        return new HashSet<>(sp(c).getStringSet(KEY_FAVS, new HashSet<>()));
    }

    public static boolean isFav(Context c, String id) {
        return getFavs(c).contains(id);
    }

    public static void setFav(Context c, String id, boolean value) {
        Set<String> s = getFavs(c);
        if (value) s.add(id); else s.remove(id);
        sp(c).edit().putStringSet(KEY_FAVS, s).apply();
    }

    public static boolean toggleFav(Context c, String id) {
        boolean now = !isFav(c, id);
        setFav(c, id, now);
        return now;
    }
}