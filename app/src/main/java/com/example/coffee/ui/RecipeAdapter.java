package com.example.coffee.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffee.R;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Esnek Adapter:
 * - Model sınıfına bağımlı değil (Reflection ile okur)
 * - item_recipe.xml içinde şu ID’leri bekler: imgThumb, txtTitle, txtSub (opsiyonel: btnFav)
 * - Detay ekranına, sadece Intent extras ile veri gönderir
 */
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {

    private final Context ctx;
    private final List<Object> data = new ArrayList<>();

    public RecipeAdapter(@NonNull Context ctx, @NonNull List<?> items) {
        this.ctx = ctx;
        this.data.addAll(items);
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_recipe, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Object r = data.get(position);

        // Görsel
        int imageRes = getIntProp(r, "getImageRes", "getImage", "getImageId", "imageRes", "getImg");
        if (imageRes == 0) imageRes = R.drawable.ic_placeholder_logo;
        h.imgThumb.setImageResource(imageRes);

        // Başlık / Alt metin
        String name = getStringProp(r, "getName", "name");
        String desc = getStringProp(r, "getDescription", "getShortDesc", "description");
        String size = getStringProp(r, "getMeasure", "measure", "getCupSize", "cupSize", "size");

        h.txtTitle.setText(nz(name));
        if (h.txtSub != null) {
            String sub = buildSubtitle(desc, size);
            h.txtSub.setText(sub);
            h.txtSub.setVisibility(TextUtils.isEmpty(sub) ? View.GONE : View.VISIBLE);
        }

        // Tık → Detay
        final int imgToSend = imageRes;
        h.itemView.setOnClickListener(v -> {
            Intent it = new Intent(ctx, RecipeDetailActivity.class);
            it.putExtra(RecipeDetailActivity.K_IMAGE,   imgToSend);
            it.putExtra(RecipeDetailActivity.K_NAME,    nz(getStringProp(r, "getName", "name")));
            it.putExtra(RecipeDetailActivity.K_DESC,    nz(getStringProp(r, "getDescription", "getShortDesc", "description")));
            it.putExtra(RecipeDetailActivity.K_MEASURE, nz(getStringProp(r, "getMeasure", "measure", "getCupSize", "cupSize", "size")));

            // method/steps alanı – hangisi varsa onu gönder
            String method = getStringProp(r, "getMethod", "method", "getSteps", "steps", "getRecipe");
            if (TextUtils.isEmpty(method)) method = desc; // yoksa desc yolla
            it.putExtra(RecipeDetailActivity.K_METHOD,  nz(method));

            it.putExtra(RecipeDetailActivity.K_TIP,     nz(getStringProp(r, "getTip", "tip")));
            it.putExtra(RecipeDetailActivity.K_NOTE,    nz(getStringProp(r, "getNote", "note")));
            ctx.startActivity(it);
        });

        // Favori butonu (varsa)
        if (h.btnFav != null) {
            h.btnFav.setOnClickListener(v -> {
                // Geçici: tıkta anim/feedback; kalıcı favori için sonra prefs ekleyeceğiz
                v.setSelected(!v.isSelected());
                v.animate().rotationBy(360f).setDuration(300).start();
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // --- ViewHolder ---
    static class VH extends RecyclerView.ViewHolder {
        ImageView imgThumb;
        TextView txtTitle;
        TextView txtSub;      // opsiyonel
        ImageButton btnFav;   // opsiyonel

        VH(@NonNull View v) {
            super(v);
            imgThumb = v.findViewById(R.id.imgThumb);
            txtTitle = v.findViewById(R.id.txtTitle);
            txtSub   = v.findViewById(R.id.txtSub);
            btnFav   = v.findViewById(R.id.btnFav);
        }
    }

    // --- Yardımcılar ---
    private static String nz(String s) { return s == null ? "" : s; }

    private static String buildSubtitle(String desc, String size) {
        String d = nz(desc).trim();
        String s = nz(size).trim();
        if (!TextUtils.isEmpty(d) && !TextUtils.isEmpty(s)) return d + " • " + s;
        if (!TextUtils.isEmpty(d)) return d;
        return s;
    }

    private static String getStringProp(Object obj, String... candidates) {
        for (String m : candidates) {
            try {
                Method method = obj.getClass().getMethod(m);
                Object val = method.invoke(obj);
                if (val != null) return String.valueOf(val);
            } catch (Exception ignored) {}
        }
        return "";
    }

    private static int getIntProp(Object obj, String... candidates) {
        for (String m : candidates) {
            try {
                Method method = obj.getClass().getMethod(m);
                Object val = method.invoke(obj);
                if (val instanceof Number) return ((Number) val).intValue();
                if (val != null) return Integer.parseInt(String.valueOf(val));
            } catch (Exception ignored) {}
        }
        return 0;
    }
}