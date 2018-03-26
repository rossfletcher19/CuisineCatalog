package com.epicodus.recipesandroid.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.recipesandroid.R;
import com.epicodus.recipesandroid.models.Recipe;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeDetailFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.recipeImageView) ImageView mRecipeImageViewLabel;
    @BindView(R.id.recipeNameTextView) TextView mRecipeNameTextViewLabel;
    @BindView(R.id.caloriesTextView) TextView mCaloriesTextViewLabel;
    @BindView(R.id.sourceTextView) TextView mSourceTextViewLabel;
    @BindView(R.id.saveRecipeButton) TextView mSaveRecipeButtonLabel;

    private Recipe mRecipe;

    public RecipeDetailFragment(){}

    public static RecipeDetailFragment newInstance(Recipe recipe) {
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("recipe", Parcels.wrap(recipe));
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);
        mSourceTextViewLabel.setOnClickListener(this);

        Picasso.with(view.getContext())
                .load(mRecipe.getImage())
                .into(mRecipeImageViewLabel);

        mRecipeNameTextViewLabel.setText(mRecipe.getTitle());
        mCaloriesTextViewLabel.setText(mRecipe.getCalories());
//        String print = "";
//        for (String ingredient : mRecipe.getIngredientLines()) {
//            print += ingredient;
//        }
//        mIngredientsTextViewLabel.setText(print);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mSourceTextViewLabel) {
            Intent directionsIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mRecipe.getUrl()));
            startActivity(directionsIntent);
        }

    }

}
