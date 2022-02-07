package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    ListView listView;

    String strLang[] = {"Android", "Java", "Python", "PHP", "C", "C++", "IOS"};
    int imgLang[] = {R.mipmap.ic_launcher_round, R.drawable.ic_java,
            R.drawable.ic_python, R.drawable.ic_php, R.drawable.ic_c, R.drawable.ic_cc, R.drawable.ic_ios};
    ArrayList<LangModel> langModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        listView = findViewById(R.id.list_view);

        langModelArrayList = new ArrayList<LangModel>();
        for (int i = 0; i < strLang.length; i++) {
            LangModel langModel = new LangModel(strLang[i], imgLang[i]);
            langModelArrayList.add(langModel);
        }

        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this,langModelArrayList);
        listView.setAdapter(myBaseAdapter);

    }
}