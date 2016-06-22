package github.nikhilbhutani.usingdagger2;

/**
 * Created by Nikhil Bhutani on 6/22/2016.
 */
public class MyHelloServiceManager implements MyHelloService{


    @Override
    public String greeting(String name) {
        return "Hello " + name;
    }
}
