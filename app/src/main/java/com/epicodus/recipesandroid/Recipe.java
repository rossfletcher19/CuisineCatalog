package com.epicodus.recipesandroid;


public class Recipe {
    private String name;
    private String description;
    private String[] ingredients;
    private String directions;
    private String cuisine;

    public Recipe (String name, String description, String[] ingredients, String directions, String cuisine) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
        this.cuisine = cuisine;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
}
