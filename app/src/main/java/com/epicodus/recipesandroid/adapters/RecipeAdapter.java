package com.epicodus.recipesandroid.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.recipesandroid.R;
import com.epicodus.recipesandroid.models.Recipe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recipeImageView) ImageView mRecipeImageView;
        @BindView(R.id.recipeNameTextView) TextView mRecipeNameTextView;
        @BindView(R.id.descriptionTextView) TextView mDescriptionTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
    private ArrayList<Recipe> mRecipes;
    private Context mContext;

    public RecipeAdapter(Context context, ArrayList<Recipe> recipes) {
        mRecipes = recipes;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View recipeView = inflater.inflate(R.layout.recipe_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(recipeView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeAdapter.ViewHolder viewHolder, int position) {
        Recipe recipe = mRecipes.get(position);
        TextView textView1 = viewHolder.mRecipeNameTextView;
        TextView textView2 = viewHolder.mDescriptionTextView;
//        ImageView imageView = viewHolder.mRecipeImageView;
        textView1.setText(recipe.getName());
        textView2.setText(recipe.getDescription());
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }
}
