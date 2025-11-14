package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;

public class AiBaristaActivity extends AppCompatActivity {

    private ImageView imgHero;
    private TextView txtCoffeeName;
    private EditText edtQuestion;
    private Button btnSend;
    private Button btnVoice;
    private TextView txtAnswerTitle;
    private TextView txtAnswerBody;

    private String coffeeName = "";
    private String coffeeDescription = "";
    private String coffeeMeasure = "";
    private String coffeeSize = "";
    private String coffeeTip = "";
    private String coffeeNote = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_barista);

        // View binding
        imgHero        = findViewById(R.id.imgHero);
        txtCoffeeName  = findViewById(R.id.txtCoffeeName);
        edtQuestion    = findViewById(R.id.edtQuestion);
        btnSend        = findViewById(R.id.btnSend);
        btnVoice       = findViewById(R.id.btnVoice);
        txtAnswerTitle = findViewById(R.id.txtAnswerTitle);
        txtAnswerBody  = findViewById(R.id.txtAnswerBody);

        // Intent ile gelen tarif bilgileri
        Intent intent = getIntent();
        int imageResId = intent.getIntExtra("imageResId", 0);
        if (imageResId != 0) {
            imgHero.setImageResource(imageResId);
        }

        coffeeName        = safeGetString(intent, "title");
        coffeeDescription = safeGetString(intent, "description");
        coffeeMeasure     = safeGetString(intent, "measure");
        coffeeSize        = safeGetString(intent, "size");
        coffeeTip         = safeGetString(intent, "tip");
        coffeeNote        = safeGetString(intent, "note");

        if (!TextUtils.isEmpty(coffeeName)) {
            txtCoffeeName.setText(coffeeName);
        } else {
            txtCoffeeName.setText("BDINO Coffee");
        }

        // Gönder butonu
        btnSend.setOnClickListener(v -> {
            String question = edtQuestion.getText().toString().trim();
            if (question.isEmpty()) {
                edtQuestion.setError("Önce AI Barista'ya bir şey sor 😊");
                return;
            }

            // 🔹 Stage 2: LLM için kullanılacak PROMPT burada oluşuyor
            String promptForModel = buildPromptForModel(question);

            // Şimdilik rule-based cevap: Stage 3'te burada Gemma/Phi çağıracağız
            String answer = generateOfflineAdvice(question, promptForModel);

            txtAnswerTitle.setVisibility(View.VISIBLE);
            txtAnswerBody.setVisibility(View.VISIBLE);
            txtAnswerBody.setText(answer);
        });

        // Sesle sor (şimdilik placeholder)
        btnVoice.setOnClickListener(v ->
                Toast.makeText(
                        AiBaristaActivity.this,
                        "Sesle soru özelliği yakında 😊",
                        Toast.LENGTH_SHORT
                ).show()
        );
    }

    private String safeGetString(Intent intent, String key) {
        String s = intent.getStringExtra(key);
        return s != null ? s : "";
    }

    /**
     * 🔥 Burası GEMMA / Phi gibi model için asıl PROMPT'u inşa eden kısım.
     * Stage 3'te bu string'i modele göndereceğiz.
     */
    private String buildPromptForModel(String question) {
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
     * Stage 1/2 için "akıllıymış gibi" duran kural tabanlı cevap.
     * Stage 3'te burası model cevabıyla değişecek.
     */
    private String generateOfflineAdvice(String question, String promptForModel) {
        StringBuilder sb = new StringBuilder();

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
        if (qLower.contains("ekşi") || qLower.contains("asid") || qLower.contains("yanık") || qLower.contains("acı")) {
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

        // Hiçbiri tetiklenmediyse genel tavsiye
        if (sb.toString().trim().equals("") ||
                sb.toString().trim().startsWith("Şu an ") && sb.toString().trim().split("\n").length <= 2) {
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

        // promptForModel şu an sadece Stage 3 için hazır, ister log’la ister sakla.
        // Örn: Log.d("BDINO_PROMPT", promptForModel);

        return sb.toString();
    }
}