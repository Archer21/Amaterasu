package com.archer.amaterasu.common;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.archer.amaterasu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alanaliaga on 15/12/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;


//  OVERRIDED LIFECYCLE METHODS

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        // Setup the layout, toolbar and bind all used views

        setContentView(getLayout());
        injectViews();
        setupToolbar();
    }

    //  METHODS THAT THE ACTIVITY CAN USE

    public void setupToolbar () {
        if (toolbar != null) {
            // will be automatically injected with butterknife
            // if a toolbar was defined
            setSupportActionBar(toolbar);
        } else {
            Log.e("BaseActivity", "ERROR IN THIS IMPLEMENTATION");
        }
    }

    public Toolbar getToolbar () {
        return toolbar;
    }


    public void injectViews () {
        ButterKnife.bind(this);
    }


//  ABSTRACT METHODS THAT ALL ACTIVITIES WILL OVERRIDE
    public abstract int getLayout ();
}
























