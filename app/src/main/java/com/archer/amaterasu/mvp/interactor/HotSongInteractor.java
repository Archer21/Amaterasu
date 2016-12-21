package com.archer.amaterasu.mvp.interactor;

import com.archer.amaterasu.domain.Song;
import com.archer.amaterasu.io.ApiAdapter;
import com.archer.amaterasu.io.ApiService;
import com.archer.amaterasu.io.model.SongResponse;
import com.archer.amaterasu.mvp.presenter.HotSongPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by archer on 20-12-16.
 */

public class HotSongInteractor {
    private HotSongPresenter presenter;

    public HotSongInteractor(HotSongPresenter presenter) {
        this.presenter = presenter;
    }

    public void fetchHotSongs () {
//        List<Song> songs = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Song song = new Song();
//            HashMap<Integer, String> images = new HashMap<>();
//            images.put(0, "https://lh3.googleusercontent.com/-QKucqaMK-30/AAAAAAAAAAI/AAAAAAAAIo4/f6idNlRAyc0/s0-c-k-no-ns/photo.jpg");
//            images.put(1, "https://lh3.googleusercontent.com/-QKucqaMK-30/AAAAAAAAAAI/AAAAAAAAIo4/f6idNlRAyc0/s0-c-k-no-ns/photo.jpg");
//            song.setImages(images);
//            song.setTitle("Ignite");
//            song.setArtist("Sawano Hirayuki");
//            song.setLikes(4356);
//            song.setDuration("3:40");
//            songs.add(song);
//        }
        Call<SongResponse> call = ApiAdapter.getApiService().getSongs();
        call.enqueue(new Callback<SongResponse>() {
            @Override
            public void onResponse(Call<SongResponse> call, Response<SongResponse> response) {
                if (response.isSuccessful()) {
                    presenter.onSuccessFetchHotSongs(response.body().getSongs());
                }

            }

            @Override
            public void onFailure(Call<SongResponse> call, Throwable t) {
                presenter.onFailureFetchHotSongs("CANNOT FETCH RESPONSE : " + call);
            }
        });




    }
}




















