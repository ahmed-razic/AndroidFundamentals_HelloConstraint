package com.example.android.androidfundamentals_activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(LOG_TAG, "--------");
        Log.d(LOG_TAG, "onCreate()");

        TextView countTextView = findViewById(R.id.count_textView);
        Intent intent = getIntent();
        int count = intent.getIntExtra("KEY", 0);

        countTextView.setText(String.valueOf(count));
    }
}




