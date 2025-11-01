package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecipesData {

    private RecipesData() {}

    // KATEGORİLER
    public static final String CAT_ESPRESSO   = "ESPRESSO";
    public static final String CAT_FILTER     = "FILTER";
    public static final String CAT_SPECIAL    = "SPECIAL";
    public static final String CAT_ALCOHOLIC  = "ALCOHOLIC";
    public static final String CAT_ICED       = "ICED";
    public static final String CAT_TURKISH    = "TURKISH";

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

    // TÜM TARİFLER (46 toplam)
    private static final List<Recipe> ALL = buildAll();
    private static List<Recipe> buildAll() {
        List<Recipe> list = new ArrayList<>();

        // ---------- ESPRESSO ----------
        list.add(new Recipe(R.drawable.cup_espresso_70ml, "Espresso", "Kısa, yoğun shot.", "18–20 g kahve, 25 sn akış", "30 ml", "Taze çekim kullan.", "Fincanı ısıt.", CAT_ESPRESSO, "T – 70 ml"));
        list.add(new Recipe(R.drawable.cup_ristretto_50ml, "Ristretto", "Kısa akışlı espresso.", "Aynı doz, daha az su", "20–25 ml", "Daha tatlı gövde.", "İnce öğütüm uygundur.", CAT_ESPRESSO, "50 ml"));
        list.add(new Recipe(R.drawable.cup_lungo_150ml, "Lungo", "Uzun espresso.", "Daha uzun akış, 60–90 ml", "60–90 ml", "Acılığı dengele.", "Orta öğütüm.", CAT_ESPRESSO, "150 ml"));
        list.add(new Recipe(R.drawable.cup_doppio_120ml, "Doppio", "Çift shot espresso.", "Çift basket, 60 ml", "60 ml", "Tamping sabit olmalı.", "Çekim dengeli olsun.", CAT_ESPRESSO, "120 ml"));
        list.add(new Recipe(R.drawable.cup_macchiato_120ml, "Macchiato", "Espresso + süt köpüğü.", "1 shot + az süt köpüğü", "120 ml", "Süt 60°C civarı.", "Köpüğü ince tut.", CAT_ESPRESSO, "120 ml"));
        list.add(new Recipe(R.drawable.cup_conpanna_100ml, "Con Panna", "Espresso üstü krema.", "1 shot + çırpılmış krema", "100 ml", "Tatlı krema uygundur.", "Soğuk servis.", CAT_ESPRESSO, "100 ml"));
        list.add(new Recipe(R.drawable.cup_cortado_150ml, "Cortado", "Espresso + eşit süt.", "1:1 oran", "150 ml", "Süt az köpüklü olsun.", "Asidite dengeler.", CAT_ESPRESSO, "150 ml"));
        list.add(new Recipe(R.drawable.cup_flatwhite_240ml, "Flat White", "Yoğun kahve, ince köpük.", "Doppio + 150 ml süt", "240 ml", "Microfoam ipeksi olsun.", "Yoğun tat.", CAT_ESPRESSO, "240 ml"));
        list.add(new Recipe(R.drawable.cup_piccolalatte_120ml, "Piccolo Latte", "Mini latte.", "Espresso + az süt", "120 ml", "Küçük bardak.", "Sıcaklığı koru.", CAT_ESPRESSO, "120 ml"));
        list.add(new Recipe(R.drawable.cup_americano_350ml, "Americano", "Espresso + su.", "1 shot + sıcak su", "350 ml", "Önce su, sonra shot.", "Hafif gövde.", CAT_ESPRESSO, "350 ml"));
        list.add(new Recipe(R.drawable.cup_romano_70ml, "Romano", "Espresso + limon.", "Limon kabuğu aromalı shot", "70 ml", "Limon kabuğu ekle.", "Asidite artar.", CAT_ESPRESSO, "70 ml"));

        // ---------- FİLTRE ----------
        list.add(new Recipe(R.drawable.cup_v60, "V60", "Temiz ve parlak kahve.", "1:15 oran, 3 dk", "300 ml", "Dairesel döküş.", "Bloom 30 sn.", CAT_FILTER, "300 ml"));
        list.add(new Recipe(R.drawable.cup_kalitawave, "Kalita Wave", "Gövdeli ve dengeli.", "1:16 oran", "240 ml", "Akış sabit olmalı.", "Orta öğütüm.", CAT_FILTER, "240 ml"));
        list.add(new Recipe(R.drawable.cup_frenchpress, "French Press", "Klasik pres demleme.", "1:12 oran, 4 dk", "300 ml", "Kalın öğütüm.", "Karıştır sonra presle.", CAT_FILTER, "300 ml"));
        list.add(new Recipe(R.drawable.cup_chemex, "Chemex", "Çok temiz tat.", "1:15 oran, 4 dk", "450 ml", "Kalın filtre.", "Yüksek ısıda.", CAT_FILTER, "450 ml"));
        list.add(new Recipe(R.drawable.cup_aeropress, "AeroPress", "Pratik, temiz, taşınabilir.", "1:12 oran", "200 ml", "Ters yöntem önerilir.", "Yavaş pres.", CAT_FILTER, "200 ml"));
        list.add(new Recipe(R.drawable.cup_colddrip, "Cold Drip", "Soğuk damla demleme.", "3–5 saatlik süreç.", "Soğuk", "Buzlu suyla.", "Düşük asidite.", CAT_FILTER, "Soğuk"));
        list.add(new Recipe(R.drawable.cup_syphonbrew, "Syphon Brew", "Gösterişli vakum demleme.", "1:15 oran", "300 ml", "Filtreyi ıslat.", "Dikkatli karıştır.", CAT_FILTER, "300 ml"));
        list.add(new Recipe(R.drawable.cup_percolator, "Percolator", "Ocakta demleme.", "Tekrar dolaşım sistemi.", "Kupa", "Orta öğütüm.", "Kaynamadan demle.", CAT_FILTER, "Kup"));
        list.add(new Recipe(R.drawable.cup_mokapot, "Moka Pot", "Yoğun kahve.", "Alt su, üst kahve", "2–4 cup", "Orta ince öğütüm.", "Kaynatmadan çıkar.", CAT_FILTER, "Kup"));

        // ---------- SPECIAL ----------
        list.add(new Recipe(R.drawable.cup_latte_300ml, "Latte", "Sütlü ve yumuşak.", "1 shot + süt", "300 ml", "Süt 65°C.", "Latte art yap.", CAT_SPECIAL, "300 ml"));
        list.add(new Recipe(R.drawable.cup_cappucino_240ml, "Cappuccino", "Köpüklü klasik.", "1 shot + süt + köpük", "240 ml", "Köpüğü yoğun yap.", "Üstüne kakao serpiştir.", CAT_SPECIAL, "240 ml"));
        list.add(new Recipe(R.drawable.cup_mochacino_300ml, "Mochaccino", "Kakao + süt + espresso.", "Kakao şurubu + süt + shot", "300 ml", "Tatlı dengeyi koru.", "Krema eklenebilir.", CAT_SPECIAL, "300 ml"));
        list.add(new Recipe(R.drawable.cup_breve_200ml, "Breve", "Half&Half ile latte.", "1 shot + half&half", "200 ml", "Kremamsı doku.", "Yoğun kıvam.", CAT_SPECIAL, "200 ml"));
        list.add(new Recipe(R.drawable.cup_affogato_150ml, "Affogato", "Dondurma üstü espresso.", "1 top + sıcak shot", "150 ml", "Sıcakken dök.", "Erimeden servis.", CAT_SPECIAL, "150 ml"));
        list.add(new Recipe(R.drawable.cup_affogato_freddo, "Affogato Freddo", "Soğuk affogato.", "Soğuk shot + dondurma", "150 ml", "Bardağı soğut.", "Fındık serpilebilir.", CAT_SPECIAL, "150 ml"));
        list.add(new Recipe(R.drawable.cup_pistachio_latte, "Pistachio Latte", "Fıstık aromalı latte.", "Fıstık şurubu + süt + shot", "300 ml", "Şurup az olsun.", "Üstüne toz fıstık.", CAT_SPECIAL, "300 ml"));
        list.add(new Recipe(R.drawable.cup_honey_latte, "Honey Latte", "Bal ile tatlandırılmış.", "Bal + süt + shot", "300 ml", "Balı sütte çöz.", "Tarçın yakışır.", CAT_SPECIAL, "300 ml"));
        list.add(new Recipe(R.drawable.cup_rose_latte, "Rose Latte", "Gül aromalı latte.", "Gül şurubu + süt + shot", "300 ml", "Şurup 15 ml.", "Üstüne kuru gül.", CAT_SPECIAL, "300 ml"));
        list.add(new Recipe(R.drawable.cup_caramel_brulee_latte, "Caramel Brûlée Latte", "Karamel brulee latte.", "Karamel + süt + shot", "300 ml", "Üstüne karamel kırığı.", "Süt 65°C.", CAT_SPECIAL, "300 ml"));
        list.add(new Recipe(R.drawable.cup_spanish_mocha, "Spanish Mocha", "Yoğun sütlü mocha.", "Kondanse süt + kakao + shot", "300 ml", "Yoğunluğu ayarla.", "Tatlılık dikkat.", CAT_SPECIAL, "300 ml"));

        // ---------- ALKOLLÜ ----------
        list.add(new Recipe(R.drawable.cup_espresso_martini, "Espresso Martini", "Votka + espresso + likör.", "Şeker + kahve likörü + shot", "Kokteyl", "İyi çalkala.", "Soğuk servis.", CAT_ALCOHOLIC, "Kokteyl"));
        list.add(new Recipe(R.drawable.cup_irish_coffee, "Irish Coffee", "Viski + kahve + krema.", "Sıcak kahve + viski + krema", "Kup", "Kremayı yavaş dök.", "Sıcak servis.", CAT_ALCOHOLIC, "Kup"));
        list.add(new Recipe(R.drawable.cup_baileys_latte, "Baileys Latte", "Baileys aromalı latte.", "Baileys + süt + shot", "300 ml", "Baileys 30 ml.", "Tatlı içim.", CAT_ALCOHOLIC, "300 ml"));
        list.add(new Recipe(R.drawable.cup_rum_mocha, "Rum Mocha", "Rom + çikolata + espresso.", "Rom + kakao + süt + shot", "300 ml", "Romu ölçülü kullan.", "Krema ekle.", CAT_ALCOHOLIC, "300 ml"));
        list.add(new Recipe(R.drawable.cup_amaretto_mocha, "Amaretto Mocha", "Badem likörlü mocha.", "Amaretto + süt + shot", "300 ml", "Amaretto 20 ml.", "Tatlı notalar.", CAT_ALCOHOLIC, "300 ml"));

        // ---------- ICED ----------
        list.add(new Recipe(R.drawable.cup_iced_americano, "Iced Americano", "Buz + su + shot.", "Shot + su + buz", "350 ml", "Shot soğusun.", "Suyu sonra ekle.", CAT_ICED, "350 ml"));
        list.add(new Recipe(R.drawable.cup_iced_latte, "Iced Latte", "Soğuk latte.", "Buz + süt + shot", "350 ml", "Tatlandırma opsiyonel.", "Bardağı soğut.", CAT_ICED, "350 ml"));
        list.add(new Recipe(R.drawable.cup_iced_mocha, "Iced Mocha", "Soğuk çikolatalı latte.", "Kakao + süt + shot + buz", "350 ml", "Şurubu çöz.", "Krema ekle.", CAT_ICED, "350 ml"));
        list.add(new Recipe(R.drawable.cup_iced_breve, "Iced Breve", "Soğuk half&half.", "Buz + half&half + shot", "350 ml", "Yoğun ve kremamsı.", "Tatlılık düşük.", CAT_ICED, "350 ml"));
        list.add(new Recipe(R.drawable.cup_icedpour, "Iced Pour", "Buz üzerine sıcak demleme.", "Demleme buz üstüne", "350 ml", "Demleme konsantre olmalı.", "Buz oranını iyi ayarla.", CAT_ICED, "350 ml"));

        // ---------- TÜRK KAHVESİ ----------
        list.add(new Recipe(R.drawable.cup_t_70ml, "Türk Kahvesi (Sade)", "Geleneksel, sade aroma.", "Soğuk su + ince öğütüm", "1 fincan", "Köpüğü taşırma.", "Şekersiz.", CAT_TURKISH, "T – 70 ml"));
        list.add(new Recipe(R.drawable.cup_t_70ml, "Türk Kahvesi (Orta)", "Hafif şekerli klasik.", "1 tatlı kaşığı şeker", "1 fincan", "Yavaş pişir.", "Köpüğü koru.", CAT_TURKISH, "T – 70 ml"));
        list.add(new Recipe(R.drawable.cup_t_70ml, "Türk Kahvesi (Şekerli)", "Tatlı içim.", "2 tatlı kaşığı şeker", "1 fincan", "Taşırmadan pişir.", "Köpüğü bol olsun.", CAT_TURKISH, "T – 70 ml"));
        list.add(new Recipe(R.drawable.cup_t_70ml, "Dibek Kahvesi", "Yumuşak, iri öğütüm.", "Sütle veya suyla hazırlanır.", "1 fincan", "Kaynatmadan ısıt.", "Köpüğü az olur.", CAT_TURKISH, "T – 70 ml"));
        list.add(new Recipe(R.drawable.cup_t_70ml, "Menengiç Kahvesi", "Kafeinsiz, fıstık aromalı.", "Menengiç tohumu + süt", "1 fincan", "Süt taşırma.", "Tatlımsı aroma.", CAT_TURKISH, "T – 70 ml"));

        return Collections.unmodifiableList(list);
    }

    public static List<Recipe> getAll() {
        return ALL;
    }
}