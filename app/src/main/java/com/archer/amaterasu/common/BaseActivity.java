package com.archer.amaterasu.common;

import android.os.Bundle;
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

//  OVERRIDED LIFECYCLE METHODS

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Setup the layout, toolbar and bind all used views

        setContentView(getLayout());
        injectViews();
    }

    //  METHODS THAT THE ACTIVITY CAN USE

    public void setupToolbar (Toolbar toolbar) {
        if (toolbar != null) {
            // will be automatically injected with butterknife
            // if a toolbar was defined
            setSupportActionBar(toolbar);
        } else {
            Log.e("BaseActivity", "ERROR IN THIS IMPLEMENTATION");
        }
    }

    public abstract Toolbar getToolbar ();


    public void injectViews () {
        ButterKnife.bind(this);
    }


//  ABSTRACT METHODS THAT ALL ACTIVITIES WILL OVERRIDE
    public abstract int getLayout ();
}
























