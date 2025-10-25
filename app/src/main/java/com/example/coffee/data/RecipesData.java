package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecipesData {

    // Kategori etiketleri (MainActivity’de gönderdiğimiz başlıklarla uyumlu)
    public static final String CAT_ESPRESSO = "ESPRESSO";
    public static final String CAT_FILTRE   = "FİLTRE";
    public static final String CAT_SPECIAL  = "SPECIAL";
    public static final String CAT_ALKOLLU  = "ALKOLLÜ";
    public static final String CAT_ICE      = "ICE";

    /** Tüm tarifler (5'er adet) */
    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // ESPRESSO (5)
        list.add(new Recipe("Espresso",  "Tek shot, yoğun lezzet. Boyut: S — 30 ml",  CAT_ESPRESSO, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Ristretto", "Kısa ve daha yoğun. Boyut: S — 20 ml",     CAT_ESPRESSO, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Lungo",     "Daha uzun akış, daha hafif. Boyut: S — 60 ml", CAT_ESPRESSO, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Doppio",    "Çift shot. Boyut: S — 60 ml",               CAT_ESPRESSO, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Macchiato", "Espresso üstüne az süt köpüğü. Boyut: S — 100 ml", CAT_ESPRESSO, R.drawable.ic_launcher_foreground));

        // FİLTRE (5)
        list.add(new Recipe("Americano",      "Espresso + sıcak su. Boyut: M — 240 ml",  CAT_FILTRE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Pour Over",      "V60 demleme. Boyut: M — 250 ml",          CAT_FILTRE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("French Press",   "Klasik tam gövde. Boyut: M — 300 ml",     CAT_FILTRE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Chemex",         "Temiz ve berrak. Boyut: L — 300 ml",      CAT_FILTRE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("AeroPress",      "Yoğun ama pürüzsüz. Boyut: S — 200 ml",   CAT_FILTRE, R.drawable.ic_launcher_foreground));

        // SPECIAL (5)
        list.add(new Recipe("Latte",          "Espresso + bol süt. Boyut: L — 300 ml",   CAT_SPECIAL, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Cappuccino",     "Süt köpüğü baskın. Boyut: M — 240 ml",    CAT_SPECIAL, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Flat White",     "Mikroköpük ile dengeli. Boyut: M — 220 ml", CAT_SPECIAL, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Mocha",          "Çikolata + süt + espresso. Boyut: L — 300 ml", CAT_SPECIAL, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Cortado",        "Espresso: süt = 1:1. Boyut: S — 120 ml",  CAT_SPECIAL, R.drawable.ic_launcher_foreground));

        // ALKOLLÜ (5)
        list.add(new Recipe("Irish Coffee",   "Viski + kahve + krema. Boyut: L — 250 ml", CAT_ALKOLLU, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Espresso Martini","Votka + kahve likörü + espresso. Boyut: S — 120 ml", CAT_ALKOLLU, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Carajillo",      "Brandy + espresso. Boyut: S — 120 ml",    CAT_ALKOLLU, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Kahlúa Latte",   "Kahve likörü + süt. Boyut: M — 240 ml",   CAT_ALKOLLU, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Baileys Coffee", "Baileys + kahve. Boyut: M — 240 ml",      CAT_ALKOLLU, R.drawable.ic_launcher_foreground));

        // ICE (5)
        list.add(new Recipe("Iced Americano", "Espresso + soğuk su + buz. Boyut: L — 300 ml", CAT_ICE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Iced Latte",     "Espresso + süt + buz. Boyut: L — 300 ml", CAT_ICE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Cold Brew",      "12–18 saat demleme. Boyut: L — 300 ml",   CAT_ICE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Affogato",       "Espresso + dondurma. Boyut: S — 150 ml",  CAT_ICE, R.drawable.ic_launcher_foreground));
        list.add(new Recipe("Frappe",         "Blender köpüklü. Boyut: L — 350 ml",      CAT_ICE, R.drawable.ic_launcher_foreground));

        return list;
    }

    /** İsme göre tarif bul */
    public static Recipe findByName(String name) {
        if (name == null || name.trim().isEmpty()) return null;
        for (Recipe r : getAll()) {
            if (r.getName().equalsIgnoreCase(name.trim())) {
                return r;
            }
        }
        return null;
    }

    /** Tüm başlıklar (kategori bağımsız) */
    public static List<String> allTitles() {
        List<String> out = new ArrayList<>();
        for (Recipe r : getAll()) out.add(r.getName());
        return out;
    }

    /** Kategoriye göre başlıklar */
    public static List<String> titlesForCategory(String category) {
        if (category == null || category.trim().isEmpty()) return Collections.emptyList();
        String key = category.trim().toUpperCase();
        List<String> out = new ArrayList<>();
        for (Recipe r : getAll()) {
            if (r.getCategory() != null && r.getCategory().equalsIgnoreCase(key)) {
                out.add(r.getName());
            }
        }
        return out;
        }
}