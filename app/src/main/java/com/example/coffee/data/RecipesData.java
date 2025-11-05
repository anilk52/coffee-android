package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;
import java.util.ArrayList;
import java.util.List;

public class RecipesData {

    public static List<Recipe> getRecipesByCategory(String category) {
        List<Recipe> recipes = new ArrayList<>();

        switch (category.toLowerCase()) {

            // ------------------------------------------------------
            // ☕ ESPRESSO KATEGORİSİ
            // ------------------------------------------------------
            case "espresso":
                recipes.add(new Recipe(
                        R.drawable.espresso,
                        "Espresso",
                        "Kısa, yoğun ve dengeli kahve shot’ı.",
                        "Espresso, 18 g taze çekilmiş kahveden 36 g çıkışla hazırlanır. "
                        + "Makine 9 bar basınçta, 92–94 °C su sıcaklığıyla 25–30 saniye çalışmalıdır. "
                        + "Kahve medium roast olmalı, öğütme tuzdan biraz daha ince olmalıdır. "
                        + "Doğru akış 3 saniyede başlamalı ve altın rengi kalın bir krema oluşmalıdır. "
                        + "İdeal espresso yaklaşık 30 ml’dir.",
                        "1:2 oran (18 g kahve → 36 g espresso)",
                        "Krema soluksa öğütmeyi incelt; çok koyuysa kahve yanmıştır.",
                        "Evde moka pot veya espresso makinesiyle deneyebilirsin.",
                        "espresso",
                        "S – 30 ml"
                ));

                recipes.add(new Recipe(
                        R.drawable.doppio,
                        "Doppio",
                        "İki shot’lık güçlü espresso.",
                        "Doppio, iki espresso shot’ının birleşimidir. "
                        + "36 g kahveyle yaklaşık 60 ml espresso elde edilir. "
                        + "9 bar basınçta, 93 °C sıcak suyla 25–30 saniyede hazırlanır. "
                        + "Yoğun gövde ve belirgin kafein etkisi sunar.",
                        "1:2 oran (36 g kahve → 72 g shot)",
                        "Kahve fazla acıysa öğütmeyi kalınlaştır.",
                        "Evde moka potta kahve miktarını iki katına çıkararak deneyebilirsin.",
                        "espresso",
                        "M – 60 ml"
                ));

                recipes.add(new Recipe(
                        R.drawable.americano,
                        "Americano",
                        "Espresso’nun sıcak suyla yumuşatılmış hali.",
                        "Americano, 30 ml espresso üzerine 90 ml sıcak su eklenerek yapılır. "
                        + "Tat profili filtre kahveye yaklaşır ama daha yumuşak içimlidir. "
                        + "Kafe miktarını artırmak için Doppio da kullanılabilir.",
                        "1 shot espresso + 90 ml su",
                        "Önce suyu ekle, ardından espressoyu dök — kremayı korur.",
                        "Evde kettle ve espresso/moka pot yeterli.",
                        "espresso",
                        "M – 120 ml"
                ));

                recipes.add(new Recipe(
                        R.drawable.cappuccino,
                        "Cappuccino",
                        "Köpüklü sütle klasik İtalyan kahvesi.",
                        "1 shot espresso (30 ml) üzerine 90 ml sıcak süt ve 60 ml süt köpüğü eklenir. "
                        + "Köpük kalın olmalı, yüzeyi ipeksi görünmelidir. "
                        + "İdeal sıcaklık 65 °C civarındadır.",
                        "1:3 oran (1 espresso, 3 süt)",
                        "Sütü fazla ısıtırsan tat yanar — 70 °C’yi geçme.",
                        "Evde süt köpürtücüyle mükemmel doku yakalanabilir.",
                        "espresso",
                        "M – 180 ml"
                ));

                recipes.add(new Recipe(
                        R.drawable.latte,
                        "Caffè Latte",
                        "Daha fazla süt, yumuşak içim.",
                        "Espresso üzerine 180 ml sıcak süt eklenir ve 10–15 ml mikroköpükle tamamlanır. "
                        + "Tatlı, dengeli ve süt ağırlıklıdır. "
                        + "Yüzeyine latte art desen yapılabilir.",
                        "1:6 oran (30 ml espresso, 180 ml süt)",
                        "Köpüklemeden önce sütü havalandır, ipeksi kıvam oluştur.",
                        "Evde french press’le sütü köpürterek benzer doku elde edebilirsin.",
                        "espresso",
                        "L – 210 ml"
                ));

                recipes.add(new Recipe(
                        R.drawable.flatwhite,
                        "Flat White",
                        "Yoğun espresso ve ince süt kreması dengesi.",
                        "Doppio (60 ml) espresso üzerine 120 ml mikro köpüklü süt eklenir. "
                        + "Köpük neredeyse yoktur, süt ipeksi bir tabaka oluşturur. "
                        + "Tat profili latte’den daha kahve yoğundur.",
                        "1:2 oran (espresso : süt)",
                        "Köpük çok olursa cappuccino’ya dönüşür, dikkat et.",
                        "Evde french press sütü iki kez bastırarak mikro köpük elde et.",
                        "espresso",
                        "M – 180 ml"
                ));

                recipes.add(new Recipe(
                        R.drawable.macchiato,
                        "Macchiato",
                        "Espresso üzerine nokta kadar süt köpüğü.",
                        "Espresso üzerine sadece 1 tatlı kaşığı süt köpüğü eklenir. "
                        + "Kahve yoğun kalır, süt aroması hafifçe hissedilir. "
                        + "İtalyanca 'lekeli' anlamına gelir.",
                        "1 shot espresso + 1 tatlı kaşığı süt köpüğü",
                        "Köpüğü fazla koyarsan mini cappuccino olur.",
                        "Evde espresso shot’ına süt köpüğü ekleyebilirsin.",
                        "espresso",
                        "S – 40 ml"
                ));

                recipes.add(new Recipe(
                        R.drawable.cortado,
                        "Cortado",
                        "Espresso ve süt eşit miktarda, dengeli tat.",
                        "1 shot espresso (30 ml) + 30 ml sıcak süt. "
                        + "Asidite yumuşar, kahve tadı belirgin kalır. "
                        + "İspanyol kökenlidir.",
                        "1:1 oran",
                        "Latte’ye göre daha güçlü, cappuccino’ya göre daha az köpüklü.",
                        "Evde moka shot + sıcak süt karışımıyla benzer tat yakalanır.",
                        "espresso",
                        "S – 60 ml"
                ));

                recipes.add(new Recipe(
                        R.drawable.mocha,
                        "Caffè Mocha",
                        "Çikolatalı, tatlı ve kremalı kahve.",
                        "Espresso üzerine 20 g kakao şurubu veya eritilmiş çikolata eklenir, "
                        + "ardından 150 ml sıcak süt dökülür ve hafif süt köpüğüyle tamamlanır. "
                        + "Üzerine kakao veya çikolata rendesi serpilir.",
                        "1 espresso + 150 ml süt + 20 g çikolata",
                        "Kakao tozunu doğrudan espressoya karıştırarak acılık dengele.",
                        "Evde Nutella + süt + moka shot mükemmel olur.",
                        "espresso",
                        "L – 200 ml"
                ));

                recipes.add(new Recipe(
                        R.drawable.ristretto,
                        "Ristretto",
                        "Kısa ekstraksiyonlu yoğun espresso.",
                        "Aynı kahve miktarıyla ama yarı süre ve hacimde (yaklaşık 15–20 ml) yapılır. "
                        + "Tat olarak daha tatlı ve kremalıdır. "
                        + "Basınç 9 bar, süre 15–18 saniye civarındadır.",
                        "18 g kahve → 18–20 ml shot",
                        "Tatlı ama yoğun — espressoya göre daha az acı.",
                        "Evde espresso makinesinde erken shot keserek deneyebilirsin.",
                        "espresso",
                        "XS – 20 ml"
                ));
                break;
        }

        return recipes;
    }
}