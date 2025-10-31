package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecipesData {

    private RecipesData() {}

    // Kategori sabitleri
    public static final String CAT_ESPRESSO  = "ESPRESSO";
    public static final String CAT_FILTER    = "FILTER";
    public static final String CAT_SPECIAL   = "SPECIAL";
    public static final String CAT_ALCOHOLIC = "ALCOHOLIC";
    public static final String CAT_ICED      = "ICED";
    public static final String CAT_TURKISH   = "TURKISH";

    private static final List<Recipe> ALL = new ArrayList<>();

    static {
        // ---- 41 HAZIR BARDAK ----
        // FILTER
        ALL.add(new Recipe(R.drawable.cup_aeropress,          "AeroPress",                 "Temiz, gövdeli",                "AeroPress ile hızlı demleme.",                       "1:15 ~ 1:17",      "Bloom 30 sn, yavaş pres.",         "", CAT_FILTER,    "M"));
        ALL.add(new Recipe(R.drawable.cup_chemex,             "Chemex",                    "Pürüzsüz, berrak",              "Kalın filtre ile berrak kupa.",                      "1:16",             "Yavaş ve sabit döküş.",            "", CAT_FILTER,    "L"));
        ALL.add(new Recipe(R.drawable.cup_v60,                "V60",                       "Temiz ve aromatik",             "Konik filtre kahve; dairesel döküş.",                "1:15 ~ 1:17",      "Bloom + 2-3 döküş.",               "", CAT_FILTER,    "M"));
        ALL.add(new Recipe(R.drawable.cup_frenchpress,        "French Press",              "Gövde belirgin",                "Demle ve presle; tortulu yapı.",                     "1:12 ~ 1:15",      "4 dk beklet, nazikçe presle.",     "", CAT_FILTER,    "L"));
        ALL.add(new Recipe(R.drawable.cup_kalitawave,         "Kalita Wave",               "Dengeli, tatlı",                "Düz taban filtre ile denge.",                         "1:16",             "Stabil akış, eşit ıslanma.",       "", CAT_FILTER,    "M"));
        ALL.add(new Recipe(R.drawable.cup_syphonbrew,         "Syphon",                    "Temiz, teatral",                "Vakum prensibiyle demleme.",                          "1:15",             "Isıyı sabit tut.",                  "", CAT_FILTER,    "M"));
        ALL.add(new Recipe(R.drawable.cup_mokapot,            "Moka Pot",                  "Yoğun, ev espresso’su",         "Buhar basıncıyla ekstraksiyon.",                     "—",                "Suyu fazla ısıtma.",               "", CAT_FILTER,    "S"));
        ALL.add(new Recipe(R.drawable.cup_percolator,         "Percolator",                "Klasik yöntem",                 "Sürekli dolaşan suyla demleme.",                      "—",                "Aşırı ekstraksiyona dikkat.",      "", CAT_FILTER,    "L"));
        ALL.add(new Recipe(R.drawable.cup_colddrip,           "Cold Drip",                 "Berrak, düşük asidite",         "Soğuk su, damla demleme.",                            "1:8 ~ 1:10",       "Yavaş damlatma en iyisi.",         "", CAT_FILTER,    "XL"));

        // ESPRESSO CORE
        ALL.add(new Recipe(R.drawable.cup_espresso_70ml,      "Espresso",                  "Yoğun, kısa",                   "18–20 g kahve, ~25–30 sn çekim.",                    "30 ml",            "9 bar, 92–94°C.",                   "", CAT_ESPRESSO,  "S – 30 ml"));
        ALL.add(new Recipe(R.drawable.cup_ristretto_50ml,     "Ristretto",                 "Daha kısa, daha yoğun",         "Kısa hacimle yoğun tat.",                             "15–20 ml",         "Daha ince öğütme.",                 "", CAT_ESPRESSO,  "XS – 15–20 ml"));
        ALL.add(new Recipe(R.drawable.cup_doppio_120ml,       "Doppio",                    "Çift shot",                     "İki shot espresso.",                                  "60 ml",            "Taze öğüt.",                        "", CAT_ESPRESSO,  "M – 60 ml"));
        ALL.add(new Recipe(R.drawable.cup_lungo_150ml,        "Lungo",                     "Uzun çekim",                    "Daha uzun ekstraksiyon.",                              "90–120 ml",        "Aşırı uzatma acılık verir.",       "", CAT_ESPRESSO,  "150 ml"));
        ALL.add(new Recipe(R.drawable.cup_macchiato_120ml,    "Macchiato",                 "Espresso + az süt köpüğü",      "Espresso lekeli süt köpüğü.",                         "60–90 ml",         "Köpüğü az ekle.",                   "", CAT_ESPRESSO,  "120 ml"));
        ALL.add(new Recipe(R.drawable.cup_conpanna_100ml,     "Con Panna",                 "Espresso + krema",              "Espresso üstüne krema.",                               "60–90 ml",         "Şekersiz önerilir.",                "", CAT_ESPRESSO,  "100 ml"));
        ALL.add(new Recipe(R.drawable.cup_piccolalatte_120ml, "Piccolo Latte",             "Küçük latte",                   "Küçük bardakta sütlü espresso.",                      "120 ml",           "Süt 60–65°C.",                      "", CAT_ESPRESSO,  "120 ml"));
        ALL.add(new Recipe(R.drawable.cup_cortado_150ml,      "Cortado",                   "Espresso + eşit süt",           "Espresso ile eşit süt.",                               "120–150 ml",       "Sütü çok köpürtme.",                "", CAT_ESPRESSO,  "150 ml"));
        ALL.add(new Recipe(R.drawable.cup_cappucino_240ml,    "Cappuccino",                "Köpüklü, dengeli",              "Espresso + süt + yoğun köpük.",                        "240 ml",           "Köpük ince gözenekli olmalı.",     "", CAT_ESPRESSO,  "240 ml"));
        ALL.add(new Recipe(R.drawable.cup_flatwhite_240ml,    "Flat White",                "Kahve baskın sütlü",            "Double espresso + kadifemsi süt.",                     "180–240 ml",       "Mikrofoam, ince köpük.",           "", CAT_ESPRESSO,  "240 ml"));
        ALL.add(new Recipe(R.drawable.cup_latte_300ml,        "Caffè Latte",               "Sütlü, yumuşak",                "Espresso üstüne sıcak süt.",                           "300 ml",           "Süt 60–65°C.",                      "", CAT_ESPRESSO,  "300 ml"));
        ALL.add(new Recipe(R.drawable.cup_mochacino_300ml,    "Mochaccino",                "Kakao dokunuşu",                "Espresso + süt + kakao/çikolata.",                     "300 ml",           "Sosu abartma.",                     "", CAT_ESPRESSO,  "300 ml"));
        ALL.add(new Recipe(R.drawable.cup_americano_350ml,    "Americano",                 "Uzun içim",                     "Espresso + sıcak su.",                                 "350 ml",           "Suyu espresso’ya ekle.",            "", CAT_ESPRESSO,  "350 ml"));
        ALL.add(new Recipe(R.drawable.cup_romano_70ml,        "Espresso Romano",           "Limon eşliğinde",               "Espresso + limon kabuğu/aroması.",                     "30 ml",            "Limonu bardağa sür.",               "", CAT_ESPRESSO,  "70 ml"));

        // SPECIAL LATTES & MOCHAS
        ALL.add(new Recipe(R.drawable.cup_honey_latte,         "Honey Latte",               "Bal aromalı",                   "Espresso + süt + bal.",                                "300 ml",           "Balı önce çözdür.",                 "", CAT_SPECIAL,   "M"));
        ALL.add(new Recipe(R.drawable.cup_pistachio_latte,     "Pistachio Latte",           "Fıstık ezmesi dokunuşu",        "Espresso + süt + fıstık aroması.",                     "300 ml",           "Homojen karıştır.",                 "", CAT_SPECIAL,   "M"));
        ALL.add(new Recipe(R.drawable.cup_rose_latte,          "Rose Latte",                "Gül aromalı",                   "Espresso + süt + gül şurubu.",                         "300 ml",           "Şurubu az kullan.",                 "", CAT_SPECIAL,   "M"));
        ALL.add(new Recipe(R.drawable.cup_caramel_brulee_latte,"Caramel Brûlée Latte",      "Karamel ve krema",              "Espresso + süt + karamel sos.",                        "300 ml",           "Üstte hafif krema.",                "", CAT_SPECIAL,   "M"));
        ALL.add(new Recipe(R.drawable.cup_spanish_mocha,       "Spanish Mocha",             "Yoğun çikolata",                "Espresso + süt + çikolata (İspanyol tarzı).",          "300 ml",           "Tatlılığı dengele.",                "", CAT_SPECIAL,   "M"));
        ALL.add(new Recipe(R.drawable.cup_amaretto_mocha,      "Amaretto Mocha",            "Badem likörü aromalı",          "Espresso + süt + çikolata + amaretto aroması.",        "300 ml",           "Aroma dozunu düşük tut.",           "", CAT_SPECIAL,   "M"));
        ALL.add(new Recipe(R.drawable.cup_rum_mocha,           "Rum Mocha",                 "Rum aromalı çikolata",          "Espresso + süt + çikolata + rum aroması.",             "300 ml",           "Aroma tadını bastırmasın.",         "", CAT_SPECIAL,   "M"));
        ALL.add(new Recipe(R.drawable.cup_affogato_150ml,      "Affogato",                  "Dondurma + espresso",           "Dondurma topu üzerine sıcak espresso.",                "150 ml",           "Espressoyu taze dök.",              "", CAT_SPECIAL,   "150 ml"));
        ALL.add(new Recipe(R.drawable.cup_breve_200ml,         "Breve",                     "Yarım yağlı krema ile",         "Espresso + yarım krema.",                               "200 ml",           "Zengin gövde için 1:1 yaklaş.",     "", CAT_SPECIAL,   "200 ml"));
        ALL.add(new Recipe(R.drawable.cup_cortado_150ml,       "Cortado (Special)",         "Dengeli süt/espresso",          "Espresso + eşit süt (tekrar)",                         "150 ml",           "Köpük az, süt sıcak.",              "", CAT_SPECIAL,   "150 ml"));
        ALL.add(new Recipe(R.drawable.cup_piccolalatte_120ml,  "Piccolo (Special)",         "Küçük latte",                   "Espresso + küçük bardak süt (tekrar).",                "120 ml",           "Mikrofoam.",                        "", CAT_SPECIAL,   "120 ml"));

        // ALCOHOLIC
        ALL.add(new Recipe(R.drawable.cup_irish_coffee,        "Irish Coffee",              "Viski + kahve + krema",         "Sıcak kahve, viski, şeker, krema.",                    "240–300 ml",       "Kremayı yüzdür.",                   "", CAT_ALCOHOLIC, "M/L"));
        ALL.add(new Recipe(R.drawable.cup_espresso_martini,    "Espresso Martini",          "Kokteyl, yoğun espresso",       "Votka + kahve likörü + espresso, buzla çalkalanır.",   "Kokteyl",          "Taze espresso şart.",               "", CAT_ALCOHOLIC, "—"));
        ALL.add(new Recipe(R.drawable.cup_baileys_latte,       "Baileys Latte",             "Kremalı likörlü latte",         "Espresso + süt + Baileys.",                            "300 ml",           "Tatlılığı dengele.",                "", CAT_ALCOHOLIC, "M"));

        // ICED
        ALL.add(new Recipe(R.drawable.cup_iced_latte,          "Iced Latte",                "Serin ve sütlü",                "Buz + süt + espresso.",                                 "300 ml",           "Buz önce bardağa.",                 "", CAT_ICED,      "M"));
        ALL.add(new Recipe(R.drawable.cup_iced_americano,      "Iced Americano",            "Serin ve uzun",                 "Buz + su + espresso.",                                  "350 ml",           "Suyu espresso’ya ekle.",            "", CAT_ICED,      "L"));
        ALL.add(new Recipe(R.drawable.cup_iced_mocha,          "Iced Mocha",                "Soğuk çikolatalı",              "Buz + süt + espresso + çikolata.",                      "300 ml",           "Sosu önce çöz.",                     "", CAT_ICED,      "M"));
        ALL.add(new Recipe(R.drawable.cup_iced_breve,          "Iced Breve",                "Zengin gövdeli soğuk",          "Buz + espresso + yarım krema.",                         "300 ml",           "Ağırlık dengesine dikkat.",         "", CAT_ICED,      "M"));
        ALL.add(new Recipe(R.drawable.cup_icedpour,            "Iced Pour-Over",            "Direkt buz üstüne",             "V60/pour-over sıcak demle, buz üstüne akıt.",           "300 ml",           "Oranı biraz yükselt (1:13).",       "", CAT_ICED,      "M"));
        ALL.add(new Recipe(R.drawable.cup_affogato_freddo,     "Affogato Freddo",           "Soğuk affogato",                "Soğuk espresso/dondurma versiyonu.",                    "150–200 ml",       "Dondurmayı en sonda koy.",          "", CAT_ICED,      "S/M"));

        // DİĞER ESPRESSO TÜREVLERİ (tamamlama)
        ALL.add(new Recipe(R.drawable.cup_cappucino_240ml,     "Cappuccino (2)",            "Köpük odaklı",                  "Tekrar isim varyasyonu (tamamlama).",                  "240 ml",           "Köpük oranı yüksek.",               "", CAT_ESPRESSO,  "240 ml"));
        ALL.add(new Recipe(R.drawable.cup_latte_300ml,         "Latte (2)",                 "Sütlü",                         "İkinci varyasyon (tamamlama).",                         "300 ml",           "Süt 60–65°C.",                      "", CAT_ESPRESSO,  "300 ml"));

        // ---- 5 TÜRK KAHVESİ VARYASYONU ----
        ALL.add(new Recipe(R.drawable.cup_t_70ml,              "Türk Kahvesi (Sade)",       "Köpüklü klasik",                "İnce çekim, cezvede 1–2 taşım.",                        "T – 70 ml",        "Soğuk su ile başla.",               "Lokumla servis.", CAT_TURKISH, "70 ml"));
        ALL.add(new Recipe(R.drawable.cup_t_70ml,              "Türk Kahvesi (Orta)",       "Orta şekerli",                  "Şeker eklenmiş klasik tarif.",                          "T – 70 ml",        "Şekeri başta çöz.",                 "", CAT_TURKISH,   "70 ml"));
        ALL.add(new Recipe(R.drawable.cup_t_70ml,              "Türk Kahvesi (Şekerli)",    "Tatlı, yoğun köpük",            "Daha fazla şekerle pişirilir.",                         "T – 70 ml",        "Taşırma, köpüğü koru.",             "", CAT_TURKISH,   "70 ml"));
        ALL.add(new Recipe(R.drawable.cup_t_70ml,              "Damla Sakızlı Türk Kahvesi","Aromatik dokunuş",              "Az miktar damla sakızı ile.",                           "T – 70 ml",        "Az kullan, aroma güçlü.",           "", CAT_TURKISH,   "70 ml"));
        ALL.add(new Recipe(R.drawable.cup_t_70ml,              "Dibek Kahvesi",             "İnce öğütüm benzeri",           "Döğülerek öğütülmüş, yumuşak içim.",                    "T – 70 ml",        "Kısık ateş tercih.",                "", CAT_TURKISH,   "70 ml"));
    }

    public static List<Recipe> getAll() {
        return Collections.unmodifiableList(ALL);
    }
}