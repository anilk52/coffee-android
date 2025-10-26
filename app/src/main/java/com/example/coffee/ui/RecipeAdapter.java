package com.example.coffee.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {

    public interface OnRecipeClick {
        void onClick(Recipe r);
    }

    private final List<Recipe> all = new ArrayList<>();
    private final OnRecipeClick onClick;

    public RecipeAdapter(OnRecipeClick onClick) {
        this.onClick = onClick;
    }

    public void submit(List<Recipe> items) {
        all.clear();
        if (items != null) all.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Recipe r = all.get(position);
        holder.title.setText(r.getName());
        holder.subtitle.setText(r.getDescription());
        holder.chip.setText(r.getCategory());
        holder.img.setImageResource(r.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            if (onClick != null) onClick.onClick(r);
        });
    }

    @Override
    public int getItemCount() {
        return all.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title, subtitle;
        Chip chip;
        VH(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.img);
            title = v.findViewById(R.id.txtTitle);
            subtitle = v.findViewById(R.id.txtSubtitle);
            chip = v.findViewById(R.id.chipCategory);
        }
    }
}