package com.example.coffee.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {

    public interface OnItemClick { void onClick(Recipe item); }

    private final OnItemClick onItemClick;
    private final List<Recipe> all = new ArrayList<>();
    private final List<Recipe> shown = new ArrayList<>();

    public RecipeAdapter(@NonNull OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public void submit(@NonNull List<Recipe> data) {
        all.clear();
        all.addAll(data);
        shown.clear();
        shown.addAll(data);
        notifyDataSetChanged();
    }

    public void filter(@Nullable String query) {
        shown.clear();
        if (query == null || query.trim().isEmpty()) {
            shown.addAll(all);
        } else {
            String q = query.toLowerCase();
            for (Recipe r : all) {
                if (r.getName().toLowerCase().contains(q)) {
                    shown.add(r);
                }
            }
        }
        notifyDataSetChanged();
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        final Recipe r = shown.get(position);
        h.txtName.setText(r.getName());
        h.txtDesc.setText(r.getDescription());

        // 🔹 Placeholder yerine BDINO logoyu koyuyoruz
        int imgRes = (r.getImageResId() != 0)
                ? r.getImageResId()
                : R.drawable.logo_bdino;

        h.img.setImageResource(imgRes);
        h.itemView.setOnClickListener(v -> onItemClick.onClick(r));
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