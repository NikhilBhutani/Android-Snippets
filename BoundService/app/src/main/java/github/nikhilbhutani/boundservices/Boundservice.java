package github.nikhilbhutani.boundservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

/**
 * Created by Nikhil Bhutani on 5/16/2016.
 */
public class Boundservice extends Service {

    private static  String LOG_TAG = "BoundService ";
    private IBinder iBinder = new LocalBinder();

    // Random number generator
    private final Random mGenerator = new Random();
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(LOG_TAG, "in onBind");
        return iBinder;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        Log.v(LOG_TAG, "in onCreate");

    }


    @Override
    public void onRebind(Intent intent) {
        Log.v(LOG_TAG, "in onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(LOG_TAG, "in onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(LOG_TAG, "in onDestroy");

    }

//The LocalBinder provides the getService() method for clients to retrieve the current instance of BoundService class
    public class LocalBinder extends Binder {
        Boundservice getService() {
            // Return this instance of BoundService so clients can call public methods
            return Boundservice.this;
        }
    }
    /** method for clients */
    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }

}
