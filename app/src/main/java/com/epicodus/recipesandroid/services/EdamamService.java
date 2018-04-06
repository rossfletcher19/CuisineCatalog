package com.epicodus.recipesandroid.services;

import android.util.Log;

import com.epicodus.recipesandroid.models.Recipe;
import com.epicodus.recipesandroid.Constants;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EdamamService {

    public static void findRecipes(String query, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.EDAMAM_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.EDAMAM_QUERY_PARAMETER, query);
        urlBuilder.addQueryParameter("from", "0");
        urlBuilder.addQueryParameter("to","30");
        urlBuilder.addQueryParameter("app_id", Constants.EDAMAM_ID);
        urlBuilder.addQueryParameter("app_key", Constants.EDAMAM_KEY);
        String url = urlBuilder.build().toString();
        System.out.println(url);


        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Recipe> processResults(Response response){
        ArrayList<Recipe> allRecipes = new ArrayList<>();
        try{
            String jsonData = response.body().string();
            if(response.isSuccessful()){
                JSONObject recipeCatalogJSON = new JSONObject(jsonData);
                JSONArray recipesJSON = recipeCatalogJSON.getJSONArray("hits");
                for (int i = 0; i<recipesJSON.length();i++){
                    //gets specific hit
                    JSONObject recipeJSON = recipesJSON.getJSONObject(i);
                    //goes into the recipe portion of hit
                    JSONObject currentRecipe = recipeJSON.getJSONObject("recipe");
                    String title = currentRecipe.getString("label");
                    String image = currentRecipe.getString("image");
                    String url = currentRecipe.getString("url");
                    String calories = Integer.toString(currentRecipe.getInt("calories"));
                    String servings = Integer.toString(currentRecipe.getInt("yield"));

                    //looks into an array of ingredients and add them to the recipe
                    ArrayList<String> ingredients = new ArrayList<>();
                    JSONArray ingredientList = currentRecipe.getJSONArray("ingredientLines");
                    for(int j = 0; j< ingredientList.length(); j++){
                        ingredients.add(ingredientList.get(j).toString());
                    }
                    System.out.println(ingredients + "ingredients");
                    Recipe recipe = new Recipe(title,image,url,ingredients,calories,servings);
                    allRecipes.add(recipe);
                }

            }

        }catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return allRecipes;
    }




}
