package com.example.coffee.model;

import java.io.Serializable;

public class Recipe implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int imageResId;
    private final String name;
    private final String shortDesc;   // liste alt metni için (opsiyonel)
    private final String description; // detay açıklama
    private final String measure;     // ölçü/boyut metni
    private final String tip;         // barista ipucu
    private final String note;        // eğlenceli not
    private final String category;    // ESPRESSO / FILTER / ...
    private final String size;        // "M – 240 ml" gibi

    public Recipe(int imageResId,
                  String name,
                  String shortDesc,
                  String description,
                  String measure,
                  String tip,
                  String note,
                  String category,
                  String size) {
        this.imageResId = imageResId;
        this.name = name;
        this.shortDesc = shortDesc;
        this.description = description;
        this.measure = measure;
        this.tip = tip;
        this.note = note;
        this.category = category;
        this.size = size;
    }

    public int getImageResId() { return imageResId; }

    public String getName() { return name != null ? name : ""; }

    public String getShortDesc() { return shortDesc != null ? shortDesc : ""; }

    public String getDescription() { return description != null ? description : ""; }

    public String getMeasure() { return measure != null ? measure : ""; }

    public String getTip() { return tip != null ? tip : ""; }

    public String getNote() { return note != null ? note : ""; }

    public String getCategory() { return category != null ? category : ""; }

    public String getSize() { return size != null ? size : ""; }
}