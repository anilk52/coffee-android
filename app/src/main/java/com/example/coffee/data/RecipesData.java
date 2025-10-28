package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public final class RecipesData {

    private RecipesData() {}

    // Kategori sabitleri (MainActivity’de bunlar kullanılıyor)
    public static final String CAT_ESPRESSO = "Espresso";
    public static final String CAT_FILTRE   = "Filtre";
    public static final String CAT_SPECIAL  = "Special";
    public static final String CAT_ALKOLLU  = "Alkollü";
    public static final String CAT_ICE      = "Iced";
    public static final String CAT_TURK     = "Türk";

    /** Tüm tarifleri tek listede döner. */
    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // ESPRESSO (Americano’yu buraya aldık; espresso bazlı)
        list.add(new Recipe(
                "Espresso", "Tek shot, yoğun ve kısa içim.",
                CAT_ESPRESSO, R.drawable.cup_s_150ml, "S — 30 ml",
                "Taze öğütüm, 9 bar, ~25–30 sn."));

        list.add(new Recipe(
                "Ristretto", "Daha kısa akış; daha konsantre.",
                CAT_ESPRESSO, R.drawable.cup_s_150ml, "S — 20 ml",
                "Öğütümü biraz daha ince tut."));

        list.add(new Recipe(
                "Lungo", "Uzun akış; gövde hafifler.",
                CAT_ESPRESSO, R.drawable.cup_s_150ml, "S — 60 ml",
                "Aşırı uzatma; acılık artar."));

        list.add(new Recipe(
                "Doppio", "Çift shot espresso.",
                CAT_ESPRESSO, R.drawable.cup_s_150ml, "S — 60 ml",
                "İki shot için doz ve tamper sabit, basket çift."));

        list.add(new Recipe(
                "Americano", "Espresso üstüne sıcak su.",
                CAT_ESPRESSO, R.drawable.cup_l_350ml, "L — 240–350 ml",
                "Shot → su (üst üste), crema korunsun."));

        // FİLTRE
        list.add(new Recipe(
                "Pour Over (V60)", "Temiz ve berrak tat.",
                CAT_FILTRE, R.drawable.cup_m_240ml, "M — 240–300 ml",
                "Dairesel döküş, 2:30–3:00 dk hedef."));

        list.add(new Recipe(
                "French Press", "Klasik tam gövde.",
                CAT_FILTRE, R.drawable.cup_m_240ml, "M — 300 ml",
                "4 dk beklet, bastır; tortuyu taşırma."));

        list.add(new Recipe(
                "Chemex", "Hafif gövde, yüksek berraklık.",
                CAT_FILTRE, R.drawable.cup_m_240ml, "M — 300 ml",
                "Kalın filtre, daha sıcak su (92–94°C)."));

        list.add(new Recipe(
                "AeroPress", "Yoğun ama pürüzsüz.",
                CAT_FILTRE, R.drawable.cup_m_240ml, "M — 200–250 ml",
                "Inverted yöntemini dene; 1:45–2:00 dk."));

        list.add(new Recipe(
                "Batch Brew", "Sabit oran, servislik demlenmiş.",
                CAT_FILTRE, R.drawable.cup_l_350ml, "L — 300–350 ml",
                "1:15–1:17 oran, taze kalması için ısıtma plağına dikkat."));

        // SPECIAL (sütlüler)
        list.add(new Recipe(
                "Latte", "Espresso + bol süt; ince mikroköpük.",
                CAT_SPECIAL, R.drawable.cup_m_240ml, "L — 300 ml",
                "Latte art için süt 55–60°C."));

        list.add(new Recipe(
                "Cappuccino", "1:1:1 espresso/süt/köpük.",
                CAT_SPECIAL, R.drawable.cup_m_240ml, "M — 240 ml",
                "Köpük daha kalın; kaşıkla tut."));

        list.add(new Recipe(
                "Flat White", "Yoğun espresso + ince köpük.",
                CAT_SPECIAL, R.drawable.cup_m_240ml, "M — 220 ml",
                "Daha az süt, daha fazla espresso tadı."));

        list.add(new Recipe(
                "Mocha", "Espresso + çikolata + süt.",
                CAT_SPECIAL, R.drawable.cup_m_240ml, "L — 300 ml",
                "Kaliteli kakao/şurup kullan."));

        list.add(new Recipe(
                "Cortado", "1:1 espresso ve süt.",
                CAT_SPECIAL, R.drawable.cup_s_150ml, "S — 120 ml",
                "Süt gövdesi ince, tat dengeli."));

        // ALKOLLÜ
        list.add(new Recipe(
                "Irish Coffee", "Viski + kahve + krema.",
                CAT_ALKOLLU, R.drawable.cup_irish, "M — 250 ml",
                "Viski → sıcak kahve → şeker → üstten krema."));

        list.add(new Recipe(
                "Espresso Martini", "Votka + kahve likörü + espresso.",
                CAT_ALKOLLU, R.drawable.cup_martini, "S — 150 ml",
                "İyi shake; üstte ince kahve köpüğü."));

        list.add(new Recipe(
                "Carajillo", "Brandy/Likör + espresso.",
                CAT_ALKOLLU, R.drawable.cup_s_150ml, "S — 120 ml",
                "Likörü yavaş ekle, karamelize tat yakala."));

        list.add(new Recipe(
                "Baileys Coffee", "Baileys + kahve.",
                CAT_ALKOLLU, R.drawable.cup_m_240ml, "M — 240 ml",
                "Baileys’i ısıtma; aroma uçmasın."));

        list.add(new Recipe(
                "Kahlúa Latte", "Kahve likörü + süt.",
                CAT_ALKOLLU, R.drawable.cup_m_240ml, "M — 240 ml",
                "Kahve baskın kalsın, şurubu abartma."));

        // ICED
        list.add(new Recipe(
                "Iced Americano", "Espresso + soğuk su + buz.",
                CAT_ICE, R.drawable.cup_ice, "L — 300–350 ml",
                "Buzu aşırı kaçırma; tat seyrelir."));

        list.add(new Recipe(
                "Iced Latte", "Espresso + süt + buz.",
                CAT_ICE, R.drawable.cup_ice, "L — 300 ml",
                "Soğuk süt ve iri buz kullan."));

        list.add(new Recipe(
                "Cold Brew", "12–18 saat demleme.",
                CAT_ICE, R.drawable.cup_ice, "L — 300 ml",
                "Kalın öğütüm, buzdolabında demle."));

        list.add(new Recipe(
                "Affogato", "Espresso + dondurma.",
                CAT_ICE, R.drawable.cup_s_150ml, "S — 150 ml",
                "Vanilyalı dondurma ideal."));

        list.add(new Recipe(
                "Frappe", "Blender köpüklü soğuk kahve.",
                CAT_ICE, R.drawable.cup_ice, "L — 350 ml",
                "Buz-kahve oranını dengede tut."));

        // TÜRK
        list.add(new Recipe(
                "Türk Kahvesi", "Klasik cezvede köpüklü.",
                CAT_TURK, R.drawable.cup_t_70ml, "S — ~70 ml",
                "Soğuk su + ince öğütüm.\nNot (şeker): Sade:0 | Az:1 çay kş. | Orta:2 | Şekerli:3"));

        list.add(new Recipe(
                "Menengiç Kahvesi", "Kafeinsiz; fıstıksı aromalar.",
                CAT_TURK, R.drawable.cup_t_70ml, "S — ~70 ml",
                "Kısık ateş; taşırma.\nNot: Genelde sade/az şekerli."));

        list.add(new Recipe(
                "Dibek Kahvesi", "Dibekte dövülmüş; yumuşak içim.",
                CAT_TURK, R.drawable.cup_t_70ml, "S — ~80 ml",
                "Köpüğü bol servis et."));

        list.add(new Recipe(
                "Osmanlı Kahvesi", "Baharatlı karışım (tarçın/kakule).",
                CAT_TURK, R.drawable.cup_t_70ml, "S — ~75 ml",
                "Baharat dozunu düşük tut."));

        list.add(new Recipe(
                "Sütlü Türk Kahvesi", "Klasik tarife süt dokunuşu.",
                CAT_TURK, R.drawable.cup_t_70ml, "S — ~100 ml",
                "Sütü kaynatmadan ekle; taşırma."));

        return list;
    }

    /** Kategoriye göre filtreler. */
    public static List<Recipe> forCategory(String category) {
        List<Recipe> all = getAll();
        if (category == null || category.trim().isEmpty()) return all;
        List<Recipe> result = new ArrayList<>();
        for (Recipe r : all) {
            if (category.equals(r.getCategory())) result.add(r);
        }
        return result;
    }

    /** İsme göre tek tarif döner (bulunamazsa null). */
    public static Recipe findByName(String name) {
        if (name == null) return null;
        for (Recipe r : getAll()) {
            if (name.equals(r.getName())) return r;
        }
        return null;
    }
}