package github.nikhilbhutani.leakcanarysnippet;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Nikhil Bhutani on 6/21/2016.
 */
public class MyApplication extends Application {

    RefWatcher refWatcher;


    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {

        System.out.println("getRefwatcher Called");

        MyApplication myApplication = (MyApplication) context.getApplicationContext();


        return myApplication.refWatcher;
    }


}
