package com.example.coffee.ai;

import android.content.Context;
import android.text.TextUtils;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

/**
 * MİLO – BDINO Coffee'nin yerel kahve yapay zekası.
 *
 * Özellikler:
 *  - generateAdvice(...)  → tek seferlik "uzun barista cevabı" (mevcut kullanım)
 *  - generateTurn(...)    → sohbet modu (MİLO soru sorup cevap bekler)
 *
 * Tamamen offline ve ücretsiz çalışır.
 */
public class BdinoAiEngine {

    private static BdinoAiEngine instance;
    private final Context appContext;
    private final Random random = new Random();

    private BdinoAiEngine(Context context) {
        this.appContext = context.getApplicationContext();
    }

    public static BdinoAiEngine getInstance(Context context) {
        if (instance == null) {
            instance = new BdinoAiEngine(context);
        }
        return instance;
    }

    public void initOfflineModelIfNeeded() {
        // Şimdilik gerçek model yok, ama API sabit kalsın diye bırakıyoruz.
    }

    /* =========================================================
       1) MİLO – TEK SEFERLİK CEVAP (MEVCUT AI BARISTA)
       ========================================================= */

    public String generateAdvice(
            String question,
            String coffeeName,
            String coffeeDescription,
            String coffeeMeasure,
            String coffeeSize,
            String coffeeTip,
            String coffeeNote
    ) {
        if (question == null) question = "";
        String qLower = question.toLowerCase(Locale.ROOT);

        Mood mood = detectMood(qLower);
        QueryType queryType = detectQueryType(qLower);
        TimeSlot timeSlot = detectTimeSlot();
        CoffeeFamily coffeeFamily = detectCoffeeFamily(coffeeName);

        StringBuilder sb = new StringBuilder();

        // 1) Giriş
        sb.append(buildIntro(mood, queryType, timeSlot)).append("\n\n");

        // 2) Mod seçimi
        if (queryType == QueryType.RECOMMENDATION) {
            sb.append(buildRecommendationAnswer(
                    qLower,
                    timeSlot,
                    mood
            ));
        } else {
            sb.append(buildTroubleshootingAnswer(
                    qLower,
                    coffeeName,
                    coffeeFamily,
                    coffeeMeasure,
                    coffeeSize,
                    coffeeTip
            ));
        }

        // 3) Küçük tüyo + kapanış
        String tinyTip = getTinyTip(qLower, coffeeName);
        if (!TextUtils.isEmpty(tinyTip)) {
            sb.append("\n").append(tinyTip).append("\n");
        }

        sb.append("\n").append(buildOutro(mood));

        return sb.toString();
    }

    /* =========================================================
       2) MİLO – SOHBET MODU (KARŞILIKLI SORU/CEVAP)
       ========================================================= */

    /**
     * Sohbet eden MİLO.
     *
     * @param userMessage   Kullanıcının yazdığı son mesaj.
     * @param state         Mevcut sohbet durumu (null ise yeni başlar).
     * @param coffeeName    (İsteğe bağlı) seçili kahve adı.
     * @param coffeeDesc    (İsteğe bağlı) açıklama.
     * @param coffeeMeasure Ölçü bilgisi.
     * @param coffeeSize    Bardak boyutu.
     * @param coffeeTip     Barista ipucu.
     * @param coffeeNote    Ek not.
     */
    public MiloReply generateTurn(
            String userMessage,
            MiloConversationState state,
            String coffeeName,
            String coffeeDesc,
            String coffeeMeasure,
            String coffeeSize,
            String coffeeTip,
            String coffeeNote
    ) {
        if (userMessage == null) userMessage = "";
        String qLower = userMessage.toLowerCase(Locale.ROOT);

        if (state == null) {
            state = new MiloConversationState();
        }
        MiloConversationState newState = state.copy();

        // Mood & saat yine işimize yarayacak
        Mood mood = detectMood(qLower);
        TimeSlot timeSlot = detectTimeSlot();

        // Eğer hiç mod seçilmemişse, önce ne isteniyor onu algıla
        if (newState.mode == MiloConversationState.Mode.NONE) {
            QueryType type = detectQueryType(qLower);

            if (type == QueryType.RECOMMENDATION) {
                // "Ne içsem?" senaryosu → öneri modu
                newState.mode = MiloConversationState.Mode.RECOMMENDATION;
                newState.step = 1;
                String answer = buildIntro(mood, type, timeSlot)
                        + "\n\nÖnce basitten başlayalım: Daha çok **sütlü** kahveleri mi seversin, yoksa **sade / siyah** kahve mi?";
                return new MiloReply(answer, true, newState);
            } else {
                // Sorun modu → şimdilik tek seferlik cevap verelim
                String answer = generateAdvice(
                        userMessage,
                        coffeeName,
                        coffeeDesc,
                        coffeeMeasure,
                        coffeeSize,
                        coffeeTip,
                        coffeeNote
                );
                // Sohbeti kapat, tekrar soru sorarsa yeni state ile başlar
                newState.mode = MiloConversationState.Mode.NONE;
                newState.step = 0;
                return new MiloReply(answer, false, newState);
            }
        }

        // Eğer öneri modundaysak adım adım ilerleyelim
        if (newState.mode == MiloConversationState.Mode.RECOMMENDATION) {
            return handleRecommendationTurn(
                    userMessage,
                    qLower,
                    newState,
                    mood,
                    timeSlot
            );
        }

        // Diğer modlar için şimdilik tek seferlik davran
        String answer = generateAdvice(
                userMessage,
                coffeeName,
                coffeeDesc,
                coffeeMeasure,
                coffeeSize,
                coffeeTip,
                coffeeNote
        );
        newState.mode = MiloConversationState.Mode.NONE;
        newState.step = 0;
        return new MiloReply(answer, false, newState);
    }

