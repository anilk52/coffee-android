package com.example.coffee.model;

public class Recipe {
    private final String name;
    private final String desc;
    private final String category;
    private final int imageResId;
    private final String size;
    private final String tips;

    public Recipe(String name, String desc, String category, int imageResId, String size, String tips) {
        this.name = name;
        this.desc = desc;
        this.category = category;
        this.imageResId = imageResId;
        this.size = size;
        this.tips = tips;
    }

    public String getName() { return name; }
    public String getDesc() { return desc; }
    public String getCategory() { return category; }
    public int getImageResId() { return imageResId; }
    public String getSize() { return size; }
    public String getTips() { return tips; }
}