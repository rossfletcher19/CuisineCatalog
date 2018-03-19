package com.epicodus.recipesandroid;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class CuisineListActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] cuisines = new String[] {"Fusion Recipes", "One-pot comfort foods", "East Coast-style meals", "West Coast-style meals"};
    private TextView mCuisineHeadingTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_list);

        mCuisineHeadingTextView = (TextView) findViewById(R.id.cuisineHeadingTextView);
        Typeface headingFont = Typeface.createFromAsset(getAssets(), "fonts/Windsong.ttf");
        mCuisineHeadingTextView.setTypeface(headingFont);



        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_selectable_list_item, cuisines);
        mListView.setAdapter(adapter);

    }





}
