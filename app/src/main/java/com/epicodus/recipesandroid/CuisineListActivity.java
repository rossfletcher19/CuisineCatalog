package com.epicodus.recipesandroid;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class CuisineListActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] cuisines = new String[] {"cuisine1", "cuisine2", "cuisine3", "cuisine4", "cuisine5"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_list);



        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_selectable_list_item, cuisines);
        mListView.setAdapter(adapter);

    }



}
