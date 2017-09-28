package com.example.arturmusayelyan.activitylifecycleexample2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //http://bricolsoftconsulting.com/how-to-test-onsaveinstancestate-and-onrestoreinstancestate-on-a-real-device/
    static final String STATE_SCORE_Key = "playerScore";
    static final String STATE_LEVEL_KEY = "playerLevel";
    private TextView score_TextView;
    private TextView level_TextView;
    private String myCurrentScore;
    private String myCurrentLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Art_Log", "MainActivity  onCreate invoked");
        score_TextView = (TextView) findViewById(R.id.textView_Score);
        level_TextView = (TextView) findViewById(R.id.textView_Level);


        if (savedInstanceState != null) {
            myCurrentScore = savedInstanceState.getString(STATE_SCORE_Key);
            myCurrentLevel = savedInstanceState.getString(STATE_LEVEL_KEY);
        }
        score_TextView.setText(myCurrentScore);
        level_TextView.setText(myCurrentLevel);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Art_Log","MainActivity  onRestoreInstanceState invoked");

        // Restore state members from saved instance
        myCurrentScore = savedInstanceState.getString(STATE_SCORE_Key);
        myCurrentLevel = savedInstanceState.getString(STATE_LEVEL_KEY);
        score_TextView.setText(myCurrentScore);
        level_TextView.setText(myCurrentLevel);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Art_Log", "MainActivity  onStart invoked");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Art_Log", "MainActivity  onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Art_Log", "MainActivity  onPause invoked");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putString(STATE_SCORE_Key, "3:2");
        savedInstanceState.putString(STATE_LEVEL_KEY, "Level:7");

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
        Log.d("Art_Log", "MainActivity  onSaveInstanceState invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Art_Log", "MainActivity  onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Art_Log", "MainActivity  onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Art_Log", "MainActivity  onDestroy invoked");
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
