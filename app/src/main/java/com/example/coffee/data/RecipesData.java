package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    public static final String CAT_ESPRESSO = "Espresso";
    public static final String CAT_FILTRE   = "Filter";
    public static final String CAT_SPECIAL  = "Special";
    public static final String CAT_ALKOLLU  = "Alcoholic";
    public static final String CAT_ICE      = "Iced";
    public static final String CAT_TURK     = "Turkish";

    /** Tüm tarifler */
    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // Espresso
        list.add(new Recipe("Espresso",  "Tek shot, yoğun lezzet.",  CAT_ESPRESSO, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Ristretto", "Daha kısa, daha yoğun.",    CAT_ESPRESSO, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Lungo",     "Uzun akışlı espresso.",     CAT_ESPRESSO, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Doppio",    "Çift shot espresso.",       CAT_ESPRESSO, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Macchiato", "Espresso + az süt köpüğü.", CAT_ESPRESSO, R.drawable.ic_launcher_foreground));

        // Filter
        list.add(new Recipe("Americano",    "Espresso + sıcak su.",           CAT_FILTRE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Pour Over",    "V60 ile temiz, berrak fincan.",  CAT_FILTRE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("French Press", "Klasik tam gövde.",              CAT_FILTRE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Chemex",       "Hafif gövdeli, berrak tat.",     CAT_FILTRE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("AeroPress",    "Yoğun ama pürüzsüz.",             CAT_FILTRE, R.drawable.ic_launcher_foreground));

        // Special
        list.add(new Recipe("Latte",       "Espresso + bol süt.",                 CAT_SPECIAL, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Cappuccino",  "Espresso + süt köpüğü.",               CAT_SPECIAL, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Flat White",  "Espresso + mikroköpük.",               CAT_SPECIAL, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Mocha",       "Espresso + çikolata + süt.",           CAT_SPECIAL, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Cortado",     "1:1 espresso ve süt.",                 CAT_SPECIAL, R.drawable.ic_launcher_foreground));

        // Alcoholic
        list.add(new Recipe("Irish Coffee",     "Viski + kahve + krema.",          CAT_ALKOLLU, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Espresso Martini", "Votka + kahve likörü + espresso.",CAT_ALKOLLU, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Carajillo",        "Brandy + espresso.",              CAT_ALKOLLU, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Kahlúa Latte",     "Kahve likörü + süt.",             CAT_ALKOLLU, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Baileys Coffee",   "Baileys + kahve.",                 CAT_ALKOLLU, R.drawable.ic_launcher_foreground));

        // Iced
        list.add(new Recipe("Iced Americano", "Espresso + soğuk su + buz.", CAT_ICE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Iced Latte",     "Espresso + süt + buz.",      CAT_ICE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Cold Brew",      "12–18 saat demleme.",        CAT_ICE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Affogato",       "Espresso + dondurma.",       CAT_ICE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Frappe",         "Blender köpüklü soğuk.",     CAT_ICE, R.drawable.ic_launcher_foreground));

        // Turkish
        list.add(new Recipe("Türk Kahvesi",        "Klasik cezve demleme.",             CAT_TURK, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Menengiç Kahvesi",    "Kafeinsiz, aromatik tat.",          CAT_TURK, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Dibek Kahvesi",       "Yumuşak içim, farklı öğütüm.",      CAT_TURK, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Osmanlı Kahvesi",     "Baharatlı karışım.",                CAT_TURK, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Sütlü Türk Kahvesi",  "Klasik tarife süt dokunuşu.",       CAT_TURK, R.drawable.ic_launcher_foreground));

        return list;
    }

    /** Kategoriye göre filtre */
    public static List<Recipe> forCategory(String category) {
        List<Recipe> result = new ArrayList<>();
        if (category == null || category.trim().isEmpty()) {
            return getAll();
        }
        String c = category.trim().toLowerCase();
        for (Recipe r : getAll()) {
            if (r.getCategory() != null && r.getCategory().toLowerCase().equals(c)) {
                result.add(r);
            }
        }
        return result;
    }

    /** İsme göre bul */
    public static Recipe findByName(String name) {
        if (name == null || name.trim().isEmpty()) return null;
        for (Recipe r : getAll()) {
            if (r.getName() != null && r.getName().equalsIgnoreCase(name.trim())) {
                return r;
            }
        }
        return null;
    }
}