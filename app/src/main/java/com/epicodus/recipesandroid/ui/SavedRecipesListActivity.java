package com.epicodus.recipesandroid.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.recipesandroid.Constants;
import com.epicodus.recipesandroid.R;
import com.epicodus.recipesandroid.adapters.FirebaseRecipeListAdapter;
import com.epicodus.recipesandroid.adapters.FirebaseRecipeViewHolder;
import com.epicodus.recipesandroid.models.Recipe;
import com.epicodus.recipesandroid.util.ItemTouchHelperAdapter;
import com.epicodus.recipesandroid.util.OnStartDragListener;
import com.epicodus.recipesandroid.util.SimpleItemTouchHelperCallback;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedRecipesListActivity extends AppCompatActivity implements OnStartDragListener {
    private DatabaseReference mRecipeReference;
//    private FirebaseRecyclerAdapter mFirebaseAdapter;
    private FirebaseRecipeListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;
    private Query recipeQuery;
    @BindView(R.id.rvRecipesList) RecyclerView rvRecipesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);
        ButterKnife.bind(this);
        setUpFirebaseAdapter();

    }

    private void setUpFirebaseAdapter() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mRecipeReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_RECIPES)
                .child(uid);
        recipeQuery = mRecipeReference.getRef();

        FirebaseRecyclerOptions<Recipe> options = new FirebaseRecyclerOptions.Builder<Recipe>().setQuery(recipeQuery, Recipe.class).build();

        mFirebaseAdapter = new FirebaseRecipeListAdapter(options, mRecipeReference, this,this);

        rvRecipesListView.setHasFixedSize(true);
        rvRecipesListView.setLayoutManager(new LinearLayoutManager(this));
        rvRecipesListView.setAdapter(mFirebaseAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback((ItemTouchHelperAdapter) mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(rvRecipesListView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.setIndexInFirebase();
        mFirebaseAdapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mFirebaseAdapter.stopListening();
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
