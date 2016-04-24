package com.archer.amaterasu.mvp.interactor;

import com.archer.amaterasu.io.ApiAdapter;
import com.archer.amaterasu.io.callback.SongsSearchServerCallback;
import com.archer.amaterasu.io.model.SongResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopSongInteractor {

    SongsSearchServerCallback mCallback;

    public TopSongInteractor(SongsSearchServerCallback callback){
        mCallback = callback;
    }

    public void performSearch(){
        final Call<SongResponse> call = ApiAdapter.getApiService().getSongs();
        call.enqueue(new Callback<SongResponse>() {
            @Override
            public void onResponse(Response<SongResponse> response) {
                if (response.body().getSongs().isEmpty())
                    mCallback.onFailedSearch();

                else
                    mCallback.onSongsFound(response.body().getSongs());
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void onDestroy(){

    }
}
