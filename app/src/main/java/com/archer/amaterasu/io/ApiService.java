package com.archer.amaterasu.io;

import com.archer.amaterasu.io.model.SongResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by archer on 20-12-16.
 */

public interface ApiService {
    @GET(ApiConstants.SONGS_URL)
    Call<SongResponse> getSongs ();
}
