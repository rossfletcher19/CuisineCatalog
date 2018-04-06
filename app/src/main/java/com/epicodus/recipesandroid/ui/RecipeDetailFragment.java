package com.epicodus.recipesandroid.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.recipesandroid.Constants;
import com.epicodus.recipesandroid.R;
import com.epicodus.recipesandroid.models.Recipe;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeDetailFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.recipeImageView) ImageView mRecipeImageViewLabel;
    @BindView(R.id.caloriesTextView) TextView mCaloriesTextViewLabel;
    @BindView(R.id.sourceTextView) TextView mSourceTextViewLabel;
    @BindView(R.id.saveRecipeButton) TextView mSaveRecipeButtonLabel;

    private Recipe mRecipe;
    private ListView lvIngredients;

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
        mSaveRecipeButtonLabel.setOnClickListener(this);




        Picasso.with(view.getContext())
                .load(mRecipe.getImage())
                .into(mRecipeImageViewLabel);
        mCaloriesTextViewLabel.setText(mRecipe.getCalories());

        lvIngredients = view.findViewById(R.id.lvIngredients);
        List<String> ingredients = new ArrayList<>();
        ingredients.addAll(mRecipe.getIngredientLines());

        lvIngredients.setAdapter(new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1, ingredients));

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mSourceTextViewLabel) {
            Intent directionsIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mRecipe.getUrl()));
            startActivity(directionsIntent);
        }
        if (v == mSaveRecipeButtonLabel) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            DatabaseReference restaurantRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_RECIPES)
                    .child(uid);
            DatabaseReference pushRef = restaurantRef.push();
            String pushId = pushRef.getKey();
            mRecipe.setPushId(pushId);
            pushRef.setValue(mRecipe);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }

    }

}
