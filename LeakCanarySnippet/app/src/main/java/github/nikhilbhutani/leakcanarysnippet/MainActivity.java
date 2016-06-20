package github.nikhilbhutani.leakcanarysnippet;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.leakcanary.RefWatcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




                new MyAsyncTask().execute(this);


    }





    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("onDestroy() called");

        RefWatcher refWatcher = MyApplication.getRefWatcher(this);
        refWatcher.watch(this);

    }

    public class MyAsyncTask extends AsyncTask<Object, String, String> {
        private Context context;

        @Override
        protected String doInBackground(Object... params) {
            context = (Context) params[0];

            // Leak Invoked
            MySingleton.getInstance().setContext(context);

            // Simulating a long running task
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Intent intent = new Intent(context, SecondActivity.class);
            startActivity(intent);
        }
    }

}
