package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    // ----------- KATEGORİ SABİTLERİ -----------
    public static final String CAT_ESPRESSO = "Espresso Bazlılar";
    public static final String CAT_FILTRE   = "Filtre Kahveler";
    public static final String CAT_SPECIAL  = "Special";
    public static final String CAT_ALKOLLU  = "Alkollü Kahveler";
    public static final String CAT_ICE      = "Soğuk Kahveler";
    public static final String CAT_TURK     = "Türk Kahvesi";

    // ----------- TÜM TARİFLER -----------
    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // ---------- ESPRESSO ----------
        list.add(new Recipe("Espresso", "Tek shot, yoğun lezzet.", CAT_ESPRESSO, R.drawable.ic_launcher_foreground, "S — 30 ml", "Kısa sürede alın, aroması hızla kaybolur."));
        list.add(new Recipe("Ristretto", "Kısa ve daha yoğun.", CAT_ESPRESSO, R.drawable.ic_launcher_foreground, "S — 20 ml", "Daha az su, daha güçlü aroma."));
        list.add(new Recipe("Lungo", "Uzun akış, daha hafif.", CAT_ESPRESSO, R.drawable.ic_launcher_foreground, "S — 60 ml", "Çekim süresini biraz uzat."));
        list.add(new Recipe("Doppio", "Çift shot espresso.", CAT_ESPRESSO, R.drawable.ic_launcher_foreground, "M — 60 ml", "Makine basıncını dengeli tut."));
        list.add(new Recipe("Macchiato", "Espresso üstüne az süt köpüğü.", CAT_ESPRESSO, R.drawable.ic_launcher_foreground, "S — 100 ml", "Köpüğü kaşıkla ekle, karıştırma."));

        // ---------- FİLTRE ----------
        list.add(new Recipe("Americano", "Espresso + sıcak su.", CAT_FILTRE, R.drawable.ic_launcher_foreground, "L — 240 ml", "Su oranını kişisel zevkine göre ayarla."));
        list.add(new Recipe("Pour Over", "V60 demleme.", CAT_FILTRE, R.drawable.ic_launcher_foreground, "M — 250 ml", "Su ısı: 92–94°C, 3 dk demleme."));
        list.add(new Recipe("French Press", "Klasik tam gövde kahve.", CAT_FILTRE, R.drawable.ic_launcher_foreground, "M — 300 ml", "4 dk beklet, süzmeden önce karıştır."));
        list.add(new Recipe("Chemex", "Temiz ve berrak gövde.", CAT_FILTRE, R.drawable.ic_launcher_foreground, "L — 300 ml", "Kâğıt filtreden önce ıslatma yap."));
        list.add(new Recipe("AeroPress", "Yoğun ama pürüzsüz.", CAT_FILTRE, R.drawable.ic_launcher_foreground, "S — 200 ml", "Basınçla 30 sn’de sıkıştır."));

        // ---------- SPECIAL ----------
        list.add(new Recipe("Latte", "Espresso + bol süt.", CAT_SPECIAL, R.drawable.ic_launcher_foreground, "L — 300 ml", "Süt köpüğünü fincan kenarına kadar dök."));
        list.add(new Recipe("Cappuccino", "Süt köpüğü baskın.", CAT_SPECIAL, R.drawable.ic_launcher_foreground, "M — 240 ml", "Espresso, süt, köpük oranı 1:1:1."));
        list.add(new Recipe("Flat White", "Mikroköpük ile dengeli.", CAT_SPECIAL, R.drawable.ic_launcher_foreground, "M — 220 ml", "Köpüğü çok ince tut."));
        list.add(new Recipe("Mocha", "Çikolata + süt + espresso.", CAT_SPECIAL, R.drawable.ic_launcher_foreground, "L — 300 ml", "Kakao oranını %20 civarında tut."));
        list.add(new Recipe("Cortado", "Espresso:süt = 1:1.", CAT_SPECIAL, R.drawable.ic_launcher_foreground, "S — 120 ml", "Köpüğü karıştırmadan dök."));

        // ---------- ALKOLLÜ ----------
        list.add(new Recipe("Irish Coffee", "Viski + kahve + krema.", CAT_ALKOLLU, R.drawable.ic_launcher_foreground, "M — 250 ml", "Viski önce, krema en son."));
        list.add(new Recipe("Espresso Martini", "Votka + kahve likörü + espresso.", CAT_ALKOLLU, R.drawable.ic_launcher_foreground, "S — 150 ml", "İyi shake; üstte ince köpük."));
        list.add(new Recipe("Carajillo", "Brandy + espresso.", CAT_ALKOLLU, R.drawable.ic_launcher_foreground, "S — 120 ml", "Likörü az az ekle."));
        list.add(new Recipe("Kahlúa Latte", "Kahve likörü + süt.", CAT_ALKOLLU, R.drawable.ic_launcher_foreground, "M — 240 ml", "Kahve başrolde kalsın."));
        list.add(new Recipe("Baileys Coffee", "Baileys + kahve.", CAT_ALKOLLU, R.drawable.ic_launcher_foreground, "M — 240 ml", "Baileys’i ısıtma; aroma kalsın."));

        // ---------- SOĞUK ----------
        list.add(new Recipe("Iced Americano", "Espresso + soğuk su + buz.", CAT_ICE, R.drawable.ic_launcher_foreground, "L — 300 ml", "Buzu sonradan ekle."));
        list.add(new Recipe("Iced Latte", "Espresso + süt + buz.", CAT_ICE, R.drawable.ic_launcher_foreground, "L — 300 ml", "Sütü önce koy."));
        list.add(new Recipe("Cold Brew", "12–18 saat demleme.", CAT_ICE, R.drawable.ic_launcher_foreground, "L — 300 ml", "Kahveyi iri çek."));
        list.add(new Recipe("Affogato", "Espresso + dondurma.", CAT_ICE, R.drawable.ic_launcher_foreground, "S — 150 ml", "Kahveyi dondurmanın üstüne dök."));
        list.add(new Recipe("Frappe", "Köpüklü buzlu kahve.", CAT_ICE, R.drawable.ic_launcher_foreground, "L — 350 ml", "Blender ile 20 sn karıştır."));

        // ---------- TÜRK KAHVESİ ----------
        list.add(new Recipe("Türk Kahvesi", "Klasik cezvede hazırlanır, su ve kahve karıştırılır.", CAT_TURK, R.drawable.ic_launcher_foreground, "S — 70 ml", "Not: Sade (şeker yok) • Az şekerli (½ küp) • Orta (1 küp) • Şekerli (2 küp)"));
        list.add(new Recipe("Menengiç Kahvesi", "Menengiç tohumundan, kafeinsiz yumuşak içim.", CAT_TURK, R.drawable.ic_launcher_foreground, "S — 70 ml", "Not: Yağlı yapısı için düşük ısıda pişir."));
        list.add(new Recipe("Dibek Kahvesi", "İri çekilmiş, yoğun ve aromatik.", CAT_TURK, R.drawable.ic_launcher_foreground, "S — 80 ml", "Not: Kremsi kıvam için süt ekle."));
        list.add(new Recipe("Sütlü Türk Kahvesi", "Suyla değil sütle yapılır.", CAT_TURK, R.drawable.ic_launcher_foreground, "S — 90 ml", "Not: Süt kaynamadan kahveyi ekle."));
        list.add(new Recipe("Damla Sakızlı Kahve", "Damla sakızı ile aromatik lezzet.", CAT_TURK, R.drawable.ic_launcher_foreground, "S — 70 ml", "Not: Sakız miktarı bıçak ucu kadar olsun."));

        return list;
    }
}

// --- Filtreleme: kategoriye göre liste döndür ---
    public static List<Recipe> forCategory(String category) {
        List<Recipe> all = getAll();
        if (category == null || category.trim().isEmpty()
                || category.equalsIgnoreCase("ALL")
                || category.equalsIgnoreCase("Tarifler")) {
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

    // --- İsme göre tek tarif döndür ---
    public static Recipe findByName(String name) {
        if (name == null || name.trim().isEmpty()) return null;
        for (Recipe r : getAll()) {
            if (r.getName() != null && r.getName().equalsIgnoreCase(name.trim())) {
                return r;
            }
        }
        return null;
    }