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
import com.example.coffee.util.FavoritesStore;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.Holder> {

    private final Context ctx;
    private final List<Recipe> items;

    public RecipeAdapter(Context ctx, List<Recipe> items) {
        this.ctx = ctx;
        this.items = items;
    }

    @NonNull @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder h, int pos) {
        Recipe r = items.get(pos);

        h.txtTitle.setText(r.getName());
        String sub = (r.getDescription() != null ? r.getDescription() : "") +
                (r.getSize() != null && !r.getSize().isEmpty() ? " • " + r.getSize() : "");
        h.txtSub.setText(sub.trim());

        if (r.getImageResId() != 0) h.imgThumb.setImageResource(r.getImageResId());
        else h.imgThumb.setImageResource(R.drawable.ic_placeholder_logo);

        // Favori yıldızı
        setStar(h.btnFav, FavoritesStore.isFav(ctx, r.getName()));
        h.btnFav.setOnClickListener(v -> {
            FavoritesStore.toggle(ctx, r.getName());
            setStar(h.btnFav, FavoritesStore.isFav(ctx, r.getName()));
        });

        // Detaya geçiş
        h.itemView.setOnClickListener(v -> {
            Intent i = new Intent(ctx, RecipeDetailActivity.class);
            i.putExtra("recipe", r);
            ctx.startActivity(i);
        });
    }

    private void setStar(ImageView iv, boolean fav) {
        iv.setImageResource(fav ? android.R.drawable.btn_star_big_on
                                : android.R.drawable.btn_star_big_off);
    }

    @Override public int getItemCount() { return items.size(); }

    static class Holder extends RecyclerView.ViewHolder {
        ImageView imgThumb, btnFav;
        TextView txtTitle, txtSub;
        Holder(@NonNull View v) {
            super(v);
            imgThumb = v.findViewById(R.id.imgThumb);
            btnFav   = v.findViewById(R.id.btnFav);
            txtTitle = v.findViewById(R.id.txtTitle);
            txtSub   = v.findViewById(R.id.txtSub);
        }
    }
}