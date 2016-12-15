package com.archer.amaterasu.common;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by alanaliaga on 15/12/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;



//  OVERRIDED LIFECYCLE METHODS

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        // Setup the layout, toolbar and bind all used views

        setContentView(getLayout());
        setupToolbar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Clear the references to the used views
    }


    //  METHODS THAT THE ACTIVITY CAN USE

    public void setupToolbar () {
        if (toolbar != null) {
            // will be automatically injected with butterknife
            // if a toolbar was defined
            setSupportActionBar(toolbar);
        }
    }

    public Toolbar getToolbar () {
        return toolbar;
    }



//  ABSTRACT METHODS THAT ALL ACTIVITIES WILL OVERRIDE
    public abstract int getLayout ();
}
























