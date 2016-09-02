package com.github.nikhilbhutani.rxandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.concurrent.Callable;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RestClient restClient;
    public ListView listView;
    private Subscription mTvShowSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restClient = new RestClient(this);
        listView = (ListView) findViewById(R.id.listView);
        createObservables();

    }


    /*Here Observable.fromCallable method gives us two important things :
    * 1. The code for creating the emitted value is not run until someone
    * subscribes to the observer.
    *
    * 2. Creation of the code can be run on different thread.
    */

    private void createObservables() {

        Observable<List<String>> tvShowObservable = Observable.fromCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return restClient.getFavoriteTvShows();
            }
        });

        mTvShowSubscription = tvShowObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Observer<List<String>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(List<String> tvShows) {


                                displayTvShows(tvShows);
                            }


                        });

    }

    private void displayTvShows(List<String> tvShows) {

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, tvShows);
        listView.setAdapter(arrayAdapter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!mTvShowSubscription.isUnsubscribed() && mTvShowSubscription != null) {
            mTvShowSubscription.unsubscribe();
        }


    }
}
