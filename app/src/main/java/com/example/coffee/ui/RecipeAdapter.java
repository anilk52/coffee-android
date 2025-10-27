package com.example.coffee.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {

    public interface OnRecipeClick {
        void onClick(Recipe r);
    }

    private final List<Recipe> all = new ArrayList<>();
    private final List<Recipe> shown = new ArrayList<>();
    private final OnRecipeClick onClick;

    public RecipeAdapter(OnRecipeClick onClick) {
        this.onClick = onClick;
    }

    public void submit(List<Recipe> items) {
        all.clear();
        shown.clear();
        if (items != null) {
            all.addAll(items);
            shown.addAll(items);
        }
        notifyDataSetChanged();
    }

    public void filter(String q) {
        shown.clear();
        if (q == null || q.trim().isEmpty()) {
            shown.addAll(all);
        } else {
            String s = q.trim().toLowerCase();
            for (Recipe r : all) {
                String name = safe(r.getName());
                String desc = safe(r.getDescription());
                if (name.contains(s) || desc.contains(s)) {
                    shown.add(r);
                }
            }
        }
        notifyDataSetChanged();
    }

    private static String safe(String s) { return s == null ? "" : s.toLowerCase(); }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup p, int v) {
        View view = LayoutInflater.from(p.getContext()).inflate(R.layout.item_recipe, p, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int pos) {
        Recipe r = shown.get(pos);
        h.title.setText(r.getName());
        h.subtitle.setText(r.getDescription() == null ? "" : r.getDescription());

        // Görsel
        if (r.getImageResId() != 0) {
            h.img.setImageResource(r.getImageResId());
        } else {
            h.img.setImageResource(R.drawable.ic_launcher_foreground);
        }

        // Kategori etiket
        String cat = r.getCategory() == null ? "Kahve" : r.getCategory();
        h.chip.setText(cat);

        // Boyut gösterimi:
        // Alkollü kategoride sabit servis kullan (ör: "Standart servis: 250 ml")
        if (cat.equalsIgnoreCase("ALKOLLÜ") || cat.equalsIgnoreCase("ALKOLLU")) {
            // Eğer RecipesData içinde cupSize ayarlı değilse bu default kullanılacak
            String sizeText = (r.getCupSize() != null && !r.getCupSize().trim().isEmpty())
                    ? r.getCupSize()
                    : "Standart servis: 250 ml";
            h.size.setText(sizeText);
        } else {
            // Diğer kategoriler için cupSize göster (örn. "M — 240 ml")
            String sizeText = (r.getCupSize() != null && !r.getCupSize().trim().isEmpty())
                    ? r.getCupSize()
                    : ""; // boşsa gösterme
            h.size.setText(sizeText);
        }

        // İpucu varsa göster, yoksa gizle
        if (r.getTip() != null && !r.getTip().trim().isEmpty()) {
            h.tip.setVisibility(View.VISIBLE);
            h.tip.setText(r.getTip());
        } else {
            h.tip.setVisibility(View.GONE);
        }

        h.itemView.setOnClickListener(v -> {
            if (onClick != null) onClick.onClick(r);
        });
    }

    @Override public int getItemCount() { return shown.size(); }

    static class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title, subtitle, chip, size, tip;
        VH(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.img);
            title = v.findViewById(R.id.txtTitle);
            subtitle = v.findViewById(R.id.txtSubtitle);
            chip = v.findViewById(R.id.chipCategory);
            size = v.findViewById(R.id.txtSize);
            tip = v.findViewById(R.id.txtTip);
        }
    }
}