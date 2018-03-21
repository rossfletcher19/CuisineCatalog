//package com.epicodus.recipesandroid;
//
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
//    private ArrayList<Recipe> mRecipes = new ArrayList<>();
//    private Context mContext;
//
//    public RecipeListAdapter(Context context, ArrayList<Recipe> recipes) {
//        mContext = context;
//        mRecipes = recipes;
//    }
//
//    public class RecipeViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.recipeImageView) ImageView mRecipeImageView;
//        @BindView(R.id.recipeNameTextView) TextView mRecipeNameTextView;
//        @BindView(R.id.descriptionTextView) TextView mDescriptionTextView;
//
//
//        private Context mContext;
//
//        public RestaurantViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//            mContext = itemView.getContext();
//        }
//
//        public void bindRecipe(Recipe recipe) {
//            mRecipeNameTextView.setText(recipe.getName());
//            mDescriptionTextView.setText(recipe.getDescription());
//
//        }
//    }
//
//
//
//
//}
