package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    public static final String CAT_ESPRESSO = "Espresso";
    public static final String CAT_FILTRE   = "Filtre";
    public static final String CAT_SPECIAL  = "Special";
    public static final String CAT_ALKOLLU  = "Alkollü";
    public static final String CAT_ICE      = "Ice";
    public static final String CAT_TURK     = "Türk Kahvesi";

    // Tüm tarifler
    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // Espresso bazlı
        list.add(new Recipe("Espresso",   "Tek shot, yoğun lezzet.",                   CAT_ESPRESSO, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Ristretto",  "Kısa akışlı, daha konsantre shot.",         CAT_ESPRESSO, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Lungo",      "Daha uzun akışlı espresso.",                CAT_ESPRESSO, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Doppio",     "Çift shot espresso.",                       CAT_ESPRESSO, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Macchiato",  "Espresso + az süt köpüğü.",                 CAT_ESPRESSO, R.drawable.ic_launcher_foreground));

        // Filtre
        list.add(new Recipe("Americano",  "Espresso + sıcak su.",                      CAT_FILTRE,   R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Pour Over",  "V60 yöntemiyle temiz tat.",                 CAT_FILTRE,   R.drawable.ic_launcher_foreground));
        list.add(new Recipe("French Press","Klasik yoğun filtre.",                     CAT_FILTRE,   R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Chemex",     "Hafif gövdeli, berrak kahve.",              CAT_FILTRE,   R.drawable.ic_launcher_foreground));
        list.add(new Recipe("AeroPress",  "Yoğun ama pürüzsüz tat.",                   CAT_FILTRE,   R.drawable.ic_launcher_foreground));

        // Special (sütlü)
        list.add(new Recipe("Latte",      "Espresso + bol süt.",                       CAT_SPECIAL,  R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Cappuccino", "Espresso + süt köpüğü.",                    CAT_SPECIAL,  R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Flat White", "Yoğun espresso + ince köpük.",              CAT_SPECIAL,  R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Mocha",      "Espresso + çikolata + süt.",                CAT_SPECIAL,  R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Cortado",    "1:1 espresso ve süt.",                      CAT_SPECIAL,  R.drawable.ic_launcher_foreground));

        // Alkollü
        list.add(new Recipe("Irish Coffee",      "Viski + kahve + krema.",             CAT_ALKOLLU,  R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Espresso Martini",  "Votka + kahve likörü + espresso.",   CAT_ALKOLLU,  R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Carajillo",         "Brandy + espresso.",                 CAT_ALKOLLU,  R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Kahlúa Latte",      "Kahve likörü + süt.",                CAT_ALKOLLU,  R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Baileys Coffee",    "Baileys + kahve.",                   CAT_ALKOLLU,  R.drawable.ic_launcher_foreground));

        // Soğuk
        list.add(new Recipe("Iced Americano", "Espresso + soğuk su + buz.",            CAT_ICE,      R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Iced Latte",     "Espresso + süt + buz.",                 CAT_ICE,      R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Cold Brew",      "12–18 saat demleme.",                   CAT_ICE,      R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Affogato",       "Espresso + dondurma.",                  CAT_ICE,      R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Frappe",         "Köpüklü soğuk kahve.",                  CAT_ICE,      R.drawable.ic_launcher_foreground));

        // Türk kahveleri
        list.add(new Recipe("Türk Kahvesi",          "Klasik cezvede ağır ağır.",      CAT_TURK,     R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Menengiç Kahvesi",      "Kafeinsiz, aromatik tat.",       CAT_TURK,     R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Dibek Kahvesi",         "Yumuşak gövdeli, farklı öğütüm.",CAT_TURK,     R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Osmanlı Kahvesi",       "Baharatlı karışım.",             CAT_TURK,     R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Sütlü Türk Kahvesi",    "Klasik tarife süt dokunuşu.",    CAT_TURK,     R.drawable.ic_launcher_foreground));

        return list;
    }

    // Kategoriye göre filtre
    public static List<Recipe> forCategory(String category) {
        List<Recipe> all = getAll();
        if (category == null || category.trim().isEmpty()) return all;

        List<Recipe> result = new ArrayList<>();
        for (Recipe r : all) {
            if (r.getCategory() != null && r.getCategory().equalsIgnoreCase(category)) {
                result.add(r);
            }
        }
        return result;
    }

    // İsme göre bul
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