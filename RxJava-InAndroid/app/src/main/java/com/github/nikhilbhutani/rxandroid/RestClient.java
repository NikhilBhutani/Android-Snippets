package com.github.nikhilbhutani.rxandroid;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil Bhutani on 9/2/2016.
 *
 * This is a mock rest client, it simulates making blocking calls to a REST endpoint.
 *
 */


public class RestClient {


    private Context mContext;

    public RestClient(Context context){

        this.mContext = context;
    }

    public List<String> getFavoriteTvShows() {
        try {
            // "Simulate" the delay of network.
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return createTvShowList();
    }

    private List<String> createTvShowList() {
        List<String> tvShows = new ArrayList<>();
        tvShows.add("Silicon Valley");
        tvShows.add("The Simpsons");
        tvShows.add("Futurama");
        tvShows.add("Rick & Morty");
        tvShows.add("The X-Files");
        tvShows.add("Star Trek: The Next Generation");
        tvShows.add("Archer");
        tvShows.add("30 Rock");
        tvShows.add("Bob's Burgers");
        tvShows.add("Breaking Bad");
        tvShows.add("Parks and Recreation");
        tvShows.add("House of Cards");
        tvShows.add("Game of Thrones");
        tvShows.add("Law And Order");
        return tvShows;
    }

}
