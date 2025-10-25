package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Uygulama içi demo veri kaynağı.
 * 5 kategori x 5 kahve = 25 öğe
 *
 * Kategoriler:
 * - "Espresso"
 * - "Filtre"
 * - "Special"
 * - "Alkollü"
 * - "Ice"
 */
public class RecipesData {

    // --- Ana liste (lazy build) ---
    private static List<Recipe> CACHE;

    public static List<Recipe> getAll() {
        if (CACHE != null) return CACHE;

        List<Recipe> list = new ArrayList<>();

        // ========== ESPRESSO ==========
        list.add(new Recipe(
                "Espresso",
                "Yoğun, kısa ve karakterli shot.",
                "Espresso",
                R.drawable.ic_launcher_foreground,
                "XS — 30 ml (Demitasse)",
                "25 sn, 18 g, 9 bar… tek yudumda karakter!"
        ));
        list.add(new Recipe(
                "Ristretto",
                "Daha kısa ve daha yoğun espresso.",
                "Espresso",
                R.drawable.ic_launcher_foreground,
                "XS — 20 ml (Demitasse)",
                "Kısa iç, uzun yaşa — aroma zirvede!"
        ));
        list.add(new Recipe(
                "Lungo",
                "Uzun çekim, daha yumuşak içim.",
                "Espresso",
                R.drawable.ic_launcher_foreground,
                "S — 120 ml (Short)",
                "Öğütüm çok ince olmasın; acılık kaçsın."
        ));
        list.add(new Recipe(
                "Doppio",
                "Çift shot espresso, bol enerji.",
                "Espresso",
                R.drawable.ic_launcher_foreground,
                "S — 120 ml (Short)",
                "İki shot, tek ruh — gün senin!"
        ));
        list.add(new Recipe(
                "Macchiato",
                "Espresso üstüne az süt köpüğü dokunuşu.",
                "Espresso",
                R.drawable.ic_launcher_foreground,
                "S — 100 ml (Short)",
                "Az süt, çok ruh: lezzet çizgiyi aşmasın."
        ));

        // ========== FİLTRE ==========
        list.add(new Recipe(
                "Filter Coffee",
                "Klasik makine demlemesi, net gövde.",
                "Filtre",
                R.drawable.ic_launcher_foreground,
                "M — 250 ml (Regular)",
                "Orta öğütüm, temiz filtre: tat şeffaf olsun."
        ));
        list.add(new Recipe(
                "V60 Pour Over",
                "Elle döküş, dengeli ve temiz fincan.",
                "Filtre",
                R.drawable.ic_launcher_foreground,
                "M — 250 ml (Regular)",
                "Dairesel dök, nazik ol: krema değil akış önemli."
        ));
        list.add(new Recipe(
                "Chemex",
                "Hafif gövde, kristal berraklık.",
                "Filtre",
                R.drawable.ic_launcher_foreground,
                "L — 300 ml (Tall)",
                "Kalın filtre = pürüzsüz tat; sabır en iyi dostun."
        ));
        list.add(new Recipe(
                "French Press",
                "Yoğun gövdeli, uzun demleme.",
                "Filtre",
                R.drawable.ic_launcher_foreground,
                "L — 300 ml (Tall)",
                "4 dk bekle; bastıktan sonra hemen servise."
        ));
        list.add(new Recipe(
                "AeroPress",
                "Hızlı ve pratik basınçlı demleme.",
                "Filtre",
                R.drawable.ic_launcher_foreground,
                "M — 220 ml (Regular)",
                "Ters yöntem meraklısına; öğütümü orta seç."
        ));

        // ========== SPECIAL ==========
        list.add(new Recipe(
                "Flat White",
                "İnce köpük, dengeli espresso-süt uyumu.",
                "Special",
                R.drawable.ic_launcher_foreground,
                "S — 150 ml (Short)",
                "Köpüğü fazla şişirme; dengeyle parılda."
        ));
        list.add(new Recipe(
                "Cortado",
                "Espresso ile eşit sıcak süt — dengeli.",
                "Special",
                R.drawable.ic_launcher_foreground,
                "S — 120 ml (Short)",
                "Asitliği sütle sakinleştir; net tat kalsın."
        ));
        list.add(new Recipe(
                "Affogato",
                "Espresso + vanilya dondurma: sıcak-soğuk mutluluk.",
                "Special",
                R.drawable.ic_launcher_foreground,
                "S — 120 ml (Short)",
                "Dondurmayı eritirken bak: mutluluk akıyor."
        ));
        list.add(new Recipe(
                "Spanish Latte",
                "Tatlı yoğunlaştırılmış sütlü latte.",
                "Special",
                R.drawable.ic_launcher_foreground,
                "L — 300 ml (Tall)",
                "Tatlı seviyorsan gönülden koy; dengeyi bozma."
        ));
        list.add(new Recipe(
                "Caramel Latte",
                "Espresso, süt ve karamelin yumuşak buluşması.",
                "Special",
                R.drawable.ic_launcher_foreground,
                "L — 300 ml (Tall)",
                "Karameli önce bardakta çöz; tat eşit yayılsın."
        ));

        // ========== ALKOLLÜ ==========
        list.add(new Recipe(
                "Irish Coffee",
                "Espresso, viski ve krema — efsane üçlü.",
                "Alkollü",
                R.drawable.ic_launcher_foreground,
                "M — 250 ml (Regular)",
                "Viski önce, krema en son: katmanlar konuşsun."
        ));
        list.add(new Recipe(
                "Baileys Latte",
                "Sütlü latteye Baileys dokunuşu.",
                "Alkollü",
                R.drawable.ic_launcher_foreground,
                "M — 250 ml (Regular)",
                "Baileys’i ısıtma; aromasını koru."
        ));
        list.add(new Recipe(
                "Kahlua Mocha",
                "Espresso + çikolata + Kahlua: tatlı-sert denge.",
                "Alkollü",
                R.drawable.ic_launcher_foreground,
                "M — 250 ml (Regular)",
                "Likörü az az ekle; kahve başrolde kalsın."
        ));
        list.add(new Recipe(
                "Espresso Martini",
                "Kokteyl bardağında şık kahve kokteyli.",
                "Alkollü",
                R.drawable.ic_launcher_foreground,
                "S — 150 ml (Short)",
                "Shake iyi yap; üstte ince köpük şart."
        ));
        list.add(new Recipe(
                "Amaretto Coffee",
                "Badem likörlü sıcak kahve.",
                "Alkollü",
                R.drawable.ic_launcher_foreground,
                "M — 200 ml (Regular)",
                "Badem aroması baskınsa kahveyi bir tık güçlendir."
        ));

        // ========== ICE ==========
        list.add(new Recipe(
                "Iced Americano",
                "Espresso, soğuk su ve buz — ferahlatıcı.",
                "Ice",
                R.drawable.ic_launcher_foreground,
                "L — 300 ml (Tall)",
                "Önce su, sonra buz: sulanmayı kontrol et."
        ));
        list.add(new Recipe(
                "Iced Latte",
                "Espresso ve soğuk süt — yaz klasiği.",
                "Ice",
                R.drawable.ic_launcher_foreground,
                "XL — 400 ml (Grande)",
                "Buzu bol koy; yazı uzat."
        ));
        list.add(new Recipe(
                "Cold Brew",
                "Uzun süre soğuk demleme — ipeksi içim.",
                "Ice",
                R.drawable.ic_launcher_foreground,
                "L — 300 ml (Tall)",
                "12 saat beklet; sabır fincana değer."
        ));
        list.add(new Recipe(
                "Frappe",
                "Buzlu, kremsi ve enerjik karışım.",
                "Ice",
                R.drawable.ic_launcher_foreground,
                "XL — 450 ml (Grande)",
                "Buzu ezmeden karıştır; köpük doğallıkla gelsin."
        ));
        list.add(new Recipe(
                "Mocha Frappe",
                "Çikolata soslu buzlu kahve keyfi.",
                "Ice",
                R.drawable.ic_launcher_foreground,
                "XL — 450 ml (Grande)",
                "Çikolatayı önce çözdür; tat eşit dağılmalı."
        ));

        CACHE = Collections.unmodifiableList(list);
        return CACHE;
    }

