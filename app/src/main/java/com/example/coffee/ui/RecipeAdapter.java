package com.example.coffee.ui;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {

    private final List<Recipe> data;
    private final List<Recipe> original; // basit arama için

    public RecipeAdapter(List<Recipe> data) {
        this.data = data;
        this.original = new ArrayList<>(data);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Recipe r = data.get(position);
        Context ctx = h.itemView.getContext();

        h.imgThumb.setImageResource(r.getImageResId());
        h.txtTitle.setText(r.getName());
        h.txtSub.setText(r.getShortDesc() + " • " + r.getCupSize());

        h.itemView.setOnClickListener(v -> {
            Intent i = new Intent(ctx, RecipeDetailActivity.class);
            i.putExtra("recipe", r);
            ctx.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // Basit arama (opsiyonel)
    public void filter(String query) {
        data.clear();
        if (query == null || query.trim().isEmpty()) {
            data.addAll(original);
        } else {
            String q = query.toLowerCase(Locale.getDefault());
            for (Recipe r : original) {
                if ((r.getName() != null && r.getName().toLowerCase(Locale.getDefault()).contains(q)) ||
                    (r.getShortDesc() != null && r.getShortDesc().toLowerCase(Locale.getDefault()).contains(q)) ||
                    (r.getCategory() != null && r.getCategory().toLowerCase(Locale.getDefault()).contains(q))) {
                    data.add(r);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class VH extends RecyclerView.ViewHolder {
        ImageView imgThumb;
        TextView txtTitle, txtSub;
        VH(@NonNull View itemView) {
            super(itemView);
            imgThumb = itemView.findViewById(R.id.imgThumb);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtSub   = itemView.findViewById(R.id.txtSub);
        }
    }
}