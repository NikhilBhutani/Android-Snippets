package github.nikhilbhutani.usingdagger2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Nikhil Bhutani on 6/22/2016.
 */

@Module
public class MainModule {

    MyApplication application;

    public MainModule(MyApplication myApplication)
    {
        this.application = myApplication;
    }

    @Singleton
    @Provides
    MyHelloService providesMyHelloService()
    {
        return new MyHelloServiceManager();
    }




}
