package com.example.mealrater;

import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ratingDialog extends DialogFragment {

    String selectedRating;

    public interface SaveRatingListener {
        void didFinishRatingPickerDialog(String selectedRating);
    }

    public ratingDialog () {
        //empty constructor
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view= inflater.inflate(R.layout.activity_rating_dialog,container);

        getDialog().setTitle("Rate Your Meal");


        RatingBar rv = view.findViewById(R.id.ratingBar);
        TextView ratingNum = view.findViewById(R.id.ratingNum);
        rv.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                ratingNum.setText(ratingBar.getRating() + "");
            }
        });


        Button submitBtn = view.findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveRatingListener activity = (SaveRatingListener) getActivity();
                selectedRating = ratingNum.getText() + "★";
                activity.didFinishRatingPickerDialog(selectedRating);
                getDialog().dismiss();
            }

        });
        return view;
    }

}