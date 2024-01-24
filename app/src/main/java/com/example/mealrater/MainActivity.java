package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ratingDialog.SaveRatingListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initChangeRatingButton();
    }


    @Override
    public void didFinishRatingPickerDialog(String selectedRating) {
        TextView ratingText = findViewById(R.id.ratingText);
        ratingText.setText(selectedRating);
    }

    private void initChangeRatingButton() {
        Button changeRating = findViewById(R.id.rateBtn);
        changeRating.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view) {
                FragmentManager fm = getSupportFragmentManager();
                ratingDialog ratingDialog = new ratingDialog();
                ratingDialog.show(fm, "RatePick");
            }
        });
    }

}