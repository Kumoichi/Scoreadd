package com.example.scoreadd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    EditText edittext1, edittext2;
    TextView textview1, textview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        edittext1 = findViewById(R.id.editTeamName1);
        edittext2 = findViewById(R.id.editTeamName2);
        textview1 = findViewById(R.id.textViewTeamname1);
        textview2 = findViewById(R.id.textViewTeamname2);
    }

    //displaying teamname.
    public void buttonDisplay(View view) {
        String teamName1 = edittext1.getText().toString();
        String teamName2 = edittext2.getText().toString();
        textview1.setText(teamName1);
        textview2.setText(teamName2);
    }

    //moving String values to the main activity page.
    public void nextPage(View view) {
        String input1 = edittext1.getText().toString();
        String input2 = edittext2.getText().toString();
        Intent intent = new Intent(StartActivity.this,MainActivity.class);
        intent.putExtra("userInput1",input1);
        intent.putExtra("userInput2",input2);
        startActivity(intent);
    }

}