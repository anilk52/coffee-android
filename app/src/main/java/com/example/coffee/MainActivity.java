package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.ui.RecipeActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.topAppBar));

        rv = findViewById(R.id.rvCategories);
        rv.setLayoutManager(new GridLayoutManager(this, 2));

        // 6 kategori
        List<String> cats = Arrays.asList(
                "Espresso", "Filtre", "Special", "Alkollü", "Ice", "Türk"
        );
        rv.setAdapter(new SimpleCategoryAdapter(cats, name -> {
            Intent i = new Intent(this, RecipeActivity.class);
            i.putExtra("category", name);
            startActivity(i);
        }));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            // Basit: RecipeActivity'e kategori olmadan git -> tüm liste
            Intent i = new Intent(this, RecipeActivity.class);
            startActivity(i);
            return true;
        } else if (id == R.id.action_favorites) {
            // Şimdilik placeholder
            return true;
        } else if (id == R.id.action_settings) {
            // Şimdilik placeholder
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Basit adapter (ihtiyaç kadar inline)
    static class SimpleCategoryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<VH> {
        interface OnClick { void onCat(String name); }
        private final List<String> data;
        private final OnClick onClick;
        SimpleCategoryAdapter(List<String> data, OnClick onClick) { this.data = data; this.onClick = onClick; }
        @NonNull @Override public VH onCreateViewHolder(@NonNull android.view.ViewGroup p, int v) {
            android.view.View vw = android.view.LayoutInflater.from(p.getContext()).inflate(R.layout.item_category, p, false);
            return new VH(vw);
        }
        @Override public void onBindViewHolder(@NonNull VH h, int pos) {
            String name = data.get(pos);
            h.txt.setText(name);
            h.itemView.setOnClickListener(v -> onClick.onCat(name));
        }
        @Override public int getItemCount() { return data.size(); }
    }

    static class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.ImageView img;
        android.widget.TextView txt;
        VH(@NonNull android.view.View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txt = itemView.findViewById(R.id.txt);
        }
    }
}