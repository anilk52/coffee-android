package com.example.coffee.ai;

import android.content.Context;

import java.util.Locale;

/**
 * BDINO Coffee – MiLO AI Barista (offline, kurallı motor)
 *
 * Hiçbir şekilde internet / bulut kullanmaz.
 * Gelen kullanıcı mesajına göre kahve odaklı cevap üretir.
 */
public class BdinoAiEngine {

    private static BdinoAiEngine INSTANCE;

    public static BdinoAiEngine getInstance(Context context) {
        // Şu an context kullanmıyoruz ama ilerde TTS vb. için lazım olabilir
        if (INSTANCE == null) {
            INSTANCE = new BdinoAiEngine();
        }
        return INSTANCE;
    }

    // Eski kodun çağırdığı ama artık iş yapmayan fonksiyon (compat için)
    public void initOfflineModelIfNeeded() {
        // Şu anlık hiçbir şey yapmıyor
    }

    /**
     * MiLO'nun vereceği cevabı üretir.
     *
     * @param userMessage Kullanıcı mesajı
     * @param coffeeName  Seçili kahvenin adı (tarif ekranından geliyorsa)
     * @param description Tarif açıklaması
     * @param measure     Ölçü bilgisi
     * @param size        Bardak boyutu
     * @param tip         Barista ipucu
     * @param note        Ek not
     * @return MiLO'nun cevap metni (sadece String)
     */
    public String generateReply(
            String userMessage,
            String coffeeName,
            String description,
            String measure,
            String size,
            String tip,
            String note
    ) {
        if (userMessage == null) userMessage = "";
        String msg = userMessage.trim();
        String lower = msg.toLowerCase(Locale.getDefault());

        String answer;

        // 1) SELAM / NE YAPIYORSUN / NASILSIN
        if (lower.contains("ne yapıyorsun") ||
                lower.contains("napıyosun") ||
                lower.contains("napıyon") ||
                lower.contains("nasılsın") ||
                lower.startsWith("selam") ||
                lower.startsWith("merhaba") ||
                lower.contains("günaydın") ||
                lower.contains("iyi akşamlar") ||
                lower.contains("iyi geceler")) {

            answer =
                    "Buradayım, demlemeler üzerine düşünüyorum ☕. " +
                    "Bugün kupanda nasıl bir ruh hali olsun istiyorsun; hafif, dengeli mi, yoksa sert bir şey mi?";
        }

        // 2) RUH HALİ / HAVA / ZAMAN
        else if (lower.contains("yağmur") ||
                 lower.contains("hava") ||
                 lower.contains("moral") ||
                 lower.contains("canım sıkkın") ||
                 lower.contains("üzgün") ||
                 lower.contains("üşüyorum") ||
                 lower.contains("akşam") ||
                 lower.contains("sabah") ||
                 lower.contains("gece")) {

            if (lower.contains("yağmur")) {
                answer =
                        "Yağmurlu havada hafif gövdeli ama sıcak bir şey iyi gider. " +
                        "V60 veya Chemex gibi temiz içimli demlemeler yağmur sesine çok yakışır. " +
                        "Biraz daha konfor istiyorsan sütlü bir latte de güzel olur.";
            } else if (lower.contains("moral") || lower.contains("canım sıkkın") || lower.contains("üzgün")) {
                answer =
                        "Moral düşükken hafif tatlı ve yumuşak kahveler iyi gelir. " +
                        "Flat White, Mocha veya beyaz çikolatalı bir içecek modunu yükseltebilir ☕✨";
            } else if (lower.contains("gece") || lower.contains("akşam")) {
                answer =
                        "Akşam/gece saatlerinde uykunu çok bozmayacak şeyler iyi olur. " +
                        "Kısa bir espresso, hafif bir pour-over ya da mümkünse kafeinsiz çekirdek tercih edebilirsin.";
            } else if (lower.contains("sabah")) {
                answer =
                        "Sabah için net ve ayıltan bir profil iyi gider. " +
                        "Doppio, lungo veya French Press gibi gövdeli demlemeler güne başlaman için ideal.";
            } else {
                answer =
                        "Ruh haline göre kahve seçebiliriz. " +
                        "\"Hafif\", \"dengeli\" ya da \"sert\" diye yaz; sana göre bir şey önereyim.";
            }
        }

        // 3) KAHVE DIŞI KONULAR (müzik, film, futbol vs.)
        else if (!(lower.contains("kahve") ||
                   lower.contains("espresso") ||
                   lower.contains("latte") ||
                   lower.contains("mocha") ||
                   lower.contains("americano") ||
                   lower.contains("demle") ||
                   lower.contains("filtre") ||
                   lower.contains("shot") ||
                   lower.contains("brew"))) {

            answer =
                    "Ben kahve konusunda uzman bir baristayım ☕. " +
                    "Film, futbol yerine sana damak zevkine göre harika bir kahve seçebilirim. " +
                    "Nasıl bir tat arıyorsun: yoğun mu, hafif mi, sütlü mü, yoksa tatlı mı?";
        }

        // 4) TARİF İSTEĞİ (nasıl yapılır / tarif)
        else if (lower.contains("nasıl yapılır") ||
                 lower.contains("tarif") ||
                 lower.startsWith("nasıl") ||
                 lower.contains("yapımı") ||
                 lower.contains("recipe")) {

            // White chocolate mocha özel case'i:
            if (lower.contains("white chocolate mocha") ||
                lower.contains("white mocha") ||
                lower.contains("beyaz çikolatalı mocha") ||
                lower.contains("beyaz çikolatalı latte")) {

                answer =
                        "Evde basit bir White Chocolate Mocha için:\n\n" +
                        "1) Espresso: 1 shot (18–20 g kahve, 25–30 sn akış).\n" +
                        "2) Beyaz çikolata: 2 yemek kaşığı beyaz çikolata sosu veya benmari eritilmiş beyaz çikolata.\n" +
                        "3) Süt: 180–200 ml sütü ısıt ve latte köpüğü olacak şekilde köpürt.\n" +
                        "4) Hazırlama:\n" +
                        "   • Bardağın dibine beyaz çikolatayı koy.\n" +
                        "   • Üzerine espressoyu ekle ve iyice karıştır.\n" +
                        "   • Köpürttüğün sütü yavaşça üzerine dök.\n" +
                        "   • İstersen üstüne rendelenmiş beyaz çikolata veya krema ekleyebilirsin.\n\n" +
                        "Tat ağır gelirse beyaz çikolatayı azalt, hafif gelirse bir kaşık daha ekleyebilirsin.";
            } else {
                String baseName = (coffeeName == null || coffeeName.isEmpty())
                        ? "kahve"
                        : coffeeName;

                StringBuilder sb = new StringBuilder();
                sb.append(baseName).append(" için basit bir reçete çerçevesi vereyim:\n\n");

                if (description != null && !description.isEmpty()) {
                    sb.append("• Profil: ").append(description).append("\n\n");
                }
                if (measure != null && !measure.isEmpty()) {
                    sb.append("• Ölçü / oran: ").append(measure).append("\n");
                }
                if (size != null && !size.isEmpty()) {
                    sb.append("• Bardak boyutu: ").append(size).append("\n\n");
                }

                sb.append("Genel adımlar:\n");
                sb.append("1) Taze çekilmiş kahve kullan. Öğütüm, demleme yöntemine uygun olmalı.\n");
                sb.append("2) Suyu kaynama noktasının biraz altında (90–96°C) kullan.\n");
                sb.append("3) Her seferinde tek bir parametreyi değiştir (öğütüm, oran ya da süre).\n");

                if (tip != null && !tip.isEmpty()) {
                    sb.append("\nBarista ipucum: ").append(tip).append("\n");
                }
                if (note != null && !note.isEmpty()) {
                    sb.append("Ek not: ").append(note).append("\n");
                }

                answer = sb.toString();
            }
        }

        // 5) TAT AYARI / PROBLEM ÇÖZME
        else if (lower.contains("çok hafif") ||
                 lower.contains("hafif oldu") ||
                 lower.contains("acı oldu") ||
                 lower.contains("çok acı") ||
                 lower.contains("sert oldu") ||
                 lower.contains("çok sert") ||
                 lower.contains("ekşi oldu") ||
                 lower.contains("tatsız") ||
                 lower.contains("yavan")) {

            answer =
                    "Tadı düzeltmek için birkaç temel ayar var. Her seferinde sadece birini değiştirmen en iyisi:\n\n" +
                    "1) Çok hafif / yavan ise:\n" +
                    "   • Öğütümü biraz daha ince yap.\n" +
                    "   • Demleme süresini hafif uzat.\n" +
                    "   • Kahve miktarını az da olsa artır.\n\n" +
                    "2) Çok acı / sert ise:\n" +
                    "   • Öğütümü biraz daha kalınlaştır.\n" +
                    "   • Demleme süresini kısalt.\n" +
                    "   • Çok koyu kavrum kullanıyorsan bir tık daha açık kavrum dene.\n\n" +
                    "3) Ekşi ise:\n" +
                    "   • Öğütümü biraz incelt ve demleme süresini artır (özellikle espresso için).\n" +
                    "   • Su sıcaklığının çok düşük olmadığından emin ol (90–96°C).\n\n" +
                    "Aynı çekirdekle 3–4 denemede, bu küçük ayarlarla kendi ideal fincanını bulursun.";
        }

        // 6) GENEL KAHVE SORULARI
        else {
            String baseName = (coffeeName == null || coffeeName.isEmpty())
                    ? "kahven"
                    : coffeeName;

            StringBuilder sb = new StringBuilder();
            sb.append("Şöyle yapalım, ").append(baseName).append(" için küçük bir rehber vereyim:\n\n");

            if (description != null && !description.isEmpty()) {
                sb.append("• Profil: ").append(description).append("\n\n");
            }
            if (measure != null && !measure.isEmpty()) {
                sb.append("• Önerilen ölçü: ").append(measure).append("\n");
            }
            if (size != null && !size.isEmpty()) {
                sb.append("• Bardak boyutu: ").append(size).append("\n\n");
            }
            if (tip != null && !tip.isEmpty()) {
                sb.append("Barista ipucu: ").append(tip).append("\n\n");
            }
            if (note != null && !note.isEmpty()) {
                sb.append("Ek not: ").append(note).append("\n\n");
            }

            sb.append("Eğer tadı istediğin gibi değilse bana sadece \"daha yoğun\", \"daha yumuşak\" " +
                    "veya \"daha tatlı\" de; parametreleri birlikte ayarlayalım.");

            answer = sb.toString();
        }

        return answer;
    }
}