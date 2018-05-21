package com.eways.etutor.Views.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWelcome extends Fragment implements View.OnClickListener {


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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        SignupFragment.btnNext.setOnClickListener(this);
        return inflater.inflate(R.layout.fragment_fragment_welcome, container, false);
    }

    @Override
    public void onClick(View v) {
        // Check if this fragment is the current fragment
        if (getActivity().getSupportFragmentManager().findFragmentById(R.id.content_signup) == this) {
            switch (v.getId()) {
                case R.id.btn_next:
                    // Go to home
                    Toast.makeText(getContext(), "Need home's view", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
