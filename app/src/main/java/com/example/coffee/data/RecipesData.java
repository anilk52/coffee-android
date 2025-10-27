package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;
import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    public static final String CAT_ESPRESSO = "ESPRESSO";
    public static final String CAT_FILTRE   = "FİLTRE";
    public static final String CAT_SPECIAL  = "SPECIAL";
    public static final String CAT_ALKOLLU  = "ALKOLLÜ";
    public static final String CAT_ICE      = "ICE";
    public static final String CAT_TURK     = "TÜRK KAHVESİ";

    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // ---------- ESPRESSO ----------
        list.add(new Recipe("Espresso (Tek Shot)",
                "Kısa, yoğun, tam gövdeli espresso.",
                CAT_ESPRESSO, R.drawable.ic_launcher_foreground,
                "S — 30 ml (Tek Shot)",
                "25–30 sn akış idealdir."));
        list.add(new Recipe("Espresso (Çift Shot) • Doppio",
                "İki shot aynı fincanda.",
                CAT_ESPRESSO, R.drawable.ic_launcher_foreground,
                "S — 60 ml (Çift Shot)",
                "Aynı süre, daha fazla doz."));

        list.add(new Recipe("Ristretto",
                "Espresso’nun daha kısa, yoğun hali.",
                CAT_ESPRESSO, R.drawable.ic_launcher_foreground,
                "S — 20 ml (Tek Shot)",
                "Daha ince öğüt, kısa akış."));
        list.add(new Recipe("Lungo",
                "Daha uzun akış, daha hafif gövde.",
                CAT_ESPRESSO, R.drawable.ic_launcher_foreground,
                "S — 60 ml (Tek Shot)",
                "Su oranını uzat, bitterleşmeye dikkat."));

        list.add(new Recipe("Macchiato (Tek Shot)",
                "Espresso üstüne az süt köpüğü.",
                CAT_ESPRESSO, R.drawable.ic_launcher_foreground,
                "S — 80–100 ml (Tek Shot)",
                "Köpüğü kaşıkla hafifçe ekle."));
        list.add(new Recipe("Macchiato (Çift Shot)",
                "Daha yoğun kahve tadı.",
                CAT_ESPRESSO, R.drawable.ic_launcher_foreground,
                "S — 100–120 ml (Çift Shot)",
                "Köpüğü tadı bastırmayacak kadar az tut."));

        list.add(new Recipe("Americano (Tek Shot)",
                "Espresso + sıcak su (uzun içim).",
                CAT_ESPRESSO, R.drawable.ic_launcher_foreground,
                "M — 250 ml (Tek Shot)",
                "Suyu espressoya ekle; üstten dök, karıştırma."));
        list.add(new Recipe("Americano (Çift Shot)",
                "Daha gövdeli, daha yoğun Americano.",
                CAT_ESPRESSO, R.drawable.ic_launcher_foreground,
                "L — 350 ml (Çift Shot)",
                "Oran 1:2–1:3; suyu tadı bozmadan artır."));

        // ---------- FİLTRE ----------
        list.add(new Recipe("Pour Over (V60)",
                "Temiz ve aromatik gövde.",
                CAT_FILTRE, R.drawable.ic_launcher_foreground,
                "M — 250 ml",
                "2:30 dk demleme, spiral döküş."));
        list.add(new Recipe("Chemex",
                "Berrak ve hafif gövde.",
                CAT_FILTRE, R.drawable.ic_launcher_foreground,
                "L — 300 ml",
                "Kalın filtre kağıdıyla berrak demleme."));
        list.add(new Recipe("French Press",
                "Klasik tam gövde kahve.",
                CAT_FILTRE, R.drawable.ic_launcher_foreground,
                "M — 300 ml",
                "4 dk demle, bastır ve hemen servis et."));
        list.add(new Recipe("Kalita Wave",
                "Tatlı ve dengeli gövde.",
                CAT_FILTRE, R.drawable.ic_launcher_foreground,
                "M — 240 ml",
                "Düz taban, sabit akış sağla."));
        list.add(new Recipe("Syphon",
                "Görsel şovlu demleme.",
                CAT_FILTRE, R.drawable.ic_launcher_foreground,
                "M — 220 ml",
                "Alt ısı dengesini sabit tut."));

        // ---------- SPECIAL (sütlü) ----------
        list.add(new Recipe("Latte (Tek Shot)",
                "Süt yoğun; latte art için ideal geniş ağızlı kupa.",
                CAT_SPECIAL, R.drawable.ic_launcher_foreground,
                "L — 300 ml (Tek Shot)",
                "Süt 60–65°C; mikroköpük pürüzsüz."));
        list.add(new Recipe("Latte (Çift Shot)",
                "Daha dengeli kahve tadı isteyenlere.",
                CAT_SPECIAL, R.drawable.ic_launcher_foreground,
                "L — 300 ml (Çift Shot)",
                "Art için akış hızını biraz artır."));

        list.add(new Recipe("Cappuccino (Tek Shot)",
                "Köpüğü belirgin, klasik cappuccino.",
                CAT_SPECIAL, R.drawable.ic_launcher_foreground,
                "M — 240 ml (Tek Shot)",
                "Köpüğü kaşıkla taşırma, kremsi kalmalı."));
        list.add(new Recipe("Cappuccino (Çift Shot)",
                "Kahve tadı daha baskın cappuccino.",
                CAT_SPECIAL, R.drawable.ic_launcher_foreground,
                "M — 240 ml (Çift Shot)",
                "Köpük kalınlığını aynı tut."));

        list.add(new Recipe("Flat White (Çift Shot)",
                "ESP: süt ≈ 1:1; yoğun kahve tadı.",
                CAT_SPECIAL, R.drawable.ic_launcher_foreground,
                "M — 220 ml (Çift Shot)",
                "Mikroköpüğü ince tut; latte’den farklı."));

        list.add(new Recipe("Mocha",
                "Espresso + süt + çikolata.",
                CAT_SPECIAL, R.drawable.ic_launcher_foreground,
                "L — 300 ml",
                "Önce çikolatayı erit, sonra espresso ekle."));

        // ---------- ALKOLLÜ (tek boy standard) ----------
        list.add(new Recipe("Irish Coffee",
                "Viski + kahve + krema.",
                CAT_ALKOLLU, R.drawable.ic_launcher_foreground,
                "250 ml (Standart)",
                "Viski önce; krema en son, karıştırma."));
        list.add(new Recipe("Espresso Martini",
                "Votka + kahve likörü + espresso (shakeli).",
                CAT_ALKOLLU, R.drawable.ic_launcher_foreground,
                "200 ml (Standart)",
                "İyi shake; üstte ince köpük."));
        list.add(new Recipe("Carajillo",
                "Brandy/likör + espresso sıcak servis.",
                CAT_ALKOLLU, R.drawable.ic_launcher_foreground,
                "150 ml (Standart)",
                "Likörü az az ekle; espressoyu bastırma."));
        list.add(new Recipe("Kahlúa Latte",
                "Kahve likörü + süt.",
                CAT_ALKOLLU, R.drawable.ic_launcher_foreground,
                "240 ml (Standart)",
                "Kahve aroması baskın kalsın."));
        list.add(new Recipe("Baileys Coffee",
                "Baileys + kahve.",
                CAT_ALKOLLU, R.drawable.ic_launcher_foreground,
                "240 ml (Standart)",
                "Baileys’i ısıtma; aroma kalsın."));

        // ---------- ICE ----------
        list.add(new Recipe("Iced Americano (Tek Shot)",
                "Espresso + soğuk su + buz.",
                CAT_ICE, R.drawable.ic_launcher_foreground,
                "L — 350 ml (Tek Shot)",
                "Espressoyu en son dök; üstte katman oluşsun."));
        list.add(new Recipe("Iced Americano (Çift Shot)",
                "Daha yoğun kahve tadı için çift shot.",
                CAT_ICE, R.drawable.ic_launcher_foreground,
                "L — 350 ml (Çift Shot)",
                "Buz miktarını artırıp sulanmayı dengele."));

        list.add(new Recipe("Iced Latte (Tek Shot)",
                "Espresso + soğuk süt + buz.",
                CAT_ICE, R.drawable.ic_launcher_foreground,
                "L — 350 ml (Tek Shot)",
                "Katmanlı görünüm için sütü önce koy."));
        list.add(new Recipe("Iced Latte (Çift Shot)",
                "Daha kahveli iced latte.",
                CAT_ICE, R.drawable.ic_launcher_foreground,
                "L — 350 ml (Çift Shot)",
                "Espressoyu buzun üstünden yavaş dök."));

        list.add(new Recipe("Cold Brew",
                "12–18 saat soğuk demleme.",
                CAT_ICE, R.drawable.ic_launcher_foreground,
                "L — 350 ml",
                "Buzla servis et; gerekirse suyla aç."));

        // ---------- TÜRK KAHVESİ (5 tarif, şeker seçenekleri notta) ----------
