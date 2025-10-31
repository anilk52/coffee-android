package com.example.coffee.model;

import java.io.Serializable;

public class Recipe implements Serializable {
    private final String name;
    private final String description;   // kısa açıklama (liste için)
    private final String steps;         // tam tarif / adımlar (detay için)
    private final int category;         // RecipesData.CAT_*
    private final int imageResId;       // R.drawable.*
    private final String cupSize;       // örn: "150 ml fincan"

    public Recipe(String name, String description, String steps,
                  int category, int imageResId, String cupSize) {
        this.name = name;
        this.description = description;
        this.steps = steps;
        this.category = category;
        this.imageResId = imageResId;
        this.cupSize = cupSize;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getSteps() { return steps; }
    public int getCategory() { return category; }
    public int getImageResId() { return imageResId; }
    public String getCupSize() { return cupSize; }
}