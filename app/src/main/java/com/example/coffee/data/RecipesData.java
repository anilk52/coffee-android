package com.example.coffee.data;

import com.example.coffee.R;
import com.example.coffee.model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecipesData {

    private RecipesData() {}

    // Kategori sabitleri
    public static final String CAT_ESPRESSO  = "ESPRESSO";
    public static final String CAT_FILTER    = "FILTER";
    public static final String CAT_SPECIAL   = "SPECIAL";
    public static final String CAT_ALCOHOLIC = "ALCOHOLIC";
    public static final String CAT_ICED      = "ICED";
    public static final String CAT_TURKISH   = "TURKISH";

    private static final List<Recipe> ALL = new ArrayList<>();

    static {
        // NOT: imageResId şimdilik garanti için placeholder.
        // Bardak görsellerinin kesin adları netleşince sadece bu alanları ilgili cup_*.png ile değiştir.
        // Örn: R.drawable.cup_m_240, R.drawable.cup_t_70, vb.

        // ESPRESSO (2)
        ALL.add(new Recipe(
                R.drawable.ic_placeholder_logo,
                "Espresso",
                "Yoğun, kısa çekim",
                "18–20 g kahveden ~25–30 sn’de 25–30 ml çıkış alınır.",
                "S – 30 ml",
                "Taze öğüt, 9 bar, 92–