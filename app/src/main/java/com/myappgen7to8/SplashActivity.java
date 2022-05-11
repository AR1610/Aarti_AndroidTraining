package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    int time = 3000;
    GifImageView imgGIF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // getSupportActionBar().hide();

        imgGIF = findViewById(R.id.img_gif);
        imgGIF.setGifImageResource(R.drawable.android_google);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this,RecyclerViewPracActivity.class);
                startActivity(i);
                finish();
            }
        },time);

    }
}