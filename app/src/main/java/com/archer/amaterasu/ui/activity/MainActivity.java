package com.archer.amaterasu.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.archer.amaterasu.R;
import com.archer.amaterasu.ui.fragment.ArtistDetailFragment;
import com.archer.amaterasu.ui.fragment.FavoritesFragment;
import com.archer.amaterasu.ui.fragment.MainFragment;
import com.archer.amaterasu.ui.fragment.TopArtistFragment;
import com.archer.amaterasu.ui.fragment.TopSongsFragment;
import com.archer.amaterasu.utils.PagerAdapter;
import com.archer.amaterasu.utils.SetupNavigationDrawer;

import java.util.ArrayList;

public class MainActivity extends SetupNavigationDrawer{

    private FragmentManager     fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar();
        configNavigationDrawerViews(R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (savedInstanceState == null){
            setupFragmentConfiguration();
        }
    }


    protected void setupFragmentConfiguration(){
        fragmentManager     = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new MainFragment()).commit();
    }


    /**
     * BASE ACTIVITY OVERRIDES METHODS
     */


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }



    /**
     * SETUP NAVIGATION DRAWER OVERRIDED METHODS
     */

    @Override
    public int getDrawerLayoutID() {
        return R.id.drawer_layout;
    }

    @Override
    public int getNavigationViewID() {
        return R.id.nav_view;
    }

    @Override
    public void setDrawerLayout(DrawerLayout drawer) {

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.latest_news) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new MainFragment()).commit();
        } else if (id == R.id.favorites) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new FavoritesFragment()).commit();
        } else if (id == R.id.downloads) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new ArtistDetailFragment()).commit();
        }
//        else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     *
     * MENU OVERRIDES METHODS
     *
     */



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
