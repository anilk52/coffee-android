package com.example.coffee.data;

import android.text.TextUtils;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    public static final String CAT_ESPRESSO = "ESPRESSO";
    public static final String CAT_FILTRE   = "FILTRE";
    public static final String CAT_SPECIAL  = "SPECIAL";
    public static final String CAT_ALKOLLU  = "ALKOLLU";
    public static final String CAT_ICE      = "ICE";
    public static final String CAT_TURK     = "TURK";

    // Tüm liste
    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // Espresso
        list.add(new Recipe("Espresso","Tek shot, yoğun lezzet.", CAT_ESPRESSO,
                android.R.drawable.ic_menu_report_image, "S — 30 ml", "Taze öğüt, 25–30 sn."));
        list.add(new Recipe("Ristretto","Kısa ve konsantre.", CAT_ESPRESSO,
                android.R.drawable.ic_menu_report_image, "S — 20 ml", "Akışı erken kes."));
        list.add(new Recipe("Lungo","Uzun akış, daha hafif.", CAT_ESPRESSO,
                android.R.drawable.ic_menu_report_image, "S — 60 ml", "Öğütme biraz iri."));
        list.add(new Recipe("Doppio","Çift shot espresso.", CAT_ESPRESSO,
                android.R.drawable.ic_menu_report_image, "S — 60 ml", "Basket 18–20 g."));
        list.add(new Recipe("Macchiato","Espresso + az köpük.", CAT_ESPRESSO,
                android.R.drawable.ic_menu_report_image, "S — 100 ml", "Köpüğü minik dokunuş."));

        // Filtre
        list.add(new Recipe("Americano","Espresso + sıcak su.", CAT_FILTRE,
                android.R.drawable.ic_menu_report_image, "M — 240 ml", "Önce su, üstüne espresso."));
        list.add(new Recipe("Pour Over","V60 temiz bardak.", CAT_FILTRE,
                android.R.drawable.ic_menu_report_image, "M — 250 ml", "Dairesel yavaş döküş."));
        list.add(new Recipe("French Press","Tam gövde.", CAT_FILTRE,
                android.R.drawable.ic_menu_report_image, "M — 300 ml", "4 dk beklet, bastır."));
        list.add(new Recipe("Chemex","Berrak ve hafif.", CAT_FILTRE,
                android.R.drawable.ic_menu_report_image, "L — 300 ml", "Kalın filtre şart."));
        list.add(new Recipe("AeroPress","Yoğun/pürüzsüz.", CAT_FILTRE,
                android.R.drawable.ic_menu_report_image, "S — 200 ml", "Basıncı kontrollü ver."));

        // Special
        list.add(new Recipe("Latte","Espresso + bol süt.", CAT_SPECIAL,
                android.R.drawable.ic_menu_report_image, "L — 300 ml", "Latte art modu on."));
        list.add(new Recipe("Cappuccino","1:1:1 kuralı.", CAT_SPECIAL,
                android.R.drawable.ic_menu_report_image, "M — 240 ml", "Köpüğü kuru tut."));
        list.add(new Recipe("Flat White","Yoğun espresso + mikroköpük.", CAT_SPECIAL,
                android.R.drawable.ic_menu_report_image, "M — 220 ml", "Köpük: ipek gibi."));
        list.add(new Recipe("Mocha","Çikolata + süt + espresso.", CAT_SPECIAL,
                android.R.drawable.ic_menu_report_image, "L — 300 ml", "Kakao kalitesi önemli."));
        list.add(new Recipe("Cortado","1:1 espresso/süt.", CAT_SPECIAL,
                android.R.drawable.ic_menu_report_image, "S — 120 ml", "Tat dengesi kritik."));

        // Alkollü
        list.add(new Recipe("Irish Coffee","Viski + kahve + krema.", CAT_ALKOLLU,
                android.R.drawable.ic_menu_report_image, "Standart — 250 ml", "Viski önce, krema en son."));
        list.add(new Recipe("Espresso Martini","Votka + kahve likörü + espresso.", CAT_ALKOLLU,
                android.R.drawable.ic_menu_report_image, "Standart — 150 ml", "İyi shake, ince köpük."));
        list.add(new Recipe("Carajillo","Brandy + espresso.", CAT_ALKOLLU,
                android.R.drawable.ic_menu_report_image, "Standart — 120 ml", "Likörü yavaş ekle."));
        list.add(new Recipe("Kahlúa Latte","Likörlü latte.", CAT_ALKOLLU,
                android.R.drawable.ic_menu_report_image, "Standart — 240 ml", "Kahve baskın kalsın."));
        list.add(new Recipe("Baileys Coffee","Baileys + kahve.", CAT_ALKOLLU,
                android.R.drawable.ic_menu_report_image, "Standart — 240 ml", "Baileys’i ısıtma."));

        // Ice
        list.add(new Recipe("Iced Americano","Espresso + soğuk su + buz.", CAT_ICE,
                android.R.drawable.ic_menu_report_image, "L — 300 ml", "Buzu abartma, aroma kaçar."));
        list.add(new Recipe("Iced Latte","Espresso + süt + buz.", CAT_ICE,
                android.R.drawable.ic_menu_report_image, "L — 300 ml", "Soğuk süt kullan."));
        list.add(new Recipe("Cold Brew","12–18 saat.", CAT_ICE,
                android.R.drawable.ic_menu_report_image, "L — 300 ml", "Sabır kahvedir."));
        list.add(new Recipe("Affogato","Espresso + dondurma.", CAT_ICE,
                android.R.drawable.ic_menu_report_image, "S — 150 ml", "Vanilya şahanedir."));
        list.add(new Recipe("Frappe","Blender köpüklü.", CAT_ICE,
                android.R.drawable.ic_menu_report_image, "L — 350 ml", "Buz/süt dengesine dikkat."));

        // Türk kahveleri (+ şeker notu tarif altına yazıldı)
        list.add(new Recipe("Türk Kahvesi","Klasik cezve demleme.", CAT_TURK,
                android.R.drawable.ic_menu_report_image, "S — 70 ml",
                "Not (şeker): Sade 0, Az 1 çay k., Orta 2, Şekerli 3."));
        list.add(new Recipe("Menengiç Kahvesi","Kafeinsiz, aromatik.", CAT_TURK,
                android.R.drawable.ic_menu_report_image, "S — 70 ml",
                "Not (şeker): Genelde sade/az önerilir."));
        list.add(new Recipe("Dibek Kahvesi","Yumuşak içim.", CAT_TURK,
                android.R.drawable.ic_menu_report_image, "S — 80 ml",
                "Not (şeker): Sade/az/orta tercihe göre."));
        list.add(new Recipe("Osmanlı Kahvesi","Baharatlı karışım.", CAT_TURK,
                android.R.drawable.ic_menu_report_image, "S — 75 ml",
                "Not (şeker): Tarçın/kakule uyumlu."));
        list.add(new Recipe("Sütlü Türk Kahvesi","Süt eklenmiş versiyon.", CAT_TURK,
                android.R.drawable.ic_menu_report_image, "S — 100 ml",
                "Not (şeker): Şeker oranını düşür."));

        return list;
    }

    public static List<Recipe> forCategory(String category) {
        List<Recipe> result = new ArrayList<>();
        if (TextUtils.isEmpty(category)) return result;
        for (Recipe r : getAll()) {
            if (category.equals(r.getCategory())) result.add(r);
        }
        return result;
    }

    public static Recipe findByName(String name) {
        if (TextUtils.isEmpty(name)) return null;
        for (Recipe r : getAll()) {
            if (name.equals(r.getName())) return r;
        }
        return null;
    }
}