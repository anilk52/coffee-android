package com.example.coffee.model;

import androidx.annotation.DrawableRes;

public class Recipe {
    private final String name;
    private final String description;
    private final String category;
    @DrawableRes
    private final int imageResId;

    public Recipe(String name, String description, String category, int imageResId) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public int getImageResId() { return imageResId; }
}