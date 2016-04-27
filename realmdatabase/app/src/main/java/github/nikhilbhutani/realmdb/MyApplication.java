package github.nikhilbhutani.realmdb;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Nikhil Bhutani on 4/27/2016.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();


        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                                                     .name("my.realm").build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
