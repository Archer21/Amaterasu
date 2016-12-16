package com.archer.amaterasu.utils;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import com.archer.amaterasu.common.BaseActivity;

/**
 * Created by archer on 16-12-16.
 */

public abstract class SetupNavigationDrawer extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    public void configDrawer (int stringOpen, int stringClose) {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, getDrawer(), getToolbar(), stringOpen, stringClose);
        getDrawer().setDrawerListener(toggle);
        toggle.syncState();

        getNavigationView().setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getDrawer().isDrawerOpen(GravityCompat.START)) {
            getDrawer().closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public abstract DrawerLayout getDrawer ();
    public abstract NavigationView getNavigationView ();

}











































