package com.eways.etutor.Presenter;

import com.eways.etutor.Interfaces.DataCallBack;

/**
 * Created by zzzzz on 5/20/2018.
 */

public class SignInPresenter {
    private DataCallBack dataCallBack;

    public SignInPresenter(DataCallBack dataCallBack) {
        this.dataCallBack = dataCallBack;
    }

    /** Sign in */
    public void signIn(String userName, String password) {
        // Verify user with server

    }
}
