// app/src/main/java/com/example/coffee/model/Recipe.java
package com.example.coffee.model;

public class Recipe {
    private final String title;
    private final String ingredients; // newline-joined or markdown
    private final String steps;       // newline-joined or markdown
    private final String tips;        // optional notes

    // Yeni (asıl) ctor
    public Recipe(String title, String ingredients, String steps, String tips) {
        this.title = nz(title);
        this.ingredients = nz(ingredients);
        this.steps = nz(steps);
        this.tips = nz(tips);
    }

    // Geri uyum (eski kodlar kırılmasın diye)
    /** @deprecated Use Recipe(title, ingredients, steps, tips). */
    @Deprecated
    public Recipe(String title, String description) {
        this.title = nz(title);
        this.ingredients = "";
        this.steps = nz(description); // eski description'ı steps'e map’liyoruz
        this.tips = "";
    }

    public String getTitle()       { return title; }
    public String getIngredients() { return ingredients; }
    public String getSteps()       { return steps; }
    public String getTips()        { return tips; }

    // UI için pratik bayraklar
    public boolean hasIngredients() { return !ingredients.isEmpty(); }
    public boolean hasSteps()       { return !steps.isEmpty(); }
    public boolean hasTips()        { return !tips.isEmpty(); }

    private static String nz(String s) { return s == null ? "" : s; }
}
