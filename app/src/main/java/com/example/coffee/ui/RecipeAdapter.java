package com.example.coffee.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.Holder> {

    private final Context context;
    private final List<Recipe> list = new ArrayList<>();
    private final List<Recipe> filtered = new ArrayList<>();

    public RecipeAdapter(Context context, List<Recipe> recipes) {
        this.context = context;
        if (recipes != null) {
            list.addAll(recipes);
            filtered.addAll(recipes);
        }
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder h, int position) {
        Recipe r = filtered.get(position);

        h.txtTitle.setText(r.getName());
        h.txtSub.setText(r.getShortDesc() + " • " + r.getCupSize());

        int res = r.getImageResId();
        if (res != 0) h.imgThumb.setImageResource(res);
        else h.imgThumb.setImageResource(R.drawable.logo_bdino);

        h.card.setOnClickListener(v -> RecipeDetailActivity.start(context, r));
    }

    @Override
    public int getItemCount() {
        return filtered.size();
    }

    public void submit(List<Recipe> recipes) {
        list.clear();
        filtered.clear();
        if (recipes != null) {
            list.addAll(recipes);
            filtered.addAll(recipes);
        }
        notifyDataSetChanged();
    }

    public void filter(String query) {
        filtered.clear();
        if (query == null || query.trim().isEmpty()) {
            filtered.addAll(list);
        } else {
            String q = query.toLowerCase();
            for (Recipe r : list) {
                if (r.getName().toLowerCase().contains(q) ||
                    r.getShortDesc().toLowerCase().contains(q)) {
                    filtered.add(r);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class Holder extends RecyclerView.ViewHolder {
        CardView card;
        ImageView imgThumb;
        TextView txtTitle, txtSub;

        Holder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cardRoot);
            imgThumb = itemView.findViewById(R.id.imgThumb);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtSub = itemView.findViewById(R.id.txtSub);
        }
    }
}