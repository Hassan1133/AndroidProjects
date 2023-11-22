package com.example.myfirstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView toogleBtn;
    DrawerLayout drawer;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        initialize(); // initialization method for initializing variables
        startDrawer(); // start drawer method for open or close navigation drawer
        bottomNavigationSelection(); // selection method for bottom navigation items
    }

    void initialize()
    {
        toogleBtn = findViewById(R.id.tool_bar_menu);
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        loadFragment(new MainFragment());
    }

    void startDrawer()
    {
        toogleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.openDrawer(GravityCompat.START);
                }
                else {
                    drawer.closeDrawer(GravityCompat.END);
                }
            }
        });
    }

    void loadFragment(Fragment fragment)
    {
        if(fragment != null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
        }
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    private void bottomNavigationSelection()
    {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home:
                        loadFragment(new MainFragment());
                        return true;
                    case R.id.about:
                        loadFragment(new AboutFragment());
                        return true;
                }
                return false;
            }
        });
    }
}