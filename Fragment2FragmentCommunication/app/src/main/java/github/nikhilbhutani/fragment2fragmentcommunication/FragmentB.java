package github.nikhilbhutani.fragment2fragmentcommunication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Nikhil Bhutani on 5/30/2016.
 */
public class FragmentB extends Fragment {

TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b,container,false);
          textView = (TextView)view.findViewById(R.id.text);
        return view;

    }


    public void getData(String message)
    {
       textView.setText(message);
    }
}
