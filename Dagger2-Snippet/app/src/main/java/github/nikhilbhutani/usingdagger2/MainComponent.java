package github.nikhilbhutani.usingdagger2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Nikhil Bhutani on 6/22/2016.
 */


@Component(modules = {MainModule.class})
@Singleton
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
