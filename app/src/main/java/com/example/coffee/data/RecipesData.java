package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;
import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    public static final int CAT_ESPRESSO = 0;
    public static final int CAT_FILTER = 1;
    public static final int CAT_SPECIAL = 2;
    public static final int CAT_ALCOHOLIC = 3;
    public static final int CAT_ICED = 4;
    public static final int CAT_TURKISH = 5;

    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // ===================== ESPRESSO =====================
        list.add(new Recipe(
                "Espresso", "Tek shot, yoğun ve kısa içim.",
                CAT_ESPRESSO, R.drawable.cup_espresso_70ml, "70 ml fincan",
                "25–30 sn aralığı lezzet için tatlı nokta.",
                "• 18–20 g ince öğütüm çekirdek kullan.\n" +
                "• Portafiltreyi temizle ve kuru olmasına dikkat et.\n" +
                "• 2–3 sn pre-infusion, toplam akış 25–30 sn.\n" +
                "• 1:2 oran hedefle (18 g kahve → 36 g espresso).\n" +
                "• Akış parlak bal renginden koyulaşınca kes." ));

        list.add(new Recipe(
                "Doppio", "Çift shot espresso.",
                CAT_ESPRESSO, R.drawable.cup_doppio_120ml, "120 ml fincan",
                "Aynı değirmen ayarında doz ve dağılıma özen göster.",
                "• 18–20 g yerine 2 shot toplam 36–40 g kahve ya da 1 basket 20 g → 40 g çıktı.\n" +
                "• 2–4 sn pre-infusion, 27–32 sn toplam akış.\n" +
                "• Akış çok koyuysa öğütümü kalınlaştır, çok hızlıysa incelt." ));

        list.add(new Recipe(
                "Ristretto", "Kısa akış; daha konsantre.",
                CAT_ESPRESSO, R.drawable.cup_ristretto_50ml, "50 ml fincan",
                "1:1–1:1.5 oran yoğun ve tatlı sonuç verir.",
                "• 18 g kahve → 18–25 g çıkış.\n" +
                "• Öğütümü hafif incelt; 20–25 sn’de bitir.\n" +
                "• Çekirdeği daha koyu kavrum seçersen çikolata-notası artar." ));

        list.add(new Recipe(
                "Lungo", "Uzun akış; hafif gövde.",
                CAT_ESPRESSO, R.drawable.cup_lungo_150ml, "150 ml fincan",
                "Aşırı acılığı önlemek için öğütümü biraz kalınlaştır.",
                "• 18 g kahve → 45–60 g çıkış (1:2.5–1:3.3).\n" +
                "• 30–40 sn arası sürdürebilirsin.\n" +
                "• Tadı çok acıysa öğütümü kalınlaştır veya akışı erken kes." ));

        list.add(new Recipe(
                "Macchiato", "Espresso üstüne az süt köpüğü.",
                CAT_ESPRESSO, R.drawable.cup_macchiato_120ml, "120 ml fincan",
                "Köpüğü kaşıkla koy; süt gelmemesine dikkat et.",
                "• 1 shot espresso hazırla.\n" +
                "• 30–60 ml sütü 60–65°C’ye kadar ısıtıp mikrofoam yap.\n" +
                "• Kaşıkla 1–2 yemek kaşığı köpüğü espressonun üzerine bırak." ));

        list.add(new Recipe(
                "Cortado", "Espresso + eşit miktar süt.",
                CAT_ESPRESSO, R.drawable.cup_cortado_150ml, "150 ml bardak",
                "Süt 60–65°C; kaynatma, tat kaybı olur.",
                "• 1 shot espresso çek.\n" +
                "• 60–70 ml sütü mikrofoam (ince köpük) olacak şekilde hazırla.\n" +
                "• 1:1 oranla espressonun üzerine dök; karıştırma." ));

        list.add(new Recipe(
                "Flat White", "İnce mikrofoam ile yumuşak içim.",
                CAT_ESPRESSO, R.drawable.cup_flatwhite_240ml, "240 ml kupa",
                "Köpük katmanı 0.5–1 cm, ipeksi doku önemli.",
                "• 1 veya 2 shot espresso (tercihe göre).\n" +
                "• 150–180 ml sütü 60–65°C’ye kadar ısıt ve mikrofoam yap.\n" +
                "• Merkezden yavaşça dök; ince, düz bir yüzey oluştur." ));

        list.add(new Recipe(
                "Cappuccino", "1:1:1 espresso/süt/köpük.",
                CAT_ESPRESSO, R.drawable.cup_cappuccino_240ml, "240 ml kupa",
                "Köpük kubbe gibi; büyük baloncuk istemiyoruz.",
                "• 1 shot espresso.\n" +
                "• 120–150 ml sütü 60–65°C; köpük kalınlığı 1–2 cm.\n" +
                "• Bardak merkezine dök; kubbe oluşsun.\n" +
                "• İsteğe göre kakao serpiştir." ));

        list.add(new Recipe(
                "Latte", "Espresso üzerine bol süt.",
                CAT_ESPRESSO, R.drawable.cup_latte_300ml, "300 ml kupa",
                "Latte art için akışa ve bardağı eğmeye dikkat et.",
                "• 1 shot espresso.\n" +
                "• 200–230 ml sütü 60–65°C; ince mikrofoam.\n" +
                "• Yüksekten ince akışla dök, son kısımda yaklaş ve şekil ver." ));

        list.add(new Recipe(
                "Mocha", "Çikolatalı latte.",
                CAT_ESPRESSO, R.drawable.cup_mochacino_300ml, "300 ml kupa",
                "Çikolatayı espressoda eritmek pütürsüz tat verir.",
                "• 1–1.5 yemek kaşığı çikolata sosu/kakao + az sıcak su ile karıştır.\n" +
                "• 1 shot espresso ekle ve çöz.\n" +
                "• 180–200 ml sıcak sütü mikrofoam yapıp üzerine dök.\n" +
                "• Üstüne çikolata sosu gezdirebilirsin." ));

        list.add(new Recipe(
                "Breve", "Espresso + yarım yağlı krema.",
                CAT_ESPRESSO, R.drawable.cup_breve_200ml, "200 ml kupa",
                "Kremayı aşırı ısıtma; 55–60°C yeterli.",
                "• 1 shot espresso.\n" +
                "• 120–150 ml yarım yağlı krema/süt karışımını ısıt.\n" +
                "• İnce köpükle espressonun üzerine dök." ));

        list.add(new Recipe(
                "Piccolo Latte", "Küçük bardakta latte.",
                CAT_ESPRESSO, R.drawable.cup_piccololatte_120ml, "120 ml bardak",
                "Tek shot + ince mikrofoam, küçük gövdeli bardak.",
                "• 1 shot espresso.\n" +
                "• 70–90 ml sütü mikrofoam yap.\n" +
                "• Bardak küçük olduğu için yavaş dök." ));

        list.add(new Recipe(
                "Con Panna", "Espresso üstüne krem şanti.",
                CAT_ESPRESSO, R.drawable.cup_conpanna_100ml, "100 ml fincan",
                "Kremayı çok değil, bir nohut büyüklüğünde ekle.",
                "• 1 shot espresso hazırla.\n" +
                "• Üzerine küçük bir rozet krem şanti sık ve hemen servis et." ));

        list.add(new Recipe(
                "Romano", "Espresso + limon kabuğu.",
                CAT_ESPRESSO, R.drawable.cup_romano_70ml, "70 ml fincan",
                "Limon kabuğu yağını bardağın kenarına sür.",
                "• İnce bir limon kabuğu şeridi hazırla.\n" +
                "• 1 shot espresso çek.\n" +
                "• Kabuğu hafifçe sıkıp yağı yüzeye bırak; kenarıyla bardağı sil." ));

        list.add(new Recipe(
                "Americano", "Espresso üzerine sıcak su.",
                CAT_ESPRESSO, R.drawable.cup_americano_350ml, "350 ml kupa",
                "Önce suyu koyup sonra shot eklemek crema’yı korur.",
                "• 180–240 ml sıcak suyu bardağa ekle.\n" +
                "• Üzerine 1 shot espresso dök.\n" +
                "• Yoğunluk için su/espresso oranını ayarla." ));

        list.add(new Recipe(
                "Affogato", "Espresso + vanilyalı dondurma.",
                CAT_ESPRESSO, R.drawable.cup_affogato_150ml, "150 ml fincan",
                "Shot çok sıcak olmalı ki dondurmayı hafif eritsin.",
                "• Küçük bir kupaya 1 top vanilyalı dondurma koy.\n" +
                "• Üzerine taze çekilmiş 1 shot espressoyu dök.\n" +
                "• İsteğe göre kakao/çikolata rendesi ekle." ));

        // ===================== FILTER =====================
        list.add(new Recipe(
                "V60 Pour Over", "Klasik filtre demleme yöntemi.",
                CAT_FILTER, R.drawable.cup_v60, "350 ml ekipman",
                "Spiral döküş; ortadan dışa, dıştan ortaya.",
                "• 15 g orta-ince öğütüm, 250 g su (92–94°C).\n" +
                "• Filtreyi ıslat, kahveyi koy.\n" +
                "• 30–40 g bloom (30–45 sn), sonra 2–3 döküşte 2:30–3:00 dk tamamla." ));

        list.add(new Recipe(
                "Chemex", "Kalın filtreyle temiz tat.",
                CAT_FILTER, R.drawable.cup_chemex, "600 ml ekipman",
                "Daha kalın filtre → daha temiz ama daha uzun akış.",
                "• 30 g orta öğütüm, 500 g su (92–94°C).\n" +
                "• Filtreyi ıslat, kahveyi koy; 60 g bloom (45 sn).\n" +
                "• 3–4 döküşte 4:00–4:30 dk’da bitir." ));

        list.add(new Recipe(
                "French Press", "Daldırmalı demleme.",
                CAT_FILTER, R.drawable.cup_frenchpress, "350 ml ekipman",
                "Metal filtre tortu bırakır; servis öncesi süzebilirsin.",
                "• 18 g kalın öğütüm, 300 g su (93°C).\n" +
                "• 4 dk beklet; 2. dakikada nazikçe karıştır.\n" +
                "• Pistonu yavaşça indir, bardağa aktar." ));

        list.add(new Recipe(
                "AeroPress", "Basınçla kısa demleme.",
                CAT_FILTER, R.drawable.cup_aeropress, "200 ml ekipman",
                "Inverted yöntem daha gövdeli tat verir.",
                "• 15 g orta-ince öğütüm, 200 g su (85–90°C).\n" +
                "• 10 sn karıştır, 1:00 bekle, kapağı tak.\n" +
                "• 30 sn’de yavaşça presle." ));

        list.add(new Recipe(
                "Syphon Brew", "Vakumla demleme.",
                CAT_FILTER, R.drawable.cup_syphonbrew, "400 ml ekipman",
                "Gösterişli; ısıl kontrol önemli.",
                "• Alt hazneye su, üst hazneye 20 g orta öğütüm.\n" +
                "• Kaynayınca su yukarı çıkar; 45–60 sn karıştır.\n" +
                "• Isıyı kes; kahve aşağı süzülünce servis." ));

        list.add(new Recipe(
                "Moka Pot", "Klasik İtalyan cezvesi.",
                CAT_FILTER, R.drawable.cup_mokapot, "250 ml ekipman",
                "Alt hazneyi çizgiye kadar suyla doldur; sıkma.",
                "• Alt hazneye sıcak su, sepete orta-ince öğütüm (basma!).\n" +
                "• Kısık-orta ateşte; ilk fışkırmada ocaktan al.\n" +
                "• Üst haznede hafif karıştır, servis." ));

        list.add(new Recipe(
                "Percolator", "Devridaimle demleme.",
                CAT_FILTER, R.drawable.cup_percolator, "500 ml ekipman",
                "Aşırı ısı kahveyi yakar; kaynama noktasında tutma.",
                "• Sepete orta-kalın öğütüm koy.\n" +
                "• Orta ateşte 6–7 dk devridaim; sonra kapat.\n" +
                "• Tortu istemiyorsan kâğıt filtre ekleyebilirsin." ));

        list.add(new Recipe(
                "Kalita Wave", "Dengeli akışlı demleme.",
                CAT_FILTER, R.drawable.cup_kalitawave, "350 ml ekipman",
                "Düz taban → sabit ekstraksiyon.",
                "• 18 g orta öğütüm, 300 g su (92–94°C).\n" +
                "• 40 g bloom (30–40 sn), 2–3 döküşte 2:45–3:15 dk." ));

        list.add(new Recipe(
                "Cold Brew", "Soğuk demleme.",
                CAT_FILTER, R.drawable.cup_colddrip, "1 L ekipman",
                "Uzun süre – düşük ısı, düşük asidite.",
                "• 1:8 oran (125 g kalın öğütüm → 1 L su, soğuk).\n" +
                "• 12–16 saat buzdolabında beklet.\n" +
                "• İnce süzgeç/kâğıt filtre ile süz, servis." ));

        // ===================== SPECIAL =====================
        list.add(new Recipe(
                "Caramel Brûlée Latte", "Karamel köpüklü özel latte.",
                CAT_SPECIAL, R.drawable.cup_caramel_brulee_latte, "350 ml bardak",
                "Üstüne karamel sosu spiral gezdir.",
                "• 1 shot espresso + 1–1.5 YK karamel şurup karıştır.\n" +
                "• 220 ml sütü 60–65°C mikrofoam yap.\n" +
                "• Üzerine dök; karamel sosla tamamla." ));

        list.add(new Recipe(
                "Rose Latte", "Gül aromalı sütlü kahve.",
                CAT_SPECIAL, R.drawable.cup_rose_latte, "300 ml bardak",
                "Gül şurubunu fazla kaçırma; 1–2 tatlı kaşığı yeter.",
                "• 1 shot espresso.\n" +
                "• 180–200 ml süt 60–65°C; gül şurubunu bardağa koy.\n" +
                "• Sütü ve espressoyu ekle; hafifçe karıştır." ));

        list.add(new Recipe(
                "Pistachio Latte", "Fıstıklı süt aromasıyla.",
                CAT_SPECIAL, R.drawable.cup_pistachio_latte, "300 ml bardak",
                "Üstüne çok az kıyılmış Antep fıstığı hoş olur.",
                "• 1 shot espresso.\n" +
                "• 200 ml süt + 1 tatlı kaşığı fıstık şurubu/paste.\n" +
                "• Karıştır, mikrofoam ile bitir." ));

        list.add(new Recipe(
                "Honey Latte", "Bal ve sütle doğal tat.",
                CAT_SPECIAL, R.drawable.cup_honey_latte, "300 ml bardak",
                "Balı direkt sıcak espressoda çöz; tadı homojen olur.",
                "• 1 shot espresso + 1 tatlı kaşığı balı karıştır.\n" +
                "• 200 ml süt 60–65°C; üzerine dök.\n" +
                "• İsteğe göre tarçın serpiştir." ));

        list.add(new Recipe(
                "Spanish Mocha", "Kakao + süt + tarçın.",
                CAT_SPECIAL, R.drawable.cup_spanish_mocha, "300 ml bardak",
                "Tarçını az kullan; kokusu baskın olabilir.",
                "• 1 YK kakao + az sıcak suyla macun yap.\n" +
                "• 1 shot espresso ekle ve çöz.\n" +
                "• 200 ml sıcak sütü dök; üstüne az tarçın." ));

        // ===================== ALCOHOLIC =====================
        list.add(new Recipe(
                "Irish Coffee", "Kahve + viski + krema.",
                CAT_ALCOHOLIC, R.drawable.cup_irish_coffee, "240 ml bardak",
                "Kremayı çırpıp yüzdür; karıştırma.",
                "• 120–150 ml sıcak filtre kahve + 40 ml İrlanda viskisi.\n" +
                "• 1–2 tatlı kaşığı esmer şeker ile karıştır.\n" +
                "• Üzerine kalınca çırpılmış kremayı kaşıkla bırak." ));

        list.add(new Recipe(
                "Baileys Latte", "Baileys likörlü latte.",
                CAT_ALCOHOLIC, R.drawable.cup_baileys_latte, "300 ml bardak",
                "Baileys’i süte ekleyip ısıtma; ayrı karıştır.",
                "• 1 shot espresso.\n" +
                "• Bardağa 30–40 ml Baileys koy.\n" +
                "• Üzerine sıcak süt + espresso dök." ));

        list.add(new Recipe(
                "Amaretto Mocha", "Badem likörlü mocha.",
                CAT_ALCOHOLIC, R.drawable.cup_amaretto_mocha, "300 ml bardak",
                "Şeker miktarını azalt; Amaretto tatlıdır.",
                "• 1 shot espresso + 1 YK çikolata sosu.\n" +
                "• 20–30 ml Amaretto ekle, karıştır.\n" +
                "• Üzerine sıcak süt dök." ));

        list.add(new Recipe(
                "Rum Mocha", "Rom aromalı mocha.",
                CAT_ALCOHOLIC, R.drawable.cup_rum_mocha, "300 ml bardak",
                "Koyu çikolata ile çok iyi uyum.",
                "• 1 shot espresso + 1 YK çikolata şurubu.\n" +
                "• 10–20 ml rom ekle.\n" +
                "• Üzerine sıcak süt ve krem şanti (isteğe bağlı)." ));

        list.add(new Recipe(
                "Espresso Martini", "Vodka + kahve likörü + espresso.",
                CAT_ALCOHOLIC, R.drawable.cup_espresso_martini, "150 ml kadeh",
                "Kokteyl shaker’da bol buzla çalkala, köpük oluşsun.",
                "• 30 ml vodka + 30 ml kahve likörü + 1 shot espresso.\n" +
                "• Buzla sertçe çalkala, süzerek kadehe doldur." ));

        // ===================== ICED =====================
        list.add(new Recipe(
                "Iced Americano", "Espresso + soğuk su + buz.",
                CAT_ICED, R.drawable.cup_iced_americano, "400 ml bardak",
                "Buzu üste ekle; sulanmayı azaltır.",
                "• Bardağı buzla doldur.\n" +
                "• 120–180 ml soğuk su ekle.\n" +
                "• Üzerine 1–2 shot soğumuş espresso dök." ));

        list.add(new Recipe(
                "Iced Latte", "Soğuk süt + espresso.",
                CAT_ICED, R.drawable.cup_iced_latte, "400 ml bardak",
                "Sütü önceden soğut; köpüğü shaker’da yap.",
                "• Bardağı buzla doldur.\n" +
                "• 200–230 ml soğuk süt + 1 shot espresso ekle.\n" +
                "• Hafifçe karıştır, isteğe göre şurup." ));

        list.add(new Recipe(
                "Iced Mocha", "Soğuk çikolatalı latte.",
                CAT_ICED, R.drawable.cup_iced_mocha, "400 ml bardak",
                "Çikolatayı espressoda çöz; pütürsüz olur.",
                "• 1 shot espresso + 1 YK çikolata sosu karıştır.\n" +
                "• Bardağı buzla doldur, 200 ml soğuk süt ekle." ));

        list.add(new Recipe(
                "Affogato Freddo", "Soğuk espresso + dondurma.",
                CAT_ICED, R.drawable.cup_affogato_freddo, "300 ml bardak",
                "Espressoyu önceden soğutup dök.",
                "• Bardağa 1 top vanilyalı dondurma koy.\n" +
                "• Üzerine soğutulmuş 1 shot espresso dök." ));

        list.add(new Recipe(
                "Iced Breve", "Espresso + soğuk krema.",
                CAT_ICED, R.drawable.cup_iced_breve, "300 ml bardak",
                "Kremayı hafif seyrelt; çok yoğun olmasın.",
                "• Bardağı buzla doldur.\n" +
                "• 1 shot espresso + 120–150 ml soğuk krema/süt karışımı ekle." ));

        // ===================== TURKISH =====================
        list.add(new Recipe(
                "Türk Kahvesi", "Klasik cezvede pişirilmiş.",
                CAT_TURKISH, R.drawable.cup_t_70ml, "70 ml fincan",
                "Köpüğü üç kez yükseltmek aromayı artırır.",
                "• Cezveye fincan başı 1 dolu tatlı kaşığı kahve ekle.\n" +
                "• (İsteğe bağlı) şeker: Sade 0 / Az 1 / Orta 2 / Şekerli 3 çay kaşığı.\n" +
                "• Soğuk suyu fincan sayısı kadar ekle, karıştır.\n" +
                "• Kısık ateşte köpük yükselince taşırmadan al; fincanlara köpüğü paylaştır.\n" +
                "• 1–2 kez daha yükseltip paylaştırarak servis et." ));

        return list;
    }
}