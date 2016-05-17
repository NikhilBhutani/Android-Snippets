package com.usingrestapi.usinglibraries;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private static final String url = "http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    ListView mylistview;
  //  TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Create default options which will be used for every
//  displayImage(...) call if no options will be passed to this method
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
        .cacheInMemory(true).cacheOnDisk(true).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
        .defaultDisplayImageOptions(defaultOptions)
        .build();
        ImageLoader.getInstance().init(config);


        mylistview = (ListView) findViewById(R.id.listView);
       //  tv = (TextView) findViewById(R.id.textView);

        NiksAysnc ourSyncTask = new NiksAysnc();
        ourSyncTask.execute(url);



    }
/*
    @Override
    public void myresult(String output) {
        textView.setText(output);
    }
    */

    public class NiksAysnc extends AsyncTask<String,String,List<MyModel>> {

        StringBuffer mystringbuffer = null;

        public MyAsyncResponse myAsyncResponse = null;



        @Override
        protected List<MyModel> doInBackground(String... strings) {
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
                String finalJson = mystringbuffer.toString();


                JSONObject jsonObject = new JSONObject(finalJson);
                JSONArray jsonArray = jsonObject.getJSONArray("worldpopulation");



                //String myobject =null;
              List<MyModel> ourlist =  new ArrayList<>();

                Gson gson = new Gson();
                for (int i =0; i<jsonArray.length(); i++)
                {
                    JSONObject finalobject = jsonArray.getJSONObject(i);
                    //Using JSON here, yay!
                    MyModel myModel = gson.fromJson(finalobject.toString(),MyModel.class);


                    //     COMMENTING THIS TO INTEGRATE GSON LIB
                    // MyModel myModel = new MyModel();
                    // myobject = finalobject.getString("country");



                    //   myModel.setCountry(finalobject.getString("country"));
             //       myModel.setRank(finalobject.getInt("rank"));
              //      myModel.setPopulation(finalobject.getString("population"));

                //    myModel.setFlag(finalobject.getString("flag"));
                    ourlist.add(myModel);
                }

                if(ourlist!=null) {
                            return ourlist;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
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
        protected void onPostExecute(List<MyModel> s) {



             Myclassadapter myclassadapter = new Myclassadapter(getApplicationContext(),R.layout.row,s);
             mylistview.setAdapter(myclassadapter);

        }
    }


    public class Myclassadapter extends ArrayAdapter
    {
        private List<MyModel> ourmodel;
        private int resource;
        private LayoutInflater inflater;
        public Myclassadapter(Context context, int resource, List<MyModel> objects) {
            super(context, resource, objects);
            ourmodel = objects;
            inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            this.resource = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if(convertView==null)
            {
                holder = new ViewHolder();
                convertView =inflater.inflate(resource,null);
                holder.textView_country = (TextView)convertView.findViewById(R.id.textView1);
                holder.textView2_population = (TextView)convertView.findViewById(R.id.textView2);
                holder.myflag = (ImageView)convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.textView_country.setText(ourmodel.get(position).getCountry());
            holder.textView2_population.setText(ourmodel.get(position).getPopulation());

            //Then later, when you want to display image
            ImageLoader.getInstance().displayImage(ourmodel.get(position).getFlag(), holder.myflag);

            return convertView;
        }

        // findViewById is expensive method for memory, there using the below viewHolder pattern
        class ViewHolder {
            private TextView textView_country;
            private TextView textView2_population;
            private ImageView myflag;
        }
    }

}
