package com.example.dotfitness;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout act_bmi, act_exercises,act_medTimer;
    TextView text_DisplayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        act_bmi = findViewById(R.id.lay_bmi);
        act_exercises = findViewById(R.id.lay_exercises);
        act_medTimer = findViewById(R.id.lay_medTimer);
        text_DisplayName = findViewById(R.id.tv_main_user);

        Intent intent1 = getIntent();
        String UserName = intent1.getStringExtra("name1");
        text_DisplayName.setText(UserName);

        act_exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExercisesActivity.class);
                startActivity(intent);
            }
        });
        act_medTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MeditationTimerActivity.class);
                startActivity(intent);
            }
        });

        act_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BmiActivity.class);
                startActivity(intent);
            }
        });


    }
}