    /**
     * "Bugün ne içsem?" gibi durumlarda MİLO'nun adım adım soru sorup
     * kullanıcının tercihlerini toplaması.
     */
    private MiloReply handleRecommendationTurn(
            String userMessage,
            String qLower,
            MiloConversationState state,
            Mood mood,
            TimeSlot timeSlot
    ) {
        MiloConversationState newState = state.copy();
        StringBuilder answer = new StringBuilder();

        // ADIM 1: Sütlü mü / sade mi?
        if (newState.step == 1) {
            if (qLower.contains("sütlü") || qLower.contains("latte") || qLower.contains("flat white")) {
                newState.milkPref = MiloConversationState.PrefMilk.MILKY;
            } else if (qLower.contains("sade") || qLower.contains("siyah") ||
                       qLower.contains("filter") || qLower.contains("filtre") ||
                       qLower.contains("espresso") || qLower.contains("americano")) {
                newState.milkPref = MiloConversationState.PrefMilk.BLACK;
            }

            if (newState.milkPref == MiloConversationState.PrefMilk.UNKNOWN) {
                answer.append("Seni daha iyi tanıyayım diye soruyorum: Daha çok sütlü kahveler mi, yoksa sade kahve mi içersin?");
                return new MiloReply(answer.toString(), true, newState);
            }

            // Bir sonraki adıma geç
            newState.step = 2;
            answer.append("Tamamdır, bunu öğrendim.\n\n");
            answer.append("Peki kahven **hafif ve sakin** mi olsun, yoksa biraz daha **yoğun / sert** mi seversin?");
            return new MiloReply(answer.toString(), true, newState);
        }

        // ADIM 2: Hafif mi / sert mi?
        if (newState.step == 2) {
            if (qLower.contains("hafif") || qLower.contains("yumuşak") || qLower.contains("light")) {
                newState.strengthPref = MiloConversationState.PrefStrength.LIGHT;
            } else if (qLower.contains("sert") || qLower.contains("güçlü") ||
                       qLower.contains("yoğun") || qLower.contains("kafa açılsın")) {
                newState.strengthPref = MiloConversationState.PrefStrength.STRONG;
            }

            if (newState.strengthPref == MiloConversationState.PrefStrength.UNKNOWN) {
                answer.append("Yoğunluk önemli: Daha **hafif / yumuşak** fincanları mı, yoksa **sert / güçlü** kahveleri mi tercih edersin?");
                return new MiloReply(answer.toString(), true, newState);
            }

            newState.step = 3;
            answer.append("Güzel, bunu da kaydettim.\n\n");
            answer.append("Şimdi de sıcaklık: Bugün **sıcak** bir şey mi istersin, yoksa **buzlu / soğuk** bir kahve mi daha iyi gider?");
            return new MiloReply(answer.toString(), true, newState);
        }

        // ADIM 3: Sıcak mı / buzlu mu?
        if (newState.step == 3) {
            if (qLower.contains("soğuk") || qLower.contains("buzlu") ||
                qLower.contains("ice") || qLower.contains("iced")) {
                newState.tempPref = MiloConversationState.PrefTemp.COLD;
            } else if (qLower.contains("sıcak") || qLower.contains("ılık") || qLower.contains("normal")) {
                newState.tempPref = MiloConversationState.PrefTemp.HOT;
            }

            if (newState.tempPref == MiloConversationState.PrefTemp.UNKNOWN) {
                answer.append("Sıcaklık kısmını netleştirelim: **Sıcak** mı içmek istersin yoksa **buzlu / soğuk** mu?");
                return new MiloReply(answer.toString(), true, newState);
            }

            newState.step = 4;
            answer.append("Tamam, tablo netleşiyor.\n\n");
            answer.append("Son bir şey: Uğraşmak senin için problem mi? Yani **pratik / çabuk** bir şey mi olsun, yoksa **uğraşması da keyifli** olabilir mi?");
            return new MiloReply(answer.toString(), true, newState);
        }

        // ADIM 4: Pratik mi / uğraşlı mı?
        if (newState.step == 4) {
            if (qLower.contains("pratik") || qLower.contains("uğraşamam") ||
                qLower.contains("kolay") || qLower.contains("çabuk") ||
                qLower.contains("hemen")) {
                newState.effortPref = MiloConversationState.PrefEffort.EASY;
            } else {
                // Kullanıcı özellikle pratik demediyse "fark etmez" sayalım
                newState.effortPref = MiloConversationState.PrefEffort.DONT_CARE;
            }

            // Artık öneri üretebiliriz
            String suggestion = buildSuggestionFromPrefs(newState, timeSlot, mood);

            // Sohbeti kapatıyoruz, tekrar "ne içsem" derse sıfırdan başlar
            newState.mode = MiloConversationState.Mode.NONE;
            newState.step = 0;

            return new MiloReply(suggestion, false, newState);
        }

        // Beklenmedik durum: sıfırla
        newState.mode = MiloConversationState.Mode.NONE;
        newState.step = 0;
        answer.append("Sohbet adımlarında biraz karıştık gibi, istersen tekrar \"Bugün ne içsem?\" diyerek başlayabiliriz.");
        return new MiloReply(answer.toString(), false, newState);
    }

