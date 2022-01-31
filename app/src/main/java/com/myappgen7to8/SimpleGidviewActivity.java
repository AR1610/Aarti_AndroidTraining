package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class SimpleGidviewActivity extends AppCompatActivity {

    GridView gridView;
    String strLang[] = {"Android","Java",".net","PHP","C","C++","Flutter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_gidview);
        gridView = findViewById(R.id.grid_view);

        ArrayAdapter<String> arrayAdapter = new
                ArrayAdapter<String>(this,R.layout.raw_list,R.id.tv_data,strLang);

        gridView.setAdapter(arrayAdapter);
    }
}