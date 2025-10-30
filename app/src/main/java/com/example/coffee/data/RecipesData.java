package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecipesData {

    public static final String CAT_ESPRESSO  = "ESPRESSO";
    public static final String CAT_FILTER    = "FILTER";
    public static final String CAT_SPECIAL   = "SPECIAL";
    public static final String CAT_ALCOHOLIC = "ALCOHOLIC";
    public static final String CAT_ICED      = "ICED";
    public static final String CAT_TURKISH   = "TURKISH";

    private static List<Recipe> CACHE;

    public static String categoryLabel(String cat) {
        if (CAT_ESPRESSO.equals(cat))  return "Espresso";
        if (CAT_FILTER.equals(cat))    return "Filtre";
        if (CAT_SPECIAL.equals(cat))   return "Special";
        if (CAT_ALCOHOLIC.equals(cat)) return "Alkollü";
        if (CAT_ICED.equals(cat))      return "Soğuk";
        if (CAT_TURKISH.equals(cat))   return "Türk";
        return "";
    }

    public static List<Recipe> getAll() {
        if (CACHE != null) return CACHE;
        List<Recipe> list = new ArrayList<>();

        // ===== Espresso Bazlı =====
        list.add(new Recipe("Espresso", "Tek shot, yoğun ve kısa içim.",
                CAT_ESPRESSO, 0, "70 ml fincan"));
        list.add(new Recipe("Doppio", "Çift shot espresso.",
                CAT_ESPRESSO, 0, "120 ml fincan"));
        list.add(new Recipe("Ristretto", "Kısa akış; daha konsantre.",
                CAT_ESPRESSO, 0, "50 ml fincan"));
        list.add(new Recipe("Lungo", "Uzun akış; hafif gövdeli.",
                CAT_ESPRESSO, 0, "150 ml fincan"));
        list.add(new Recipe("Macchiato", "Espresso üstüne az süt köpüğü.",
                CAT_ESPRESSO, 0, "120 ml fincan"));
        list.add(new Recipe("Cortado", "Espresso + eşit miktar süt.",
                CAT_ESPRESSO, 0, "150 ml bardak"));
        list.add(new Recipe("Flat White", "İnce mikrofoam ile yumuşak içim.",
                CAT_ESPRESSO, 0, "240 ml kupa"));
        list.add(new Recipe("Cappuccino", "1:1:1 espresso/süt/köpük.",
                CAT_ESPRESSO, 0, "240 ml kupa"));
        list.add(new Recipe("Latte", "Espresso üzerine bol süt.",
                CAT_ESPRESSO, 0, "300 ml kupa"));
        list.add(new Recipe("Mocha", "Çikolatalı latte.",
                CAT_ESPRESSO, 0, "300 ml kupa"));
        list.add(new Recipe("Breve", "Espresso + yarım yağlı krema.",
                CAT_ESPRESSO, 0, "200 ml kupa"));
        list.add(new Recipe("Piccolo Latte", "Küçük bardakta latte.",
                CAT_ESPRESSO, 0, "120 ml bardak"));
        list.add(new Recipe("Con Panna", "Espresso üstüne krem şanti.",
                CAT_ESPRESSO, 0, "100 ml fincan"));
        list.add(new Recipe("Romano", "Espresso + limon kabuğu.",
                CAT_ESPRESSO, 0, "70 ml fincan"));
        list.add(new Recipe("Americano", "Espresso üzerine sıcak su.",
                CAT_ESPRESSO, 0, "350 ml kupa"));
        // Dosya adı: cup_affogato_150ml (sen böyle koymuştun)
        list.add(new Recipe("Affogato", "Espresso + vanilyalı dondurma.",
                CAT_ESPRESSO, R.drawable.cup_affogato_150ml, "150 ml fincan"));

        // ===== Filtre =====
        list.add(new Recipe("V60 Pour Over", "Klasik filtre demleme yöntemi.",
                CAT_FILTER, 0, "350 ml ekipman"));
        list.add(new Recipe("Chemex", "Kalın filtreyle temiz tat.",
                CAT_FILTER, 0, "600 ml ekipman"));
        list.add(new Recipe("French Press", "Klasik yoğun filtre.",
                CAT_FILTER, R.drawable.cup_frenchpress, "300 ml ekipman"));
        list.add(new Recipe("AeroPress", "Basınçla kısa demleme.",
                CAT_FILTER, 0, "200 ml ekipman"));
        list.add(new Recipe("Syphon Brew", "Vakumla demleme.",
                CAT_FILTER, 0, "400 ml ekipman"));
        list.add(new Recipe("Moka Pot", "Klasik İtalyan cezvesi.",
                CAT_FILTER, 0, "250 ml ekipman"));
        list.add(new Recipe("Percolator", "Kaynama devridaimi.",
                CAT_FILTER, 0, "500 ml ekipman"));
        list.add(new Recipe("Kalita Wave", "Dengeli su akışı.",
                CAT_FILTER, 0, "350 ml ekipman"));
        list.add(new Recipe("Cold Drip", "Yavaş damıtma yöntemi.",
                CAT_FILTER, R.drawable.cup_colddrip, "600 ml ekipman"));

        // ===== Alkollü =====
        list.add(new Recipe("Irish Coffee", "Kahve + viski + krema.",
                CAT_ALCOHOLIC, 0, "240 ml bardak"));
        list.add(new Recipe("Baileys Latte", "Baileys likörlü latte.",
                CAT_ALCOHOLIC, 0, "300 ml bardak"));
        list.add(new Recipe("Amaretto Mocha", "Badem likörlü mocha.",
                CAT_ALCOHOLIC, 0, "300 ml bardak"));
        list.add(new Recipe("Rum Mocha", "Rom aromalı mocha.",
                CAT_ALCOHOLIC, 0, "300 ml bardak"));
        list.add(new Recipe("Espresso Martini", "Vodka + kahve likörü + espresso.",
                CAT_ALCOHOLIC, 0, "150 ml kadeh"));

        // ===== Iced =====
        list.add(new Recipe("Iced Americano", "Espresso + soğuk su + buz.",
                CAT_ICED, 0, "400 ml bardak"));
        list.add(new Recipe("Iced Latte", "Soğuk süt + espresso.",
                CAT_ICED, 0, "400 ml bardak"));
        list.add(new Recipe("Iced Mocha", "Soğuk çikolatalı latte.",
                CAT_ICED, 0, "400 ml bardak"));
        list.add(new Recipe("Affogato Freddo", "Soğuk espresso + dondurma.",
                CAT_ICED, 0, "300 ml bardak"));
        list.add(new Recipe("Iced Pour Over", "Buz üstüne V60 dökümü.",
                CAT_ICED, 0, "350 ml bardak"));

        // ===== Türk =====
        list.add(new Recipe("Türk Kahvesi", "Klasik cezvede pişirilmiş.",
                CAT_TURKISH, 0, "70 ml fincan"));
        list.add(new Recipe("Menengiç Kahvesi", "Kafeinsiz, aromatik.",
                CAT_TURKISH, 0, "70 ml fincan"));
        list.add(new Recipe("Dibek Kahvesi", "Yumuşak içim.",
                CAT_TURKISH, 0, "80 ml fincan"));
        list.add(new Recipe("Osmanlı Kahvesi", "Baharatlı karışım.",
                CAT_TURKISH, 0, "75 ml fincan"));
        list.add(new Recipe("Sütlü Türk", "Klasik tarifin sütlü versiyonu.",
                CAT_TURKISH, 0, "100 ml fincan"));

        CACHE = Collections.unmodifiableList(list);
        return CACHE;
    }

    public static List<Recipe> forCategory(String category) {
        if (category == null || category.trim().isEmpty()) return getAll();
        List<Recipe> out = new ArrayList<>();
        for (Recipe r : getAll()) {
            if (category.equalsIgnoreCase(r.getCategory())) out.add(r);
        }
        return out;
    }
}