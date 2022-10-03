package com.example.scoreadd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    TextView intentResult1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        intentResult1 = findViewById(R.id.textView2);
        //getting int value from main activity page.
        int getScore1 = getIntent().getIntExtra("intScore1",0);
        int getScore2 = getIntent().getIntExtra("intScore2",0);

        //getting string value originally from start activity page.
        String winner1 = getIntent().getStringExtra("team1win");
        String winner2 = getIntent().getStringExtra("team2win");
        String trueWinner;

        //if team1 win it shows team1. if team2 win it shows team2.
        if (getScore1 > getScore2)
        {
            trueWinner = winner1;
        } else{
            trueWinner = winner2;
        }
        intentResult1.setText("Congratulations! Team " + trueWinner + " won ");

    }
}