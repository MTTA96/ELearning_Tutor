package com.eways.etutor.Fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Model.User;
import com.eways.etutor.Presenter.SignUpInfoPresenter;
import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;
import com.eways.etutor.Utils.SupportKey;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUserInfo extends Fragment implements View.OnClickListener, DataCallBack {

    /**
     * VIEWS
     */
    EditText etName, etPassword;
    ImageView clear_name, clear_phone;

    /**
     * Models
     */
    private Activity activity;
    private FragmentHandler fragmentHandler;
    private SignUpInfoPresenter signUpInfoPresenter;
    private PhoneAuthCredential credential;
    private User user;
    private String name;
    private String password;

    // Params
    private static final String credentialParam = "credential";

    public static FragmentUserInfo newInstance() {

        Bundle args = new Bundle();
//        args.putSerializable(credentialParam, (Serializable) credential);
        FragmentUserInfo fragment = new FragmentUserInfo();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        fragmentHandler = new FragmentHandler(getContext(), R.id.childSignUpContentView);
        signUpInfoPresenter = new SignUpInfoPresenter(this);
//        if (getArguments() != null) {
//            credential = (PhoneAuthCredential) getArguments().getSerializable(credentialParam);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_user_info, container, false);

        // Configure view
        declare_views(root);
        handle_views();

        return root;
    }

    public void declare_views(View root) {
        etName = root.findViewById(R.id.name);
        etPassword = root.findViewById(R.id.password);

        clear_name = root.findViewById(R.id.clear_name_text);
        clear_phone = root.findViewById(R.id.clear_phone_text);


    }

    public void handle_views() {
        setUpEditText();

        clear_name.setOnClickListener(this);
        clear_phone.setOnClickListener(this);
        SignupFragment.btnNext.setOnClickListener(this);
        SignupFragment.btnBack.setOnClickListener(this);
    }

    public void setUpEditText() {
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etName.getText().toString().compareTo("") != 0) {
                    clear_name.setVisibility(View.VISIBLE);
                } else {
                    clear_name.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etPassword.getText().toString().compareTo("") != 0) {
                    clear_phone.setVisibility(View.VISIBLE);
                } else {
                    clear_phone.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * MARK: - EVENTS
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.clear_name_text:
                etName.setText("");
                break;

            case R.id.clear_phone_text:
                etPassword.setText("");
                break;

            case R.id.btn_next:
                if (getActivity().getSupportFragmentManager().findFragmentById(R.id.childSignUpContentView) == this) {
                    user = prepareData();
                    if (user != null)
                        signInWithPhoneAuthCredential(FragmentVerify.credential);
                }
                break;

            case R.id.btn_back:
                if (getActivity().getSupportFragmentManager().findFragmentById(R.id.childSignUpContentView) == this) {
                    fragmentHandler.changeFragment(FragmentEnterPhone.newInstance(), SupportKey.ENTER_PHONE_FRAGMENT_TAG, R.anim.slide_from_left, 0);
                }
                break;
        }
    }


    /** MARK: - METHODS */

    /**
     * Sign in firebase when verify success and user info has filled
     */
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");

                            FirebaseUser fbUser = task.getResult().getUser();
                            user.setUid(fbUser.getUid());
                            signUpInfoPresenter.signUp(user);
                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                        }
                    }
                });
    }

    /** Prepare data before sign up */
    private User prepareData() {
        User tempUser = new User();
        name = etName.getText().toString();
        password = etPassword.getText().toString();

        if (!name.isEmpty() && !password.isEmpty()) {
            tempUser.setFirstName(name);
            tempUser.setPassword(password);
            return tempUser;
        }
        return null;
    }

    @Override
    public void dataCallBack(String result, @Nullable Bundle bundle) {
        if (result.compareTo("Success") == 0) {
            fragmentHandler.changeFragment(FragmentUserInfo.newInstance(), SupportKey.ENTER_PHONE_FRAGMENT_TAG, R.anim.slide_from_left, 0);
            return;
        }

        Toast.makeText(getContext(), getString(R.string.unknow_error_msg), Toast.LENGTH_SHORT).show();
    }
}