    /**
     * Toplanan tercihlere göre kahve önerileri üretir.
     */
    private String buildSuggestionFromPrefs(
            MiloConversationState prefs,
            TimeSlot timeSlot,
            Mood mood
    ) {
        StringBuilder sb = new StringBuilder();

        sb.append("Tamam, seni biraz daha tanıdım. Özetleyeyim:\n");

        // Süt
        if (prefs.milkPref == MiloConversationState.PrefMilk.MILKY) {
            sb.append("  • Sütlü kahveleri seviyorsun.\n");
        } else if (prefs.milkPref == MiloConversationState.PrefMilk.BLACK) {
            sb.append("  • Sade / siyah kahve seviyorsun.\n");
        }

        // Yoğunluk
        if (prefs.strengthPref == MiloConversationState.PrefStrength.LIGHT) {
            sb.append("  • Fincanın hafif / yumuşak olmasını tercih ediyorsun.\n");
        } else if (prefs.strengthPref == MiloConversationState.PrefStrength.STRONG) {
            sb.append("  • Bir tık daha yoğun / güçlü fincanları tercih ediyorsun.\n");
        }

        // Sıcaklık
        if (prefs.tempPref == MiloConversationState.PrefTemp.COLD) {
            sb.append("  • Soğuk / buzlu bir şey istiyorsun.\n");
        } else if (prefs.tempPref == MiloConversationState.PrefTemp.HOT) {
            sb.append("  • Sıcak kahve tarafındasın.\n");
        }

        // Effort
        if (prefs.effortPref == MiloConversationState.PrefEffort.EASY) {
            sb.append("  • Çok uğraşmak istemiyorsun, pratik bir şey olsun istiyorsun.\n");
        } else if (prefs.effortPref == MiloConversationState.PrefEffort.DONT_CARE) {
            sb.append("  • Uğraşması da keyifli olabilir, problem değil.\n");
        }

        sb.append("\nBuna göre sana en çok yakışan BDINO fincanları şöyle:\n\n");

        // Öneri listesi
        if (prefs.tempPref == MiloConversationState.PrefTemp.COLD) {
            // Soğuk kahve
            if (prefs.milkPref == MiloConversationState.PrefMilk.MILKY) {
                sb.append("  • Iced Latte: Sütlü, yumuşak ve buzla birlikte iyi giden bir fincan.\n");
            } else {
                sb.append("  • Cold Brew: Düşük asiditeli, ferah ve sade içimli bir kahve.\n");
            }
            if (prefs.strengthPref == MiloConversationState.PrefStrength.STRONG) {
                sb.append("  • Iced Americano: Güçlü kahve karakterinden vazgeçmeden serinlemek için.\n");
            }
        } else {
            // Sıcak kahve
            if (prefs.milkPref == MiloConversationState.PrefMilk.MILKY) {
                if (prefs.strengthPref == MiloConversationState.PrefStrength.LIGHT) {
                    sb.append("  • Latte: Sütlü, hafif ve sakinleştirici bir fincan.\n");
                } else {
                    sb.append("  • Flat White: Latte'den biraz daha yoğun ama hâlâ kremamsı.\n");
                    sb.append("  • Cappuccino: Köpüklü, dengeli ve sohbetlik bir fincan.\n");
                }
            } else {
                // Sade kahve
                if (prefs.strengthPref == MiloConversationState.PrefStrength.LIGHT) {
                    sb.append("  • Filtre Kahve: Temiz, net ve uzun içimli bir fincan.\n");
                    sb.append("  • Americano: Espresso karakterini koruyan daha uzun bir fincan.\n");
                } else {
                    sb.append("  • Espresso: Kısa, güçlü ve direkt bir fincan.\n");
                    sb.append("  • Lungo: Espresso kadar kısa değil, ama hâlâ yoğun ve canlı.\n");
                    if (timeSlot == TimeSlot.NIGHT) {
                        sb.append("  • Küçük bir Türk Kahvesi: Geceye karakterli ama dozajı kontrollü bir kapanış yapar.\n");
                    }
                }
            }
        }

        if (prefs.effortPref == MiloConversationState.PrefEffort.EASY) {
            sb.append("\nPratik olması için:\n");
            sb.append("  - Makinen varsa düz espresso veya Americano'ya yönelebilirsin.\n");
            sb.append("  - Evde basit bir filtre makinesi varsa tek düğmeyle filtre kahve demlemek iyi bir çözüm.\n");
        }

        sb.append("\nİlk önerdiğim fincanlardan biriyle başla; sevmezsen diğerini denersin. Birkaç gün içinde kendi BDINO imza kahveni bulursun. ☕");

        return sb.toString();
    }

