package com.example.arturmusayelyan.activitylifecycleexample2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        counter++;
        Log.d("Art_Log",counter+"");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        Log.d("Art_Log", counter + " was saved");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        Log.d("Art_Log", counter + " was restored");
    }
}
