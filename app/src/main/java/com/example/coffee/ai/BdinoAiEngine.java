package com.example.coffee.ai;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * bdinoᴼ Coffee - BrewAi Engine
 *
 * Basit, offline çalışan, kahve odaklı kural tabanlı cevap motoru.
 * Bulut istemiyor, internet istemiyor; sadece metin bazlı çalışıyor.
 */
public class BdinoAiEngine {

    private static BdinoAiEngine instance;

    public static synchronized BdinoAiEngine getInstance(Context context) {
        if (instance == null) {
            instance = new BdinoAiEngine(context.getApplicationContext());
        }
        return instance;
    }

    private final Context appContext;

    private BdinoAiEngine(Context ctx) {
        this.appContext = ctx;
    }

    /**
     * BrewAi ile tek bir dönüşümlük sohbet.
     *
     * @param userMessage   Kullanıcının mesajı
     * @param previousState Önceki sohbet durumu (yoksa null)
     * @return BrewAiReply (cevap + yeni durum)
     */
    public BrewAiReply chatOnce(String userMessage, BrewAiConversationState previousState) {
        if (userMessage == null) {
            userMessage = "";
        }

        String trimmed = userMessage.trim();
        if (trimmed.isEmpty()) {
            String msg = "Önce bana bir şey sor, sonra kahve muhabbeti başlasın ☕";
            BrewAiConversationState state = previousState != null
                    ? previousState
                    : BrewAiConversationState.start();
            return new BrewAiReply(msg, state, true);
        }

        String lower = trimmed.toLowerCase(Locale.ROOT);
        String answer = generateAnswer(lower);

        // Sohbet geçmişini güncelle
        BrewAiConversationState newState = (previousState == null)
                ? BrewAiConversationState.start().nextTurn(trimmed, answer)
                : previousState.nextTurn(trimmed, answer);

        return new BrewAiReply(answer, newState, true);
    }