    // --- Yardımcılar ---

    /** İsme göre tarif bul (tam eşleşme, büyük/küçük harf duyarsız). */
    public static Recipe findByName(String name) {
        if (name == null || name.trim().isEmpty()) return null;
        for (Recipe r : getAll()) {
            if (r.getName() != null && r.getName().equalsIgnoreCase(name.trim())) {
                return r;
            }
        }
        return null;
    }

    /** Kategoriye göre Recipe listesi. */
    public static List<Recipe> byCategory(String category) {
        if (category == null || category.trim().isEmpty()) return Collections.emptyList();
        String c = category.trim();
        List<Recipe> out = new ArrayList<>();
        for (Recipe r : getAll()) {
            if (c.equalsIgnoreCase(r.getCategory())) out.add(r);
        }
        return out;
    }

    /** Tüm başlıkları (isimleri) döndür. */
    public static List<String> allTitles() {
        List<String> titles = new ArrayList<>();
        for (Recipe r : getAll()) {
            if (r.getName() != null) titles.add(r.getName());
        }
        return titles;
    }

    /** Verilen kategori için başlık listesi. */
    public static List<String> titlesForCategory(String category) {
        List<String> titles = new ArrayList<>();
        for (Recipe r : byCategory(category)) {
            if (r.getName() != null) titles.add(r.getName());
        }
        return titles;
    }
}