package com.epicodus.recipesandroid.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.epicodus.recipesandroid.R;
import com.epicodus.recipesandroid.adapters.RecipeListAdapter;
import com.epicodus.recipesandroid.models.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipesListActivity extends AppCompatActivity{
//    private ListView mRecipeListview;
//    private ListView mcuisineListView;
    List<Recipe> recipes;
    RecipeListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);
        Intent intent = getIntent();
        String cuisine = intent.getStringExtra("cuisine");

        recipes = Recipe.createRecipeList();

        RecyclerView rvRecipes = (RecyclerView)findViewById(R.id.rvRecipesList);
        adapter = new RecipeListAdapter(this, recipes);
        rvRecipes.setLayoutManager(new LinearLayoutManager(this));
        rvRecipes.setAdapter(adapter);

    }

}
