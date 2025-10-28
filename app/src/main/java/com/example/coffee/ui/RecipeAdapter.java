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

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {

    public interface OnRecipeClick { void onClick(Recipe r); }

    private final List<Recipe> all = new ArrayList<>();
    private final List<Recipe> shown = new ArrayList<>();
    private final OnRecipeClick onClick;

    public RecipeAdapter(OnRecipeClick onClick) { this.onClick = onClick; }

    public void submit(List<Recipe> list){
        all.clear();
        if (list != null) all.addAll(list);
        filter(null);
    }

    public void filter(String q){
        shown.clear();
        if (q == null || q.trim().isEmpty()){
            shown.addAll(all);
        } else {
            String s = q.trim().toLowerCase();
            for (Recipe r : all){
                String n = r.getName() == null ? "" : r.getName().toLowerCase();
                String d = r.getDescription() == null ? "" : r.getDescription().toLowerCase();
                if (n.contains(s) || d.contains(s)) shown.add(r);
            }
        }
        notifyDataSetChanged();
    }

    @NonNull @Override public VH onCreateViewHolder(@NonNull ViewGroup p, int v) {
        View view = LayoutInflater.from(p.getContext()).inflate(R.layout.item_recipe, p, false);
        return new VH(view);
    }

    @Override public void onBindViewHolder(@NonNull VH h, int pos) {
        Recipe r = shown.get(pos);
        h.txtName.setText(r.getName());
        h.txtDesc.setText(r.getDescription() == null ? "" : r.getDescription());
        if (r.getImageResId() != 0) h.img.setImageResource(r.getImageResId());
        h.itemView.setOnClickListener(v -> { if (onClick != null) onClick.onClick(r); });
    }

    @Override public int getItemCount() { return shown.size(); }

    static class VH extends RecyclerView.ViewHolder {
        ImageView img; TextView txtName; TextView txtDesc;
        VH(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txtName = itemView.findViewById(R.id.txtName);
            txtDesc = itemView.findViewById(R.id.txtDesc);
        }
    }
}