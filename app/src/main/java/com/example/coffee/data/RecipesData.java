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
        put("Espresso", new Recipe(
                "Espresso",
                "18 g ince öğütülmüş kahve\n1:2 oran",
                "18 g dozlayın\n25–30 sn’de 36 g shot alın\n92–94°C su; taze öğütüm kritik.",
                "Krema rengi fındıksı olmalı, taze kahve kullanın."
        ));
        put("Espresso", new Recipe(
                "Cappuccino",
                "1 shot espresso\n120 ml süt",
                "Espresso hazırlayın\nSütü 60–65°C’ye kadar köpürtün\n1:3 oranında birleştirin",
                "Süt dokusu ipeksi olmalı, büyük kabarcık bırakmayın."
        ));
        put("Milk", new Recipe(
                "Latte",
                "1 shot espresso\n200 ml süt",
                "Espresso + buharla ısıtılmış süt\nİnce mikrofoam ile üstünü kaplayın",
                "Sütü 60°C’nin üzerine çıkarmayın."
        ));
        put("Türk Kahvesi", new Recipe(
                "Türk Kahvesi",
                "7 g çok ince öğütülmüş kahve\n70–80 ml su",
                "Cezvede karıştırın\nKısık ateşte kabarmaya bırakın",
                "Taşmadan hemen önce alın, köpüğü paylaştırın."
        ));
        put("Brew", new Recipe(
                "Americano",
                "1 shot espresso\n120–150 ml sıcak su",
                "Bardağa suyu dökün\nÜzerine espresso ekleyin",
                "Suyu önce koyun; espresso homojen karışsın."
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

    private RecipesData() {}

    public static List<String> categories() {
        return new ArrayList<>(DATA.keySet());
    }

    public static List<String> titlesForCategory(String category) {
        if (category == null) return Collections.emptyList();
        List<Recipe> list = null;
        for (String key : DATA.keySet()) {
            if (key.equalsIgnoreCase(category)) {
                list = DATA.get(key);
                break;
            }
        }
        if (list == null) return Collections.emptyList();
        List<String> titles = new ArrayList<>(list.size());
        for (Recipe r : list) titles.add(r.getTitle());
        return titles;
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

    public static List<Recipe> findAllByTitle(String title) {
        if (title == null) return Collections.emptyList();
        List<Recipe> result = new ArrayList<>();
        for (List<Recipe> list : DATA.values()) {
            for (Recipe r : list) {
                if (title.equalsIgnoreCase(r.getTitle())) result.add(r);
            }
        }
        return result;
    }

    public static Set<Recipe> all() {
        Set<Recipe> out = new LinkedHashSet<>();
        for (List<Recipe> list : DATA.values()) out.addAll(list);
        return out;
    }
}
