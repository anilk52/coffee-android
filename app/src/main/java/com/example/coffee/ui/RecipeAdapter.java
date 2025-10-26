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

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private final List<Recipe> allRecipes = new ArrayList<>();
    private final List<Recipe> filteredRecipes = new ArrayList<>();
    private final OnRecipeClick listener;

    public interface OnRecipeClick {
        void onClick(Recipe recipe);
    }

    public RecipeAdapter(OnRecipeClick listener) {
        this.listener = listener;
    }

    public void submit(List<Recipe> data) {
        allRecipes.clear();
        filteredRecipes.clear();
        if (data != null) {
            allRecipes.addAll(data);
            filteredRecipes.addAll(data);
        }
        notifyDataSetChanged();
    }

    /** Arama veya filtreleme için **/
    public void filter(String query) {
        filteredRecipes.clear();
        if (query == null || query.trim().isEmpty()) {
            filteredRecipes.addAll(allRecipes);
        } else {
            String lower = query.toLowerCase();
            for (Recipe r : allRecipes) {
                if (r.getName().toLowerCase().contains(lower)
                        || r.getDescription().toLowerCase().contains(lower)) {
                    filteredRecipes.add(r);
                }
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe recipe = filteredRecipes.get(position);
        holder.txtName.setText(recipe.getName());
        holder.txtDesc.setText(recipe.getDescription());
        holder.img.setImageResource(recipe.getImageRes());
        holder.itemView.setOnClickListener(v -> listener.onClick(recipe));
    }

    @Override
    public int getItemCount() {
        return filteredRecipes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtDesc;
        ImageView img;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            img = itemView.findViewById(R.id.img);
        }
    }
}