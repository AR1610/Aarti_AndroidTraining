package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekbarRatingbarActivity extends AppCompatActivity {

    private static final String TAG = SeekbarRatingbarActivity.class.getName();
    SeekBar seekBar;
    private TextView tvSeekbar,tvRating;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar_ratingbar);
        seekBar = findViewById(R.id.seekbar);
        tvSeekbar = (TextView)findViewById(R.id.tv_seekbar);
        ratingBar = findViewById(R.id.ratingbar);
        tvRating = findViewById(R.id.tv_ratingbar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                tvRating.setText(String.valueOf(rating));
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                tvSeekbar.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                Log.e(TAG, "onStartTrackingTouch: " );

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Log.e(TAG, "onStopTrackingTouch: " );
            }
        });


    }
}