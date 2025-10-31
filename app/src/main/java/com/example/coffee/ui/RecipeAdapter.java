package com.example.coffee.ui;

import android.content.Context;
import android.text.TextUtils;
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

    public interface OnItemClick { void onClick(Recipe item); }

    private final Context ctx;
    private final OnItemClick onItemClick;
    private final List<Recipe> all = new ArrayList<>();
    private final List<Recipe> shown = new ArrayList<>();

    public RecipeAdapter(Context ctx, OnItemClick onItemClick) {
        this.ctx = ctx;
        this.onItemClick = onItemClick;
    }

    public void submit(List<Recipe> data) {
        all.clear();
        shown.clear();
        if (data != null) {
            all.addAll(data);
            shown.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void filter(String q) {
        shown.clear();
        if (TextUtils.isEmpty(q)) {
            shown.addAll(all);
        } else {
            String needle = q.toLowerCase();
            for (Recipe r : all) {
                if (r.getName().toLowerCase().contains(needle) ||
                        r.getShortDesc().toLowerCase().contains(needle)) {
                    shown.add(r);
                }
            }
        }
        notifyDataSetChanged();
    }

    @NonNull @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder h, int pos) {
        Recipe r = shown.get(pos);
        h.txtTitle.setText(r.getName());

        String sub = r.getShortDesc() + " • " + r.getCupSize();
        h.txtSub.setText(sub);

        int res = r.getImageResId();             // Recipe.java’da ekledik
        if (res != 0) h.imgThumb.setImageResource(res);
        else h.imgThumb.setImageResource(R.drawable.logo_bdino); // fallback

        h.card.setOnClickListener(v -> onItemClick.onClick(r));
    }

    @Override
    public int getItemCount() { return shown.size(); }

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