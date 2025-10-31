package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    // Kategori tanımları
    public static final String CAT_ESPRESSO = "Espresso";
    public static final String CAT_FILTER = "Filtre";
    public static final String CAT_SPECIAL = "Special";
    public static final String CAT_ALCOHOLIC = "Alkollü";
    public static final String CAT_ICED = "Soğuk";
    public static final String CAT_TURKISH = "Türk Kahvesi";

    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // ===== ESPRESSO BAZLI =====
        list.add(new Recipe("Espresso", "Tek shot, yoğun ve kısa içim.", CAT_ESPRESSO, R.drawable.cup_espresso_70ml, "70 ml fincan", "Shot yaklaşık 25 saniye akmalı."));
        list.add(new Recipe("Doppio", "Çift shot espresso, daha yoğun gövde.", CAT_ESPRESSO, R.drawable.cup_doppio_120ml, "120 ml fincan", "Kahve/su oranı 1:2 olmalı."));
        list.add(new Recipe("Ristretto", "Kısa akış, yoğun aroma.", CAT_ESPRESSO, R.drawable.cup_ristretto_50ml, "50 ml fincan", "Kısa ekstraksiyonla tat dengesi korunur."));
        list.add(new Recipe("Lungo", "Uzun akış, daha hafif gövde.", CAT_ESPRESSO, R.drawable.cup_lungo_150ml, "150 ml fincan", "Su oranı ristretto’nun 2 katı olmalı."));
        list.add(new Recipe("Macchiato", "Espresso üstüne az süt köpüğü.", CAT_ESPRESSO, R.drawable.cup_macchiato_120ml, "120 ml fincan", "Köpük fazla olmamalı, yüzeyi kaplasın."));
        list.add(new Recipe("Cortado", "Espresso + eşit miktar süt.", CAT_ESPRESSO, R.drawable.cup_cortado_150ml, "150 ml bardak", "Süt 60–65°C civarında olmalı."));
        list.add(new Recipe("Flat White", "İnce mikrofoam ile dengeli içim.", CAT_ESPRESSO, R.drawable.cup_flatwhite_240ml, "240 ml bardak", "Shot süresi 30 sn civarında olmalı."));
        list.add(new Recipe("Cappuccino", "1:1:1 oranında espresso, süt ve köpük.", CAT_ESPRESSO, R.drawable.cup_cappuccino_240ml, "240 ml kupa", "Köpüğü ince mikro yapıda olmalı."));
        list.add(new Recipe("Latte", "Espresso üstüne bol süt.", CAT_ESPRESSO, R.drawable.cup_latte_300ml, "300 ml bardak", "Köpük yüzeyde ince tabaka olmalı."));
        list.add(new Recipe("Piccolo Latte", "Küçük bardakta latte versiyonu.", CAT_ESPRESSO, R.drawable.cup_piccololatte_120ml, "120 ml bardak", "Yoğun espresso kullan."));
        list.add(new Recipe("Con Panna", "Espresso üstüne krem şanti.", CAT_ESPRESSO, R.drawable.cup_conpanna_100ml, "100 ml fincan", "Soğuk şanti kullanma, sıcak krema tercih et."));
        list.add(new Recipe("Romano", "Espresso + limon kabuğu.", CAT_ESPRESSO, R.drawable.cup_romano_70ml, "70 ml fincan", "Limon kabuğu espresso’yu dengelemek için."));
        list.add(new Recipe("Americano", "Espresso üzerine sıcak su.", CAT_ESPRESSO, R.drawable.cup_americano_350ml, "350 ml kupa", "Önce espresso, sonra sıcak su ekle."));
        list.add(new Recipe("Affogato", "Espresso + vanilyalı dondurma.", CAT_ESPRESSO, R.drawable.cup_affogato_150ml, "150 ml fincan", "Espressoyu dondurmanın üstüne dök."));

        // ===== FİLTRE =====
        list.add(new Recipe("V60 Pour Over", "Klasik filtre demleme.", CAT_FILTER, R.drawable.cup_v60, "300 ml kupa", "Su 92–94°C olmalı, 2:30 dakikada demle."));
        list.add(new Recipe("Chemex", "Kalın filtreyle temiz ve berrak tat.", CAT_FILTER, R.drawable.cup_chemex, "500 ml cam sürahi", "Orta kalın öğütme kullan."));
        list.add(new Recipe("French Press", "Klasik yoğun filtre kahvesi.", CAT_FILTER, R.drawable.cup_frenchpress, "350 ml kupa", "4 dakika beklet, sonra bastır."));
        list.add(new Recipe("Aeropress", "Basınçla kısa demleme.", CAT_FILTER, R.drawable.cup_aeropress, "250 ml kupa", "Ters demleme 2 dakikada en iyi sonuç."));
        list.add(new Recipe("Syphon Brew", "Vakum yöntemiyle demleme.", CAT_FILTER, R.drawable.cup_syphonbrew, "400 ml cam demleme kabı", "Su 90°C civarında olmalı."));
        list.add(new Recipe("Moka Pot", "Klasik İtalyan cezvesi.", CAT_FILTER, R.drawable.cup_mokapot, "200 ml kupa", "Orta öğütme, az sıkı bastır."));
        list.add(new Recipe("Percolator", "Kaynama devridaimiyle demleme.", CAT_FILTER, R.drawable.cup_percolator, "400 ml metal pot", "Kaynatma süresi 5 dk’yı geçmesin."));
        list.add(new Recipe("Kalita Wave", "Dengeli akış sağlayan özel filtre.", CAT_FILTER, R.drawable.cup_kalitawave, "300 ml kupa", "Sabit döküşle 2:30 dakikada demle."));
        list.add(new Recipe("Cold Drip", "Yavaş damıtma yöntemi.", CAT_FILTER, R.drawable.cup_colddrip, "500 ml soğuk şişe", "6-8 saatlik soğuk demleme."));

        // ===== SPECIAL =====
        list.add(new Recipe("Caramel Brûlée Latte", "Espresso, süt ve karamel soslu tatlı latte.", CAT_SPECIAL, R.drawable.cup_caramel_brulee_latte, "240 ml bardak", "Üzerine karamel sos gezdir."));
        list.add(new Recipe("Spanish Latte", "Yoğun süt ve şekerle dengelenmiş espresso.", CAT_SPECIAL, R.drawable.cup_spanish_mocha, "300 ml bardak", "Soğuk veya sıcak servis edilebilir."));
        list.add(new Recipe("Rose Latte", "Gül aromalı latte.", CAT_SPECIAL, R.drawable.cup_rose_latte, "240 ml bardak", "Üzerine gül yaprağı serpiştir."));
        list.add(new Recipe("Pistachio Latte", "Fıstık aromalı latte.", CAT_SPECIAL, R.drawable.cup_pistachio_latte, "240 ml bardak", "Antep fıstığı tozu ile süslenir."));
        list.add(new Recipe("Spanish Mocha", "Çikolatalı süt + espresso karışımı.", CAT_SPECIAL, R.drawable.cup_spanish_mocha, "300 ml bardak", "Çikolata sosla fincan kenarını kapla."));

        // ===== ALKOLLÜ =====
        list.add(new Recipe("Irish Coffee", "Kahve + viski + krema.", CAT_ALCOHOLIC, R.drawable.cup_irish_coffee, "240 ml cam bardak", "Krema üstte kalacak şekilde dök."));
        list.add(new Recipe("Baileys Latte", "Baileys likörlü latte.", CAT_ALCOHOLIC, R.drawable.cup_baileys_latte, "240 ml bardak", "Baileys’i sütle karıştır, espresso ekle."));
        list.add(new Recipe("Amaretto Mocha", "Badem likörlü mocha.", CAT_ALCOHOLIC, R.drawable.cup_amaretto_mocha, "300 ml bardak", "Üzerine çikolata tozu serpiştir."));
        list.add(new Recipe("Rum Mocha", "Rom aromalı mocha.", CAT_ALCOHOLIC, R.drawable.cup_rum_mocha, "300 ml bardak", "Romu son aşamada ekle."));
        list.add(new Recipe("Espresso Martini", "Vodka + kahve likörü + espresso.", CAT_ALCOHOLIC, R.drawable.cup_espresso_martini, "150 ml kadeh", "Buzla çalkala, köpüklü dök."));

        // ===== SOĞUK =====
        list.add(new Recipe("Iced Americano", "Espresso + soğuk su + buz.", CAT_ICED, R.drawable.cup_iced_americano, "350 ml bardak", "Espressoyu buz üstüne dök."));
        list.add(new Recipe("Iced Latte", "Soğuk süt + espresso + buz.", CAT_ICED, R.drawable.cup_iced_latte, "350 ml bardak", "Espressoyu sütle karıştır, buz ekle."));
        list.add(new Recipe("Iced Mocha", "Soğuk çikolatalı latte.", CAT_ICED, R.drawable.cup_iced_mocha, "350 ml bardak", "Çikolata sosu bardağa çizgi yaparak dök."));
        list.add(new Recipe("Affogato Freddo", "Soğuk espresso + dondurma.", CAT_ICED, R.drawable.cup_affogato_freddo, "200 ml bardak", "Dondurma üstüne espresso ekle."));
        list.add(new Recipe("Iced Pour Over", "Buz üstüne V60 dökümü.", CAT_ICED, R.drawable.cup_icedpour, "350 ml bardak", "Sıcak suyu buz üstüne dök."));

        // ===== TÜRK KAHVESİ =====
        list.add(new Recipe("Türk Kahvesi", "Klasik cezvede pişirilmiş.", CAT_TURKISH, R.drawable.cup_t_70ml, "70 ml fincan", "Köpüğü bol olacak şekilde pişir."));
        list.add(new Recipe("Menengiç Kahvesi", "Kafeinsiz, aromatik içim.", CAT_TURKISH, R.drawable.cup_t_70ml, "70 ml fincan", "Sütle pişir, hafif kaynat."));
        list.add(new Recipe("Dibek Kahvesi", "Yumuşak içimli özel karışım.", CAT_TURKISH, R.drawable.cup_t_70ml, "70 ml fincan", "Kısık ateşte karıştırmadan pişir."));
        list.add(new Recipe("Osmanlı Kahvesi", "Baharatlı karışım.", CAT_TURKISH, R.drawable.cup_t_70ml, "70 ml fincan", "Üzerine tarçın serpiştir."));
        list.add(new Recipe("Sütlü Türk Kahvesi", "Klasik tarifin sütlü versiyonu.", CAT_TURKISH, R.drawable.cup_t_70ml, "70 ml fincan", "Sütle pişir, hafif köpüklü bırak."));

        return list;
    }
}