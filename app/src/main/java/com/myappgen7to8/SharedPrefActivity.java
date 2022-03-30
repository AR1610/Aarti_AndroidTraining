package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedPrefActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtFn, edtLn;
    Button btnAdd, btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        edtFn = findViewById(R.id.edt_fn);
        edtLn = findViewById(R.id.edt_ln);
        btnAdd = findViewById(R.id.btn_add);
        btnDisplay = findViewById(R.id.btn_display);
        btnAdd.setOnClickListener(this);
        btnDisplay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_add:

                String strFn = edtFn.getText().toString();
                String strLn = edtLn.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("MYAPP_GEN_7_to_8", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("PREF_KEY_FN", strFn);
                editor.putString("PREF_KEY_LN", strLn);
                editor.commit();

                edtFn.setText("");
                edtLn.setText("");

                break;


            case R.id.btn_display:

                SharedPreferences sharedPreferences1 = getSharedPreferences("MYAPP_GEN_7_to_8", MODE_PRIVATE);

                String str_fn = sharedPreferences1.getString("PREF_KEY_FN", "");
                String str_ln = sharedPreferences1.getString("PREF_KEY_LN", "");

                edtFn.setText(str_fn);
                edtLn.setText(str_ln);


                break;
        }
    }
}