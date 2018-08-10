package com.eways.etutor.Views.Fragment.Account;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eways.etutor.Adapter.ImageChooseAdapter;
import com.eways.etutor.Interfaces.DataCallback.User.UpdateUserInfoCallBack;
import com.eways.etutor.Model.Account.User;
import com.eways.etutor.Model.ImageSelect;
import com.eways.etutor.Presenter.Authentication.UserPresenter;
import com.eways.etutor.R;
import com.eways.etutor.Utils.DialogPlusHandler;
import com.eways.etutor.Utils.FileUtils;
import com.eways.etutor.Utils.Handler.FragmentHandler;
import com.eways.etutor.Utils.Handler.ImageHandler;
import com.eways.etutor.Utils.SupportKeys;
import com.eways.etutor.Utils.params.GlobalParams;
import com.eways.etutor.Views.Fragment.Authentication.FragmentWelcome;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUpdateInfo extends Fragment implements View.OnClickListener, UpdateUserInfoCallBack {

    /** ----- VIEWS ----- */

    ImageView ivAvarta, ivBack;
    EditText etLastName, etFirstName, etSkype, etCmnd, etBirthDay, etEmail, etPhone, etAddress, etCerti, etJob;
    TextView tvBack;

    /** ----- PROPS ----- */

    private UserPresenter userPresenter;
    private FragmentHandler fragmentHandler;
    private ImageHandler imageHandler;
    private DialogPlusHandler dialogPlusHandler;
    private ImageChooseAdapter imageChooseAdapter;
    private User user;
    private ArrayList<ImageSelect> imageSelects;
    private Uri imgUri;

    private static String param = "user";

    public FragmentUpdateInfo() {
        // Required empty public constructor
    }

    public static FragmentUpdateInfo newInstance(User user) {

        Bundle args = new Bundle();
        args.putSerializable(param, (Serializable) user);

        FragmentUpdateInfo fragment = new FragmentUpdateInfo();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentHandler = new FragmentHandler(getContext(), R.id.content_signup);

        if (getArguments() != null) {
            this.user = (User) getArguments().getSerializable(param);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_update_info, container, false);
        declare_views(root);
        handle_views();
        return root;
    }

    public void declare_views(View root) {

        ivAvarta = root.findViewById(R.id.avarta);
        etFirstName = root.findViewById(R.id.et_first_name);
        etLastName = root.findViewById(R.id.et_last_name);
        etSkype = root.findViewById(R.id.skype_id);
        etCmnd = root.findViewById(R.id.cmnd);
        etBirthDay = root.findViewById(R.id.date_picker);
        etEmail = root.findViewById(R.id.et_email);
        etPhone = root.findViewById(R.id.et_phone);
        etAddress = root.findViewById(R.id.et_address);
        etJob = root.findViewById(R.id.et_job);
        ivBack = root.findViewById(R.id.iv_back);

    }

    public void handle_views() {
        imageHandler = new ImageHandler(getActivity());
        SetUpDialog();
        ivAvarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPlusHandler.ShowDiglogPlus();
            }
        });

        etBirthDay.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    public void SetUpDialog() {

        imageSelects = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(FileUtils.loadJSONFromAsset(getActivity(), "image_choose"));
            for (int i = 0; i < jsonArray.length(); i++) {
                imageSelects.add(GlobalParams.getInstance().getGSon().fromJson(jsonArray.get(i).toString(), ImageSelect.class));
            }
            imageChooseAdapter = new ImageChooseAdapter(getActivity(), R.layout.item_image_select, imageSelects);
            dialogPlusHandler = new DialogPlusHandler(getActivity(), imageChooseAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case DialogPlusHandler.REQUEST_CODE_CAMERA:
                imgUri = data.getData();
                imageHandler.loadImageRound(String.valueOf(imgUri), ivAvarta);
                break;

            case DialogPlusHandler.REQUEST_CODE_GALLERY:
                imgUri = data.getData();
                imageHandler.loadImageRound(String.valueOf(imgUri), ivAvarta);
                break;

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == DialogPlusHandler.REQUEST_CODE_CAMERA){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, DialogPlusHandler.REQUEST_CODE_CAMERA);
            }
        }

    }

    @Override
    public void onClick(View view) {

        // Check if this fragment is the current fragment
        Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.content_signup);

        if (currentFragment != null && currentFragment == this) {
            switch (view.getId()) {
                case R.id.btn_next:
                    prepareData();
                    userPresenter.updateInfo(user, imgUri, this);
                    break;

                case R.id.date_picker:
                    new DatePickerDialog(getActivity(), mDate, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                    break;
            }
        }

    }

    Calendar myCalendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener mDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            myCalendar.set(Calendar.YEAR, i);
            myCalendar.set(Calendar.MONTH, i1);
            myCalendar.set(Calendar.DAY_OF_MONTH, i2);
            updateLabel();
        }
    };

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etBirthDay.setText(sdf.format(myCalendar.getTime()));
    }

    private void prepareData() {

        user.setEmail(etEmail.getText().toString());
        user.setBirthday(etBirthDay.getText().toString());
        user.setAddress(etAddress.getText().toString());

    }

    @Override
    public void uploadInfoCallBack(int errorCode) {

        if(errorCode == SupportKeys.FAILED_CODE) {
            Toast.makeText(getContext(), "Cập nhật thông tin thất bại!", Toast.LENGTH_LONG).show();
            return;
        }

        fragmentHandler.changeFragment(FragmentWelcome.newInstance(), null, 0, 0);

    }

}
