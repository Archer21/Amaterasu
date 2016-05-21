package com.archer.amaterasu.common;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import io.realm.Realm;

public abstract class BaseFragment extends Fragment{
    protected Context CONTEXT;
    private Realm realm;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        CONTEXT = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        realm = Realm.getDefaultInstance();
        if (getPresenter() != null){
            getPresenter().onStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        realm.close();
        if (getPresenter() != null){
            getPresenter().onStop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbindViews();

    }

    public Realm getRealm() {
        return realm;
    }

    protected abstract int getFragmentLayout();

    /**
     * @return The presenter attached to the fragment. This must extends from {@link BasePresenter}
     * */
    protected abstract BasePresenter getPresenter();

    /**
     * Replace all the annotated fields with ButterKnife annotations with the proper value
     * */
    private void bindViews(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    private void unbindViews() {
        ButterKnife.unbind(this);
    }
}