    /* =========================================================
       3) Ortak yardımcılar (Mood, QueryType, TimeSlot, vb)
       ========================================================= */

    private enum Mood {
        NEUTRAL, FRUSTRATED, HAPPY, CURIOUS, SAD
    }

    private enum QueryType {
        TROUBLE,
        RECOMMENDATION,
        GENERIC
    }

    private enum TimeSlot {
        MORNING,
        AFTERNOON,
        EVENING,
        NIGHT
    }

    private enum CoffeeFamily {
        ESPRESSO,
        FILTER,
        TURKISH,
        ICED,
        OTHER
    }

    private Mood detectMood(String q) {
        if (q.contains("bıktım") || q.contains("sinir") || q.contains("olmuyor") ||
            q.contains("hep böyle") || q.contains("delir") || q.contains("çıldır")) {
            return Mood.FRUSTRATED;
        }
        if (q.contains("moralim") || q.contains("canım sıkkın") || q.contains("üzgün") ||
            q.contains("yorgun") || q.contains("çok yoruldum")) {
            return Mood.SAD;
        }
        if (q.contains("harika") || q.contains("bayıldım") || q.contains("çok güzel") ||
            q.contains("süper") || q.contains("efsane")) {
            return Mood.HAPPY;
        }
        if (q.contains("nasıl") || q.contains("neden") || q.contains("acaba") ||
            q.contains("merak ediyorum") || q.contains("anlamıyorum")) {
            return Mood.CURIOUS;
        }
        return Mood.NEUTRAL;
    }

