package com.example.arturmusayelyan.activitylifecycleexample2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //First Activity
    //http://bricolsoftconsulting.com/how-to-test-onsaveinstancestate-and-onrestoreinstancestate-on-a-real-device/
    private static final String STATE_SCORE_Key = "playerScore";
    private static final String STATE_LEVEL_KEY = "playerLevel";
    private TextView score_TextView;
    private TextView level_TextView;
    private String myCurrentScore;
    private String myCurrentLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("PrintLog", "First Activity: onCreate invoked");
        score_TextView = findViewById(R.id.textView_Score);
        level_TextView = findViewById(R.id.textView_Level);


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
        // kanchvum e onStart()-ic heto,ete mi angam stexcvel u destroy exel e activitin
        //karanq ays metodi poxoraen miangamic onCreate()-i mej stugenq
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("PrintLog", "First Activity: onRestoreInstanceState invoked");

        // Restore state members from saved instance
        myCurrentScore = savedInstanceState.getString(STATE_SCORE_Key);
        myCurrentLevel = savedInstanceState.getString(STATE_LEVEL_KEY);
        score_TextView.setText(myCurrentScore);
        level_TextView.setText(myCurrentLevel);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("PrintLog", "First Activity: onStart invoked");

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("PrintLog", "First Activity: onResume invoked");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("PrintLog", "First Activity: onPause invoked");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        // sovorakan bundle-e
        // ashxatum e misht onPause()-ic heto
        savedInstanceState.putString(STATE_SCORE_Key, "3:2");
        savedInstanceState.putString(STATE_LEVEL_KEY, "Level:7");

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
        Log.d("PrintLog", "First Activity: onSaveInstanceState invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("PrintLog", "First Activity: onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("PrintLog", "First Activity: onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("PrintLog", "First Activity: onDestroy invoked");
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.second_act_btn:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.counter_act_btn:
                startActivity(new Intent(this,CounterActivity.class));
                break;
        }
    }
}
