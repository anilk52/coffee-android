package com.example.coffee.adapter;

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

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {

    public interface OnRecipeClick {
        void onClick(Recipe recipe);
    }

    private final LayoutInflater inflater;
    private final List<Recipe> data = new ArrayList<>();
    private final OnRecipeClick callback;

    public RecipeAdapter(Context ctx, List<Recipe> items, OnRecipeClick cb) {
        this.inflater = LayoutInflater.from(ctx);
        if (items != null) data.addAll(items);
        this.callback = cb;
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recipe, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Recipe r = data.get(position);

        // ---- BURADAKİ 3 SATIRI, SENDEKİ RECIPE GETTER ADLARINA GÖRE GEREKİRSE DEĞİŞTİR ----
        String name = safe(r.getName());           // Örn: getTitle() ise burayı getTitle() yap
        String desc = safe(r.getDesc());           // Örn: getDescription()
        int imgRes  = r.getImageResId();           // Örn: getImageRes() / getImage()
        // -------------------------------------------------------------------------------------

        h.txtName.setText(name);
        h.txtDesc.setText(desc);

        if (imgRes != 0) {
            h.img.setImageResource(imgRes);
            h.img.setVisibility(View.VISIBLE);
        } else {
            h.img.setImageDrawable(null);
            h.img.setVisibility(View.GONE);
        }

        h.card.setOnClickListener(v -> {
            if (callback != null) callback.onClick(r);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private String safe(String s) { return s == null ? "" : s; }

    static class VH extends RecyclerView.ViewHolder {
        CardView card;
        ImageView img;
        TextView txtName, txtDesc;
        VH(@NonNull View itemView) {
            super(itemView);
            card    = (CardView) itemView;
            img     = itemView.findViewById(R.id.img);
            txtName = itemView.findViewById(R.id.txtName);
            txtDesc = itemView.findViewById(R.id.txtDesc);
        }
    }
}