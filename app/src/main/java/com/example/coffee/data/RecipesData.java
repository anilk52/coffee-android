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
                // Espresso
                recipes.add(new Recipe(
                        R.drawable.cup_espresso_70ml,
                        "Espresso",
                        "Kısa, yoğun ve dengeli kahve shot’ı.",
                        "Espresso, 18 g taze çekilmiş kahveden yaklaşık 36 g çıkışla hazırlanır. "
                                + "Makine 9 bar basınçta, 92–94 °C su sıcaklığıyla 25–30 saniye çalışmalıdır. "
                                + "Kahve medium roast olmalı, öğütme tuzdan biraz daha ince seçilmelidir. "
                                + "Doğru akış 3–5. saniyede başlamalı ve fincanda altın rengi, kalın bir krema tabakası oluşmalıdır. "
                                + "İyi çekilmiş bir espresso, dengeli asidite, gövde ve tatlılığı bir arada sunar ve yaklaşık 30 ml hacmindedir.",
                        "1:2 oran (18 g kahve → 36 g espresso)",
                        "Akış çok hızlıysa öğütmeyi incelt; çok yavaşsa biraz kalınlaştır. "
                                + "Kreması soluksa kahve çok taze olmayabilir.",
                        "Evde moka pot kullanarak espressoya yakın yoğunlukta kahve elde edebilirsin. "
                                + "Önemli olan taze çekirdek ve tutarlı ısı.",
                        "espresso",
                        "S – 30 ml"
                ));

                // Doppio
                recipes.add(new Recipe(
                        R.drawable.cup_doppio_120ml,
                        "Doppio",
                        "İki shot’lık güçlü espresso.",
                        "Doppio, iki espresso shot’ının birleşimidir. "
                                + "Genellikle 36 g kahveden 60–70 g arası çıkış alınır. "
                                + "Aynı şekilde 9 bar basınç ve 92–94 °C su sıcaklığı kullanılır, süre yine 25–30 saniye civarındadır. "
                                + "Daha yüksek kafein ve daha yoğun gövde sunar; uzun içim sevenler için idealdir.",
                        "1:2 oran (36 g kahve → 70 g shot civarı)",
                        "Fincan hacmini ona göre seç; çok küçük fincanda çift shot taşabilir.",
                        "Evde iki kez moka pot demleyerek benzer yoğunlukta bir doppio yaratabilirsin.",
                        "espresso",
                        "M – 60 ml"
                ));

                // Americano
                recipes.add(new Recipe(
                        R.drawable.cup_americano_350ml,
                        "Americano",
                        "Espresso’nun sıcak suyla yumuşatılmış hali.",
                        "Americano, bir shot espresso (30 ml) üzerine yaklaşık 90 ml sıcak su eklenerek hazırlanır. "
                                + "Tat profili filtre kahveye yaklaşır ancak gövdesi biraz daha dolgun kalır. "
                                + "Daha hafif içim için su miktarını artırabilir, daha yoğun tat için doppio kullanabilirsin.",
                        "1 shot espresso + 90 ml sıcak su",
                        "Kremayı korumak için önce sıcak suyu ekle, sonra espressoyu üzerine dök.",
                        "Evde kettle + moka pot ile çok benzer bir Americano elde edebilirsin.",
                        "espresso",
                        "M – 120 ml"
                ));

                // Cappuccino
                recipes.add(new Recipe(
                        R.drawable.cup_cappucino_240ml, // dosya ismi cappucino
                        "Cappuccino",
                        "Köpüklü sütle klasik İtalyan kahvesi.",
                        "Cappuccino, 1 shot espresso (30 ml), yaklaşık 60 ml sıcak süt ve 60 ml yoğun süt köpüğüyle hazırlanır. "
                                + "Toplam hacim 150–180 ml civarındadır. "
                                + "Köpük kalın ve kremamsı olmalı, yüzeyde kadifemsi bir doku hissedilmelidir. "
                                + "İdeal süt sıcaklığı 60–65 °C aralığındadır; daha yüksek sıcaklıkta süt yanık bir tat bırakır.",
                        "1 espresso + 1 birim süt + 1 birim süt köpüğü",
                        "Sütü ısıtırken sürahiyi elinle tutup çok yakıcı olmamasına dikkat et; "
                                + "elini 3–4 saniyeden fazla üzerinde tutamıyorsan süt fazla ısınmıştır.",
                        "Evde french press veya elde çırpıcı kullanarak da güzel bir köpük elde edebilirsin.",
                        "espresso",
                        "M – 180 ml"
                ));

                // Latte
                recipes.add(new Recipe(
                        R.drawable.cup_latte_300ml,
                        "Caffè Latte",
                        "Bol sütlü, yumuşak içimli kahve.",
                        "Caffè Latte, 1 shot espresso (30 ml) üzerine yaklaşık 180–210 ml sıcak süt eklenerek hazırlanır. "
                                + "Üstünde ince bir mikroköpük tabakası bulunur. "
                                + "Tatlı, süt ağırlıklı ve oldukça yumuşak bir profili vardır. "
                                + "Latte art yapmak için ideal zemindir.",
                        "1:6 oran (30 ml espresso → ~180 ml süt)",
                        "Sütü köpürtürken çok fazla kabartma; latte’de ince ve ipeksi bir tabaka yeterlidir.",
                        "Evde french press ile sütü hafifçe köpürtüp latte hissiyatını yakalayabilirsin.",
                        "espresso",
                        "L – 240–300 ml"
                ));

                // Flat White
                recipes.add(new Recipe(
                        R.drawable.cup_flatwhite_240ml,
                        "Flat White",
                        "Yoğun espresso, ince mikroköpüklü süt dengesi.",
                        "Flat White genelde 2 shot espresso (doppio) ve 120–140 ml civarında mikroköpüklü süt ile yapılır. "
                                + "Köpük katmanı çok ince olmalı; latte’ye göre daha kahve yoğun, cappuccino’ya göre daha az köpüklüdür.",
                        "2 shot espresso + ~130 ml süt",
                        "Süt köpüğünü cappuccino kadar kalın yapma; yüzeyde ince ve parlak bir tabaka yeterli.",
                        "Evde iki moka shot + süt ile benzer bir yoğunluk yakalanabilir.",
                        "espresso",
                        "M – 180 ml"
                ));

                // Macchiato
                recipes.add(new Recipe(
                        R.drawable.cup_macchiato_120ml,
                        "Macchiato",
                        "Espresso üzerine nokta kadar süt köpüğü.",
                        "Macchiato, 1 shot espresso üzerine sadece 1–2 tatlı kaşığı süt köpüğü eklenerek hazırlanır. "
                                + "Kahve baskın kalır, süt sadece aromayı yuvarlar. "
                                + "Kelime anlamı İtalyanca ‘lekeli’ veya ‘işaretlenmiş’tir.",
                        "1 espresso + 1–2 tatlı kaşığı süt köpüğü",
                        "Köpük miktarını abartma; yoksa küçük bir cappuccino’ya dönüşür.",
                        "Evde espresso veya moka shot üzerine az miktar köpüklü süt eklemek yeterli.",
                        "espresso",
                        "S – 40–50 ml"
                ));

                // Cortado
                recipes.add(new Recipe(
                        R.drawable.cup_cortado_150ml,
                        "Cortado",
                        "Espresso ve süt 1:1 oranında, dengeli içim.",
                        "Cortado, 1 shot espresso (30 ml) ile aynı miktarda (30 ml) sıcak süt karıştırılarak yapılır. "
                                + "Asidite yumuşar ancak kahve tadı belirgin kalır. "
                                + "İspanyol kökenli bu içecek, latte’nin daha küçük ve daha yoğun bir versiyonu gibidir.",
                        "1:1 oran (30 ml espresso + 30 ml süt)",
                        "Sıcak sütü fazla köpürtme; cortado’nun olayı, kremamsı ama ince bir süt tabakasıdır.",
                        "Evde küçük bir cam bardakta moka shot + az süt ile kolayca hazırlanabilir.",
                        "espresso",
                        "S – 60 ml"
                ));

                // Mocha
                recipes.add(new Recipe(
                        R.drawable.cup_mochacino_300ml, // mocha için en yakın görsel
                        "Caffè Mocha",
                        "Çikolatalı, tatlı ve kremalı kahve.",
                        "Caffè Mocha, 1 shot espresso, 20–25 g çikolata sosu veya kakao karışımı "
                                + "ve 150–180 ml sıcak sütle hazırlanır. "
                                + "Espresso ile çikolata önce karıştırılır, ardından süt eklenir ve hafif köpükle tamamlanır. "
                                + "Üzerine kakao serpiştirilebilir veya çikolata rendesi eklenebilir.",
                        "1 espresso + 20–25 g çikolata + 150–180 ml süt",
                        "Çikolata sosu çok yoğun ise süt miktarını artırarak dengele.",
                        "Evde hazır çikolata tozu veya sürülebilir çikolata (ör. Nutella) ile nefis mocha yapabilirsin.",
                        "espresso",
                        "L – 220–260 ml"
                ));

                // Ristretto
                recipes.add(new Recipe(
                        R.drawable.cup_ristretto_50ml,
                        "Ristretto",
                        "Kısa ekstraksiyonlu, süper yoğun espresso.",
                        "Ristretto, aynı miktarda kahve kullanılıp daha kısa sürede ve daha az hacimde alınan bir shot’tır. "
                                + "Genellikle 18 g kahveden 15–20 ml arası çıkış alınır. "
                                + "Süre 15–18 saniye civarındadır. "
                                + "Sonuç; tatlı, yoğun ve düşük acılı, güçlü bir kahve deneyimidir.",
                        "18 g kahve → 15–20 ml shot",
                        "Ristretto’da akışı erken kesersin; çok uzatırsan normal espressoya döner.",
                        "Evde espresso makinesinde shot’ı zamanından biraz önce durdurarak kolayca deneyebilirsin.",
                        "espresso",
                        "XS – 20 ml"
                ));

                break;
        }

        return recipes;
    }
}