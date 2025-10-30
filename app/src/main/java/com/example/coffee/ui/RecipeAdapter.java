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
import com.example.coffee.data.RecipesData;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> implements Filterable {

    public interface OnItemClick { void onClick(Recipe item); }

    private final Context context;
    private final List<Recipe> all = new ArrayList<>();
    private final List<Recipe> items = new ArrayList<>();
    private OnItemClick click;

    public RecipeAdapter(@NonNull Context ctx, @NonNull List<Recipe> initial) {
        this.context = ctx;
        setItems(initial);
    }

    public void setOnItemClick(OnItemClick c) { this.click = c; }

    public void setItems(@NonNull List<Recipe> newItems) {
        all.clear();
        all.addAll(newItems);
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int pos) {
        final Recipe r = items.get(pos);

        h.txtTitle.setText(r.getName());

        String sub = joinNonEmpty(" • ",
                safe(r.getShortDesc()),
                safe(RecipesData.categoryLabel(r.getCategory())),
                safe(r.getCupSize())
        );
        h.txtSubtitle.setText(sub);

        int imgRes = r.getImageResId() != 0 ? r.getImageResId() : R.drawable.logo_bdino;
        h.imgThumb.setImageResource(imgRes);

        h.card.setOnClickListener(v -> {
            if (click != null) click.onClick(r);
        });
    }

    @Override
    public int getItemCount() { return items.size(); }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override protected FilterResults performFiltering(CharSequence cs) {
                String q = cs == null ? "" : cs.toString().trim().toLowerCase();
                List<Recipe> out = new ArrayList<>();
                if (q.isEmpty()) {
                    out.addAll(all);
                } else {
                    for (Recipe r : all) {
                        if (r.getName().toLowerCase().contains(q)) out.add(r);
                    }
                }
                FilterResults fr = new FilterResults();
                fr.values = out;
                fr.count = out.size();
                return fr;
            }

            @Override protected void publishResults(CharSequence cs, FilterResults fr) {
                items.clear();
                if (fr.values instanceof List) {
                    //noinspection unchecked
                    items.addAll((List<Recipe>) fr.values);
                }
                notifyDataSetChanged();
            }
        };
    }

    static String safe(String s) { return TextUtils.isEmpty(s) ? "" : s; }

    static String joinNonEmpty(String sep, String... parts) {
        StringBuilder b = new StringBuilder();
        for (String p : parts) {
            if (!TextUtils.isEmpty(p)) {
                if (b.length() > 0) b.append(sep);
                b.append(p);
            }
        }
        return b.toString();
    }

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