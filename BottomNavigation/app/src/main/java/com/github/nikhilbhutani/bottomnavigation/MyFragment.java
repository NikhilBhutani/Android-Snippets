package com.github.nikhilbhutani.bottomnavigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nikhil Bhutani on 10/22/2016.
 */

public class MyFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_COLOR = "color";

    // TODO: Rename and change types of parameters
    private int color;

    CardView card;

    public MyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SquareFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyFragment newInstance(int param1) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getInt(ARG_COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        card = (CardView) rootView.findViewById(R.id.card);

        card.setCardBackgroundColor(color);

        return rootView;
    }

    public void updateColor(int color) {

        card.setCardBackgroundColor(color);
    }

}
