package com.example.dotfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ShowDietPlansActivity extends AppCompatActivity {

    LinearLayout act_weightGain;
    LinearLayout act_weightLoss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_diet_plans);
        act_weightGain = findViewById(R.id.lay_gainweight);
        act_weightLoss = findViewById(R.id.lay_loseweight);

        act_weightGain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowDietPlansActivity.this, WeightGainActivity.class);
                startActivity(intent);
                final MediaPlayer mp1 = MediaPlayer.create(ShowDietPlansActivity.this, R.raw.voice_gainweight);
                mp1.start();
            }
        });
        act_weightLoss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowDietPlansActivity.this, WeightLossActivity.class);
                startActivity(intent);
                final MediaPlayer mp1 = MediaPlayer.create(ShowDietPlansActivity.this, R.raw.voice_loseweight);
                mp1.start();
            }
        });


    }
}