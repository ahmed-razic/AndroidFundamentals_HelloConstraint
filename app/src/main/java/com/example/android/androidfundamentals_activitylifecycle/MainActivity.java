package com.example.android.androidfundamentals_activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private int mCount;
    private TextView mShowCount;
    private Button mZeroButton;
    private Button mCountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "--------");
        Log.d(LOG_TAG, "onCreate()");

        mShowCount = findViewById(R.id.textView_count);
        mZeroButton = findViewById(R.id.button_zero);
        mCountButton = findViewById(R.id.button_count);
    }

    public void showHello(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("KEY", mCount);
        startActivity(intent);
    }

    public void resetToZero(View view) {
        mCount = 0;
        mShowCount.setText(String.valueOf(mCount));

        view.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
        mCountButton.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
    }

    public void countUp(View view) {

        mCount++;
        mShowCount.setText(String.valueOf(mCount));

        if ( mCount % 2 == 0 ) {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
        } else {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
        }
        mZeroButton.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy()");
    }
}