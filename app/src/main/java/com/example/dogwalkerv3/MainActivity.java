package com.example.dogwalkerv3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dogwalkerv3.database.Database;
import com.example.dogwalkerv3.uiposts.newpost.NewPostFragment;
import com.example.dogwalkerv3.users.ui.AccountDataFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Toolbar appBar;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //action bar
        //appBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        // Replace this with the action you want to perform when the home icon is clicked
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainerView, new ContentFragment())
                                .commit();
                        break;
                    case R.id.navigation_add_content:
                        // Replace this with the action you want to perform when the add content icon is clicked
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainerView, new NewPostFragment())
                                .commit();
                        break;
                    case R.id.navigation_account_data:
                        // Replace this with the action you want to perform when the account data icon is clicked
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainerView, new AccountDataFragment())
                                .commit();
                        break;
                }
                return false;
            }
        });

    }

    public void showPopupMenu(View v) {

        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.main_menu, popupMenu.getMenu());

        // Set a listener to handle menu item clicks
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_1:
                        // Handle menu item 1 click
                        return true;
                    case R.id.menu_item_2:
                        // Handle menu item 2 click
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }

}