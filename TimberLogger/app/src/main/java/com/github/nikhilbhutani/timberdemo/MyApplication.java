package com.github.nikhilbhutani.timberdemo;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Nikhil Bhutani on 7/15/2016.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        if(BuildConfig.DEBUG) {

            Timber.plant(new Timber.DebugTree(){

                //Add the line number to the log
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return super.createStackElementTag(element)+ " : " +element.getLineNumber();
                }
            });
        }
        else{

            // This is for Release mode
            //Release tree extending the timber.tree abstract class

            Timber.plant(new ReleaseTree());

            //We'll use the release tree for any crashlytics ops
            //Crashlytics.start();  //Init crash reporting lib
        }

    }
}
