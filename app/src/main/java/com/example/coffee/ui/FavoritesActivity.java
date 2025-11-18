package com.example.coffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Favori kahveleri listeleyen ekran.
 * Şimdilik basit: Intent ile gelen favori listesi varsa onu gösterir,
 * yoksa boş mesajı gösterir.
 */
public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView recyclerFavorites;
    private TextView txtEmptyMessage;

    private RecipeAdapter adapter;
    private List<Recipe> favoriteList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        recyclerFavorites = findViewById(R.id.recyclerFavorites);
        txtEmptyMessage   = findViewById(R.id.txtEmptyMessage); // XML’de varsa kullanılır, yoksa null olur sorun değil

        recyclerFavorites.setLayoutManager(new LinearLayoutManager(this));

        // Eğer başka bir ekrandan "favorites" listesi gönderilmişse al
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("favorites")) {
            try {
                ArrayList<Recipe> passed =
                        (ArrayList<Recipe>) intent.getSerializableExtra("favorites");
                if (passed != null) {
                    favoriteList.clear();
                    favoriteList.addAll(passed);
                }
            } catch (Exception ignored) {
                // Bir sıkıntı olursa listeyi boş bırakırız
            }
        }

        // Adapter’i bağla
        adapter = new RecipeAdapter(this, favoriteList);
        recyclerFavorites.setAdapter(adapter);

        // Boşsa mesaj göster, doluysa gizle
        updateEmptyState();
    }

    private void updateEmptyState() {
        if (txtEmptyMessage == null) return;

        if (favoriteList == null || favoriteList.isEmpty()) {
            txtEmptyMessage.setVisibility(View.VISIBLE);
            txtEmptyMessage.setText("Henüz favorilere eklediğin bir kahve yok.\n" +
                    "Tarif detayından kalp ikonuna dokunarak favori ekleyebilirsin.");
        } else {
            txtEmptyMessage.setVisibility(View.GONE);
        }
    }
}