package github.nikhilbhutani.usingactiveandroid;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Nikhil Bhutani on 6/23/2016.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
