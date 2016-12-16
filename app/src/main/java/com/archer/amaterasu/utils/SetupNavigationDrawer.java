package com.archer.amaterasu.utils;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import com.archer.amaterasu.common.BaseActivity;

public abstract class SetupNavigationDrawer extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView navigationView;

    public void configNavigationDrawerViews(int stringOpen, int stringClose){
        drawer = (DrawerLayout) findViewById(getDrawerLayoutID());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, getToolbar(), stringOpen, stringClose);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(getNavigationViewID());
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(getDrawerLayoutID());
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Helper methods
     */

    public NavigationView getNavigationView(){
        return navigationView;
    }

    public DrawerLayout getDrawer(){
        return drawer;
    }

    /**
     * Abstract methods
     */

    public abstract int getDrawerLayoutID();
    public abstract int getNavigationViewID();
}




















