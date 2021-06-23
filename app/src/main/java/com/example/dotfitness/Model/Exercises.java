package com.example.dotfitness.Model;


public class Exercises {


    String index;
    String exercise_name;


    public Exercises() {
    }

    public Exercises(String index, String exercise_name) {
        this.index = index;
        this.exercise_name = exercise_name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }
}
