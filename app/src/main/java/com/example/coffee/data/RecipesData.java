package com.example.coffee.data;

import com.example.coffee.model.Recipe;
import com.example.coffee.R;
import com.example.coffee.model.Recipe;
import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    public static final String CAT_ESPRESSO = "Espresso";
    public static final String CAT_FILTRE   = "Filtre";
    public static final String CAT_SPECIAL  = "Special";
    public static final String CAT_ALKOLLU  = "Alkollu";
    public static final String CAT_ICE      = "Ice";
    public static final String CAT_TURK     = "Turk";

    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // Espresso tabanı
        list.add(new Recipe("Espresso", "Tek shot, yoğun lezzet.", CAT_ESPRESSO,
                R.drawable.cup_s_150ml, "S — 30 ml", "Taze öğütülmüş kahve kullan."));
        list.add(new Recipe("Americano", "Espresso + sıcak su.", CAT_ESPRESSO,
                R.drawable.cup_l_350ml, "L — 300–350 ml", "Su oranını kişiye göre ayarla."));
        list.add(new Recipe("Macchiato", "Espresso + az süt köpüğü.", CAT_ESPRESSO,
                R.drawable.cup_s_150ml, "S — 100 ml", "Köpükle leke bırakmak esas."));

        // Filtre
        list.add(new Recipe("Pour Over", "V60 ile temiz tat.", CAT_FILTRE,
                R.drawable.cup_m_240ml, "M — 250 ml", "Dairesel döküş, sabır ister."));
        list.add(new Recipe("French Press", "Klasik yoğun filtre.", CAT_FILTRE,
                R.drawable.cup_m_240ml, "M — 300 ml", "4 dk demleme ideal."));

        // Special (sütlü)
        list.add(new Recipe("Latte", "Espresso + bol süt.", CAT_SPECIAL,
                R.drawable.cup_m_240ml, "L — 300 ml", "Latte art için mikroköpük."));
        list.add(new Recipe("Cappuccino", "Espresso + süt köpüğü.", CAT_SPECIAL,
                R.drawable.cup_m_240ml, "M — 240 ml", "Yaklaşık 1:1:1 denge."));

        // Alkollü
        list.add(new Recipe("Irish Coffee", "Viski + kahve + krema.", CAT_ALKOLLU,
                R.drawable.cup_irish, "M — 250 ml", "Viski önce, krema en son."));
        list.add(new Recipe("Espresso Martini", "Votka + kahve likörü + espresso.", CAT_ALKOLLU,
                R.drawable.cup_martini, "S — 150 ml", "İyi shake; üstte ince köpük."));

        // Soğuk
        list.add(new Recipe("Iced Latte", "Espresso + süt + buz.", CAT_ICE,
                R.drawable.cup_ice, "L — 300 ml", "Soğuk süt kullan."));
        list.add(new Recipe("Iced Americano", "Espresso + soğuk su + buz.", CAT_ICE,
                R.drawable.cup_ice, "L — 300 ml", "Buzu abartma, aroma gider."));

        // Türk
        list.add(new Recipe("Türk Kahvesi", "Klasik cezve demleme.", CAT_TURK,
                R.drawable.cup_t_70ml, "S — 70 ml",
                "Soğuk su, ince öğütülmüş kahve.\nNot: Sade:0, Az:1, Orta:2, Şekerli:3 çay kaşığı."));
        list.add(new Recipe("Menengiç Kahvesi", "Kafeinsiz, aromatik.", CAT_TURK,
                R.drawable.cup_t_70ml, "S — 70 ml", "Kısık ateşte pişir."));

        return list;
    }

    public static List<Recipe> forCategory(String category) {
        List<Recipe> all = getAll();
        if (category == null || category.trim().isEmpty()) return all;
        List<Recipe> out = new ArrayList<>();
        for (Recipe r : all) {
            if (category.equals(r.getCategory())) out.add(r);
        }
        return out;
    }

    public static Recipe findByName(String name) {
        if (name == null) return null;
        for (Recipe r : getAll()) {
            if (name.equals(r.getName())) return r;
        }
        return null;
    }
}