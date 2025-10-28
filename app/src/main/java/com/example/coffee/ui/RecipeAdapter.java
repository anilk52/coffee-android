package com.example.coffee.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {

    public interface OnRecipeClick { void onClick(Recipe r); }

    private final List<Recipe> all = new ArrayList<>();
    private final List<Recipe> shown = new ArrayList<>();
    private final OnRecipeClick onClick;

    public RecipeAdapter(OnRecipeClick onClick) {
        this.onClick = onClick;
    }

    public void submit(List<Recipe> items) {
        all.clear();
        if (items != null) all.addAll(items);
        filter(null);
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
                String cat  = safe(r.getCategory());
                if (name.contains(s) || desc.contains(s) || cat.contains(s)) {
                    shown.add(r);
                }
            }
        }
        notifyDataSetChanged();
    }

    private static String safe(String s) { return s == null ? "" : s.toLowerCase(); }

    @NonNull
    @Override public VH onCreateViewHolder(@NonNull ViewGroup p, int v) {
        View view = LayoutInflater.from(p.getContext()).inflate(R.layout.item_recipe, p, false);
        return new VH(view);
    }

    @Override public void onBindViewHolder(@NonNull VH h, int pos) {
        Recipe r = shown.get(pos);
        h.txtTitle.setText(r.getName());
        h.txtSubtitle.setText(safe(r.getDescription()).isEmpty() ? " " : r.getDescription());
        h.chipCategory.setText(safe(r.getCategory()).isEmpty() ? "Kahve" : r.getCategory());
        if (r.getImageResId() != 0) h.img.setImageResource(r.getImageResId());
        h.itemView.setOnClickListener(v -> { if (onClick != null) onClick.onClick(r); });
    }

    @Override public int getItemCount() { return shown.size(); }

    static class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTitle, txtSubtitle;
        Chip chipCategory;
        VH(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.img);
            txtTitle = v.findViewById(R.id.txtTitle);
            txtSubtitle = v.findViewById(R.id.txtSubtitle);
            chipCategory = v.findViewById(R.id.chipCategory);
        }
    }
}