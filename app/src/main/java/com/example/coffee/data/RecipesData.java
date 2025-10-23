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
        // Espresso kategorisi
        put("Espresso", new Recipe(
                "Espresso",
                "18 g ince öğütülmüş kahve\n1:2 oran",
                "18 g dozlayın\n25–30 sn’de 36 g shot alın\n92–94°C su; taze öğütüm kritik.",
                "Krema rengi fındıksı olmalı, taze kahve kullanın."
        ));

        // Cappuccino kategorisi
        put("Espresso", new Recipe(
                "Cappuccino",
                "1 shot espresso\n120 ml süt",
                "Espresso hazırlayın\nSütü 60–65°C’ye kadar köpürtün\n1:3 oranında birleştirin",
                "Süt dokusu ipeksi olmalı, büyük kabarcık bırakmayın."
        ));

        // Sütlü kahveler
        put("Milk", new Recipe(
                "Latte",
                "1 shot espresso\n200 ml süt",
                "Espresso + buharla ısıtılmış süt\nİnce mikrofoam ile üstünü kaplayın",
                "Sütü 60°C’nin üzerine çıkarmayın."
        ));

        // Türk kahvesi
        put("Türk Kahvesi", new Recipe(
                "Türk Kahvesi",
                "7 g çok ince öğütülmüş kahve\n70–80 ml su",
                "Cezvede karıştırın\nKısık ateşte kabarmaya bırakın",
                "Taşmadan hemen önce alın, köpüğü paylaştırın."
        ));

        // Americano
        put("Brew", new Recipe(
                "Americano",
                "1 shot espresso\n120–150 ml sıcak su",
                "Bardağa suyu dökün\nÜzerine espresso ekleyin",
                "Suyu önce koyun; espresso homojen karışsın."
        ));
    }

    // Yardımcı ekleme metodu
    private static void put(String category, Recipe recipe) {
        List<Recipe> list = DATA.get(category);
        if (list == null) {
            list = new ArrayList<>();
            DATA.put(category, list);
        }
        list.add(recipe);
    }

    private RecipesData() {}

    /** Kategorilerin isim listesi */
    public static List<String> categories() {
        return new ArrayList<>(DATA.keySet());
    }

    /** Belirli kategoriye göre tarif başlıkları */
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

    /** Tüm başlıkları kategori fark etmeksizin getirir */
    public static List<String> allTitles() {
        List<String> out = new ArrayList<>();
        for (List<Recipe> list : DATA.values()) {
            for (Recipe r : list) out.add(r.getTitle());
        }
        return out;
    }

    /** Başlığa göre tek bir tarif döndürür */
    public static Recipe findByTitle(String title) {
        if (title == null) return null;
        for (List<Recipe> list : DATA.values()) {
            for (Recipe r : list) {
                if (title.equalsIgnoreCase(r.getTitle())) {
                    return r;
                }
            }
        }
        return null;
    }

    /** Aynı başlığa sahip birden fazla tarif varsa hepsini döndürür */
    public static List<Recipe> findAllByTitle(String title) {
        if (title == null) return Collections.emptyList();
        List<Recipe> result = new ArrayList<>();
        for (List<Recipe> list : DATA.values()) {
            for (Recipe r : list) {
                if (title.equalsIgnoreCase(r.getTitle())) {
                    result.add(r);
                }
            }
        }
        return result;
    }

    /** Tüm tarifleri set olarak döndürür */
    public static Set<Recipe> all() {
        Set<Recipe> out = new LinkedHashSet<>();
        for (List<Recipe> list : DATA.values()) out.addAll(list);
        return out;
    }
}
