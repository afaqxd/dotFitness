package com.example.dotfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dotfitness.Adapter.RecyclerViewAdapter;
import com.example.dotfitness.Model.Exercises;

import java.util.ArrayList;
import java.util.List;

public class ExercisesActivity extends AppCompatActivity implements RecyclerViewAdapter.OnExerciseListener {


    List<Exercises> ExercisesList = new ArrayList<>();
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        recyclerView = findViewById(R.id.recyclerview1);
        ExercisesList.add(new Exercises("1.", "ARM RAISES"));
        ExercisesList.add(new Exercises("2.", "TRICEPS DIPS"));
        ExercisesList.add(new Exercises("3.", "DIAMOND PUSHUPS"));
        ExercisesList.add(new Exercises("4.", "JUMPING JACKS"));
        ExercisesList.add(new Exercises("5.", "DIAGONAL PLANK"));
        ExercisesList.add(new Exercises("6.", "BURPEES"));
        ExercisesList.add(new Exercises("7.", "ARM SCISSORS"));
        ExercisesList.add(new Exercises("8.", "SHOULDER GATORS"));

        recyclerViewAdapter = new RecyclerViewAdapter(ExercisesList, ExercisesActivity.this,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    public void OnExerciseClick(int position) {
        /*Intent intent = new Intent(ExercisesActivity.this,TimerActivity.class);
        startActivity(intent);*/
    }


}