package com.example.coffee.model;

import java.io.Serializable;

public class Recipe implements Serializable {
    public final String title;
    public final String ingredients; // çok satırlı metin
    public final String steps;       // çok satırlı metin
    public final String tip;         // opsiyonel ipucu

    public Recipe(String title, String ingredients, String steps, String tip) {
        this.title = title;
        this.ingredients = ingredients;
        this.steps = steps;
        this.tip = tip;
    }
}
