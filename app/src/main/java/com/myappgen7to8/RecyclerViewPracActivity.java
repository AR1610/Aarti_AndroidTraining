package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewPracActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String strLang[] = {"Android", "Java", "Python", "PHP", "C", "C++", "IOS"};
    int imgLang[] = {R.mipmap.ic_launcher_round, R.drawable.ic_java,
            R.drawable.ic_python, R.drawable.ic_php, R.drawable.ic_c, R.drawable.ic_cc, R.drawable.ic_ios};
    ArrayList<LangModel> langModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_prac);
        recyclerView = findViewById(R.id.recycler_view);


        langModelArrayList = new ArrayList<LangModel>();
        for (int i = 0; i < strLang.length; i++) {
            LangModel langModel = new LangModel(strLang[i], imgLang[i]);
            langModelArrayList.add(langModel);
        }


        MyRecyclerParcAdapter myRecyclerParcAdapter = new MyRecyclerParcAdapter(this,langModelArrayList);
        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myRecyclerParcAdapter);


    }
}