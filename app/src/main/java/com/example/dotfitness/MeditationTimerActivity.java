package com.example.dotfitness;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MeditationTimerActivity extends AppCompatActivity {

    private static long START_TIME = 600000; // 10 Mins
    TextView text_timer;
    Button timerStart,timerReset;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = START_TIME;
    private boolean timerRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation_timer);

        text_timer = findViewById(R.id.tv_med_timer);
        timerStart = findViewById(R.id.btn_timerStartPause);

        timerReset = findViewById(R.id.btn_timerReset);

        timerStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });

        timerReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDown();
    }


    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateCountDown();
            }
            @Override
            public void onFinish() {
                timerRunning = false;
                timerStart.setText("Start");
                timerStart.setVisibility(View.INVISIBLE);
                timerReset.setVisibility(View.VISIBLE);
            }
        }.start();
        timerRunning = true;
        timerStart.setText("pause");
        timerReset.setVisibility(View.INVISIBLE);
    }


    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        timerStart.setText("START");
        timerReset.setVisibility(View.VISIBLE);

    }

    private void resetTimer() {
        timeLeftInMilliseconds = START_TIME;
        updateCountDown();
        timerReset.setVisibility(View.INVISIBLE);
        timerStart.setVisibility(View.VISIBLE);
    }


    private void updateCountDown() {
        int minutes = (int) ((timeLeftInMilliseconds / 1000) / 60); // casting because timeleft is in long
        int seconds = (int) ((timeLeftInMilliseconds / 1000) % 60);
        String timeFormat = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        text_timer.setText(timeFormat);
    }
}