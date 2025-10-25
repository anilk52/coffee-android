package com.bdino.coffee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.VH> {

    interface OnCoffeeClickListener { void onCoffeeClick(String name); }

    private final List<String> items;
    private final OnCoffeeClickListener listener;

    public CoffeeAdapter(List<String> items, OnCoffeeClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_coffee, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        String name = items.get(position);
        holder.title.setText(name);
        holder.itemView.setOnClickListener(v -> listener.onCoffeeClick(name));
    }

    @Override
    public int getItemCount() { return items.size(); }

    static class VH extends RecyclerView.ViewHolder {
        TextView title;
        VH(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
        }
    }
}
