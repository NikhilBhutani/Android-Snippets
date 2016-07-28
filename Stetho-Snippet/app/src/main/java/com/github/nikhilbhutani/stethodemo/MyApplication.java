package com.github.nikhilbhutani.stethodemo;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Nikhil Bhutani on 7/28/2016.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();



        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());

    }
}
