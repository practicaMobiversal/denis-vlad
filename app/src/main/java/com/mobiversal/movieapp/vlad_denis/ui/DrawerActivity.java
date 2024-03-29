package com.mobiversal.movieapp.vlad_denis.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.mobiversal.movieapp.vlad_denis.R;

public class DrawerActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        initToolbar();
        initDrawer();
        showFirstFragment();
    }


    private void showFirstFragment() {
        switchFragment(new FirstFragment());
    }

    private void showSecondFragment() {
        switchFragment(new SecondFragment());
    }


    private void switchFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.fl_container, fragment)
                .commit();
    }

    private void initToolbar () {
        drawerLayout = findViewById(R.id.dl_drawer);
        Toolbar toolbar = findViewById(R.id.tb_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));
    }

    private void initDrawer() {
        navigationView = findViewById(R.id.nv_navigation);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            handleNavigation(menuItem.getItemId());
            closeDrawer();
            return true;
        });
    }
    private void closeDrawer() {
        drawerLayout.closeDrawers();
    }

    private void handleNavigation(int destinationId) {
    switch (destinationId) {
        case R.id.first:
            showFirstFragment();
            break;
        case R.id.second:
            showSecondFragment();
            break;
    }

    }



}
