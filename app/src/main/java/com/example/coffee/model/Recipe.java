package com.example.coffee.model;

import java.io.Serializable;

public class Recipe implements Serializable {
    private final int imageResId;
    private final String name;
    private final String shortDesc;
    private final String description;
    private final String measure;
    private final String tip;
    private final String note;
    private final String category;  // ESPRESSO / FILTER / ...
    private final String cupSize;   // T-70 ml / S-150 ml ...

    public Recipe(int imageResId,
                  String name,
                  String shortDesc,
                  String description,
                  String measure,
                  String tip,
                  String note,
                  String category,
                  String cupSize) {
        this.imageResId = imageResId;
        this.name = name;
        this.shortDesc = shortDesc;
        this.description = description;
        this.measure = measure;
        this.tip = tip;
        this.note = note;
        this.category = category;
        this.cupSize = cupSize;
    }

    public int getImageResId() { return imageResId; }
    public String getName() { return name; }
    public String getShortDesc() { return shortDesc; }
    public String getDescription() { return description; }
    public String getMeasure() { return measure; }
    public String getTip() { return tip; }
    public String getNote() { return note; }
    public String getCategory() { return category; }
    public String getCupSize() { return cupSize; }
}