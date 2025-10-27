package com.example.coffee.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {

    public interface OnRecipeClick { void onRecipeClick(Recipe recipe); }

    private final List<Recipe> original;
    private final List<Recipe> items = new ArrayList<>();
    private final OnRecipeClick listener;

    public RecipeAdapter(List<Recipe> data, OnRecipeClick listener) {
        this.original = new ArrayList<>(data);
        this.items.addAll(data);
        this.listener = listener;
    }

    @NonNull @Override public VH onCreateViewHolder(@NonNull ViewGroup p, int vType) {
        View v = LayoutInflater.from(p.getContext()).inflate(R.layout.item_simple_row, p, false);
        return new VH(v);
    }

    @Override public void onBindViewHolder(@NonNull VH h, int pos) {
        Recipe r = items.get(pos);
        h.title.setText(r.getName());
        h.subtitle.setText(r.getDesc());
        h.itemView.setOnClickListener(v -> listener.onRecipeClick(r));
    }

    @Override public int getItemCount() { return items.size(); }

    public void filter(String q) {
        items.clear();
        if (q == null || q.trim().isEmpty()) {
            items.addAll(original);
        } else {
            String s = q.toLowerCase();
            for (Recipe r : original) {
                if (r.getName().toLowerCase().contains(s) ||
                    r.getSize().toLowerCase().contains(s)) {
                    items.add(r);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView title, subtitle;
        VH(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            subtitle = itemView.findViewById(R.id.txtSubtitle);
        }
    }
}