package com.myappgen7to8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        bottomNavigationView = findViewById(R.id.bottom_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.item_home){

                    Toast.makeText(BottomActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    toolbar.setTitle("Home");
                }else  if (id == R.id.item_profile){

                    toolbar.setTitle("Profile");
                    Toast.makeText(BottomActivity.this, "Add", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });


    }
}