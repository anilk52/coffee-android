package com.example.coffee.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.data.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {

    public interface OnItemClick {
        void onClick(Recipe item);
    }

    private final LayoutInflater inflater;
    private final OnItemClick onItemClick;
    private final List<Recipe> items = new ArrayList<>();

    public RecipeAdapter(@NonNull Context ctx, @NonNull List<Recipe> initial,
                         @NonNull OnItemClick listener) {
        this.inflater = LayoutInflater.from(ctx);
        this.onItemClick = listener;
        if (initial != null) items.addAll(initial);
    }

    public void updateData(@NonNull List<Recipe> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recipe, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        final Recipe r = items.get(position);

        holder.txtName.setText(r.getName());
        holder.txtDesc.setText(r.getDesc());

        // Görsel yoksa placeholder göster
        int imgRes = r.getImageResId() != 0 ? r.getImageResId() : R.drawable.ic_placeholder_logo;
        holder.img.setImageResource(imgRes);

        holder.itemView.setOnClickListener(v -> {
            if (onItemClick != null) onItemClick.onClick(r);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtName;
        TextView txtDesc;

        VH(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txtName = itemView.findViewById(R.id.txtName);
            txtDesc = itemView.findViewById(R.id.txtDesc);
        }
    }
}