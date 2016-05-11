package com.archer.amaterasu;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class Global extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
