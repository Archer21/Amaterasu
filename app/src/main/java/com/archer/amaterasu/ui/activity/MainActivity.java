package com.archer.amaterasu.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import com.archer.amaterasu.R;
import com.archer.amaterasu.ui.fragment.HomeFragment;
import com.archer.amaterasu.ui.fragment.HotSongsFragment;
import com.archer.amaterasu.ui.fragment.SearchFragment;
import com.archer.amaterasu.utils.Helpers;
import com.archer.amaterasu.utils.SetupNavigationDrawer;

import butterknife.BindView;

public class MainActivity extends SetupNavigationDrawer {

    // BINDED VIEWS WITH BUTTERKNIFE
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    // ACTIVITY INSTANCES AND REFERENCES
    private final String LOG_TAG = MainActivity.this.getClass().getSimpleName();
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction fragmentTransaction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar(toolbar);
        configDrawer(R.string.open_drawer, R.string.close_drawer);
        if (savedInstanceState == null) {
            Helpers.setupFragment(fragmentManager, new HomeFragment(), R.id.main_container);
        }
    }

    // ACTIVITY METHODS

//    public void setupFragment (Fragment fragment) {
//        fragmentManager = getSupportFragmentManager();
//        fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.main_container, fragment).commit();
//    }


   // OVERRIDED METHODS FROM BASEACTIVITY

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public DrawerLayout getDrawer() {
        return drawer;
    }

    @Override
    public NavigationView getNavigationView() {
        return navigationView;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.drawer_home) {
            Helpers.setupFragment(fragmentManager, new HomeFragment(), R.id.main_container);
        } else if (id == R.id.drawer_search) {
            Helpers.setupFragment(fragmentManager, new SearchFragment(), R.id.main_container);
        } else if (id == R.id.drawer_log_out) {
            Log.d(LOG_TAG, "Logout of the application");
        }

        getDrawer().closeDrawer(GravityCompat.START);
        return true;

    }
}






























