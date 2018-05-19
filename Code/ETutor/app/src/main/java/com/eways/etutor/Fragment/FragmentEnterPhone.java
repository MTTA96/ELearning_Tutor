package com.eways.etutor.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;
//import com.eways.etutor.Utils.Handler.SharedPreferencesHandler;
import com.eways.etutor.Utils.SupportKey;

/**
 * A simple {@link Fragment} subclass.
 */
//<<<<<<< HEAD
public class FragmentEnterPhone extends Fragment {

    // Data variable
//    private SharedPreferencesHandler preferencesHandler;
//=======
//public class FragmentEnterPhone extends Fragment implements View.OnClickListener {
//    public static TextView tvPhoneNumber;
//
//    /** Models */
//    private SharedPreferencesHandler preferencesHandler;
//    private FragmentHandler fragmentHandler;
//>>>>>>> origin/master

    public FragmentEnterPhone() {
        // Required empty public constructor
    }

    public static FragmentEnterPhone newInstance() {

        Bundle args = new Bundle();

        FragmentEnterPhone fragment = new FragmentEnterPhone();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//<<<<<<< HEAD
//        preferencesHandler = new SharedPreferencesHandler(getContext(), SupportKey.SHARED_PREF_FILE_NAME);
//=======
//        // Declare vars
//        preferencesHandler = new SharedPreferencesHandler(getContext(), SupportKey.SHARED_PREF_FILE_NAME);
//        fragmentHandler = new FragmentHandler(getContext(), R.id.childSignUpContentView);
//>>>>>>> origin/master
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_fragment_enter_phone, container, false);
//<<<<<<< HEAD
//        tvPhoneNumber = root.findViewById(R.id.phone);
//
//        if (!tvPhoneNumber.getText().toString().isEmpty()) {
//            preferencesHandler.setPhoneNumber(tvPhoneNumber.getText().toString());
//        }
//=======
//        tvPhoneNumber = root.findViewById(R.id.phone);
//
//        SignupFragment.btnBack.setOnClickListener(this);
//        SignupFragment.btnNext.setOnClickListener(this);
//
//        if (!tvPhoneNumber.getText().toString().isEmpty()) {
//            preferencesHandler.setPhoneNumber(tvPhoneNumber.getText().toString());
//        }
//>>>>>>> origin/master
        return root;
    }


//    @Override
//    public void onClick(View v) {
//        // Check if this fragment is the current fragment
//        if (getActivity().getSupportFragmentManager().findFragmentById(R.id.childSignUpContentView) == this) {
//            switch (v.getId()) {
//                case R.id.btn_back:
//                    getActivity().getSupportFragmentManager().popBackStack();
//                    break;
//                case R.id.btn_next:
//                    String phoneNumber = tvPhoneNumber.getText().toString();
//                    if (!phoneNumber.isEmpty())
//                        fragmentHandler.changeFragment(FragmentVerify.newInstance(phoneNumber), SupportKey.VERIFY_FRAGMENT_TAG, R.anim.slide_from_left, 0);
//                    else {
//                        Toast.makeText(getContext(), getString(R.string.missing_info_msg), Toast.LENGTH_SHORT).show();
//                    }
//                    break;
//            }
//        }
//    }
}
