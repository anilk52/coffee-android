// app/src/main/java/com/example/coffee/data/RecipesData.java
package com.example.coffee.data;

import com.example.coffee.model.Recipe;
import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    public static List<Recipe> getRecipes(String category) {
        switch (category) {
            case "ESPRESSO": return espressoBased();
            case "FILTER":   return filterCoffees();
            case "ALCOHOL":  return alcoholicCoffees();
            default:         return new ArrayList<>();
        }
    }

    // 1) Espresso bazlılar
    private static List<Recipe> espressoBased() {
        List<Recipe> list = new ArrayList<>();

        list.add(new Recipe(
                "Espresso",
                "- 18–20 g ince öğütülmüş kahve\n- ~90°C su\n- 9 bar basınç",
                "1) Portafiltreye 18–20 g kahve dozla ve sıkıca tamp et.\n" +
                "2) 90–96°C suyla 9 bar basınçta shot al.\n" +
                "3) 25–30 sn’de ~30–40 ml çıkış hedefle.",
                "TDS ve sürede sapma varsa öğütümü ayarla."
        ));

        list.add(new Recipe(
                "Cappuccino",
                "- 1 espresso (30 ml)\n- 120 ml soğuk süt",
                "1) 1 shot espresso al.\n" +
                "2) Sütü 60–65°C’ye kadar mikroköpükle buharla.\n" +
                "3) Önce süt, sonra köpükle 150–180 ml fincanı doldur.",
                "İnce, parlak mikroköpük için buhar çubuğunu yüzeyin hemen altında tut."
        ));

        list.add(new Recipe(
                "Latte",
                "- 1 espresso (30 ml)\n- 200–220 ml süt",
                "1) Espresso çek.\n" +
                "2) Sütü 55–60°C, minimal köpükle ısıt.\n" +
                "3) Espresso üzerine dök; istersen latte art.",
                "Latte’de köpük cappuccino’ya göre daha incedir."
        ));

        list.add(new Recipe(
                "Flat White",
                "- 1 çift espresso (ristretto tercih)\n- 130–150 ml süt",
                "1) 2 shot bazlı espresso hazırla.\n" +
                "2) Sütü 55–60°C’de, çok ince mikroköpükle buharla.\n" +
                "3) Küçük fincana dök, kahve tadı belirgin kalsın.",
                "Daha güçlü kahve için ristretto double kullan."
        ));

        list.add(new Recipe(
                "Macchiato",
                "- 1 espresso\n- 1–2 tatlı kaşığı süt köpüğü",
                "1) Espresso hazırla.\n" +
                "2) Üzerine az miktarda süt köpüğü koy.\n" +
                "3) Hızlı servis et.",
                "Süt köpüğü fazla olursa latte macchiato’ya yaklaşır."
        ));

        return list;
    }

    // 2) Filtre kahveler
    private static List<Recipe> filterCoffees() {
        List<Recipe> list = new ArrayList<>();

        list.add(new Recipe(
                "V60 Pour-Over",
                "- 15 g orta-ince öğütüm\n- 250 g ~92°C su\n- Kağıt filtre",
                "1) Filtreyi durula, 15 g kahveyi ekle.\n" +
                "2) 40 g suyla 30 sn blooming.\n" +
                "3) 2–3 döküyle 250 g’a tamamla (toplam 2:30–3:00).",
                "Daha tatlı fincan için biraz daha ince öğüt, toplam süreyi 2:30’a yaklaştır."
        ));

        list.add(new Recipe(
                "French Press",
                "- 30 g orta-kalın öğütüm\n- 500 g 94°C su",
                "1) Kahveyi ekle, üstüne suyu dök ve karıştır.\n" +
                "2) 4 dk demle, yüzeyi kır ve köpüğü al.\n" +
                "3) Pistonu yavaşça bastır ve hemen servis et.",
                "Acılık olmaması için 4–5 dk’dan fazla bekletme."
        ));

        list.add(new Recipe(
                "AeroPress",
                "- 15 g orta öğütüm\n- 220 g 85–90°C su\n- Ters (inverted) yöntem önerilir",
                "1) Bloom: 30 g su, 30 sn.\n" +
                "2) Kalan suyu ekle, 1:30’a kadar bekle.\n" +
                "3) Çevir, 20–30 sn’de presle.",
                "Daha gövdeli fincan için daha ince öğüt ve sıcaklığı +1–2°C yap."
        ));

        list.add(new Recipe(
                "Chemex",
                "- 30 g orta-ince öğütüm\n- 500 g 92°C su",
                "1) Filtreyi iyice ıslat.\n" +
                "2) 60 g suyla 30 sn bloom.\n" +
                "3) Sarmal döküşle 500 g’a 3:30–4:00’da ulaş.",
                "Chemex filtresi daha kalın olduğundan öğütümü V60’tan biraz daha ince tut."
        ));

        list.add(new Recipe(
                "Cold Brew",
                "- 80 g kalın öğütüm\n- 1 L soğuk su",
                "1) Kavanoza kahve ve suyu koy, karıştır.\n" +
                "2) Buzdolabında 12–18 saat beklet.\n" +
                "3) İnce filtreyle süz ve servis et.",
                "Yoğunluk için 1:10 oran deneyebilir, serviste su/ sütle açabilirsin."
        ));

        return list;
    }

    // 3) Alkollü kahveler
    private static List<Recipe> alcoholicCoffees() {
        List<Recipe> list = new ArrayList<>();

        list.add(new Recipe(
                "Irish Coffee",
                "- 120 ml sıcak filtre kahve\n- 40 ml İrlanda viskisi\n- 2 çay kaşığı şeker\n- Krema",
                "1) Isıtılmış bardağa şeker ve viskiyi koy, karıştır.\n" +
                "2) Üzerine kahveyi ekle.\n" +
                "3) Hafif çırpılmış kremayı kaşık üstünden yüzeye bırak.",
                "Kremayı karıştırmadan içilir; sıcaklık dengesi önemli."
        ));

        list.add(new Recipe(
                "Espresso Martini",
                "- 30 ml taze espresso (soğutulmuş)\n- 45 ml votka\n- 30 ml kahve likörü\n- Buz",
                "1) Shaker’a tüm malzemeleri ve buzu ekle.\n" +
                "2) İyice çalkala ve kupe bardağa süz.\n" +
                "3) Üç kahve çekirdeğiyle süsle.",
                "Espressoyu çok sıcak koyma; sulanmayı artırır."
        ));

        list.add(new Recipe(
                "Carajillo (Meksika/İspanya)",
                "- 1 espresso\n- 30–45 ml Licor 43 veya brandy",
                "1) Bardağa likörü koy.\n" +
                "2) Üzerine sıcak espresso ekle ve karıştır.",
                "Buzlu servis edilen “Carajillo 43” varyantı da popülerdir."
        ));

        list.add(new Recipe(
                "Caffè Corretto",
                "- 1 espresso\n- 10–20 ml grappa (veya anasonlu likör)",
                "1) Espressoyu hazırla.\n" +
                "2) Grappa ile ‘düzelterek’ servis et.",
                "İtalyan barlarda kısa ve sıcak içilir."
        ));

        list.add(new Recipe(
                "Spanish Coffee (bar versiyonu)",
                "- 120 ml sıcak kahve\n- 30 ml rom (veya brandy)\n- 15 ml kahve likörü\n- Şeker, krema",
                "1) Bardağın ağzını şekerle kaplayabilirsin.\n" +
                "2) Rom ve likörü ekle, üzerine kahveyi koy.\n" +
                "3) Kremayla tamamla.",
                "Ateşli karamelizasyon yapılan ‘show’ versiyonları da vardır."
        ));

        return list;
    }
}
