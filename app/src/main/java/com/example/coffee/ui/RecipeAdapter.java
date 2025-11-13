package com.example.coffee.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;
import com.example.coffee.ui.RecipeDetailActivity;

import java.util.List;

// 🔴 ÖNEMLİ: BURAYI KENDİ PROJENE GÖRE KONTROL ET
// Recipe.java dosyanı aç, en üst satırına bak:
//  - Eğer "package com.example.coffee.data;" yazıyorsa, bu satır DOĞRU:
//        import com.example.coffee.data.Recipe;
//  - Eğer "package com.example.coffee;" yazıyorsa, bunu:
//        import com.example.coffee.Recipe;
//    yapacaksın.
//  - Eğer "package com.example.coffee.model;" yazıyorsa:
//        import com.example.coffee.model.Recipe;
//  gibi.
//
// Şu anda en mantıklı ve sık görülen ihtimal:
import com.example.coffee.data.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private final Context context;
    private final List<Recipe> recipeList;

    public RecipeAdapter(Context context, List<Recipe> recipeList) {
        this.context = context;
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recipe, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);

        // Kart içeriğini doldur
        holder.txtTitle.setText(recipe.getTitle());
        holder.txtSubtitle.setText(recipe.getShortDescription());
        holder.imgThumb.setImageResource(recipe.getImageResId());

        // Kart tıklanınca doğru tarife git
        holder.cardContainer.setOnClickListener(v -> {
            int adapterPos = holder.getAdapterPosition();
            if (adapterPos == RecyclerView.NO_POSITION) return;

            Recipe clicked = recipeList.get(adapterPos);

            Intent intent = new Intent(context, RecipeDetailActivity.class);

            // Görsel
            intent.putExtra("imageResId", clicked.getImageResId());

            // Metinler
            intent.putExtra("title",       clicked.getTitle());
            intent.putExtra("description", clicked.getDescription());
            intent.putExtra("measure",     clicked.getMeasure());
            intent.putExtra("size",        clicked.getSize());
            intent.putExtra("tip",         clicked.getTip());
            intent.putExtra("note",        clicked.getNote());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return recipeList != null ? recipeList.size() : 0;
    }

    // 🔥 RecipeActivity ve FavoritesActivity'nin çağırdığı metod
    public void updateList(List<Recipe> newList) {
        recipeList.clear();
        recipeList.addAll(newList);
        notifyDataSetChanged();
    }

    static class RecipeViewHolder extends RecyclerView.ViewHolder {

        CardView cardContainer;
        ImageView imgThumb;
        TextView txtTitle;
        TextView txtSubtitle;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);

            cardContainer = itemView.findViewById(R.id.cardContainer);
            imgThumb      = itemView.findViewById(R.id.imgThumb);
            txtTitle      = itemView.findViewById(R.id.txtTitle);
            txtSubtitle   = itemView.findViewById(R.id.txtSubtitle);
        }
    }
}