    private QueryType detectQueryType(String q) {
        if (q.contains("ne içsem") || q.contains("bana kahve öner") ||
            q.contains("kahve öner") || q.contains("hangi kahve") ||
            q.contains("kahve tavsiye") || q.contains("bir kahve söyle") ||
            q.contains("şu an ne içilir") || q.contains("şu an ne içsem iyi gider")) {
            return QueryType.RECOMMENDATION;
        }

        if (q.contains("acı") || q.contains("ekşi") || q.contains("hafif") ||
            q.contains("zayıf") || q.contains("çok sert") || q.contains("çok yoğun") ||
            q.contains("köpük") || q.contains("süre") || q.contains("kaç saniye") ||
            q.contains("yanık tat") || q.contains("yanık")) {
            return QueryType.TROUBLE;
        }

        return QueryType.TROUBLE;
    }

    private TimeSlot detectTimeSlot() {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);

        if (hour >= 5 && hour < 11) {
            return TimeSlot.MORNING;
        } else if (hour >= 11 && hour < 17) {
            return TimeSlot.AFTERNOON;
        } else if (hour >= 17 && hour < 22) {
            return TimeSlot.EVENING;
        } else {
            return TimeSlot.NIGHT;
        }
    }

    private CoffeeFamily detectCoffeeFamily(String coffeeName) {
        if (coffeeName == null) return CoffeeFamily.OTHER;
        String n = coffeeName.toLowerCase(Locale.ROOT);

        if (n.contains("espresso") || n.contains("ristretto") ||
            n.contains("lungo") || n.contains("americano") ||
            n.contains("latte") || n.contains("cappuccino") ||
            n.contains("flat white") || n.contains("macchiato") ||
            n.contains("mocha")) {
            return CoffeeFamily.ESPRESSO;
        }

        if (n.contains("filter") || n.contains("filtre") ||
            n.contains("v60") || n.contains("chemex") ||
            n.contains("kalita")) {
            return CoffeeFamily.FILTER;
        }

        if (n.contains("türk") || n.contains("turk") || n.contains("cezve")) {
            return CoffeeFamily.TURKISH;
        }

        if (n.contains("iced") || n.contains("soğuk") || n.contains("cold brew") ||
            n.contains("freddo")) {
            return CoffeeFamily.ICED;
        }

        return CoffeeFamily.OTHER;
    }

    /* ---------------- Giriş & Kapanış ---------------- */

    private String buildIntro(Mood mood, QueryType type, TimeSlot timeSlot) {
        String[] neutralTrouble = {
                "Bu tarz kahve dertlerini çoğu kişi yaşıyor, beraber çözebiliriz.",
                "Fincandaki küçük detayları düzeltmek için buradayım.",
                "Gel, fincanın arkasındaki sebebi birlikte okuyalım.",
                "Bu soruyu sorman bile kahveye ne kadar önem verdiğini gösteriyor."
        };

        String[] neutralRecommend = {
                "Tam zamanında sordun, sana birkaç kahve fikri vereyim.",
                "Bugünkü ruh haline göre bir iki fincan önerebilirim.",
                "Hadi BDINO tarzı bir kahve seçelim sana.",
                "Bir fincanla günü biraz daha iyi hale getirebiliriz."
        };

        String[] frustrated = {
                "Üst üste olmayınca insanı gerçekten yoruyor, haklısın.",
                "Bu his çok normal, çoğu barista adayının geçtiği yollardasın.",
                "Sinir bozucu olabiliyor ama ufak dokunuşlarla çözülebilir.",
                "Merak etme, birkaç denemede bu sorunu aşarız."
        };

        String[] happy = {
                "Zaten iyi gidiyorsun, biraz daha ince ayar yapalım.",
                "Bu enerjiyle fincanını bambaşka seviyeye taşıyabiliriz.",
                "Harika, sadece birkaç küçük dokunuş kaldı.",
                "Keyfin yerinde, fincanını da ona yakışır hale getirelim."
        };

        String[] sad = {
                "Moralin çok da yüksek değil gibi, o zaman işi zorlaştırmayalım.",
                "Duygu tarafı karışıkken bari kahve kısmını rahatlatan bir fincan yapalım.",
                "Kendini yormadan içini ısıtacak bir fincan seçelim.",
                "Bazen bir fincan kahve, tonu tamamen değiştirmese de yumuşatır."
        };

        String base;

        switch (mood) {
            case FRUSTRATED:
                base = frustrated[random.nextInt(frustrated.length)];
                break;
            case HAPPY:
                base = happy[random.nextInt(happy.length)];
                break;
            case SAD:
                base = sad[random.nextInt(sad.length)];
                break;
            case CURIOUS:
                base = "Güzel soru, detaylı cevap hak ediyor.";
                break;
            default:
                if (type == QueryType.RECOMMENDATION) {
                    base = neutralRecommend[random.nextInt(neutralRecommend.length)];
                } else {
                    base = neutralTrouble[random.nextInt(neutralTrouble.length)];
                }
        }

        switch (timeSlot) {
            case MORNING:
                return base + " Sabah saatleri, kahve için en kritik zamanlardandır.";
            case AFTERNOON:
                return base + " Öğlen sonrası fincanı günün geri kalanının ritmini belirler.";
            case EVENING:
                return base + " Akşam fincanı genelde ritüel gibidir, onu güzelleştirelim.";
            case NIGHT:
            default:
                return base + " Gece kahvesi ayrı bir dünya, dikkatli ayarlayalım.";
        }
    }

    private String buildOutro(Mood mood) {
        String[] neutral = {
                "Birkaç denemede kendi BDINO rutinini bulursun.",
                "Önemli olan her fincanda küçük bir şey öğrenmek.",
                "Damak tadını en iyi sen tanıyorsun, ben sadece yol işaretlerini koyuyorum.",
                "Bir sonraki fincanda ne değiştiğini gözlemlemeyi unutma."
        };

        String[] soft = {
                "Kendine de fincanına da sabırlı davran, ikisi de zamanla oturur.",
                "Kahve küçük bir ritüel, kendine nefes alanı açmak için güzel bir bahane.",
                "Küçük ayarlarla fincanın karakterini birlikte kurarız."
        };

        switch (mood) {
            case FRUSTRATED:
            case SAD:
                return soft[random.nextInt(soft.length)];
            default:
                return neutral[random.nextInt(neutral.length)];
        }
    }

    /* ---------------- Problem Çözme Modu ---------------- */

    private String buildTroubleshootingAnswer(
            String qLower,
            String coffeeName,
            CoffeeFamily family,
            String coffeeMeasure,
            String coffeeSize,
            String coffeeTip
    ) {
        StringBuilder sb = new StringBuilder();

        if (!TextUtils.isEmpty(coffeeName)) {
            sb.append("Şu an özellikle **").append(coffeeName).append("** için konuşalım.\n\n");
        }

        boolean mentionedSomething = false;

        if (qLower.contains("acı") || qLower.contains("yanık")) {
            mentionedSomething = true;
            sb.append("• Kahven acı veya yanık tat veriyorsa genelde şu sebepler olur:\n");
            if (family == CoffeeFamily.ESPRESSO) {
                sb.append("  - Öğütüm çok ince ve akış süresi fazla uzun olabilir.\n");
                sb.append("  - 25–35 saniye bandına yaklaşmaya çalış, puck'ı çok sıkıştırma.\n");
            } else if (family == CoffeeFamily.FILTER) {
                sb.append("  - Demleme süresi çok uzamış veya su sıcaklığı fazla yüksek olabilir.\n");
                sb.append("  - Toplam demleme süresini 2:30–4:00 aralığında tutmaya çalış.\n");
            } else if (family == CoffeeFamily.TURKISH) {
                sb.append("  - Kahveyi kaynattıysan yanık tat kaçınılmaz olur.\n");
                sb.append("  - İlk kabarmayı görür görmez cezveyi ocaktan almayı dene.\n");
            } else {
                sb.append("  - Genel olarak daha kalın öğütüm ve biraz daha kısa süre dene.\n");
            }
            sb.append("\n");
        }

        if (qLower.contains("ekşi")) {
            mentionedSomething = true;
            sb.append("• Ekşi tat genelde 'under-extraction' işaretidir:\n");
            sb.append("  - Öğütümü biraz incelt.\n");
            sb.append("  - Demleme süresini ufak bir miktar uzat.\n");
            sb.append("  - Su sıcaklığın çok düşükse 1–2°C arttırmayı dene.\n\n");
        }

        if (qLower.contains("zayıf") || qLower.contains("hafif") || qLower.contains("su gibi")) {
            mentionedSomething = true;
            sb.append("• Kahve çok hafif veya zayıf geliyorsa:\n");
            sb.append("  - Oranını gözden geçir: daha fazla kahve veya biraz daha az su kullan.\n");
            sb.append("  - Öğütümü biraz incelt, böylece ekstraksiyon artar.\n");
            if (family == CoffeeFamily.ESPRESSO) {
                sb.append("  - Espresso tarafında 1:2 oranı (örneğin 18 g kahve → 36 g shot) iyi bir başlangıçtır.\n");
            }
            sb.append("\n");
        }

        if (qLower.contains("köpük") || qLower.contains("foam") || qLower.contains("süt")) {
            mentionedSomething = true;
            sb.append("• Süt ve köpük tarafında sorun yaşıyorsan:\n");
            sb.append("  - Buhar çubuğunu sütün yüzeyine çok yakın başlat, küçük baloncuklar duyduğunda iyi yoldasın.\n");
            sb.append("  - Sonra çubuğu biraz daha derine indirip sütün kendi etrafında dönmesini sağla.\n");
            sb.append("  - 60–65°C bandı, süt tatlılığını öne çıkaran güvenli bölgedir.\n\n");
        }

        if (qLower.contains("süre") || qLower.contains("kaç saniye") ||
            qLower.contains("kaç sn") || qLower.contains("kaç dk")) {
            mentionedSomething = true;
            sb.append("• Süre için genel başlangıç noktaları:\n");
            sb.append("  - Espresso: 25–35 saniye arası.\n");
            sb.append("  - Lungo: 35–45 saniye civarı.\n");
            sb.append("  - Filtre kahve: çoğu reçetede 2:30–4:00 dakika.\n");
            sb.append("  - Türk kahvesi: kaynatmadan önceki ilk kabarmayı yakalamak kritik.\n\n");
        }

        if (!mentionedSomething) {
            sb.append("Kahveyi iyileştirmek için genel bir çerçeve vereyim:\n");
            sb.append("  1. Her seferinde sadece tek parametreyi değiştir (öğütüm, süre, oran veya sıcaklık).\n");
            sb.append("  2. Tadın yönüne göre hareket et:\n");
            sb.append("     - Çok hafifse: daha ince öğütüm veya daha uzun süre.\n");
            sb.append("     - Çok sert/acıysa: daha kalın öğütüm veya daha kısa süre.\n");
            sb.append("  3. Aynı çekirdekle en az 3–4 fincan deneme yap, karakterini çözersin.\n\n");
        }

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

        return sb.toString();
    }

    /* ---------------- Öneri Modu (tek seferlik) ---------------- */

    private String buildRecommendationAnswer(
            String qLower,
            TimeSlot timeSlot,
            Mood mood
    ) {
        StringBuilder sb = new StringBuilder();

        boolean wantsIced = qLower.contains("buzlu") || qLower.contains("soğuk") ||
                            qLower.contains("serinlemek") || qLower.contains("ferah");
        boolean wantsStrong = qLower.contains("çok güçlü") || qLower.contains("sert") ||
                              qLower.contains("uyku kaçsın") || qLower.contains("kafa açılsın");
        boolean wantsSoft = qLower.contains("hafif") || qLower.contains("yumuşak") ||
                            qLower.contains("sütlü");
        boolean wantsEasy = qLower.contains("pratik") || qLower.contains("uğraşamam") ||
                            qLower.contains("uğraşmak istemiyorum") || qLower.contains("kolay olsun");

        if (wantsIced) {
            sb.append("Hava veya ruh hali seni daha ferah bir fincana çağırıyor gibi duruyor.\n\n");
            sb.append("Şu seçenekler sana iyi gelebilir:\n");
            sb.append("  • Iced Latte: Sütlü, yumuşak ve buzla beraber ferahlatıcı.\n");
            sb.append("  • Cold Brew: Daha uzun sürede demlenen, düşük asiditeli ve çok ferah bir seçenek.\n");
            if (wantsStrong) {
                sb.append("  • Iced Americano: Espresso yoğunluğunu kaybetmeden serinlemek istersen iyi gider.\n");
            }
        } else {
            switch (timeSlot) {
                case MORNING:
                    sb.append("Sabah fincanı için hem uyandıran hem de dengeli birkaç öneri:\n\n");
                    if (wantsStrong) {
                        sb.append("  • Double Espresso: Direkt ve net bir uyanma modu.\n");
                        sb.append("  • Lungo: Biraz daha uzun içim ama hâlâ canlı ve yoğun.\n");
                    } else if (wantsSoft || mood == Mood.SAD) {
                        sb.append("  • Latte: Sütlü, yumuşak ve güne daha sakin başlatan bir fincan.\n");
                        sb.append("  • Flat White: Latte'den biraz daha yoğun ama hâlâ kremamsı.\n");
                    } else {
                        sb.append("  • Filtre Kahve: Net, temiz tatlı klasik bir başlangıç.\n");
                        sb.append("  • Americano: Espresso karakterini koruyan, daha uzun içimli bir alternatif.\n");
                    }
                    break;
                case AFTERNOON:
                    sb.append("Öğlen sonrası için enerjiyi toparlayan ama çok da yormayan öneriler:\n\n");
                    if (wantsSoft || mood == Mood.SAD) {
                        sb.append("  • Latte veya Cappuccino: Sütlü, sohbetlik fincanlar.\n");
                    } else if (wantsStrong) {
                        sb.append("  • Espresso veya Cortado: Kısa ama etkili bir mola.\n");
                    } else {
                        sb.append("  • Filtre Kahve: Hem çalışırken hem dinlenirken eşlik eder.\n");
                    }
                    break;
                case EVENING:
                    sb.append("Akşam fincanı biraz ritüel gibidir, o yüzden birkaç sakin öneri:\n\n");
                    if (wantsStrong && mood != Mood.SAD) {
                        sb.append("  • Cappuccino: Köpüklü, dengeli ve sohbetlik bir fincan.\n");
                    } else {
                        sb.append("  • Latte: Akşamları yumuşak bir kapanış gibi.\n");
                        sb.append("  • Türk Kahvesi: Küçük ama karakterli bir fincanla günü toparlayabilirsin.\n");
                    }
                    break;
                case NIGHT:
                default:
                    sb.append("Gece kahvesi biraz dikkat ister, uykuyu da göz önünde bulundurman iyi olur.\n\n");
                    if (wantsStrong) {
                        sb.append("  • Küçük bir Türk Kahvesi veya tek shot Espresso: dozajı çok kaçırmadan.\n");
                    } else if (wantsSoft || mood == Mood.SAD) {
                        sb.append("  • Latte tarzı sütlü bir fincan, geceye daha yumuşak eşlik eder.\n");
                    } else {
                        sb.append("  • Hafif bir filtre kahve veya uzun bir Americano tercih edebilirsin.\n");
                    }
                    break;
            }
        }

        if (wantsEasy) {
            sb.append("\nPratik olması önemliyse:\n");
            sb.append("  - Makineden düz bir espresso veya Americano almak,\n");
            sb.append("  - Varsa basit bir filtre makinesiyle tek düğmeyle demleme yapmak çok işini görebilir.\n");
        }

        sb.append("\nİlk önerdiğim fincanlardan biriyle başla; sevmezsen diğerine geç. Böyle böyle kendi BDINO rutinini bulursun. ☕");

        return sb.toString();
    }

    /* ---------------- Küçük Barista Tüyoları ---------------- */

    private String getTinyTip(String qLower, String coffeeName) {
        if (qLower.contains("öğüt") || qLower.contains("grind") || qLower.contains("çekirdek")) {
            return "MİLO tüyosu: Öğütüm ayarını değiştirirken her seferinde sadece küçük adımlar at. İki–üç klik birden değiştirmek tadı takip etmeyi zorlaştırır.";
        }

        if (qLower.contains("süt") || qLower.contains("köpük") || qLower.contains("foam")) {
            return "MİLO tüyosu: Sütü köpürtürken sürahiyi hafif yana eğip sütün kendi etrafında dönmesini sağla; bu, parlak ve ipeksi bir doku verir.";
        }

        if (qLower.contains("filtre") || qLower.contains("v60") || qLower.contains("chemex") ||
            qLower.contains("filter")) {
            return "MİLO tüyosu: Demleme bittikten sonra sürahiyi hafifçe çevirerek kahveyi karıştırmak, fincanlar arasında tat dengesini eşitler.";
        }

        if (coffeeName != null) {
            String n = coffeeName.toLowerCase(Locale.ROOT);
            if (n.contains("türk")) {
                return "MİLO tüyosu: Türk kahvesinde cezveyi ocaktan almadan hemen önceki ilk kabarma anı, hem köpük hem tat için en kritik saniyedir.";
            }
            if (n.contains("espresso")) {
                return "MİLO tüyosu: Espresso için puck yüzeyini düz ve çatlak bırakmamaya çalış, suyu nereden geçeceğini şaşırtmamış olursun.";
            }
        }

        return "MİLO tüyosu: Aynı kahveyi birkaç gün boyunca, her seferinde tek bir parametreyi değiştirerek denersen, damak tadına en yakın reçeteyi çok hızlı bulursun.";
    }
}