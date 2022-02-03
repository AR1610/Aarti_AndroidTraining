package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
SwitchCompat switchCompat;
ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        switchCompat = findViewById(R.id.bswitch);
        toggleButton = findViewById(R.id.cSwitch);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    Toast.makeText(VideoActivity.this, "ON", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(VideoActivity.this, "OFF", Toast.LENGTH_SHORT).show();

                }
            }
        });



        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    Toast.makeText(VideoActivity.this, "ON", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(VideoActivity.this, "OFF", Toast.LENGTH_SHORT).show();

                }
            }
        });


        videoView = findViewById(R.id.video_view);
        String strPath = "android.resource://" +
                getPackageName() + "/" + R.raw.motivational_video;
        videoView.setVideoPath(strPath);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();



    }
}