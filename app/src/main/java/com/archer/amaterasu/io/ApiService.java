package com.archer.amaterasu.io;

import com.archer.amaterasu.io.model.ArtistResponse;
import com.archer.amaterasu.io.model.SongResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET(ApiConstants.SONGS_URL)
    Call<SongResponse> getSongs();

    @GET(ApiConstants.ARTIST_URL)
    Call<ArtistResponse> getArtists();
}
