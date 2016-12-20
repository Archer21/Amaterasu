package com.archer.amaterasu.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by alanaliaga on 15/12/16.
 */

public abstract class BaseFragment extends Fragment {

    protected Context CONTEXT;
    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CONTEXT = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbindViews();
    }

    /**
     * Fragment lifecycle methods for BasePresenter
     * onStart and onStop
     */
    @Override
    public void onStart() {
        super.onStart();
        if (getPresenter() != null) {
            Log.e("BasePresenter", "STARTED PRESENTER");
            getPresenter().onStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }

    /**
     * Methods available for all fragments
     */
    private void bindViews (View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
    }

    private void unbindViews () {
        unbinder.unbind();
    }

    /**
     * Abstract methods that all Fragments must override
     */
    public abstract int getFragmentLayout();
    public abstract BasePresenter getPresenter ();
}































