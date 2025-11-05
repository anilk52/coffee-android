package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipesData {

    // Tüm tarifler (41 dünya kahvesi + 5 Türk kahvesi = 46)
    private static final List<Recipe> RECIPES = Arrays.asList(

            // region ESPRESSO

            new Recipe(
                    R.drawable.cup_espresso_70ml,
                    "Espresso",
                    "Yoğun, kısa ve net bir espresso shot.",
                    "Klasik espresso, ince öğütülmüş kahvenin yüksek basınçla kısa sürede demlenmesiyle elde edilir. "
                            + "Tatlılık, asidite ve gövdenin bir arada hissedildiği, tüm kahve dünyasının başlangıç noktasıdır.",
                    "18 g kahve • 36 g espresso (1:2) • 25–30 sn demleme",
                    "Akışı kremadan takip et: Çok hızlı akıyorsa daha ince, çok yavaşsa biraz daha kalın öğüt.",
                    "Tadımı her zaman sade yap; şeker eklemeden önce çekirdeği tanı.",
                    "espresso",
                    "S – 70 ml"
            ),

            new Recipe(
                    R.drawable.cup_ristretto_50ml,
                    "Ristretto",
                    "Daha kısa, daha yoğun espresso.",
                    "Ristretto, aynı kahve miktarıyla daha az su kullanılarak elde edilir. "
                            + "Sonuç; kısa, yoğun ve tatlılık hissi yüksek bir shot’tır.",
                    "18 g kahve • 20–25 g shot • 18–22 sn",
                    "Ristretto için akış başlar başlamaz ilk kısımda kes; en aromatik bölüm orasıdır.",
                    "Yoğun tat sevenler için sütlü içeceklerin tabanı olarak da harika çalışır.",
                    "espresso",
                    "XS – 50 ml"
            ),

            new Recipe(
                    R.drawable.cup_lungo_150ml,
                    "Lungo",
                    "Uzun içimli, hafif gövdeli espresso.",
                    "Lungo, espresso shot’un daha uzun süre akıtılmasıyla elde edilir. "
                            + "Daha hafif gövdeli, daha uzun içimli ve acılığa kaçmadan dengeli bir fincan hedefler.",
                    "18 g kahve • 50–60 g shot • 35–40 sn",
                    "Lungo yaparken öğütümü çok inceltme; yoksa fazla acılık çıkar.",
                    "Sade siyah kahve seven ama filtre kahveye göre daha yoğun tat isteyenler için idealdir.",
                    "espresso",
                    "M – 150 ml"
            ),

            new Recipe(
                    R.drawable.cup_doppio_120ml,
                    "Doppio",
                    "Çift shot espresso.",
                    "Doppio, tek seferde iki shot espresso alman için tasarlanmış çift basket kullanımıdır. "
                            + "Sabah çok uyanık olman gereken günler için güçlü ve net bir seçenektir.",
                    "18–20 g kahve • 40–44 g espresso • 25–30 sn",
                    "Aynı zamanda latte, cappuccino gibi içeceklerin standart tabanı olarak da kullanılabilir.",
                    "Kafein yoğunğunu artırmak için değil, tadı güçlendirmek için tercih et.",
                    "espresso",
                    "S – 120 ml"
            ),

            new Recipe(
                    R.drawable.cup_macchiato_120ml,
                    "Espresso Macchiato",
                    "Espresso üstü küçük bir süt dokunuşu.",
                    "Macchiato, tek shot espresso üzerine az miktarda mikroköpük süt eklenerek hazırlanır. "
                            + "Espressonun keskinliğini hafifçe yumuşatır ama karakterini kaybettirmez.",
                    "1 shot espresso • 1–2 yemek kaşığı mikroköpük süt",
                    "Sütü aşırı ekleme; espresso hâlâ başrolde olmalı.",
                    "Sade espressoya geçiş yapmak isteyenler için ideal ara duraktır.",
                    "espresso",
                    "S – 120 ml"
            ),

            new Recipe(
                    R.drawable.cup_conpanna_100ml,
                    "Espresso Con Panna",
                    "Espresso üzerinde krema bulutu.",
                    "Con Panna, espresso shot’un üzerine taze çırpılmış krema eklenerek yapılır. "
                            + "Tatlı, yoğun ve tatlı krizlerinde küçük bir tatlı yerine geçebilecek kadar karakterlidir.",
                    "1 shot espresso • 1–2 yemek kaşığı taze krema",
                    "Kremayı çok şekerli yapma; kahvenin aroması kaybolmasın.",
                    "Özellikle tatlı seven ama hacmi küçük bir içecek isteyenler için harika bir seçimdir.",
                    "espresso",
                    "S – 100 ml"
            ),

            new Recipe(
                    R.drawable.cup_romano_70ml,
                    "Espresso Romano",
                    "Yanında limonla servis edilen espresso.",
                    "Espresso Romano, yanında ince limon dilimiyle servis edilen espressodur. "
                            + "Limon kabuğundaki yağlar, kahvenin asiditesini farklı bir seviyeye taşır.",
                    "1 shot espresso • 1 ince limon dilimi",
                    "Limon kabuğunu fincan kenarına hafifçe sürerek narenciye kokusunu belirginleştirebilirsin.",
                    "Alışılmışın dışında, ferah ve karakterli bir espresso deneyimi sunar.",
                    "espresso",
                    "S – 70 ml"
            ),

            new Recipe(
                    R.drawable.cup_americano_350ml,
                    "Americano",
                    "Espresso + sıcak su, uzun içimli siyah kahve.",
                    "Americano, espresso shot’un üzerine sıcak su eklenerek hazırlanır. "
                            + "Filtre kahveye göre farklı, espressoya göre daha hafif bir gövde sunar.",
                    "1–2 shot espresso • 150–250 ml sıcak su",
                    "Önce sıcak suyu koyup üzerine espressoyu eklemek kremanın daha iyi korunmasını sağlar.",
                    "Siyah kahve içmeyi seviyor ama espressoyu kısa buluyorsan ideal tercih.",
                    "espresso",
                    "L – 350 ml"
            ),

            new Recipe(
                    R.drawable.cup_breve_200ml,
                    "Breve",
                    "Espresso + yarım yağlı krema (half & half).",
                    "Breve, klasik latteye göre çok daha kremamsı bir içecek sunar. Süt yerine yarı süt yarı krema kullanılır. "
                            + "Yoğun gövde ve tatlı bir damak hissi bırakır.",
                    "1 shot espresso • 120–150 ml half & half • Hafif köpürtme",
                    "Köpürtürken çok ısıtma; 60–65°C üzerinde yağlar ağırlaşır.",
                    "Tatlı ihtiyacını şeker eklemeden çözmek isteyenler için güçlü bir seçenek.",
                    "espresso",
                    "M – 200 ml"
            ),

            new Recipe(
                    R.drawable.cup_piccolalatte_120ml,
                    "Piccolo Latte",
                    "Küçük bardakta yoğun sütlü espresso.",
                    "Piccolo, tek shot espresso üzerine az miktarda sütle hazırlanır. "
                            + "Latte hissi verir ama hacmi küçük, kahve aroması daha belirgindir.",
                    "1 shot espresso • 80–100 ml süt • İnce mikroköpük",
                    "Sütü çok kabartma; latte art yapmak zorunda değilsin, dokuyu pürüzsüz tutman yeterli.",
                    "Kahve aroması belirgin, sütlü ama hafif içimli bir seçenek istersen tam sana göre.",
                    "espresso",
                    "S – 120 ml"
            ),

            new Recipe(
                    R.drawable.cup_flatwhite_240ml,
                    "Flat White",
                    "Yoğun espresso tabanlı, ince sütlü içecek.",
                    "Flat white, genellikle çift shot espresso üzerine, latteye göre daha az ama daha yoğun sütle hazırlanır. "
                            + "Süt ve kahve dengesi oldukça sıkı ve tatlılık ön plandadır.",
                    "2 shot espresso • 140–160 ml süt • İnce mikroköpük",
                    "Şerbet gibi içilmemeli; yudumladığında kahve tadı net gelmeli.",
                    "Latte’ye göre daha ‘kahveli’, cappuccino’ya göre daha ‘sütlü’ bir ara nokta.",
                    "espresso",
                    "M – 240 ml"
            ),

            new Recipe(
                    R.drawable.cup_cappucino_240ml,
                    "Cappuccino",
                    "Eşit oranlarda espresso, süt ve süt köpüğü.",
                    "Klasik cappuccino, espresso üzerine buharda ısıtılmış süt ve yoğun köpük ile hazırlanır. "
                            + "Yumuşak gövde, dengeli tatlılık ve hafif kremamsı yapı sunar.",
                    "1 shot espresso • 60–90 ml süt • 2 parmak kalınlığında köpük",
                    "Köpüğü kuru değil, parlak ve akışkan bir dokuya getir; ‘ıslak cappuccino’ tadı yükseltir.",
                    "Üzerine hafif kakao serpiştirerek daha tatlı bir profil elde edebilirsin.",
                    "espresso",
                    "M – 240 ml"
            ),

            new Recipe(
                    R.drawable.cup_latte_300ml,
                    "Caffè Latte",
                    "Bol sütlü, yumuşak kahve.",
                    "Latte, espresso üzerine bolca süt eklenerek hazırlanır. "
                            + "Kahve aroması yumuşak, sütlü içecek sevenler için idealdir.",
                    "1–2 shot espresso • 200–220 ml süt • İnce mikroköpük",
                    "Şurup eklemek istiyorsan önce espresso ile karıştır, sonra sütü ekle.",
                    "Tatlı, yumuşak ve uzun içimli bir kahve arayanlara birebir.",
                    "espresso",
                    "L – 300 ml"
            ),

            new Recipe(
                    R.drawable.cup_mochacino_300ml,
                    "Mochaccino",
                    "Latte + kakao, tatlı çikolatalı kahve.",
                    "Mochaccino, espresso, süt ve kakao/çikolata sosunun birleşimidir. "
                            + "Hem sıcak çikolata hem kahve hissi verir; tatlı krizleri için birebir.",
                    "1 shot espresso • 10–15 g kakao veya 20–25 ml çikolata sosu • 200 ml süt",
                    "Kakaoyu küçük bir sıcak su veya espresso ile açıp topak bırakmadan karıştır.",
                    "Üzerine krema ve az kakao ekleyerek küçük bir tatlıya dönüştürebilirsin.",
                    "espresso",
                    "L – 300 ml"
            ),

            new Recipe(
                    R.drawable.cup_affogato_150ml,
                    "Affogato",
                    "Espresso + dondurma, kahveli tatlı.",
                    "Affogato, vanilyalı dondurma üzerine taze çekilmiş sıcak espresso dökülerek hazırlanır. "
                            + "Hem tatlı hem kahve olan ultra basit ama etkileyici bir sunumdur.",
                    "1 top vanilyalı dondurma • 1 shot taze espresso",
                    "Espressoyu dondurmanın üzerine servis anında dök; erimeyi izlemek bile keyifli.",
                    "Akşam yemeği sonrası hafif ama kahveli bir tatlı arıyorsan affogato mükemmel.",
                    "espresso",
                    "S – 150 ml"
            ),

            new Recipe(
                    R.drawable.cup_cortado_150ml,
                    "Cortado",
                    "Espresso ile eşit miktarda süt.",
                    "Cortado, espresso ve sıcak sütü eşit oranlarda birleştirerek dengeli bir içim sunar. "
                            + "Ne çok sütlü ne çok sert; tam ortasında bir profil.",
                    "1 shot espresso • 1 shot sıcak süt • Az mikroköpük",
                    "Sütün sıcaklığını 60–65°C civarında tut; daha sıcak olursa tatlar keskinleşir.",
                    "Espressoya yumuşak bir geçiş yapmak isteyenler için ideal ara duraktır.",
                    "espresso",
                    "M – 150 ml"
            ),

            // endregion

            // region FILTER

            new Recipe(
                    R.drawable.cup_aeropress,
                    "AeroPress",
                    "Basınç yardımıyla yapılan kompakt filtre kahve.",
                    "AeroPress, kısa sürede, gövdeli ama temiz içimli kahve demlemek için tasarlanmış pratik bir ekipmandır. "
                            + "Hem klasik yöntemle hem de ters demleme ile farklı profiller yakalayabilirsin.",
                    "15–17 g kahve • 220 ml su • 1:13–1:15 oran • 1,5–2 dk toplam süre",
                    "Öğütümü V60’tan biraz daha ince tut; baskı uygularken çok hızlı bastırma.",
                    "Seyahatlerde yanında taşımalık, hafif ve çok yönlü bir demleme arıyorsan biçilmiş kaftan.",
                    "filter",
                    "M – 240 ml"
            ),

            new Recipe(
                    R.drawable.cup_chemex,
                    "Chemex",
                    "Temiz, parlak ve yumuşak filtre kahve.",
                    "Kalın filtresi sayesinde Chemex, çok temiz ve zarif bir fincan üretir. "
                            + "Tatlılık öne çıkar, gövde hafif ama aromalar net kalır.",
                    "25–30 g kahve • 400–500 ml su • 1:15–1:16 oran • 3,5–4,5 dk",
                    "Su dökerken dairesel hareketlerle merkeze yakın kal; filtre kenarlarına çok kaçma.",
                    "Arkadaşlarla paylaşmalık, büyük hacimli ve şık sunumlar için harika bir seçim.",
                    "filter",
                    "L – 500 ml"
            ),

            new Recipe(
                    R.drawable.cup_frenchpress,
                    "French Press",
                    "Evde en ulaşılabilir filtre kahve yöntemi.",
                    "French press, kalın öğütülmüş kahvenin sıcak suyla bekletilip süzülmesiyle hazırlanır. "
                            + "Gövdesi yüksek, tortulu ama karakterli bir fincan verir.",
                    "15 g kahve • 250 ml su • 1:16 oran • 4 dk demleme",
                    "Demleme bittikten sonra kahveyi karafe veya kupaya al; presin içinde beklerse acılık artar.",
                    "Evde ekipmansız hissettiğinde bile çoğu mutfakta bulunan kurtarıcı demleme yöntemidir.",
                    "filter",
                    "M – 250 ml"
            ),

            new Recipe(
                    R.drawable.cup_kalitawave,
                    "Kalita Wave",
                    "Dengeli, gövdeli pour-over.",
                    "Düz tabanlı filtresi sayesinde Kalita Wave, demleme hatalarına karşı daha toleranslıdır. "
                            + "Daha gövdeli, dengeli ve tekrar edilebilir sonuçlar üretir.",
                    "18 g kahve • 270 ml su • 1:15 oran • 3–3,5 dk",
                    "Su dökerken üç veya dört döküşte bitirmeye çalış; demlemeyi çok uzatma.",
                    "Asiditeyi sevmiyor ama filtre kahveden de vazgeçemiyorsan tam aradığın ekipman.",
                    "filter",
                    "M – 270 ml"
            ),

            new Recipe(
                    R.drawable.cup_v60,
                    "V60 Pour Over",
                    "Temiz, aromatik ve parlak bir fincan.",
                    "V60, konik formu ve tek uçlu çıkış deliğiyle suyun akış hızını kontrol etmene izin verir. "
                            + "Doğru öğütümle çok temiz, aromatik ve dengeli fincanlar elde edebilirsin.",
                    "15 g kahve • 240 ml su • 1:16 oran • 2,5–3 dk",
                    "KBloom döküşü sonrası suyu 2–3 döküşte ekle, toplam demleme süresini 3 dakikayı geçirme.",
                    "Çekirdeğin tadını ‘en net’ hissetmek istediğinde başvuracağın temel pour-over yöntemidir.",
                    "filter",
                    "M – 240 ml"
            ),

            new Recipe(
                    R.drawable.cup_syphonbrew,
                    "Syphon Brew",
                    "Gösterişli ve temiz gövdeli demleme.",
                    "Syphon, vakum prensibiyle çalışan, hem göze hem damağa hitap eden demleme yöntemidir. "
                            + "Çok temiz, hafif gövdeli ama aromatik fincanlar üretir.",
                    "18–20 g kahve • 300 ml su • 1:15–1:16 oran • 3–4 dk",
                    "Isıyı çok yükseltmeden kontrollü kaynama sağla; yoksa kahve yanık tat verebilir.",
                    "Gösterişli sunumu ve laboratuvar havası sayesinde misafir ağırlamada efsane bir oyuncu.",
                    "filter",
                    "L – 300 ml"
            ),

            new Recipe(
                    R.drawable.cup_colddrip,
                    "Cold Drip",
                    "Saatler süren soğuk demleme.",
                    "Cold drip, soğuk suyun saatler boyunca yavaşça kahvenin üzerinden damlayarak geçtiği bir yöntemdir. "
                            + "Düşük asidite, yoğun gövde ve çikolata notaları sunar.",
                    "50–60 g kahve • 600–700 ml soğuk su • 3–8 saat damlama",
                    "Damla hızını saniyede yaklaşık 1 damla civarında ayarlamak dengeli sonuç verir.",
                    "Yazın buzdolabında hazır bekleyen, buzla servis edilen güçlü bir konsantre gibidir.",
                    "filter",
                    "XL – 600 ml"
            ),

            new Recipe(
                    R.drawable.cup_percolator,
                    "Percolator",
                    "Klasik kamp ve ocak üstü demleme.",
                    "Percolator, suyun kaynamaya yakın ısıyla kahvenin üzerinden tekrar tekrar geçmesiyle çalışır. "
                            + "Yoğun gövdeli, güçlü ve rustik bir fincan üretir.",
                    "Orta–kalın öğütüm • 1:15–1:17 oran • 5–8 dk toplam süre",
                    "Kaynamaya başladıktan sonra çok uzun süre bırakma; acılık hızla artar.",
                    "Kamp ve dağ ortamlarında filtresiz, pratik ve nostaljik bir çözüm sunar.",
                    "filter",
                    "L – 400 ml"
            ),

            new Recipe(
                    R.drawable.cup_mokapot,
                    "Moka Pot",
                    "Ocak üstü yoğun kahve, espresso benzeri.",
                    "Moka pot, buhar basıncıyla suyu kahvenin içinden geçirerek yoğun bir kahve elde eder. "
                            + "Espresso kadar basınçlı olmasa da yoğun ve sert bir profil sunar.",
                    "Su haznesini valfe kadar doldur • İnce öğütüm (espresso kadar değil) • 3–5 dk",
                    "Kaynayan kahveyi ocaktan alır almaz karıştır; dipte kalan kahve daha yoğun olur.",
                    "Evde espresso makinesi olmadan yoğun kahve isteyenler için uygun fiyatlı bir çözüm.",
                    "filter",
                    "S – 150 ml"
            ),

            new Recipe(
                    R.drawable.cup_icedpour,
                    "Iced Pour Over",
                    "Buz üzerine direkt demleme, ferah filtre kahve.",
                    "Iced pour over, sıcak demlemeyi buz üzerine yaparak kahveyi anında soğutur. "
                            + "Canlı asiditeyi korurken ferah ve temiz bir soğuk kahve üretir.",
                    "15 g kahve • 120 ml sıcak su + 120 g buz • 1:16 oran",
                    "Toplam su/buz miktarını normal sıcak demlemeyle aynı tut; sadece bir kısmını buz olarak düşün.",
                    "Filtre kahve seviyorsan ve yazın buzlu versiyonunu istiyorsan ideal yöntem.",
                    "filter",
                    "M – 240 ml"
            ),

            // endregion

            // region SPECIAL (ALKOLSÜZ ÖZEL İÇECEKLER)

            new Recipe(
                    R.drawable.cup_honey_latte,
                    "Honey Latte",
                    "Bal ile tatlandırılmış yumuşak latte.",
                    "Honey latte, şeker yerine bal ile tatlandırılmış latte yorumudur. "
                            + "Tatlılık doğal, bitişi yumuşak ve boğazda hafif bal dokunuşu bırakır.",
                    "1–2 shot espresso • 200 ml süt • 1–2 tatlı kaşığı bal",
                    "Balı, süt eklemeden önce sıcak espressoyla karıştırıp tamamen çözündür.",
                    "Rafine şeker yerine doğal bir tatlandırıcıyla hazırlanmış, konforlu bir içecektir.",
                    "special",
                    "L – 300 ml"
            ),

            new Recipe(
                    R.drawable.cup_pistachio_latte,
                    "Pistachio Latte",
                    "Antep fıstıklı, kremamsı latte.",
                    "Pistachio latte, kavrulmuş Antep fıstığı aromasıyla zenginleştirilmiş sütlü kahvedir. "
                            + "Tatlılık hafif, fıstık aroması ise burunda ve damakta kalıcıdır.",
                    "1–2 shot espresso • 200 ml süt • 20–30 ml fıstık şurubu veya ezmesi",
                    "Gerçek fıstık ezmesi kullanıyorsan topak kalmaması için sıcak espressoyla iyice karıştır.",
                    "Tatlıya yakın ama hâlâ kahve karakterini taşıyan, imza içecek havasında bir tarif.",
                    "special",
                    "L – 300 ml"
            ),

            new Recipe(
                    R.drawable.cup_rose_latte,
                    "Rose Latte",
                    "Gül aromalı, hafif floral latte.",
                    "Rose latte, gül şurubu veya gül aromasıyla tatlandırılmış sütlü kahvedir. "
                            + "Burunda gül kokusu, damakta hafif tatlı ve floral bir bitiş bırakır.",
                    "1 shot espresso • 200 ml süt • 15–20 ml gül şurubu",
                    "Gül şurubunu fazla kaçırma; kahve aroması geride kalmasın.",
                    "Özellikle akşam saatlerinde sakinleştirici, yumuşak bir kahve alternatifi gibi hissedilir.",
                    "special",
                    "L – 300 ml"
            ),

            new Recipe(
                    R.drawable.cup_caramel_brulee_latte,
                    "Caramel Brûlée Latte",
                    "Karamelli, tatlı ve yoğun latte.",
                    "Caramel brûlée latte, karamel sosu ve hafif yanık şeker notalarıyla tatlı, yoğun ve tatlı krizlerini kesen bir içecektir. "
                            + "Üzeri kremayla servis edildiğinde tam bir tatlıya dönüşür.",
                    "1–2 shot espresso • 200 ml süt • 20–30 ml karamel sos • Üzeri krema opsiyonel",
                    "Karamel sosu ve espressoyu önce karıştır; sütü sonra ekle ki tat eşit dağılabilsin.",
                    "Tatlı sevenler için kahve+t atlı karışımı, tam anlamıyla ‘ikisi bir arada’ çözüm.",
                    "special",
                    "L – 300 ml"
            ),

            // endregion

            // region ALCOHOLIC

            new Recipe(
                    R.drawable.cup_espresso_martini,
                    "Espresso Martini",
                    "Votka, kahve likörü ve espresso ile gece içeceği.",
                    "Espresso martini, taze çekilmiş espresso, votka ve kahve likörünü birleştiren şık bir kokteyldir. "
                            + "Tatlılık, alkol ve kahve aroması dengeli olmalıdır.",
                    "30 ml votka • 30 ml kahve likörü • 30 ml taze espresso • Buz",
                    "Malzemeleri shaker’da bol buzla güçlü şekilde çalkala; köpüklü bir üst katman oluştur.",
                    "Akşam saatlerinde kahve tadından vazgeçmeden kokteyl içmek isteyenler için imza içecek.",
                    "alcoholic",
                    "S – Kokteyl bardağı"
            ),

            new Recipe(
                    R.drawable.cup_irish_coffee,
                    "Irish Coffee",
                    "Viski, kahve ve krema ile sıcak kokteyl.",
                    "Irish coffee, sıcak filtre kahve, İrlanda viskisi, şeker ve krema ile hazırlanan klasik bir kokteyldir. "
                            + "Alt katmanda sıcak kahve, üstte soğuk krema kontrastı sunar.",
                    "120–150 ml sıcak kahve • 30–40 ml İrlanda viskisi • 1–2 tatlı kaşığı şeker • Üzeri krema",
                    "Kremayı kahvenin üstüne yavaşça kaşığın tersinden dök ki katmanlı dokuyu koruyabilesin.",
                    "Soğuk havalarda hem ısıtan hem de tatlı bir dokunuş sunan, ikonik bir kahveli kokteyl.",
                    "alcoholic",
                    "M – 200 ml"
            ),

            new Recipe(
                    R.drawable.cup_baileys_latte,
                    "Baileys Latte",
                    "Baileys ile kremamsı, hafif alkollü latte.",
                    "Baileys latte, espressoya Baileys likörü ve süt ekleyerek hazırlanan tatlı ve kremamsı bir içecektir. "
                            + "Kahve aroması geride kalmaz, likörle birleşince tatlı ve yuvarlak bir profil sunar.",
                    "1 shot espresso • 30–40 ml Baileys • 150–180 ml süt",
                    "Baileys’i espresso ile karıştırdıktan sonra süt ekle; böylece tat eşit yayılır.",
                    "Tatlı, hafif alkollü ve rahat içimli bir akşam kahvesi için ideal.",
                    "alcoholic",
                    "M – 240 ml"
            ),

            new Recipe(
                    R.drawable.cup_amaretto_mocha,
                    "Amaretto Mocha",
                    "Badem likörlü çikolatalı kahve.",
                    "Amaretto mocha, espresso, çikolata ve badem likörü birleşimidir. "
                            + "Hem tatlı hem aromatik; badem notaları öne çıkan zengin bir içecek sunar.",
                    "1 shot espresso • 20 ml çikolata sosu • 20–30 ml amaretto • 150 ml süt",
                    "Alkolü ekledikten sonra içeceği kaynatma; ısıt ama kaynama noktasına getirme.",
                    "Tatlı ve aromatik, tatlı niyetine içilebilecek bir kahveli kokteyldir.",
                    "alcoholic",
                    "M – 240 ml"
            ),

            new Recipe(
                    R.drawable.cup_rum_mocha,
                    "Rum Mocha",
                    "Rom, çikolata ve kahve ile sıcak kokteyl.",
                    "Rum mocha, espressoyu kakao ve rom ile birleştirerek zengin bir sıcak içecek yaratır. "
                            + "Çikolata ve kahve uyumuna romun sıcak tatlı notaları eşlik eder.",
                    "1 shot espresso • 15–20 g kakao veya çikolata sosu • 20–30 ml rom • 150–180 ml süt",
                    "Rom ekledikten sonra sadece ısıt; kaynama noktasına çıkartma.",
                    "Tatlı ve hafif alkollü sıcak içecek arayanlar için zengin bir alternatif.",
                    "alcoholic",
                    "M – 240 ml"
            ),

            new Recipe(
                    R.drawable.cup_spanish_mocha,
                    "Spanish Mocha",
                    "Sütlü çikolata, kahve ve likör dokunuşu.",
                    "Spanish mocha, sütlü çikolata ve kahve uyumuna hafif likör dokunuşu ekleyerek hazırlanır. "
                            + "Tatlı, yoğun ve uzun içimli bir kahve kokteylidir.",
                    "1 shot espresso • 20–30 ml çikolata sosu • 20–30 ml kahve veya fındık likörü • 150–180 ml süt",
                    "Şeker seviyesini kontrol etmek için önce çikolata miktarını ayarla, sonra likörü ekle.",
                    "Tatlı içecekleri seviyorsan ve kahveden vazgeçemiyorsan tatlı barista dokunuşu gibi hissettirir.",
                    "alcoholic",
                    "M – 240 ml"
            ),

            // endregion

            // region ICED

            new Recipe(
                    R.drawable.cup_iced_americano,
                    "Iced Americano",
                    "Espresso + buz ve soğuk su.",
                    "Iced americano, espresso shot’un buz ve soğuk su ile uzatılmasıyla hazırlanır. "
                            + "Hafif, ferah ve hızlı içimli bir soğuk kahve sunar.",
                    "1–2 shot espresso • Buz • 150–200 ml soğuk su",
                    "Espressoyu biraz ılıttıktan sonra buzla buluştur; ani ısı farkı tadı bozmasın.",
                    "Yaz aylarında siyah kahveden vazgeçmeden serinlemek için basit ve etkili yöntem.",
                    "iced",
                    "L – 350 ml"
            ),

            new Recipe(
                    R.drawable.cup_iced_latte,
                    "Iced Latte",
                    "Buz üzerinde hafif sütlü kahve.",
                    "Iced latte, sıcak latteye göre daha hafif dokulu, buzlu ve ferah bir alternatiftir. "
                            + "Kahve aroması belirgin, süt ayarı hafif tatlılıkta tutulur.",
                    "1–2 shot espresso • Buz • 150–200 ml soğuk süt",
                    "Bardağın yarısını buzla doldur, önce espressoyu ekle, sonra sütle tamamla.",
                    "Tatlı sevmeyen ama buzlu, sütlü kahve isteyenler için ideal günlük içecek.",
                    "iced",
                    "L – 350 ml"
            ),

            new Recipe(
                    R.drawable.cup_iced_mocha,
                    "Iced Mocha",
                    "Çikolatalı, buzlu sütlü kahve.",
                    "Iced mocha, soğuk süt, buz, espresso ve çikolata karışımıdır. "
                            + "Sanki içilebilir bir kahveli milkshake hissi verir.",
                    "1 shot espresso • 20–25 ml çikolata sosu • Buz • 150 ml soğuk süt",
                    "Çikolatayı espressoyla karıştırıp çözdükten sonra buz ve süt ekle.",
                    "Tatlı ama çok ağır olmayan kahveli tatlı arayanlar için günlük kaçamak.",
                    "iced",
                    "L – 350 ml"
            ),

            new Recipe(
                    R.drawable.cup_iced_breve,
                    "Iced Breve",
                    "Kremamsı, yoğun buzlu sütlü kahve.",
                    "Iced breve, sıcak versiyonuna göre daha ferah, ama hâlâ çok kremamsı ve yoğun bir içecektir. "
                            + "Half & half ile hazırlanır, gövdesi yüksektir.",
                    "1 shot espresso • Buz • 150 ml soğuk half & half",
                    "Bardağı fazla buzla doldur; kremamsı yapı ağır olduğu için seyreltmeye yardımcı olur.",
                    "Tatlı ve yoğun sütlü kahve sevenler için yazlık lüks dokunuş.",
                    "iced",
                    "L – 350 ml"
            ),

            new Recipe(
                    R.drawable.cup_affogato_freddo,
                    "Affogato Freddo",
                    "Soğuk espresso + dondurma, yazlık affogato.",
                    "Affogato freddo, soğutulmuş espresso veya soğuk demleme kahve ile dondurmanın birleşimidir. "
                            + "Sıcak affogato’ya göre daha ferah ve yaz akşamlarına uygun bir tatlı–kahve hibritidir.",
                    "1 top dondurma • 60–80 ml soğuk espresso veya cold brew",
                    "Kahveyi çok sulandırmadan konsantre kullan; dondurma eridikçe içecek hafifler.",
                    "Dondurma ve kahveyi aynı anda sevenler için yazın vazgeçilmez ritüeli olabilir.",
                    "iced",
                    "S – 150 ml"
            ),

            // endregion

            // region TURKISH (5 TARİF, AYNI BARDAK)

            new Recipe(
                    R.drawable.cup_t_70ml,
                    "Klasik Türk Kahvesi",
                    "Köz kokulu, ince telveli geleneksel kahve.",
                    "Klasik Türk kahvesi, ince öğütülmüş kahvenin cezvede yavaşça ısıtılmasıyla hazırlanır. "
                            + "Telvesiyle servis edilir, köpüğü bol ve kıvamı ipeksi olmalıdır.",
                    "1 fincan için: 6–7 g kahve • 60–70 ml soğuk su. "
                            + "Şeker oranı: şekersiz için şeker yok, az şekerli için 1 çay kaşığı, orta için 2, şekerli için 3 çay kaşığı.",
                    "Karışımı cezvede hiç kaynatmadan, kenarlardan hafif kabarmaya başlayınca ocaktan al.",
                    "Köpüğü paylaşılmaz derler ama sen ister tek fincana ister eşitçe dağıtabilirsin.",
                    "turkish",
                    "S – 70 ml"
            ),

            new Recipe(
                    R.drawable.cup_t_70ml,
                    "Sütlü Türk Kahvesi",
                    "Sütle yumuşamış, kremamsı Türk kahvesi.",
                    "Sütlü Türk kahvesi, klasiğe göre daha yumuşak, kremamsı ve tatlı bir profilde olur. "
                            + "Sütün bir kısmı su yerine kullanılır; telve yapısı korunur.",
                    "1 fincan için: 4–5 g kahve • 40 ml süt + 30 ml su. "
                            + "Şeker: damak zevkine göre 1–2 çay kaşığı.",
                    "Süt taşmaya meyilli olduğu için çok kısık ateşte, kontrollü ısıt.",
                    "Sade Türk kahvesi sana sert geliyorsa, sütlü yorum iyi bir başlangıç olabilir.",
                    "turkish",
                    "S – 70 ml"
            ),

            new Recipe(
                    R.drawable.cup_t_70ml,
                    "Dibek Kahvesi",
                    "Daha iri öğütüm, kremsi ve hafif dokulu.",
                    "Dibek kahvesi, daha iri çekilmiş ve genellikle karışım aromalar içeren bir Türk kahvesi yorumudur. "
                            + "Klasik Türk kahvesine göre daha kremamsı ve hafif gövdeli hissedilir.",
                    "1 fincan için: 6–7 g dibek kahvesi • 60–70 ml su. "
                            + "Şeker: arzuya göre 1–2 çay kaşığı.",
                    "Karıştırırken topak kalmamasına dikkat et; iri öğütüm bazen yüzeye toplanabilir.",
                    "Misafire sunumda lokum veya hurmayla birlikte servis edildiğinde çok şık durur.",
                    "turkish",
                    "S – 70 ml"
            ),

            new Recipe(
                    R.drawable.cup_t_70ml,
                    "Menengiç Kahvesi",
                    "Kafeinsiz, fıstıksı aromalı sıcak içecek.",
                    "Menengiç kahvesi, kahve çekirdeği yerine menengiç ağacının meyvelerinden yapılır. "
                            + "Kafeinsizdir, yoğun fıstıksı ve aromatik bir tada sahiptir.",
                    "1 fincan için: 1–1,5 tatlı kaşığı menengiç karışımı • 60–70 ml süt veya su. "
                            + "Şeker: damak zevkine göre.",
                    "Sütle yaparsan daha kremamsı, suyla yaparsan daha hafif bir içim elde edersin.",
                    "Kafein tüketmek istemeyenler için Türk kahvesi geleneğine alternatif sıcak içecek.",
                    "turkish",
                    "S – 70 ml"
            ),

            new Recipe(
                    R.drawable.cup_t_70ml,
                    "Damla Sakızlı Türk Kahvesi",
                    "Klasik Türk kahvesine hafif sakız dokunuşu.",
                    "Damla sakızlı Türk kahvesi, klasik tarife küçük miktarda damla sakız eklenerek hazırlanır. "
                            + "Burnunda hafif sakız kokusu, damakta tatlımsı ve aromatik bir bitiş bırakır.",
                    "1 fincan için: 6–7 g kahve • 60–70 ml su • Çok küçük bir parça damla sakız. "
                            + "Şeker: şekersiz/az/orta/şekerli için 0–3 çay kaşığı.",
                    "Damla sakızı miktarını abartma; az miktar bile güçlü aroma verir.",
                    "Türk kahvesi ritüeline küçük ama karakterli bir dokunuş eklemenin en pratik yolu.",
                    "turkish",
                    "S – 70 ml"
            )

            // endregion
    );

    /**
     * Tüm tarifleri döndürür (kopya liste).
     */
    public static List<Recipe> getAll() {
        return new ArrayList<>(RECIPES);
    }

    /**
     * Kategoriye göre filtreler. categoryKey null/boş ise tüm tarifleri döndürür.
     * Kategoriler: espresso, filter, special, alcoholic, iced, turkish
     */
    public static List<Recipe> getByCategory(String categoryKey) {
        List<Recipe> out = new ArrayList<>();
        if (categoryKey == null || categoryKey.trim().isEmpty()) {
            out.addAll(RECIPES);
            return out;
        }

        String key = categoryKey.trim().toLowerCase();
        for (Recipe r : RECIPES) {
            if (r.getCategory().toLowerCase().equals(key)) {
                out.add(r);
            }
        }
        return out;
    }

    /**
     * Detay ekranında okunabilir kategori adı göstermek için.
     * Kullanılmıyorsa da zararı yok.
     */
    public static String categoryLabel(String key) {
        if (key == null) return "";
        switch (key.toLowerCase()) {
            case "espresso":
                return "Espresso Bazlı Kahveler";
            case "filter":
                return "Filtre ve Demleme Yöntemleri";
            case "special":
                return "Özel Tarifler";
            case "alcoholic":
                return "Alkollü Kahveler";
            case "iced":
                return "Soğuk Kahveler";
            case "turkish":
                return "Türk Kahveleri";
            default:
                return key;
        }
    }
}