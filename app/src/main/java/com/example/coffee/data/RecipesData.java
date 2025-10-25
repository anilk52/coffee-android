package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * RecipesData — uygulamada kullanılacak kahve tariflerini sağlar.
 * getAll() metodu Recipe listesini döndürür.
 * findByName() metodu isme göre tarif bulur.
 */
public class RecipesData {

    // Tüm tarifleri döndür
    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        list.add(new Recipe(
                "Espresso",
                "Yoğun, kısa ve güçlü bir kahve.",
                "Espresso Bazlı",
                R.drawable.ic_launcher_foreground
        ));

        list.add(new Recipe(
                "Latte",
                "Espresso ve bol sütle yapılan yumuşak içimli kahve.",
                "Espresso Bazlı",
                R.drawable.ic_launcher_foreground
        ));

        list.add(new Recipe(
                "Cappuccino",
                "Süt köpüğüyle zenginleştirilmiş klasik kahve.",
                "Espresso Bazlı",
                R.drawable.ic_launcher_foreground
        ));

        list.add(new Recipe(
                "Mocha",
                "Çikolata, süt ve espresso karışımı lezzetli içecek.",
                "Espresso Bazlı",
                R.drawable.ic_launcher_foreground
        ));

        list.add(new Recipe(
                "Americano",
                "Espresso üzerine sıcak su eklenerek hazırlanır.",
                "Filtre Kahve",
                R.drawable.ic_launcher_foreground
        ));

        list.add(new Recipe(
                "Irish Coffee",
                "Kahve, krema ve İrlanda viskisiyle hazırlanır.",
                "Alkollü Kahve",
                R.drawable.ic_launcher_foreground
        ));

        return list;
    }

    // İsme göre tarif bul
    public static Recipe findByName(String name) {
        if (name == null || name.trim().isEmpty()) return null;
        for (Recipe r : getAll()) {
            if (r.getName().equalsIgnoreCase(name.trim())) {
                return r;
            }
        }
        return null;
    }
}