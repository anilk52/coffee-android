package com.example.coffee.model;

public class Recipe {
    private final String name;
    private final String shortDesc;   // listede görünen kısa açıklama (detayda da kullanıyoruz)
    private final String category;    // "Espresso", "Filter" vb.
    private final int imageRes;       // R.drawable...
    private final String cupSize;     // "300 ml kupa" gibi
    private final String tip;         // barista ipucu (opsiyonel)

    // Tam imza (6 parametre)
    public Recipe(String name, String shortDesc, String category, int imageRes, String cupSize, String tip) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.category = category;
        this.imageRes = imageRes;
        this.cupSize = cupSize;
        this.tip = tip == null ? "" : tip;
    }

    // Geriye dönük uyum: RecipesData 5 parametre gönderiyorsa buraya düşsün.
    public Recipe(String name, String shortDesc, String category, int imageRes, String cupSize) {
        this(name, shortDesc, category, imageRes, cupSize, "");
    }

    // --- Getters ---
    public String getName() { return name; }
    public String getShortDesc() { return shortDesc; }
    public String getDescription() { return shortDesc; } // Detay ekranı bunu çağırıyor
    public String getCategory() { return category; }
    public int getImageRes() { return imageRes; }

    // Geriye dönük uyum: Adapter'da getImageResId() çağrısı var.
    public int getImageResId() { return imageRes; }

    public String getCupSize() { return cupSize; }
    public String getTip() { return tip; }
}