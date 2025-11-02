package com.example.coffee.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.MainActivity;
import com.example.coffee.R;
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecipeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView emptyView;
    private EditText search;
    private RecipeAdapter adapter;

    private final List<Recipe> all = new ArrayList<>();
    private final List<Recipe> shown = new ArrayList<>();
    private String category;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        category = getIntent().getStringExtra(MainActivity.EXTRA_CATEGORY);
        if (category == null) category = "";

        recyclerView = findViewById(R.id.recyclerView);
        emptyView    = findViewById(R.id.emptyView);
        search       = findViewById(R.id.inputSearch);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecipeAdapter(shown);
        recyclerView.setAdapter(adapter);

        // TÜM tarifleri al, kategoriye göre filtrele
        List<Recipe> fromData = RecipesData.getAll(this); // JSON/asset okuyan mevcut metod
        all.clear();
        if (fromData != null) all.addAll(fromData);

        applyCategory();
        applySearch("");

        // Arama
        search.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int st, int c, int a) {}
            @Override public void onTextChanged(CharSequence s, int st, int b, int c) { applySearch(s.toString()); }
            @Override public void afterTextChanged(Editable s) {}
        });

        setTitle(category.isEmpty() ? getString(R.string.app_name) : category);
    }

    private void applyCategory() {
        shown.clear();
        for (Recipe r : all) {
            // Recipe.getCategory() içeriği: "Espresso", "Filtre", "Special", "Alkollü", "Iced", "Türk"
            if (equalsIgnoreTrTr(r.getCategory(), category)) {
                shown.add(r);
            }
        }
        adapter.notifyDataSetChanged();
        updateEmpty();
    }

    private void applySearch(String q) {
        q = q == null ? "" : q.trim().toLowerCase(Locale.getDefault());
        if (q.isEmpty()) { // sadece kategori filtresi kalsın
            applyCategory();
            return;
        }
        List<Recipe> base = new ArrayList<>();
        for (Recipe r : all) if (equalsIgnoreTrTr(r.getCategory(), category)) base.add(r);

        shown.clear();
        for (Recipe r : base) {
            String hay = (r.getName()+" "+r.getShortDesc()+" "+r.getMeasure()).toLowerCase(Locale.getDefault());
            if (hay.contains(q)) shown.add(r);
        }
        adapter.notifyDataSetChanged();
        updateEmpty();
    }

    private void updateEmpty() {
        boolean isEmpty = shown.isEmpty();
        emptyView.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
        recyclerView.setVisibility(isEmpty ? View.GONE   : View.VISIBLE);
    }

    // Türkçe/İngilizce küçük-büyük ve aksan içeren eşleşmelerde gevşek karşılaştırma
    private boolean equalsIgnoreTrTr(String a, String b) {
        if (a == null || b == null) return false;
        return a.trim().equalsIgnoreCase(b.trim());
    }
}