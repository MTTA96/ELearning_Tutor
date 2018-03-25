package com.eways.etutor.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;
import com.eways.etutor.Utils.Handler.GmailHandler;
import com.google.android.gms.common.SignInButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    /*----- VIEWS ------*/
    SignInButton btnLoginGmail;

    /*---- FRAGMENT HANDLE -----*/
    FragmentHandler fragmentHandler;

    /*---- GMAIL HANDLE -----*/
    GmailHandler gmailHandler;
    public static final String KEY_PRE_LOGIN = "id_login";

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        Declare(root);
        Handle();

        return root;
    }

    public static LoginFragment newInstance() {

        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    //Handle view
    public void Handle() {

        //Set click button
        btnLoginGmail.setOnClickListener(this);
    }

    //Declare views
    public void Declare(View root) {

        //Setup button login Gmail
        btnLoginGmail = root.findViewById(R.id.sign_in_button);
        btnLoginGmail.setSize(SignInButton.SIZE_STANDARD);

        //Setup Fragment Handle
        fragmentHandler = new FragmentHandler(getActivity(), R.id.main_activity);

        //Setup Gmail handle
        gmailHandler = new GmailHandler(getActivity(), this);
        gmailHandler.ConfigGoogleLogin();

    }

    @Override
    public void onStart() {
        super.onStart();

        gmailHandler.onStart();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        gmailHandler.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in_button:

                gmailHandler.signIn();

                break;
        }
    }
}