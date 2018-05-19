package com.eways.etutor.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.eways.etutor.Activity.WelcomeActivity;
import com.eways.etutor.Interface.CallParentFragment;
import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
//<<<<<<< HEAD
public class SignupFragment extends Fragment implements View.OnClickListener, CallParentFragment {
//=======
//public class SignupFragment extends Fragment {
//>>>>>>> origin/master

    /** VIEWS */
    AppBarLayout barLayout;
//<<<<<<< HEAD
    TextView tvBack;
    Button btnNext;
//=======
//    public static LinearLayout btnBack, btnNext;
//    TextView tvBack, tvNext;
//>>>>>>> origin/master
    RecyclerView listCircle;
    android.support.v7.widget.Toolbar toolbar;
    NestedScrollView nestedScrollView;
    ImageView btnBack;
    FragmentVerify fragmentVerify;

    private FragmentHandler fragmentHandler;
    private int curPosition = 0;

    private ArrayList<Fragment> listFragment;

    public SignupFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_signup, container, false);

        declare_views(root);
        handle_views();
        return root;
    }

//<<<<<<< HEAD
    private void handle_views() {

        btnNext.setOnClickListener(this);
        btnBack.setOnClickListener(this);
//=======
//    private void declare_views(View root) {
//
//        barLayout = root.findViewById(R.id.appBarLayout);
//        btnBack = root.findViewById(R.id.btn_back);
//        btnNext = root.findViewById(R.id.btn_next);
//        tvBack = root.findViewById(R.id.tv_back);
//        tvNext = root.findViewById(R.id.tv_next);
//        toolbar = root.findViewById(R.id.toolbar);
//        listCircle = root.findViewById(R.id.list_circle);
//        nestedScrollView = root.findViewById(R.id.nestedScrollView);
//>>>>>>> origin/master

        //Setup Fragment Handle
//        fragmentHandler = new FragmentHandler(getActivity(), R.id.childSignUpContentView);
        fragmentHandler = new FragmentHandler(getActivity(), R.id.content_signup);
        listFragment = new ArrayList<>();
        listFragment.add(new FragmentEnterPhone());
        listFragment.add(new FragmentVerify());
        listFragment.add(new FragmentFavorite());

        //Setup Fragment Handle
//<<<<<<< HEAD
        fragmentHandler.changeFragment(listFragment.get(curPosition), 0, 0);

//        btnNext.setOnClickListener(this);
//        btnBack.setOnClickListener(this);

//        circles = new ArrayList<>();
//        circleAdapter = new CircleAdapter(getActivity(), circles);
//        listCircle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
//        listCircle.setAdapter(circleAdapter);
//=======
//        fragmentHandler.changeFragment(listFragment.get(curPosition), SupportKey.RULES_FRAGMENT_TAG, R.anim.slide_from_left, 0);
//>>>>>>> origin/master
    }

//    private void handle_views() {

//<<<<<<< HEAD
    private void declare_views(View root) {
//=======
//        circles = new ArrayList<>();
//        circleAdapter = new CircleAdapter(getActivity(), circles);
//        listCircle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
//        listCircle.setAdapter(circleAdapter);
//    }
//>>>>>>> origin/master

//        barLayout = (AppBarLayout) root.findViewById(R.id.appBarLayout);
        btnBack = root.findViewById(R.id.btn_back);
        btnNext = root.findViewById(R.id.btn_next);
//        tvBack = root.findViewById(R.id.tv_back);
//        tvNext = root.findViewById(R.id.tv_next);
//        toolbar = root.findViewById(R.id.toolbar);
//        listCircle = root.findViewById(R.id.list_circle);


    }


    //Set up parallex view
//    public void setUpParallexView(AppBarLayout appBarLayout, int mode) {
//        if (mode == listFragment.size() - 1){
//            appBarLayout.setExpanded(false, true);
//
//        }else {
//            appBarLayout.setExpanded(true, true);
//        }
//
//    }

    //check email valid
    public boolean checkEmail(String mail) {
        String[] array = mail.split("@");
        if (array[array.length - 1].compareTo(".com") == 0) {
            return true;
        }
        return false;
    }

//<<<<<<< HEAD
    @Override
    public void onClick(View view) {
//=======
//    @Override
//    public void onClick(View view) {
//>>>>>>> origin/master
//        switch (view.getId()) {
//            case R.id.btn_back:
//                if (curPosition > 0) {
//                    fragmentHandler.changeFragment(listFragment.get(curPosition - 1), R.anim.slide_from_left, 0);
//                    curPosition -= 1;
//                }
//                break;
//
//            case R.id.btn_next:
//
//                /** Need to optimize (wanna sleep) */
//                if (curPosition + 1 == 2) {
//                    fragmentHandler.changeFragment(FragmentVerify.newInstance(FragmentEnterPhone.tvPhoneNumber.getText().toString()), R.anim.slide_from_left, 0);
//                }
//
//                if (curPosition < listFragment.size() - 1) {
//                    fragmentHandler.changeFragment(listFragment.get(curPosition + 1), R.anim.slide_from_left, 0);
//                    curPosition += 1;
//                }
//                else
//                    if (curPosition == listFragment.size() - 1 ) {
//                        startActivity(new Intent(getActivity(), HomeActivity.class));
//                        getActivity().finish();
//                    }
//
//                break;
//        }
//<<<<<<< HEAD
        switch (view.getId()) {
            case R.id.btn_next:
                clickNext();
                break;

            case R.id.btn_back:
                clickBack();
                break;
        }
    }



    public void clickNext(){
        if (curPosition == listFragment.size() - 1) {
            startActivity(new Intent(getActivity(), WelcomeActivity.class));
            getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_from_left);
        } else {
            if (curPosition + 1 == 1){

//                fragmentVerify = new FragmentVerify();
//                fragmentVerify.onListenerComplete(this);
                FragmentVerify.callParentFragment = this;
                btnNext.setVisibility(View.INVISIBLE);
            }else {
                btnNext.setVisibility(View.VISIBLE);
            }
            fragmentHandler.changeFragment(listFragment.get(curPosition + 1), R.anim.slide_from_left, 0);
            curPosition++;

        }
    }
//=======
////    }
//>>>>>>> origin/master

    public void clickBack(){
        getFragmentManager().popBackStack();

        if (curPosition - 1 == 1){
            btnNext.setVisibility(View.INVISIBLE);
        }else {
            btnNext.setVisibility(View.VISIBLE);
        }

        curPosition--;
    }

    @Override
    public void callParent(boolean result) {
        if (result){
            clickNext();
        }
    }
}
