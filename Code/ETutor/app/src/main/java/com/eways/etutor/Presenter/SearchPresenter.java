package com.eways.etutor.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Model.SearchResults;
import com.eways.etutor.Utils.SupportKey;
import com.eways.etutor.Views.Activity.HomeActivity;

import java.util.ArrayList;


/**
 * Created by zzzzz on 5/22/2018.
 */

public class SearchPresenter implements DataCallBack {

    private DataCallBack dataCallBack;

    public SearchPresenter(DataCallBack dataCallBack) {
        this.dataCallBack = dataCallBack;
    }

    /** Get search results */
    public void search(String keyword, String filter) {

        // Check current type for searching
        switch (HomeActivity.currentSearchType) {
            case SupportKey.SEARCH_SUBJECTS:
                SearchResults.search(keyword, this);
                break;
            case SupportKey.SEARCH_STUDENTS:
                break;
        }
    }

    @Override
    public void dataCallBack(int resultCode, @Nullable Bundle bundle) {
        ArrayList resultsList = (ArrayList) bundle.getSerializable(null);

        if (resultsList.size() > 0) {
//            listCourse.clear();
//            for (int i = 0; i < resultsList.size(); i++) {
//
//                JsonObject jsonObject = GlobalParams.getInstance().getGSon().toJsonTree(resultsList.get(i)).getAsJsonObject();
//                listCourse.add(GlobalParams.getInstance().getGSon().fromJson(jsonObject.toString(), Course.class));
//
//            }
//            searchAdapter.notifyDataSetChanged();

        }
    }
}
