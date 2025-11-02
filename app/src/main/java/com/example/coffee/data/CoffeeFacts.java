package com.example.coffee.data;

import java.util.Random;

public final class CoffeeFacts {
    private static final String[] FACTS = new String[]{
            "Flat White, Avustralya ve Yeni Zelanda kahve kültürünün ikonik içeceğidir.",
            "Espresso, 25–30 saniyelik ekstraksiyon aralığında en dengeli tadı verir.",
            "Türk kahvesi telvesiyle servis edilir ve dünyadaki en ince öğütüm türünü kullanır.",
            "Chemex filtresi kâğıdı kalındır; gövdeyi azaltıp berraklık sağlar.",
            "V60’ta su döküş açısı ve akış hızı, asidite/ gövde dengesini belirler.",
            "Moka pot, basınçlı buharla kahveyi üst hazneye iter; ince ama espresso kadar değil.",
            "Latte art için süt ~55–60°C aralığında daha tatlı ve parlak olur.",
            "Sifon (Syphon) vakum prensibiyle çalışır; temiz ama aromatik bir gövde sunar.",
            "French press demleme süresi tipik olarak 4 dakikadır; fazla süre acılık verir.",
            "Kahve kavrumu açıldıkça asidite artar, koyulaştıkça gövde ve acılık artar."
    };

    private static final Random RNG = new Random();

    private CoffeeFacts(){}

    public static String random() {
        int i = RNG.nextInt(FACTS.length);
        return FACTS[i];
    }
}