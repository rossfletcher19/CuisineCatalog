package com.epicodus.recipesandroid.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.recipesandroid.R;
import com.epicodus.recipesandroid.models.Recipe;
import com.epicodus.recipesandroid.ui.RecipeDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder> {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;
    private List<Recipe> mRecipes;
    private Context mContext;

    public RecipeListAdapter(Context context, List<Recipe> recipes) {
        mRecipes = recipes;
        mContext = context;
    }


    @Override
    public RecipeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View recipeView = inflater.inflate(R.layout.recipe_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(recipeView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.ViewHolder viewHolder, int position) {
        Recipe recipe = mRecipes.get(position);
        TextView textView1 = viewHolder.mRecipeNameTextView;
//        ImageView imageView = viewHolder.mRecipeImageView;
        textView1.setText(recipe.getTitle());
        viewHolder.bindRecipe(mRecipes.get(position));

    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.recipeImageView) ImageView mRecipeImageView;
        @BindView(R.id.recipeNameTextView) TextView mRecipeNameTextView;
//        @BindView(R.id.descriptionTextView) TextView mDescriptionTextView;
//        @BindView(R.id.ingredientsTextView) TextView mIngredientsTextView;
//        @BindView(R.id.directionsTextView) TextView mDirectionsTextView;
        private Context mContext;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, RecipeDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("recipes", Parcels.wrap(mRecipes));
            mContext.startActivity(intent);
        }

        public void bindRecipe(Recipe recipe) {
            Picasso.with(mContext)
                    .load(recipe.getImage())
                    .resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop()
                    .into(mRecipeImageView);
            mRecipeNameTextView.setText(recipe.getTitle());
        }

    }







}
