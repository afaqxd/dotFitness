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
        ExercisesList.add(new Exercises("1.", "Arm Raises"));
        ExercisesList.add(new Exercises("2.", "Triceps Dips"));
        ExercisesList.add(new Exercises("3.", "Diamond Pushups"));
        ExercisesList.add(new Exercises("4.", "Jumping Jacks"));
        ExercisesList.add(new Exercises("5.", "Diagonal Plank"));
        ExercisesList.add(new Exercises("6.", "Burpees"));
        ExercisesList.add(new Exercises("7.", "Arm Scissors"));
        ExercisesList.add(new Exercises("8.", "Shoulder Gators"));

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