package com.example.coffee.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;
import com.example.coffee.ui.RecipeDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    public static final String EXTRA_RECIPE = "extra_recipe";

    private final Context context;
    private List<Recipe> items;

    public RecipeAdapter(Context context, List<Recipe> items) {
        this.context = context;
        this.items = (items != null) ? items : new ArrayList<>();
    }

    public void updateList(List<Recipe> newList) {
        this.items = (newList != null) ? newList : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new RecipeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = items.get(position);

        holder.txtName.setText(recipe.getName());
        holder.txtShortDesc.setText(recipe.getShortDesc());

        if (recipe.getImageResId() != 0) {
            holder.imgRecipe.setImageResource(recipe.getImageResId());
        } else {
            holder.imgRecipe.setImageResource(R.drawable.ic_placeholder_logo);
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, RecipeDetailActivity.class);
            intent.putExtra(EXTRA_RECIPE, recipe);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class RecipeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRecipe;
        TextView txtName;
        TextView txtShortDesc;

        RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRecipe = itemView.findViewById(R.id.imgRecipe);
            txtName = itemView.findViewById(R.id.txtName);
            txtShortDesc = itemView.findViewById(R.id.txtShortDesc);
        }
    }
}