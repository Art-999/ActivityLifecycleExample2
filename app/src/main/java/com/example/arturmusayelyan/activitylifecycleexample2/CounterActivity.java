package com.example.arturmusayelyan.activitylifecycleexample2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView counterTv;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter_activity);
        counterTv = findViewById(R.id.counter_tv);
        findViewById(R.id.go_to_first_act_btn).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        counter++;
        Log.d("Art_Log", counter + "");
        counterTv.setText(counter + "");
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putInt("counter", counter);
        super.onSaveInstanceState(saveInstanceState);
        Log.d("Art_Log", counter + " was saved");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        Log.d("Art_Log", counter + " was restored");
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_to_first_act_btn:
                // ays depqum nor activity kstexcvi ev sovorakan onBackPressed()-ic tarber kashxati, mer activity destroy chi lini
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

}
