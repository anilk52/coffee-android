package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecipesData {

    public static final String CAT_ESPRESSO = "ESPRESSO";
    public static final String CAT_FILTRE   = "FİLTRE";
    public static final String CAT_SPECIAL  = "SPECIAL";
    public static final String CAT_ALKOLLU  = "ALKOLLÜ";
    public static final String CAT_ICE      = "ICE";

    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // ESPRESSO
        list.add(new Recipe("Espresso","Tek shot, yoğun lezzet.",CAT_ESPRESSO, R.drawable.ic_launcher_foreground,"S — 30 ml (Demitasse)","25 sn, 18 g, 9 bar; tek yudumda karakter!"));
        list.add(new Recipe("Ristretto","Daha kısa ve konsantre.",CAT_ESPRESSO, R.drawable.ic_launcher_foreground,"S — 20 ml (Demitasse)","Kısa akış: aroma zirvede!"));
        list.add(new Recipe("Lungo","Uzun akış, yumuşak gövde.",CAT_ESPRESSO, R.drawable.ic_launcher_foreground,"S — 60 ml (Short)","Aşırı ince öğütmeyle acılığı tetikleme."));
        list.add(new Recipe("Doppio","Çift shot enerji.",CAT_ESPRESSO, R.drawable.ic_launcher_foreground,"S — 60 ml (Short)","İki shot, tek ruh — gün senin!"));
        list.add(new Recipe("Macchiato","Üstüne az köpük dokunuşu.",CAT_ESPRESSO, R.drawable.ic_launcher_foreground,"S — 100 ml (Short)","Az süt, çok kahve: dengeyi bozma."));

        // FİLTRE
        list.add(new Recipe("Americano","Espresso + sıcak su.",CAT_FILTRE, R.drawable.ic_launcher_foreground,"M — 240 ml (Regular)","Önce su, sonra espresso ekle; tadı dengeler."));
        list.add(new Recipe("Pour Over","V60 ile temiz fincan.",CAT_FILTRE, R.drawable.ic_launcher_foreground,"M — 250 ml (Regular)","Dairesel döküş, stabil akış."));
        list.add(new Recipe("French Press","Yoğun, tam gövdeli.",CAT_FILTRE, R.drawable.ic_launcher_foreground,"L — 300 ml (Tall)","4 dk bekle; bastıktan sonra hemen servis."));
        list.add(new Recipe("Chemex","Kristal berraklık.",CAT_FILTRE, R.drawable.ic_launcher_foreground,"L — 300 ml (Tall)","Kalın filtreyle pürüzsüz tat."));
        list.add(new Recipe("AeroPress","Hızlı ve pratik.",CAT_FILTRE, R.drawable.ic_launcher_foreground,"M — 220 ml (Regular)","Ters yöntemle daha gövdeli fincan."));

        // SPECIAL
        list.add(new Recipe("Latte","Yumuşak sütlü kahve.",CAT_SPECIAL, R.drawable.ic_launcher_foreground,"L — 300 ml (Tall)","Köpüğü fazla şişirme; mikroköpük hedef."));
        list.add(new Recipe("Cappuccino","Köpük baskın denge.",CAT_SPECIAL, R.drawable.ic_launcher_foreground,"M — 240 ml (Regular)","1/3 espresso, 1/3 süt, 1/3 köpük."));
        list.add(new Recipe("Flat White","Espresso odaklı sütlü.",CAT_SPECIAL, R.drawable.ic_launcher_foreground,"M — 220 ml (Regular)","Küçük bardakta yoğun tat."));
        list.add(new Recipe("Mocha","Çikolatalı latte.",CAT_SPECIAL, R.drawable.ic_launcher_foreground,"L — 300 ml (Tall)","Çikolatayı önce sütle çöz."));
        list.add(new Recipe("Cortado","1:1 espresso-süt.",CAT_SPECIAL, R.drawable.ic_launcher_foreground,"S — 120 ml (Short)","Asiditeyi sütle sakinleştir."));

        // ALKOLLÜ
        list.add(new Recipe("Irish Coffee","Viski + kahve + krema.",CAT_ALKOLLU, R.drawable.ic_launcher_foreground,"M — 250 ml (Regular)","Viski önce; krema en son."));
        list.add(new Recipe("Espresso Martini","Şık kokteyl.",CAT_ALKOLLU, R.drawable.ic_launcher_foreground,"S — 150 ml (Short)","İyi shake; üstte ince köpük."));
        list.add(new Recipe("Carajillo","Brandy + espresso.",CAT_ALKOLLU, R.drawable.ic_launcher_foreground,"S — 120 ml (Short)","Likörü az az ekle."));
        list.add(new Recipe("Kahlúa Latte","Likörlü latte.",CAT_ALKOLLU, R.drawable.ic_launcher_foreground,"M — 240 ml (Regular)","Kahve başrolde kalsın."));
        list.add(new Recipe("Baileys Coffee","Baileys + kahve.",CAT_ALKOLLU, R.drawable.ic_launcher_foreground,"M — 240 ml (Regular)","Baileys’i ısıtma; aroma kalsın."));

        // ICE
        list.add(new Recipe("Iced Americano","Soğuk su + buz.",CAT_ICE, R.drawable.ic_launcher_foreground,"L — 300 ml (Tall)","Önce su, sonra buz: sulanmayı kontrol et."));
        list.add(new Recipe("Iced Latte","Süt + buz + espresso.",CAT_ICE, R.drawable.ic_launcher_foreground,"L — 300 ml (Tall)","Buzu bol koy; yazı uzat."));
        list.add(new Recipe("Cold Brew","Uzun soğuk demleme.",CAT_ICE, R.drawable.ic_launcher_foreground,"L — 300 ml (Tall)","12–18 saat sabır."));
        list.add(new Recipe("Affogato","Espresso + dondurma.",CAT_ICE, R.drawable.ic_launcher_foreground,"S — 150 ml (Short)","Sıcak-soğuk kontrast keyfi."));
        list.add(new Recipe("Frappe","Kremsi buzlu keyif.",CAT_ICE, R.drawable.ic_launcher_foreground,"XL — 350 ml (Grande)","Buzu ezmeden köpürt."));

        return list;
    }

    public static Recipe findByName(String name) {
        if (name == null || name.trim().isEmpty()) return null;
        for (Recipe r : getAll()) {
            if (r.getName().equalsIgnoreCase(name.trim())) return r;
        }
        return null;
    }

    public static List<String> allTitles() {
        List<String> out = new ArrayList<>();
        for (Recipe r : getAll()) out.add(r.getName());
        return out;
    }

    public static List<String> titlesForCategory(String category) {
        if (category == null || category.trim().isEmpty()) return Collections.emptyList();
        String key = category.trim();
        List<String> out = new ArrayList<>();
        for (Recipe r : getAll()) {
            if (r.getCategory() != null && r.getCategory().equalsIgnoreCase(key)) {
                out.add(r.getName());
            }
        }
        return out;
    }
}
