package com.epicodus.recipesandroid;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.mainHeadingTextView) TextView mMainHeadingTextView;
    @BindView(R.id.seeCatalogButton) Button mSeeCatalogButton;


//    private TextView mMainHeadingTextView;
//    private Button mSeeCatalogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Recipe recipe1 = new Recipe("PHILLY CHEESESTEAKS", "A cheesesteakk, also known as a Philadelphia cheesesteak, Philly cheesesteak, cheesesteak sandwich, cheese steak, or steak and cheese, is a sandwich made from thinly sliced pieces of beefsteak and melted cheese in a long hoagie roll.", new String[]{"2 medium onions, halved and sliced", "2 medium sweet red or green peppers, halved and sliced", "1 beef top sirloin steak (1-1/2 pounds), cut into thin strips","1 envelope onion soup mix","1 can (14-1/2 ounces) reduced-sodium beef broth"," 6 hoagie buns, split","12 slices provolone cheese, halved","Pickled hot cherry peppers, optional"} , "Place onions and red peppers in a 4- or 5-qt. slow cooker. Add beef, soup mix and broth. Cook, covered, on low 6-8 hours or until meat is tender., Arrange buns on a baking sheet, cut side up. Using tongs, place meat mixture on bun bottoms; top with cheese., Broil 2-3 in. from heat 30-60 seconds or until cheese is melted and bun tops are toasted.", "West Coast-style meals");

        Recipe recipe2 = new Recipe("NEW ENGLAND CLAM CHOWDER", "With its fertile farmland, coastal waters, and flavorful influence from generations of immigrants, it’s no surprise that New England cuisine has a reputation for being seasonal, hearty, and comforting.", new String[]{"4 center-cut bacon strips", "2 celery ribs, chopped","1 large onion, chopped","1 garlic clove, minced","3 small potatoes, peeled and cubed","1 cup water","1 bottle (8 ounces) clam juice","3 teaspoons reduced-sodium chicken bouillon granules","1/4 teaspoon white pepper"," 1/4 teaspoon dried thyme","1/3 cup all-purpose flour","2 cups fat-free half-and-half, divided","2 cans (6-1/2 ounces each) chopped clams, undrained"} , "In a Dutch oven, cook bacon over medium heat until crisp. Remove to paper towels to drain; set aside. Saute the celery, onion and garlic in the drippings until tender. Stir in the potatoes, water, clam juice, bouillon, pepper and thyme. Bring to a boil. Reduce heat; simmer, uncovered, for 15-20 minutes or until potatoes are tender., In a small bowl, combine flour and 1 cup half-and-half until smooth. Gradually stir into soup. Bring to a boil; cook and stir for 1-2 minutes or until thickened., Stir in clams and remaining half-and-half; heat through (do not boil). Crumble the reserved bacon; sprinkle over each serving. Yield: 5 servings.", "East Coast-style meals");

        Recipe recipe3 = new Recipe("NEW ENGLAND CLAM CHOWDER2", "With its fertile farmland, coastal waters, and flavorful influence from generations of immigrants, it’s no surprise that New England cuisine has a reputation for being seasonal, hearty, and comforting.", new String[]{"4 center-cut bacon strips", "2 celery ribs, chopped","1 large onion, chopped","1 garlic clove, minced","3 small potatoes, peeled and cubed","1 cup water","1 bottle (8 ounces) clam juice","3 teaspoons reduced-sodium chicken bouillon granules","1/4 teaspoon white pepper"," 1/4 teaspoon dried thyme","1/3 cup all-purpose flour","2 cups fat-free half-and-half, divided","2 cans (6-1/2 ounces each) chopped clams, undrained"} , "In a Dutch oven, cook bacon over medium heat until crisp. Remove to paper towels to drain; set aside. Saute the celery, onion and garlic in the drippings until tender. Stir in the potatoes, water, clam juice, bouillon, pepper and thyme. Bring to a boil. Reduce heat; simmer, uncovered, for 15-20 minutes or until potatoes are tender., In a small bowl, combine flour and 1 cup half-and-half until smooth. Gradually stir into soup. Bring to a boil; cook and stir for 1-2 minutes or until thickened., Stir in clams and remaining half-and-half; heat through (do not boil). Crumble the reserved bacon; sprinkle over each serving. Yield: 5 servings.", "One-pot comfort foods");

        Recipe recipe4 = new Recipe("PHILLY CHEESESTEAKS2", "A cheesesteakk, also known as a Philadelphia cheesesteak, Philly cheesesteak, cheesesteak sandwich, cheese steak, or steak and cheese, is a sandwich made from thinly sliced pieces of beefsteak and melted cheese in a long hoagie roll.", new String[]{"2 medium onions, halved and sliced", "2 medium sweet red or green peppers, halved and sliced", "1 beef top sirloin steak (1-1/2 pounds), cut into thin strips","1 envelope onion soup mix","1 can (14-1/2 ounces) reduced-sodium beef broth"," 6 hoagie buns, split","12 slices provolone cheese, halved","Pickled hot cherry peppers, optional"} , "Place onions and red peppers in a 4- or 5-qt. slow cooker. Add beef, soup mix and broth. Cook, covered, on low 6-8 hours or until meat is tender., Arrange buns on a baking sheet, cut side up. Using tongs, place meat mixture on bun bottoms; top with cheese., Broil 2-3 in. from heat 30-60 seconds or until cheese is melted and bun tops are toasted.", "Fusion Recipes");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mMainHeadingTextView = (TextView) findViewById(R.id.mainHeadingTextView);
        Typeface headingFont = Typeface.createFromAsset(getAssets(), "fonts/Windsong.ttf");
        mMainHeadingTextView.setTypeface(headingFont);


        mSeeCatalogButton = (Button) findViewById(R.id.seeCatalogButton);
        mSeeCatalogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CuisineListActivity.class);
                startActivity(intent);
            }
        });





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_user_profile) {
            // Handle the camera action
        } else if (id == R.id.nav_my_recipes) {

        } else if (id == R.id.nav_feedback) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
