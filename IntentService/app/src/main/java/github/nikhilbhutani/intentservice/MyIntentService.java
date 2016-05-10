package github.nikhilbhutani.intentservice;

import android.app.IntentService;
import android.content.Intent;
/**  Created by Nikhil Bhutani on 5/11/2016.
 *
 * Intentservice
 * 1. Creates a default worker thread that executes all intents delivered to onStartCommand()
 * 2. Creates a work queue that passes one intent at a time to your onHandleIntent() implementaion.
 * 3. Stops the services after the requests have been handled, by calling stopSelf()
 * 4. Provide default implementation of onBind() that returns null
 * 5. Provide a default implementaion of onStartCommand() that sends the intent to the work queue and then to
 * your onHandleIntent implementation.
 */


public class MyIntentService extends IntentService {

    public  MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            System.out.println(intent.getStringExtra("value"));
        }
     }

}