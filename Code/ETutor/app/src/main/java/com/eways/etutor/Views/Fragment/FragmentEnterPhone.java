package com.eways.etutor.Views.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.eways.etutor.Presenter.EnterPhonePresenter;
import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;
//import com.eways.etutor.Utils.Handler.SharedPreferencesHandler;
import com.eways.etutor.Utils.SupportKey;

/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentEnterPhone extends Fragment implements View.OnClickListener {
    public static TextView tvPhoneNumber;

    /** Models */
    private FragmentHandler fragmentHandler;
    private EnterPhonePresenter enterPhonePresenter;

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
        fragmentHandler = new FragmentHandler(getContext(), R.id.content_signup);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_fragment_enter_phone, container, false);
        tvPhoneNumber = root.findViewById(R.id.phone);

        SignupFragment.btnNext.setOnClickListener(this);

        return root;
    }


    @Override
    public void onClick(View v) {
        // Check if this fragment is the current fragment
        if (getActivity().getSupportFragmentManager().findFragmentById(R.id.content_signup) == this) {
            switch (v.getId()) {
                case R.id.btn_next:
                    // Check phone number on server
                    checkPhone();
                    String phoneNumber = "+84" + tvPhoneNumber.getText().toString();
                    if (!phoneNumber.isEmpty())
                        fragmentHandler.changeFragment(FragmentVerify.newInstance(phoneNumber), SupportKey.VERIFY_FRAGMENT_TAG, R.anim.slide_from_left, 0);
                    else {
                        Toast.makeText(getContext(), getString(R.string.msg_missing_info), Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }

    /** Check phone's status on server */
    private void checkPhone() {

    }
}
