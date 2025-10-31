package com.example.coffee.data;

import android.content.Context;
import com.example.coffee.R;
import com.example.coffee.data.model.Recipe;
import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    public static final String CAT_ESPRESSO   = "Espresso";
    public static final String CAT_FILTER     = "Filtre";
    public static final String CAT_SPECIAL    = "Special";
    public static final String CAT_ALCOHOLIC  = "Alkollü";
    public static final String CAT_ICED       = "Iced";
    public static final String CAT_TURKISH    = "Turkish";

    public static List<Recipe> getAll(Context ctx) {
        List<Recipe> list = new ArrayList<>();

        // ---------- ESPRESSO ----------
        list.add(new Recipe("Espresso", "Tek shot, yoğun ve kısa içim.",
                CAT_ESPRESSO, R.drawable.cup_espresso_70ml, "70 ml fincan", "18–20 g, 25–30 sn, ~1:2 oran."));
        list.add(new Recipe("Doppio", "Çift shot espresso.",
                CAT_ESPRESSO, R.drawable.cup_doppio_120ml, "120 ml fincan", "İki shot, 36–40 g çıkış."));
        list.add(new Recipe("Ristretto", "Kısa akış; daha konsantre tat.",
                CAT_ESPRESSO, R.drawable.cup_ristretto_50ml, "50 ml fincan", "1:1 oran, erken kes."));
        list.add(new Recipe("Lungo", "Uzun akış; hafif gövde.",
                CAT_ESPRESSO, R.drawable.cup_lungo_150ml, "150 ml fincan", "1:3 oran, daha uzun akış."));
        list.add(new Recipe("Macchiato", "Espresso üstüne az süt köpüğü.",
                CAT_ESPRESSO, R.drawable.cup_macchiato_120ml, "120 ml fincan", "Köpüğü kaşıkla ekle."));
        list.add(new Recipe("Cortado", "Espresso + eşit miktar süt.",
                CAT_ESPRESSO, R.drawable.cup_cortado_150ml, "150 ml bardak", "1:1 oran, mikrofoam."));
        list.add(new Recipe("Flat White", "İnce mikrofoam ile yumuşak içim.",
                CAT_ESPRESSO, R.drawable.cup_flatwhite_240ml, "240 ml kupa", "Çift shot + ince köpük."));
        list.add(new Recipe("Cappuccino", "1:1:1 espresso/süt/köpük.",
                CAT_ESPRESSO, R.drawable.cup_cappucino_240ml, "240 ml kupa", "Köpüğü kubbe gibi yap."));
        list.add(new Recipe("Latte", "Espresso üzerine bol süt.",
                CAT_ESPRESSO, R.drawable.cup_latte_300ml, "300 ml kupa", "Süt 60°C, latte art için."));
        list.add(new Recipe("Mocha", "Çikolatalı latte.",
                CAT_ESPRESSO, R.drawable.cup_mochacino_300ml, "300 ml kupa", "Çikolatayı espressoyla çöz."));
        list.add(new Recipe("Breve", "Espresso + yarım yağlı krema.",
                CAT_ESPRESSO, R.drawable.cup_breve_200ml, "200 ml kupa", "Yoğun shot + krema."));
        list.add(new Recipe("Piccolo Latte", "Küçük bardakta latte.",
                CAT_ESPRESSO, R.drawable.cup_piccolalatte_120ml, "120 ml bardak", "Tek shot + mikrofoam."));
        list.add(new Recipe("Con Panna", "Espresso üstüne krem şanti.",
                CAT_ESPRESSO, R.drawable.cup_conpanna_100ml, "100 ml fincan", "Kremayı son anda ekle."));
        list.add(new Recipe("Romano", "Espresso + limon kabuğu.",
                CAT_ESPRESSO, R.drawable.cup_romano_70ml, "70 ml fincan", "Limon kabuğunu kenara sür."));
        list.add(new Recipe("Americano", "Espresso üzerine sıcak su.",
                CAT_ESPRESSO, R.drawable.cup_americano_350ml, "350 ml kupa", "Önce su, sonra shot."));
        list.add(new Recipe("Affogato", "Espresso + vanilyalı dondurma.",
                CAT_ESPRESSO, R.drawable.cup_affogato_150ml, "150 ml fincan", "Sıcak shot’ı dondurmaya dök."));

        // ---------- FİLTRE ----------
        list.add(new Recipe("V60 Pour Over", "Klasik filtre demleme, temiz finiş.",
                CAT_FILTER, R.drawable.cup_v60, "350 ml ekipman", "1:15 oran, spiral döküş, 3 dk."));
        list.add(new Recipe("Chemex", "Kalın filtreyle temiz tat.",
                CAT_FILTER, R.drawable.cup_chemex, "600 ml ekipman", "Orta öğütüm, 4 dk demleme."));
        list.add(new Recipe("French Press", "Klasik yoğun filtre.",
                CAT_FILTER, R.drawable.cup_frenchpress, "350 ml ekipman", "4 dk beklet, nazikçe bastır."));
        list.add(new Recipe("AeroPress", "Basınçla kısa demleme.",
                CAT_FILTER, R.drawable.cup_aeropress, "200 ml ekipman", "1 dk karıştır, 30 sn pres."));
        list.add(new Recipe("Syphon Brew", "Vakumla görsel demleme.",
                CAT_FILTER, R.drawable.cup_syphonbrew, "400 ml ekipman", "Vakumla 45 sn karıştır."));
        list.add(new Recipe("Moka Pot", "Klasik İtalyan cezvesi.",
                CAT_FILTER, R.drawable.cup_mokapot, "250 ml ekipman", "Alt su, üst kahve, ısı düşük."));
        list.add(new Recipe("Percolator", "Kaynama devridaimiyle yoğun tat.",
                CAT_FILTER, R.drawable.cup_percolator, "500 ml ekipman", "Orta ateş, 7 dk demleme."));
        list.add(new Recipe("Kalita Wave", "Dengeli su akışıyla demleme.",
                CAT_FILTER, R.drawable.cup_kalitawave, "350 ml ekipman", "3 dk spiral dök."));
        list.add(new Recipe("Cold Drip", "Buzlu suyla yavaş damlama.",
                CAT_FILTER, R.drawable.cup_colddrip, "600 ml ekipman", "2–3 sn/1 damla, 4 saat."));

        // ---------- SPECIAL ----------
        list.add(new Recipe("Caramel Brûlée Latte", "Karamel soslu, kremalı latte.",
                CAT_SPECIAL, R.drawable.cup_caramel_brulee_latte, "350 ml bardak", "Karamel + süt + shot."));
        list.add(new Recipe("Rose Latte", "Gül aromalı, yumuşak latte.",
                CAT_SPECIAL, R.drawable.cup_rose_latte, "300 ml bardak", "Gül şurubu az ekle."));
        list.add(new Recipe("Pistachio Latte", "Fıstıklı süt aromalı latte.",
                CAT_SPECIAL, R.drawable.cup_pistachio_latte, "300 ml bardak", "Fıstık ezmesini sütle karıştır."));
        list.add(new Recipe("Honey Latte", "Bal ve sütle doğal tat.",
                CAT_SPECIAL, R.drawable.cup_honey_latte, "300 ml bardak", "Balı espressoya karıştır."));
        list.add(new Recipe("Spanish Mocha", "Kakao + süt + tarçın aroması.",
                CAT_SPECIAL, R.drawable.cup_spanish_mocha, "300 ml bardak", "Üzerine tarçın serpiştir."));

        // ---------- ALKOLLÜ ----------
        list.add(new Recipe("Irish Coffee", "Kahve + viski + krema.",
                CAT_ALCOHOLIC, R.drawable.cup_irish_coffee, "240 ml bardak", "Kremayı yüzdür."));
        list.add(new Recipe("Baileys Latte", "Baileys likörlü latte.",
                CAT_ALCOHOLIC, R.drawable.cup_baileys_latte, "300 ml bardak", "Baileys’i sütle karıştır."));
        list.add(new Recipe("Amaretto Mocha", "Badem likörlü mocha.",
                CAT_ALCOHOLIC, R.drawable.cup_amaretto_mocha, "300 ml bardak", "Tatlılık için krema ekle."));
        list.add(new Recipe("Rum Mocha", "Rom aromalı sıcak mocha.",
                CAT_ALCOHOLIC, R.drawable.cup_rum_mocha, "300 ml bardak", "Koyu çikolata + 10 ml rom."));
        list.add(new Recipe("Espresso Martini", "Vodka + kahve likörü + espresso.",
                CAT_ALCOHOLIC, R.drawable.cup_espresso_martini, "150 ml kadeh", "Buzla çalkala, süz."));

        // ---------- SOĞUK ----------
        list.add(new Recipe("Iced Americano", "Espresso + soğuk su + buz.",
                CAT_ICED, R.drawable.cup_iced_americano, "400 ml bardak", "Buzu erimeden servis."));
        list.add(new Recipe("Iced Latte", "Soğuk süt + espresso.",
                CAT_ICED, R.drawable.cup_iced_latte, "400 ml bardak", "Sütü soğuk köpürt."));
        list.add(new Recipe("Iced Mocha", "Soğuk çikolatalı latte.",
                CAT_ICED, R.drawable.cup_iced_mocha, "400 ml bardak", "Çikolata + süt + shot."));
        list.add(new Recipe("Iced Breve", "Espresso + soğuk krema.",
                CAT_ICED, R.drawable.cup_iced_breve, "300 ml bardak", "Kremayı buzla karıştır."));
        list.add(new Recipe("Affogato Freddo", "Soğuk espresso + dondurma.",
                CAT_ICED, R.drawable.cup_affogato_freddo, "300 ml bardak", "Shot’ı soğutup dök."));
        list.add(new Recipe("Iced Pour Over", "Buz üstüne V60 dökümü.",
                CAT_ICED, R.drawable.cup_icedpour, "350 ml bardak", "Yarısı buz, yarısı su."));

        // ---------- TÜRK ----------
        list.add(new Recipe("Türk Kahvesi", "Klasik cezvede pişirilmiş Türk kahvesi.",
                CAT_TURKISH, R.drawable.cup_t_70ml, "70 ml fincan", "Köpüğü kaçırma, yavaş ateş."));
        list.add(new Recipe("Menengiç Kahvesi", "Kafeinsiz, aromatik menengiç.",
                CAT_TURKISH, R.drawable.cup_t_70ml, "70 ml fincan", "Kısık ateşte pişir."));
        list.add(new Recipe("Dibek Kahvesi", "Yumuşak içimli, farklı öğütüm.",
                CAT_TURKISH, R.drawable.cup_t_70ml, "80 ml fincan", "Yoğun köpükle servis."));
        list.add(new Recipe("Osmanlı Kahvesi", "Baharatlı karışım (tarçın, kakule).",
                CAT_TURKISH, R.drawable.cup_t_70ml, "75 ml fincan", "Baharatları az ekle."));
        list.add(new Recipe("Sütlü Türk Kahvesi", "Klasik tarife süt eklenmiş versiyon.",
                CAT_TURKISH, R.drawable.cup_t_70ml, "100 ml fincan", "Sütü kaynatmadan ekle."));
        list.add(new Recipe("Damla Sakızlı Türk Kahvesi", "Hafif damla sakızı aroması.",
                CAT_TURKISH, R.drawable.cup_t_70ml, "70 ml fincan", "Küçük parça sakız yeterli."));

        return list;
    }
}