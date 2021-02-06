package com.example.android.androidfundamentals_activitylifecycle;

import androidx.annotation.NonNull;
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

    private int mCount;
    private TextView mShowCount;
    private Button mZeroButton;
    private Button mCountButton;
    private TextView mSampleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.textView_count);
        mZeroButton = findViewById(R.id.button_zero);
        mCountButton = findViewById(R.id.button_count);
        mSampleText = findViewById(R.id.sample_textView);

        if (savedInstanceState != null) {
            // Restore value of members from saved state.
            mCount = savedInstanceState.getInt("count");
            mShowCount.setText(String.valueOf(mCount));
            if(savedInstanceState.getBoolean("visible")){
                mSampleText.setVisibility(View.VISIBLE);
                mSampleText.setText(savedInstanceState.getString("sample_text"));
            };
        }
    }

    public void showHello(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("KEY", mCount);
        startActivity(intent);
    }

    public void resetToZero(View view) {
        mCount = 0;
        mShowCount.setText(String.valueOf(mCount));
        mSampleText.setText("");

        view.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
        mCountButton.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
    }

    public void countUp(View view) {

        mCount++;
        mShowCount.setText(String.valueOf(mCount));

        if ( mCount % 2 == 0 ) {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
            if (mSampleText.getVisibility() == View.INVISIBLE) {
                mSampleText.setVisibility(View.VISIBLE);
                mSampleText.setText(R.string.even_number);
            }

        } else {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
            mSampleText.setVisibility(View.INVISIBLE);
        }
        mZeroButton.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("count", mCount);
        if(mSampleText.getVisibility() == View.VISIBLE) {
            savedInstanceState.putBoolean("visible", true);
            savedInstanceState.putString("sample_text", (String) mSampleText.getText());
        }
    }
}