package com.example.coffee.data;

import android.content.Context;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    // Kategoriler
    public static final int CAT_ESPRESSO  = 1;
    public static final int CAT_FILTER    = 2;
    public static final int CAT_SPECIAL   = 3;
    public static final int CAT_ALCOHOLIC = 4;
    public static final int CAT_ICED      = 5;
    public static final int CAT_TURKISH   = 6;

    public static String categoryLabel(int cat) {
        switch (cat) {
            case CAT_ESPRESSO:  return "Espresso";
            case CAT_FILTER:    return "Filtre";
            case CAT_SPECIAL:   return "Special";
            case CAT_ALCOHOLIC: return "Alkollü";
            case CAT_ICED:      return "Soğuk";
            case CAT_TURKISH:   return "Türk";
            default:            return "Diğer";
        }
    }

    public static List<Recipe> getAll(Context ctx) {
        List<Recipe> list = new ArrayList<>();

        // ---------- ESPRESSO ----------
        list.add(new Recipe(
                "Espresso",
                "Tek shot, yoğun ve kısa içim.",
                "• 18–20 g kahve, ince öğütüm.\n" +
                "• 92–94 °C su, 9 bar.\n" +
                "• 2–3 sn pre-infusion; toplam 25–30 sn’de 36–40 g çıkış (1:2).\n" +
                "• Akış kaplan desenine dönünce durdur.",
                CAT_ESPRESSO, R.drawable.cup_espresso_70ml, "70 ml fincan"
        ));
        list.add(new Recipe(
                "Doppio",
                "Çift shot espresso.",
                "• 2×(18–20 g) veya 20 g basket; 40 g çıkış ×2 (toplam ~72–80 g).\n" +
                "• Aynı demleme parametreleri; toplam 27–32 sn.",
                CAT_ESPRESSO, R.drawable.cup_doppio_120ml, "120 ml fincan"
        ));
        list.add(new Recipe(
                "Ristretto",
                "Kısa akış; daha konsantre tat.",
                "• 18–20 g kahve; 18–25 g çıkış (1:1–1:1.3).\n" +
                "• Öğütümü bir tık inceleştir, 20–25 sn’de bitir.",
                CAT_ESPRESSO, R.drawable.cup_ristretto_50ml, "50 ml fincan"
        ));
        list.add(new Recipe(
                "Lungo",
                "Uzun akış; hafif gövde.",
                "• 18 g kahve; 60–80 g çıkış (1:3–1:4).\n" +
                "• Öğütümü kalınlaştır, 35–45 sn.",
                CAT_ESPRESSO, R.drawable.cup_lungo_150ml, "150 ml fincan"
        ));
        list.add(new Recipe(
                "Macchiato",
                "Espresso üstüne az süt köpüğü.",
                "• 1 shot espresso çek.\n" +
                "• 60–65 °C sütü mikrofoam yap.\n" +
                "• Üstüne 1–2 kaşık köpük koy.",
                CAT_ESPRESSO, R.drawable.cup_macchiato_120ml, "120 ml fincan"
        ));
        list.add(new Recipe(
                "Cortado",
                "Espresso + eşit miktar süt.",
                "• 1 shot espresso.\n" +
                "• 60–65 °C süt; 1:1 oranında ekle.\n" +
                "• İnce mikrofoam, kalın köpük değil.",
                CAT_ESPRESSO, R.drawable.cup_cortado_150ml, "150 ml bardak"
        ));
        list.add(new Recipe(
                "Flat White",
                "İnce mikrofoam ile yumuşak içim.",
                "• 1–2 shot espresso.\n" +
                "• 60–65 °C süt, çok ince mikrofoam.\n" +
                "• 150–180 ml finiş; latte’den daha az köpük.",
                CAT_ESPRESSO, R.drawable.cup_flatwhite_240ml, "240 ml kupa"
        ));
        list.add(new Recipe(
                "Cappuccino",
                "1:1:1 espresso/süt/köpük.",
                "• 1 shot espresso.\n" +
                "• 60–65 °C süt; 1 cm kalınlıkta köpük.\n" +
                "• Üstüne kakao serpebilirsin.",
                CAT_ESPRESSO, R.drawable.cup_cappucino_240ml, "240 ml kupa"
        ));
        list.add(new Recipe(
                "Latte",
                "Espresso üzerine bol süt.",
                "• 1 shot espresso.\n" +
                "• 60–65 °C süt, ince mikrofoam; 300 ml’ye tamamla.\n" +
                "• Latte art için ideal akış.",
                CAT_ESPRESSO, R.drawable.cup_latte_300ml, "300 ml kupa"
        ));
        list.add(new Recipe(
                "Mocha",
                "Çikolatalı latte.",
                "• 1 shot espresso + 15–25 g çikolata şurubu/kakao.\n" +
                "• 60–65 °C sütle tamamla, karıştır.\n" +
                "• Üstüne krema opsiyonel.",
                CAT_ESPRESSO, R.drawable.cup_mochacino_300ml, "300 ml kupa"
        ));
        list.add(new Recipe(
                "Breve",
                "Espresso + yarım yağlı krema.",
                "• 1 shot espresso.\n" +
                "• Süt yerine yarı süt/yarı krema (half-and-half) kullan.\n" +
                "• Kısa ve yoğun içim.",
                CAT_ESPRESSO, R.drawable.cup_breve_200ml, "200 ml kupa"
        ));
        list.add(new Recipe(
                "Piccolo Latte",
                "Küçük bardakta latte.",
                "• 1 ristretto veya kısa espresso.\n" +
                "• 60–65 °C süt; 120 ml cam bardağa dök.",
                CAT_ESPRESSO, R.drawable.cup_piccolalatte_120ml, "120 ml bardak"
        ));
        list.add(new Recipe(
                "Con Panna",
                "Espresso üstüne krem şanti.",
                "• 1 shot espresso.\n" +
                "• Üstüne 1–2 tatlı kaşığı taze krem şanti.\n" +
                "• Hemen servis et.",
                CAT_ESPRESSO, R.drawable.cup_conpanna_100ml, "100 ml fincan"
        ));
        list.add(new Recipe(
                "Romano",
                "Espresso + limon kabuğu.",
                "• Fincanın kenarını limon kabuğuyla yağla.\n" +
                "• 1 shot espressoyu ekle, kabukla servis.",
                CAT_ESPRESSO, R.drawable.cup_romano_70ml, "70 ml fincan"
        ));
        list.add(new Recipe(
                "Americano",
                "Espresso üzerine sıcak su.",
                "• 150–200 ml sıcak suyu bardağa koy.\n" +
                "• Üzerine 1 shot espresso ekle (crema korunsun).",
                CAT_ESPRESSO, R.drawable.cup_americano_350ml, "350 ml kupa"
        ));
        list.add(new Recipe(
                "Affogato",
                "Espresso + vanilyalı dondurma.",
                "• 1 top vanilyalı dondurmayı bardağa koy.\n" +
                "• Üzerine taze 1 shot espresso dök; hemen servis.",
                CAT_ESPRESSO, R.drawable.cup_affogato_150ml, "150 ml fincan"
        ));

        // ---------- FİLTRE ----------
        list.add(new Recipe(
                "V60 Pour Over",
                "Klasik filtre demleme, temiz finiş.",
                "• 15 g kahve (orta-ince), 250 g su @ 92–94 °C.\n" +
                "• 30–45 sn blooming (2× su), ardından spiral döküşle toplam 2:30–3:00.",
                CAT_FILTER, R.drawable.cup_v60, "350 ml ekipman"
        ));
        list.add(new Recipe(
                "Chemex",
                "Kalın filtreyle temiz tat.",
                "• 30 g kahve (orta-kalın), 500 g su @ 92–94 °C.\n" +
                "• Bloom 45 sn; toplam 3:30–4:30 sürede tamamla.",
                CAT_FILTER, R.drawable.cup_chemex, "600 ml ekipman"
        ));
        list.add(new Recipe(
                "French Press",
                "Klasik yoğun filtre.",
                "• 18 g kahve (orta-kalın), 300 g su @ 93 °C.\n" +
                "• 4 dk beklet; bastır ve hemen servis et.",
                CAT_FILTER, R.drawable.cup_frenchpress, "350 ml ekipman"
        ));
        list.add(new Recipe(
                "AeroPress",
                "Basınçla kısa demleme.",
                "• 15 g kahve (orta-ince), 220 g su @ 85–90 °C.\n" +
                "• 1 dk karıştır, 30 sn presle.\n" +
                "• İnverted yöntem opsiyonel.",
                CAT_FILTER, R.drawable.cup_aeropress, "200 ml ekipman"
        ));
        list.add(new Recipe(
                "Syphon Brew",
                "Vakumla görsel demleme.",
                "• 20 g kahve (orta), 300 g su @ 92 °C.\n" +
                "• Yükselince 45–60 sn karıştır; 1 dk’da aşağı süzülsün.",
                CAT_FILTER, R.drawable.cup_syphonbrew, "400 ml ekipman"
        ));
        list.add(new Recipe(
                "Moka Pot",
                "Klasik İtalyan cezvesi.",
                "• Alt hazneye suyu valf altına kadar koy.\n" +
                "• Sepete orta-ince öğütüm kahve; yüzeyi düzle.\n" +
                "• Orta ateşte çıkış başlar başlamaz al.",
                CAT_FILTER, R.drawable.cup_mokapot, "250 ml ekipman"
        ));
        list.add(new Recipe(
                "Percolator",
                "Kaynama devridaimiyle yoğun tat.",
                "• Orta-kalın öğütüm; orta ateşte 6–8 dk devir daim.\n" +
                "• Aşırı demlemeyi önlemek için süreyi kontrol et.",
                CAT_FILTER, R.drawable.cup_percolator, "500 ml ekipman"
        ));
        list.add(new Recipe(
                "Kalita Wave",
                "Dengeli su akışıyla demleme.",
                "• 20 g kahve (orta), 320 g su @ 93 °C.\n" +
                "• 3 döküş; toplam 3:00–3:30.",
                CAT_FILTER, R.drawable.cup_kalitawave, "350 ml ekipman"
        ));
        list.add(new Recipe(
                "Cold Drip",
                "Buzlu suyla yavaş damlama.",
                "• Orta öğütüm; 6–12 saat arası yavaş damla.\n" +
                "• Konsantreyi buzla servis et.",
                CAT_FILTER, R.drawable.cup_colddrip, "500 ml ekipman"
        ));

        // ---------- SPECIAL ----------
        list.add(new Recipe(
                "Caramel Brûlée Latte",
                "Karamel soslu, kremalı latte.",
                "• 1 shot espresso + 20–30 g karamel sos.\n" +
                "• 60–65 °C sütle tamamla; üstüne karamel gezdir.",
                CAT_SPECIAL, R.drawable.cup_caramel_brulee_latte, "350 ml bardak"
        ));
        list.add(new Recipe(
                "Rose Latte",
                "Gül aromalı, yumuşak latte.",
                "• 1 shot espresso + 5–10 ml gül şurubu.\n" +
                "• 60–65 °C süt; gül yaprağıyla süsle.",
                CAT_SPECIAL, R.drawable.cup_rose_latte, "300 ml bardak"
        ));
        list.add(new Recipe(
                "Pistachio Latte",
                "Fıstıklı süt aromalı latte.",
                "• 1 shot espresso + 10–15 g fıstık kreması/şurubu.\n" +
                "• 60–65 °C süt; üstüne kıyılmış fıstık.",
                CAT_SPECIAL, R.drawable.cup_pistachio_latte, "300 ml bardak"
        ));
        list.add(new Recipe(
                "Honey Latte",
                "Bal ve sütle doğal tat.",
                "• 1 shot espresso + 10–15 g balı espressoya çözdür.\n" +
                "• 60–65 °C sütle tamamla.",
                CAT_SPECIAL, R.drawable.cup_honey_latte, "300 ml bardak"
        ));
        list.add(new Recipe(
                "Spanish Mocha",
                "Kakao + süt + tarçın aroması.",
                "• 1 shot espresso + kakao + bir tutam tarçın.\n" +
                "• 60–65 °C süt; üstüne tarçın serpiştir.",
                CAT_SPECIAL, R.drawable.cup_spanish_mocha, "300 ml bardak"
        ));

        // ---------- ALKOLLÜ ----------
        list.add(new Recipe(
                "Irish Coffee",
                "Kahve + viski + krema.",
                "• 120 ml sıcak filtre kahve + 40 ml İrlanda viskisi + şeker.\n" +
                "• Üste hafif çırpılmış kremayı yüzdür.",
                CAT_ALCOHOLIC, R.drawable.cup_irish_coffee, "240 ml bardak"
        ));
        list.add(new Recipe(
                "Baileys Latte",
                "Baileys likörlü latte.",
                "• 1 shot espresso + 30 ml Baileys.\n" +
                "• 60–65 °C sütle tamamla.",
                CAT_ALCOHOLIC, R.drawable.cup_baileys_latte, "300 ml bardak"
        ));
        list.add(new Recipe(
                "Amaretto Mocha",
                "Badem likörlü mocha.",
                "• 1 shot espresso + 20 g çikolata + 20 ml Amaretto.\n" +
                "• Sütle tamamla; krema opsiyonel.",
                CAT_ALCOHOLIC, R.drawable.cup_amaretto_mocha, "300 ml bardak"
        ));
        list.add(new Recipe(
                "Rum Mocha",
                "Rom aromalı sıcak mocha.",
                "• 1 shot espresso + 20 g çikolata + 15 ml rom.\n" +
                "• 60–65 °C süt; üstüne kakao.",
                CAT_ALCOHOLIC, R.drawable.cup_rum_mocha, "300 ml bardak"
        ));
        list.add(new Recipe(
                "Espresso Martini",
                "Vodka + kahve likörü + espresso.",
                "• Shaker: 40 ml vodka + 20 ml kahve likörü + 1 shot espresso + buz.\n" +
                "• İyice çalkala, süz; 3 kahve çekirdeğiyle servis.",
                CAT_ALCOHOLIC, R.drawable.cup_espresso_martini, "150 ml kadeh"
        ));

        // ---------- SOĞUK ----------
        list.add(new Recipe(
                "Iced Americano",
                "Espresso + soğuk su + buz.",
                "• Bardağı buzla doldur.\n" +
                "• 120–150 ml soğuk su + 1 shot espresso ekle.",
                CAT_ICED, R.drawable.cup_iced_americano, "400 ml bardak"
        ));
        list.add(new Recipe(
                "Iced Latte",
                "Soğuk süt + espresso.",
                "• Bardağı buzla doldur.\n" +
                "• 200 ml soğuk süt + 1 shot espresso dök.",
                CAT_ICED, R.drawable.cup_iced_latte, "400 ml bardak"
        ));
        list.add(new Recipe(
                "Iced Mocha",
                "Soğuk çikolatalı latte.",
                "• Bardağın içine çikolata sos; buz ekle.\n" +
                "• 200 ml soğuk süt + 1 shot espresso.\n" +
                "• Karıştır, üstüne krema opsiyonel.",
                CAT_ICED, R.drawable.cup_iced_mocha, "400 ml bardak"
        ));
        list.add(new Recipe(
                "Iced Breve",
                "Espresso + soğuk krema.",
                "• Buz + 150 ml süt + 50 ml krema + 1 shot espresso.\n" +
                "• Hafifçe karıştır.",
                CAT_ICED, R.drawable.cup_iced_breve, "300 ml bardak"
        ));
        list.add(new Recipe(
                "Affogato Freddo",
                "Soğuk espresso + dondurma.",
                "• 1–2 top vanilyalı dondurma.\n" +
                "• Üzerine soğutulmuş kısa espresso dök.",
                CAT_ICED, R.drawable.cup_affogato_freddo, "300 ml bardak"
        ));
        list.add(new Recipe(
                "Iced Pour Over",
                "Buz üstüne V60 dökümü.",
                "• Demleme suyunun %40’ını buz olarak karaf dibine koy.\n" +
                "• V60’ı normal oranla demle; buzun üzerine süz.",
                CAT_ICED, R.drawable.cup_icedpour, "350 ml bardak"
        ));

        // ---------- TÜRK ----------
        list.add(new Recipe(
                "Türk Kahvesi",
                "Klasik cezvede pişirilmiş Türk kahvesi.",
                "• Kişi başı: 1 tepeleme çay kaşığı kahve + 60–70 ml su.\n" +
                "• Şeker tercihi: sade (0), az (1), orta (2), şekerli (3 çk).\n" +
                "• Kısık ateşte, taşırmadan köpüğü fincanlara paylaştır.",
                CAT_TURKISH, R.drawable.cup_t_70ml, "70 ml fincan"
        ));
        list.add(new Recipe(
                "Menengiç Kahvesi",
                "Kafeinsiz, aromatik menengiç.",
                "• Sütle pişirilirse daha kremsi olur.\n" +
                "• Kısık ateşte yavaşça köpürt.",
                CAT_TURKISH, R.drawable.cup_t_70ml, "70 ml fincan"
        ));
        list.add(new Recipe(
                "Dibek Kahvesi",
                "Yumuşak içimli, farklı öğütüm.",
                "• Orta ateşte, fokurmadan önce köpüğü al.\n" +
                "• Şeker tercihi isteğe göre.",
                CAT_TURKISH, R.drawable.cup_t_70ml, "80 ml fincan"
        ));
        list.add(new Recipe(
                "Osmanlı Kahvesi",
                "Baharatlı karışım (tarçın, kakule).",
                "• Karışıma 1 tutam tarçın/kakule ekle.\n" +
                "• Yavaş ateşte köpüğü kaçırma.",
                CAT_TURKISH, R.drawable.cup_t_70ml, "75 ml fincan"
        ));
        list.add(new Recipe(
                "Sütlü Türk Kahvesi",
                "Klasik tarife süt eklenmiş.",
                "• Suyun yarısı süt olacak şekilde pişir.\n" +
                "• Taşırmadan köpüğü paylaştır.",
                CAT_TURKISH, R.drawable.cup_t_70ml, "100 ml fincan"
        ));
        // İstersen bu sonuncuyu yoruma alabilirsin:
        list.add(new Recipe(
                "Damla Sakızlı Türk Kahvesi",
                "Hafif damla sakızı aroması.",
                "• Demlemeden önce cezveye minik bir parça damla sakızı ekle.\n" +
                "• Kısık ateşte eriyip aroma versin.",
                CAT_TURKISH, R.drawable.cup_t_70ml, "70 ml fincan"
        ));

        return list;
    }
}