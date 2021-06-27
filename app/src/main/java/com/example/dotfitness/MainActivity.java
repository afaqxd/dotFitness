package com.example.dotfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation anim01,anim02,anim03,anim04,anim05,anim06,anim07;
    LinearLayout act_bmi, act_exercises, act_medTimer, act_diets,act_wallpapers,act_signout;
    CardView cardBMI,cardEXERCISES,cardMEDITATION;
    CardView cardDIETS,cardWALLPAPERS,cardSIGNOUT;
    CardView cardDASHBOARD;
    TextView text_DisplayName;
    SharedPreferences sh1;
    SharedPreferences.Editor editor1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        act_bmi = findViewById(R.id.lay_bmi);
        act_exercises = findViewById(R.id.lay_exercises);
        act_medTimer = findViewById(R.id.lay_medTimer);
        act_diets = findViewById(R.id.lay_diet);
        act_wallpapers = findViewById(R.id.lay_wallpapers);
        act_signout = findViewById(R.id.lay_signout);
        text_DisplayName = findViewById(R.id.tv_main_user);
        cardBMI = findViewById(R.id.cardview_bmi);
        cardEXERCISES = findViewById(R.id.cardview_exercises);
        cardMEDITATION = findViewById(R.id.cardview_meditation);
        cardDIETS = findViewById(R.id.card_diets);
        cardWALLPAPERS = findViewById(R.id.card_wallpapers);
        cardSIGNOUT = findViewById(R.id.card_signout);
        cardDASHBOARD = findViewById(R.id.card_dashboard);

        anim01 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_right1);
        act_bmi.startAnimation(anim01);
        cardBMI.startAnimation(anim01);

        anim02 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_right2);
        act_exercises.startAnimation(anim02);
        cardEXERCISES.startAnimation(anim02);

        anim03 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_right3);
        act_medTimer.startAnimation(anim03);
        cardMEDITATION.startAnimation(anim03);

        anim04 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_left1);
        act_diets.startAnimation(anim04);
        cardDIETS.startAnimation(anim04);

        anim05 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_left2);
        act_wallpapers.startAnimation(anim05);
        cardWALLPAPERS.startAnimation(anim05);

        anim06 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_left3);
        act_signout.startAnimation(anim06);
        cardSIGNOUT.startAnimation(anim06);

        anim07 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_top_to_bottom);
        cardDASHBOARD.startAnimation(anim07);




        sh1 = getSharedPreferences("DATA",MODE_PRIVATE);
        editor1 = sh1.edit();


        Intent intent1 = getIntent();
        String UserName = intent1.getStringExtra("name1");

        text_DisplayName.setText(sh1.getString("N",""));

        act_exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ExercisesActivity.class);
                startActivity(intent);
                final MediaPlayer mp1 = MediaPlayer.create(MainActivity.this, R.raw.voice_exercises);
                mp1.start();
            }
        });
        act_medTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MeditationTimerActivity.class);
                startActivity(intent);
                final MediaPlayer mp1 = MediaPlayer.create(MainActivity.this, R.raw.voice_meditation);
                mp1.start();
            }
        });

        act_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BmiActivity.class);
                startActivity(intent);
                final MediaPlayer mp1 = MediaPlayer.create(MainActivity.this, R.raw.voice_bmicalculator);
                mp1.start();
            }
        });

        act_wallpapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WallpapersActivity.class);
                startActivity(intent);
                final MediaPlayer mp1 = MediaPlayer.create(MainActivity.this, R.raw.voice_wallpapers);
                mp1.start();
            }
        });

        act_diets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowDietPlansActivity.class);
                startActivity(intent);
                final MediaPlayer mp1 = MediaPlayer.create(MainActivity.this, R.raw.voice_dietplans);
                mp1.start();
            }
        });

        act_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sh1.edit().clear().commit();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}