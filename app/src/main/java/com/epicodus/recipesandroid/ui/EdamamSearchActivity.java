package com.epicodus.recipesandroid.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.SearchView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epicodus.recipesandroid.Constants;
import com.epicodus.recipesandroid.R;
import com.epicodus.recipesandroid.adapters.RecipeListAdapter;
import com.epicodus.recipesandroid.models.Recipe;
import com.epicodus.recipesandroid.services.EdamamService;

import okhttp3.Call;
import okhttp3.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

public class EdamamSearchActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.rvApiRecipesList) RecyclerView rvApiRecipesList;
    private RecipeListAdapter mAdapter;
    public List<Recipe> recipes = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edamam_search);
        ButterKnife.bind(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);


        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                getRecipes(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }



    private void getRecipes(String searchQuery) {
        final EdamamService edamamService = new EdamamService();
        edamamService.findRecipes(searchQuery, new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    recipes = edamamService.processResults(response);
                    if (recipes.size() == 0) {
                        EdamamSearchActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"No Recipes Found", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(EdamamSearchActivity.this, EdamamSearchActivity.class);
                                startActivity(intent);
                            }
                        });

                    } else {
                        EdamamSearchActivity.this.runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                mAdapter = new RecipeListAdapter(getApplicationContext(), recipes);
                                rvApiRecipesList.setAdapter(mAdapter);
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EdamamSearchActivity.this);
                                rvApiRecipesList.setLayoutManager(layoutManager);
                                rvApiRecipesList.setHasFixedSize(true);


                            }

                        });
                    }
                }
            });

        }
}