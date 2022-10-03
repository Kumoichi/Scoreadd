package com.example.scoreadd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    static int mScore1 = 0;
    static int mScore2 = 0;

    TextView mScoreText1,mScoreText2,intentTeam1, intentTeam2;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){
            //get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //set the theme mode for the restarted activity
            if(nightMode==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);

        //change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);
        intentTeam1 = findViewById(R.id.givenTeam1);
        intentTeam2 = findViewById(R.id.givenTeam2);


        String teamName1 = getIntent().getStringExtra("userInput1");
        String teamName2 = getIntent().getStringExtra("userInput2");

        intentTeam1.setText(teamName1);
        intentTeam2.setText(teamName2);

        if(savedInstanceState != null){
            mScore1 = savedInstanceState.getInt("STATE_SCORE_1");
            mScore2 = savedInstanceState.getInt("STATE_SCORE_2");

            //set the score text views
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }

    }



    public void decreaseScore(View view) {
        //get the id of the button that was clicked
        int viewID = view.getId(); //why is it int here?

        switch (viewID){
            //if it was on Team1
            case R.id.decreaseTeam1:

                //decrement the score and update the TextView
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            //if it was on Team2
            case R.id.decreaseTeam2:
                //Decrement the score and update the textview.
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
        }

    }

    public void increaseScore(View view) {
        //get the id of the button that was clicked
        int ViewID = view.getId();
        switch(ViewID){
            case R.id.increaseTeam1:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
                //if it was Team2
            case R.id.increaseTeam2:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        //save the scores
        outState.putInt("STATE_SCORE_1",mScore1);
        outState.putInt("STATE_SCORE_2",mScore2);
        super.onSaveInstanceState(outState);
    }

    //moving string value and int value to the result activity page.
    public void moveToResult(View view) {
        //if score is same it moves to draw page
        if (mScore2 == mScore1)
        {
            Intent i1 = new Intent(MainActivity.this,DrawActivity.class);
            startActivity(i1);
        }
        else {
            String teamName1 = getIntent().getStringExtra("userInput1");
            String teamName2 = getIntent().getStringExtra("userInput2");
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("intScore1", mScore1);
            intent.putExtra("intScore2", mScore2);
            intent.putExtra("team1win", teamName1);
            intent.putExtra("team2win", teamName2);
            startActivity(intent);
        }

    }
}