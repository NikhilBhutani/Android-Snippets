package github.nikhilbhutani.usingdagger2;

import android.app.Application;

/**
 * Created by Nikhil Bhutani on 6/22/2016.
 */
public class MyApplication extends Application {

    private static MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeDepInj();


    }

    private void initializeDepInj() {


        mainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build();


    }

    public static MainComponent getComponent()
    {
        return mainComponent;
    }

}
