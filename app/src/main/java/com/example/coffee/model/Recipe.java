package com.example.coffee.model;

public class Recipe {
    private final String title;
    private final String ingredients; // newline-joined
    private final String steps;       // newline-joined
    private final String tips;        // optional

    public Recipe(String title, String ingredients, String steps, String tips) {
        this.title = nz(title);
        this.ingredients = nz(ingredients);
        this.steps = nz(steps);
        this.tips = nz(tips);
    }

    /** Eski kodu kırmamak için: description artık yok; steps'e yönlendiriyoruz. */
    @Deprecated public String getDescription() { return steps; }
    @Deprecated public boolean hasDescription() { return hasSteps(); }

    public String getTitle() { return title; }
    public String getIngredients() { return ingredients; }
    public String getSteps() { return steps; }
    public String getTips() { return tips; }

    public boolean hasIngredients() { return !ingredients.isEmpty(); }
    public boolean hasSteps() { return !steps.isEmpty(); }
    public boolean hasTips() { return !tips.isEmpty(); }

    private static String nz(String s) { return s == null ? "" : s; }
}
