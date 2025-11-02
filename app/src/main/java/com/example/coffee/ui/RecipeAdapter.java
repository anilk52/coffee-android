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

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {
    private final Context ctx;
    private final List<Object> data = new ArrayList<>();

    public RecipeAdapter(@NonNull Context ctx, @NonNull List<?> items) {
        this.ctx = ctx; this.data.addAll(items);
    }

    @NonNull @Override public VH onCreateViewHolder(@NonNull ViewGroup p, int vt) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_recipe, p, false);
        return new VH(v);
    }

    @Override public void onBindViewHolder(@NonNull VH h, int pos) {
        Object r = data.get(pos);

        String name = gs(r, "getName","name");
        String desc = gs(r, "getDescription","getShortDesc","description");
        String size = gs(r, "getMeasure","measure","getCupSize","cupSize","size");
        int img = gi(r, "getImageRes","getImage","getImageId","imageRes","getImg");
        if (img == 0) img = R.drawable.ic_placeholder_logo;

        h.imgThumb.setImageResource(img);
        h.txtTitle.setText(nz(name));
        String sub = buildSub(desc, size);
        if (h.txtSub != null) {
            h.txtSub.setText(sub);
            h.txtSub.setVisibility(TextUtils.isEmpty(sub) ? View.GONE : View.VISIBLE);
        }

        // —— Tahmini SÜRE & ZORLUK ——
        String n = (name == null ? "" : name).toLowerCase();
        String estTime, diff;
        if (n.contains("espresso") || n.contains("ristretto") || n.contains("doppio")) {
            estTime = "0:30"; diff = "Zor";
        } else if (n.contains("v60") || n.contains("chemex") || n.contains("syphon") || n.contains("kalita")) {
            estTime = "3:00"; diff = "Orta";
        } else if (n.contains("turk")) {
            estTime = "2:30"; diff = "Kolay";
        } else if (n.contains("iced")) {
            estTime = "1:30"; diff = "Kolay";
        } else {
            estTime = "2:00"; diff = "Kolay";
        }

        // —— Tat Profili & Ekipman (otomatik) ——
        String taste = guessTaste(n);
        String gear  = guessGear(n);

        final int fImg = img;
        h.itemView.setOnClickListener(v -> {
            Intent it = new Intent(ctx, RecipeDetailActivity.class);
            it.putExtra(RecipeDetailActivity.K_IMAGE,   fImg);
            it.putExtra(RecipeDetailActivity.K_NAME,    nz(name));
            it.putExtra(RecipeDetailActivity.K_DESC,    nz(desc));
            it.putExtra(RecipeDetailActivity.K_MEASURE, nz(size));
            String method = gs(r, "getMethod","method","getSteps","steps","getRecipe");
            if (TextUtils.isEmpty(method)) method = desc;
            it.putExtra(RecipeDetailActivity.K_METHOD,  nz(method));

            it.putExtra("total_time", estTime);
            it.putExtra("difficulty", diff);
            it.putExtra("taste_profile", taste);
            it.putExtra("equipment", gear);

            ctx.startActivity(it);
        });

        if (h.btnFav != null) {
            h.btnFav.setOnClickListener(v -> v.animate().rotationBy(360f).setDuration(250).start());
        }
    }

    @Override public int getItemCount() { return data.size(); }

    static class VH extends RecyclerView.ViewHolder {
        ImageView imgThumb; TextView txtTitle; TextView txtSub; ImageButton btnFav;
        VH(@NonNull View v) {
            super(v);
            imgThumb = v.findViewById(R.id.imgThumb);
            txtTitle = v.findViewById(R.id.txtTitle);
            txtSub   = v.findViewById(R.id.txtSub);
            btnFav   = v.findViewById(R.id.btnFav);
        }
    }

    // ——— Heuristics ———
    private String guessTaste(String n) {
        if (n.contains("mocha") || n.contains("brulee") || n.contains("pistachio") || n.contains("honey") || n.contains("rose") || n.contains("spanish"))
            return "Tatlı & aromatik";
        if (n.contains("latte") || n.contains("flat") || n.contains("capp") || n.contains("breve"))
            return "Sütlü & yumuşak";
        if (n.contains("espresso") || n.contains("ristretto") || n.contains("doppio") || n.contains("macchiato"))
            return "Yoğun & gövdeli";
        if (n.contains("v60") || n.contains("chemex") || n.contains("kalita") || n.contains("pour"))
            return "Temiz & canlı asidite";
        if (n.contains("turk"))
            return "Yoğun & dengeli";
        if (n.contains("irish") || n.contains("rum") || n.contains("baileys"))
            return "Likör etkili, tatlı";
        if (n.contains("iced") || n.contains("freddo") || n.contains("cold"))
            return "Ferah & hafif";
        return "Dengeli";
    }

    private String guessGear(String n) {
        if (n.contains("espresso") || n.contains("ristretto") || n.contains("doppio") || n.contains("macchiato") || n.contains("conpanna"))
            return "Espresso makinesi";
        if (n.contains("mokapot") || n.contains("moka"))
            return "Moka pot";
        if (n.contains("v60"))
            return "V60 dripper + filtre";
        if (n.contains("chemex"))
            return "Chemex + filtre";
        if (n.contains("kalita"))
            return "Kalita Wave + filtre";
        if (n.contains("syphon"))
            return "Sifon (Syphon)";
        if (n.contains("french"))
            return "French Press";
        if (n.contains("percolator"))
            return "Percolator";
        if (n.contains("aeropress"))
            return "AeroPress";
        if (n.contains("turk"))
            return "Cezve / İbrik";
        if (n.contains("martini") || n.contains("affogato") || n.contains("freddo") || n.contains("iced"))
            return "Shaker / bardak + buz";
        return "Kupa / bardak";
    }

    // ——— Helpers ———
    private static String nz(String s){ return s==null?"":s; }
    private static String buildSub(String d,String s){
        d=nz(d).trim(); s=nz(s).trim();
        if (!TextUtils.isEmpty(d) && !TextUtils.isEmpty(s)) return d+" • "+s;
        return !TextUtils.isEmpty(d) ? d : s;
    }
    private static String gs(Object o, String... c){ for(String m:c){ try{
        Method md=o.getClass().getMethod(m); Object v=md.invoke(o);
        if(v!=null) return String.valueOf(v);
    }catch(Exception ignored){}} return ""; }
    private static int gi(Object o, String... c){ for(String m:c){ try{
        Method md=o.getClass().getMethod(m); Object v=md.invoke(o);
        if(v instanceof Number) return ((Number)v).intValue();
        if(v!=null) return Integer.parseInt(String.valueOf(v));
    }catch(Exception ignored){}} return 0; }
}