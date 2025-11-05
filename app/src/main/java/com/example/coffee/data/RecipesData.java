package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Uygulamadaki tüm tariflerin basit veri kaynağı.
 * Şimdilik kod içine gömülü; ileride JSON/SQLite'e taşınabilir.
 */
public final class RecipesData {

    private static final List<Recipe> ALL_RECIPES;

    static {
        List<Recipe> list = new ArrayList<>();

        // =============== ESPRESSO ===============
        list.add(new Recipe(
                R.drawable.ic_espresso,
                "Single Espresso",
                "Yoğun, kısa ve net espresso shot.",
                "18–19 g taze çekilmiş kahveyi portafiltreye düzgünce dağıtıp tamp et. "
                        + "92–94°C suyla 25–30 saniyede yaklaşık 36–40 g espresso al. "
                        + "Akış başta koyu ve yoğun, sonunda hafif incelmiş olmalı. "
                        + "Kreması altın kahverengi ve bütün yüzeyi kaplamalı.",
                "1:2 oran — 18 g kahveden 36 g içecek, 25–30 sn.",
                "Akışı ilk 5–6 saniye izle; çok hızlıysa öğütümü incelt, çok yavaşsa kalınlaştır.",
                "Espressoyu fincanda 10–15 saniyeden fazla bekletme; aroma hızla bozulur.",
                "espresso",
                "30–40 ml"
        ));

        list.add(new Recipe(
                R.drawable.ic_espresso,
                "Double Espresso",
                "Standart kafe shot’ı, daha gövdeli ve dengeli.",
                "18–20 g kahve kullanıp çift shot çıkart. 90–94°C arası su ile 25–30 sn demleme süresini koru. "
                        + "Akış ince bir bal sütunu gibi olmalı. "
                        + "Daha tatlı bir profil için 1–2 saniye erken kesebilirsin.",
                "1:2 oran — 18–20 g kahveden 36–40 g espresso.",
                "Aynı kahveyle üst üste iki shot çekiyorsan öğütümü ve dozu sık sık kontrol et; kahve ısındıkça akış hızlanır.",
                "Menşei tek bölgeli kahvelerde demleme süresi ve oranla oynamak tadı dramatik değiştirir; küçük adımlarla ilerle.",
                "espresso",
                "40–50 ml"
        ));

        list.add(new Recipe(
                R.drawable.ic_espresso,
                "Americano",
                "Espresso üzerine sıcak su eklenmiş hafif içimli kahve.",
                "Önce fincana 120–150 ml sıcak su koy. Üzerine 1 shot espresso ekle. "
                        + "Bu sıra, kremanın daha uzun süre korunmasını sağlar. "
                        + "Su miktarını damak zevkine göre artırıp azaltabilirsin.",
                "1 shot espresso + 120–150 ml sıcak su.",
                "Su çok kaynar olmasın; 90–92°C civarı hem içimi hem aromayı korur.",
                "İstersen buz ekleyip soğuk Americano yapabilir, üstüne limon kabuğu ile ferahlık katabilirsin.",
                "espresso",
                "150–180 ml"
        ));

        // =============== FİLTRE / DEMLEME ===============
        list.add(new Recipe(
                R.drawable.ic_filter,
                "Chemex – Temel Tarif",
                "Temiz, parlak ve tatlı gövdeli filtre kahve.",
                "600 ml chemex için 36 g kahveyi orta-ince öğüt. Filtreyi ıslat, kağıdı ısıtıcı suyla durula. "
                        + "Bloom için 60–70 g su ekleyip 30–40 sn bekle. Ardından dairesel hareketlerle "
                        + "toplam 600 g suya 3–4 döküşte tamamla. Toplam süre 4–4,5 dakika civarı.",
                "1:16 oran — 36 g kahve / 600 g su, 94°C.",
                "Akış çok hızlıysa öğütümü incelt; çok yavaşsa daha kalın öğüt. Ama her seferinde tek parametreyi değiştir.",
                "Chemex camı önceden ısıtmak, kahvenin son fincanda daha dengeli kalmasını sağlar.",
                "filter",
                "2 büyük kupa (~600 ml)"
        ));

        list.add(new Recipe(
                R.drawable.ic_filter,
                "V60 – Dengeli Profil",
                "Asidite, gövde ve tatlılık arasında dengeli bir V60.",
                "15 g kahveyi orta ince öğüt. 250 g suyu 93–94°C’ye getir. "
                        + "Önce 40 g suyla 30 sn bloom yap. Sonra dairesel hareketle 100 g’a tamamla. "
                        + "1:10’a gelince kısa bir ara ver, ardından 250 g’a kadar dök. "
                        + "Toplam süre 2:30–3:00 arası idealdir.",
                "1:16–1:17 oran — 15 g kahve / 250 g su.",
                "Kahve tanelerinin yatağı demlenme sonunda düz ve sakin görünmeli; çukur veya duvara yapışma kanallanmaya işaret eder.",
                "Farklı kahveler için önce su sıcaklığıyla, sonra öğütümle oynayarak favori noktanı bul.",
                "filter",
                "1 kupa (~250 ml)"
        ));

        // =============== SPECIAL (sütlü / aromalı) ===============
        list.add(new Recipe(
                R.drawable.ic_special,
                "Flat White",
                "Yoğun espresso + ince dokulu sütlü içim.",
                "Çift shot espresso hazırla. 130–140 ml soğuk sütü 60–65°C’ye kadar köpürt; "
                        + "süt yüzeyinde ayna gibi hafif parlak, kabarcıksız olmalı. "
                        + "Espressoya merkezi bir akışla sütü dök; fincanı çok doldurmadan, kahve aromasını baskılamadan bitir.",
                "2 shot espresso + ~130 ml süt.",
                "Sütü fazla ısıtırsan tatlılık kaybolur ve yanık tat gelir; termometre yoksa cezveyi tutamayacak kadar sıcak olmamalı.",
                "Evdeysen mikrodalga + el köpürtücü ile de fena olmayan bir doku yakalayabilirsin; önemli olan büyük kabarcıkları dağıtmak.",
                "special",
                "180–200 ml"
        ));

        list.add(new Recipe(
                R.drawable.ic_special,
                "Rose Latte",
                "Gül şurubu ile hafif floral, tatlı latte.",
                "Büyük bir fincana 1–2 yemek kaşığı gül şurubu koy. Üzerine 1 shot espresso ekle ve karıştır. "
                        + "150 ml sütü 60–65°C’ye kadar köpürtüp fincana dök. "
                        + "Üste çok az tarçın veya kurutulmuş gül yaprağı serpebilirsin.",
                "1 shot espresso + 150 ml süt + 20–30 ml gül şurubu.",
                "Şurubu azdan başlat; yoğun gül aroması kahvenin tüm profilini bastırabilir.",
                "Şurubun yoksa, az bal + birkaç damla gül suyu ile benzer, daha hafif bir versiyon yapabilirsin.",
                "special",
                "220–240 ml"
        ));

        // =============== ALKOLLÜ ===============
        list.add(new Recipe(
                R.drawable.ic_alcoholic,
                "Espresso Martini",
                "Yoğun kahve aromalı, dengeli kokteyl.",
                "Shaker’a bol buz, 1 shot espresso, 40 ml votka ve 20 ml kahve likörü ekle. "
                        + "Güçlü şekilde 10–15 sn çalkala. Soğutulmuş martini bardağına süz. "
                        + "Üstüne birkaç kahve çekirdeği bırakabilirsin.",
                "40 ml votka + 20 ml kahve likörü + 1 shot espresso.",
                "Espressoyu sıcak sıcak değil, ılığa yakın kullan; yoksa shaker içindeki buz çok hızlı erir ve içki sulanır.",
                "Şeker oranını artırmak için biraz basit şurup ekleyebilirsin; ama önce likörün tatlılığını mutlaka tat.",
                "alcoholic",
                "90–120 ml"
        ));

        // =============== ICED ===============
        list.add(new Recipe(
                R.drawable.ic_iced,
                "Iced Latte",
                "Buz üzerinde hafif sütlü kahve.",
                "Bardağı buzla doldur. 1 shot espressoyu ayrı bir kapta hazırlayıp 1–2 küp buzla hafif soğut. "
                        + "Buzlu bardağa önce 150–170 ml soğuk süt dök, sonra üstten yavaşça espressoyu ekle "
                        + "ve katmanları izleyerek hafifçe karıştır.",
                "1 shot espresso + 150–170 ml soğuk süt + bol buz.",
                "Sütü daha kremamsı istersen yarı süt yarı krema (half&half) karışımı kullanabilirsin.",
                "Şekerli seviyorsan, espresso sıcak halindeyken şurup ekle; soğukken şeker zor çözünür.",
                "iced",
                "250–300 ml"
        ));

        // =============== TÜRK ===============
        list.add(new Recipe(
                R.drawable.ic_turkish,
                "Klasik Türk Kahvesi",
                "Köpüklü, geleneksel Türk kahvesi.",
                "Cezveye her fincan için 1 silme tatlı kaşığı kahve ve arzuya göre şeker koy. "
                        + "Üzerine soğuk su ekle (her fincan için ~60–70 ml). "
                        + "Kısık ateşte karıştırarak ısıtmaya başla, köpüklenmeye başladığında üstten köpüğü fincanlara paylaştır. "
                        + "Kahve kaynamaya yaklaşınca taşırtmadan cezveyi ocaktan al ve fincanlara yavaşça dök.",
                "1 tatlı kaşığı kahve / 60–70 ml su, kısık ateş.",
                "Karıştırmayı sadece başta yap; köpük oluşmaya başladıktan sonra cezveyi sarsmamaya çalış.",
                "Kahveyi içmeden önce fincanda telvenin çökmesi için 1–2 dakika beklemek, hem ağızda tortu bırakmaz hem de aromayı toparlar.",
                "turkish",
                "60–70 ml"
        ));

        ALL_RECIPES = Collections.unmodifiableList(list);
    }

    private RecipesData() { }

    /** Uygulamadaki tüm tarifler (immutable liste). */
    public static List<Recipe> getAll() {
        return ALL_RECIPES;
    }
}