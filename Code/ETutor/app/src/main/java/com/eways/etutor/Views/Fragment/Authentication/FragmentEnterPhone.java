package com.eways.etutor.Views.Fragment.Authentication;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Model.Account.User;
import com.eways.etutor.Presenter.Authentication.EnterPhonePresenter;
import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;
//import com.eways.etutor.Utils.Handler.SharedPreferencesHandler;
import com.eways.etutor.Utils.SupportKeys;
import com.eways.etutor.Views.Fragment.Account.FragmentUpdateInfo;

/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentEnterPhone extends Fragment implements View.OnClickListener, DataCallBack {
    public static TextView tvPhoneNumber;

    /** Models */
    private FragmentHandler fragmentHandler;
    private EnterPhonePresenter enterPhonePresenter;
    private String phoneNumber;

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
        enterPhonePresenter = new EnterPhonePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_enter_phone, container, false);
        tvPhoneNumber = root.findViewById(R.id.phone);

        // Events
        SignupFragment.btnNext.setOnClickListener(this);

        return root;
    }

    /** Check phone's status */
    private void checkPhone(String phoneNumber) {
        // handle errors
        if (phoneNumber.isEmpty() || phoneNumber.length() < 9 || phoneNumber.length() > 10) {
            Toast.makeText(getContext(), getString(R.string.msg_phone_number_incorrect), Toast.LENGTH_SHORT).show();
            return;
        }

        // Check phone number in database
        this.phoneNumber = "+84" + tvPhoneNumber.getText().toString();
        enterPhonePresenter.checkPhoneStatus(this.phoneNumber);

        return;
    }

    /** ----- EVENTS ----- */

    @Override
    public void onClick(View v) {
        // Check if this fragment is the current fragment
        Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.content_signup);
        if (currentFragment != null && currentFragment == this) {
            switch (v.getId()) {
                case R.id.btn_next:
                    // Check phone number
                    checkPhone(tvPhoneNumber.getText().toString());
                    break;
            }
        }
    }


    /** ----- Handle results from presenter ----- */

    @Override
    public void dataCallBack(int resultCode, @Nullable Bundle bundle) {

        // handle error
        if (resultCode == SupportKeys.FAILED_CODE) {
            Toast.makeText(getContext(), R.string.msg_unknow_error, Toast.LENGTH_SHORT).show();
            return;
        }

        // handle result
        int status = bundle.getInt(null);

        switch (status) {

            // Available to use

            case 0:
                fragmentHandler.changeFragment(FragmentVerify.newInstance(phoneNumber), SupportKeys.VERIFY_FRAGMENT_TAG, R.anim.slide_from_left, 0);
                break;

            // User existed

            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setMessage("Tài khoản của bạn đã là học viên, bấm đăng ký để trở thành gia sư")
                        .setTitle(R.string.msg_existing_user);

                builder.setPositiveButton("Đăng ký", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        User user = new User();
                        user.setPhone(tvPhoneNumber.getText().toString());
                        fragmentHandler.changeFragment(FragmentUpdateInfo.newInstance(user), null, R.anim.slide_from_left, 0);
                    }
                });
                builder.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;

            default:
                break;

        }

    }

}

