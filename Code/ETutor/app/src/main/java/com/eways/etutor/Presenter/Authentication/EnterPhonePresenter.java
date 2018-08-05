package com.eways.etutor.Presenter.Authentication;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Model.Account.User;
import com.eways.etutor.Utils.SupportKeys;

/**
 * Created by zzzzz on 5/20/2018.
 */

public class EnterPhonePresenter implements DataCallBack {
    private DataCallBack dataCallBack;

    public EnterPhonePresenter(DataCallBack dataCallBack) {
        this.dataCallBack = dataCallBack;
    }

    /** Check phone's status on server */

    public void checkPhoneStatus(String phoneNumber) {
        User.checkPhoneNumber(phoneNumber, this);
    }

    /** Handle results from database */

    @Override
    public void dataCallBack(int resultCode, @Nullable Bundle bundle) {
        // Handle error
        if (resultCode == SupportKeys.FAILED_CODE) {
            dataCallBack.dataCallBack(resultCode, null);
            return;
        }

        // Handle data
        dataCallBack.dataCallBack(resultCode, bundle);
    }
}
