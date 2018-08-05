package com.eways.etutor.Views.Activity.Account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Presenter.Authentication.UserPresenter;
import com.eways.etutor.R;
import com.eways.etutor.Utils.ActivityUtils;
import com.eways.etutor.Utils.Handler.FragmentHandler;
import com.eways.etutor.Utils.SupportKeys;
import com.eways.etutor.Views.Activity.Course.CourseRequestManagerActivity;
import com.eways.etutor.Views.Dialog.LoadingDialog;

public class UserManagerActivity extends Activity implements View.OnClickListener, DataCallBack {
    /* VIEWS */

    ImageView avarta;
    TextView userName, userEmail;
    View btnInfo, btnMyCourse, btnCourseTutor, btnLogout, btnCourseAttend;

    FragmentHandler fragmentHandler;
    private UserPresenter userPresenter;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manager);

        declare_views();
        handle_views();
        userPresenter = new UserPresenter(this);
        loadingDialog = LoadingDialog.getInstance(this);
    }

    public void declare_views(){
        btnInfo = findViewById(R.id.btn_info);
        avarta = findViewById(R.id.avarta);
        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmail);
        btnLogout = findViewById(R.id.btn_logout);
        btnMyCourse = findViewById(R.id.btn_my_course);
        btnCourseAttend = findViewById(R.id.btn_course_attend);
    }

    public void handle_views(){
//        fragmentHandler = new FragmentHandler(getActivity(), R.id.content_course);

        btnInfo.setOnClickListener(this);
        btnMyCourse.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
        btnCourseAttend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_info:
                ActivityUtils.ChangeActivity(UserManagerActivity.this, UpdateInfoActivity.class);

                break;

            case R.id.btn_my_course:
                ActivityUtils.ChangeActivity(UserManagerActivity.this, CourseManager.class);

                break;

            case R.id.btn_course_attend:

                ActivityUtils.ChangeActivity(this, CourseRequestManagerActivity.class);
                break;

            case R.id.btn_logout:
                loadingDialog.show();
                userPresenter.signOut(this);
                break;
        }
    }

    @Override
    public void dataCallBack(int resultCode, @Nullable Bundle bundle) {

        loadingDialog.dismiss();

        if (resultCode == SupportKeys.FAILED_CODE) {
            return;
        }

        Intent signInIntent = new Intent(this, AuthenticationActivity.class);
        signInIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(signInIntent);

    }

}
