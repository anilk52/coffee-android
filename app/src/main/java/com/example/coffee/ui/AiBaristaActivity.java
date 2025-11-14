package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffee.R;

public class AiBaristaActivity extends AppCompatActivity {

    private ImageView imgHero;
    private TextView txtCoffeeName;
    private EditText edtQuestion;
    private Button btnSend;
    private Button btnVoice;   // Şimdilik placeholder
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
        imgHero         = findViewById(R.id.imgHero);
        txtCoffeeName   = findViewById(R.id.txtCoffeeName);
        edtQuestion     = findViewById(R.id.edtQuestion);
        btnSend         = findViewById(R.id.btnSend);
        btnVoice        = findViewById(R.id.btnVoice);
        txtAnswerTitle  = findViewById(R.id.txtAnswerTitle);
        txtAnswerBody   = findViewById(R.id.txtAnswerBody);

        // Intent'ten tarif bilgilerini al (RecipeDetailActivity'den geleceğini varsayıyoruz)
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
        }

        // Gönder butonu
        btnSend.setOnClickListener(v -> {
            String question = edtQuestion.getText().toString().trim();
            if (question.isEmpty()) {
                edtQuestion.setError("Önce AI Barista'ya bir şey sor 😊");
                return;
            }

            // Şimdilik sahte (rule-based) cevap.
            // İleride burada Gemma / gerçek LLM entegrasyonu yapacağız.
            String answer = generateOfflineAdvice(question);

            txtAnswerTitle.setVisibility(View.VISIBLE);
            txtAnswerBody.setVisibility(View.VISIBLE);
            txtAnswerBody.setText(answer);
        });

        // Sesle sor butonu (şimdilik pasif / TODO)
        btnVoice.setOnClickListener(v ->
                // Buraya ileride ses tanıma eklenecek
                edtQuestion.setError("Sesle soru özelliği yakında 😊")
        );
    }

    private String safeGetString(Intent intent, String key) {
        String s = intent.getStringExtra(key);
        return s != null ? s : "";
    }

    /**
     * İlk sürüm için basit, "akıllıymış gibi" duran kural tabanlı cevap.
     * Sonraki aşamada burayı gerçek offline LLM (Gemma) ile değiştireceğiz.
     */
    private String generateOfflineAdvice(String question) {
        StringBuilder sb = new StringBuilder();

        // Başlık
        if (!TextUtils.isEmpty(coffeeName)) {
            sb.append("Şu an ")
              .append(coffeeName)
              .append(" üzerine konuşuyoruz.\n\n");
        } else {
            sb.append("Seçili kahve için bazı önerilerim var.\n\n");
        }

        String qLower = question.toLowerCase();

        // Yoğunluk / güçlü tat
        if (qLower.contains("yoğun") || qLower.contains("güçlü") || qLower.contains("sert")) {
            sb.append("• Daha yoğun bir fincan için:\n");
            sb.append("  - Öğütümü bir tık incelt.\n");
            sb.append("  - Demleme / akış süresini 3–5 saniye uzat.\n");
            sb.append("  - Aynı bardak boyutunda daha az su / süt kullanmayı dene.\n\n");
        }

        // Hafif / yumuşak
        if (qLower.contains("hafif") || qLower.contains("yumuşak")) {
            sb.append("• Daha hafif bir fincan için:\n");
            sb.append("  - Öğütümü bir tık kalınlaştır.\n");
            sb.append("  - Demleme süresini biraz kısalt.\n");
            sb.append("  - Bardak hacmini büyütüp süt/su miktarını arttırabilirsin.\n\n");
        }

        // Sıcaklık
        if (qLower.contains("sıcak") || qLower.contains("yanık") || qLower.contains("acı")) {
            sb.append("• Kahve fazla sıcak veya yanık geliyorsa:\n");
            sb.append("  - Su sıcaklığını 1–2°C düşür.\n");
            sb.append("  - Espresso için çok uzun akış sürelerinden kaçın (özellikle 35–40 sn üzeri).\n");
            sb.append("  - Sütü buharlarken 60–65°C bandını geçmemeye çalış.\n\n");
        }

        // Krema / köpük
        if (qLower.contains("krema") || qLower.contains("köpük") || qLower.contains("foam")) {
            sb.append("• Krema / süt köpüğü için:\n");
            sb.append("  - Sütü 55–60°C arasında bitir, bu aralık en tatlı hissi verir.\n");
            sb.append("  - Buhar ucunu sütün yüzeyine yakın tut, büyük baloncukları en sona doğru yok et.\n");
            sb.append("  - Tamamen homojen, ıslak boya kıvamı hedefle.\n\n");
        }

        // Süre / timer
        if (qLower.contains("süre") || qLower.contains("kaç saniye") || qLower.contains("kaç dk")) {
            sb.append("• Süreyi ayarlarken:\n");
            sb.append("  - Espresso için genellikle 25–35 saniye aralığı iyi bir başlangıç noktasıdır.\n");
            sb.append("  - Filtre kahvede toplam demleme süresi çoğu reçetede 2:30–4:00 dakikadır.\n\n");
        }

        // Eğer yukarıdaki bloklardan hiçbiri tetiklenmezse genel tavsiye
        if (sb.toString().trim().isEmpty() ||
                sb.toString().trim().equals("Şu an " + coffeeName + " üzerine konuşuyoruz.")) {
            sb.append("Genel bir tavsiye istersen:\n");
            sb.append("• Her denemede sadece tek bir parametreyi değiştir (süre, öğütüm, gramaj veya süt miktarı).\n");
            sb.append("• Böylece fincandaki değişimin nereden kaynaklandığını çok daha rahat anlarsın.\n\n");
        }

        // Tariften gelen ölçü / ipucu bilgilerini ekle
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

        sb.append("\nUnutma, damak zevki kişisel; küçük dokunuşlarla kendi Bdino reçeteni oluşturabilirsin. ☕");

        return sb.toString();
    }
}