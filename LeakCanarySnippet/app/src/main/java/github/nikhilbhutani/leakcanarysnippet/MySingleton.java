package github.nikhilbhutani.leakcanarysnippet;

import android.content.Context;

/**
 * Created by Nikhil Bhutani on 6/21/2016.
 */
public class MySingleton {

    private static MySingleton mySingletoninstance;
    private Context context;


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    private MySingleton()
    {

    }

    public static MySingleton getInstance()
    {
        if(mySingletoninstance==null)
        {
            mySingletoninstance = new MySingleton();
        }
        return mySingletoninstance;
    }

}
