package com.archer.amaterasu.mvp.presenter;

import android.util.Log;

import com.archer.amaterasu.common.BasePresenter;
import com.archer.amaterasu.domain.Song;
import com.archer.amaterasu.io.callback.SongsSearchServerCallback;
import com.archer.amaterasu.mvp.interactor.TopSongInteractor;
import com.archer.amaterasu.mvp.viewmodel.TopSongViewModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TopSongPresenter extends BasePresenter implements SongsSearchServerCallback{

    private WeakReference<TopSongViewModel> mView;
    private TopSongInteractor mInteractor;
    private boolean mIsChangingConfig;

    public TopSongPresenter(TopSongViewModel view){
        this.mView = new WeakReference<TopSongViewModel>(view);
        mInteractor = new TopSongInteractor(this);
    }

    /**
     * TopSongPresenter methods
     */
//    public void onConfigurationChanged(TopSongViewModel view){
//        mView = new WeakReference<TopSongViewModel>(view);
//    }

    public void onConfigurationChanged(){
        Log.e("TopSongPresenter", "DATA IS CURRENT LOADED");
    }

    public void onDestroy(boolean isChangingConfig){
        mView = null;
        mIsChangingConfig = isChangingConfig;
        if (!isChangingConfig){
            mInteractor.onDestroy();
        }
    }


    public void searchSongs(){
        mInteractor.performSearch();
    }


    /**
     * Override methods from BasePresenter
     */

    @Override
    public void onStart() {
        mView.get().setupList();
        mView.get().setupAdapter();
    }


    @Override
    public void onStop() {

    }


    /**
     * ViewModel methods
     */



    @Override
    public void onSongsFound(ArrayList<Song> songs) {
        mView.get().displayFoundSongs(songs);
    }

    @Override
    public void onFailedSearch() {
        mView.get().displayFailedSearch();
    }

    @Override
    public void onNetworkError() {
        mView.get().displayNetworkError();
    }

    @Override
    public void onServerError() {
        mView.get().displayServerError();
    }
}
