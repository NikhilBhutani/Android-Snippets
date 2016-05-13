package github.nikhilbhutani.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Nikhil Bhutani on 5/13/2016.
 */
public class SecondPage extends Fragment{
    private String pagetitle;
    private int pagenum;

    /*
       1. Using newInstance, we will have the single place, where all the arguments used by the fragment could be bundled up
       and we don't have to write the code everytime we instatiate a fragment, hence using static newInstance() to instantiate a
       fragment is a good practice.

       2. The way to pass stuff to your fragment so that they are available after the fragment is recreated by android is to
       pass the bundle to the setArguments method.
     */
    public static SecondPage newInstance(String page_title, int page_num)
    {
        SecondPage secondPage = new SecondPage();
        Bundle args = new Bundle();
        args.putString("mypagetitle",page_title);
        args.putInt("mypagenum",page_num);

        secondPage.setArguments(args);
        return secondPage;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pagetitle = getArguments().getString("mypagetitle");
        pagenum = getArguments().getInt("mypagenum", 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        //Inflating the layout for this fragemnt
        View view = inflater.inflate(R.layout.layout_secondpage,container,false);
        TextView textView = (TextView)view.findViewById(R.id.textview2);
        textView.setText("Title is "+pagetitle+" and the number is "+pagenum);
        return view;
    }}
