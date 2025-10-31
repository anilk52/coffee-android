package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecipesData {

    private RecipesData() {}

    public static final String CAT_ESPRESSO  = "ESPRESSO";
    public static final String CAT_FILTER    = "FILTER";
    public static final String CAT_SPECIAL   = "SPECIAL";
    public static final String CAT_ALCOHOLIC = "ALCOHOLIC";
    public static final String CAT_ICED      = "ICED";
    public static final String CAT_TURKISH   = "TURKISH";

    private static final List<Recipe> ALL = new ArrayList<>();

    static {
        // Görsel adlarının uyuşmama riskine karşı, garanti placeholder kullandım.
        // İstersen cup görseller tam oturduğunda bunları tek tek değiştiririz.
        ALL.add(new Recipe(
                R.drawable.ic_placeholder_logo,
                "Türk Kahvesi",
                "Klasik, cezvede ince çekim",
                "İnce çekilmiş kahve cezvede köpükle pişirilir.",
                "1 fincan • 70 ml",
                "Taze öğüt, soğuk su kullan.",
                "Lokumla servis tavsiye.",
                CAT_TURKISH,
                "T – 70 ml"
        ));

        ALL.add(new Recipe(
                R.drawable.ic_placeholder_logo,
                "Caffè Latte",
                "Espresso + süt, kalp latte art",
                "1 shot espresso üzerine buharda ısıtılmış süt eklenir.",
                "M – 240 ml",
                "Süt 60–65°C arası olsun.",
                "Krema için mikrofoam şart.",
                CAT_ESPRESSO,
                "M – 240 ml"
        ));
    }

    public static List<Recipe> getAll() {
        return Collections.unmodifiableList(ALL);
    }
}