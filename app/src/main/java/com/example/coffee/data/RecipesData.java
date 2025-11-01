package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecipesData {

    private RecipesData() {}

    // KATEGORİ SABİTLERİ
    public static final String CAT_ESPRESSO   = "ESPRESSO";
    public static final String CAT_FILTER     = "FILTER";
    public static final String CAT_SPECIAL    = "SPECIAL";
    public static final String CAT_ALCOHOLIC  = "ALCOHOLIC";
    public static final String CAT_ICED       = "ICED";
    public static final String CAT_TURKISH    = "TURKISH";

    // UI için görünen etiket
    public static String categoryLabel(String cat) {
        if (cat == null) return "";
        switch (cat) {
            case CAT_ESPRESSO:  return "Espresso";
            case CAT_FILTER:    return "Filtre";
            case CAT_SPECIAL:   return "Special";
            case CAT_ALCOHOLIC: return "Alkollü";
            case CAT_ICED:      return "Ice";
            case CAT_TURKISH:   return "Türk";
            default:            return cat;
        }
    }

    // TÜM TARİFLER (örnekler – kalanları aynı kalıpla ekleyebilirsin)
    private static final List<Recipe> ALL = buildAll();
    private static List<Recipe> buildAll() {
        List<Recipe> list = new ArrayList<>();

        // ---- ESPRESSO ailesi ----
        list.add(new Recipe(
                R.drawable.cup_espresso_70ml,
                "Espresso",
                "Tek shot, yoğun ve kısa.",
                "18–20 g kahveden ~30 ml shot.",
                "1 shot (~30 ml)",
                "Taze öğütüm, 25–30 sn akış.",
                "Fincanı önceden ısıt.",
                CAT_ESPRESSO,
                "T – 70 ml"));

        list.add(new Recipe(
                R.drawable.cup_ristretto_50ml,
                "Ristretto",
                "Daha kısa ve konsantre.",
                "Aynı doz, daha kısa akış.",
                "20–25 ml",
                "Öğütümü bir tık incelet.",
                "Tatlı notalar artar.",
                CAT_ESPRESSO,
                "50 ml"));

        list.add(new Recipe(
                R.drawable.cup_lungo_150ml,
                "Lungo",
                "Uzun akışlı espresso.",
                "30+ sn, 60–90 ml çıkış.",
                "60–90 ml",
                "Aşırı uzatma acılık getirir.",
                "Hafif gövdeli olur.",
                CAT_ESPRESSO,
                "150 ml"));

        // ---- FİLTRE ----
        list.add(new Recipe(
                R.drawable.cup_v60,
                "V60",
                "Temiz ve parlak fincan.",
                "1:15 oran, 92–94°C, 2:30–3:00 dk.",
                "15 g kahve → 225 ml su",
                "Dairesel döküş, bloom 30 sn.",
                "Orta–ince öğütüm.",
                CAT_FILTER,
                "300 ml"));

        // ---- SPECIAL (örnek) ----
        list.add(new Recipe(
                R.drawable.cup_latte_300ml,
                "Latte",
                "Sütlü, yumuşak içim.",
                "1 shot üzerine microfoam süt.",
                "1 shot + 200–240 ml süt",
                "Süt 60–65°C, yanık değil.",
                "Latte art kalp dene.",
                CAT_SPECIAL,
                "300 ml"));

        // ---- ALKOLLÜ ----
        list.add(new Recipe(
                R.drawable.cup_espresso_martini,
                "Espresso Martini",
                "Kokteyl + kahve",
                "Votka + kahve likörü + espresso",
                "1:1:1 + 1 shot",
                "İyi soğut, iyi çalkala.",
                "Üstte krema köpüğü ister.",
                CAT_ALCOHOLIC,
                "Kokteyl"));

        // ---- ICED ----
        list.add(new Recipe(
                R.drawable.cup_iced_latte,
                "Iced Latte",
                "Soğuk ve sütlü.",
                "Buz + süt + espresso.",
                "Bardak buzla dolu",
                "Espressoyu soğutarak ekle.",
                "Şurup opsiyonel.",
                CAT_ICED,
                "350 ml"));

        // ---- TÜRK ----
        list.add(new Recipe(
                R.drawable.cup_t_70ml,
                "Türk Kahvesi",
                "Klasik cezve demleme.",
                "Soğuk su + ince öğütüm; köpükle pişir.",
                "1 fincan",
                "Köpüğü taşırma.",
                "Şekersiz önerilir.",
                CAT_TURKISH,
                "T – 70 ml"));

        // TODO: Kalan 46 tarifi aynı kalıpla ekleyebilirsin (görsel + kategori set edilerek).
        return Collections.unmodifiableList(list);
    }

    public static List<Recipe> getAll() {
        return ALL;
    }
}