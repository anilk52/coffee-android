package com.example.coffee.model;

import androidx.annotation.DrawableRes;

public class Recipe {
    private final String title;
    private final String subtitle;      // kısa tanım
    private final int category;         // kategori id
    @DrawableRes private final int imageResId;
    private final String sizeNote;      // bardak/ölçü bilgisi
    private final String tip;           // barista ipucu
    private final String instructions;  // *** adım adım tarif ***

    public Recipe(String title, String subtitle, int category, int imageResId,
                  String sizeNote, String tip, String instructions) {
        this.title = title;
        this.subtitle = subtitle;
        this.category = category;
        this.imageResId = imageResId;
        this.sizeNote = sizeNote;
        this.tip = tip;
        this.instructions = instructions;
    }

    public String getTitle() { return title; }
    public String getSubtitle() { return subtitle; }
    public int getCategory() { return category; }
    public int getImageResId() { return imageResId; }
    public String getSizeNote() { return sizeNote; }
    public String getTip() { return tip; }
    public String getInstructions() { return instructions; }
}