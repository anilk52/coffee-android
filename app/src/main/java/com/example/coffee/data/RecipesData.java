package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecipesData {

    private RecipesData() {}

    // Kategori sabitleri: String (UI ve filtreleme için)
    public static final String CAT_ESPRESSO  = "ESPRESSO";
    public static final String CAT_FILTER    = "FILTER";
    public static final String CAT_SPECIAL   = "SPECIAL";
    public static final String CAT_ALCOHOLIC = "ALCOHOLIC";
    public static final String CAT_ICED      = "ICED";
    public static final String CAT_TURKISH   = "TURKISH";

    // Basit statik liste (demo)
    private static final List<Recipe> ALL = new ArrayList<>();

    static {
        // Örnek kayıtlar — elindeki görselleri uygun adla değiştir
        ALL.add(new Recipe(
                R.drawable.cup_t_70,              // görsel
                "Türk Kahvesi",                   // name
                "Klasik, cezvede ince çekim",     // shortDesc
                "İnce çekilmiş kahve, cezvede köpükle pişirilir.", // description
                "1 fincan • 70 ml",               // measure
                "Taze öğüt, soğuk su kullan.",    // tip
                "Keyif notu: lokumla servis.",    // note
                CAT_TURKISH,                      // category
                "T – 70 ml"                       // cupSize
        ));

        ALL.add(new Recipe(
                R.drawable.cup_m_240,
                "Caffè Latte",
                "Espresso + süt, kalp latte art",
                "1 shot espresso üzerine buharda ısıtılmış süt.",
                "M – 240 ml",
                "Sütün sıcaklığı ~60–65°C.",
                "Krema için mikrofoam şart.",
                CAT_ESPRESSO,
                "M – 240 ml"
        ));
        // İstediğin kadar ekleyebilirsin...
    }

    public static List<Recipe> getAll() {
        return Collections.unmodifiableList(ALL);
    }
}