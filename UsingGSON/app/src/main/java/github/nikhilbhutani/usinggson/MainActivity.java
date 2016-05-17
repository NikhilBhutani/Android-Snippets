package github.nikhilbhutani.usinggson;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

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

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "JSONStreamReader";

    private static final String url = "http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    ListView mylistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylistview = (ListView)findViewById(R.id.listView);
        new MyAsyncTask().execute(url);

    }


   private class MyAsyncTask extends AsyncTask<String,String,List<MyPOJO>>
    {
        StringBuffer stringBuffer = null;


        @Override
        protected List<MyPOJO> doInBackground(String... strings) {

            HttpURLConnection  httpURLConnection = null;

            //For efficient reading of characters, arrays, String we use BufferedReader
            BufferedReader bufferedReader = null;

            try {
                Log.i(LOG_TAG," Opening connection");
                URL myurl = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection)myurl.openConnection();
                httpURLConnection.connect();

                InputStream inputStream = httpURLConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                List<MyPOJO> list = new ArrayList<>();
                stringBuffer = new StringBuffer();
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    stringBuffer.append(line);
                }
                String finaljson= stringBuffer.toString();

                System.out.println("Here is the finaljson "+finaljson);

                Gson gson = new Gson();
                JSONObject jsonObject = new JSONObject(finaljson);
                JSONArray jsonArray = jsonObject.getJSONArray("worldpopulation");

                for(int i=0;i<jsonArray.length();i++)
                {

                    JSONObject finalobject = jsonArray.getJSONObject(i);

                    MyPOJO myPOJO = gson.fromJson(finalobject.toString(),MyPOJO.class);

                    list.add(myPOJO);
                }

                if(list!=null)
                {
                 Log.i(LOG_TAG," List is not null hence returning");
                    return list;
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }finally {
                if(httpURLConnection!=null) {
                    httpURLConnection.disconnect();
                }
                if(bufferedReader!=null)
                {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            return null;
        }

        @Override
        protected void onPostExecute(List<MyPOJO> s) {



            Myclassadapter myclassadapter = new Myclassadapter(getApplicationContext(),R.layout.row,s);
            mylistview.setAdapter(myclassadapter);

        }
    }

    public class Myclassadapter extends ArrayAdapter
    {

        private List<MyPOJO> modelclass;
        private int resource;
        private LayoutInflater inflater;

        public Myclassadapter(Context context, int resource, List<MyPOJO> objects) {
            super(context, resource, objects);
            modelclass = objects;
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
                holder.textView_country = (TextView)convertView.findViewById(R.id.text);
                holder.textView2_population = (TextView)convertView.findViewById(R.id.text2);

                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.textView_country.setText(modelclass.get(position).getCountry());
            holder.textView2_population.setText(modelclass.get(position).getPopulation());



            return convertView;
        }

        // findViewById is expensive method for memory, there using the below viewHolder pattern
        class ViewHolder {
            private TextView textView_country;
            private TextView textView2_population;

        }
    }


}
