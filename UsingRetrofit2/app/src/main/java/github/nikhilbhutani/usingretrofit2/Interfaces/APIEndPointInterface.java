package github.nikhilbhutani.usingretrofit2.Interfaces;

import github.nikhilbhutani.usingretrofit2.Model.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Nikhil Bhutani on 6/7/2016.
 *
 * Retrofit works with interface and multiple annotations
 * If your method type is get, then you have it as GET then you define the endpoint and then the query parameters
 * Then Callback for the parse response
 */




public interface APIEndPointInterface {

    @GET("people")
    Call<ApiResponse> getPeople();


    //If there are some dynamic query elements then you pass it as parameters within the
    //query annotation eg : Call<VideoData> getPlaylistItems(@Query("playlistid" String playlistid)) This is passed as a parameter
    // if you have specific API key, that is also needed to passed as a parameter along with playlistid
}
