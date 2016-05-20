package github.nikhilbhutani.okhttp;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Nikhil Bhutani on 5/20/2016.
 */
public class OkHttpConnection extends AsyncTask<Void, Void, byte[]> {

    private final String IMG_URL ="http://api.androidhive.info/images/glide/small/deadpool.jpg";
    @Override
    protected byte[] doInBackground(Void... voids) {


        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(IMG_URL)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            return response.body().bytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
