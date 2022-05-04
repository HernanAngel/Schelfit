package com.zybooks.schelfit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class main_menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);


        Button workout_button = findViewById(R.id.workout_menu_button);
        Button meals_button = findViewById(R.id.meals_menu_button);
        Button schedule_button = findViewById(R.id.schedule_menu_button);
        Button activity_button = findViewById(R.id.activity_menu_button);
        Button menu_back = findViewById(R.id.main_menu_button);
        Button settings_button = findViewById(R.id.settings_menu_button);
        Button login_button = findViewById(R.id.login_menu_button);

        workout_button.setOnClickListener(view -> openWorkouts());
        meals_button.setOnClickListener(view -> openMeals());
        schedule_button.setOnClickListener(view -> openSchedule());
        activity_button.setOnClickListener(view -> openActivity());
        menu_back.setOnClickListener(view -> openBackmenu());
        login_button.setOnClickListener(view -> openLogin());
        settings_button.setOnClickListener(view -> openSettings());

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

    public void openBackmenu(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openSettings(){
        Intent intent = new Intent(this,settings_activity.class);
        startActivity(intent);
    }

    public void openLogin(){
        Intent intent = new Intent(this, login_activity.class);
        startActivity(intent);
    }
}
