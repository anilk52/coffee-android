package com.example.coffee.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> implements Filterable {

    private final Context context;
    private final List<Recipe> original;   // tam liste
    private List<Recipe> filtered;         // ekranda gösterilen liste

    public RecipeAdapter(Context context, List<Recipe> items) {
        this.context = context;
        this.original = new ArrayList<>(items);
        this.filtered = new ArrayList<>(items);
        setHasStableIds(true);
    }

    // Dışarıdan veri güncellemek için
    public void setItems(List<Recipe> items) {
        original.clear();
        original.addAll(items);
        filtered = new ArrayList<>(items);
        notifyDataSetChanged();
    }

    public Recipe getItem(int position) {
        return filtered.get(position);
    }

    @Override public long getItemId(int position) {
        // Stabil ID: başlığa göre hash
        return filtered.get(position).getTitle().hashCode();
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
        Recipe item = filtered.get(position);

        h.txtTitle.setText(item.getTitle());
        h.txtSubtitle.setText(item.getSubtitle());

        int imgRes = (item.getImageResId() != 0) ? item.getImageResId() : R.drawable.logo_bdino;
        h.imgThumb.setImageResource(imgRes);

        h.card.setOnClickListener(v -> {
            Intent i = new Intent(context, RecipeDetailActivity.class);
            i.putExtra(RecipeDetailActivity.EXTRA_TITLE, item.getTitle());
            i.putExtra(RecipeDetailActivity.EXTRA_SUBTITLE, item.getSubtitle());
            i.putExtra(RecipeDetailActivity.EXTRA_IMAGE, item.getImageResId());
            i.putExtra(RecipeDetailActivity.EXTRA_SIZE, item.getSizeNote());
            i.putExtra(RecipeDetailActivity.EXTRA_TIP, item.getTip());
            i.putExtra(RecipeDetailActivity.EXTRA_INSTRUCTIONS, item.getInstructions());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return filtered.size();
    }

    // ---------- Filterable (arama kutusu için) ----------
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence query) {
                String q = query == null ? "" : query.toString().trim().toLowerCase();
                List<Recipe> out = new ArrayList<>();
                if (q.isEmpty()) {
                    out.addAll(original);
                } else {
                    for (Recipe r : original) {
                        if (r.getTitle().toLowerCase().contains(q)
                                || r.getSubtitle().toLowerCase().contains(q)) {
                            out.add(r);
                        }
                    }
                }
                FilterResults fr = new FilterResults();
                fr.values = out;
                fr.count = out.size();
                return fr;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filtered = (List<Recipe>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    // ---------- ViewHolder ----------
    static class VH extends RecyclerView.ViewHolder {
        CardView card;
        ImageView imgThumb;
        TextView txtTitle, txtSubtitle;

        VH(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cardRoot);
            imgThumb = itemView.findViewById(R.id.imgThumb);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtSubtitle = itemView.findViewById(R.id.txtSubtitle);
        }
    }
}