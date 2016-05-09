package github.nikhilbhutani.fragmentslifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Nikhil Bhutani on 5/10/2016.
 */
public class NiksFragment extends android.support.v4.app.Fragment implements View.OnClickListener {


    //when the fragment attaches to its host activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("invoked ", "onAttach in Fragment" );

    }

   // when a new fragment instance initializes, which always happens after it attaches to the host
   // — fragments are a bit like a virus in that way
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("invoked ", "onCreate in Fragment" );
    }

//when a fragment creates its portion of the view hierarchy, which is added to its activity’s view hierarchy
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("invoked ", "onCreateView in Fragment" );
        View view = inflater.inflate(R.layout.niks_fragment,
                container, false);

        Button nextButton = (Button) view.findViewById(R.id.button_first);
        nextButton.setOnClickListener(this);

        return view;
    }

    //when the fragment’s activity has finished its own onCreate event
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i("invoked ", "onActivityCreated in Fragment" );
        super.onActivityCreated(savedInstanceState);
    }

    //when the fragment is visible; a fragment cannot start until its starts and often
    // starts immediately after the activity does
    @Override
    public void onStart() {
        super.onStart();
        Log.i("invoked ", "onStart in Fragment" );
    }

    //when the fragment is visible and interactable;
    // a fragment cannot resume until its activity resumes and often does so in quick succession after the activity
    @Override
    public void onResume() {
        Log.i("invoked ", "onStart in Fragment" );
        super.onResume();
    }

    //when the fragment is no longer interactable; it occurs when either
    // the fragment is about to be removed or replaced, or the host activity takes a pause
    @Override
    public void onPause() {
        Log.i("invoked ", "onPause in Fragment" );
        super.onPause();
    }

    //when the fragment is no longer visible;
    // it occurs either after the fragment is about to be removed or replaced or when the host activity stops
    @Override
    public void onStop() {
        Log.i("invoked ", "onStop in Fragment" );
        super.onStop();
    }

    //when the view and related resources created in onCreateView is removed from the activity’s view hierarchy and destroyed
    @Override
    public void onDestroyView() {
        Log.i("invoked ", "onDestroyview in Fragment" );
        super.onDestroyView();
    }

    //when the fragment does its final clean up
    @Override
    public void onDestroy() {
        Log.i("invoked ", "onDestroy in Fragment" );
        super.onDestroy();
    }

    //when the fragment is detached from its host activity
    @Override
    public void onDetach() {

        Log.i("invoked ", "onDetach in Fragment" );
        super.onDetach();
    }

    @Override
    public void onClick(View view) {

    }
}