    /**
     * Asıl cevap üretim mantığı.
     * Burada zamanla daha çok kural / şablon ekleyebiliriz.
     */
    private String generateAnswer(String lower) {
        // Selamlaşma
        if (containsAny(lower, "selam", "merhaba", "hey", "naber", "napıyorsun", "ne yapıyorsun")) {
            return "Buradayım, kahve düşünüyorum tabii ki ☕\n"
                    + "İstersen bugün ne içeceğine birlikte karar verelim.";
        }

        // Ne içsem?
        if (containsAny(lower, "ne içsem", "ne önerirsin", "öner", "kahve tavsiye", "bugün ne içeyim")) {
            return "Bugünkü ruh haline göre seçelim:\n\n"
                    + "• Hafif ve yumuşak istersen: Latte veya flat white.\n"
                    + "• Yoğun ve kısa olsun dersen: Doppio espresso.\n"
                    + "• Ferahlatıcı bir şey istersen: Iced latte veya cold brew.\n"
                    + "• Tatlı bir şey canın çekiyorsa: Caramel latte veya mocha.\n\n"
                    + "İstersen ekipmanını söyle (moka pot, french press, espresso makinesi gibi), "
                    + "sana oraya özel bir tarif de önerebilirim.";
        }

        // Latte soruları
        if (lower.contains("latte")) {
            return "Latte için temel reçete şöyle:\n\n"
                    + "• 18 g espresso (1 shot, 25–30 sn arası akış)\n"
                    + "• Yaklaşık 220–250 ml süt\n"
                    + "• İnce, kadifemsi mikro köpük (çok kalın değil)\n\n"
                    + "Aroma eklemek istersen genelde 20 ml şurup iyi bir başlangıç noktası:\n"
                    + "• Vanilya latte → 20 ml vanilya şurubu\n"
                    + "• Caramel latte → 15–20 ml karamel şurubu\n"
                    + "• Hazelnut latte → 15 ml fındık şurubu\n"
                    + "• Lotus / Biscoff → 1 tatlı kaşığı ufalanmış bisküvi + biraz karamel\n\n"
                    + "Evde hangi ekipman var, söyle istersen, oraya göre daha net tarif verebilirim.";
        }

        // Mocha soruları
        if (lower.contains("mocha") || lower.contains("moka") || lower.contains("white mocha")) {
            return "Mocha aslında çikolatalı bir latte gibi düşünebilirsin:\n\n"
                    + "• 1 shot espresso (18–20 g kahve)\n"
                    + "• 15–25 g çikolata sosu veya kaliteli kakao karışımı\n"
                    + "• 200–220 ml süt\n\n"
                    + "White mocha için tek fark çikolata kısmını beyaz çikolata ile yapman.\n"
                    + "Tatlı seviyorsan önce 20 g civarında dene, sonra damak tadına göre artırıp azaltırsın.";
        }

        // Espresso çok acı / ekşi
        if (containsAny(lower, "espresso", "ristretto", "doppio")) {
            if (containsAny(lower, "acı", "çok acı", "yanık")) {
                return "Espresso çok acı geliyorsa birkaç ihtimal var:\n\n"
                        + "• Öğütüm çok ince olabilir → akış süresi 30 sn’yi geçiyorsa biraz kalınlaştır.\n"
                        + "• Demleme süresi uzun olabilir → 25–30 sn arası tutmaya çalış.\n"
                        + "• Kahve çok koyu kavrulmuş olabilir → daha açık kavrum dene.\n\n"
                        + "Akış süreni ve öğütümünü söylersen, daha net yorum yapabilirim.";
            }
            if (containsAny(lower, "ekşi", "sour", "mayhoş")) {
                return "Espresso ekşi geliyorsa genelde:\n\n"
                        + "• Öğütüm fazla kalındır → akış çok hızlıdır (15–20 sn gibi).\n"
                        + "• Demleme süresi kısadır → 25 sn altına düşüyorsa biraz incelt.\n"
                        + "• Kahve çok taze olabilir → yeni kavrulmuş kahve için 5–7 gün dinlenme iyi olur.\n\n"
                        + "Ekipmanını ve sürelerini biliyorsan yaz, birlikte ince ayar yapalım.";
            }
        }

        // Türk kahvesi
        if (containsAny(lower, "türk kahvesi", "turk kahvesi", "cezve")) {
            return "Türk kahvesi için basit ama kritik birkaç nokta var:\n\n"
                    + "• Su: Soğuk içme suyu kullan.\n"
                    + "• Oran: 1 fincan için 1 dolu tatlı kaşığı kahve iyi başlama noktasıdır.\n"
                    + "• Şeker: Pişmeden önce eklenir, karıştırılır, sonra bir daha karıştırılmaz.\n"
                    + "• Isı: Orta-düşük ısıda ağır ağır kabarsın; taşmadan hemen önce al.\n\n"
                    + "Köpük istiyorsan, çok karıştırma ve kaynatmadan hemen önce ocaktan alman önemli.";
        }

        // Ekipmana göre soru
        if (containsAny(lower, "v60", "chemex", "aeropress", "french press", "moka pot", "mokapot")) {
            return "Demleme ekipmanına göre oran seçmek çok önemli. Genel öneriler:\n\n"
                    + "• V60 → 1:15–1:16 (1 g kahve / 15–16 g su)\n"
                    + "• Chemex → 1:16–1:17, biraz daha temiz bir fincan verir\n"
                    + "• French press → 1:15 civarı, kalın öğütüm\n"
                    + "• Moka pot → Orta-ince öğütüm, hazneyi tam doldur, suyu emniyet vanasına kadar.\n"
                    + "• Aeropress → 1:12–1:15, reçeteye göre değişir.\n\n"
                    + "İstersen bir tanesini seç, sana adım adım reçete yazayım.";
        }

        // “Bugün moralim bozuk / yorgunum”
        if (containsAny(lower, "moralim bozuk", "yorgunum", "keyifsizim", "modum düşük", "canım sıkkın")) {
            return "O zaman kahve sadece içecek değil, küçük bir ritüel olsun ☕\n\n"
                    + "• Çok yormadan: Sade bir latte veya sıcak çikolata iyi gider.\n"
                    + "• Biraz silkelenmek istersen: Doppio espresso + küçük bir su.\n"
                    + "• Uzun uzun içeyim diyorsan: Hafif kavrum bir filtre kahve.\n\n"
                    + "İstersen evde neler olduğunu söyle, ona göre sana küçük bir ‘iyi hisset’ tarifi hazırlayayım.";
        }

        // Genel fallback
        return "Anladığım kadarıyla kahveyle ilgili bir şeyler düşünüyorsun ama tam olarak ne istediğini çözemedim 😅\n\n"
                + "Benden isteyebileceğin şeylere birkaç örnek vereyim:\n"
                + "• “Evde V60 ile nasıl kahve yaparım?”\n"
                + "• “White chocolate mocha tarifi yazar mısın?”\n"
                + "• “Sütü doğru nasıl köpürtürüm?”\n"
                + "• “Bugün ne içsem?”\n\n"
                + "Şimdi bir tanesini seç ya da aklına geleni sor, devam edelim.";
    }

    private boolean containsAny(String text, String... words) {
        for (String w : words) {
            if (text.contains(w)) return true;
        }
        return false;
    }

    /**
     * BrewAi sohbet durumu: Basitçe soru-cevap geçmişini tutar.
     */
    public static class BrewAiConversationState {
        private final List<String> history;

        private BrewAiConversationState(List<String> history) {
            this.history = history;
        }

        public static BrewAiConversationState start() {
            return new BrewAiConversationState(new ArrayList<>());
        }

        public BrewAiConversationState nextTurn(String user, String ai) {
            List<String> copy = new ArrayList<>(history);
            copy.add("Sen: " + user);
            copy.add("BrewAi: " + ai);
            return new BrewAiConversationState(copy);
        }

        public List<String> getHistory() {
            return history;
        }
    }

    /**
     * BrewAi cevabı: Metin + yeni durum + başarı bilgisi.
     */
    public static class BrewAiReply {
        public final String answer;
        public final BrewAiConversationState newState;
        public final boolean ok;

        public BrewAiReply(String answer, BrewAiConversationState newState, boolean ok) {
            this.answer = answer;
            this.newState = newState;
            this.ok = ok;
        }
    }
}