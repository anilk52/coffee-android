// app/src/main/java/com/example/coffee/data/RecipesData.java
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
        // Kategoriler sıralı kalsın diye LinkedHashMap/LinkedHashSet kullandık
        put("Espresso", new Recipe(
                "Espresso",
                "- 18 g ince öğütülmüş kahve\n- 1:2 oran",
                "1) 18 g dozlayın\n2) 25–30 sn’de 36 g shot alın",
                "92–94°C su; taze öğütüm en kritik noktadır."
        ));
        put("Espresso", new Recipe(
                "Cappuccino",
                "- 1 shot espresso\n- 120 ml süt",
                "1) Espresso hazırlayın\n2) Sütü 60–65°C’ye köpürtün\n3) 1:3 oranında birleştirin",
                "Sütte büyük kabarcık bırakmayın; ipeksi doku hedeflenir."
        ));
        put("Milk", new Recipe(
                "Latte",
                "- 1 shot espresso\n- 200 ml süt",
                "1) Espresso + buharda ısınmış süt\n2) İnce mikrofoam ile üstünü kaplayın",
                "Sütü 60°C üstüne çıkarmayın; tat kaybeder."
        ));
        put("Brew", new Recipe(
                "Türk Kahvesi",
                "- 7 g çok ince öğütüm\n- 70–80 ml su",
                "1) Cezvede kahve + su + (isteğe şeker)\n2) Kısık ateşte kabarınca alın",
                "Taze çekim ve soğuk su kullanın."
        ));
        put("Brew", new Recipe(
                "Americano",
                "- 1 shot espresso\n- 120–150 ml sıcak su",
                "1) Bardağa önce su\n2) Üzerine espresso ekle",
                "Önce su, sonra espresso daha homojen sonuç verir."
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

    /** Kategori isimleri (ekranda listelemek için). */
    public static List<String> categories() {
        return new ArrayList<>(DATA.keySet());
    }

    /** Belirli kategorideki başlıklar. Kategori yoksa boş döner. */
    public static List<String> titlesForCategory(String category) {
        List<Recipe> list = DATA.get(category);
        if (list == null) return Collections.emptyList();
        List<String> titles = new ArrayList<>(list.size());
        for (Recipe r : list) titles.add(r.getTitle());
        return titles;
    }

    /** Tüm kategorilerdeki tüm başlıklar (tek liste). */
    public static List<String> allTitles() {
        List<String> out = new ArrayList<>();
        for (List<Recipe> list : DATA.values()) {
            for (Recipe r : list) out.add(r.getTitle());
        }
        return out;
    }

    /** Başlığa göre tarif bul (kategori bağımsız). İlk eşleşmeyi döner. */
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

    /** Aynı isme sahip birden fazla tarif varsa hepsini döner. */
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

    /** Tüm tariflerin seti (gerektiğinde). */
    public static Set<Recipe> all() {
        Set<Recipe> out = new LinkedHashSet<>();
        for (List<Recipe> list : DATA.values()) out.addAll(list);
        return out;
    }
}
