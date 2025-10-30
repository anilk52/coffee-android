package com.example.coffee.data;

import android.text.TextUtils;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public final class RecipesData {

    private RecipesData() {}

    // ---- Kategori sabitleri (hem TR hem EN alias'lar) ----
    public static final String CAT_ESPRESSO   = "espresso";
    public static final String CAT_FILTER     = "filter";
    public static final String CAT_FILTRE     = "filtre";      // alias
    public static final String CAT_ALCOHOLIC  = "alcoholic";
    public static final String CAT_ALKOLLU    = "alkollu";     // alias
    public static final String CAT_ICED       = "iced";
    public static final String CAT_ICE        = "ice";         // alias
    public static final String CAT_TURKISH    = "turkish";
    public static final String CAT_TURK       = "turk";        // alias
    public static final String CAT_SPECIAL    = "special";

    // ---- Public API ----
    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // ==================== ESPRESSO BAZLI ====================
        list.add(new Recipe("Espresso",        "Tek shot, yoğun ve kısa içim.",           CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "70 ml fincan",  "Ön demleme 2–3 sn, toplam 25–30 sn."));
        list.add(new Recipe("Doppio",          "Çift shot espresso.",                     CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "120 ml fincan", "Öğütümü bir tık kalınlaştır."));
        list.add(new Recipe("Ristretto",       "Kısa akış; daha konsantre.",              CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "50 ml fincan",  "1:1 oranında yoğun shot."));
        list.add(new Recipe("Lungo",           "Uzun akış; hafif gövdeli.",               CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "150 ml fincan", "Akışı uzat, öğütümü kalınlaştır."));
        list.add(new Recipe("Macchiato",       "Espresso üstüne az süt köpüğü.",          CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "120 ml fincan", "Köpüğü kaşıkla ekle."));
        list.add(new Recipe("Cortado",         "Espresso + eşit miktar süt.",             CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "150 ml bardak", "Süt 60°C civarı."));
        list.add(new Recipe("Flat White",      "İnce mikrofoam ile yumuşak içim.",        CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "240 ml kupa",   "Köpük boya kıvamında."));
        list.add(new Recipe("Cappuccino",      "1:1:1 espresso/süt/köpük.",               CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "240 ml kupa",   "Köpük kubbe gibi."));
        list.add(new Recipe("Latte",           "Espresso üzerine bol süt.",               CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "300 ml kupa",   "Latte art için ideal."));
        list.add(new Recipe("Mocha",           "Çikolatalı latte.",                       CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "300 ml kupa",   "Çikolatayı espressoyla çöz."));
        list.add(new Recipe("Breve",           "Espresso + yarım yağlı krema.",           CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "200 ml kupa",   "Yoğun içim için kısa shot."));
        list.add(new Recipe("Piccolo Latte",   "Küçük bardakta latte.",                   CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "120 ml bardak", "Tek shot + mikrofoam."));
        list.add(new Recipe("Con Panna",       "Espresso üstüne krem şanti.",             CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "100 ml fincan", "Kremayı son anda ekle."));
        list.add(new Recipe("Romano",          "Espresso + limon kabuğu.",                CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "70 ml fincan",  "Limon kabuğu yağıyla aroma."));
        list.add(new Recipe("Americano",       "Espresso üzerine sıcak su.",              CAT_ESPRESSO, R.drawable.ic_placeholder_logo, "350 ml kupa",   "Önce su, sonra shot."));
        // Elinde kesin var dediğin görsel:
        list.add(new Recipe("Affogato",        "Espresso + vanilyalı dondurma.",          CAT_ESPRESSO, R.drawable.cup_affogato150ml,   "150 ml fincan", "Sıcak shot’ı dondurmanın üstüne."));

        // ==================== FİLTRE / DEMLEME ====================
        list.add(new Recipe("V60 Pour Over",   "Klasik filtre demleme yöntemi.",          CAT_FILTER,   R.drawable.ic_placeholder_logo, "350 ml ekipman","Spiral döküş, 3 dk demleme."));
        list.add(new Recipe("Chemex",          "Kalın filtreyle temiz tat.",              CAT_FILTER,   R.drawable.ic_placeholder_logo, "600 ml ekipman","Orta öğütüm, 4 dk demleme."));
        // Elinde kesin var dediğin görseller:
        list.add(new Recipe("French Press",    "Kahveyi presle süz.",                     CAT_FILTER,   R.drawable.cup_frenchpress,     "350 ml ekipman","4 dk demleme, sonra bastır."));
        list.add(new Recipe("Cold Drip",       "Yavaş soğuk demleme.",                    CAT_FILTER,   R.drawable.cup_colddrip,        "400 ml ekipman","3–4 saatte yavaş damlama."));

        list.add(new Recipe("AeroPress",       "Basınçla kısa demleme.",                  CAT_FILTER,   R.drawable.ic_placeholder_logo, "200 ml ekipman","1 dk karıştır, 30 sn pres."));
        list.add(new Recipe("Syphon Brew",     "Vakumla demleme.",                        CAT_FILTER,   R.drawable.ic_placeholder_logo, "400 ml ekipman","Görsel şovlu demleme."));
        list.add(new Recipe("Moka Pot",        "Klasik İtalyan cezvesi.",                 CAT_FILTER,   R.drawable.ic_placeholder_logo, "250 ml ekipman","Alt su, üst kahve."));
        list.add(new Recipe("Percolator",      "Kaynama devridaimiyle demleme.",          CAT_FILTER,   R.drawable.ic_placeholder_logo, "500 ml ekipman","Orta ateş, 7 dk demleme."));
        list.add(new Recipe("Kalita Wave",     "Dengeli su akışıyla demleme.",            CAT_FILTER,   R.drawable.ic_placeholder_logo, "350 ml ekipman","3 dk’da spiral dök."));

        // ==================== ALKOLLÜ ====================
        list.add(new Recipe("Irish Coffee",    "Kahve + viski + krema.",                  CAT_ALCOHOLIC,R.drawable.ic_placeholder_logo, "240 ml bardak", "Kremayı üstte yüzdür."));
        list.add(new Recipe("Baileys Latte",   "Baileys likörlü latte.",                  CAT_ALCOHOLIC,R.drawable.ic_placeholder_logo, "300 ml bardak", "Baileys’i sütle karıştır."));
        list.add(new Recipe("Amaretto Mocha",  "Badem likörlü mocha.",                    CAT_ALCOHOLIC,R.drawable.ic_placeholder_logo, "300 ml bardak", "Tatlılık için krema ekle."));
        list.add(new Recipe("Rum Mocha",       "Rom aromalı sıcak mocha.",                CAT_ALCOHOLIC,R.drawable.ic_placeholder_logo, "300 ml bardak", "Koyu çikolata + 10 ml rom."));
        list.add(new Recipe("Espresso Martini","Vodka + kahve likörü + espresso.",        CAT_ALCOHOLIC,R.drawable.ic_placeholder_logo, "150 ml kadeh", "Buzla çalkala, süz."));

        // ==================== ICED ====================
        list.add(new Recipe("Iced Americano",  "Espresso + soğuk su + buz.",              CAT_ICED,     R.drawable.ic_placeholder_logo, "400 ml bardak", "Buzu erimeden servis."));
        list.add(new Recipe("Iced Latte",      "Soğuk süt + espresso.",                   CAT_ICED,     R.drawable.ic_placeholder_logo, "400 ml bardak", "Sütü soğuk köpürt."));
        list.add(new Recipe("Iced Mocha",      "Soğuk çikolatalı latte.",                 CAT_ICED,     R.drawable.ic_placeholder_logo, "400 ml bardak", "Bardağın kenarına çikolata izi."));
        list.add(new Recipe("Affogato Freddo", "Soğuk espresso + dondurma.",              CAT_ICED,     R.drawable.ic_placeholder_logo, "300 ml bardak", "Shot’ı soğutup dök."));
        list.add(new Recipe("Iced Breve",      "Espresso + soğuk krema.",                 CAT_ICED,     R.drawable.ic_placeholder_logo, "300 ml bardak", "Yarım yağlı krema ile karıştır."));
        list.add(new Recipe("Iced Pour Over",  "Buz üstüne V60 dökümü.",                  CAT_ICED,     R.drawable.ic_placeholder_logo, "350 ml bardak", "Yarısı buz, yarısı su."));

        // ==================== SPECIAL ====================
        list.add(new Recipe("Caramel Brûlée Latte","Karamel-köpükle özel latte.",         CAT_SPECIAL,  R.drawable.ic_placeholder_logo, "350 ml bardak", "Üzerine karamel sos gezdir."));
        list.add(new Recipe("Rose Latte",      "Gül aromalı sütlü kahve.",                CAT_SPECIAL,  R.drawable.ic_placeholder_logo, "300 ml bardak", "Gül yaprağıyla süsle."));
        list.add(new Recipe("Pistachio Latte", "Fıstıklı süt aromasıyla latte.",          CAT_SPECIAL,  R.drawable.ic_placeholder_logo, "300 ml bardak", "Üzerine kıyılmış fıstık ekle."));
        list.add(new Recipe("Honey Latte",     "Bal ve sütle doğal tat.",                 CAT_SPECIAL,  R.drawable.ic_placeholder_logo, "300 ml bardak", "Balı espressoya karıştır."));
        list.add(new Recipe("Spanish Mocha",   "Kakao + süt + tarçın aroması.",           CAT_SPECIAL,  R.drawable.ic_placeholder_logo, "300 ml bardak", "Üzerine tarçın serpiştir."));

        // ==================== TÜRK KAHVESİ ====================
        list.add(new Recipe("Türk Kahvesi",    "Klasik cezvede pişirilmiş Türk kahvesi.", CAT_TURKISH,  R.drawable.ic_placeholder_logo, "70 ml fincan",  "Yavaş ateşte; köpüğü kaçırma.\nNot: Sade: 0 şeker, Az: 1 çay kaşığı, Orta: 2, Şekerli: 3"));
        list.add(new Recipe("Menengiç Kahvesi","Kafeinsiz, aromatik menengiç.",           CAT_TURKISH,  R.drawable.ic_placeholder_logo, "70 ml fincan",  "Kısık ateşte pişir.\nNot: Sade veya az şekerli önerilir."));
        list.add(new Recipe("Dibek Kahvesi",   "Yumuşak içimli, farklı öğütüm.",          CAT_TURKISH,  R.drawable.ic_placeholder_logo, "80 ml fincan",  "Yoğun köpükle servis."));
        list.add(new Recipe("Osmanlı Kahvesi", "Baharatlı karışım (tarçın, kakule).",     CAT_TURKISH,  R.drawable.ic_placeholder_logo, "75 ml fincan",  "Baharatları kontrollü ekle."));
        list.add(new Recipe("Sütlü Türk",      "Klasik tarife süt eklenmiş versiyon.",    CAT_TURKISH,  R.drawable.ic_placeholder_logo, "100 ml fincan", "Sütü kaynatmadan ekle."));

        return list;
    }

    /** Kategoriye göre filtreler; null/boş ise tümünü döner. */
    public static List<Recipe> forCategory(String category) {
        List<Recipe> all = getAll();
        if (TextUtils.isEmpty(category)) return all;

        String target = normalizeCategory(category);
        List<Recipe> out = new ArrayList<>();
        for (Recipe r : all) {
            if (normalizeCategory(r.getCategory()).equals(target)) {
                out.add(r);
            }
        }
        return out;
    }

    /** Ada göre ilk eşleşeni döner; yoksa null. */
    public static Recipe findByName(String name) {
        if (TextUtils.isEmpty(name)) return null;
        for (Recipe r : getAll()) {
            if (r.getName() != null && r.getName().equalsIgnoreCase(name.trim())) {
                return r;
            }
        }
        return null;
    }

    // ---- Helpers ----
    private static String normalizeCategory(String cat) {
        if (cat == null) return "";
        String c = cat.trim().toLowerCase();

        if (c.equals(CAT_ESPRESSO)) return CAT_ESPRESSO;

        if (c.equals(CAT_FILTER) || c.equals(CAT_FILTRE)) return CAT_FILTER;

        if (c.equals(CAT_ALCOHOLIC) || c.equals(CAT_ALKOLLU)) return CAT_ALCOHOLIC;

        if (c.equals(CAT_ICED) || c.equals(CAT_ICE)) return CAT_ICED;

        if (c.equals(CAT_TURKISH) || c.equals(CAT_TURK)) return CAT_TURKISH;

        if (c.equals(CAT_SPECIAL)) return CAT_SPECIAL;

        // Bilinmeyenleri olduğu gibi döndür (belki ileride yeni kategori eklersin)
        return c;
    }
}