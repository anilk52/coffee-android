package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    // Kategori sabitleri — MainActivity’de bunlar gönderiliyor
    public static final String CAT_ESPRESSO = "ESPRESSO";
    public static final String CAT_FILTRE   = "FİLTRE";
    public static final String CAT_SPECIAL  = "SPECIAL";
    public static final String CAT_ALKOLLU  = "ALKOLLÜ";
    public static final String CAT_ICE      = "ICE";

    /** Tüm tarifler */
    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // ESPRESSO
        list.add(new Recipe(
                "Espresso",
                "Tek shot, yoğun ve kısa kahve.",
                CAT_ESPRESSO,
                R.drawable.ic_launcher_foreground,
                "S — 30 ml",
                "Taze öğüt, 25–30 sn akış."
        ));
        list.add(new Recipe(
                "Ristretto",
                "Daha kısa, daha yoğun akış.",
                CAT_ESPRESSO,
                R.drawable.ic_launcher_foreground,
                "S — 20 ml",
                "Öğütmeyi bir tık daha ince tut."
        ));
        list.add(new Recipe(
                "Doppio",
                "Çift shot espresso.",
                CAT_ESPRESSO,
                R.drawable.ic_launcher_foreground,
                "S — 60 ml",
                "Çıkış süresi toplam 28–32 sn civarı."
        ));

        // FİLTRE
        list.add(new Recipe(
                "Americano",
                "Espresso + sıcak su ile uzun kahve.",
                CAT_FILTRE,
                R.drawable.ic_launcher_foreground,
                "L — 350 ml",
                "Suyu espressoya eklerken karıştırma, üstten dök."
        ));
        list.add(new Recipe(
                "Pour Over (V60)",
                "Açık ve temiz gövdeli demleme.",
                CAT_FILTRE,
                R.drawable.ic_launcher_foreground,
                "M — 240 ml",
                "Orta-ince öğüt, 2:30–3:00 dk hedef."
        ));
        list.add(new Recipe(
                "Chemex",
                "Berrak ve hafif gövde.",
                CAT_FILTRE,
                R.drawable.ic_launcher_foreground,
                "L — 300 ml",
                "Filtreyi ıslat, kağıt tadını yok et."
        ));

        // SPECIAL (sütlü)
        list.add(new Recipe(
                "Latte",
                "Espresso üzerine bol süt — latte art için ideal.",
                CAT_SPECIAL,
                R.drawable.ic_launcher_foreground,
                "L — 300 ml",
                "Sütü 60–65°C, mikroköpük pürüzsüz."
        ));
        list.add(new Recipe(
                "Cappuccino",
                "Köpük yoğunluğu baskın klasik kahve.",
                CAT_SPECIAL,
                R.drawable.ic_launcher_foreground,
                "M — 240 ml",
                "Köpüğü kaşıkla taşırma, kıvamlı tut."
        ));
        list.add(new Recipe(
                "Flat White",
                "Daha küçük hacimde yoğun süt + espresso.",
                CAT_SPECIAL,
                R.drawable.ic_launcher_foreground,
                "M — 220 ml",
                "Çekirdek ve süt dengesini eşitle."
        ));

        // ALKOLLÜ — TEK BOY (STANDART)
        list.add(new Recipe(
                "Irish Coffee",
                "Viski + kahve + krema.",
                CAT_ALKOLLU,
                R.drawable.ic_launcher_foreground,
                "250 ml (Standart)",
                "Viski önce; krema en son, karıştırma."
        ));
        list.add(new Recipe(
                "Espresso Martini",
                "Votka + kahve likörü + espresso (shakeli).",
                CAT_ALKOLLU,
                R.drawable.ic_launcher_foreground,
                "200 ml (Standart)",
                "İyi shake; üstte ince köpük hattı."
        ));
        list.add(new Recipe(
                "Carajillo",
                "Brandy/likör + espresso sıcak servis.",
                CAT_ALKOLLU,
                R.drawable.ic_launcher_foreground,
                "150 ml (Standart)",
                "Likörü az az ekle, espressoyu bastırma."
        ));

        // ICE
        list.add(new Recipe(
                "Iced Americano",
                "Espresso + soğuk su + buz.",
                CAT_ICE,
                R.drawable.ic_launcher_foreground,
                "L — 350 ml",
                "Buzu bardağa ekle, espressoyu en son dök."
        ));
        list.add(new Recipe(
                "Iced Latte",
                "Espresso + soğuk süt + buz.",
                CAT_ICE,
                R.drawable.ic_launcher_foreground,
                "L — 350 ml",
                "Sütü önce ekle, espressoyu üstten katmanla."
        ));
        list.add(new Recipe(
                "Cold Brew",
                "Uzun süreli soğuk demleme.",
                CAT_ICE,
                R.drawable.ic_launcher_foreground,
                "L — 350 ml",
                "12–18 saat demleme; buzla servis et."
        ));

        // TÜRK KAHVESİ
        list.add(new Recipe(
                "Türk Kahvesi",
                "Geleneksel pişirim, köpüklü servis.",
                CAT_ESPRESSO, // ayrık kategori istemiyorsan espresso bazlıda tutabiliriz
                R.drawable.ic_launcher_foreground,
                "T — 70 ml",
                "Soğuk suyla başla; taşmadan köpüğü al."
        ));

        return list;
    }

    /** Kategoriye göre liste */
    public static List<Recipe> forCategory(String category) {
        List<Recipe> all = getAll();
        if (category == null || category.trim().isEmpty()
                || category.equalsIgnoreCase("Tarifler")
                || category.equalsIgnoreCase("ALL")) {
            return all;
        }
        List<Recipe> out = new ArrayList<>();
        for (Recipe r : all) {
            if (r.getCategory() != null && r.getCategory().equalsIgnoreCase(category)) {
                out.add(r);
            }
        }
        return out;
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