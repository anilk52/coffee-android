package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    public static final String CAT_ESPRESSO = "Espresso";
    public static final String CAT_FILTER = "Filtre";
    public static final String CAT_SPECIAL = "Special";
    public static final String CAT_ALCOHOLIC = "Alkollü";
    public static final String CAT_ICED = "Soğuk";
    public static final String CAT_TURKISH = "Türk Kahvesi";

    public static List<Recipe> getAll() {
        List<Recipe> list = new ArrayList<>();

        // ===== ESPRESSO =====
        list.add(new Recipe(
                "Espresso",
                "Tek shot, yoğun ve kısa içim.",
                CAT_ESPRESSO,
                R.drawable.cup_espresso_70ml,
                "70 ml fincan",
                "15–18 gram ince öğütülmüş kahveyi porta filtreye koy, 25–30 saniye içinde 30 ml shot elde et. Su sıcaklığı 92–94°C olmalı. Shot 25 saniye civarı akmalı."
        ));

        list.add(new Recipe(
                "Doppio",
                "Çift shot espresso, daha yoğun gövde.",
                CAT_ESPRESSO,
                R.drawable.cup_doppio_120ml,
                "120 ml fincan",
                "18–20 gram kahveden 60 ml espresso elde et. Aynı süre (25–30 sn) korunmalı. Yoğun aroma için öğütme biraz daha ince olmalı."
        ));

        list.add(new Recipe(
                "Cappuccino",
                "1:1:1 oranında espresso, süt ve köpük.",
                CAT_ESPRESSO,
                R.drawable.cup_cappucino_240ml,
                "240 ml kupa",
                "1 shot espresso üzerine 120 ml buharlanmış süt ekle, üstüne 1 cm mikro köpük koy. Süt 60–65°C olmalı."
        ));

        list.add(new Recipe(
                "Piccolo Latte",
                "Küçük bardakta latte versiyonu.",
                CAT_ESPRESSO,
                R.drawable.cup_piccolalatte_120ml,
                "120 ml bardak",
                "Bir shot espresso üzerine 80 ml ısıtılmış süt ekle. Latte benzeri ama daha konsantre bir içim verir."
        ));

        list.add(new Recipe(
                "Affogato",
                "Espresso + vanilyalı dondurma.",
                CAT_ESPRESSO,
                R.drawable.cup_affogato_150ml,
                "150 ml fincan",
                "Bir top vanilyalı dondurmayı fincana koy, üstüne sıcak espressoyu direkt dök. 5–10 saniye içinde servis et."
        ));

        // ===== FİLTRE =====
        list.add(new Recipe(
                "V60 Pour Over",
                "Klasik filtre demleme.",
                CAT_FILTER,
                R.drawable.cup_v60,
                "300 ml kupa",
                "17 gram kahveyi orta öğüt, 250 ml 92°C suyu 3 aşamada dök. Toplam demleme süresi 2:30–3:00 dakika olmalı."
        ));

        list.add(new Recipe(
                "French Press",
                "Yoğun gövdeli klasik filtre.",
                CAT_FILTER,
                R.drawable.cup_frenchpress,
                "350 ml kupa",
                "18 gram kalın öğütülmüş kahveye 300 ml 94°C su ekle. 4 dakika demle, sonra yavaşça bastır."
        ));

        list.add(new Recipe(
                "Chemex",
                "Berrak ve temiz gövdeli demleme.",
                CAT_FILTER,
                R.drawable.cup_chemex,
                "500 ml cam sürahi",
                "30 gram kahve, 500 ml 93°C su. Spiral dökümle 4–5 dakika demle. Temiz, çiçeksi tatlar verir."
        ));

        list.add(new Recipe(
                "Aeropress",
                "Basınçla kısa demleme.",
                CAT_FILTER,
                R.drawable.cup_aeropress,
                "250 ml kupa",
                "15 gram kahve, 220 ml su (85–90°C). 10 sn karıştır, 1 dakika beklet, sonra bastır."
        ));

        // ===== SPECIAL =====
        list.add(new Recipe(
                "Caramel Brûlée Latte",
                "Espresso, süt ve karamel soslu tatlı latte.",
                CAT_SPECIAL,
                R.drawable.cup_caramel_brulee_latte,
                "240 ml bardak",
                "1 shot espresso, 180 ml buharlanmış süt, 15 ml karamel şurubu. Üstüne karamel sos gezdir."
        ));

        list.add(new Recipe(
                "Rose Latte",
                "Gül aromalı latte.",
                CAT_SPECIAL,
                R.drawable.cup_rose_latte,
                "240 ml bardak",
                "Espresso üzerine 10 ml gül şurubu ve sıcak süt ekle. Üstüne kurutulmuş gül yaprakları serpiştir."
        ));

        list.add(new Recipe(
                "Spanish Latte",
                "Yoğun süt ve şekerle dengelenmiş espresso.",
                CAT_SPECIAL,
                R.drawable.cup_spanish_mocha,
                "300 ml bardak",
                "Espresso + 1 tatlı kaşığı yoğunlaştırılmış süt + 150 ml sıcak süt. Karıştır ve sıcak servis et."
        ));

        list.add(new Recipe(
                "Pistachio Latte",
                "Fıstık aromalı latte.",
                CAT_SPECIAL,
                R.drawable.cup_pistachio_latte,
                "240 ml bardak",
                "Espresso, süt ve 10 ml fıstık aromasıyla karıştır. Üstüne kıyılmış Antep fıstığı ekle."
        ));

        // ===== ALKOLLÜ =====
        list.add(new Recipe(
                "Irish Coffee",
                "Kahve + viski + krema.",
                CAT_ALCOHOLIC,
                R.drawable.cup_irish_coffee,
                "240 ml cam bardak",
                "1 shot espresso, 40 ml İrlanda viskisi, 1 tatlı kaşığı şeker. Üzerine soğuk krema ekle."
        ));

        list.add(new Recipe(
                "Baileys Latte",
                "Baileys likörlü latte.",
                CAT_ALCOHOLIC,
                R.drawable.cup_baileys_latte,
                "240 ml bardak",
                "1 shot espresso, 30 ml Baileys, 150 ml buharlanmış süt. Üzerine kakao tozu serpiştir."
        ));

        list.add(new Recipe(
                "Espresso Martini",
                "Vodka + kahve likörü + espresso.",
                CAT_ALCOHOLIC,
                R.drawable.cup_espresso_martini,
                "150 ml kadeh",
                "30 ml espresso, 30 ml vodka, 30 ml kahve likörü. Buzla çalkala, köpüklü şekilde süz."
        ));

        // ===== SOĞUK =====
        list.add(new Recipe(
                "Iced Americano",
                "Espresso + soğuk su + buz.",
                CAT_ICED,
                R.drawable.cup_iced_americano,
                "350 ml bardak",
                "Bir shot espressoyu buz dolu bardağa dök, üstüne 200 ml soğuk su ekle. Karıştırmadan servis et."
        ));

        list.add(new Recipe(
                "Iced Latte",
                "Soğuk süt + espresso + buz.",
                CAT_ICED,
                R.drawable.cup_iced_latte,
                "350 ml bardak",
                "Bir shot espressoyu 180 ml soğuk sütle karıştır. 4–5 buz küpü ekle, pipetle servis et."
        ));

        list.add(new Recipe(
                "Iced Mocha",
                "Soğuk çikolatalı latte.",
                CAT_ICED,
                R.drawable.cup_iced_mocha,
                "350 ml bardak",
                "1 shot espresso, 10 ml çikolata şurubu, 150 ml süt, buz. Karıştır, üstüne krema ekle."
        ));

        // ===== TÜRK KAHVESİ =====
        list.add(new Recipe(
                "Türk Kahvesi",
                "Klasik cezvede pişirilmiş.",
                CAT_TURKISH,
                R.drawable.cup_t_70ml,
                "70 ml fincan",
                "Bir fincan suya 1 tatlı kaşığı kahve, isteğe göre şeker. Kısık ateşte köpürene kadar pişir."
        ));

        list.add(new Recipe(
                "Menengiç Kahvesi",
                "Kafeinsiz, aromatik içim.",
                CAT_TURKISH,
                R.drawable.cup_t_70ml,
                "70 ml fincan",
                "Cezvede sütle birlikte kaynat. Köpük oluşunca fincana dök."
        ));

        list.add(new Recipe(
                "Sütlü Türk Kahvesi",
                "Klasik tarifin sütlü versiyonu.",
                CAT_TURKISH,
                R.drawable.cup_t_70ml,
                "70 ml fincan",
                "Suyun yerine süt kullan. Kısık ateşte, taşırmadan pişir."
        ));

        return list;
    }
}