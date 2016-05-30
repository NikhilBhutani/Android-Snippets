package github.nikhilbhutani.fragment2fragmentcommunication;

import android.app.Activity;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Nikhil Bhutani on 5/30/2016.
 */
public class FragmentA extends Fragment {

    Mylistener mylistener;
    EditText editText;
    Button button;



    //container Activity must implement this interface
    public interface Mylistener
    {

        public void sendData(String message);

    }

    //This makes sure that the container activity has implemented
    // the interface. If not, it throws an exception
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            mylistener = (Mylistener)activity;
        }
        catch (ClassCastException e)
        {
            e.printStackTrace();
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a,container,false);
        editText = (EditText)view.findViewById(R.id.edittext);
        button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = editText.getText().toString();

                //SEND THE EVENT TO THE HOST ACTIVITY
                mylistener.sendData(msg);

            }
        });
        return view;
    }




}
