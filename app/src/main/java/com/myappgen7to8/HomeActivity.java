package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvEmail = findViewById(R.id.tv_email);

        Intent i = getIntent();
        String strEmail = i.getStringExtra("KEY_EMAIL");

        tvEmail.setText("Email id is "+strEmail);
    }
}