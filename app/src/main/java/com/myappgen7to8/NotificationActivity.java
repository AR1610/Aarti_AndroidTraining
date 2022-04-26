package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity {

    Button btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        btnNotification = findViewById(R.id.btn_notification);

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel =
                            new NotificationChannel("com.myappgen7to8",
                                    getString(R.string.app_name), NotificationManager.IMPORTANCE_DEFAULT);


                    Intent i = new Intent(NotificationActivity.this, CustomListViewActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this,
                            1, i, PendingIntent.FLAG_ONE_SHOT);


                    NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationActivity.this);
                    builder.setSmallIcon(R.drawable.ic_house);
                    builder.setContentTitle("MyApp 7 to 8");
                    builder.setContentText("No Lecture today");
                    builder.setContentIntent(pendingIntent);
                    builder.setChannelId("com.myappgen7to8");


                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.createNotificationChannel(notificationChannel);
                    notificationManager.notify(1, builder.build());

                }
            }
        });

    }
}