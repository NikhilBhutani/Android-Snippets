package com.github.nikhilbhutani.timberdemo;

import android.util.Log;

import timber.log.Timber;

/**
 * Created by Nikhil Bhutani on 7/15/2016.
 */
public class ReleaseTree extends Timber.Tree {


    @Override
    protected boolean isLoggable(int priority) {
        if(priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO){
            return false;
        }
        else
        {
            // only logs for WARN, ERROR, WTF
            return true;
        }
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {

        //Reporting caught exception to crashlytics or whatever crash libray being used.
        if(priority == Log.ERROR){
            // Crashlytics.log(e);
        }

    }
}
