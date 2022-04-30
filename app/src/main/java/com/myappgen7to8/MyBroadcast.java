package com.myappgen7to8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

public class MyBroadcast extends BroadcastReceiver {

    MediaPlayer mediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {

        mediaPlayer = MediaPlayer.create(context,R.raw.alarm_sound);
        mediaPlayer.start();
    }
}
