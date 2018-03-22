package com.epicodus.recipesandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipesListActivity extends AppCompatActivity{
//    private ListView mRecipeListview;
//    private ListView mcuisineListView;
    ArrayList<Recipe> recipes;
    RecipeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);
        Intent intent = getIntent();
        String cuisine = intent.getStringExtra("cuisine");

        recipes = Recipe.createRecipeList();

        ArrayList<Recipe> cuisineRecipes = new ArrayList<Recipe>();
        for (Recipe recipe : recipes) {
            if (recipe.getCuisine().equals(cuisine)) {
                cuisineRecipes.addAll(Arrays.asList(recipe));

            } else {
                Log.d("test for looppppp", "test for loopppp");


            }
        }


        RecyclerView rvRecipes = (RecyclerView)findViewById(R.id.rvRecipesList);
        adapter = new RecipeAdapter(this, cuisineRecipes);
        rvRecipes.setLayoutManager(new LinearLayoutManager(this));
        rvRecipes.setAdapter(adapter);



//        if (cuisine.contains("Fusion Recipes")) {
//            RecyclerView rvRecipes = (RecyclerView)findViewById(R.id.rvRecipesList);
//            adapter = new RecipeAdapter(this, recipes);
//            rvRecipes.setLayoutManager(new LinearLayoutManager(this));
//            rvRecipes.setAdapter(adapter);
//        } else if (cuisine.contains("One-pot comfort foods")) {
//            RecyclerView rvRecipes = (RecyclerView)findViewById(R.id.rvRecipesList);
//            adapter = new RecipeAdapter(this, recipes);
//            rvRecipes.setLayoutManager(new LinearLayoutManager(this));
//            rvRecipes.setAdapter(adapter);
//        } else if (cuisine.contains("West Coast-style meals")) {
//            RecyclerView rvRecipes = (RecyclerView)findViewById(R.id.rvRecipesList);
//            adapter = new RecipeAdapter(this, recipes);
//            rvRecipes.setLayoutManager(new LinearLayoutManager(this));
//            rvRecipes.setAdapter(adapter);
//        } else if (cuisine.contains("East Coast-style meals")) {
//            RecyclerView rvRecipes = (RecyclerView)findViewById(R.id.rvRecipesList);
//            adapter = new RecipeAdapter(this, recipes);
//            rvRecipes.setLayoutManager(new LinearLayoutManager(this));
//            rvRecipes.setAdapter(adapter);
//        } else {
//            System.out.println("end of if....");
//        }


    }

}
