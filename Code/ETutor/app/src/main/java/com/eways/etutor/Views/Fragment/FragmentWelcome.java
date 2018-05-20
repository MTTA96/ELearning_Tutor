package com.eways.etutor.Views.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eways.etutor.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWelcome extends Fragment {


    public FragmentWelcome() {
        // Required empty public constructor
    }

    public static FragmentWelcome newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentWelcome fragment = new FragmentWelcome();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_welcome, container, false);
    }

}
