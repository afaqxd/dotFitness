package com.example.dotfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ExercisesActivity extends AppCompatActivity {

    ImageView img_pushups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        img_pushups = findViewById(R.id.img_pushupsyt);

        img_pushups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrlPushups("https://www.youtube.com/watch?v=IODxDxX7oi4");
            }
        });



    }

    private void gotoUrlPushups(String s)
    {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}