package com.example.dotfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BmiActivity extends AppCompatActivity {

    EditText height,weight;
    TextView result;
    Button calculate,reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        height = findViewById(R.id.edt_height);
        weight = findViewById(R.id.edt_weight);
        calculate = findViewById(R.id.btn_calculate);
        reset = findViewById(R.id.btn_reset);
        result = findViewById(R.id.tv_result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightStr = height.getText().toString();
                String weightStr = weight.getText().toString();
                if(heightStr.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please enter your height",Toast.LENGTH_LONG).show();
                }
                else if(weightStr.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please enter your weight",Toast.LENGTH_LONG).show();
                }
                else{
                calculateBMI();}
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height.setText("");
                weight.setText("");
                height.requestFocus();
            }
        });


    }



    private void calculateBMI()
    {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        float heightValue = Float.parseFloat(heightStr) /100;
        float weightValue = Float.parseFloat(weightStr) ;
        float bmi = weightValue / (heightValue * heightValue);

        String bmiText = "";

        if(bmi<=15)
        {
            bmiText = "very severely underweight";
        } else if(bmi >15 && bmi <=18.5)
        {
            bmiText = "severely underweight";
        } else if(bmi > 18.5 && bmi <= 24.5)
        {
            bmiText = "underweight";
        } else if(bmi > 24.5 && bmi <= 29.9)
        {
            bmiText = "normal";
        } else if(bmi > 29.9 && bmi <= 35)
        {
            bmiText = "overweight";
        } else if(bmi > 35 && bmi <= 39.9)
        {
            bmiText = "obese class I";
        } else if(bmi > 39.9 && bmi <= 45)
        {
            bmiText = "obese class II";
        } else
        {
            bmiText = "obese class III";
        }

        bmiText = bmi + "\n" + bmiText;
        result.setText(bmiText);
    }



}