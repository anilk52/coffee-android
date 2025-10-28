package com.example.coffee.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class Recipe {
    private final String name;
    private final String description;
    private final String category;   // CAT_ESPRESSO, CAT_FILTRE, ...
    private final String size;       // “S — 30 ml” gibi
    private final String tips;       // barista ipucu
    @DrawableRes private final int imageResId;

    public Recipe(@NonNull String name,
                  @NonNull String description,
                  @NonNull String category,
                  @DrawableRes int imageResId,
                  @NonNull String size,
                  @NonNull String tips) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.imageResId = imageResId;
        this.size = size;
        this.tips = tips;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }  // ← BUNA GÜVENELİM
    public String getCategory() { return category; }
    public int getImageResId() { return imageResId; }
    public String getSize() { return size; }
    public String getTips() { return tips; }
}