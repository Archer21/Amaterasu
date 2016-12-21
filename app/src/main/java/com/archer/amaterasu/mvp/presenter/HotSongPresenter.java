package com.archer.amaterasu.mvp.presenter;

import android.util.Log;

import com.archer.amaterasu.common.BasePresenter;
import com.archer.amaterasu.domain.Song;
import com.archer.amaterasu.mvp.interactor.HotSongInteractor;
import com.archer.amaterasu.mvp.viewmodel.HotSongsViewModel;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by archer on 20-12-16.
 */

public class HotSongPresenter extends BasePresenter {

    private WeakReference<HotSongsViewModel> mView;
    private HotSongInteractor interactor;

    public HotSongPresenter(HotSongsViewModel view) {
        mView = new WeakReference<>(view);
        interactor = new HotSongInteractor(this);
    }

    /**
     * Overrided methods from BasePresenter
     */
    @Override
    public void onStart() {
        mView.get().setupList();
        interactor.fetchHotSongs();
    }

    @Override
    public void onStop() {
        mView = null;
    }

    public void onSuccessFetchHotSongs (List<Song> fetchedSongs) {
        Log.e("HotSongPresenter", fetchedSongs.toString());
        mView.get().setupAdapter(fetchedSongs);
    }

    public void onFailureFetchHotSongs (String error) {
        mView.get().onFailSearch(error);
    }

}

































