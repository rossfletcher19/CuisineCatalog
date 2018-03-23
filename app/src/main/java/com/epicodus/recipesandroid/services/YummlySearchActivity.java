package com.epicodus.recipesandroid.services;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.recipesandroid.R;
import com.epicodus.recipesandroid.adapters.RecipeAdapter;
import com.epicodus.recipesandroid.models.Recipe;
import com.epicodus.recipesandroid.ui.MainActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YummlySearchActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.apiSearchPageButton) Button bApiSearchPageButton;
    @BindView(R.id.apiSearchEditText) EditText mApiSearchEditText;
    ArrayList<Recipe> recipes;
    RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yummly_search);
        ButterKnife.bind(this);



        bApiSearchPageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String apiSearchTerms = mApiSearchEditText.getText().toString();
                Log.d(TAG, apiSearchTerms);

            }
        });


        recipes = Recipe.createRecipeList();
        RecyclerView rvApiRecipes = (RecyclerView)findViewById(R.id.rvApiRecipesList);
        adapter = new RecipeAdapter(this, recipes);
        rvApiRecipes.setLayoutManager(new LinearLayoutManager(this));
        rvApiRecipes.setAdapter(adapter);



    }
}
