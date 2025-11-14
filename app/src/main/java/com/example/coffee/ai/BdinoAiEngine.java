package com.example.coffee.ai;

import android.content.Context;
import android.text.TextUtils;

/**
 * BDINO Coffee için AI katmanı.
 *
 * Şu an:
 *  - Prompt üretir (LLM'e verilecek metin).
 *  - Kural tabanlı (rule-based) "fake AI" cevap oluşturur.
 *
 * Gelecekte (Gemma 2B vb.):
 *  - isOfflineModelReady() true dönecek şekilde güncellenecek.
 *  - generateWithModel(prompt) içinde gerçek offline LLM çağrılacak.
 *
 * AiBaristaActivity tarafını değiştirmeden sadece bu sınıf güncellenecek.
 */
public class BdinoAiEngine {

    // Gelecekte model durumu için kullanılacak context
    private static BdinoAiEngine instance;
    private final Context appContext;

    // Şimdilik offline LLM devre dışı (ileride burayı model durumuna bağlayacağız)
    private boolean offlineModelReady = false;

    private BdinoAiEngine(Context context) {
        this.appContext = context.getApplicationContext();
    }

    public static BdinoAiEngine getInstance(Context context) {
        if (instance == null) {
            instance = new BdinoAiEngine(context);
        }
        return instance;
    }

    /**
     * İleride: Gemma model dosyasını yüklemek, path ayarlamak vs için kullanılabilir.
     * Şimdilik placeholder.
     */
    public void initOfflineModelIfNeeded() {
        // TODO: Gemma 2B modelini buradan başlatacağız (nativeInit vs).
        // Şimdilik hiçbir şey yapmıyoruz.
        offlineModelReady = false;
    }

    /**
     * Offline LLM hazır mı?
     * Şimdilik her zaman false. Gemma entegre edilince bu logic değişecek.
     */
    public boolean isOfflineModelReady() {
        return offlineModelReady;
    }

    /**
     * LLM'e verilecek prompt'u üretir.
     */
    private String buildPromptForModel(
            String question,
            String coffeeName,
            String coffeeDescription,
            String coffeeMeasure,
            String coffeeSize,
            String coffeeTip,
            String coffeeNote
    ) {
        StringBuilder p = new StringBuilder();

        p.append("Sen BDINO Coffee mobil uygulamasında çalışan uzman bir kahve baristası yapay zekâsın. ");
        p.append("Kullanıcıya her zaman sakin, net ve öğretici bir dille cevap ver. ");
        p.append("Özellikle espresso bazlı içecekler, filtre kahve, demleme süreleri, öğütüm kalınlığı ve süt köpürtme konusunda uzmansın.\n\n");

        if (!TextUtils.isEmpty(coffeeName)) {
            p.append("Kahve adı: ").append(coffeeName).append("\n");
        }
        if (!TextUtils.isEmpty(coffeeDescription)) {
            p.append("Kısa açıklama: ").append(coffeeDescription).append("\n");
        }
        if (!TextUtils.isEmpty(coffeeMeasure)) {
            p.append("Ölçü bilgisi: ").append(coffeeMeasure).append("\n");
        }
        if (!TextUtils.isEmpty(coffeeSize)) {
            p.append("Bardak boyutu: ").append(coffeeSize).append("\n");
        }
        if (!TextUtils.isEmpty(coffeeTip)) {
            p.append("Tarifin barista ipucu: ").append(coffeeTip).append("\n");
        }
        if (!TextUtils.isEmpty(coffeeNote)) {
            p.append("Ek not: ").append(coffeeNote).append("\n");
        }

        p.append("\n");
        p.append("Kullanıcının sorusu:\n");
        p.append(question).append("\n\n");

        p.append("Cevap verirken:\n");
        p.append("- Gerekirse madde madde yaz.\n");
        p.append("- Gereksiz teknik detaylarla boğma.\n");
        p.append("- Tad profili, yoğunluk, ağızda kalan his gibi konularda da yorum yap.\n");
        p.append("- Mümkünse her cevabı 3–6 satır arasında tut.\n");

        return p.toString();
    }

    /**
     * Gelecekte gerçek offline LLM'in çağrılacağı yer.
     * Şimdilik sadece placeholder olarak bırakıyoruz.
     */
    private String generateWithModel(String promptForModel) {
        // TODO: Gemma 2B / Phi-3 Mini entegrasyonu burada olacak.
        // promptForModel -> native LLM -> cevap string
        // Şimdilik kullanıcıya açıklayıcı bir demo mesajı dönelim:
        return "Şu an BDINO'nun kural tabanlı barista modu aktif. " +
               "Offline gerçek AI (Gemma 2B) entegrasyonu hazırlandığında, bu mesaj yerine " +
               "model tarafından üretilen cevaplar gelecek.\n\n" +
               "Şimdilik temel barista tavsiyelerini aşağıda paylaşıyorum:\n";
    }

