package com.example.coffee.data;

import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class RecipesData {
    private static final Map<String, List<Recipe>> DATA = new LinkedHashMap<>();

    static {
        // Basit örnekler - boş kalmaz, açılış garantisi
        put("ESPRESSO", new Recipe(
                "Espresso",
                "- 18 g öğütülmüş kahve\n- 25–30 sn çekim\n- 36 g shot",
                "Portafiltreyi temizle ve kurut. 18 g kahve, düzgün tamp, 30 sn’de 36 g çıkış hedefle.",
                "Su sıcaklığı 92–94°C arası iyi sonuç verir."
        ));

        put("FILTER", new Recipe(
                "V60",
                "- 15 g kahve\n- 250 ml su (92–94°C)",
                "Kağıdı ıslat, 30 g bloom 30 sn, sonra dairesel dökerek 2:30 toplam sürede bitir.",
                "Orta-ince öğütüm genelde tat profilini dengeler."
        ));

        put("ALCOHOL", new Recipe(
                "Irish Coffee",
                "- 120 ml sıcak filtre\n- 40 ml Irish whiskey\n- 1–2 çay kaşığı şeker",
                "Bardağı ısıt, kahve ve şeker karıştır, whiskey ekle. Üstüne hafif çırpılmış krema.",
                "Kremayı dökerken kaşığa çarptır ki üstte kalsın."
        ));
    }

    private static void put(String category, Recipe recipe) {
        List<Recipe> list = DATA.get(category);
        if (list == null) {
            list = new ArrayList<>();
            DATA.put(category, list);
        }
        list.add(recipe);
    }

    public static List<String> titlesForCategory(String category) {
        List<Recipe> list = DATA.get(category);
        if (list == null || list.isEmpty()) return Collections.emptyList();
        List<String> out = new ArrayList<>(list.size());
        for (Recipe r : list) out.add(r.getTitle());
        return out;
    }

    public static List<String> allTitles() {
        List<String> out = new ArrayList<>();
        for (List<Recipe> list : DATA.values()) {
            for (Recipe r : list) out.add(r.getTitle());
        }
        return out;
    }

    public static Recipe findByTitle(String title) {
        if (title == null) return null;
        for (List<Recipe> list : DATA.values()) {
            for (Recipe r : list) {
                if (title.equalsIgnoreCase(r.getTitle())) return r;
            }
        }
        return null;
    }

    // İhtiyaç olursa tüm tarifleri set olarak döner
    public static Set<Recipe> all() {
        Set<Recipe> set = new LinkedHashSet<>();
        for (List<Recipe> list : DATA.values()) set.addAll(list);
        return set;
    }
}
