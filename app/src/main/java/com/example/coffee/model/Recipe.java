package com.example.coffee.model;

public class Recipe {
    private final String name;
    private final String shortDesc;
    private final String category;
    private final int imageRes;
    private final String cupSize;
    private final String tip;

    public Recipe(String name, String shortDesc, String category, int imageRes, String cupSize, String tip) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.category = category;
        this.imageRes = imageRes;
        this.cupSize = cupSize;
        this.tip = tip;
    }

    public String getName() { return name; }
    public String getShortDesc() { return shortDesc; }
    public String getCategory() { return category; }
    public int getImageRes() { return imageRes; }
    public String getCupSize() { return cupSize; }
    public String getDescription() { return shortDesc; }  // 💡 Detay ekranı buradan alacak
    public String getTip() { return tip; }
}