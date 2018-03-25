package com.eways.etutor.Utils.Handler;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.eways.etutor.Activity.MainActivity;
import com.eways.etutor.Fragment.LoginFragment;
import com.eways.etutor.Model.Teacher;
import com.eways.etutor.Utils.Api.ApiHandler;
import com.eways.etutor.Utils.Api.ApiUtils;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ADMIN on 3/11/2018.
 */

public class GmailHandler {

    private Activity mActivity;
    private LoginFragment loginFragment;

    SharedPreferencesHandler sharedPreferencesHandler;
    Teacher account;
    ApiHandler apiHandler;

    private static final int RC_SIGN_IN = 1 ;

    /*----- GOOGLE LOGIN -----*/
    private GoogleSignInClient mGoogleSignInClient;

    public GmailHandler(Activity mActivity, LoginFragment loginFragment) {
        this.mActivity = mActivity;
        this.loginFragment = loginFragment;

        apiHandler = ApiUtils.getUserById();

        sharedPreferencesHandler = new SharedPreferencesHandler(mActivity, LoginFragment.KEY_PRE_LOGIN);
    }

    //Configure Google Sign-in and the GoogleSignInClient object
    public void ConfigGoogleLogin() {

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(mActivity, gso);
    }

    public void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        loginFragment.startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    //Handle result of login gmail
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            Log.d("test", "handleSignInResult: ");
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            postLoginGmail(account.getId());

            Log.d("idGmail", account.getId());
//            fragmentHandler.ChangeFragment();

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);

        }
    }

    public void onStart(){
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(mActivity);
    }

    public Teacher postLoginGmail(final String id){

        apiHandler.getUserById(id).enqueue(new Callback<Teacher>() {
            @Override
            public void onResponse(Call<Teacher> call, Response<Teacher> response) {

            }

            @Override
            public void onFailure(Call<Teacher> call, Throwable t) {


            }
        });

        Log.d("test", "1");
        return account;
    }
}
