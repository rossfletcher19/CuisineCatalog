package com.epicodus.recipesandroid;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RecipeListActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] recipes = new String[] {"recipe1", "recipe2", "recipe3", "recipe4", "recipe5", "recipe6", "recipe7", "recipe8"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);



        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_selectable_list_item, recipes);
        mListView.setAdapter(adapter);

    }



}