    /**
     * Dışarıdan çağrılan tek ana fonksiyon:
     * - Gerekli prompt'u üretir.
     * - Eğer offline LLM hazırsa modeli kullanır,
     *   değilse kural tabanlı cevaba düşer.
     */
    public String generateAdvice(
            String question,
            String coffeeName,
            String coffeeDescription,
            String coffeeMeasure,
            String coffeeSize,
            String coffeeTip,
            String coffeeNote
    ) {
        // 1) LLM için prompt oluştur
        String promptForModel = buildPromptForModel(
                question,
                coffeeName,
                coffeeDescription,
                coffeeMeasure,
                coffeeSize,
                coffeeTip,
                coffeeNote
        );

        StringBuilder sb = new StringBuilder();

        // 2) Eğer offline model hazırsa, önce model cevabını yaz (ileride gerçek olacak)
        if (isOfflineModelReady()) {
            String llmAnswer = generateWithModel(promptForModel);
            sb.append(llmAnswer).append("\n");
        }

        // 3) Ardından veya model yoksa tamamen kural tabanlı cevap ekle
        if (!TextUtils.isEmpty(coffeeName)) {
            sb.append("Şu an ").append(coffeeName).append(" üzerine konuşuyoruz.\n\n");
        } else {
            sb.append("Seçili kahve için bazı önerilerim var.\n\n");
        }

        String qLower = question.toLowerCase();

        // Yoğun kahve / sert tat
        if (qLower.contains("yoğun") || qLower.contains("güçlü") || qLower.contains("sert")) {
            sb.append("• Daha yoğun bir fincan için:\n");
            sb.append("  - Öğütümü bir tık incelt.\n");
            sb.append("  - Demleme / akış süresini 3–5 saniye uzat.\n");
            sb.append("  - Aynı bardak boyutunda daha az su / süt kullan.\n\n");
        }

        // Hafif / yumuşak
        if (qLower.contains("hafif") || qLower.contains("yumuşak")) {
            sb.append("• Daha hafif bir fincan için:\n");
            sb.append("  - Öğütümü bir tık kalınlaştır.\n");
            sb.append("  - Demleme süresini bir miktar kısalt.\n");
            sb.append("  - Bardak hacmini büyütüp süt/su miktarını arttırabilirsin.\n\n");
        }

        // Asidite / ekşilik / yanık tat
        if (qLower.contains("ekşi") || qLower.contains("asid") ||
                qLower.contains("yanık") || qLower.contains("acı")) {
            sb.append("• Asidite veya yanık tat için:\n");
            sb.append("  - Çok ince öğütmüş olabilirsin; bir tık kalınlaştır.\n");
            sb.append("  - Demleme süresini kısalt.\n");
            sb.append("  - Su sıcaklığını 1–2°C düşürmeyi dene.\n\n");
        }

        // Sıcaklık
        if (qLower.contains("sıcak") || qLower.contains("ılı") || qLower.contains("soğuk")) {
            sb.append("• Sıcaklık ayarı için:\n");
            sb.append("  - Espresso için makinenin önerdiği sıcaklıkta kalmaya çalış.\n");
            sb.append("  - Sütü buharlarken 60–65°C bandı, hem tatlılık hem doku için ideal.\n\n");
        }

        // Krema / köpük
        if (qLower.contains("krema") || qLower.contains("köpük") || qLower.contains("foam")) {
            sb.append("• Krema / süt köpüğü için:\n");
            sb.append("  - Buhar ucunu sütün yüzeyine yakın tutup küçük baloncuklarla başla.\n");
            sb.append("  - Sonra daha derine inerek sütün tamamını döndür.\n");
            sb.append("  - Hedef: ıslak boya kıvamında, parlak ve pürüzsüz bir doku.\n\n");
        }

        // Süre / kaç saniye
        if (qLower.contains("süre") || qLower.contains("kaç saniye") ||
                qLower.contains("kaç sn") || qLower.contains("kaç dk")) {
            sb.append("• Süre için genel başlangıç noktaları:\n");
            sb.append("  - Espresso: 25–35 saniye arası.\n");
            sb.append("  - Lungo: 35–45 saniye civarı.\n");
            sb.append("  - Filtre kahve: çoğu reçetede 2:30–4:00 dakika.\n\n");
        }

        // Eğer yukarıdakiler hiç tetiklenmediyse
        String current = sb.toString().trim();
        if (current.equals("") ||
                (current.startsWith("Şu an ") && current.split("\n").length <= 2)) {
            sb.append("Genel bir barista tavsiyesi istersen:\n");
            sb.append("• Her denemede sadece TEK parametreyi değiştir (süre, öğütüm, gramaj veya süt miktarı).\n");
            sb.append("• Böylece fincandaki farkın nereden geldiğini çok daha net görürsün.\n\n");
        }

        // Tariften gelen ekstra bilgiler
        if (!TextUtils.isEmpty(coffeeMeasure)) {
            sb.append("Tarif ölçün: ").append(coffeeMeasure).append("\n");
        }
        if (!TextUtils.isEmpty(coffeeSize)) {
            sb.append("Bardak boyutu: ").append(coffeeSize).append("\n");
        }
        if (!TextUtils.isEmpty(coffeeTip)) {
            sb.append("\nTarifin barista ipucu:\n");
            sb.append("“").append(coffeeTip).append("”\n");
        }

        sb.append("\nKüçük dokunuşlarla kendi BDINO reçeteni oluşturabilirsin. ☕");

        return sb.toString();
    }
}