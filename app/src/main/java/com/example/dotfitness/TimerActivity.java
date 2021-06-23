package com.example.dotfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    TextView text_ExerciseName;
    TextView text_timer;
    Button timerStart;
    ImageView img_ytIcon;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 30000; // 30 seconds time
    private boolean timerRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        text_ExerciseName = findViewById(R.id.tv_exerciseName);
        text_timer = findViewById(R.id.tv_timerView);
        timerStart = findViewById(R.id.btn_timerStart);
        img_ytIcon = findViewById(R.id.img_yt);

        Intent intent = getIntent();
        String tempName = intent.getStringExtra("exerName").toString();
        String tempIndex = intent.getStringExtra("exerIndex").toString();
        int tab_position = (intent.getIntExtra("exerNumber", 0));
        text_ExerciseName.setText(tempIndex + " " + tempName);

        img_ytIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tab_position == 0) {
                    gotoUrlArmRaises("https://www.youtube.com/watch?v=i_vx_I9-v6U");
                }else if (tab_position == 1) {
                    gotoUrlTriceps("https://www.youtube.com/watch?v=dl8_opV0A0Y");
                }else if (tab_position == 2) {
                    gotoUrlDiamondPushups("https://www.youtube.com/watch?v=J0DnG1_S92I");
                }else if (tab_position == 3) {
                    gotoUrlJumpingJacks("https://www.youtube.com/watch?v=zJmYRT4v9rw");
                }else if (tab_position == 4) {
                    gotoUrlDiagonalPlank("https://www.youtube.com/watch?v=qXWu8sN3NOc");
                }else if (tab_position == 5) {
                    gotoUrlBurpees("https://www.youtube.com/watch?v=rg0f_LYhqQA");
                }else if (tab_position == 6) {
                    gotoUrlArmScissors("https://www.youtube.com/watch?v=dPDsW7xvuVY");
                }else if (tab_position == 7) {
                    gotoUrlGators("https://www.youtube.com/watch?v=4c-wsl6BA-E");
                }
            }
        });

        timerStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });
        updateTimer();
    }

    private void startStop() {
        if (timerRunning) {
            stopTimer();
        } else {
            startTimer();
        }

    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                final MediaPlayer mp1 = MediaPlayer.create(TimerActivity.this, R.raw.sound_tick);
                mp1.start();
                timeLeftInMilliseconds = l;
                updateTimer();

            }

            @Override
            public void onFinish() {

            }
        }.start();
        timerStart.setText("PAUSE");
        timerRunning = true;
    }

    private void updateTimer() {

        int seconds = (int) timeLeftInMilliseconds / 1000;
        String timeLeftText;
        timeLeftText = "00" + ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;
        text_timer.setText(timeLeftText);

    }

    private void stopTimer() {
        countDownTimer.cancel();
        timerStart.setText("START");
        timerRunning = false;
    }

    private void gotoUrlArmRaises(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void gotoUrlTriceps(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void gotoUrlDiamondPushups(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void gotoUrlJumpingJacks(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void gotoUrlDiagonalPlank(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void gotoUrlBurpees(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void gotoUrlArmScissors(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void gotoUrlGators(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

}