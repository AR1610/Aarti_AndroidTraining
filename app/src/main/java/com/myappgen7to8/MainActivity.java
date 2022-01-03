package com.myappgen7to8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail;
    Button btnLogin,btnSend;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edt_email);
        btnLogin = findViewById(R.id.btn_login);
        imgLogo = findViewById(R.id.img_logo);
        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https:www.google.com/"));
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail = edtEmail.getText().toString();

                imgLogo.setImageResource(R.drawable.img_bg);
                // edtEmail.setError("Enter Email ID");
                Toast.makeText(MainActivity.this,
                        "Email id is  " + strEmail, Toast.LENGTH_SHORT).show();
               /* Intent i = new Intent(MainActivity.this, HomeActivity.class);
                i.putExtra("KEY_EMAIL", strEmail);
                startActivity(i);*/
            }
        });
    }
}