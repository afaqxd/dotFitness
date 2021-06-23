package com.example.dotfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import java.util.Random;
import java.util.Spliterator;

public class SplashScreen extends AppCompatActivity {

    Animation anim01,anim02,anim03;
    ImageView dot,fitness,loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        dot = findViewById(R.id.img_dot);
        fitness = findViewById(R.id.img_fitness);
        loading = findViewById(R.id.img_heart);

        anim01 = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.slide_right);
        fitness.startAnimation(anim01);
        anim02 = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.anim_scale);
        dot.startAnimation(anim02);
        anim03 = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.rotate_heart);
        loading.startAnimation(anim03);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },2500);

    }

}