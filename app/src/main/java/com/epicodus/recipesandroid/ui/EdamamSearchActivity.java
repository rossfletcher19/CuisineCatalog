package com.epicodus.recipesandroid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.recipesandroid.R;
import com.epicodus.recipesandroid.adapters.RecipeAdapter;
import com.epicodus.recipesandroid.models.Recipe;
import com.epicodus.recipesandroid.services.EdamamService;

import okhttp3.Call;
import okhttp3.Callback;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

public class EdamamSearchActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.apiSearchPageButton) Button bApiSearchPageButton;
    @BindView(R.id.apiSearchEditText) EditText mApiSearchEditText;
    ArrayList<Recipe> recipes;
    RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edamam_search);
        ButterKnife.bind(this);

        bApiSearchPageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String searchQuery = mApiSearchEditText.getText().toString();
                getRecipes(searchQuery);
                System.out.println(searchQuery);
                Log.d(TAG, searchQuery);

            }
        });



    }



        private void getRecipes(String searchQuery) {
            final EdamamService edamamService = new EdamamService();
            edamamService.findRecipes(searchQuery, new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            });
        }

//        recipes = Recipe.createRecipeList();
//        RecyclerView rvApiRecipes = (RecyclerView)findViewById(R.id.rvApiRecipesList);
//        adapter = new RecipeAdapter(this, recipes);
//        rvApiRecipes.setLayoutManager(new LinearLayoutManager(this));
//        rvApiRecipes.setAdapter(adapter);



    }

