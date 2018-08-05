package com.eways.etutor.Presenter;

import android.content.Context;

import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Interfaces.DataCallback.SearchSuggestion.SearchSuggestionCallBack;
import com.eways.etutor.Interfaces.DataCallback.Subject.FavSubjectWithCoursesCallBack;
import com.eways.etutor.Interfaces.DataCallback.Subject.TrendingSubjectCallBack;
import com.eways.etutor.Interfaces.DataCallback.User.TopTutorsCallBack;
import com.eways.etutor.Utils.SharedPreferences.SharedPrefSupportKeys;
import com.eways.etutor.Utils.SharedPreferences.SharedPrefUtils;

/**
 * Created by ADMIN on 5/20/2018.
 */

public class HomePresenter {

    private DataCallBack dataCallBack;
    private SearchSuggestionCallBack searchSuggestionCallBack;
    private SharedPrefUtils sharedPrefUtils;

    /** For home fragment */
    public HomePresenter(Context context) {
        sharedPrefUtils = new SharedPrefUtils(context, SharedPrefSupportKeys.SHARED_PREF_FILE_NAME);
    }

    /** For home activity */
    public HomePresenter(Context context, SearchSuggestionCallBack searchSuggestionCallBack) {
        this.searchSuggestionCallBack = searchSuggestionCallBack;
        sharedPrefUtils = new SharedPrefUtils(context, SharedPrefSupportKeys.SHARED_PREF_FILE_NAME);
    }


    /**
     *  MARK: - HANDLE DATA FROM SERVER
     *  */

}
