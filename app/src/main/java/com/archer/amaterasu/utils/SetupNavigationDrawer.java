package com.archer.amaterasu.utils;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseActivity;

public abstract class SetupNavigationDrawer extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    public void configViews(int stringOpen, int stringClose){
        DrawerLayout drawer = (DrawerLayout) findViewById(getDrawerLayoutID());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, getToolbar(), stringOpen, stringClose);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(getNavigationViewID());
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    /**
     * Abstract methods
     */

    public abstract int getDrawerLayoutID();
    public abstract int getNavigationViewID();
    public abstract boolean onNavigationItemSelected(MenuItem item);
}
