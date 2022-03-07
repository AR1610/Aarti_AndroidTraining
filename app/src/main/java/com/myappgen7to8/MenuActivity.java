package com.myappgen7to8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    TextView tvClick;
    Button btnPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tvClick = findViewById(R.id.tv_click);
        registerForContextMenu(tvClick);
        btnPopUp = findViewById(R.id.btn_popup);
        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MenuActivity.this,btnPopUp);

                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.item_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.ite_add:
                                Toast.makeText(MenuActivity.this, "Add", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.ite_delete:
                                Toast.makeText(MenuActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.ite_edit:
                                Toast.makeText(MenuActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                                return true;
                        }

                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
 @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.ite_add:
                Toast.makeText(MenuActivity.this, "Add", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.ite_delete:
                Toast.makeText(MenuActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.ite_edit:
                Toast.makeText(MenuActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu,menu);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.ite_add:
                Toast.makeText(MenuActivity.this, "Add", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.ite_delete:
                Toast.makeText(MenuActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.ite_edit:
                Toast.makeText(MenuActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                return true;
        }



        return super.onContextItemSelected(item);
    }
}