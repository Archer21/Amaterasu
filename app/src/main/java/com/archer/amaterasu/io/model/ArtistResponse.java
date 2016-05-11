package com.archer.amaterasu.io.model;

import com.archer.amaterasu.domain.Artist;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ArtistResponse {

    @SerializedName(ArtistKeys.ARTISTS_RESULTS)
    ArtistResult results;

    public void setArtists(ArrayList<Artist> artists){
        results.artists = artists;
    }

    public ArrayList<Artist> getArtists(){
        return results.artists;
    }

    public class ArtistResult {
        ArrayList<Artist> artists;
    }
}




















