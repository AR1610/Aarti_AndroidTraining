package com.myappgen7to8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlertActivity extends AppCompatActivity {

    Button btnAlertDialog,btnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        btnAlertDialog = findViewById(R.id.btn_AlertDialog);
        btnCustomDialog = findViewById(R.id.btn_custom_Dialog);
        btnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater = getLayoutInflater();
                View myview = layoutInflater.inflate(R.layout.raw_dialog,null);

                AlertDialog.Builder builder = new AlertDialog.Builder(AlertActivity.this);
                AlertDialog alertDialog = builder.create();
                alertDialog.setView(myview);
                alertDialog.show();
                EditText edtEmail = myview.findViewById(R.id.edt_email);
                Button btnSubmit = myview.findViewById(R.id.btn_submit);

                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (alertDialog.isShowing()){
                            alertDialog.dismiss();
                        }
                        String strEmail = edtEmail.getText().toString();
                        Toast.makeText(AlertActivity.this, ""+strEmail, Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });
    }


    public void AlertClick(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.user_ngo);
        builder.setTitle(getResources().getString(R.string.app_name));
        builder.setMessage("Are you sure, you want to delete?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(AlertActivity.this, "Yes is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(AlertActivity.this, "No is clicked", Toast.LENGTH_SHORT).show();

            }
        });

        builder.setNeutralButton("Finish", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        builder.show();

    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.user_ngo);
        builder.setTitle(getResources().getString(R.string.app_name));
        builder.setMessage("Are you sure, you want to back?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        builder.show();


    }
}