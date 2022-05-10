package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlarmActivity extends AppCompatActivity {

    EditText edtTime;
    Button btnTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        edtTime = findViewById(R.id.edt_time);
        btnTime = findViewById(R.id.btn_time);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int time = Integer.parseInt(edtTime.getText().toString());
                Intent  i = new Intent(AlarmActivity.this,MyBroadcast.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this,
                        1,i,PendingIntent.FLAG_ONE_SHOT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(time*1000),pendingIntent);

            }
        });
    }
}