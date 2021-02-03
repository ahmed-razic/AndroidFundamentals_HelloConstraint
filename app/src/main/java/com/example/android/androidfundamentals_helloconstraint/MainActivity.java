package com.example.android.androidfundamentals_helloconstraint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCountUp;
    private TextView mShowCount;
    private Button mZeroButton;
    private Button mCountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.textView_count);
        mZeroButton = findViewById(R.id.button_zero);
        mCountButton = findViewById(R.id.button_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "Show toast text", Toast.LENGTH_LONG);
        toast.show();
    }

    public void resetToZero(View view) {
        mCountUp = 0;
        mShowCount.setText(String.valueOf(mCountUp));

        view.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
        mCountButton.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
    }

    public void countUp(View view) {

        mCountUp++;
        mShowCount.setText(String.valueOf(mCountUp));

        if ( mCountUp % 2 == 0 ) {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
        } else {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
        }
        mZeroButton.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
    }
}