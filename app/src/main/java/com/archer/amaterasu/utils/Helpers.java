package com.archer.amaterasu.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by archer on 22-12-16.
 */

public class Helpers {


    public static void setupFragment (FragmentManager fm, Fragment fragment, int resourceContainer) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(resourceContainer, fragment).commit();
    }

}























