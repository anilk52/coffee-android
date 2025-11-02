package com.example.coffee.utils;

import java.lang.reflect.Method;
import java.text.Normalizer;

public final class RecipeIds {
    private RecipeIds(){}

    public static String idOf(Object r) {
        if (r == null) return "";
        // 1) getId/getKey/getSlug varsa onu al
        String id = getStringProp(r, "getId", "id", "getKey", "key", "getSlug", "slug");
        if (id != null && !id.isEmpty()) return slug(id);
        // 2) Yoksa name’dan üret
        String name = getStringProp(r, "getName", "name");
        return slug(name);
    }

    private static String getStringProp(Object obj, String... candidates) {
        for (String m : candidates) {
            try {
                Method method = obj.getClass().getMethod(m);
                Object val = method.invoke(obj);
                if (val != null) return String.valueOf(val);
            } catch (Exception ignored) {}
        }
        return null;
    }

    private static String slug(String s) {
        if (s == null) return "";
        String t = Normalizer.normalize(s, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")   // aksanları at
                .toLowerCase()
                .replaceAll("[^a-z0-9]+", "_")
                .replaceAll("^_+|_+$", "");
        return t.isEmpty() ? "item" : t;
    }
}