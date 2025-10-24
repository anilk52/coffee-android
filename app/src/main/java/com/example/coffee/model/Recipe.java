package com.example.coffee.model;

public class Recipe {
    private final String title;
    private final String ingredients; // newline-joined
    private final String steps;       // newline-joined (description yerine)
    private final String tips;        // optional

    public Recipe(String title, String ingredients, String steps, String tips) {
        this.title = nz(title);
        this.ingredients = nz(ingredients);
        this.steps = nz(steps);
        this.tips = nz(tips);
    }

    /** Eski koda uyumluluk: description'u steps'e mapler. */
    @Deprecated
    public Recipe(String title, String description) {
        this.title = nz(title);
        this.ingredients = "";
        this.steps = nz(description);
        this.tips = "";
    }

    public String getTitle() { return title; }
    public String getIngredients() { return ingredients; }
    public String getSteps() { return steps; }
    public String getTips() { return tips; }

    public boolean hasIngredients() { return !ingredients.isEmpty(); }
    public boolean hasSteps() { return !steps.isEmpty(); }
    public boolean hasTips() { return !tips.isEmpty(); }

    private static String nz(String s) { return s == null ? "" : s; }
}
