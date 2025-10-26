package com.example.coffee.model;

import androidx.annotation.DrawableRes;

public class Recipe {
    private final String name;
    private final String description;
    private final String category;
    @DrawableRes
    private final int imageResId;
    private final String cupSize; // ör: "L — 300 ml (Tall)"
    private final String tip;     // barista ipucu

    public Recipe(String name, String description, String category, int imageResId, String cupSize, String tip) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.imageResId = imageResId;
        this.cupSize = cupSize;
        this.tip = tip;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public int getImageResId() { return imageResId; }
    public String getCupSize() { return cupSize; }
    public String getTip() { return tip; }
}
