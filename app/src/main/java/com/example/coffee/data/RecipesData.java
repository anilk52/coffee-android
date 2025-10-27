package com.example.coffee.data;

import com.example.coffee.R;
import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    // 🔹 Kategori sabitleri
    public static final String CAT_ESPRESSO = "Espresso";
    public static final String CAT_FILTRE = "Filtre";
    public static final String CAT_SPECIAL = "Special";
    public static final String CAT_ALKOLLU = "Alkollü";
    public static final String CAT_ICE = "Ice";
    public static final String CAT_TURK = "Türk Kahvesi";

    // 🔹 Tüm kahveler burada oluşturuluyor
    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // ☕ Espresso bazlılar
        list.add(new Recipe("Espresso", "Tek shot, yoğun lezzet.", CAT_ESPRESSO, R.drawable.ic_launcher_foreground, "S — 30 ml", "Taze öğütülmüş kahve kullan."));
        list.add(new Recipe("Ristretto", "Kısa akışlı, daha konsantre shot.", CAT_ESPRESSO, R.drawable.ic_launcher_foreground, "S — 20 ml", "Kısa sürede yoğun aroma."));
        list.add(new Recipe("Lungo", "Daha uzun akışlı espresso.", CAT_ESPRESSO, R.drawable.ic_launcher_foreground, "S — 60 ml", "Su eklenir, tat daha yumuşar."));
        list.add(new Recipe("Doppio", "Çift shot espresso.", CAT_ESPRESSO, R.drawable.ic_launcher_foreground, "S — 60 ml", "İki shot için çift miktar kahve."));
        list.add(new Recipe("Macchiato", "Espresso + az süt köpüğü.", CAT_ESPRESSO, R.drawable.ic_launcher_foreground, "S — 100 ml", "Köpükle leke bırakmak esas."));

        // ☕ Filtre kahveler
        list.add(new Recipe("Americano", "Espresso + sıcak su.", CAT_FILTRE, R.drawable.ic_launcher_foreground, "M — 240 ml", "Su oranını kişiye göre ayarla."));
        list.add(new Recipe("Pour Over", "V60 yöntemiyle temiz tat.", CAT_FILTRE, R.drawable.ic_launcher_foreground, "M — 250 ml", "Dairesel döküş, sabır ister."));
        list.add(new Recipe("French Press", "Klasik yoğun filtre.", CAT_FILTRE, R.drawable.ic_launcher_foreground, "M — 300 ml", "4 dk demleme ideal."));
        list.add(new Recipe("Chemex", "Hafif gövdeli, berrak kahve.", CAT_FILTRE, R.drawable.ic_launcher_foreground, "L — 300 ml", "Kalın filtre kullan."));
        list.add(new Recipe("AeroPress", "Yoğun ama pürüzsüz tat.", CAT_FILTRE, R.drawable.ic_launcher_foreground, "S — 200 ml", "Basınç kontrollü demleme."));

        // ☕ Özel kahveler
        list.add(new Recipe("Latte", "Espresso + bol süt.", CAT_SPECIAL, R.drawable.ic_launcher_foreground, "L — 300 ml", "Latte art için ideal."));
        list.add(new Recipe("Cappuccino", "Espresso + süt köpüğü.", CAT_SPECIAL, R.drawable.ic_launcher_foreground, "M — 240 ml", "1:1:1 oran kuralı: espresso-süt-köpük."));
        list.add(new Recipe("Flat White", "Yoğun espresso + ince köpük.", CAT_SPECIAL, R.drawable.ic_launcher_foreground, "M — 220 ml", "Köpüğü mikroköpük olmalı."));
        list.add(new Recipe("Mocha", "Espresso + çikolata + süt.", CAT_SPECIAL, R.drawable.ic_launcher_foreground, "L — 300 ml", "Kakao kalitesi fark yaratır."));
        list.add(new Recipe("Cortado", "1:1 espresso ve süt.", CAT_SPECIAL, R.drawable.ic_launcher_foreground, "S — 120 ml", "Tat dengesine dikkat et."));

        // ☕ Alkollü kahveler
        list.add(new Recipe("Irish Coffee", "Viski + kahve + krema.", CAT_ALKOLLU, R.drawable.ic_launcher_foreground, "M — 250 ml", "Viski önce, krema en son."));
        list.add(new Recipe("Espresso Martini", "Votka + kahve likörü + espresso.", CAT_ALKOLLU, R.drawable.ic_launcher_foreground, "S — 150 ml", "İyi shake; üstte ince köpük."));
        list.add(new Recipe("Carajillo", "Brandy + espresso.", CAT_ALKOLLU, R.drawable.ic_launcher_foreground, "S — 120 ml", "Likörü yavaş yavaş ekle."));
        list.add(new Recipe("Kahlúa Latte", "Kahve likörü + süt.", CAT_ALKOLLU, R.drawable.ic_launcher_foreground, "M — 240 ml", "Kahve başrolde kalsın."));
        list.add(new Recipe("Baileys Coffee", "Baileys + kahve.", CAT_ALKOLLU, R.drawable.ic_launcher_foreground, "M — 240 ml", "Baileys’i ısıtma; aroma kalsın."));

        // ❄️ Soğuk kahveler
        list.add(new Recipe("Iced Americano", "Espresso + soğuk su + buz.", CAT_ICE, R.drawable.ic_launcher_foreground, "L — 300 ml", "Buzu çok ekleme, aroma gider."));
        list.add(new Recipe("Iced Latte", "Espresso + süt + buz.", CAT_ICE, R.drawable.ic_launcher_foreground, "L — 300 ml", "Soğuk süt kullan."));
        list.add(new Recipe("Cold Brew", "12–18 saat demleme.", CAT_ICE, R.drawable.ic_launcher_foreground, "L — 300 ml", "Sabırla demle."));
        list.add(new Recipe("Affogato", "Espresso + dondurma.", CAT_ICE, R.drawable.ic_launcher_foreground, "S — 150 ml", "Vanilyalı dondurma ideal."));
        list.add(new Recipe("Frappe", "Blender köpüklü soğuk kahve.", CAT_ICE, R.drawable.ic_launcher_foreground, "L — 350 ml", "Buz oranını dengede tut."));

        // ☕ Türk kahveleri
        list.add(new Recipe("Türk Kahvesi", "Klasik cezve demleme.", CAT_TURK, R.drawable.ic_launcher_foreground, "S — 70 ml", "Soğuk su, ince öğütülmüş kahve.\nNot: Sade: 0 şeker, Az: 1 çay kaşığı, Orta: 2, Şekerli: 3."));
        list.add(new Recipe("Menengiç Kahvesi", "Kafeinsiz, aromatik tat.", CAT_TURK, R.drawable.ic_launcher_foreground, "S — 70 ml", "Kısık ateşte pişir.\nNot: Sade veya az şekerli önerilir."));
        list.add(new Recipe("Dibek Kahvesi", "Öğütülmesi farklı, yumuşak içim.", CAT_TURK, R.drawable.ic_launcher_foreground, "S — 80 ml", "Yoğun köpükte servis et."));
        list.add(new Recipe("Osmanlı Kahvesi", "Baharatlı karışım.", CAT_TURK, R.drawable.ic_launcher_foreground, "S — 75 ml", "Tarçın ve kakule fark yaratır."));
        list.add(new Recipe("Sütlü Türk Kahvesi", "Klasik tarife süt eklenmiş versiyon.", CAT_TURK, R.drawable.ic_launcher_foreground, "S — 100 ml", "Sütü kaynatmadan ekle."));

        return list;
    }

    // 🔸 Kategoriye göre filtreleme
    public static List<Recipe> forCategory(String category) {
        List<Recipe> all = getAll();
        List<Recipe> result = new ArrayList<>();

        if (category == null || category.trim().isEmpty())
            return all;

        for (Recipe r : all) {
            if (r.getCategory().equalsIgnoreCase(category)) {
                result.add(r);
            }
        }
        return result;
    }

    // 🔸 İsme göre kahve bulma
    public static Recipe findByName(String name) {
        if (name == null) return null;
        for (Recipe r : getAll()) {
            if (r.getTitle().equalsIgnoreCase(name.trim())) {
                return r;
            }
        }
        return null;
    }
}