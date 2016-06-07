package github.nikhilbhutani.usingretrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import github.nikhilbhutani.usingretrofit2.Adapters.ListAdapter;
import github.nikhilbhutani.usingretrofit2.Interfaces.APIEndPointInterface;
import github.nikhilbhutani.usingretrofit2.Model.ApiResponse;
import github.nikhilbhutani.usingretrofit2.Model.People;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

String baseUrl = "http://swapi.co/api/";
    private ApiResponse apiResponse;
    APIEndPointInterface apiEndPointInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_peoples);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))  //Json received will be deserialized using GsonConverter
                .build();

        apiEndPointInterface = retrofit.create(APIEndPointInterface.class);

        Call<ApiResponse> call =  apiEndPointInterface.getPeople();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                if (response.isSuccessful()) {
                    List<People> peoples = response.body().getPeopleList();
                    recyclerView.setAdapter(new ListAdapter(peoples, R.layout.list_item_people));
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

                System.out.println("CallBack Failed");
            }


    });
   }

}