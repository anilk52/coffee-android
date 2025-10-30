package com.example.coffee.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Recipe {
    private final String name;
    private final String shortDesc;
    private final String category;   // "ESPRESSO","FILTER","SPECIAL","ALCOHOLIC","ICED","TURKISH"
    private final int imageResId;    // 0 ise adapter fallback ikon gösterir
    private final String cupSize;

    public Recipe(@NonNull String name,
                  @Nullable String shortDesc,
                  @NonNull String category,
                  @DrawableRes int imageResId,
                  @Nullable String cupSize) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.category = category;
        this.imageResId = imageResId;
        this.cupSize = cupSize;
    }

    public String getName() { return name; }
    public String getShortDesc() { return shortDesc; }
    public String getCategory() { return category; }
    public int getImageResId() { return imageResId; }
    public String getCupSize() { return cupSize; }
}