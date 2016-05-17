package com.usingrestapi.usinglibraries;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nikhil Bhutani on 4/15/2016.
 */
public class NiksAysnc extends AsyncTask<String,String,String> {

    StringBuffer mystringbuffer = null;

    public MyAsyncResponse myAsyncResponse = null;

    private static final String url = "http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader myreader = null;  // used for efficient reading of characters, arrays, string

        try {
            URL myurl = new URL(strings[0]);
            connection = (HttpURLConnection)myurl.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            myreader = new BufferedReader(new InputStreamReader(stream));

            mystringbuffer = new StringBuffer();
            String line = "";
            while((line=myreader.readLine())!=null)
            {
                mystringbuffer.append(line);
            }
            return mystringbuffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(connection!=null)
            {
                connection.disconnect();
            }
            if(myreader!=null)
            {
                try {
                    myreader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return  null;

    }

    @Override
    protected void onPostExecute(String s) {
        if(s!=null) {
            myAsyncResponse.myresult(s);
        }
    }
}
