package com.example.digitalprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ActTimeTracking extends AppCompatActivity {

    private TextView study;
    private ImageView X_study;
    private TextView movie;
    private ImageView X_movie;
    private TextView gym;
    private ImageView X_gym;
    private TextView restaurant;
    private ImageView X_restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_time_tracking);
        study = (TextView) findViewById(R.id.study_msg_text);
        X_study = (ImageView) findViewById(R.id.close_study_tip);
        movie = (TextView) findViewById(R.id.movie_msg_text);
        X_movie = (ImageView) findViewById(R.id.close_movie_tip);
        gym = (TextView) findViewById(R.id.gym_msg_text);
        X_gym = (ImageView) findViewById(R.id.close_gym_tip);
        restaurant = (TextView) findViewById(R.id.restaurant_msg_text);
        X_restaurant = (ImageView) findViewById(R.id.close_restaurant_tip);
    }

    public void showStudyTip(View view) {
        study.setVisibility(View.VISIBLE);
        X_study.setVisibility(View.VISIBLE);
    }

    public void hideStudyTip(View view) {
        study.setVisibility(View.INVISIBLE);
        view.setVisibility(View.INVISIBLE);
    }

    public void showMovieTip(View view) {
        movie.setVisibility(View.VISIBLE);
        X_movie.setVisibility(View.VISIBLE);
    }

    public void hideMovieTip(View view) {
        movie.setVisibility(View.INVISIBLE);
        view.setVisibility(View.INVISIBLE);
    }

    public void showGymTip(View view) {
        gym.setVisibility(View.VISIBLE);
        X_gym.setVisibility(View.VISIBLE);
    }

    public void hideGymTip(View view) {
        gym.setVisibility(View.INVISIBLE);
        view.setVisibility(View.INVISIBLE);
    }

    public void showRestaurantTip(View view) {
        restaurant.setVisibility(View.VISIBLE);
        X_restaurant.setVisibility(View.VISIBLE);
    }

    public void hideRestaurantTip(View view) {
        restaurant.setVisibility(View.INVISIBLE);
        view.setVisibility(View.INVISIBLE);
    }
}
