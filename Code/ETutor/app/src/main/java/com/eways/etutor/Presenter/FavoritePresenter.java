package com.eways.etutor.Presenter;

import android.content.Context;
import android.util.Log;

import com.eways.etutor.Interfaces.DataCallback.Subject.FavSubjectWithCoursesCallBack;
import com.eways.etutor.Model.Account.User;
import com.eways.etutor.Model.Subject.Subject;
import com.eways.etutor.Network.Subject.SubjectListCallBack;
import com.eways.etutor.Utils.SharedPreferences.SharedPrefSupportKeys;
import com.eways.etutor.Utils.SharedPreferences.SharedPrefUtils;
import com.eways.etutor.Utils.SupportKeys;

import java.util.ArrayList;

/**
 * Created by zzzzz on 6/17/2018.
 */

public class FavoritePresenter implements FavSubjectWithCoursesCallBack, SubjectListCallBack {
    private Context context;
    private SharedPrefUtils sharedPrefUtils;
    private SubjectListCallBack subjectListCallBack;
    private FavSubjectWithCoursesCallBack favSubjectWithCoursesCallBack;

    public FavoritePresenter(Context context) {
        this.context = context;
        sharedPrefUtils = new SharedPrefUtils(context, SharedPrefSupportKeys.SHARED_PREF_FILE_NAME);
    }

    /** Get subject list */

    public void getSubjectList(SubjectListCallBack subjectListCallBack) {

        this.subjectListCallBack = subjectListCallBack;

        Subject.getSubjectList(this);

    }

    /** Add favorite */
    public void addFavorite(ArrayList<String> listFavorite, FavSubjectWithCoursesCallBack favSubjectWithCoursesCallBack) {

        //User.addFavorite(sharedPrefUtils.getString(SharedPrefSupportKeys.UID), listFavorite, this);

    }

    @Override
    public void favSubjectsCourseCallBack(int errorCode, ArrayList result) {

        if (errorCode == SupportKeys.FAILED_CODE) {
            favSubjectWithCoursesCallBack.favSubjectsCourseCallBack(SupportKeys.FAILED_CODE, null);
            return;
        }

        // Handle data
        favSubjectWithCoursesCallBack.favSubjectsCourseCallBack(SupportKeys.SUCCESS_CODE, null);

    }

    @Override
    public void subjectListCallBack(int errorCode, ArrayList<Subject> subjects) {

        if (errorCode == SupportKeys.FAILED_CODE) {
            Log.d("FavoritePresenter:", "Failed");
            subjectListCallBack.subjectListCallBack(errorCode, null);
            return;
        }

        subjectListCallBack.subjectListCallBack(errorCode, subjects);

    }

}
