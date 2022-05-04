package com.zybooks.schelfit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.graphics.drawable.AnimationDrawable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ConstraintLayout constraintLayout = findViewById(R.id.main_layout);

        //AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        //animationDrawable.setEnterFadeDuration(2500);
        //animationDrawable.setExitFadeDuration(5000);
        //animationDrawable.start();

        ImageButton workout_button = findViewById(R.id.workout_button);
        ImageButton meals_button = findViewById(R.id.meals_button);
        ImageButton schedule_button = findViewById(R.id.schedule_button);
        ImageButton activity_button = findViewById(R.id.activity_button);
        Button menu_button = findViewById(R.id.menu_button);

        workout_button.setOnClickListener(view -> openWorkouts());
        meals_button.setOnClickListener(view -> openMeals());
        schedule_button.setOnClickListener(view -> openSchedule());
        activity_button.setOnClickListener(view -> openActivity());
        menu_button.setOnClickListener(view -> openMenu());

    }

    public void openWorkouts(){
        Intent intent = new Intent(this, workouts.class);
        startActivity(intent);
    }

    public void openMeals(){
        Intent intent = new Intent(this, meals.class);
        startActivity(intent);
    }

    public void openSchedule(){
        Intent intent = new Intent(this, schedule.class);
        startActivity(intent);
    }

    public void openActivity(){
        Intent intent = new Intent(this, activity.class);
        startActivity(intent);
    }

    public void openMenu(){
        Intent intent = new Intent(this, main_menu.class);
        startActivity(intent);
    }
}