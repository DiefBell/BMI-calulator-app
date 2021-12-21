package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void convertBMI(View v){
        try{
        //get input from user
        EditText height = (EditText)findViewById(R.id.inputHeight);
        double heightConv = Double.parseDouble(height.getText().toString());//height as an integer in cm

        EditText weight = (EditText) findViewById(R.id.inputWeight);
        double weightConv = Double.parseDouble(weight.getText().toString());//weight as an integer
if((heightConv<=0)||(weightConv<=0)){
    TextView output = findViewById(R.id.outputBMI);
    output.setText("Don't leave anything as zero!\nAnd no negative values!");
}else {
    //BMI = kg/m*m
    double x = Double.parseDouble(String.format("%.1f", weightConv / ((heightConv / 100) * (heightConv / 100))));
    //output of calculated BMI
    TextView output = findViewById(R.id.outputBMI);
    output.setText(Double.toString(x));
    TextView risk  = findViewById(R.id.outputRisk);
    ConstraintLayout et = (ConstraintLayout) findViewById(R.id.background); //variable for background
    if (x <= 18.4) {
        et.setBackgroundResource(R.drawable.yellow_gradient_background);
        risk.setText("You are underweight");
    } else if (x >= 18.5 && x <= 24.9) {
        et.setBackgroundResource(R.drawable.green_gradient_background);
        risk.setText("You have normal BMI");
    }else if(x>=25.0&&x<=29.9){
        et.setBackgroundResource(R.drawable.yellow_gradient_background);
        risk.setText("You are slightly overweight");
    }else if(x>=30.0&&x<=34.9){
        et.setBackgroundResource(R.drawable.orange_gradient_background);
        risk.setText("You are overweight");
    }else if(x>=35.0&&x<=39.9){
        et.setBackgroundResource(R.drawable.red_gradient_background);
        risk.setText("You are quite overweight");
    }else if(x>=40.0){
        et.setBackgroundResource(R.drawable.dark_red_gradient_background);
        risk.setText("You are severely overweight");
    }else{
        et.setBackgroundResource(R.drawable.main_gradient_background);
    }
}
    }catch(Exception e){
            TextView output = findViewById(R.id.outputBMI);
            output.setText("Oops, something isn't quite right!");
        }
    }
}