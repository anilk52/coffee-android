package com.example.coffee.model;

import androidx.annotation.DrawableRes;

public class Recipe {
    private final String name;
    private final String description;
    private final String category;
    private final String cupSize;   // Bardak boyutu (ör: L — 300 ml)
    private final String tips;      // Barista ipucu
    @DrawableRes
    private final int imageResId;

    public Recipe(String name, String description, String category, int imageResId, String cupSize, String tips) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.imageResId = imageResId;
        this.cupSize = cupSize;
        this.tips = tips;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getCupSize() {
        return cupSize;
    }

    public String getTips() {
        return tips;
    }
}