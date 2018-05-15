package com.eways.etutor.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.eways.etutor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUserInfo extends Fragment implements View.OnClickListener{

    /* VIEWS */
    EditText name,password;
    ImageView clear_name, clear_phone;

    public FragmentUserInfo() {
        // Required empty public constructor
    }

    public static FragmentUserInfo newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentUserInfo fragment = new FragmentUserInfo();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_user_info, container, false);

        declare_views(root);
        handle_views();

        return root;
    }

    public void declare_views(View root){
        name = root.findViewById(R.id.name);
        password = root.findViewById(R.id.password);


        clear_phone = root.findViewById(R.id.clear_phone_text);

    }

    public void handle_views(){
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.clear_phone_text:
                password.setText("");

                break;


        }
    }
}
