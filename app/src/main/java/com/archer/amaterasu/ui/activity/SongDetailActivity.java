package com.archer.amaterasu.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseActivity;
import com.archer.amaterasu.ui.fragment.SongDetailFragment;

public class SongDetailActivity extends BaseActivity {

    private FragmentManager     fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFragmentConfiguration();

    }

    protected void setupFragmentConfiguration(){
        fragmentManager     = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new SongDetailFragment()).commit();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_song_detail;
    }
}












