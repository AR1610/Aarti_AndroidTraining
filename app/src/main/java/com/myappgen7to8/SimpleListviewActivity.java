package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleListviewActivity extends AppCompatActivity {
    ListView listView;
    String strLang[] = {"Android","Java",".net","PHP","C","C++","Flutter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_listview);
        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,strLang);

     /*   ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.raw_list,R.id.tv_data,strLang);*/
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String strData = parent.getItemAtPosition(position).toString();
                Toast.makeText(SimpleListviewActivity.this, ""+strData,
                        Toast.LENGTH_SHORT).show();
            }
        });




    }
}