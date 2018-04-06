package com.epicodus.recipesandroid.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.recipesandroid.Constants;
import com.epicodus.recipesandroid.R;
import com.epicodus.recipesandroid.models.Recipe;
import com.epicodus.recipesandroid.ui.RecipeDetailActivity;
import com.epicodus.recipesandroid.util.ItemTouchHelperViewHolder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseRecipeViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;
    public ImageView mRecipeImageView;
    View mView;
    Context mContext;

    public FirebaseRecipeViewHolder (View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    @Override
    public void onItemSelected() {
        itemView.animate()
                .alpha(0.7f)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(500);
    }

    @Override
    public void onItemClear() {
        itemView.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f);
    }

    public void bindRecipe(Recipe recipe) {
        mRecipeImageView = (ImageView) mView.findViewById(R.id.recipeImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.recipeNameTextView);


        Picasso.with(mContext)
                .load(recipe.getImage())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mRecipeImageView);

        nameTextView.setText(recipe.getTitle());

    }

//    @Override
//    public void onClick(View view) {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//        final ArrayList<Recipe> recipes = new ArrayList<>();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RECIPES).child(uid);
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    recipes.add(snapshot.getValue(Recipe.class));
//                }
//
//                int itemPosition = getLayoutPosition();
//
//                Intent intent = new Intent(mContext, RecipeDetailActivity.class);
//                intent.putExtra("position", itemPosition);
//                intent.putExtra("recipes", Parcels.wrap(recipes));
//
//                mContext.startActivity(intent);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//    }
}
