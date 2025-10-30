package com.example.coffee.ui;

import android.content.Context;
import android.text.TextUtils;
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
import java.util.Locale;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.Holder> implements Filterable {

    public interface OnItemClick { void onClick(Recipe item); }

    private final Context context;
    private final List<Recipe> original = new ArrayList<>();
    private final List<Recipe> visible = new ArrayList<>();
    private OnItemClick onItemClick;

    public RecipeAdapter(@NonNull Context ctx, @NonNull List<Recipe> initial) {
        this.context = ctx;
        setItems(initial);
    }

    public void setOnItemClick(OnItemClick l) { this.onItemClick = l; }

    public void setItems(@NonNull List<Recipe> data) {
        original.clear();
        original.addAll(data);
        visible.clear();
        visible.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder h, int position) {
        final Recipe r = visible.get(position);

        h.txtTitle.setText(safe(r.getName()));
        String meta = joinNonEmpty(" • ",
                safe(r.getShortDesc()),
                safe(r.getCupSize()));
        h.txtMeta.setText(meta);

        int res = r.getImageResId();
        if (res != 0) {
            h.imgThumb.setImageResource(res);
        } else {
            // Projede placeholder yoksa bile derlensin diye Android ikonunu kullandım
            h.imgThumb.setImageResource(android.R.drawable.ic_menu_gallery);
        }

        h.card.setOnClickListener(v -> {
            if (onItemClick != null) onItemClick.onClick(r);
        });
    }

    @Override
    public int getItemCount() { return visible.size(); }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override protected FilterResults performFiltering(CharSequence constraint) {
                String q = constraint == null ? "" : constraint.toString().toLowerCase(Locale.ROOT).trim();
                List<Recipe> out = new ArrayList<>();
                if (TextUtils.isEmpty(q)) {
                    out.addAll(original);
                } else {
                    for (Recipe r : original) {
                        if (!TextUtils.isEmpty(r.getName())
                                && r.getName().toLowerCase(Locale.ROOT).contains(q)) {
                            out.add(r);
                        }
                    }
                }
                FilterResults fr = new FilterResults();
                fr.values = out;
                fr.count = out.size();
                return fr;
            }

            @Override protected void publishResults(CharSequence constraint, FilterResults results) {
                visible.clear();
                if (results != null && results.values instanceof List) {
                    //noinspection unchecked
                    visible.addAll((List<Recipe>) results.values);
                }
                notifyDataSetChanged();
            }
        };
    }

    private static String safe(String s) { return s == null ? "" : s; }

    private static String joinNonEmpty(String sep, String... parts) {
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            if (p != null && !p.trim().isEmpty()) {
                if (sb.length() > 0) sb.append(sep);
                sb.append(p.trim());
            }
        }
        return sb.toString();
    }

    static class Holder extends RecyclerView.ViewHolder {
        CardView card;
        ImageView imgThumb;
        TextView txtTitle, txtMeta;

        Holder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cardRoot);
            imgThumb = itemView.findViewById(R.id.imgThumb);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtMeta = itemView.findViewById(R.id.txtMeta);
        }
    }
}