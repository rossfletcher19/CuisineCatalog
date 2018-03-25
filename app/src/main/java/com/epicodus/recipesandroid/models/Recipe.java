package com.epicodus.recipesandroid.models;


import android.support.v7.widget.RecyclerView;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.Arrays;


@Parcel
public class Recipe {
    private String title;
    private String image;
    private String url;
    private ArrayList<String> ingredientLines;
    private Integer calories;
    private Integer servings;
    private String cuisine;



    public Recipe(){}

    public Recipe(String title, String image, String url, ArrayList<String> ingredientLines, Integer calories, Integer servings) {
        this.title = title;
        this.image = image;
        this.url = url;
        this.ingredientLines = ingredientLines;
        this.calories = calories;
        this.servings = servings;


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<String> getIngredientLines() {
        return ingredientLines;
    }

    public void setIngredientLines(ArrayList<String> ingredientLines) {
        this.ingredientLines = ingredientLines;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

        public static ArrayList<Recipe> createRecipeList() {


        ArrayList<Recipe> recipes = new ArrayList<>();

//                Recipe recipe1x = new Recipe("title", "img", "url", new ArrayList<>(Arrays.asList("","","","","","","","","","",""} , "cal", "servings", "course", "cuisine", "description");

    Recipe recipe1 = new Recipe("PHILLY CHEESESTEAKS", "https://www.edamam.com/web-img/4a5/4a51d52639197229a46a3cd6e1e0254e.jpg", "https://www.tasteofhome.com/recipes/easy-philly-cheesesteaks", new ArrayList<>(Arrays.asList("2 medium onions, halved and sliced", "2 medium sweet red or green peppers, halved and sliced", "1 beef top sirloin steak (1-1/2 pounds), cut into thin strips", "1 envelope onion soup mix", "1 can (14-1/2 ounces) reduced-sodium beef broth", " 6 hoagie buns, split", "12 slices provolone cheese, halved", "Pickled hot cherry peppers, optional")), 400, 3);

        Recipe recipe1a = new Recipe("Rum and coke pulled pork","https://www.edamam.com/web-img/0cf/0cfba91f9de02d26123a236c60f03897.jpg" , "http://www.chatelaine.com/recipe/dinner/rum-and-coke-pulled-pork/", new ArrayList<>(Arrays.asList("1.25 kg bone-in pork shoulder, excess fat trimmed from blade roast", "1/2 tsp salt", "2tsp canola oil", "2 celery stalks, chopped", "2 carrots chopped", "1 large onion", "2-3 jalapenos chopped", "2 garlic cloves", "1/2 tsp all spice", "1/2 gold rum", "2 cups cola", "1.5 low-sodium chicken broth", "2 bay leaves", "1/2 tsp dried thyme", "2 tbsp apple cider vinegar")), 500, 5);

            Recipe recipe2 = new Recipe("PHILLY CHEESESTEAKS", "https://www.edamam.com/web-img/4a5/4a51d52639197229a46a3cd6e1e0254e.jpg", "https://www.tasteofhome.com/recipes/easy-philly-cheesesteaks", new ArrayList<>(Arrays.asList("2 medium onions, halved and sliced", "2 medium sweet red or green peppers, halved and sliced", "1 beef top sirloin steak (1-1/2 pounds), cut into thin strips", "1 envelope onion soup mix", "1 can (14-1/2 ounces) reduced-sodium beef broth", " 6 hoagie buns, split", "12 slices provolone cheese, halved", "Pickled hot cherry peppers, optional")), 400, 3);

            Recipe recipe2a = new Recipe("Rum and coke pulled pork", "https://www.edamam.com/web-img/0cf/0cfba91f9de02d26123a236c60f03897.jpg", "http://www.chatelaine.com/recipe/dinner/rum-and-coke-pulled-pork/", new ArrayList<>(Arrays.asList("1.25 kg bone-in pork shoulder, excess fat trimmed from blade roast", "1/2 tsp salt", "2tsp canola oil", "2 celery stalks, chopped", "2 carrots chopped", "1 large onion", "2-3 jalapenos chopped", "2 garlic cloves", "1/2 tsp all spice", "1/2 gold rum", "2 cups cola", "1.5 low-sodium chicken broth", "2 bay leaves", "1/2 tsp dried thyme", "2 tbsp apple cider vinegar")), 500, 5);



        recipes.addAll(Arrays.asList(recipe1, recipe1a, recipe2, recipe2a));
        return recipes;
    }
}



