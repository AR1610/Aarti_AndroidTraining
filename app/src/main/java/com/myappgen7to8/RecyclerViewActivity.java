package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.myappgen7to8.webservice.Utils;
import com.myappgen7to8.webservice.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        findID();
        dataGetFromServer();

    }

    private void findID() {

        recyclerView = findViewById(R.id.recyclerview);

    }

    private void dataGetFromServer() {

        ArrayList<UserModel> userModelArrayList = new ArrayList<UserModel>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utils.main_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        UserModel userModel = new UserModel();
                        userModel.setId(jsonObject.getInt("id"));
                        userModel.setFirst_name(jsonObject.getString("first_name"));
                        userModel.setLast_name(jsonObject.getString("last_name"));
                        userModel.setEmail(jsonObject.getString("email"));

                        userModelArrayList.add(userModel);

                        loadData(userModelArrayList);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);


    }


    private void loadData(ArrayList<UserModel> userModelArrayList) {


        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(this, userModelArrayList);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(myRecyclerAdapter);

    }
}