final String SUGAR_NOTE =
        "Şeker seçenekleri: Sade (0), Az (½ tatlı kaşığı ≈ 1 küp), " +
        "Orta (1 tatlı kaşığı ≈ 2 küp), Şekerli (2 tatlı kaşığı ≈ 3–4 küp).";

list.add(new Recipe(
        "Türk Kahvesi",
        "Cezvede yavaş pişirim, fincanda köpüklü servis.",
        CAT_TURK,
        R.drawable.ic_launcher_foreground,
        "T — 70 ml",
        SUGAR_NOTE + " Soğuk suyla başla; taşmadan köpüğü al."
));

list.add(new Recipe(
        "Menengiç",
        "Kafeinsiz, doğal ve yağlı aromalı içim.",
        CAT_TURK,
        R.drawable.ic_launcher_foreground,
        "T — 100 ml",
        SUGAR_NOTE + " Kısık ateşte yavaş ısıt; kaynatma."
));

list.add(new Recipe(
        "Dibek Kahvesi",
        "İri öğütüm, dolgun ve aromatik gövde.",
        CAT_TURK,
        R.drawable.ic_launcher_foreground,
        "T — 100 ml",
        SUGAR_NOTE + " Kaynama noktasına yaklaşmadan ocaktan al."
));

list.add(new Recipe(
        "Sütlü Türk Kahvesi",
        "Daha yumuşak içim; suyun bir kısmı süt ile değiştirilir.",
        CAT_TURK,
        R.drawable.ic_launcher_foreground,
        "T — 90 ml",
        SUGAR_NOTE + " Süt oranını %30–50 arası tut; taşmaya dikkat."
));

list.add(new Recipe(
        "Damla Sakızlı Türk Kahvesi",
        "Hafif sakız aromalı, tatlımsı profil.",
        CAT_TURK,
        R.drawable.ic_launcher_foreground,
        "T — 70 ml",
        SUGAR_NOTE + " Çok az sakız kullan; aroma baskın olmasın."
));
        return list;
    }

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